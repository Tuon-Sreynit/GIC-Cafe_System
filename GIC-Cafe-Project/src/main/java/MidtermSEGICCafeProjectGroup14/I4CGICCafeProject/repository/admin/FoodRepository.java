package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.web.multipart.MultipartFile;


import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{

    // default void saveFoodToDB(Food food, MultipartFile file) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'saveFoodToDB'");
    // }
    
}