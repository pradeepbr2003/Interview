package com.accenture.interview.util;

import com.accenture.interview.dto.EmployeeDto;
import com.accenture.interview.enums.CompanyEnum;
import com.accenture.interview.enums.EmpNameEnum;
import com.accenture.interview.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class EmployeeUtil {
    private static Random random = new Random();
    private static EmpNameEnum[] names = EmpNameEnum.values();
    private static CompanyEnum[] companies = CompanyEnum.values();

    public void update(EmployeeDto employeeDto, Employee employee) {
        if (employeeDto.getEmpName() != null) employee.setEmpName(employeeDto.getEmpName());
        if (employeeDto.getComp() != null) employee.setComp(employeeDto.getComp());
        if (employeeDto.getSalary() != 0) employee.setSalary(employeeDto.getSalary());
    }

    public EmployeeDto convertToDto(Employee employee) {
        EmployeeDto employeeDto = EmployeeDto.builder().empId(employee.getEmpId())
                .empName(employee.getEmpName()).comp(employee.getComp()).salary(employee.getSalary()).build();
        return employeeDto;
    }

    public List<Employee> loadAllEmployees() {
        return IntStream.range(0, EmpNameEnum.values().length).mapToObj(this::getEmployee).toList();
    }

    private Employee getEmployee(int index) {
        return Employee.builder().empName(names[index].name()).comp(companies[index].name()).salary(random.nextDouble(1000.12, 10000.32)).build();
    }
}
