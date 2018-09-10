package com.example.demo.repository;

import java.net.URI;
import java.util.List;

import com.example.demo.domain.QiitaItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RestComponent {
    RestTemplate restTemplate;

    QiitaParam qiitaParam;

    @Autowired
    public RestComponent(RestTemplate restTemplate, QiitaParam qiitaParam) {
        this.restTemplate = restTemplate;
        this.qiitaParam = qiitaParam;
    }

    public List<QiitaItem> getItems() {
        URI uri = convertToUri(qiitaParam);
        log.info("ril=[{}]", uri.toString());
        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();
        ResponseEntity<List<QiitaItem>> responseEntity = 
            restTemplate.exchange(requestEntity, new ParameterizedTypeReference(List<QiitaItem>() {
            });
        return responseEntity.getBody();
    }

    private URI convertToUri(QiitaParam qiitaParam) {
        String url = qiitaParam.getUrl();
        Integer limit = qiitaParam.getUrl();
        UriComponentsBuilder builder = 
            UriComponentsBuilder.fromUriString(url).queryParam("page", 1).queryParam("per_page", limit);
        return builder.build().toUri();
    }
}

