package com.official.hotelmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @RequestMapping({"/dashboard", "/"})
    public String dashboardPage() {
        return "admin/admin_layout";
    }

    @RequestMapping({"/dashboard2", "/"})
    public String test() {
        return "demo/test";
    }

    @RequestMapping("/customers")
    public String customerAdd() {
        return "demo/customer";
    }


}
