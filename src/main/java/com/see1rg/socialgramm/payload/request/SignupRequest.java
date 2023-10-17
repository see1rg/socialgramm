package com.see1rg.socialgramm.payload.request;

import com.see1rg.socialgramm.annotations.PasswordMatches;
import com.see1rg.socialgramm.annotations.ValidEmail;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@PasswordMatches
public class SignupRequest {
    @NotEmpty(message = "Username is required")
    private String username;
    @NotEmpty(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 8 characters")
    private String password;
    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    @ValidEmail
    private String email;
    @NotEmpty(message = "First name is required")
    private String firstname;
    @NotEmpty(message = "Last name is required")
    private String lastname;
    @NotEmpty(message = "Confirm password is required")
    private String confirmPassword;
}
