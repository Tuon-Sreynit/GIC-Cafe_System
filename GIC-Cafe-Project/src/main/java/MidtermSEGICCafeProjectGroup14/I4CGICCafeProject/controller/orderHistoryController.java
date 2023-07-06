package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.InvoiceRepository;

@RestController
public class orderHistoryController {
    @Autowired
    private InvoiceRepository iRepo;

    
    public orderHistoryController(InvoiceRepository iRepo) {
        this.iRepo = iRepo;
    }

    @GetMapping(path = "/order_history")
    public ModelAndView order_history(){
         ModelAndView mav = new ModelAndView("order_history");
         mav.addObject("invoices", iRepo.findAll());
         return mav;
    }
}