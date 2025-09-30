package com.accenture.interview.controller;

import com.accenture.interview.config.ErrorMessageConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/errorMessage1")
public class ErrorController1 {

    @Autowired
    private ErrorMessageConfig errorMsgConfig;

    @GetMapping
    public Map<String, String> getErrorMessage() {
        Map map = Map.of("empId", errorMsgConfig.getEmpIdRegEx(), "empName", errorMsgConfig.getEmpNameRegEx(), "salary", errorMsgConfig.getSalaryRegEx(), "company", errorMsgConfig.getCompRegEx());
        return map;
    }
}
