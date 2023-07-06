package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Cashier;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Drink;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Food;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.AdminRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.CashierRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.DrinkRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.FoodRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.service.CashierService;


@Controller
public class detailFoodController {
    @Autowired
    private CashierRepository cRepo;
    @Autowired
    private CashierService cService;
    @Autowired
    private DrinkRepository dRepo;
    @Autowired 
    private FoodRepository fRepo;
    @Autowired AdminRepository adminRepo;

    @GetMapping("/detailFood/{id}")
    public String showDetailfood(@PathVariable Long id, Model model) {
        Food food = new Food();
        food = fRepo.findById(id).get();
        model.addAttribute("cashiers", cRepo.findAll());
        List <Drink> list1 = dRepo.findAll();
        model.addAttribute("drinks", list1);
        List <Food> list2 = fRepo.findAll();
        model.addAttribute("foods", list2);
        model.addAttribute("food", food);
        model.addAttribute("admin", adminRepo.findAll().get(0));
        return "view_detail_food";
    }

}
