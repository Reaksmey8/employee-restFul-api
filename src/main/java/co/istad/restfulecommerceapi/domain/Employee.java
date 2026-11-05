package co.istad.restfulecommerceapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Employee {

    private static int nextId = 3;

    private Integer id;

    private String name;

    private String email;

    private BigDecimal salary;

    private LocalDate hireDate;

    private Boolean isActive;

    public Employee(String name, String email, BigDecimal salary, LocalDate hireDate, Boolean isActive) {
        this.id = nextId++;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.hireDate = hireDate;
        this.isActive = Boolean.TRUE;
    }
}
