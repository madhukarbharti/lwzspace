package org.lwz.space.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiaoQuan on 2014/12/21.
 */
//..../myzone/user/test
//..../myzone/user/te

@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/test")
    public String toIndex() {
        return "test";
    }
}
