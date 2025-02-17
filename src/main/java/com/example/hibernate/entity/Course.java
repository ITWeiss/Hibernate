package com.example.hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "courses", schema = "company")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
    public Course() {
        this.students = new HashSet<>();
    }
}
