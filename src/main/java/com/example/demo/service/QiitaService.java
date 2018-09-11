package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.domain.QiitaItem;
import com.example.demo.repository.QiitaRepository;
import com.example.demo.repository.RestComponent;

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
    public void crawlItems() {
        List<QiitaItem> items = restComponent.getItems();
        qiiitaRepository.saveAll(items);
    }

    @Transactional(readOnly = true)
    public List<QiitaItem> findAll() {
        return qiiitaRepository.findAll();
    }

}