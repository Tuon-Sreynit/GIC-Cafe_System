package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.FoodCategory;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.FoodCategoryRepository;

@Controller
public class foodCategoryController {
    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    @GetMapping("/addFoodCategory")
    public String foodCategoryFormView(Model model) {
        FoodCategory foodCategory = new FoodCategory();
        model.addAttribute("fCategory", foodCategory);
        return "addFoodCategory";
    }

    @PostMapping("/saveFoodCategory")
    public String saveFoodCategory(@ModelAttribute("fCategory") FoodCategory foodCategory){
        if(foodCategory.getFoodCategoryName().equals("")){
            System.out.println("Can not be saved!");
        }else if(foodCategory.getFoodCategoryCode().equals("")){
            System.out.println("Can not be saved!");
        }else{
            foodCategoryRepository.save(foodCategory);
        }
        return "redirect:/adminView";
    }
}
