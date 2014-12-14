package org.springside.examples.quickstart.web.userdemo;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.examples.quickstart.entity.UserDemo;
import org.springside.examples.quickstart.service.userdemo.UserDemoService;
 
@Controller
@RequestMapping(value = "/userDemo")
public class UserDemoUpdateController {
 
    private UserDemoService userDemoService;
 
    @Autowired
    public void setUserDemoService(UserDemoService userDemoService) {
        this.userDemoService = userDemoService;
    }
 
    @RequestMapping(value = "update/{id}")
    public String updateForm(Model model) {
 
        return "userDemo/userDemoForm";
    }
 
    @RequestMapping(value = "save/{id}")
    public String update(@ModelAttribute("userDemo") UserDemo userDemo,
            RedirectAttributes redirectAttributes) {
    	/*ModelAttribute用于参数上时： 用来通过名称对应，把相应名称的值绑定到注解的参数bean上；要绑定的值来源于：
    	A） @SessionAttributes 启用的attribute 对象上；
    	B） @ModelAttribute 用于方法上时指定的model对象；
    	C） 上述两种情况都没有时，new一个需要绑定的bean对象，然后把request中按名称对应的方式把值绑定到bean中。*/
        userDemoService.saveUserDemo(userDemo);
        redirectAttributes.addFlashAttribute("message",
                "更新" + userDemo.getLoginName() + "成功");
        return "redirect:/userDemo/";
    }
 
    /**
     * 使用@ModelAttribute, 实现Struts2
     * Preparable二次部分绑定的效果,先根据form的id从数据库查出Task对象,再把Form提交的内容绑定到该对象上。
     * 因为仅update()方法的form中有id属性，因此本方法在该方法中执行.
     */
    @ModelAttribute("userDemo")
    public UserDemo getUserDemoId(@PathVariable("id") Long id) {
        return userDemoService.findUserDemobyName(id);
    }
}


/*	 Spring能根据spring-mvc.xml中的<context:component-scan> 自动扫描@Controller， 无需配置。*/