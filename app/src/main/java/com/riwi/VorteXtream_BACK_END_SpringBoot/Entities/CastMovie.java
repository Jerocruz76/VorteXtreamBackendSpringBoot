package com.riwi.VorteXtream_BACK_END_SpringBoot.Entities;

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
@Table(name = "Cast_movie")
public class CastMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="studio_id", nullable = false)
    int studioId;

    @Column(name="cast_id", nullable = false)
    int castId;

    @Column(name="director_id", nullable = false)
    int directorId;

    @Column(name="media_id", nullable = false)
    int mediaId;
}
