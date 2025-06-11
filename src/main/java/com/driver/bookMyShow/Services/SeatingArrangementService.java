//package com.driver.bookMyShow.Services;
//
//import com.driver.bookMyShow.Dtos.ResponseDtos.SeatArrangementResponseDto;
//import com.driver.bookMyShow.Exceptions.AlreadyPresentException;
//import com.driver.bookMyShow.Exceptions.NotFoundExecption;
//import com.driver.bookMyShow.Models.Screen;
//import com.driver.bookMyShow.Models.SeatingArrangement;
//import com.driver.bookMyShow.Repositories.ScreenRepository;
//import com.driver.bookMyShow.Repositories.SeatingArrangementRepositories;
//import com.driver.bookMyShow.Transformers.SeatArrangementResponse;
//import com.driver.bookMyShow.constant.Messages;
//import com.driver.bookMyShow.utils.Utils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class SeatingArrangementService {
//    @Autowired
//    private SeatingArrangementRepositories seatingArrangementRepositories;
//    @Autowired
//    private ScreenRepository screenRepository;
//
//    public String generateSeatingFormCapacity(String cinemaHallId){
//
//        List<SeatingArrangement> seats=new ArrayList<>();
//
//        if (!screenRepository.existsById(cinemaHallId)){
//            throw new NotFoundExecption(Messages.SCREEN+Messages.ONE_TAB+Messages.NOT_FOUND);
//        }
//            Screen screen = screenRepository.findById(cinemaHallId).get();
//        if(!screen.getSeatingArrangementList().isEmpty()){
//            throw new AlreadyPresentException(Messages.SCREEN+Messages.ONE_TAB+Messages.ALREADY_PRESENT);
//        }
//
//        for (int i = 1; i<= screen.getCapacitive().getDiamond(); i++){
//            seats.add(SeatingArrangement.builder()
//                    .seatName("D"+i)
//                    .seatType("DIAMOND")
//                            .isActive(true)
//                            .deleted(false)
//                            .id(Utils.generateUUID(10))
//                            .screenSize(screen.getScreenType())
//                       .screen(screen)
//                    .build());
//        }
//        for (int i = 1; i<= screen.getCapacitive().getGold(); i++){
//
//              seats.add(SeatingArrangement.builder()
//                      .seatName("G"+i)
//                      .seatType("Gold")
//                      .id(Utils.generateUUID(10))
//                              .isActive(true)
//                              .deleted(false)
//                      .screenSize(screen.getScreenType())
//                      .screen(screen)
//                      .build());
//        }
//        for (int i = 1; i<= screen.getCapacitive().getSilver(); i++){
//            seats.add(SeatingArrangement.builder()
//                    .seatName("S" + i)
//                    .seatType("SILVER")
//                    .id(Utils.generateUUID(10))
//                                    .isActive(true)
//                                    .deleted(false)
////                    .active(true)
////                    .deleted(false)
//                    .screen(screen)
//                    .screenSize(screen.getScreenType()) // if needed
//                    .build()); }
//        seatingArrangementRepositories.saveAll(seats);
//        return Messages.SUCCESS;
//    }
//    public List<SeatArrangementResponseDto>  getAllSeatingArrangementById(String screenId){
//        if (!screenRepository.existsById(screenId)) {
//            throw new NotFoundExecption(Messages.SCREEN+Messages.ONE_TAB+Messages.NOT_FOUND);
//        }
//        if (!seatingArrangementRepositories.existsByScreen_Id(screenId)){
//            throw new NotFoundExecption(Messages.SEAT_ARRANGEMENT+Messages.NOT_FOUND+Messages.SCREEN);
//        }
//
//        List<SeatingArrangement> seatingArrangementList =    seatingArrangementRepositories.findByScreen_Id(screenId);
//        return SeatArrangementResponse.seatArrangementReturnDto(seatingArrangementList);
//
//    }
//}
