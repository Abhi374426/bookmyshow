package com.driver.bookMyShow.Controllers;

import com.driver.bookMyShow.Dtos.RequestDtos.ScreenRequestDto;
import com.driver.bookMyShow.Dtos.RequestDtos.TheaterRequestDto;
//import com.driver.bookMyShow.Dtos.ResponseDtos.ReturnShowSeatV1Dto;
import com.driver.bookMyShow.Dtos.ResponseDtos.ScreenResponseDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.TheaterResponseDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.TheaterReturnDto;
import com.driver.bookMyShow.ResponseAPI.ResonponseAPI;
import com.driver.bookMyShow.Services.TheaterService;
import com.driver.bookMyShow.constant.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater/v1")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping
    public ResponseEntity<ResonponseAPI<TheaterResponseDto>> addTheater(@RequestBody TheaterRequestDto theaterRequestDto) {
        TheaterResponseDto theaterV1Dto = theaterService.addTheaterV1Service(theaterRequestDto);
        ResonponseAPI<TheaterResponseDto> resonponseAPI = ResonponseAPI.<TheaterResponseDto>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.CREATED.value())
                .data(theaterV1Dto)
                .build();
        return new ResponseEntity<>(resonponseAPI, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<ResonponseAPI<List<TheaterResponseDto>>> getALlData() {
        List<TheaterResponseDto> theaterResponseDtos = theaterService.gellAllApi();
        ResonponseAPI<List<TheaterResponseDto>> resonponseAPI = ResonponseAPI.<List<TheaterResponseDto>>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(theaterResponseDtos)
                .build();
        return new ResponseEntity<>(resonponseAPI, HttpStatus.OK);
    }

    @GetMapping("/{theaterId}")
    public ResponseEntity<ResonponseAPI<TheaterResponseDto>> getTheaterById(@PathVariable String theaterId) {
        TheaterResponseDto theaterResponseDto = theaterService.getTheaterById(theaterId);
        ResonponseAPI<TheaterResponseDto> resonponseAPI = ResonponseAPI.<TheaterResponseDto>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(theaterResponseDto)
                .build();
        return new ResponseEntity<>(resonponseAPI, HttpStatus.OK);
    }

    @PatchMapping("/{theaterId}/{facilityId}")
    public ResponseEntity<ResonponseAPI<TheaterReturnDto>> toggelForTheater(@PathVariable String theaterId, @PathVariable String facilityId) {
        TheaterReturnDto theaterReturnDto = theaterService.toggleTheaterFacility(theaterId, facilityId);
        ResonponseAPI<TheaterReturnDto> resonponseAPI = ResonponseAPI.<TheaterReturnDto>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(theaterReturnDto)
                .build();
        return new ResponseEntity<>(resonponseAPI, HttpStatus.OK);
    }

    @PutMapping("/{theaterId}")
    public ResponseEntity<ResonponseAPI<TheaterResponseDto>> updateTheaterById(@PathVariable String theaterId, @RequestBody TheaterRequestDto theaterRequestDto) {
        TheaterResponseDto theaterResponseDto = theaterService.updateTheaterById(theaterId, theaterRequestDto);
        ResonponseAPI<TheaterResponseDto> resonponseAPI = ResonponseAPI.<TheaterResponseDto>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(theaterResponseDto)
                .build();
        return new ResponseEntity<>(resonponseAPI, HttpStatus.OK);
    }

    @PutMapping("/facility-add/{theaterId}/{facilityId}")
    public ResponseEntity<ResonponseAPI<TheaterResponseDto>> addFacilityByTheater(@PathVariable String theaterId, @PathVariable String facilityId) {
        TheaterResponseDto theaterResponseDto = theaterService.addFacilityByTheater(theaterId, facilityId);
        ResonponseAPI<TheaterResponseDto> resonponseAPI = ResonponseAPI.<TheaterResponseDto>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(theaterResponseDto)
                .build();
        return new ResponseEntity<>(resonponseAPI, HttpStatus.OK);
    }
    @PostMapping("/{theaterID}")
    public ResponseEntity<ResonponseAPI<ScreenResponseDto>>  addScreenById(@PathVariable String theaterID, @RequestBody ScreenRequestDto screenRequestDto){
             ScreenResponseDto screenResponseDto= theaterService.addScreenById(theaterID,screenRequestDto);
             ResonponseAPI<ScreenResponseDto> resonponseAPI=ResonponseAPI.<ScreenResponseDto>builder()
                     .message(Messages.SUCCESS)
                     .status(HttpStatus.OK.value())
                     .data(screenResponseDto)
                     .build();
             return new ResponseEntity<>(resonponseAPI,HttpStatus.OK);
    }
    @GetMapping("/theater/{theaterId}")
    public ResponseEntity<ResonponseAPI<List<ScreenResponseDto>>>  getAllScreenOfTheater(@PathVariable String theaterId){
              List<ScreenResponseDto> screenResponseDto=theaterService.getAllScreenOfTheater(theaterId);
        ResonponseAPI<List<ScreenResponseDto>> resonponseAPI=ResonponseAPI.<List<ScreenResponseDto>>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(screenResponseDto)
                .build();
        return new ResponseEntity<>(resonponseAPI,HttpStatus.OK);
    }
    @GetMapping("/screen/{screenId}")
    public ResponseEntity<ResonponseAPI<ScreenResponseDto>> getScreenByID(@PathVariable String screenId){
        ScreenResponseDto screenResponseDto= theaterService.getScreenById(screenId);
        ResonponseAPI<ScreenResponseDto> resonponseAPI=ResonponseAPI.<ScreenResponseDto>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(screenResponseDto)
                .build();
        return new ResponseEntity<>(resonponseAPI,HttpStatus.OK);
    }
    @DeleteMapping("/{screenId}")
  public   ResponseEntity<ResonponseAPI<String>> deleteScreenById(@PathVariable String screenId) {
      String str = theaterService.deletedById(screenId);
      ResonponseAPI<String> resonponseAPI = ResonponseAPI.<String>builder()
              .message(Messages.SUCCESS)
              .status(HttpStatus.OK.value())
              .data(str)
              .build();
      return new ResponseEntity<>(resonponseAPI, HttpStatus.OK);


  }
}
