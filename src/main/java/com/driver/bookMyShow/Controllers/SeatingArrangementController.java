//package com.driver.bookMyShow.Controllers;
//
////import com.driver.bookMyShow.Dtos.ResponseDtos.ReturnShowSeatV1Dto;
//
//import com.driver.bookMyShow.Dtos.ResponseDtos.SeatArrangementResponseDto;
//import com.driver.bookMyShow.ResponseAPI.ResonponseAPI;
////import com.driver.bookMyShow.Services.SeatingArrangementService;
//import com.driver.bookMyShow.constant.Messages;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/seating-arrangement/v1")
//public class SeatingArrangementController {
////    @Autowired
////    private SeatingArrangementService seatingArrangementService;
//
//    @PostMapping("/{cinemaHallId}")
//    public ResponseEntity<ResonponseAPI<String>> addSeatArgForScreen(@PathVariable("cinemaHallId") String cinemaHallId) {
//
//        String seatingArrangementV1List = seatingArrangementService.generateSeatingFormCapacity(cinemaHallId);
//        ResonponseAPI<String> resonponseAPI = ResonponseAPI.<String>builder()
//                .message(Messages.SUCCESS)
//                .status(HttpStatus.OK.value())
//                .data(seatingArrangementV1List)
//                .build();
//        return new ResponseEntity<>(resonponseAPI, HttpStatus.CREATED);
//
//    }
//
//    @GetMapping("/{screenId}")
//    public ResponseEntity<ResonponseAPI<List<SeatArrangementResponseDto>>> getScreenSeats(@PathVariable String screenId) {
//        List<SeatArrangementResponseDto> seatArrangementResponseDtoList = seatingArrangementService.getAllSeatingArrangementById(screenId);
//        ResonponseAPI<List<SeatArrangementResponseDto>> listResonponseAPI = ResonponseAPI.<List<SeatArrangementResponseDto>>builder()
//                .message(Messages.SUCCESS)
//                .status(HttpStatus.OK.value())
//                .data(seatArrangementResponseDtoList)
//                .build();
//        return new ResponseEntity<>(listResonponseAPI, HttpStatus.OK);
//    }
//
//}
