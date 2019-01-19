
package com.vault.demo.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table( name = "COUNTRIES" )
public class Country
{
  
  @Id
  @Column( name = "COUNTRY_ID" )
  public String id;
  
  @Column( name = "COUNTRY_NAME" )
  public String name;
  
  @ManyToOne( cascade = CascadeType.ALL )
  @JoinColumn( name = "REGION_ID" )
  public Region region;
  
  public String getId()
  {
    return id;
  }
  
  public void setId( String id )
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
  
  public Region getRegion()
  {
    return region;
  }
  
  public void setRegion( Region region )
  {
    this.region = region;
  }
  
}
