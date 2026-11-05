package co.istad.restfulecommerceapi.dto;

import java.time.LocalDate;

public record UpdateEmployeeRequest(

        String name,
        String email,
        String salary,
        LocalDate hireDate

) {
}
