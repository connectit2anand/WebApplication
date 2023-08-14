package com.anand.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Route {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeID;

    @NotNull(message = "Start point cannot be null !")
    private String routeFrom;

	@NotNull(message = "Destination point cannot be null !")
    private String routeTo;
	
	@NotNull(message = "distance cannot be null")
    private Integer distance;

    @JsonIgnore
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<Bus> busList = new ArrayList<>();
   
}
