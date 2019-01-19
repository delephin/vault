
package com.vault.demo.service;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vault.demo.domain.FullEmployee;
import com.vault.demo.domain.extra.EmployeeSpecificationsBuilder;
import com.vault.demo.repository.FullEmployeeRepository;


@RestController
public class EmployeeService
{
  
  @Autowired
  private FullEmployeeRepository employeeRepository;
  
  // @Autowired
  // private JobRepository jobRepository;
  //
  // @Autowired
  // private DepartmentRepository departmentRepository;
  //
  // @GetMapping( "/employee/all" )
  // public Page<FullEmployee> getEmployee( Pageable p )
  // {
  //
  // System.out.println(p.getPageSize() + " : " + p.getOffset() + " : " + p.getPageNumber());
  // Page<FullEmployee> r = employeeRepository.findAll(p).map(e -> {
  // FullEmployee fe = new FullEmployee(e);
  // jobRepository.findById(e.getJobId()).ifPresent(j -> fe.setJob(j));
  // employeeRepository.findById(e.getManagerId()).ifPresent(m -> fe.setManager(m));
  //
  // departmentRepository.findById(e.getDepartmentId()).ifPresent(d -> {
  // fe.setDepartment(d);
  // });
  // return fe;
  // });
  //
  // return r;
  // }
  
  // @GetMapping( "/employees/{jobId}/manager/{managerId}/last_name/{lastName}" )
  // public Page<FullEmployee> getEmployee( Pageable p, String jobId, Integer managerId, String lastName )
  
  @GetMapping( "/employees" )
  public Page<FullEmployee> getEmployee( Pageable p, @RequestParam( value = "search" ) String search )
  {
    System.out.println(p.getPageSize() + " : " + p.getOffset() + " : " + p.getPageNumber());
    
    EmployeeSpecificationsBuilder builder = new EmployeeSpecificationsBuilder();
    Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
    Matcher matcher = pattern.matcher(search + ",");
    while (matcher.find())
    {
      builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
    }
    
    Specification<FullEmployee> spec = builder.build();
    
    return employeeRepository.findAll(p);
    
  }
}
