
package org.springside.examples.quickstart.repository;
 
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.UserDemo;
 
public interface UserDemoDao extends PagingAndSortingRepository<UserDemo, Long> {
 
     
}