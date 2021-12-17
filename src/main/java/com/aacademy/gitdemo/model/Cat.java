package com.aacademy.gitdemo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "cats")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(
            name = "person_id",
            foreignKey = @ForeignKey(name = "fk_person_id")
    )
    private Person owner;
}
