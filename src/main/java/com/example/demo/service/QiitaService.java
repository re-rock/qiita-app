package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class QiitaService {
    
    RestComponent restComponent;

    QiitaRepository qiiitaRepository;

    @Autowired
    public QiitaService(RestComponent restComponent, QiitaRepository qiitaRepository){
        this.restComponent = restComponent;
        this.qiiitaRepository = qiitaRepository;
    }

    @Transactional(readOnly = false)
    public void crawItems() {
        List<QiitaItem> items = restComponent.getItems();
        qiiitaRepository.saveAll(items);
    }

    @Transactional(readOnly = true)
    public List<QiitaItem> findAll() {
        return qiiitaRepository.findAll();
    }


}