package com.driver.bookMyShow.Services;

import com.driver.bookMyShow.Dtos.RequestDtos.ScreenRequestDto;
import com.driver.bookMyShow.Dtos.RequestDtos.TheaterRequestDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.ScreenResponseDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.TheaterResponseDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.TheaterReturnDto;
import com.driver.bookMyShow.Exceptions.*;
import com.driver.bookMyShow.Models.Facility;
import com.driver.bookMyShow.Models.TheaterFacility;
import com.driver.bookMyShow.Models.Theater;
import com.driver.bookMyShow.Repositories.FacilityRepository;
import com.driver.bookMyShow.Repositories.TheaterFacilityRepository;
import com.driver.bookMyShow.Repositories.TheaterRepository;
import com.driver.bookMyShow.Transformers.TheaterTransformer;
import com.driver.bookMyShow.constant.Messages;
import com.driver.bookMyShow.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    private TheaterFacilityRepository theaterFacilityRepository;
    @Autowired
    private ScreenService screenService;
    @Autowired
    private TheaterFacilityService theaterFacilityService;

    public TheaterResponseDto addTheaterV1Service(TheaterRequestDto theaterRequestDto) {
        theaterRequestDto.validate();
        if (theaterRepository.existsByAddress(theaterRequestDto.getAddress()))
            throw new AlreadyPresentException(Messages.THEATER + Messages.ONE_TAB + Messages.ALREADY_PRESENT);
        List<String> facilityList = theaterRequestDto.getFacilityList();
        List<Facility> facilityEntities = facilityList.stream()
                .distinct()
                .map(single -> facilityRepository.findById(single).orElseThrow(() -> new NotFoundExecption(Messages.FACILITY + Messages.ONE_TAB + Messages.NOT_FOUND))
                )
                .toList();
        Theater theater = TheaterTransformer.TheaterV1EntryDtoToTheaterV1(theaterRequestDto);
        theater.setId(Utils.generateUUID(10));
        theater.setCreatedAt(LocalDateTime.now());
        Theater theaterV11 = theaterRepository.save(theater);

        //ye pe call ho rha theather facility
        List<TheaterFacility> theaterFacilities = facilityEntities.stream()
                .map(facility -> TheaterFacility.builder()
                        .id(Utils.generateUUID(10))
                        .theater(theaterV11)
                        .facility(facility)
                        .isActive(true)
                        .deleted(false)
                        .build())
                .collect(Collectors.toList());
        theaterFacilityRepository.saveAll(theaterFacilities);
        theaterV11.setTheaterFacilities(theaterFacilities);
        return TheaterTransformer.ThearteV1ToReturnThaterV1Dto(theaterV11);
    }

    @Transactional
    public TheaterResponseDto updateTheaterById(String theaterId, TheaterRequestDto theaterRequestDto) {
        theaterRequestDto.validate();
        Theater theater = theaterRepository.findById(theaterId).orElseThrow(() ->
                new NotFoundExecption(Messages.THEATER + Messages.ONE_TAB + Messages.NOT_FOUND));
        if (!theater.getAddress().equalsIgnoreCase(theaterRequestDto.getAddress())) {
            if (theaterRepository.existsByAddress(theaterRequestDto.getAddress()))
                throw new AlreadyPresentException(Messages.THEATER + Messages.ONE_TAB + Messages.ALREADY_PRESENT);
        }
        //deleted facility that are alred exist
        theaterFacilityRepository.deleteByTheater(theater);
        //check dulipcate
        List<String> facilityList = theaterRequestDto.getFacilityList();
        List<Facility> facilityEntities = facilityList.stream()
                .distinct()
                .map(single -> facilityRepository.findById(single)
                        .orElseThrow(() -> new NotFoundExecption(Messages.FACILITY + Messages.ONE_TAB + Messages.NOT_FOUND))
                )
                .toList();
        theater.setName(theaterRequestDto.getName());
        theater.setAddress(theaterRequestDto.getAddress());
        theaterRepository.save(theater);
        //facility add
        List<TheaterFacility> theaterFacilities = facilityEntities.stream()
                .map(facility -> TheaterFacility.builder()
                        .id(Utils.generateUUID(10))
                        .theater(theater)
                        .facility(facility)
                        .isActive(true)
                        .deleted(false)
                        .build())
                .collect(Collectors.toList());
        theaterFacilityRepository.saveAll(theaterFacilities);
        theater.setTheaterFacilities(theaterFacilities);


        return TheaterTransformer.ThearteV1ToReturnThaterV1Dto(theaterRepository.save(theater));


    }

    public List<TheaterResponseDto> gellAllApi() {
        List<Theater> theaters = theaterRepository.findAll();
        if (theaters.isEmpty()) {
            throw new NotFoundExecption(Messages.THEATER+Messages.ONE_TAB+Messages.NOT_FOUND);
        }
        return theaters.stream().map(TheaterTransformer::ThearteV1ToReturnThaterV1Dto).collect(Collectors.toList());
    }

    public TheaterResponseDto getTheaterById(String theaterId) {
        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(() ->
                new NotFoundExecption(Messages.THEATER + Messages.ONE_TAB + Messages.NOT_FOUND));
        return TheaterTransformer.ThearteV1ToReturnThaterV1Dto(theater);

    }
    public TheaterReturnDto toggleTheaterFacility(String theaterID, String facilityId) {
        Theater theater = theaterRepository.findById(theaterID).orElseThrow(() ->
                new NotFoundExecption(Messages.THEATER + Messages.ONE_TAB + Messages.NOT_FOUND));
        Facility facility = facilityRepository.findById(facilityId).orElseThrow(() ->
                new NotFoundExecption(Messages.FACILITY + Messages.ONE_TAB + Messages.NOT_FOUND));
        return theaterFacilityService.toggelForTheater(theater.getId(), facility.getId());
    }
    public TheaterResponseDto addFacilityByTheater(String theaterId, String facilityId) {
        Theater theater = theaterRepository.findById(theaterId).orElseThrow(() ->
                new NotFoundExecption(Messages.THEATER + Messages.ONE_TAB + Messages.NOT_FOUND));
        facilityRepository.findById(facilityId).orElseThrow(() ->
                new NotFoundExecption(Messages.FACILITY + Messages.ONE_TAB + Messages.NOT_FOUND));
        theaterFacilityService.addFacilityOnTheater(theaterId, facilityId);
        return TheaterTransformer.ThearteV1ToReturnThaterV1Dto(theater);

    }
    public ScreenResponseDto addScreenById(String theaterId, ScreenRequestDto screenRequestDto) {
        return screenService.addScreenById(theaterId, screenRequestDto);
    }

    public List<ScreenResponseDto> getAllScreenOfTheater(String theaterId) {
        return screenService.getAllScreenOfTheater(theaterId);
    }

    public ScreenResponseDto getScreenById(String screenId) {
        return screenService.getScreenById(screenId);
    }

    public String deletedById(String screenId) {
        return screenService.deletedById(screenId);
    }



}
