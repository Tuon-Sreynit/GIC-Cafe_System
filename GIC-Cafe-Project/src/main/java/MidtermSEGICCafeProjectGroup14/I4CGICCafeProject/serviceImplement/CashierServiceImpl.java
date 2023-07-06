package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.serviceImplement;

import java.io.IOException;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Cashier;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.CashierRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.service.CashierService;


@Service
public class CashierServiceImpl implements CashierService {
    public CashierRepository cRepo;
    
    public CashierServiceImpl(CashierRepository cRepo) {
        this.cRepo = cRepo;
    }
    
    @Override
    public void saveCashierToDB(Cashier cashier, MultipartFile file, Date dob) {
        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();

        birthDate.setTime(dob);
        System.out.println(dob);

        int age = 0;
        age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
        System.out.println(age);
        
        cashier.setDob(dob);
        cashier.setAge(age);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        if(fileName.contains("..")){
            System.out.println("not a valid file");
        }
        
        try {
            cashier.setPhoto(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        cRepo.save(cashier);
    } 

    @Override
    public List<Cashier> findAll() {
        return cRepo.findAll();
    }

    @Override
    public void save(Cashier cashier) { 
        cRepo.save(cashier);
    }

    @Override
    public Cashier findById(Long id) {
        return cRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
       
    }

}
