package com.travellerybe.picture.command.application;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.travellerybe.picture.command.domain.Picture;
import com.travellerybe.picture.exception.PictureException;
import com.travellerybe.travel.exception.TravelException;
import com.travellerybe.picture.query.dto.response.PictureResDto;
import com.travellerybe.picture.query.repository.PictureRepository;
import com.travellerybe.user.command.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static com.travellerybe.picture.exception.PictureExceptionType.S3_UPLOAD_FAILED;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class PictureService {
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final PictureRepository pictureRepository;
    private final AmazonS3Client amazonS3Client;

    public List<String> uploadGroupByLocationPictures(MultipartFile[] files) {
        List<String> fileUrls = new ArrayList<>();

        try {
            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                ObjectMetadata metadata = new ObjectMetadata();

                metadata.setContentType(file.getContentType());
                metadata.setContentLength(file.getSize());
                amazonS3Client.putObject(bucket, fileName, file.getInputStream(), metadata);
                fileUrls.add(URLDecoder.decode(amazonS3Client.getUrl(bucket, fileName).toString(), StandardCharsets.UTF_8));
                log.info(URLDecoder.decode(amazonS3Client.getUrl(bucket, fileName).toString(), StandardCharsets.UTF_8));
            }

            return fileUrls;
        } catch (Exception e) {
            throw new PictureException(S3_UPLOAD_FAILED);
        }
    }

    public List<PictureResDto> getUserPictures(User user, Pageable pageable) {
        List<Picture> pictures = pictureRepository.findAllByUser(user, pageable).getContent();
        return pictures.stream().map(picture -> new PictureResDto(
                picture.getId(),
                picture.getPath(),
                picture.getDate(),
                picture.getName(),
                picture.getMime())).toList();
    }
}
