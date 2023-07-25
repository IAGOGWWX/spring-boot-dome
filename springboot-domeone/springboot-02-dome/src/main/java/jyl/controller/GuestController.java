package jyl.controller;


import jyl.domain.Guest;
import jyl.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private GuestService guestService;

//    @RequestMapping("/guest/list")
    @GetMapping
    public String list(Model model){
        model.addAttribute("list",guestService.list());
        return "list";
    }
    //@RequestMapping("/guest/toAdd")
    @GetMapping("/toAdd")   //因为 /guest提前了只需要 GetMapping("/toAdd") ，想要访问到这个请求只需要 @{/guest/toAdd}
    public String toAdd(){
        return "add";
    }

    /**
     * 将/guest 格式的url映射到此方法
     * @PostMapping 代表需要添加的操作
     * @param guest
     * @return
     */
    //@RequestMapping("/guest/add")
    @PostMapping  // 想要访问到这个请求只需要 @{/guest}
    public String add(Guest guest){

        System.out.println("controller = "+guest.toString());
        guestService.add(guest);
        //return "redirect:/guest/list";  //转发不需要 加guest了 ，
        return "redirect:/guest";

    }

    /**
     * 前端请求方式 @{/guest/toUpdate/}+${guest.name}
     * 将/guest/toUpdate/{name}格式的url映射到此方法
     * 其中的name属性值  通过注解 @PathVariable("name")映射到方法的属性中
     * 其中的“name” 代表去url中查找的属性值
     * 直译的意思就是  从路径中获取name的值 赋值给 String name
     *
     * @param model
     * @param name
     * @return
     */
    //@RequestMapping("/guest/toUpdate")
    //更新操作之前需要获取对象，传入的参数需要用/{name}并添加@PathVariable("name")注解对应
    @GetMapping("/toUpdate/{name}")
    public String toUpdate(Model model,@PathVariable("name") String name){
        model.addAttribute("guest",guestService.get(name));
        return "update";
    }

    //@RequestMapping("/guest/update")
    @PutMapping  //PutMapping注解代表的就是更新操作 所有只需要URL请求   /guest 就可以访问到了
    public String update(Guest guest){

        guestService.update(guest);
        //return "redirect:/guest/list";
        return "redirect:/guest";

    }

        //@RequestMapping("/guest/delete")
        @DeleteMapping("/{name}")
        public String delete(@PathVariable("name") String name){

            guestService.delete(name);
            //return "redirect:/guest/list";
            return "redirect:/guest";

        }
}
