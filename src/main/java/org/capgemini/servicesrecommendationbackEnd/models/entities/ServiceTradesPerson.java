package org.capgemini.servicesrecommendationbackEnd.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ServiceTradesPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String title;
    private String email;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name="id_category")
    private Category category;
    @OneToMany(mappedBy = "serviceTradesPerson")
    private List<Recommendation> recommendations;
}
