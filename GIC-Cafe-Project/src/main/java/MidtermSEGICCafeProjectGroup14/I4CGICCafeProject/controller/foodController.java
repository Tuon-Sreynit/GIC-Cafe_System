package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Food;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.FoodCategory;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.FoodCategoryRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.FoodRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.service.FoodService;

@RestController
public class foodController {
    @Autowired
     private FoodRepository foodRepository;
     @Autowired
     private FoodService foodService;
     @Autowired
     private FoodCategoryRepository foodCategoryRepository;

     @GetMapping("/addFood")
     @ResponseBody
     public ModelAndView addFood() {
          ModelAndView mav = new ModelAndView("add_food");
          Food newFood = new Food();
          mav.addObject("food", newFood);
          mav.addObject("fCategories", foodCategoryRepository.findAll());
          return mav;
     }


     @PostMapping("/saveFood")
     public ModelAndView saveFood(@RequestParam("food_name") String food_name,
               @RequestParam("food_code") String food_code,
               @RequestParam("food_price") Double food_price,
               @RequestParam("food_note") String food_note,
               @RequestParam("photo") MultipartFile photo,
               @RequestParam("category") Long cid) {

          Food newFood = new Food();
          newFood.setFood_name(food_name);
          newFood.setFood_code(food_code);
          newFood.setFood_note(food_note);
          newFood.setFood_price(food_price);
          newFood.setFood_category_name(foodCategoryRepository.findById(cid).get().getFoodCategoryName());
          newFood.setFood_category_code(foodCategoryRepository.findById(cid).get().getFoodCategoryCode());

          Food food = foodService.saveFoodToDB(newFood, photo);
          Long foodId = food.getId();
          return new ModelAndView("redirect:/detailFood/" + foodId);
     }

     @PostMapping("/updateFood")
     public ModelAndView updateFood(@RequestParam("food_code") String food_code,
                                   @RequestParam("food_name") String food_name,
                                   @RequestParam("food_price") Double food_price,
                                   @RequestParam("food_note") String food_note,
                                   @RequestParam("foodCategoryName") Long foodCategoryId,
                                   @RequestParam("photo") MultipartFile photo,
                                   @RequestParam("fid") Long id){
          Food newfood = new Food();
          newfood = foodService.findById(id);
          
          newfood.setFood_code(food_code);
          newfood.setFood_name(food_name);
          newfood.setFood_price(food_price);
          newfood.setFood_note(food_note);
          newfood.setFood_category_name(foodCategoryRepository.findById(foodCategoryId).get().getFoodCategoryName());
          newfood.setFood_category_code(foodCategoryRepository.findById(foodCategoryId).get().getFoodCategoryCode());

          if(!photo.isEmpty()){
               foodService.saveFoodToDB(newfood, photo);
          }
          Food food = foodService.saveFoodToDB(newfood, photo);
          Long foodId = food.getId();
          return new ModelAndView("redirect:/detailFood/" + foodId);
     }

     @GetMapping("/showUpdateFood")
     public ModelAndView showUpdateFood(@RequestParam Long foodId){
          ModelAndView mav = new ModelAndView("edit_food");
          Food food = foodRepository.findById(foodId).get();
          List<FoodCategory> fCategories =  foodCategoryRepository.findAll();
          mav.addObject("food", food);
          mav.addObject("fCategories", fCategories);
          return mav;
     }

     @GetMapping("/deleteFood")
     public ModelAndView deleteFood(@RequestParam Long foodId){
          foodRepository.deleteById(foodId);
          return new ModelAndView("redirect:/adminView");
     }
    
}
