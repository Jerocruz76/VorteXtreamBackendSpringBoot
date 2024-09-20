package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "media_entity")
public class MediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "media_description", nullable = false)
    private String description;

    @Column(name = "publication_date", nullable = false)
    private String publicationDate;

    @ManyToOne
    @JoinColumn(name = "cast_id", referencedColumnName = "id",nullable = false)
    private Cast cast;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id",nullable = false)
    private Categories categories;

    @ManyToOne
    @JoinColumn(name = "directors_id",referencedColumnName = "id",nullable = false)
    private Directors directors;

    @OneToOne
    @JoinColumn(name = "image_id",referencedColumnName = "id",nullable = false)
    private ImageEntity imageEntity;

    @ManyToOne
    @JoinColumn(name = "studio_id",referencedColumnName = "id",nullable = false)
    private Studios studios;

    @ManyToOne
    @JoinColumn(name = "subcategory_id",referencedColumnName = "id",nullable = false)
    private SubCategories subCategories;

    @OneToOne
    @JoinColumn(name = "streaming_id",referencedColumnName = "id",nullable = false)
    private TypeStreaming typeStreaming;
}
