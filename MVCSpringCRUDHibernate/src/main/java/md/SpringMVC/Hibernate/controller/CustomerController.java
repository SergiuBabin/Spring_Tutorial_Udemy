package md.SpringMVC.Hibernate.controller;


import md.SpringMVC.Hibernate.entity.Customer;
import md.SpringMVC.Hibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(@RequestParam(required = false, name = "sortBy") String sortBy,
                                Model model) {

        model.addAttribute("customers", customerService.getCustomers(sortBy));

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Customer customer = new Customer();

        model.addAttribute("customer", customer);
        return "customer_form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {

        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/{id}/showFormForUpdate")
    public String showFormForUpdate(@PathVariable("id") int id, Model model){
        Customer customer = customerService.getCustomer(id);

        model.addAttribute("customer", customer);

        return "customer_form";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id, Model model){

        customerService.deleteCustomer(id);

        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("theSearchName") String name, Model model) {

        List<Customer> customers = customerService.searchCustomers(name);

        model.addAttribute("customers", customers);

        return "list-customers";
    }

}
