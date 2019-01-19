
package com.vault.demo.domain.extra;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.vault.demo.domain.FullEmployee;


public class EmployeeSpecificationsBuilder
{
  
  private final List<SearchCriteria> params;
  
  public EmployeeSpecificationsBuilder()
  {
    params = new ArrayList<SearchCriteria>();
  }
  
  public EmployeeSpecificationsBuilder with( String key, String operation, Object value )
  {
    params.add(new SearchCriteria(key, operation, value));
    return this;
  }
  
  public Specification<FullEmployee> build()
  {
    if (params.size() == 0)
    {
      return null;
    }
    
    // List<Specification> specs = params.stream().map(EmployeeSpecifications::new).collect(Collectors.toList());
    
    // Specification result = specs.get(0);
    
    // for (int i = 1; i < params.size(); i++)
    // {
    // result = params.get(i).isOrPredicate() ? Specification.where(result).or(specs.get(i)) : Specification.where(result).and(specs.get(i));
    // }
    return null;
  }
}
