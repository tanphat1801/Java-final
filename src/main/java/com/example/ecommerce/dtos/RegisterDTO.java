package com.example.ecommerce.dtos;

import com.example.ecommerce.models.User;
import com.example.ecommerce.utils.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
@Getter
@Setter
@ToString
public class RegisterDTO extends UserProfileDTO {
    @Value("${some.key}:ROLE_USER")
    String role;

    @NotNull
    @Length(min = 6, max = 16)
    String password;

    @NotNull
    @Length(min = 6, max = 16)
    String passwordConfirm;

    public User copy() {
        User user = new User();

        user.setId(this.id);
        user.setRole(this.role);
        user.setName(this.name);
        user.setTel(this.tel);
        user.setAddress(this.address);
        user.setPassword(this.password);
        user.setGender(this.gender);

        return user;
    }
}