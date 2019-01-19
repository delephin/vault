
package com.vault.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vault.demo.domain.Employee;
import com.vault.demo.repository.EmployeeRepository;
import com.vault.demo.exception.EmployeeNotFoundException;


@RestController
public class EmployeeController
{
  
  @Autowired
  private EmployeeRepository employeeRepository;
  
  @GetMapping( "/employee/{id}" )
  public Employee getEmployee( @PathVariable int id )
  {
    return employeeRepository.findById(id).orElseThrow(( ) -> new EmployeeNotFoundException(id));
  }
  
  @PutMapping( "/employee/{id}" )
  public Employee updateEmployee( @PathVariable int id, final @RequestBody Employee newEmployee )
  {
    return employeeRepository.findById(id).map(innerEmployee -> {
      innerEmployee.setFirstName(newEmployee.getFirstName());
      innerEmployee.setEmail(newEmployee.getEmail());
      innerEmployee.setCommissionPct(newEmployee.getCommissionPct());
      innerEmployee.setDepartmentId(newEmployee.getDepartmentId());
      innerEmployee.setManagerId(newEmployee.getManagerId());
      innerEmployee.setPhoneNumeric(newEmployee.getPhoneNumeric());
      innerEmployee.setSalary(newEmployee.getSalary());
      return employeeRepository.save(innerEmployee);
    }).orElseThrow(( ) -> new EmployeeNotFoundException(id));
  }
  
  @DeleteMapping( "/employee/{id}" )
  public void deleteEmployee( @PathVariable int id )
  {
    employeeRepository.deleteById(id);
  }
  
  @PostMapping( "/employee" )
  public Employee createEmployee( @RequestBody Employee employee )
  {
    return employeeRepository.save(employee);
  }
}
