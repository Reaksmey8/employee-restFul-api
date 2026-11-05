package co.istad.restfulecommerceapi.exception;

import lombok.Builder;

@Builder
public record FieldErrorResponse(

        String field,

        String message

) {
}
