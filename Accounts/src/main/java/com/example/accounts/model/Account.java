package com.example.accounts.model;

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
@Table(name = "ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;

    private String accountType;

    private String accNumber;
    private String accountName;
    private String balance;

    @CreationTimestamp
    @Column(name = "date", updatable = false)
    private Timestamp timestamp;
}
