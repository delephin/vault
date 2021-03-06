
package com.vault.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vault.demo.domain.Job;


@Repository
public interface JobRepository extends JpaRepository<Job, String>
{
  
}
