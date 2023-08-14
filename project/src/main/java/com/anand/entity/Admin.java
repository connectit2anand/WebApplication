package com.anand.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity(name="Admin")
@Data
public class Admin {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminID;

    @NotNull(message="name cannot be null")
    private String name;

    @Email
    private String email;

    @Min(8)
    private String password;
}
