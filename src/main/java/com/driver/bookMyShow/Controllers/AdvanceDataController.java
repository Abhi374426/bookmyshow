package com.driver.bookMyShow.Controllers;

import com.driver.bookMyShow.Dtos.RequestDtos.AdvanceRequestDto;
import com.driver.bookMyShow.Models.AdvanceData;
import com.driver.bookMyShow.Services.Impl.AdvanceserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advance/data")
public class AdvanceDataController {
    @Autowired
    private AdvanceserviceImpl advanceservice;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AdvanceRequestDto advanceRequestDto) {
        try {
            AdvanceData savedData = advanceservice.post(advanceRequestDto);
            return ResponseEntity.ok(savedData);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

}
