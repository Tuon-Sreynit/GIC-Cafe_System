package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String food_code;
    private String food_name;
    private Double food_price;
    private String food_category_code;
    private String food_category_name;
    private String food_note;
    @Lob
    @Column(nullable = true,length = 214748)
    private String photo;
    
   
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public Food(Long id, String food_code, String food_name, Double food_price, String food_category_code,
            String food_category_name, String photo, String food_note) {
        this.id = id;
        this.food_code = food_code;
        this.food_name = food_name;
        this.food_price = food_price;
        this.food_category_code = food_category_code;
        this.food_category_name = food_category_name;
        this.photo = photo;
        this.food_note = food_note;
    }
    public Food(){

    }
    public String getFood_code() {
        return food_code;
    }
    public void setFood_code(String food_code) {
        this.food_code = food_code;
    }
    public String getFood_name() {
        return food_name;
    }
    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }
    public Double getFood_price() {
        return food_price;
    }  

    public void setFood_price(Double food_price) {
        this.food_price = food_price;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    public String getFood_category_code() {
        return food_category_code;
    }
    
    public void setFood_category_code(String food_category_code) {
        this.food_category_code = food_category_code;
    }
    public String getFood_category_name() {
        return food_category_name;
    }
    public void setFood_category_name(String food_category_name) {
        this.food_category_name = food_category_name;
    }

    @Override
    public String toString() {
        return "Food [food_code=" + food_code + ", food_name=" + food_name + ", food_price=" + food_price + ", photo=" + photo + "]";
    }
    public String getFood_note() {
        return food_note;
    }
    public void setFood_note(String food_note) {
        this.food_note = food_note;
    }
    
}
