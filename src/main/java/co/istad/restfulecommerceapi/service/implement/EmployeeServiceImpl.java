package co.istad.restfulecommerceapi.service.implement;

import co.istad.restfulecommerceapi.domain.Employee;
import co.istad.restfulecommerceapi.dto.CreateEmployeeRequest;
import co.istad.restfulecommerceapi.dto.EmployeeResponse;
import co.istad.restfulecommerceapi.dto.UpdateEmployeeRequest;
import co.istad.restfulecommerceapi.mapper.EmployeeMapper;
import co.istad.restfulecommerceapi.repository.EmployeeRepository;
import co.istad.restfulecommerceapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

//    in the class it call bean
    // Service work by inject repository bean by constructor (cus service handle business logic to work
    // by need data and data has in repo)
    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Override
    public List<EmployeeResponse> getAll() {
        return repository.getEmployees()
                .stream()
                .map(mapper::toResponse)
                // lambda expression emp -> mapper.toResponse(emp)
                .toList();
    }

    @Override
    public EmployeeResponse getEmployeeById(Integer id) {

        return repository.getEmployees()
                .stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .map(mapper::toResponse)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Employee with id: %d Not Found".formatted(id)
                        )
                );
    }

    @Override
    public EmployeeResponse createEmployee(CreateEmployeeRequest employeeRequest) {

        if (checkEmailExit(employeeRequest.email())){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email is exits"
            );
        }

        Employee employee = mapper.fromCreateEmployeeRequest(employeeRequest);
        employee.setId(repository.getEmployees().size() + 1);
        employee.setIsActive(true);
        repository.getEmployees().add(employee);
        return mapper.toResponse(employee);
    }

    @Override
    public EmployeeResponse updateEmployee(Integer id, UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = repository.getEmployees()
                .stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Employee with id: %d Not Found".formatted(id)
                        )
                );
        mapper.updateEmployeeFromRequest(updateEmployeeRequest, employee);
        return mapper.toResponse(employee);
    }


    @Override
    public void deleteEmployeeById(Integer id) {
        Employee employee = repository.getEmployees()
                .stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Employee with id :%d Not found".formatted(id)
                        )
                );
        repository.getEmployees().remove(employee);
    }


    private boolean checkEmailExit(String email){
        return repository.getEmployees()
                .stream()
                .anyMatch(emp -> emp.getEmail().equals(email));
    }
}
