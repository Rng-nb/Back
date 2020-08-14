package com.thoughtworks.bussiness.service;

import com.thoughtworks.bussiness.domain.BsInfo;
import com.thoughtworks.bussiness.dto.BsInfoDto;
import com.thoughtworks.bussiness.repository.BsInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BsInfoService {
    private BsInfoRepository bsInfoRepository;
    @Autowired
    public BsInfoService(BsInfoRepository bsInfoRepository) {
        this.bsInfoRepository = bsInfoRepository;
    }

    public List<BsInfo> getBussinessInfoList() {
        List<BsInfo> bsInfoList= bsInfoRepository.findAll().stream().map( item ->
                BsInfo.builder().productName(item.getProductName()).productPrice(item.getProductPrice())
                        .productUnit(item.getProductUnit()).productUrl(item.getProductUrl()).build())
                        .collect(Collectors.toList());
        return bsInfoList;
    }

    public void postBussinessInfo(BsInfo bsInfo) {
        BsInfoDto bsInfoDto = BsInfoDto.builder().productName(bsInfo.getProductName())
                .productPrice(bsInfo.getProductPrice()).productUnit(bsInfo.getProductUnit())
                .productUrl(bsInfo.getProductUrl()).build();
        bsInfoDto = bsInfoRepository.save(bsInfoDto);
    }
}