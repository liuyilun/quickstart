package org.springside.examples.quickstart.entity;
 
import javax.persistence.Entity;
import javax.persistence.Table;
 
import org.hibernate.validator.constraints.NotBlank;
 
//JPA标识
@Entity
@Table(name="ACCT_USER")
public class UserDemo extends IdEntityBase {
    private String loginName;
    private String password;
    private String name;
    private String email;
 
    @NotBlank
    public String getLoginName() {
        return loginName;
    }
 
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
}