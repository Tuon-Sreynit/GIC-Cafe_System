package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DrinkCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String drinkCategoryCode;
    private String drinkCategoryName;
    public DrinkCategory(Long id, String drinkCategoryCode, String drinkCategoryName) {
        this.id = id;
        this.drinkCategoryCode = drinkCategoryCode;
        this.drinkCategoryName = drinkCategoryName;
    }

    
    public DrinkCategory() {
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDrinkCategoryCode() {
        return drinkCategoryCode;
    }
    public void setDrinkCategoryCode(String drinkCategoryCode) {
        this.drinkCategoryCode = drinkCategoryCode;
    }
    public String getDrinkCategoryName() {
        return drinkCategoryName;
    }
    public void setDrinkCategoryName(String drinkCategoryName) {
        this.drinkCategoryName = drinkCategoryName;
    }

    
}
