package com.example.ecommerce.dtos;

import com.example.ecommerce.utils.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class UserProfileDTO {
    @NotNull
    protected Long id;

    @NotNull
    protected String name;

    @NotNull
    @Length(min = 10, max = 10)
    @Column(unique = true)
    protected String tel;

    @NotNull
    protected String address;

    @NotNull
    @Enumerated(EnumType.STRING)
    protected Gender gender;
}
