package com.driver.bookMyShow.Services;

import com.driver.bookMyShow.Dtos.RequestDtos.ScreenRequestDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.ScreenResponseDto;
import com.driver.bookMyShow.Exceptions.NotFoundExecption;
import com.driver.bookMyShow.Models.Screen;
import com.driver.bookMyShow.Models.Theater;
import com.driver.bookMyShow.Repositories.ScreenRepository;
import com.driver.bookMyShow.Repositories.TheaterRepository;
import com.driver.bookMyShow.Transformers.ScreenTransfomers;
import com.driver.bookMyShow.constant.Messages;
import com.driver.bookMyShow.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreenService {
    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private TheaterRepository theaterRepository;

//    public String addCinemaHall(String theaterId, ScreenRequestDto screenRequestDto) {
//        screenRequestDto.validate();
//      Theater theaterObj=  theaterRepository.findById(theaterId).orElseThrow(
//                ()->new NotFoundExecption(Messages.THEATER+Messages.ONE_TAB+Messages.NOT_FOUND));
//      Capacitive capacitive = CapacitiveDtoToCapacitiveTransformer.dtoToObj(screenRequestDto.getCapacitiveV1());
//        capacitive.setId(Utils.generateUUID(10));
//        Screen screen = CinemaHallTransformer.CinemaHallV1EntryDtoToCinemaHallV1(screenRequestDto);
//        screen.setId(Utils.generateUUID(10));
//        screen.setTheater(theaterV11);
//        screen.setCapacitive(capacitive);
//        Screen screenV11 = screenRepository.save(screen);
//        return "Screen_id:" + screenV11.getId();
//    }
    @Transactional
    public ScreenResponseDto   addScreenById(String theaterId,ScreenRequestDto screenRequestDto){
        screenRequestDto.validate();
      Theater theaterObj= theaterRepository.findById(theaterId).orElseThrow(
                  ()->new NotFoundExecption(Messages.THEATER+Messages.ONE_TAB+Messages.NOT_FOUND));
      Screen screenObj= ScreenTransfomers.ScreenDtoToObj(screenRequestDto);
      screenObj.setId(Utils.generateUUID(10));
      screenObj.setTheater(theaterObj);
      return ScreenTransfomers.ObjToScreenDto(screenRepository.save(screenObj));
    }

    public List<ScreenResponseDto> getAllScreenOfTheater(String theaterId){
        Theater theaterObj= theaterRepository.findById(theaterId).orElseThrow(()->
                new NotFoundExecption(Messages.THEATER+Messages.ONE_TAB+Messages.NOT_FOUND));
      return theaterObj.getScreens().stream().map(ScreenTransfomers::ObjToScreenDto).collect(Collectors.toList());
    }
    public ScreenResponseDto  getScreenById(String screenId){
      Screen screen=  screenRepository.findById(screenId).orElseThrow(()->
                new NotFoundExecption(Messages.SCREEN+Messages.ONE_TAB+Messages.NOT_FOUND));
       return   ScreenTransfomers.ObjToScreenDto(screen);
    }
    public String deletedById(String screenId){
        screenRepository.findById(screenId).orElseThrow(()->
                new NotFoundExecption(Messages.SCREEN+Messages.ONE_TAB+Messages.NOT_FOUND));
          screenRepository.deleteById(screenId);
          return Messages.SUCCESS;
    }

}
