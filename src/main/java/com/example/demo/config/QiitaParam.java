package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "qiita.param")
public class QiitaParam {

    private String url;

    private String limit;
    
}