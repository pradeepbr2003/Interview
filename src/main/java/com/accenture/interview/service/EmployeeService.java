package com.accenture.interview.service;

import com.accenture.interview.dto.EmployeeDto;
import com.accenture.interview.jpa.EmployeeRepository;
import com.accenture.interview.model.Employee;
import com.accenture.interview.util.EmployeeUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    @Autowired
    private EmployeeUtil employeeUtil;


    public List<EmployeeDto> saveAllEmployee(List<Employee> employeeList) {
        return empRepo.saveAll(employeeList).stream().map(employeeUtil::convertToDto).toList();
    }

    public void loadEmployees() {
        saveAllEmployee(employeeUtil.loadAllEmployees());
    }

    public List<EmployeeDto> getAllEmployees() {
        return empRepo.findAll().stream().map(employeeUtil::convertToDto).toList();
    }

    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee emp = Employee.builder().empName(employeeDto.getEmpName()).comp(employeeDto.getComp())
                .salary(employeeDto.getSalary()).build();
        Employee employee = empRepo.save(emp);
//        if (employee != null) throw new RuntimeException("To demonstrate roll back ");
        return employeeUtil.convertToDto(employee);
    }

    @Transactional
    public EmployeeDto rollBackExample(EmployeeDto employeeDto) {
        Employee emp = Employee.builder().empName(employeeDto.getEmpName()).comp(employeeDto.getComp())
                .salary(employeeDto.getSalary()).build();
        Employee employee = empRepo.save(emp);
        if (employee != null) throw new RuntimeException("To demonstrate roll back ");
        return employeeUtil.convertToDto(employee);
    }

    public EmployeeDto getEmployee(long empId) {
        Employee employee = empRepo.findById(empId)
                .orElseThrow(() -> new RuntimeException(String.format("%n Employee with %d not found %n", empId)));
        return employeeUtil.convertToDto(employee);
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee employee = empRepo.findById(employeeDto.getEmpId())
                .orElseThrow(() -> new RuntimeException(String.format("%n Employee with %d not found %n", employeeDto.getEmpId())));
        employeeUtil.update(employeeDto, employee);
        Employee emp = empRepo.save(employee);
        return employeeUtil.convertToDto(emp);
    }

    public EmployeeDto removeEmployee(Long empId) {
        Employee employee = empRepo.findById(empId)
                .orElseThrow(() -> new RuntimeException(String.format("%n Employee with %d not found %n", empId)));
        empRepo.delete(employee);
        return employeeUtil.convertToDto(employee);
    }

}
