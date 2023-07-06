package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.serviceImplement;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Food;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.FoodRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.service.FoodService;


@Service
public class foodImplement implements FoodService {
    public FoodRepository foodRepo;

    public foodImplement(FoodRepository foodRepo){
        this.foodRepo = foodRepo;
    }

    @Override
    public Food saveFoodToDB(Food food, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        if(fileName.contains("..")){
            System.out.println("not a valid file");
        }

        try{
            food.setPhoto(Base64.getEncoder().encodeToString(file.getBytes()));
        }catch(IOException e){
            e.printStackTrace();
        }
        return foodRepo.save(food);
    }

    @Override
    public List<Food> findAll() {
        return foodRepo.findAll();
    }

    @Override
    public void save(Food food) {
        foodRepo.save(food);
    }

    @Override
    public Food findById(Long id) {
        return foodRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(long id){
        
    }
}
