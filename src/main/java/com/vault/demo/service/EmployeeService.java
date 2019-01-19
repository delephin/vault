
package com.vault.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vault.demo.domain.FullEmployee;
import com.vault.demo.repository.EmployeeRepository;
import com.vault.demo.repository.FullEmployeeRepository;
import com.vault.demo.repository.JobRepository;


@RestController
public class EmployeeService
{
  
  @Autowired
  private FullEmployeeRepository fullEmployeeRepository;
  
  @Autowired
  private EmployeeRepository     employeeRepository;
  
  @Autowired
  private JobRepository          jobRepository;
  
  @GetMapping( "/employees" )
  public List<FullEmployee> getEmployee( Pageable p, @RequestParam( value = "jobId" ) Optional<String> jobId, @RequestParam( value = "lastName" ) Optional<String> lastName, @RequestParam( value = "managerId" ) Optional<Integer> managerId )
  {
    
    Sort sort = Sort.by("hireDate").ascending();
    
    List<FullEmployee> result;
    if (jobId.isPresent() && managerId.isPresent() && lastName.isPresent())
    {
      result = fullEmployeeRepository.findEmployeesByJobIdAndLastNameAndManagerId(sort, jobRepository.findById(jobId.get()).get(), employeeRepository.findById(managerId.get()).get(), lastName.get());
    }
    else if (jobId.isPresent() && managerId.isPresent())
    {
      result = fullEmployeeRepository.findEmployeesByJobIdAndManagerId(sort, jobRepository.findById(jobId.get()).get(), employeeRepository.findById(managerId.get()).get());
    }
    else if (jobId.isPresent() && lastName.isPresent())
    {
      result = fullEmployeeRepository.findEmployeesByJobIdAndLastName(sort, jobRepository.findById(jobId.get()).get(), lastName.get());
    }
    else if (managerId.isPresent() && lastName.isPresent())
    {
      result = fullEmployeeRepository.findEmployeesByLastNameAndManagerId(sort, employeeRepository.findById(managerId.get()).get(), lastName.get());
    }
    else if (managerId.isPresent())
    {
      result = fullEmployeeRepository.findByManagerId(sort, employeeRepository.findById(managerId.get()).get().getId());
    }
    else if (jobId.isPresent())
    {
      result = fullEmployeeRepository.findByJobId(sort, jobRepository.findById(jobId.get()).get().getId());
    }
    else
    {
      result = fullEmployeeRepository.findByLastName(sort, lastName.get());
    }
    
    int offset = (int) p.getOffset();
    int limit = (((offset + p.getPageSize()) <= result.size()) ? (offset + p.getPageSize()) : result.size());
    
    if (offset > result.size() || limit < offset) return new ArrayList<FullEmployee>();
    
    return result.subList(offset, limit);
  }
}
