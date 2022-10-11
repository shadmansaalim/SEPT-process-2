package com.example.persons.personModel;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@ToString
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;

    private String name;
    private String address;
    private String postcode;
    private String age;
    private String job;
    private String email;
    private String phoneno;
}