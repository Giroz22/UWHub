package com.waveghost.uwhub.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tournaments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TournamentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;

    @OneToMany(
        mappedBy = "tournament",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<TeamEntity> teams;

    @OneToOne(
        mappedBy = "tournament",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private ModalityEntity modality;
}
