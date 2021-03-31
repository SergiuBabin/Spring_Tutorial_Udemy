package md.Spring.controller;

import md.Spring.models.Student;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Babin Sergiu
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimmerEditor);
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {

        // Create a student object
        Student student = new Student();

        // add student object to the model
        model.addAttribute("student", student);

        return "student_form";
    }

    @PostMapping
    public String processForm(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "student_form";
        }

        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(student.getEmail());
        return "student_confirmation";
    }
}
