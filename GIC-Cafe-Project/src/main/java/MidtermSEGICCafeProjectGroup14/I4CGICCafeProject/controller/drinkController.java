package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Drink;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.DrinkCategory;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.DrinkCategoryRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.DrinkRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.service.DrinkService;

@RestController
public class drinkController {
    
    @Autowired
    private DrinkRepository drinkRepo;
    @Autowired
    private DrinkService drinkService;
    @Autowired
    private DrinkCategoryRepository drinkCategoryRepository;

    @GetMapping("/addDrink")
    public ModelAndView addDrink() {
          ModelAndView mav = new ModelAndView("add_drink");
          Drink newDrink = new Drink();
          mav.addObject("drink", newDrink);
          mav.addObject("dCategories", drinkCategoryRepository.findAll());
          return mav;
    }
    
    @PostMapping("/saveDrink")
     public ModelAndView saveDrink(@ModelAttribute Drink drink, @RequestParam("file") MultipartFile file, @RequestParam("category") Long cid) {
          drink.setDrinkCategoryCode(drinkCategoryRepository.findById(cid).get().getDrinkCategoryCode());
          drink.setDrinkCategoryName(drinkCategoryRepository.findById(cid).get().getDrinkCategoryName());
          Drink saveDrink = drinkService.saveDrinkToDB(drink, file);
          Long drinkId = saveDrink.getId();
          return new ModelAndView("redirect:/detailDrink/" + drinkId);
     }
    
     @GetMapping("/deleteDrink")
     public ModelAndView deleteDrink(@RequestParam Long drinkId) {
          drinkRepo.deleteById(drinkId);
          return new ModelAndView("redirect:/adminView");
     }
     @PostMapping("/updateDrink")
     public ModelAndView updateDrink(@RequestParam("drinkCode") String drinkCode,
               @RequestParam("drinkName") String drinkName,
               @RequestParam("drinkCategoryName") Long drinkCategoryId,
               @RequestParam("price") Double price,
               @RequestParam("drinkNote") String drinkNote,
               @RequestParam("file") MultipartFile photo,
               @RequestParam("did") Long id) {

          Drink newDrink = new Drink();
          newDrink = drinkService.findById(id);

          newDrink.setPrice( price);
          newDrink.setDrinkName(drinkName);
          newDrink.setDrinkCode(drinkCode);
          newDrink.setDrinkNote(drinkNote);
          newDrink.setDrinkCategoryName(drinkCategoryRepository.findById(drinkCategoryId).get().getDrinkCategoryName());
          newDrink.setDrinkCategoryCode(drinkCategoryRepository.findById(drinkCategoryId).get().getDrinkCategoryCode());
         
          if (!photo.isEmpty()) {
               drinkService.saveDrinkToDB(newDrink, photo);
          }
          
          Drink saveDrink = drinkService.saveDrinkToDB(newDrink, photo);
          Long drinkId = saveDrink.getId();
          return new ModelAndView("redirect:/detailDrink/" + drinkId);
     }

     @GetMapping("/showUpdateDrink")
     public ModelAndView showUpdateDrink(@RequestParam Long drinkId) {
          ModelAndView mav = new ModelAndView("edit_product");
          Drink drink = drinkRepo.findById(drinkId).get();
          List<DrinkCategory> dCategories =  drinkCategoryRepository.findAll();
          mav.addObject("drink", drink);
          mav.addObject("dCategories", dCategories);

          return mav;
     }

}
