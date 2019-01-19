
package com.vault.demo.domain.extra;


import java.util.function.Predicate;

import org.hibernate.criterion.CriteriaQuery;
import org.springframework.data.jpa.domain.Specification;

import com.vault.demo.domain.FullEmployee;


//import javax.persistence.criteria.Root;

//public class EmployeeSpecifications implements Specification<FullEmployee>
public class EmployeeSpecifications
// implements Specification<FullEmployee>
{
  
  private SearchCriteria criteria;
  
  public EmployeeSpecifications( SearchCriteria criteria )
  {
    super();
    this.criteria = criteria;
  }
  
  // @Override
  // public Predicate toPredicate( Root<FullEmployee> root, CriteriaQuery query, CriteriaBuilder builder )
  // // {
  // //
  // // if (criteria.getOperation().equalsIgnoreCase(">"))
  // // {
  // // return builder.greaterThanOrEqualTo(root.<String> get(criteria.getKey()), criteria.getValue().toString());
  // // }
  // // else if (criteria.getOperation().equalsIgnoreCase("<"))
  // // {
  // // return builder.lessThanOrEqualTo(root.<String> get(criteria.getKey()), criteria.getValue().toString());
  // // }
  // // else if (criteria.getOperation().equalsIgnoreCase(":"))
  // // {
  // // if (root.get(criteria.getKey()).getJavaType() == String.class)
  // // {
  // // return builder.like(root.<String> get(criteria.getKey()), "%" + criteria.getValue() + "%");
  // // }
  // // else
  // // {
  // // return builder.equal(root.get(criteria.getKey()), criteria.getValue());
  // // }
  // // }
  // return null;
  // }
}
