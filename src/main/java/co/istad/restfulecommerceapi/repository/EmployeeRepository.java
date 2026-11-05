package co.istad.restfulecommerceapi.repository;

import co.istad.restfulecommerceapi.domain.Employee;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
@Getter
public class EmployeeRepository {

    private final List<Employee> employees;

    public EmployeeRepository(List<Employee> employees){
        this.employees = employees;
        Employee emp1 = new Employee();

        emp1.setId(1);
        emp1.setName("Tony Stark");
        emp1.setEmail("tony@gamil.com");
        emp1.setSalary(BigDecimal.valueOf(1500.00));
        emp1.setHireDate(LocalDate.of(2026, 11, 2));
        emp1.setIsActive(true);

        Employee emp2 = new Employee();

        emp2.setId(2);
        emp2.setName("Bruce Banner");
        emp2.setEmail("hulk@gamil.com");
        emp2.setSalary(BigDecimal.valueOf(2500.00));
        emp2.setHireDate(LocalDate.of(2026, 11, 2));
        emp2.setIsActive(true);

        employees.add(emp1);
        employees.add(emp2);

    }

}
