
package com.vault.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vault.demo.domain.FullEmployee;


@Repository
public interface FullEmployeeRepository extends JpaRepository<FullEmployee, Integer>
{
  
}
