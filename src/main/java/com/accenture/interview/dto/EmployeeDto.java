package com.accenture.interview.dto;

import com.accenture.interview.validator.ValidateEmpId;
import com.accenture.interview.validator.ValidateEmpName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {

    @ValidateEmpId(message = "{error.empIdRegEx}")
    private Long empId;

    @ValidateEmpName(message = "{error.empNameRegEx}")
    private String empName;

    @ValidateEmpName(message = "{error.compRegEx}")
    private String comp;

    @ValidateEmpId(message = "{error.salaryRegEx}")
    private double salary;
}
