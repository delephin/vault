
package com.vault.demo.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table( name = "JOB_HISTORY" )
@IdClass( JobHistoryPK.class )
public class JobHistory implements Serializable
{
  
  private static final long serialVersionUID = -5383527892869360101L;
  
  @Id
  @Column( name = "EMPLOYEE_ID" )
  public Integer            employeeId;
  
  @Id
  @Column( name = "START_DATE", nullable = false )
  public Date               startDate;
  
  @Column( name = "END_DATE", nullable = false )
  public Date               endDate;
  
  @Column( name = "JOB_ID" )
  public String             jobId;
  
  @Column( name = "DEPARTMENT_ID" )
  public Integer            departmentId;
  
  public Integer getEmployeeId()
  {
    return employeeId;
  }
  
  public void setEmployeeId( Integer employeeId )
  {
    this.employeeId = employeeId;
  }
  
  public Date getStartDate()
  {
    return startDate;
  }
  
  public void setStartDate( Date startDate )
  {
    this.startDate = startDate;
  }
  
  public Date getEndDate()
  {
    return endDate;
  }
  
  public void setEndDate( Date endDate )
  {
    this.endDate = endDate;
  }
  
  public String getJobId()
  {
    return jobId;
  }
  
  public void setJobId( String jobId )
  {
    this.jobId = jobId;
  }
  
  public Integer getDepartmentId()
  {
    return departmentId;
  }
  
  public void setDepartmentId( Integer departmentId )
  {
    this.departmentId = departmentId;
  }
  
}
