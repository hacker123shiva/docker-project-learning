package com.spring.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usersDetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

@Column(unique = true)
private String userName;
private String password;
private String role;
}
