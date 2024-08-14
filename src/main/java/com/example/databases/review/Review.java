package com.example.databases.review;

import com.example.databases.company.Company;
import jakarta.persistence.*;

@Entity
public class Review {
    public Review() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String discription;

}
