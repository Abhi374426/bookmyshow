package com.driver.bookMyShow.Controllers;

import com.driver.bookMyShow.Dtos.RequestDtos.ShowRequestDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.ShowResponseDtos;
import com.driver.bookMyShow.ResponseAPI.ResonponseAPI;
import com.driver.bookMyShow.Services.ShowService;
import com.driver.bookMyShow.constant.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    private ShowService showService;
    @PostMapping("/{screenID}")
    public ResponseEntity<ResonponseAPI<ShowResponseDtos>>  addShowBYScreenId(@PathVariable String screenID, @RequestBody ShowRequestDto  showRequestDto){
        ShowResponseDtos showResponseDtos=  showService.createShowByScreenId(screenID,showRequestDto);
        ResonponseAPI<ShowResponseDtos> resonponseAPI=ResonponseAPI.<ShowResponseDtos>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(showResponseDtos)
                .build();
        return new ResponseEntity<>(resonponseAPI,HttpStatus.OK);
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<ResonponseAPI<String>>  addShowBYScreenId(@PathVariable("id") String showId){
        ResonponseAPI<String> resonponseAPI=ResonponseAPI.<String>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(showService.showStatusByShowId(showId))
                .build();
        return new ResponseEntity<>(resonponseAPI,HttpStatus.OK);
    }
    @GetMapping("/show/{id}")
    public ResponseEntity<ResonponseAPI<ShowResponseDtos>> getShowById(@PathVariable("id") String showId){
        ResonponseAPI<ShowResponseDtos> resonponseAPI=ResonponseAPI.<ShowResponseDtos>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(showService.getShowById(showId))
                .build();
        return new ResponseEntity<>(resonponseAPI,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<ResonponseAPI<List<ShowResponseDtos>>> getAllShow(){
        ResonponseAPI<List<ShowResponseDtos>> resonponseAPI=ResonponseAPI.<List<ShowResponseDtos>>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(showService.getAllShow())
                .build();
        return new ResponseEntity<>(resonponseAPI,HttpStatus.OK);
    }
    @GetMapping("/screen/{id}")
    public ResponseEntity<ResonponseAPI<List<ShowResponseDtos>>> getAllShowByScreenID(@PathVariable("id") String screenId){
        ResonponseAPI<List<ShowResponseDtos>> resonponseAPI=ResonponseAPI.<List<ShowResponseDtos>>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(showService.getAllShowByScreenID(screenId))
                .build();
        return new ResponseEntity<>(resonponseAPI,HttpStatus.OK);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<ResonponseAPI<ShowResponseDtos>>  updateShow(@PathVariable("id") String showID, @RequestBody ShowRequestDto  showRequestDto){

        ResonponseAPI<ShowResponseDtos> resonponseAPI=ResonponseAPI.<ShowResponseDtos>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(showService.updateShow(showID,showRequestDto))
                .build();
        return new ResponseEntity<>(resonponseAPI,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResonponseAPI<String>>  deletedShowByID(@PathVariable("id") String showId){
        ResonponseAPI<String> resonponseAPI=ResonponseAPI.<String>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(showService.deletedShowByID(showId))
                .build();
        return new ResponseEntity<>(resonponseAPI,HttpStatus.OK);
    }


}
