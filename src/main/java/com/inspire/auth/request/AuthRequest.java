package com.inspire.auth.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data@Builder
public class AuthRequest {
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,5}",
            flags = Pattern.Flag.CASE_INSENSITIVE,message = "Email Invalid")
    @NotNull(message = "email is required")
    private String email;
    @NotNull(message = "password is required")
    @Size(min = 4, message = "Password must be at least 4 characters long")
    private String password;

}
