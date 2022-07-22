package com.harperbrown.maintanencerequestserver.domain.core.maintenceRequest.services;

import com.harperbrown.maintanencerequestserver.domain.core.exceptions.ResourceCreationException;
import com.harperbrown.maintanencerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.harperbrown.maintanencerequestserver.domain.core.maintenceRequest.models.MaintenceRequest;

import java.util.List;

public interface MaintenceRequestService {
    MaintenceRequest create(MaintenceRequest maintenceRequest) throws ResourceCreationException;
    MaintenceRequest getById(Long id)throws ResourceNotFoundException;
    MaintenceRequest getByEmail(String email) throws ResourceNotFoundException;
    List<MaintenceRequest>getAll();
    MaintenceRequest update (Long id, MaintenceRequest maintenceRequestDetails) throws ResourceNotFoundException;
    void delete(Long id);
}
