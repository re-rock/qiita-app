package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.example.demo.service.QiitaService;

@Controller
public class QiitaScheduleController {

    private static final long INTERVAL = 900_000;

    @Autowired
    QiitaService qiitaServce;

    @Scheduled(fixedRate=INTERVAL)
    public void crawQiitaItems() {
        qiitaServce.crawlItems();
    }
    
}
