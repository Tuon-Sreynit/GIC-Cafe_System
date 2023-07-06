package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Cashier;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Drink;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Food;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.AdminRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.CashierRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.DrinkRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.FoodRepository;

@RestController
public class AdminController {
    
    @Autowired
    private CashierRepository cRepo;
    @Autowired
    private DrinkRepository dRepo;
    @Autowired FoodRepository fRepo;

    @Autowired
    private AdminRepository adminRepo;

    @GetMapping("/adminView")
     public ModelAndView adminView() {
          ModelAndView mav = new ModelAndView("home_admin");
          List <Cashier> list = cRepo.findAll();
          mav.addObject("cashiers", list);
          List <Drink> list1 = dRepo.findAll();
          mav.addObject("drinks", list1);
          List <Food> list2 = fRepo.findAll();
          mav.addObject("foods", list2);
          mav.addObject("admin", adminRepo.findAll().get(0));
          return mav;
     }
}
