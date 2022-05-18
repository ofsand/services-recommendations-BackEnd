package org.capgemini.servicesrecommendationbackEnd.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecommendation;
    private String comment;
    private boolean isApproved;
    private int numberStars;
    @ManyToOne
    @JoinColumn(name="id_user", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name="id_tradesperson")
    private Tradesperson tradesperson;
    @ManyToOne
    @JoinColumn(name="id_service")
    private Service service;
}