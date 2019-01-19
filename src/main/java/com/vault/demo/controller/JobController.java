
package com.vault.demo.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vault.demo.domain.Job;
import com.vault.demo.repository.JobRepository;


@RestController
public class JobController
{
  
  @Autowired
  private JobRepository jobRepository;
  
  @GetMapping( "/job/{id}" )
  public Optional<Job> getJob( @PathVariable String id )
  {
    return jobRepository.findById(id);
  }
}
