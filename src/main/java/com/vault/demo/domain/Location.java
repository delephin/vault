
package com.vault.demo.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table( name = "LOCATIONS" )
public class Location
{
  
  @Id
  @Column( name = "LOCATION_ID" )
  public Integer id;
  
  @Column( name = "STREET_ADDRESS" )
  public String  streetAddress;
  
  @Column( name = "POSTAL_CODE" )
  public String  postalCode;
  
  @Column( nullable = false )
  public String  city;
  
  @Column( name = "STATE_PROVINCE" )
  public String  stateProvince;
  
  @ManyToOne
  @JoinColumn( name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID" )
  public Country country;
  
  public Integer getId()
  {
    return id;
  }
  
  public void setId( Integer id )
  {
    this.id = id;
  }
  
  public String getStreetAddress()
  {
    return streetAddress;
  }
  
  public void setStreetAddress( String streetAddress )
  {
    this.streetAddress = streetAddress;
  }
  
  public String getPostalCode()
  {
    return postalCode;
  }
  
  public void setPostalCode( String postalCode )
  {
    this.postalCode = postalCode;
  }
  
  public String getCity()
  {
    return city;
  }
  
  public void setCity( String city )
  {
    this.city = city;
  }
  
  public String getStateProvince()
  {
    return stateProvince;
  }
  
  public void setStateProvince( String stateProvince )
  {
    this.stateProvince = stateProvince;
  }
  
  public Country getCountry()
  {
    return country;
  }
  
  public void setCountry( Country country )
  {
    this.country = country;
  }
  
}
