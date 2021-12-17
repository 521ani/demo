package com.aacademy.gitdemo.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    @Length(min = 10, max = 10)
    private String ucn;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private Integer age;

    @OneToMany(mappedBy = "owner")
    private Set<Cat> cats;
}
