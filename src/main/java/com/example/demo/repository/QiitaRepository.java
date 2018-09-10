package com.example.demo.repository;

import com.example.demo.domain.QiitaItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QiitaRepository extends JpaRepository<QiitaItem, String> {
}