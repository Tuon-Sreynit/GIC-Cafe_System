package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.serviceImplement;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Drink;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.DrinkRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.service.DrinkService;

@Service
public class drink_imple implements DrinkService{

    @Autowired
    private DrinkRepository drinkRepo;

    @Override
    public List<Drink> findAll() {
        return drinkRepo.findAll();
    }

    @Override
    public Drink save(Drink drink) {
        return drinkRepo.save(drink);
    }

    @Override
    public Drink findById(Long id) {
        return drinkRepo.findById(id).get();
    }

    @Override
    public void delete(long id) {
        drinkRepo.deleteById(id);
    }
    
    @Override
    public Drink saveDrinkToDB(Drink drink, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        if(fileName.contains("..")){
            System.out.println("not a valid file");
        }
        
        try {
            drink.setPhoto(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return drinkRepo.save(drink);

    }

}
    



