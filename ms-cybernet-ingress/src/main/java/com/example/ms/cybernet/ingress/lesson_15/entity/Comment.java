package com.example.ms.cybernet.ingress.lesson_15.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "comment")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Comment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String content;

    @ManyToOne
    Post post;

}
