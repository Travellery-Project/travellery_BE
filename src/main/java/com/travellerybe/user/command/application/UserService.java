package com.travellerybe.user.command.application;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.travellerybe.picture.exception.PictureException;
import com.travellerybe.picture.query.repository.PictureRepository;
import com.travellerybe.travel.repository.TravelRepository;
import com.travellerybe.user.command.domain.User;
import com.travellerybe.user.command.dto.domain.UserDto;
import com.travellerybe.user.command.dto.domain.mapper.UserMapper;
import com.travellerybe.user.exception.AuthException;
import com.travellerybe.user.command.dto.domain.ProfileDto;
import com.travellerybe.user.command.dto.request.ModifyProfileReqDto;
import com.travellerybe.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static com.travellerybe.picture.exception.PictureExceptionType.S3_UPLOAD_FAILED;
import static com.travellerybe.user.exception.AuthExceptionType.DUPLICATED_USERNAME;
import static com.travellerybe.user.exception.AuthExceptionType.NOT_FOUND_MEMBER;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final PictureRepository pictureRepository;
    private final TravelRepository travelRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AmazonS3Client amazonS3Client;

    public ProfileDto getUserProfile(User user) {
        int travelCount = travelRepository.countByUser(user);
        int pictureCount = pictureRepository.countByUser(user);

        return userMapper.toProfileDto(user, travelCount, pictureCount);
    }

    @Transactional
    public void modifyUserPicture(User user, MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            ObjectMetadata metadata = new ObjectMetadata();

            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());
            amazonS3Client.putObject(bucket, fileName, file.getInputStream(), metadata);
            String picturePath = URLDecoder.decode(amazonS3Client.getUrl(bucket, fileName).toString(), StandardCharsets.UTF_8);

            userRepository.updatePicture(user.getId(), picturePath);

        } catch (Exception e) {
            throw new PictureException(S3_UPLOAD_FAILED);
        }
    }

    @Transactional
    public UserDto modifyUserProfile(User user, ModifyProfileReqDto modifyProfileReqDto) {
        if (!Objects.equals(user.getUsername(), modifyProfileReqDto.username())) {
            validateUsername(modifyProfileReqDto.username());
        }
        userRepository.updateUserProfile(user.getId(), modifyProfileReqDto.description(),
                modifyProfileReqDto.username());
        User updatedUser = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new AuthException(NOT_FOUND_MEMBER));

        return userMapper.toUserDto(updatedUser);
    }

    private void validateUsername(String username) {
        if (userRepository.existsByUsername(username)) {
            throw new AuthException(DUPLICATED_USERNAME);
        }
    }
}
