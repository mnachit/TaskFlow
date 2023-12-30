package org.example.taskflow.domain.entities;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.taskflow.domain.enums.CardType;
import org.example.taskflow.domain.enums.RangeType;

@Entity
@Data
@Enabled
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    private Integer numberOfUtilisation;
    private CardType cardTypetype;
    private RangeType rangeType;
}
