
package com.vault.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vault.demo.domain.Country;


@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>
{
  
}
