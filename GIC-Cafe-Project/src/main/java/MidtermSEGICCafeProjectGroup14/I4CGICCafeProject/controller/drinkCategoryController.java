package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.DrinkCategory;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.DrinkCategoryRepository;

@Controller
public class drinkCategoryController {
    @Autowired
    private DrinkCategoryRepository drinkCategoryRepository;

    @GetMapping("/addDrinkCategory")
    public String drinkCategoryFormView(Model model) {
        DrinkCategory drinkCategory = new DrinkCategory();
        model.addAttribute("dCategory", drinkCategory);
        return "addDrinkCategory";
    }

    @PostMapping("/saveDrinkCategory")
    public String saveDrinkCategory(@ModelAttribute("dCategory") DrinkCategory drinkCategory){
        if(drinkCategory.getDrinkCategoryName().equals("")){
            System.out.println("Can not be saved!");
        }else if(drinkCategory.getDrinkCategoryCode().equals("")){
            System.out.println("Can not be saved!");

        }else{
            drinkCategoryRepository.save(drinkCategory);
        }
        return "redirect:/adminView";
    }
}
