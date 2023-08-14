package com.anand.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MyErrorDetails {
	 private LocalDateTime time;
	 private String message;
	 private String details;
}
