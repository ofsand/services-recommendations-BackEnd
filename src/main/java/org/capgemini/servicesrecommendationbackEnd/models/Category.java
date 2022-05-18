package org.capgemini.servicesrecommendationbackEnd.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long idCategory;
    private String name;
    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;
    @OneToMany(mappedBy = "category")
    private List<Service> services;
    @OneToMany(mappedBy = "category")
    private List<Tradesperson> tradesPersons;
}
