package com.example.ms.cybernet.ingress.dao.entity;


import com.example.ms.cybernet.ingress.model.enums.CardStatus;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cards")
@Entity
public class CardEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String pan;
    private String cardHolder;

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;
}
