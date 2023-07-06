package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Cashier;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.CashierRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.service.CashierService;

@RestController
public class CashierController {

     @Autowired
     private CashierRepository cRepo;
     @Autowired
     private CashierService cService;

     @GetMapping("/addCashier")
     public ModelAndView addCashier() {
          ModelAndView mav = new ModelAndView("add_cashier");
          Cashier newCashier = new Cashier();
          mav.addObject("cashier", newCashier);
          return mav;
     }

     @PostMapping("/saveCashier")
     public ModelAndView saveCashier(@RequestParam("firstName") String firstName,
               @RequestParam("lastName") String lastName,
               @RequestParam("dob") Date dob,
               @RequestParam("username") String username,
               @RequestParam("password") String password,
               @RequestParam("photo") MultipartFile photo,
               @RequestParam("sex") String sex) {

          Cashier newCashier = new Cashier();
          newCashier.setFirstName(firstName);
          newCashier.setLastName(lastName);
          newCashier.setUsername(username);
          newCashier.setPassword(password);
          newCashier.setSex(sex);
          cService.saveCashierToDB(newCashier, photo, dob);
          return new ModelAndView("redirect:/adminView");
     }

     @PostMapping("/updateCashier")
     public ModelAndView updateCashier(@RequestParam("firstName") String firstName,
               @RequestParam("lastName") String lastName,
               @RequestParam("dob") Date dob,
               @RequestParam("username") String username,
               @RequestParam("password") String password,
               @RequestParam("photo") MultipartFile photo,
               @RequestParam("sex") String sex,
               @RequestParam("uid") Long id) {

          Cashier newCashier = new Cashier();
          newCashier = cService.findById(id);

          newCashier.setFirstName(firstName);
          newCashier.setLastName(lastName);
          newCashier.setDob(dob);
          newCashier.setUsername(username);
          newCashier.setSex(sex);
          if (!password.equals("")) {
               newCashier.setPassword(password);
          }
          if (!photo.isEmpty()) {
               cService.saveCashierToDB(newCashier, photo, dob);
          }
          cService.save(newCashier);
          
          return new ModelAndView("redirect:/adminView");
     }

     @GetMapping("/showUpdateCashier")
     public ModelAndView showUpdateCashier(@RequestParam Long cashierId) {
          ModelAndView mav = new ModelAndView("edit_cashier");
          Cashier cashier = cRepo.findById(cashierId).get();
          mav.addObject("cashier", cashier);
          return mav;
     }

     @GetMapping("/deleteCashier")
     public ModelAndView deleteCashier(@RequestParam Long cashierId) {
          cRepo.deleteById(cashierId);
          return new ModelAndView("redirect:/adminView");
     }
}
