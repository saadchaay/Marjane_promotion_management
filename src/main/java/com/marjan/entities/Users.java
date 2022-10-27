package com.marjan.entities;

import com.marjan.helpers.EnumValues;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Users {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "role", nullable = false)
    private String role;

    @Basic
    @Column(name = "store_id", nullable = false)
    private int storeId;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Stores storesByStoreId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (storeId != users.storeId) return false;
        if (!Objects.equals(email, users.email)) return false;
        if (!Objects.equals(password, users.password)) return false;
        return Objects.equals(role, users.role);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + storeId;
        return result;
    }

    public Stores getStoresByStoreId() {
        return storesByStoreId;
    }

    public void setStoresByStoreId(Stores storesByStoreId) {
        this.storesByStoreId = storesByStoreId;
    }
}
