
package com.vault.demo.controller;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vault.demo.domain.Department;
import com.vault.demo.exception.ActionNotAllowed;
import com.vault.demo.repository.DepartmentRepository;
import com.vault.demo.repository.EmployeeRepository;
import com.vault.demo.repository.LocationRepository;


@RestController
public class DepartmentController
{
  
  @Autowired
  private DepartmentRepository departmentRepository;
  
  @Autowired
  private LocationRepository   locationRepository;
  
  @Autowired
  private EmployeeRepository   employeeRepository;
  
  @GetMapping( "/department/{id}" )
  public Optional<Department> getDepartment( @PathVariable int id )
  {
    return departmentRepository.findById(id);
  }
  
  @GetMapping( "/location/{locationId}/departments" )
  public List<Department> getAllDepartmentsByLocationId( @PathVariable( value = "locationId" ) int locationId )
  {
    return departmentRepository.findByLocationId(locationId);
  }
  
  @PostMapping( "/department" )
  public Department createDepartment( @RequestBody Department department )
  {
    List<Integer> deptos = departmentRepository.findByLocationId(department.getLocation().getId()).stream().map(Department::getId).collect(Collectors.toList());
    
    Double averageSalary = employeeRepository.findByDepartmentIdIn(deptos).stream().mapToDouble(e -> e.getSalary()).average().orElse(0.0);
    
    LocalDate ld = LocalDate.now();
    int dayOfMonth = ld.getDayOfMonth();
    
    if (averageSalary <= 1000) return departmentRepository.save(department);
    
    if (dayOfMonth <= 14 || averageSalary > 1500)
    {
      throw new ActionNotAllowed("Department wasn't created. Average Salary [" + averageSalary + "] Current Day [" + dayOfMonth + "]");
    }
    
    return departmentRepository.save(department);
  }
}
