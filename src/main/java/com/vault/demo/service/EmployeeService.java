
package com.vault.demo.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
  public Page<FullEmployee> getEmployee( Pageable p, @RequestParam( value = "jobId" ) Optional<String> jobId, @RequestParam( value = "lastName" ) Optional<String> lastName, @RequestParam( value = "managerId" ) Optional<Integer> managerId )
  {
    
    System.out.println(p.getPageSize() + " : " + p.getOffset() + " : " + p.getPageNumber() + " jobId: " + jobId + " lastName: " + lastName + " managerId:" + managerId);
    if (jobId.isPresent() && managerId.isPresent() && lastName.isPresent())
    {
      return fullEmployeeRepository.findEmployeesByJobIdAndLastNameAndManagerId(p, jobRepository.findById(jobId.get()).get(), employeeRepository.findById(managerId.get()).get(), lastName.get());
    }
    else if (jobId.isPresent() && managerId.isPresent())
    {
      return fullEmployeeRepository.findEmployeesByJobIdAndManagerId(p, jobRepository.findById(jobId.get()).get(), employeeRepository.findById(managerId.get()).get());
    }
    else if (jobId.isPresent() && lastName.isPresent())
    {
      return fullEmployeeRepository.findEmployeesByJobIdAndLastName(p, jobRepository.findById(jobId.get()).get(), lastName.get());
    }
    else if (managerId.isPresent() && lastName.isPresent())
    {
      return fullEmployeeRepository.findEmployeesByLastNameAndManagerId(p, employeeRepository.findById(managerId.get()).get(), lastName.get());
    }
    else if (managerId.isPresent())
    {
      return fullEmployeeRepository.findByManagerId(p, employeeRepository.findById(managerId.get()).get().getId());
    }
    else if (jobId.isPresent())
    {
      return fullEmployeeRepository.findByJobId(p, jobRepository.findById(jobId.get()).get().getId());
    }
    
    return fullEmployeeRepository.findByLastName(p, lastName.get());
    
  }
}
