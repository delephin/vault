
package com.vault.demo.repository;


import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vault.demo.domain.Department;
import com.vault.demo.domain.Employee;
import com.vault.demo.domain.FullEmployee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
  
  List<Employee> findByDepartmentId( Integer departmentId );
  
  List<Employee> findByDepartmentIdIn( Collection<Integer> departments );
  
}
