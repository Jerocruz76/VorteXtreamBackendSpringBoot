package com.riwi.VorteXtream_BACK_END_SpringBoot.Domain.Entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="images")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String original_filename;

    @Column(name = "image_url", nullable = false)
    private String url;

    @Column(name = "image_id", nullable = false)
    private String public_id;

    public ImageEntity(String originalFilename, String url, String publicId) {
        this.original_filename = originalFilename;
        this.url = url;
        this.public_id=publicId;
    }
}
