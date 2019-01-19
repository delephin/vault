
package com.vault.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vault.demo.domain.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>
{
  
  List<Department> findByLocationId( Integer locationId );
}
