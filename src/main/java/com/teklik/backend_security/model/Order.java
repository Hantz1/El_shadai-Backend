package com.teklik.backend_security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String codesale;

    private String products;

    @Column(name = "qty")
    private int amount;

    private float totalsale;

    private String salesperson;

    private String customer;

    private String status;

    private String datesale;
}
