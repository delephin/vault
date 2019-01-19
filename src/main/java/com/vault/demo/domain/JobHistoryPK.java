
package com.vault.demo.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Embeddable;


@Embeddable
public class JobHistoryPK implements Serializable
{
  
  protected Integer employeeId;
  protected Date    startDate;
  
  public JobHistoryPK()
  {
  }
  
  public JobHistoryPK( Integer employeeId, Date startDate )
  {
    super();
    this.employeeId = employeeId;
    this.startDate = startDate;
  }
  
  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
    result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
    return result;
  }
  
  @Override
  public boolean equals( Object obj )
  {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    JobHistoryPK other = (JobHistoryPK) obj;
    if (employeeId == null)
    {
      if (other.employeeId != null) return false;
    }
    else if (!employeeId.equals(other.employeeId)) return false;
    if (startDate == null)
    {
      if (other.startDate != null) return false;
    }
    else if (!startDate.equals(other.startDate)) return false;
    return true;
  }
  
  @Override
  public String toString()
  {
    return "JobHistoryPK [employeeId=" + employeeId + ", startDate=" + startDate + "]";
  }
  
}