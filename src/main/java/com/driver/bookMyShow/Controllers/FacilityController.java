package com.driver.bookMyShow.Controllers;

import com.driver.bookMyShow.Dtos.RequestDtos.FacilityRequestDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.FacilityResponseDto;
import com.driver.bookMyShow.ResponseAPI.ResonponseAPI;
import com.driver.bookMyShow.Services.FacilityService;
import com.driver.bookMyShow.constant.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private FacilityService facilityService;

    @PostMapping
    public ResponseEntity<ResonponseAPI<FacilityResponseDto>> addFacilityByTheaterId(@RequestBody FacilityRequestDto facilityRequestDto) {
        FacilityResponseDto facilityResponseDto = facilityService.addFacilityv1(facilityRequestDto);
        ResonponseAPI<FacilityResponseDto> resonponseAPI = ResonponseAPI.<FacilityResponseDto>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.CREATED.value())
                .data(facilityResponseDto)
                .build();
        return new ResponseEntity<>(resonponseAPI, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<ResonponseAPI<List<FacilityResponseDto>>> getAllFacility() {
        List<FacilityResponseDto> facilityResponseDtos = facilityService.getAllFacilityv1();
        ResonponseAPI<List<FacilityResponseDto>> resonponseAPI = ResonponseAPI.<List<FacilityResponseDto>>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(facilityResponseDtos)
                .build();
        return new ResponseEntity<>(resonponseAPI, HttpStatus.OK);

    }

    @PutMapping("/{facilityId}")
    public ResponseEntity<ResonponseAPI<FacilityResponseDto>> updateFacility(@PathVariable String facilityId, @RequestBody FacilityRequestDto facilityRequestDto) {
        FacilityResponseDto facilityResponseDto = facilityService.updateFacilityv1(facilityId, facilityRequestDto);
        ResonponseAPI<FacilityResponseDto> resonponseAPI = ResonponseAPI.<FacilityResponseDto>builder()
                .message(Messages.UPDATE)
                .status(HttpStatus.OK.value())
                .data(facilityResponseDto)
                .build();
        return new ResponseEntity<>(resonponseAPI, HttpStatus.OK);
    }

    @DeleteMapping("/{facilityId}")
    public ResponseEntity<ResonponseAPI<String>> deleteFacilityById(@PathVariable String facilityId) {
        String str = facilityService.deleteFacilityv1(facilityId);
        ResonponseAPI<String> resonponseAPI = ResonponseAPI.<String>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(str)
                .build();
        return new ResponseEntity<>(resonponseAPI, HttpStatus.OK);
    }

    @PatchMapping("/{facilityId}")
    public ResponseEntity<ResonponseAPI<String>> updateDefaults(@PathVariable String facilityId) {
        String str = facilityService.updateDefaultv1(facilityId);
        ResonponseAPI<String> resonponseAPI = ResonponseAPI.<String>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(str)
                .build();
        return new ResponseEntity<>(resonponseAPI, HttpStatus.OK);
    }

    @GetMapping("/{facilityId}")
    public ResponseEntity<ResonponseAPI<FacilityResponseDto>> getFacilityById(@PathVariable String facilityId) {
        FacilityResponseDto facilityResponseDto = facilityService.getFacilityByIdv1(facilityId);
        ResonponseAPI<FacilityResponseDto> resonponseAPI = ResonponseAPI.<FacilityResponseDto>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(facilityResponseDto)
                .build();
        return new ResponseEntity<>(resonponseAPI, HttpStatus.OK);
    }


}
