package com.travellerybe.travel.command.application;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.travellerybe.like.command.domain.Likes;
import com.travellerybe.like.query.repository.LikesRepository;
import com.travellerybe.travel.command.domain.*;
import com.travellerybe.travel.exception.TravelException;
import com.travellerybe.travel.query.dto.request.PictureDto;
import com.travellerybe.travel.query.dto.request.RegisterLocationGroupDto;
import com.travellerybe.travel.query.dto.request.RegisterTravelDto;
import com.travellerybe.travel.query.dto.response.PictureResDto;
import com.travellerybe.travel.query.dto.response.RegisterTravelResDto;
import com.travellerybe.travel.query.dto.response.TravelResDto;
import com.travellerybe.travel.query.repository.*;
import com.travellerybe.user.command.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.travellerybe.travel.exception.TravelExceptionType.NOT_FOUND_TRAVEL;
import static com.travellerybe.travel.exception.TravelExceptionType.S3_UPLOAD_FAILED;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class TravelService {
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final DestinationRepository destinationRepository;
    private final LikesRepository likesRepository;
    private final TagRepository tagsRepository;
    private final PictureRepository pictureRepository;
    private final LocationGroupRepository locationGroupRepository;
    private final TravelRepository travelRepository;
    private final AmazonS3Client amazonS3Client;

    @Transactional
    public List<String> uploadGroupByLocation(MultipartFile[] files) {
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
            throw new TravelException(S3_UPLOAD_FAILED);
        }
    }

    @Transactional
    public RegisterTravelResDto registerTravel(RegisterTravelDto registerTravelDto, User user) {

        Set<Tag> tags = registerTravelDto.tags().stream().map(tagName ->
                tagsRepository.save(Tag.builder()
                        .name(tagName)
                        .build()
                )).collect(Collectors.toSet());

        Optional<Destination> existingDestination = destinationRepository.findByName(registerTravelDto.destination());

        Destination destination = existingDestination.orElseGet(() ->
                destinationRepository.save(Destination.builder()
                        .name(registerTravelDto.destination())
                        .build())
        );

        Travel travel = Travel.builder()
                .title(registerTravelDto.title())
                .thumbnail(registerTravelDto.thumbnail())
                .user(user)
                .tags(tags)
                .destination(destination)
                .build();

        travelRepository.save(travel);

        return new RegisterTravelResDto(travel.getId());
    }

    @Transactional
    public void registerLocationGroup(RegisterLocationGroupDto registerLocationGroupDto, User user) {
        Travel travel = travelRepository.findById(registerLocationGroupDto.travelId())
                .orElseThrow(() -> new TravelException(NOT_FOUND_TRAVEL));

        LocationGroup locationGroup = locationGroupRepository.save(registerLocationGroupDto.toEntityWithTravel(travel));

        List<PictureDto> picturesDto = registerLocationGroupDto.locationGroup().pictures();
        List<Picture> pictures = picturesDto.stream().map(picture ->
                picture.toEntityWithUserAndLocationGroup(user, locationGroup)).toList();

        pictureRepository.saveAll(pictures);
    }

    public List<TravelResDto> getTravelFeed(Pageable pageable, User user) {
        Page<Travel> travels = travelRepository.findAll(pageable);

        return travels.stream().map(travel ->
                TravelResDto.fromTravel(travel, likesRepository.existsByUserAndTravel(user, travel))).toList();
    }

    public List<TravelResDto> getTravelFeed(Pageable pageable) {
        Page<Travel> travels = travelRepository.findAll(pageable);

        return travels.stream().map(travel ->
                TravelResDto.fromTravel(travel, false)).toList();
    }

    public List<TravelResDto> getUserTravels(User user, Pageable pageable) {
        List<Travel> travels = travelRepository.findAllByUser(user, pageable).getContent();
        return travels.stream().map(travel -> TravelResDto.fromTravel(travel, null)).toList();
    }

    public List<TravelResDto> getUserLikesTravel(User user, Pageable pageable) {
        List<Likes> likesList = likesRepository.getAllByUser(user, pageable).getContent();

        return likesList.stream().map(likes -> TravelResDto.fromTravel(likes.getTravel(), true)).toList();
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

    public List<LocationGroup> getTravelDetails(Long travelId) {
        return locationGroupRepository.findAllByTravelId(travelId);
    }
}
