package com.driver.bookMyShow.Services.Impl;

import com.driver.bookMyShow.Dtos.RequestDtos.ShowRequestDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.ShowResponseDtos;
import com.driver.bookMyShow.Enums.ShowStatus;
import com.driver.bookMyShow.Exceptions.AlreadyPresentException;
import com.driver.bookMyShow.Exceptions.NotFoundExecption;
import com.driver.bookMyShow.Exceptions.RequestFailedException;
import com.driver.bookMyShow.Models.Screen;
import com.driver.bookMyShow.Models.Show;
import com.driver.bookMyShow.Repositories.ScreenRepository;
import com.driver.bookMyShow.Repositories.ShowRepository;
import com.driver.bookMyShow.Services.ScreenService;
import com.driver.bookMyShow.Services.ShowService;
import com.driver.bookMyShow.Transformers.ShowTransformer;
import com.driver.bookMyShow.constant.Messages;
import com.driver.bookMyShow.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    private ScreenRepository screenRepository;
    @Autowired
    private ShowRepository showRepository;

    @Override
    public ShowResponseDtos createShowByScreenId(String screenID, ShowRequestDto showRequestDto) {
        showRequestDto.validate();
        Screen screen = screenRepository.findById(screenID).orElseThrow(() -> new NotFoundExecption(Messages.SCREEN + Messages.ONE_TAB + Messages.NOT_FOUND));
        List<Show> conflicts = showRepository.findByScreen_IdAndStartTimeLessThanAndEndTimeGreaterThan(screenID, showRequestDto.getEndTime(),showRequestDto.getStartTime());
        if (!conflicts.isEmpty()) {
            throw new AlreadyPresentException("Show timing conflicts with existing shows.");
        }
        Show show = ShowTransformer.DtoTOObj(showRequestDto);
        show.setId(Utils.generateUUID(10));
        show.setScreen(screen);
        return ShowTransformer.ObjTODto(showRepository.save(show));
    }

    @Override
    public ShowResponseDtos getShowById(String showId) {
       Show show= showRepository.findById(showId).orElseThrow(()->
                new NotFoundExecption(Messages.SHOW+Messages.ONE_TAB+Messages.NOT_FOUND));
       return ShowTransformer.ObjTODto(show);
    }

    @Override
    public List<ShowResponseDtos> getAllShow() {
             return   showRepository.findAll().stream().map(ShowTransformer::ObjTODto).
                       collect(Collectors.toList());
    }

    @Override
    public List<ShowResponseDtos> getAllShowByScreenID(String screenID) {
        List<Show> shows = showRepository.findByScreenId(screenID);
        if (shows.isEmpty()) throw new NotFoundExecption(Messages.SHOW + Messages.ONE_TAB + Messages.NOT_FOUND);
        return shows.stream().map(ShowTransformer::ObjTODto).collect(Collectors.toList());

    }

    @Override
    public ShowResponseDtos updateShow(String showId, ShowRequestDto showRequestDto) {
     Show show=  showRepository.findById(showId).orElseThrow(()-> new NotFoundExecption(Messages.SHOW+Messages.ONE_TAB+Messages.NOT_FOUND));
        List<Show> conflicts = showRepository.findByScreen_IdAndStartTimeLessThanAndEndTimeGreaterThan(show.getScreen().getId(), showRequestDto.getEndTime() ,showRequestDto.getStartTime());
        if (!conflicts.isEmpty()) {
            throw new AlreadyPresentException("Show timing conflicts with existing shows.");
        }
        show.setStartTime(showRequestDto.getStartTime());
        show.setEndTime(showRequestDto.getEndTime());
        return ShowTransformer.ObjTODto(showRepository.save(show));
    }



    @Override
    public String deletedShowByID(String showID) {
           showRepository.findById(showID).orElseThrow(()-> new NotFoundExecption(Messages.SHOW+Messages.ONE_TAB+Messages.NOT_FOUND));
           showRepository.deleteById(showID);
        return Messages.SUCCESS;
    }

    @Override
    public String showStatusByShowId(String showID) {
        return ShowStatus.getEnum(showRepository.findById(showID).orElseThrow(() -> new NotFoundExecption(Messages.SHOW + Messages.ONE_TAB + Messages.NOT_FOUND)).getShowStatus()).getDescription();
    }
}
