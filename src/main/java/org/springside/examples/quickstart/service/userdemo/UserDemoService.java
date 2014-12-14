package org.springside.examples.quickstart.service.userdemo;


import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.examples.quickstart.entity.UserDemo;
import org.springside.examples.quickstart.repository.UserDemoDao;
 
@Component
@Transactional(readOnly = true)
public class UserDemoService {
 
    private UserDemoDao userDemoDao;
 
    @Autowired
    public void setUserDemoDao(UserDemoDao userDemoDao) {
        this.userDemoDao = userDemoDao;
    }
 
    public UserDemo findUserDemobyName(Long id) {
        return userDemoDao.findOne(id);
    }
 
    @Transactional(readOnly = false)
    public void deleteUserDemo(Long id) {
        userDemoDao.delete(id);
    }
 
    @Transactional(readOnly = false)
    public void saveUserDemo(UserDemo userDemo) {
        userDemoDao.save(userDemo);
    }
 
    public List<UserDemo> findAllUserDemo() {
        return (List<UserDemo>) userDemoDao.findAll(((new Sort(Direction.ASC,
                "id"))));
 
    }
 
}