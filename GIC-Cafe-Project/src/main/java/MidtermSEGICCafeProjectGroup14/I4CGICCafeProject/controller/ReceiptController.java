package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.CurrentDrinkOrder;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.CurrentFoodOrder;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Invoice;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Receipt;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.AdminRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.CashierRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.CurrentDrinkOrderRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.CurrentFoodOrderRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.InvoiceRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.ReceiptRepository;

@Controller
public class ReceiptController {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private CurrentDrinkOrderRepository currentDrinkOrderRepository;
    @Autowired
    private CurrentFoodOrderRepository currentFoodOrderRepository;
    @Autowired
    private CashierRepository cRepo;
    @Autowired
    private AdminRepository adminRepo;

    @GetMapping("/calculator/{id}")
    public String calculatorView(@PathVariable Long id, Model model){
        Receipt receipt = new Receipt();
        receipt.setInvoiceId(id);
        model.addAttribute("receipt", receipt);
        model.addAttribute("total", invoiceRepository.findById(id).get().getPrice());
        return "calculator";
    }

    @PostMapping("/save_receipt")
    public String saveReceipt(@ModelAttribute("receipt") Receipt receipt){
        Receipt savedReceipt = receiptRepository.save(receipt);
        return "redirect:/receipt/" + savedReceipt.getId() ;
    }

    @GetMapping("/receipt/{rid}")
    public String receiptView(Model model, @PathVariable Long rid){
        Receipt receipt = receiptRepository.findById(rid).get();
        Invoice invoice = invoiceRepository.findById(receipt.getInvoiceId()).get();
        List<CurrentDrinkOrder> drinkOrders = currentDrinkOrderRepository.findAll();
        List<CurrentFoodOrder> foodOrders = currentFoodOrderRepository.findAll();
        
        model.addAttribute("receipt", receipt);
        model.addAttribute("invoice", invoice);
        model.addAttribute("drinks", drinkOrders);
        model.addAttribute("foods", foodOrders);
        return "reciepts";
    }

    @GetMapping("/invoice/{iid}")
    public String invoiceView(Model model, @PathVariable Long iid){
        Invoice invoice = invoiceRepository.findById(iid).get();
        List<CurrentDrinkOrder> drinkOrders = currentDrinkOrderRepository.findAll();
        List<CurrentFoodOrder> foodOrders = currentFoodOrderRepository.findAll();
        
        model.addAttribute("invoice", invoice);
        model.addAttribute("drinks", drinkOrders);
        model.addAttribute("foods", foodOrders);
        return "invoice";
    }

    
}
