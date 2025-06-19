package com.driver.bookMyShow.Services.Impl;

import com.driver.bookMyShow.Dtos.RequestDtos.AdvanceRequestDto;
import com.driver.bookMyShow.Exceptions.NotFoundExecption;
import com.driver.bookMyShow.Models.AdvanceData;
import com.driver.bookMyShow.Repositories.AdvanceDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvanceserviceImpl {
    @Autowired
    private AdvanceDataRepo advanceDataRepo;

     public AdvanceData post(AdvanceRequestDto advanceRequestDto){
         if (advanceRequestDto.getUserIdCreation()!=null){
             AdvanceData advanceData=new AdvanceData();
             advanceData.setDate(advanceRequestDto.getDate());
             advanceData.setAdvanceType(advanceRequestDto.getAdvanceType());
             advanceData.setVechicleType(advanceRequestDto.getVechicleType());
             advanceData.setRouteName(advanceRequestDto.getRouteName());
             advanceData.setStatus(advanceRequestDto.getStatus());
             advanceData.setVendor(advanceRequestDto.getVendor());
             advanceData.setUserIdCreation(advanceRequestDto.getUserIdCreation());
             advanceData.setUserIdUpdation(advanceRequestDto.getUserIdUpdation());
            return advanceDataRepo.save(advanceData);

         }
         else {
             throw new NotFoundExecption("user create id is not present ");
         }
     }
     public List<AdvanceData> getAll(AdvanceRequestDto advanceRequestDto){
        return advanceDataRepo.searchData(advanceRequestDto.getDate(),advanceRequestDto.getAdvanceType()
         ,advanceRequestDto.getVechicleType(),advanceRequestDto.getRouteName()
                 ,advanceRequestDto.getStatus(),
                 advanceRequestDto.getVendor());
     }
}
