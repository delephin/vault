
package com.vault.demo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
  Page<FullEmployee> findEmployeesByJobIdAndLastNameAndManagerId( Pageable paramPageable, @Param( "job" ) Job job, @Param( "manager" ) Employee manager, @Param( "lastName" ) String lastName );
  
  @Query( "select e from FullEmployee e where e.job = :job and e.manager = :manager " )
  Page<FullEmployee> findEmployeesByJobIdAndManagerId( Pageable paramPageable, @Param( "job" ) Job job, @Param( "manager" ) Employee manager );
  
  @Query( "select e from FullEmployee e where e.job = :job and e.lastName = :lastName" )
  Page<FullEmployee> findEmployeesByJobIdAndLastName( Pageable paramPageable, @Param( "job" ) Job job, @Param( "lastName" ) String lastName );
  
  @Query( "select e from FullEmployee e where e.manager = :manager and e.lastName = :lastName" )
  Page<FullEmployee> findEmployeesByLastNameAndManagerId( Pageable paramPageable, @Param( "manager" ) Employee manager, @Param( "lastName" ) String lastName );
  
  Page<FullEmployee> findByManagerId( Pageable paramPageable, Integer managerId );
  
  Page<FullEmployee> findByJobId( Pageable paramPageable, String jobId );
  
  Page<FullEmployee> findByLastName( Pageable paramPageable, String lastName );
}
