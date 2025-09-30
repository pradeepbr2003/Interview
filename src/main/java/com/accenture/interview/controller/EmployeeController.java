package com.accenture.interview.controller;

import com.accenture.interview.dto.EmployeeDto;
import com.accenture.interview.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @PostMapping
    public EmployeeDto addEmployee(@Valid EmployeeDto employee) {
        return empService.addEmployee(employee);
//        return empService.rollBackExample(employee);
    }

    @PutMapping
    public EmployeeDto updateEmployee(@Valid EmployeeDto employee) {
        return empService.updateEmployee(employee);
    }

    @GetMapping
    public List<EmployeeDto> getEmployees() {
        return empService.getAllEmployees();
    }

    @GetMapping("/{empId}")
    public EmployeeDto getEmployee(@PathVariable Long empId) {
        return empService.getEmployee(empId);
    }

    @DeleteMapping("/{empId}")
    public String deleteEmployee(@PathVariable Long empId) {
        EmployeeDto employee = empService.removeEmployee(empId);
        return String.format("Successfully deleted Employee %s %n", employee.getEmpName());
    }
}
