package org.lwz.space.controller;

import org.lwz.space.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by xiaoQuan on 2014/12/21.
 */

@Controller
public class PersonController {

    @Resource
    private PersonService personService;

    @RequestMapping(value = "/person/test", method = RequestMethod.GET)
    public String toTestPage(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {

        return "test";
    }
}
