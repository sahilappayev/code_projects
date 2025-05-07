package org.mn.booking.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AuthRequestDto(@NotBlank String username,
                             @NotBlank String password) {
}
