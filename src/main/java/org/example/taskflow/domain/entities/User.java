package org.example.taskflow.domain.entities;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.taskflow.domain.enums.Role;

import java.util.List;

@Entity
@Data
@Enabled
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Task> task;
    @OneToMany(fetch = FetchType.EAGER)
    private List<DemandReplacement> demandReplacement;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Card> cards;
}
