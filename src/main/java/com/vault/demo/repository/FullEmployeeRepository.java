
package com.vault.demo.repository;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vault.demo.domain.Employee;
import com.vault.demo.domain.FullEmployee;
import com.vault.demo.domain.Job;


@Repository
public interface FullEmployeeRepository extends JpaRepository<FullEmployee, Integer>
{
  
  @Query( "select e from FullEmployee e where e.job = :job and e.manager = :manager and e.lastName = :lastName" )
  List<FullEmployee> findEmployeesByJobIdAndLastNameAndManagerId( Sort paramSort, @Param( "job" ) Job job, @Param( "manager" ) Employee manager, @Param( "lastName" ) String lastName );
  
  @Query( "select e from FullEmployee e where e.job = :job and e.manager = :manager " )
  List<FullEmployee> findEmployeesByJobIdAndManagerId( Sort paramSort, @Param( "job" ) Job job, @Param( "manager" ) Employee manager );
  
  @Query( "select e from FullEmployee e where e.job = :job and e.lastName = :lastName" )
  List<FullEmployee> findEmployeesByJobIdAndLastName( Sort paramSort, @Param( "job" ) Job job, @Param( "lastName" ) String lastName );
  
  @Query( "select e from FullEmployee e where e.manager = :manager and e.lastName = :lastName" )
  List<FullEmployee> findEmployeesByLastNameAndManagerId( Sort paramSort, @Param( "manager" ) Employee manager, @Param( "lastName" ) String lastName );
  
  List<FullEmployee> findByManagerId( Sort paramSort, Integer managerId );
  
  List<FullEmployee> findByJobId( Sort paramSort, String jobId );
  
  List<FullEmployee> findByLastName( Sort paramSort, String lastName );
}
