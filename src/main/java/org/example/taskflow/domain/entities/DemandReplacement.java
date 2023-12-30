package org.example.taskflow.domain.entities;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.taskflow.domain.enums.DemandedStatus;

import java.time.LocalDate;

@Entity
@Data
@Enabled
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "demand_replacements")
public class DemandReplacement {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Task currentTask;
    @OneToOne
    private Task newTask;
    private String description;
    private LocalDate datedemand;
    @ManyToOne
    @JoinColumn(name = "demand_by")
    private User demandeBy;
    private DemandedStatus status;
}
