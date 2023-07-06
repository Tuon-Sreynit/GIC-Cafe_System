package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "drinks")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String drinkName;

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    private String drinkCode;

    public String getDrinkCode() {
        return drinkCode;
    }

    public void setDrinkCode(String drinkCode) {
        this.drinkCode = drinkCode;
    }

    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private String drinkNote;

    public String getDrinkNote() {
        return drinkNote;
    }

    public void setDrinkNote(String drinkNote) {
        this.drinkNote = drinkNote;
    }

    private String drinkCategoryCode;

    @Column(name = "drink_category_code", nullable = true)
    public String getDrinkCategoryCode() {
        return drinkCategoryCode;
    }

    public void setDrinkCategoryCode(String drinkCategoryCode) {
        this.drinkCategoryCode = drinkCategoryCode;
    }

    @Column(name = "drink_category_name", nullable = true)
    private String drinkCategoryName;

    public String getDrinkCategoryName() {
        return drinkCategoryName;
    }

    public void setDrinkCategoryName(String drinkCategoryName) {
        this.drinkCategoryName = drinkCategoryName;
    }

    @Lob
    @Column(nullable = true, length = 214748)
    private String photo;

    public Drink(String drinkName, String drinkCode, Double price, String drinkNote, String photo,
            String drinkCategoryName, String drinkCategoryCode) {
        this.drinkName = drinkName;
        this.drinkCode = drinkCode;
        this.price = price;
        this.drinkNote = drinkNote;
        this.photo = photo;
        this.drinkCategoryName = drinkCategoryName;
        this.drinkCategoryCode = drinkCategoryCode;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Drink() {

    }

}