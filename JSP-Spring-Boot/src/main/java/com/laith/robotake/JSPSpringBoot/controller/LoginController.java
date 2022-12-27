package com.laith.robotake.JSPSpringBoot.controller;


import com.laith.robotake.JSPSpringBoot.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("session")
public class LoginController {

   /* @Value("${spring.login.username}")
    private String username;
    @Value("${spring.login.password}")
    private String password;*/

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value={"/"})
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/welcome")
    public ModelAndView firstPage() {
        return new ModelAndView("welcome");
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "login";
    }

    /*@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model,
                                  @RequestParam String username,
                                  @RequestParam String password,
                                  HttpServletRequest request
                                  ) {
        if (!employeeService.validateUserNameAndPassword(username,password)) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }
        model.put("username", username);
        model.put("password", password);
        request.getSession().setAttribute("isAuthorized",true);
        return "welcome";
    }*/

   /* private boolean validateUser(String username, String password) {
        return this.username.equalsIgnoreCase(username)
                && this.password.equalsIgnoreCase(password);}*/
}
