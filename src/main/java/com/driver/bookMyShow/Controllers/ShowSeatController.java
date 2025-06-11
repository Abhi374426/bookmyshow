//package com.driver.bookMyShow.Controllers;
//
//import com.driver.bookMyShow.Dtos.RequestDtos.ShowSeatV1EntryDto;
////import com.driver.bookMyShow.Dtos.ResponseDtos.ReturnShowSeatV1Dto;
//import com.driver.bookMyShow.Dtos.ResponseDtos.SeatResponse;
//import com.driver.bookMyShow.ResponseAPI.ResonponseAPI;
//import com.driver.bookMyShow.Services.ShowSeatV1Service;
//import com.driver.bookMyShow.constant.Messages;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/show-seat/v1")
//public class ShowSeatV1Controller {
//    @Autowired
//    private ShowSeatV1Service showSeatV1Service;
//
//    @PostMapping("/{show_id}")
//    public ResponseEntity<ResonponseAPI<String>> addSeatDetails(@PathVariable Integer show_id, @RequestBody ShowSeatV1EntryDto showSeatV1EntryDto) {
//        String msg = showSeatV1Service.addSeatDetails(show_id, showSeatV1EntryDto);
//        ResonponseAPI<String> resonponseAPI = ResonponseAPI.<String>builder()
//                .message(Messages.SUCCESS)
//                .status(HttpStatus.CREATED.value())
//                .data(msg)
//                .build();
//        return new ResponseEntity<>(resonponseAPI, HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<ResonponseAPI<List<SeatResponse>>> getAllSeatDetails() {
//
//        List<SeatResponse> returnShowSeatV1DtoList = showSeatV1Service.getAllSeatDetails();
//        ResonponseAPI<List<SeatResponse>> listResonponseAPI = ResonponseAPI.<List<SeatResponse>>builder()
//                .message(Messages.SUCCESS)
//                .status(HttpStatus.OK.value())
//                .data(returnShowSeatV1DtoList)
//                .build();
//        return new ResponseEntity<>(listResonponseAPI, HttpStatus.OK);
//
//
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ResonponseAPI<String>> updateSeatDetails(@PathVariable String id, @RequestBody ShowSeatV1EntryDto showSeatV1EntryDto) {
//
//        String msg = showSeatV1Service.updateSeatDetails(id, showSeatV1EntryDto);
//        ResonponseAPI<String> resonponseAPI = ResonponseAPI.<String>builder()
//                .message(msg)
//                .status(HttpStatus.OK.value())
//                .data(null)
//                .build();
//        return new ResponseEntity<>(resonponseAPI, HttpStatus.OK);
//
//    }
//
//
//}
