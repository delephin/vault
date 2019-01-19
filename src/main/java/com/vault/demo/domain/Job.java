
package com.vault.demo.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table( name = "JOBS" )
public class Job
{
  
  @Id
  @Column( name = "JOB_ID" )
  public String  id;
  
  @Column( name = "JOB_TITLE", nullable = false )
  public String  jobTitle;
  
  @Column( name = "MIN_SALARY" )
  public Integer minSalary;
  
  @Column( name = "MAX_SALARY" )
  public Integer maxSalary;
  
  public String getId()
  {
    return id;
  }
  
  public void setId( String id )
  {
    this.id = id;
  }
  
  public String getJobTitle()
  {
    return jobTitle;
  }
  
  public void setJobTitle( String jobTitle )
  {
    this.jobTitle = jobTitle;
  }
  
  public Integer getMinSalary()
  {
    return minSalary;
  }
  
  public void setMinSalary( Integer minSalary )
  {
    this.minSalary = minSalary;
  }
  
  public Integer getMaxSalary()
  {
    return maxSalary;
  }
  
  public void setMaxSalary( Integer maxSalary )
  {
    this.maxSalary = maxSalary;
  }
  
}
