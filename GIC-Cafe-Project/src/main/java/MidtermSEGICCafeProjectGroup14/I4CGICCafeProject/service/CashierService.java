package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Cashier;

@Service
public interface CashierService {

    List <Cashier> findAll();
    public void saveCashierToDB(Cashier cashier, MultipartFile file, Date dob);
    void save(Cashier cashier);
    Cashier findById(Long id);
    void delete(long id);
}
