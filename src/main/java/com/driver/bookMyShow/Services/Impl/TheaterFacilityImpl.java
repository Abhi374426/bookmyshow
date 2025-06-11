package com.driver.bookMyShow.Services.Impl;

import com.driver.bookMyShow.Dtos.RequestDtos.ScreenRequestDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.ScreenResponseDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.TheaterReturnDto;
import com.driver.bookMyShow.Exceptions.AlreadyPresentException;
import com.driver.bookMyShow.Exceptions.NotFoundExecption;
import com.driver.bookMyShow.Exceptions.RequestFailedException;
import com.driver.bookMyShow.Models.*;

import com.driver.bookMyShow.Repositories.FacilityRepository;
import com.driver.bookMyShow.Repositories.ScreenRepository;
import com.driver.bookMyShow.Repositories.TheaterFacilityRepository;
import com.driver.bookMyShow.Repositories.TheaterRepository;
import com.driver.bookMyShow.Services.ScreenService;
import com.driver.bookMyShow.Services.TheaterFacilityService;
import com.driver.bookMyShow.Transformers.TheaterFacilityTransformer;
import com.driver.bookMyShow.constant.Messages;
import com.driver.bookMyShow.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterFacilityImpl implements TheaterFacilityService {
    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterFacilityRepository theaterFacilityRepository;
    @Autowired
    private ScreenService screenService;
    @Autowired
    private FacilityRepository facilityRepository;

    public List<TheaterFacility> addFacilityToTheater(String theaterId, List<Facility> facilities) {
        Theater theater = theaterRepository.findById(theaterId).orElseThrow(() ->
                new NotFoundExecption(Messages.THEATER + Messages.ONE_TAB + Messages.NOT_FOUND));
        for (Facility facility : facilities) {
            TheaterFacility theaterFacility = TheaterFacility.builder()
                    .id(Utils.generateUUID(10))
                    .theater(theater)
                    .facility(facility)
                    .isActive(true)
                    .deleted(false)
                    .build();
            theaterFacilityRepository.save(theaterFacility);
        }
        List<TheaterFacility> theaterFacilities = theater.getTheaterFacilities();
        System.out.println("this is facility inside the theafacility method -----" + theaterFacilities);
        return theaterFacilities;
    }

    public TheaterReturnDto toggelForTheater(String theaterId, String Facility) {
        TheaterFacility facility = theaterFacilityRepository.findByTheater_IdAndFacility_Id(theaterId, Facility).orElseThrow(() ->
                new NotFoundExecption(Messages.THEATER + Messages.ONE_TAB + Messages.AND + Messages.FACILITY + Messages.MATCHS + Messages.NOT_FOUND));
        com.driver.bookMyShow.Models.Facility facility1 = facilityRepository.findById(Facility)
                .orElseThrow(() -> new NotFoundExecption(Messages.FACILITY + Messages.ONE_TAB + Messages.NOT_FOUND));
        if (!facility1.getIsActive()) {
            throw new RequestFailedException("Facility is not provided by bookmyshow");
        }
        facility.setIsActive(!facility.getIsActive());
        return TheaterFacilityTransformer.TheaterFacilityToDto(theaterFacilityRepository.save(facility));

    }

    @Override
    public void addFacilityOnTheater(String theaterId, String facilityId) {
        Optional<TheaterFacility> existingFacility = theaterFacilityRepository
                .findByTheater_IdAndFacility_Id(theaterId, facilityId);

        if (existingFacility.isPresent()) {
            throw new AlreadyPresentException(
                    Messages.FACILITY + Messages.ONE_TAB + Messages.ALREADY_PRESENT + " for " + Messages.THEATER
            );
        }
        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(() -> new NotFoundExecption(Messages.THEATER + Messages.ONE_TAB + Messages.NOT_FOUND));

        Facility facility = facilityRepository.findById(facilityId)
                .orElseThrow(() -> new NotFoundExecption(Messages.FACILITY + Messages.ONE_TAB + Messages.NOT_FOUND));
        TheaterFacility theaterFacility = TheaterFacility.builder()
                .id(Utils.generateUUID(10)) // Optional if you're setting custom IDs
                .theater(theater)
                .facility(facility)
                .isActive(true)
                .deleted(false)
                .build();
        theaterFacilityRepository.save(theaterFacility);
    }




}
