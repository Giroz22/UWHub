package com.waveghost.uwhub.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "staffs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserTourneyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String position;

    @ManyToOne
    @JoinColumn(
        name = "user_id"
    )
    private UserEntity user;

    @ManyToOne
    @JoinColumn(
        name = "tournament_id"
    )
    private TournamentEntity tournament;
}
