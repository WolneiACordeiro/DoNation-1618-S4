package com.donation1618.donation.domain.dto.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FieldMessage {
    private String fieldName;
    private String message;
}
