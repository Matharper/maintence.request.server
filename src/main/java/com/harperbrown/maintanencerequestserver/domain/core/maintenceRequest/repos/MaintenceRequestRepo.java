package com.harperbrown.maintanencerequestserver.domain.core.maintenceRequest.repos;

import com.harperbrown.maintanencerequestserver.domain.core.maintenceRequest.models.MaintenceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaintenceRequestRepo extends JpaRepository<MaintenceRequest,Long> {
    Optional<MaintenceRequest>findByEmail(String email);
}
