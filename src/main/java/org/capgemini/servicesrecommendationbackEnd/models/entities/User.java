package org.capgemini.servicesrecommendationbackEnd.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    private String email;
    private String pseudo;
    private String username;
    private String password;
    private String rolesTemp;
    @ManyToMany
    @JoinTable(name="users_roles",
        joinColumns = @JoinColumn(name = "id_user"),
        inverseJoinColumns = @JoinColumn(name="id_role")
    )
    private List<Role> roles = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Category> categories = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Recommendation> recommendations = new ArrayList<>();
}
