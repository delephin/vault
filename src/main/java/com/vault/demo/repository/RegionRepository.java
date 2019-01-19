
package com.vault.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vault.demo.domain.Region;


@Repository
public interface RegionRepository extends JpaRepository<Region, Integer>
{
  
}
