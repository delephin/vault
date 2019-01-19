
package com.vault.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vault.demo.domain.JobHistory;


@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, String>
{
  
}
