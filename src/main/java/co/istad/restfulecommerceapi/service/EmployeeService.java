package co.istad.restfulecommerceapi.service;

import co.istad.restfulecommerceapi.domain.Employee;
import co.istad.restfulecommerceapi.dto.CreateEmployeeRequest;
import co.istad.restfulecommerceapi.dto.EmployeeResponse;
import co.istad.restfulecommerceapi.dto.UpdateEmployeeRequest;

import java.util.List;

public interface EmployeeService {
    // write abstruct methods
    // CRUD = CREATE, READ, UDATE, DELETE
    List<EmployeeResponse> getAll();
    EmployeeResponse getEmployeeById(Integer id);

    EmployeeResponse createEmployee(CreateEmployeeRequest employeeRequest);

    // Update & Delete
    EmployeeResponse updateEmployee(Integer id, UpdateEmployeeRequest updateEmployeeRequest);
    void deleteEmployeeById(Integer id);

}
