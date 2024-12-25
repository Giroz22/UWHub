package com.waveghost.uwhub.domain.entities;

import com.waveghost.uwhub.utils.enums.RoleTourney;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private RoleTourney role;

    @ManyToOne
    @JoinColumn(
        name = "user_id",
        nullable = false
    )
    private UserEntity user;

    @ManyToOne
    @JoinColumn(
        name = "tournament_id",
        nullable = false
    )
    private TournamentEntity tournament;
}
