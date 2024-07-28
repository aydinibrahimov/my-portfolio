package com.example.ms.cybernet.ingress.lesson_15.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Post {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;

    @OneToOne(mappedBy = "post", cascade = ALL, fetch = LAZY)
    PostDetail postDetail;

    @OneToMany(mappedBy = "post", cascade = ALL)
    @ToString.Exclude
    private List<Comment> comments;

    @ManyToMany(cascade = ALL)
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    List<Tag> tags;
}
