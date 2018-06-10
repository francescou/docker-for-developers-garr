package com.example.demo.resource;

import com.example.demo.dto.Status;
import com.example.demo.repository.StatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/thermostat")
public class StatusResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatusResource.class);

    private StatusRepository statusRepository;

    public StatusResource(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }


    @Scheduled(initialDelay = 60_000, fixedDelay = 100_000)
    public void memory() {


        LOGGER.info("killing memory...");

        List l = new ArrayList();
        int n = 0;
        while (true) {
            l.add(BigInteger.valueOf(++n));
        }
    }


    @PostConstruct
    public void postConstruct() {
        if (statusRepository.findAll().size() == 0) {
            Status status = new Status();
            status.setValue(20);

            statusRepository.save(status);
        }
    }

    @PostMapping
    public ResponseEntity<Status> updateStatus(@RequestBody Status status) {
        statusRepository.save(status);
        return ResponseEntity.ok(status);
    }


    @GetMapping
    public ResponseEntity<Status> getStatus() {

        Status status = statusRepository
                .findAll()
                .values()
                .stream()
                .findFirst()
                .get();

        return ResponseEntity.ok(status);

    }

}
