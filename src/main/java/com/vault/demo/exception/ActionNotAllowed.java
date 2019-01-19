
package com.vault.demo.exception;


public class ActionNotAllowed extends RuntimeException
{
  
  private static final long serialVersionUID = 1513375221940436898L;
  
  public ActionNotAllowed( String message )
  {
    super(message);
  }
}
