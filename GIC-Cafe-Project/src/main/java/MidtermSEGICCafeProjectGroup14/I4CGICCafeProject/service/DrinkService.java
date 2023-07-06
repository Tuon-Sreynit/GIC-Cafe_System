package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.service;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Drink;

public interface DrinkService {
   List <Drink> findAll();
   Drink save(Drink drink);
   Drink findById(Long id);
   void delete(long id);
   Drink saveDrinkToDB(Drink drink, MultipartFile file);

}
