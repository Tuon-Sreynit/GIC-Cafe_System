package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Admin;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Cashier;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.AdminRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.service.CashierService;

@Controller
public class LoginController {

    private CashierService cashierSer;
    private AdminRepository adminRepo;

    public LoginController(CashierService cashierSer, AdminRepository adminRepo) {
        super();
        this.cashierSer = cashierSer;
        this.adminRepo = adminRepo;
    }

    @GetMapping({"/login", "/"})
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @PostMapping(path = "login/check")
    public String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password, ModelMap model) {
        List<Cashier> cashiers = cashierSer.findAll();
        List<Admin> admins = adminRepo.findAll();

        boolean userNotExist = true;
        boolean invalidCredentials = false;
        boolean isAdmin = false;

        for (Admin admin : admins) {
            if (admin.getUsername().equals(username)) {
                userNotExist = false;
                if (admin.getPassword().equals(password)) {
                    isAdmin = true;
                } else {
                    invalidCredentials = true;
                }
                break;
            }
        }

        if (!isAdmin) {
            for (Cashier cashier : cashiers) {
                if (cashier.getUsername().equals(username)) {
                    userNotExist = false;
                    if (cashier.getPassword().equals(password)) {
                        invalidCredentials = false;
                    } else {
                        invalidCredentials = true;
                    }
                    break;
                }
            }
        }

        if (userNotExist) {
            model.addAttribute("errorMessage", "Username doesn't exist.");
        } else if (invalidCredentials) {
            model.addAttribute("errorMessage", "Invalid username or password.");
        } else if (isAdmin) {
            return "redirect:/adminView";
        } else {
            return "redirect:/productSelection";
        }

        return "redirect:/";
    }
}
