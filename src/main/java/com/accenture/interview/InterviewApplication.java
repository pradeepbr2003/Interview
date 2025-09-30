package com.accenture.interview;

import com.accenture.interview.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterviewApplication {
    @Autowired
    private EmployeeService empService;

    public static void main(String[] args) {
        SpringApplication.run(InterviewApplication.class, args);
    }

    @PostConstruct
    public void loadData() {
        empService.loadEmployees();
    }

}
