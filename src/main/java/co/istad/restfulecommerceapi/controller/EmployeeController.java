package co.istad.restfulecommerceapi.controller;

import co.istad.restfulecommerceapi.dto.CreateEmployeeRequest;
import co.istad.restfulecommerceapi.dto.EmployeeResponse;
import co.istad.restfulecommerceapi.dto.UpdateEmployeeRequest;
import co.istad.restfulecommerceapi.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping
    public List<EmployeeResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("{id}")
    public EmployeeResponse getEmployeeById(@PathVariable Integer id){
        return service.getEmployeeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponse createEmployeeRequest(
            @Valid @RequestBody CreateEmployeeRequest createEmployeeRequest){
        return service.createEmployee(createEmployeeRequest);
    }

    @PatchMapping("{id}")
    public EmployeeResponse updateEmployee(
            @PathVariable Integer id,
            @RequestBody UpdateEmployeeRequest updateEmployeeRequest){
        return service.updateEmployee(id, updateEmployeeRequest);
    }

    @DeleteMapping("{id}")
    public void deleteEmployeeById(
          @PathVariable  Integer id

    ){
        service.deleteEmployeeById(id);
    }
}
