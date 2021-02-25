package com.cisco.code.controller;


import com.cisco.code.ResourceNotFoundException;
import com.cisco.code.model.User;
import com.cisco.code.repository.HelloWorldRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class HelloWorldController {

    @Autowired
    private HelloWorldRespository helloWorldRespository;

    @RequestMapping
    String home() {
        return "Hello World Spring Boot from ci-cd instance!";
    }

    @GetMapping("/echo")
    public String echo() {
        return "Welcome to Deepa's CI/CD world ";
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllEmployees() {
        return ResponseEntity.ok(helloWorldRespository.findAll());
    }

    @PostMapping("/user")
    public User add(@RequestBody User user) {
        return helloWorldRespository.save(user);
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<User> findEmployeeById(@PathVariable(value = "id") Integer employeeId) {
        User employee = helloWorldRespository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found" + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateEmployee(@PathVariable(value = "id") Integer employeeId,
                                               @RequestBody User employeeDetails) {
        User employee = helloWorldRespository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        employee.setName(employeeDetails.getName());
        final User updatedEmployee = helloWorldRespository.save(employee);
        return ResponseEntity.ok(updatedEmployee);

    }
}
