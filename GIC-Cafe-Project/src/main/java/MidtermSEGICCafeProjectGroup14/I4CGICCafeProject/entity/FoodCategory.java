package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FoodCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodCategoryCode;
    private String foodCategoryName;
    public FoodCategory(Long id, String foodCategoryCode, String foodCategoryName) {
        this.id = id;
        this.foodCategoryCode = foodCategoryCode;
        this.foodCategoryName = foodCategoryName;
    }
    
    public FoodCategory() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFoodCategoryCode() {
        return foodCategoryCode;
    }
    public void setFoodCategoryCode(String foodCategoryCode) {
        this.foodCategoryCode = foodCategoryCode;
    }
    public String getFoodCategoryName() {
        return foodCategoryName;
    }
    public void setFoodCategoryName(String foodCategoryName) {
        this.foodCategoryName = foodCategoryName;
    }

    
}
