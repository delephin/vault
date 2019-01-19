
package com.vault.demo.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vault.demo.domain.Location;
import com.vault.demo.repository.LocationRepository;


@RestController
public class LocationController
{
  
  @Autowired
  private LocationRepository locationRepository;
  
  @GetMapping( "/location/{id}" )
  public Optional<Location> getLocation( @PathVariable int id )
  {
    return locationRepository.findById(id);
  }
}
