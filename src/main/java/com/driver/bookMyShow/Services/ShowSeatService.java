package com.driver.bookMyShow.Services;

import com.driver.bookMyShow.Repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {
    @Autowired
    private ShowSeatRepository showSeatRepository;
//    @Autowired
//    private ShowRepository showRepository;


//    public String addSeatDetails(Integer showId,ShowSeatV1EntryDto showSeatV1EntryDto) throws ShowDoesNotExists {
//          showSeatV1EntryDto.validate();
//        Optional<Show> show = showRepository.findById(showId);
//        if (show.isEmpty()) {
//            throw new ShowDoesNotExists();
//        }
//        String seatType = showSeatV1EntryDto.getSeatType();
//        boolean isvalid = false;
//        for (SeatTypeV1 seatTypeV1 : SeatTypeV1.values()) {
//            if (seatTypeV1.name().equalsIgnoreCase(seatType)) {
//                isvalid = true;
//                break;
//            }
//        }
//        if (!isvalid) {
//            throw new NotValidExecption(Messages.SEAT+Messages.ONE_TAB+Messages.Not_Valid);
//        }
//        Show show1 = show.get();
//        ShowSeatV1 showSeatV1 = ShowSeatTransformer.showSeatV1DtoToShowseatV1(showSeatV1EntryDto);
//        showSeatV1.setId(Utils.generateUUID(10));
//        showSeatV1.setShow(show1);
//        showSeatV1.setDeleted(false);
//        showSeatV1Repository.save(showSeatV1);
//         return Messages.SUCCESS;
//
//    }

//    public String addSeatDetails(Integer showId, ShowSeatV1EntryDto showSeatV1EntryDto) throws ShowDoesNotExists {
//        showSeatV1EntryDto.validate();
//        Optional<Show> show = showRepository.findById(showId);
//        Show show1 = show.orElseThrow(() -> new NotFoundExecption(Messages.SHOW+Messages.ONE_TAB+Messages.NOT_FOUND));
//
//        if (showSeatV1Repository.existsByShowAndSeatType(show1, showSeatV1EntryDto.getSeatType())) {
//            throw new AlreadyPresentException(showSeatV1EntryDto.getSeatType() + Messages.ONE_TAB + Messages.ALREADY_PRESENT);
//        }
//        ShowSeatV1 showSeatV1 = ShowSeatTransformer.showSeatV1DtoToShowseatV1(showSeatV1EntryDto);
//        showSeatV1.setId(Utils.generateUUID(10));
//        showSeatV1.setShow(show1);
//        showSeatV1.setDeleted(false);
//        showSeatV1Repository.save(showSeatV1);
//        return Messages.SUCCESS;
//    }
//    public List<SeatResponse> getAllSeatDetails() {
//
//        List<ShowSeatV1> showSeats = showSeatV1Repository.findAll();
//
//        if (showSeats.isEmpty()) {
//            throw new NotFoundExecption(Messages.SEAT + Messages.ONE_TAB +Messages.NOT_FOUND);
//        }
//
//        return showSeats.stream().map(ShowSeatTransformer::returnShowSeatV1Dto).collect(Collectors.toList());
//    }
//
//    public String updateSeatDetails(String id, ShowSeatV1EntryDto showSeatV1EntryDto) {
//
//        Optional<ShowSeatV1> showSeatV1Opt = showSeatV1Repository.findById(id);
//
//        if (showSeatV1Opt.isEmpty()) {
//
//            throw new SeatDetailsNotFound();
//        }
//        ShowSeatV1 showSeatV1 = showSeatV1Opt.get();
//        showSeatV1.setPrice(showSeatV1EntryDto.getPrice());
//        showSeatV1Repository.save(showSeatV1);
//        return Messages.SUCCESS;
//    }
}
