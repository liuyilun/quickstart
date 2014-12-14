package org.springside.examples.quickstart.web.userdemo;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.examples.quickstart.entity.UserDemo;
import org.springside.examples.quickstart.service.userdemo.UserDemoService;
 
/**
 * List page:
 * @author Robin
 *
 */
@Controller
@RequestMapping(value = "/userDemo")
public class UserDemoController {
 
    @Autowired
    private UserDemoService userDemoService;
 
    @RequestMapping(value ={"list",""})
    public String list(Model model) {
 
        List<UserDemo> userDemos = userDemoService.findAllUserDemo();
        model.addAttribute("userDemos", userDemos);
        return "userDemo/userDemoList";
    }
 
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("userDemo", new UserDemo());
        //设置跳转的action 但是未成功。采用写死的方法
        //model.addAttribute("action", "create");
        return "userDemo/userDemoForm";
    }
 
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String create(UserDemo newUserDemo,
            RedirectAttributes redirectAttributes) {
 
        userDemoService.saveUserDemo(newUserDemo);
        redirectAttributes.addFlashAttribute("message", "创建"+newUserDemo.getLoginName()+"成功");
        return "redirect:/userDemo/";
    }
 
    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes) {
        userDemoService.deleteUserDemo(id);
        redirectAttributes.addFlashAttribute("message", "删除任务成功");
        return "redirect:/userDemo/";
    }
     
     
}
/**
 * List page:
 * 
 * @author Robin 负责增、查、删
 *
 */
/*
 * 将@RequestMapping放在类级别上 这可令它与方法级别上的@RequestMapping注解协同工作，取得缩小选择范围的效果，如下：
 * 
 * @RequestMapping("/a")//类级别,可以不需要,如果要了,下面所有的请求路径前都需要加入 /a public class
 * ccccontroller{
 * 
 * @RequestMapping("/b")//方法级别,必须有,决定这个方法处理哪个请求,如果有类级别 /a/b　　　
 * 
 * @RequestMapping(value="/b" method=RequestMethod.POST)　　　
 * 
 * @RequestMapping(value="/b", method=RequestMethod.GET,
 * params="type=checking")　　　
 * 
 * @RequestMapping public String show() { //如果没有类级别的就直接请求/b return; } }
 */

	/*
	 * 2：问题：接收用户请求参数 值
	 * 
	 * 1）请求1： /test/start.do?name=zhangsan 
	 * 请求2： /test/start/zhangsan.do 在请求2中
	 * 将参数作为请求URL 传递 采用 URL模板
	 * 2）@RequestMapping("/start/{name}") 这个name 随便 啥都可以
	 * public String start(@PathVariable("name") string name){ 反正和上面的对应 return
	 * 方法体里面就可以直接获得参数 }
	 * 3）包含多个 @RequestMapping ("/start/{name}/{age}")
	 */
	