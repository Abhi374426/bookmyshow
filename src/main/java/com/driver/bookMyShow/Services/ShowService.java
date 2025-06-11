package com.driver.bookMyShow.Services;

import com.driver.bookMyShow.Dtos.RequestDtos.ShowRequestDto;
import com.driver.bookMyShow.Dtos.ResponseDtos.ShowResponseDtos;

import java.util.List;

public interface ShowService {
  ShowResponseDtos  createShowByScreenId(String screenID, ShowRequestDto showRequestDto);
  ShowResponseDtos  getShowById(String showId);
  List<ShowResponseDtos>   getAllShow();
  List<ShowResponseDtos> getAllShowByScreenID(String screenID);
//  List<ShowResponseDtos> getAllShowByMoviesID(String moviesID);
  ShowResponseDtos  updateShow(String screenId,ShowRequestDto showRequestDto);
  String  deletedShowByID(String showID);
  String  showStatusByShowId(String showID);
}
