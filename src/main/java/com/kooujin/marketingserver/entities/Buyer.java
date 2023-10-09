package com.kooujin.marketingserver.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
@Getter
@Setter
public class Buyer implements Serializable {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid")
    private UUID id;

    private String name;

    private String email;

    private String cpf;

    private boolean isPremium = false;

    private boolean isAdmin = false;


    private boolean boughtCupom = false;

    public Buyer(UUID id, String name, String email, String cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public Buyer(String name, String email, String cpf) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public Buyer(String name, String email) {
        this.name = name;
        this.email = email;
        this.cpf = "";
    }

    public Buyer() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return Objects.equals(id, buyer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
