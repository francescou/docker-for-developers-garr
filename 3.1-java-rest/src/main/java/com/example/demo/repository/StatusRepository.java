package com.example.demo.repository;



import java.util.Map;

import javax.annotation.PostConstruct;

import com.example.demo.dto.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {


}

