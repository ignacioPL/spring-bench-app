package io.perezlaborda.controllers;

import io.perezlaborda.models.ResponseSize;
import io.perezlaborda.services.SlowService;
import io.perezlaborda.services.UserEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private UserEventService service;
    private SlowService slowService;

    @Autowired
    public MainController(UserEventService service, SlowService slowService) {
        this.service = service;
        this.slowService = slowService;
    }

    @RequestMapping("/")
    public String index(){
        return "hello world";
    }

    @RequestMapping("/slow/{count}")
    public String slow(@PathVariable int count) {
        slowService.loopIterator(count);
        return "finish";
    }

    @RequestMapping("/all")
    public String all(){
        //List<UserEvent> list = new ArrayList<>();
        long count = service.count();// .iterator().forEachRemaining(list::add);
        //list.forEach(System.out::println);
        return "termine: " + count;
    }

    @RequestMapping("/one/{id}")
    @ResponseBody
    public ResponseSize findOne(@PathVariable String id){
        long count = service.findByPk_UserId(id).size();
        return new ResponseSize(count);
    }

}
