package com.harperbrown.maintanencerequestserver.domain.core.maintenceRequest.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity

public class MaintenceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String aptNumber;
    @NonNull
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @PrePersist
    protected void onCreate(){
        createdAt = new Date();
    }
    public String toString(){
        return String.format("%d %s %s %s",id, firstName, lastName, email, aptNumber,description);
    }

}
