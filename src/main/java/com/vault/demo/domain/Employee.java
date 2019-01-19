
package com.vault.demo.domain;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table( name = "EMPLOYEES" )
public class Employee
{
  
  @Id
  @Column( name = "EMPLOYEE_ID" )
  @GeneratedValue( strategy = GenerationType.IDENTITY )
  public Integer id;
  
  @Column( name = "FIRST_NAME" )
  public String  firstName;
  
  @Column( name = "LAST_NAME", nullable = false )
  public String  lastName;
  
  @Column( nullable = false )
  public String  email;
  
  @Column( name = "PHONE_NUMERIC" )
  public String  phoneNumeric;
  
  @Column( name = "HIRE_DATE", nullable = false )
  public Date    hireDate;
  
  @Column( name = "JOB_ID", nullable = false )
  public String  jobId;
  
  public Float   salary;
  
  @Column( name = "COMMISSION_PCT" )
  public Float   commissionPct;
  
  @Column( name = "MANAGER_ID" )
  public Integer managerId;
  
  @Column( name = "DEPARTMENT_ID" )
  public Integer departmentId;
  
  public Integer getId()
  {
    return id;
  }
  
  public void setId( Integer id )
  {
    this.id = id;
  }
  
  public String getFirstName()
  {
    return firstName;
  }
  
  public void setFirstName( String firstName )
  {
    this.firstName = firstName;
  }
  
  public String getLastName()
  {
    return lastName;
  }
  
  public void setLastName( String lastName )
  {
    this.lastName = lastName;
  }
  
  public String getEmail()
  {
    return email;
  }
  
  public void setEmail( String email )
  {
    this.email = email;
  }
  
  public String getPhoneNumeric()
  {
    return phoneNumeric;
  }
  
  public void setPhoneNumeric( String phoneNumeric )
  {
    this.phoneNumeric = phoneNumeric;
  }
  
  public Date getHireDate()
  {
    return hireDate;
  }
  
  public void setHireDate( Date hireDate )
  {
    this.hireDate = hireDate;
  }
  
  public String getJobId()
  {
    return jobId;
  }
  
  public void setJobId( String jobId )
  {
    this.jobId = jobId;
  }
  
  public Float getSalary()
  {
    return salary;
  }
  
  public void setSalary( Float salary )
  {
    this.salary = salary;
  }
  
  public Float getCommissionPct()
  {
    return commissionPct;
  }
  
  public void setCommissionPct( Float commissionPct )
  {
    this.commissionPct = commissionPct;
  }
  
  public Integer getManagerId()
  {
    return managerId;
  }
  
  public void setManagerId( Integer managerId )
  {
    this.managerId = managerId;
  }
  
  public Integer getDepartmentId()
  {
    return departmentId;
  }
  
  public void setDepartmentId( Integer departmentId )
  {
    this.departmentId = departmentId;
  }
  
  @Override
  public String toString()
  {
    return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumeric=" + phoneNumeric + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary=" + salary + ", commissionPct=" + commissionPct + ", managerId=" + managerId + ", departmentId=" + departmentId + "]";
  }
  
}
