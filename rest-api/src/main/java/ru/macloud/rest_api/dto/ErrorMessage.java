package ru.macloud.rest_api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class ErrorMessage {

    private String description;

}
