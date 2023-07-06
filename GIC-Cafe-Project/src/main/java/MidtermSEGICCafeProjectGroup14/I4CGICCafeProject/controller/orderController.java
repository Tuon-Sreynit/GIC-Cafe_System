package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.CurrentDrinkOrder;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.CurrentFoodOrder;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.CurrentDrinkOrderRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.CurrentFoodOrderRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.DrinkCategoryRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.DrinkRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.DrinkSizeRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.FoodCategoryRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.FoodRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.FoodSizeRepository;

@Controller
public class orderController {
    @Autowired
    private DrinkCategoryRepository drinkCategoryRepository;
    @Autowired
    private FoodCategoryRepository foodCategoryRepository;
    @Autowired
    private DrinkRepository drinkRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private DrinkSizeRepository drinkSizeRepository;
    @Autowired
    private FoodSizeRepository foodSizeRepository;
    @Autowired
    private CurrentDrinkOrderRepository currentDrinkOrderRepository;
    @Autowired
    private CurrentFoodOrderRepository currentFoodOrderRepository;

    @GetMapping("/productSelection")
    public String viewProductSelection(Model model){
        model.addAttribute("dCategories", drinkCategoryRepository.findAll());
        model.addAttribute("fCategories", foodCategoryRepository.findAll());
        model.addAttribute("drinks", drinkRepository.findAll());
        model.addAttribute("foods", foodRepository.findAll());
        model.addAttribute("drinkSizes", drinkSizeRepository.findAll());
        model.addAttribute("foodSizes", foodSizeRepository.findAll());
        model.addAttribute("foodOrders", currentFoodOrderRepository.findAll());
        model.addAttribute("drinkOrders", currentDrinkOrderRepository.findAll());
        return "drink_select_and_order_info";
    }

    @PostMapping("/save_drink_order")
    public String saveDrinkOrder(@RequestParam("size") Long sizeId, @RequestParam("amount") Integer amount, @RequestParam("drinkId") Long id){
        CurrentDrinkOrder currentDrinkOrder = new CurrentDrinkOrder();
        currentDrinkOrder.setAmount(amount);
        currentDrinkOrder.setDrinkId(id);
        currentDrinkOrder.setDrinkName(drinkRepository.findById(id).get().getDrinkName());
        currentDrinkOrder.setDrinkPrice(drinkRepository.findById(id).get().getPrice());
        currentDrinkOrder.setSizeId(sizeId);
        currentDrinkOrder.setSizePrice(drinkSizeRepository.findById(sizeId).get().getPrice());
        currentDrinkOrder.setSizeName(drinkSizeRepository.findById(sizeId).get().getName());
        currentDrinkOrderRepository.save(currentDrinkOrder);
        return "redirect:/productSelection";
    }

    @PostMapping("/save_food_order")
    public String saveFoodOrder(@RequestParam("size") Long sizeId, @RequestParam("amount") Integer amount, @RequestParam("foodId") Long id){
        CurrentFoodOrder currentFoodOrder = new CurrentFoodOrder();
        currentFoodOrder.setAmount(amount);
        currentFoodOrder.setFoodId(id);
        currentFoodOrder.setFoodName(foodRepository.findById(id).get().getFood_name());
        currentFoodOrder.setFoodPrice(foodRepository.findById(id).get().getFood_price());
        currentFoodOrder.setSizeId(sizeId);
        currentFoodOrder.setSizePrice(foodSizeRepository.findById(sizeId).get().getPrice());
        currentFoodOrder.setSizeName(foodSizeRepository.findById(sizeId).get().getName());
        
        currentFoodOrderRepository.save(currentFoodOrder);
        return "redirect:/productSelection";
    }

    @GetMapping("/delete_drink_order/{id}")
    public String deleteDrinkOrder(@PathVariable Long id){
        currentDrinkOrderRepository.deleteById(id);
        return "redirect:/productSelection";
    }

    @GetMapping("/delete_food_order/{id}")
    public String deleteFoodOrder(@PathVariable Long id){
        currentFoodOrderRepository.deleteById(id);
        return "redirect:/productSelection";
    }

    @GetMapping("/clear_current_order")
    public String clearOrders(){
        currentDrinkOrderRepository.deleteAll();
        currentFoodOrderRepository.deleteAll();
        return "redirect:/productSelection";
    }   
}
