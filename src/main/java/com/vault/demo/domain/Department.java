
package com.vault.demo.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table( name = "DEPARTMENTS" )
public class Department
{
  
  @Id
  @Column( name = "DEPARTMENT_ID" )
  @GeneratedValue( strategy = GenerationType.IDENTITY )
  public Integer  id;
  
  @Column( name = "DEPARTMENT_NAME", nullable = false )
  public String   name;
  
  @Column( name = "MANAGER_ID" )
  public Integer  managerId;
  
  @ManyToOne
  @JoinColumn( name = "LOCATION_ID", referencedColumnName = "LOCATION_ID" )
  public Location location;
  
  public Integer getId()
  {
    return id;
  }
  
  public void setId( Integer id )
  {
    this.id = id;
  }
  
  public String getName()
  {
    return name;
  }
  
  public void setName( String name )
  {
    this.name = name;
  }
  
  public Integer getManagerId()
  {
    return managerId;
  }
  
  public void setManagerId( Integer managerId )
  {
    this.managerId = managerId;
  }
  
  public Location getLocation()
  {
    return location;
  }
  
  public void setLocation( Location location )
  {
    this.location = location;
  }
  
  @Override
  public String toString()
  {
    return "Department [id=" + id + ", name=" + name + ", managerId=" + managerId + ", location=" + location + "]";
  }
}
