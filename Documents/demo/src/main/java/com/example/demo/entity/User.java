package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "full_name")
    private String fullName;

    private String phone;

    private String email;

    private String address;

    @Transient
    private String departmentName;

    public User(final Long id, final String fullName, final String email, final String departmentName) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.departmentName = departmentName;
    }
}
