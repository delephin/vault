
package com.vault.demo.exception;


public class EmployeeNotFoundException extends RuntimeException
{
  
  private static final long serialVersionUID = -8832794591966883043L;
  
  public EmployeeNotFoundException( Integer id )
  {
    super("Employee with id " + id + " not found.");
  }
}
