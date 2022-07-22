package com.harperbrown.maintanencerequestserver.domain.core.maintenceRequest.controllers;

import com.harperbrown.maintanencerequestserver.domain.core.maintenceRequest.models.MaintenceRequest;
import com.harperbrown.maintanencerequestserver.domain.core.maintenceRequest.services.MaintenceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/request")
public class MaintenceRequestController {
    private MaintenceRequestService maintenceRequestService;

    @Autowired
    public MaintenceRequestController(MaintenceRequestService maintenceRequestService) {
        this.maintenceRequestService = maintenceRequestService;
    }

    @GetMapping
    public ResponseEntity<List<MaintenceRequest>> getAll(){
        List<MaintenceRequest> maintenceRequests = maintenceRequestService.getAll();
        return new ResponseEntity<>(maintenceRequests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MaintenceRequest> create(@RequestBody MaintenceRequest maintenceRequest){
        maintenceRequest = maintenceRequestService.create(maintenceRequest);
        return new ResponseEntity<>(maintenceRequest, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MaintenceRequest> getById(@PathVariable("id") Long id){
        MaintenceRequest maintenceRequest = maintenceRequestService.getById(id);
        return new ResponseEntity<>(maintenceRequest, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<MaintenceRequest> getByEmail(@RequestParam String email){
        MaintenceRequest maintenceRequest = maintenceRequestService.getByEmail(email);
        return new ResponseEntity<>(maintenceRequest, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<MaintenceRequest> update(@PathVariable("id") Long id, @RequestBody MaintenceRequest maintenceRequestDetail){
        maintenceRequestDetail = maintenceRequestService.update(id, maintenceRequestDetail);
        return new ResponseEntity<>(maintenceRequestDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        maintenceRequestService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
