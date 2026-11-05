package co.istad.restfulecommerceapi.mapper;

import co.istad.restfulecommerceapi.domain.Employee;
import co.istad.restfulecommerceapi.dto.CreateEmployeeRequest;
import co.istad.restfulecommerceapi.dto.EmployeeResponse;
import co.istad.restfulecommerceapi.dto.UpdateEmployeeRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    // Map from Domain to DTO
    EmployeeResponse toResponse(Employee employee);

    // Map from DTO to domain
    Employee fromCreateEmployeeRequest(CreateEmployeeRequest employeeRequest);

    // update exiting employee obj
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployeeFromRequest(UpdateEmployeeRequest request, @MappingTarget Employee employee);

}
