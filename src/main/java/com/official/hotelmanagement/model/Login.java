package com.official.hotelmanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("Login")
public record Login(
        @Id Integer id,
        String username,
        String password
) {
}
