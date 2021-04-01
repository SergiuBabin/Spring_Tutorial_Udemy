package md.Spring.Udemy.controller;

/**
 * @author Babin Sergiu
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/customer")
public class TestController {
    @RequestMapping("/list")
    public String listCustomers(Model model) {

        return "list_customers";
    }

}
