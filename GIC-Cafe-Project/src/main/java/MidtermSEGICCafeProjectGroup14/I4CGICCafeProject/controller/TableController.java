package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.CurrentDrinkOrder;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.CurrentFoodOrder;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Invoice;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.CurrentDrinkOrderRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.CurrentFoodOrderRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.InvoiceRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.service.TableEntityService;



@Controller
public class TableController {
    @Autowired
    private TableEntityService tableService;
    @Autowired
    private CurrentDrinkOrderRepository currentDrinkOrderRepository;
    @Autowired
    private CurrentFoodOrderRepository currentFoodOrderRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;

    @GetMapping("/table_management")
    public String manageTable(Model model){
        model.addAttribute("tableAmount", tableService.getTableAmount());
        return "tableManagement";
    }
    
    @GetMapping("/table_selection")
    public String selectTable(Model model){
        model.addAttribute("tables", tableService.getAllTable());
        return "table_selection";
    }

    @PostMapping("/table_management/set_number_of_table")
    public String setTableAmount(@RequestParam("tableAmount") Integer tableAmount){
        tableService.setNewTableAmount(tableAmount);
        return "redirect:/adminView";
    }

    @PostMapping("/set_table_availeble")
    public String setTableAvaileble(@RequestParam("tableId") Integer tid){
        tableService.setTableAvaileble((long) tid);
        return "redirect:/table_selection";
    }

    @PostMapping("/set_table_busy/save_invoice")
    public String saveInvoice(@RequestParam("tableId") Long tid){
        tableService.setTableBusy(tid);
        Invoice newInvoice = new Invoice();
        newInvoice.setTable_id(tid);

        Double price = (double) 0;
        for(CurrentFoodOrder currentFoodOrder : currentFoodOrderRepository.findAll()){
            price = price + ((currentFoodOrder.getFoodPrice() + currentFoodOrder.getSizePrice()) * currentFoodOrder.getAmount());
        }
        for(CurrentDrinkOrder currentDrinkOrder : currentDrinkOrderRepository.findAll()){
            price = price + ((currentDrinkOrder.getDrinkPrice() + currentDrinkOrder.getSizePrice()) * currentDrinkOrder.getAmount());
        }
        
        newInvoice.setPrice(price);

        Invoice sInvoice = invoiceRepository.save(newInvoice);

        return "redirect:/calculator/" + sInvoice.getId();
    }

    @PostMapping("/set_table_unpaid/save_invoice")
    public String saveInvoiceUnpaid(@RequestParam("tableId") Long tid){
        tableService.setTableUnpaid(tid);
        Invoice newInvoice = new Invoice();
        newInvoice.setTable_id(tid);

        Double price = (double) 0;
        for(CurrentFoodOrder currentFoodOrder : currentFoodOrderRepository.findAll()){
            price = price + ((currentFoodOrder.getFoodPrice() + currentFoodOrder.getSizePrice()) * currentFoodOrder.getAmount());
        }
        for(CurrentDrinkOrder currentDrinkOrder : currentDrinkOrderRepository.findAll()){
            price = price + ((currentDrinkOrder.getDrinkPrice() + currentDrinkOrder.getSizePrice()) * currentDrinkOrder.getAmount());
        }
        
        newInvoice.setPrice(price);

        Invoice sInvoice = invoiceRepository.save(newInvoice);

        return "redirect:/invoice/" + sInvoice.getId();
    }

    

    

}
