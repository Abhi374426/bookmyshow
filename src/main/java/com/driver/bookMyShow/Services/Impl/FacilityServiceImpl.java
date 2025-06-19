package com.driver.bookMyShow.Services.Impl;

import com.driver.bookMyShow.Dtos.RequestDtos.FacilityRequestDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.FacilityResponseDto;
import com.driver.bookMyShow.Exceptions.AlreadyPresentException;
import com.driver.bookMyShow.Exceptions.NotFoundExecption;
import com.driver.bookMyShow.Models.Facility;
import com.driver.bookMyShow.Models.TheaterFacility;
import com.driver.bookMyShow.Repositories.FacilityRepository;
import com.driver.bookMyShow.Repositories.TheaterFacilityRepository;
import com.driver.bookMyShow.Repositories.TheaterRepository;
import com.driver.bookMyShow.Services.FacilityService;
import com.driver.bookMyShow.Transformers.FacitityDtoToFacility;
import com.driver.bookMyShow.constant.Messages;
import com.driver.bookMyShow.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacilityServiceImpl implements FacilityService {
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    private TheaterFacilityRepository theaterFacilityRepository;

    @Override
    public FacilityResponseDto addFacilityv1(FacilityRequestDto facilityRequestDto) {
        facilityRequestDto.validate();
        facilityRepository.findByFacility(facilityRequestDto.getFacility()).ifPresent(facility -> {
            throw new AlreadyPresentException(Messages.FACILITY + Messages.ONE_TAB + Messages.ALREADY_PRESENT);
        });
        Facility newFacility = FacitityDtoToFacility.facilityDtoToFacilityv1(facilityRequestDto);
        newFacility.setId(Utils.generateUUID(10));
        return FacitityDtoToFacility.facilityToReturnDtov1(facilityRepository.save(newFacility));
    }

    @Override
    public List<FacilityResponseDto> getAllFacilityv1() {
        List<Facility> facilities = facilityRepository.findAll();
        if (facilities.isEmpty())

            throw new NotFoundExecption(Messages.FACILITY + Messages.ONE_TAB + Messages.NOT_FOUND);
        return facilities.stream().map(FacitityDtoToFacility::facilityToReturnDtov1).collect(Collectors.toList());
    }

    @Override
    public FacilityResponseDto updateFacilityv1(String facilityId, FacilityRequestDto facilityRequestDto) {
        Facility facility = facilityRepository.findById(facilityId)
                .orElseThrow(() -> new NotFoundExecption(Messages.FACILITY + Messages.ONE_TAB + Messages.NOT_FOUND));
        facilityRepository.findByFacility(facilityRequestDto.getFacility()).ifPresent(existing -> {
            if (!existing.getId().equals(facilityId))
                throw new AlreadyPresentException(Messages.FACILITY + Messages.ONE_TAB + Messages.ALREADY_PRESENT);
        });
        System.out.println("gf");
        facility.setFacility(facilityRequestDto.getFacility());
        facility.setLogo(facilityRequestDto.getFacility());
        return FacitityDtoToFacility.facilityToReturnDtov1(facilityRepository.save(facility));
    }

    @Override
    public String deleteFacilityv1(String facilityId) {
        Facility facility = facilityRepository.findById(facilityId).orElseThrow(
                () -> new NotFoundExecption(Messages.FACILITY + Messages.ONE_TAB + Messages.NOT_FOUND));
        facilityRepository.deleteById(facilityId);
        List<TheaterFacility> theaterFacilities = theaterFacilityRepository.findByFacility_Id(facilityId);
        theaterFacilities.stream().forEach(facility1 -> {
           theaterFacilityRepository.deleteById(facility1.getId());
        });


        return Messages.SUCCESS;
    }

    @Override
    public String updateDefaultv1(String facilityId) {
        Facility facility = facilityRepository.findById(facilityId).orElseThrow(
                () -> new NotFoundExecption(Messages.FACILITY + Messages.ONE_TAB + Messages.NOT_FOUND));
        facility.setIsActive(!facility.getIsActive());
        boolean stauts=facility.getIsActive();
        facilityRepository.save(facility);
        List<TheaterFacility> theaterFacilities = theaterFacilityRepository.findByFacility_Id(facilityId);
        theaterFacilities.stream().forEach(facility1 -> {
                    facility1.setIsActive(stauts);
                }
        );
        theaterFacilityRepository.saveAll(theaterFacilities);
        return Messages.UPDATE;
    }

    @Override
    public FacilityResponseDto getFacilityByIdv1(String facilityId) {
        Facility facility = facilityRepository.findById(facilityId).orElseThrow(
                () -> new NotFoundExecption(Messages.FACILITY + Messages.ONE_TAB + Messages.NOT_FOUND));
//        if (facility.getDeleted()) {
//            throw new RequestFailedException(Messages.FACILITY + Messages.ONE_TAB + "is deleted and cannot be viewed.");
//        }
        return FacitityDtoToFacility.facilityToReturnDtov1(facility);

    }
}