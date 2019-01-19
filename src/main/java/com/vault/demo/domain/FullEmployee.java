
package com.vault.demo.domain;


import java.sql.Date;

import javax.persistence.*;


@Entity
@Table( name = "EMPLOYEES" )
public class FullEmployee
// extends Employee
{
  
  // INI
  @Id
  @Column( name = "EMPLOYEE_ID" )
  @GeneratedValue( strategy = GenerationType.IDENTITY )
  public Integer    id;
  
  @Column( name = "FIRST_NAME" )
  public String     firstName;
  
  @Column( name = "LAST_NAME", nullable = false )
  public String     lastName;
  
  @Column( nullable = false )
  public String     email;
  
  @Column( name = "PHONE_NUMERIC" )
  public String     phoneNumeric;
  
  @Column( name = "HIRE_DATE", nullable = false )
  public Date       hireDate;
  
  public Float      salary;
  
  @Column( name = "COMMISSION_PCT" )
  public Float      commissionPct;
  
  // END
  @ManyToOne
  @JoinColumn( name = "JOB_ID", referencedColumnName = "JOB_ID" )
  public Job        job;
  
  @ManyToOne
  @JoinColumn( name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID" )
  public Employee   manager;
  
  @ManyToOne
  @JoinColumn( name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID" )
  public Department department;
  
  // public FullEmployee( Employee e )
  // {
  // this.id = e.getId();
  // // this.departmentId = e.getDepartmentId();
  // this.commissionPct = e.getCommissionPct();
  // this.firstName = e.getFirstName();
  // this.lastName = e.getLastName();
  // this.email = e.getEmail();
  // this.hireDate = e.getHireDate();
  // // this.jobId = e.getJobId();
  // // this.managerId = e.getManagerId();
  // }
  
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
  
  public Job getJob()
  {
    return job;
  }
  
  public void setJob( Job job )
  {
    this.job = job;
  }
  
  public Employee getManager()
  {
    return manager;
  }
  
  public void setManager( Employee manager )
  {
    this.manager = manager;
  }
  
  public Department getDepartment()
  {
    return department;
  }
  
  public void setDepartment( Department department )
  {
    this.department = department;
  }
  
}
