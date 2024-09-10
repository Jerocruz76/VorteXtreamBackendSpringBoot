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
@Table(name = "directors")
public class Directors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "age", nullable = false)
    int age;

    @Column(name = "synopsis", nullable = false)
    String synopsis;

    @Column(name = "nationality", nullable = false)
    String nationality;

}
