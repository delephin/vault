
package com.vault.demo.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vault.demo.domain.Region;
import com.vault.demo.repository.RegionRepository;


@RestController
public class RegionController
{
  
  @Autowired
  private RegionRepository regionRepository;
  
  @GetMapping( "/region/{id}" )
  public Optional<Region> getRegion( @PathVariable int id )
  {
    return regionRepository.findById(id);
  }
}
