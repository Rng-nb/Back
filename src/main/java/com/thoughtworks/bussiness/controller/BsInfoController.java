package com.thoughtworks.bussiness.controller;
import com.thoughtworks.bussiness.service.BsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BsInfoController {

    private BsInfoService bsInfoService;

    @Autowired
    public BsInfoController(BsInfoService bsInfoService) {
        this.bsInfoService = bsInfoService;
    }

    @GetMapping("/bsInfo")
    public ResponseEntity getBussinessInfoList() {
        return ResponseEntity.ok(bsInfoService.getBussinessInfoList());
    }



}