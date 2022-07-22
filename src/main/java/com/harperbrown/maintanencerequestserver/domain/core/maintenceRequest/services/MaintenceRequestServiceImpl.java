package com.harperbrown.maintanencerequestserver.domain.core.maintenceRequest.services;

import com.harperbrown.maintanencerequestserver.domain.core.exceptions.ResourceCreationException;
import com.harperbrown.maintanencerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.harperbrown.maintanencerequestserver.domain.core.maintenceRequest.models.MaintenceRequest;
import com.harperbrown.maintanencerequestserver.domain.core.maintenceRequest.repos.MaintenceRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MaintenceRequestServiceImpl implements MaintenceRequestService {
    private MaintenceRequestRepo maintenceRequestRepo;

    @Autowired
    public MaintenceRequestServiceImpl(MaintenceRequestRepo maintenceRequestRepo){
        this.maintenceRequestRepo = maintenceRequestRepo;
    }


    @Override
    public MaintenceRequest create(MaintenceRequest maintenceRequest) throws ResourceCreationException {
        Optional<MaintenceRequest> optional = maintenceRequestRepo.findByEmail(maintenceRequest.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Request with email exist: " + maintenceRequest.getEmail());
        maintenceRequest = maintenceRequestRepo.save(maintenceRequest);
        return maintenceRequest;
    }

    @Override
    public MaintenceRequest getById(Long id) throws ResourceNotFoundException {
        MaintenceRequest maintenceRequest = maintenceRequestRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Request with id: " + id));
        return maintenceRequest;
    }

    @Override
    public MaintenceRequest getByEmail(String email) throws ResourceNotFoundException {
        MaintenceRequest maintenceRequest = maintenceRequestRepo.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("No Request with email: " + email));
        return maintenceRequest;
    }

    @Override
    public List<MaintenceRequest> getAll() {
        return maintenceRequestRepo.findAll();
    }

    @Override
    public MaintenceRequest update(Long id, MaintenceRequest maintenceRequestDetails) throws ResourceNotFoundException {
        MaintenceRequest maintenceRequest = getById(id);
        maintenceRequest.setFirstName(maintenceRequestDetails.getFirstName());
        maintenceRequest.setLastName(maintenceRequestDetails.getLastName());
        maintenceRequest.setEmail(maintenceRequestDetails.getEmail());
        maintenceRequest = maintenceRequestRepo.save(maintenceRequest);
        return maintenceRequest;
    }

    @Override
    public void delete(Long id) {
        MaintenceRequest maintenceRequest = getById(id);
        maintenceRequestRepo.delete(maintenceRequest);
    }
}
