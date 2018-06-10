package com.example.demo.resource;

import com.example.demo.dto.Status;
import com.example.demo.repository.StatusRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/thermostat")
public class StatusResource {

    private StatusRepository statusRepository;

    public StatusResource(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
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