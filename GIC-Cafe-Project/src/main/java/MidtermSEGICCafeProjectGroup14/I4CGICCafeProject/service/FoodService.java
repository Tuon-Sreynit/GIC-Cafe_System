package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Food;



@Service
public interface FoodService {
    
    public Food saveFoodToDB(Food food, MultipartFile file);
    List <Food> findAll();
    void save(Food food);
    Food findById(Long id);
    void delete(long id);
}
