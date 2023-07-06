package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CurrentDrinkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long drinkId;
    private String drinkName;
    private Double drinkPrice;

    private Long sizeId;
    private Double sizePrice;
    private String sizeName;
    
    private Integer amount;

    public CurrentDrinkOrder(Long drinkId, String drinkName, Double drinkPrice, Long sizeId, Double sizePrice,
            Integer amount, String sizeName) {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
        this.sizeId = sizeId;
        this.sizePrice = sizePrice;
        this.amount = amount;
        this.sizeName = sizeName;
    }

    public CurrentDrinkOrder() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(Long drinkId) {
        this.drinkId = drinkId;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public Double getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(Double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public Long getSizeId() {
        return sizeId;
    }

    public void setSizeId(Long sizeId) {
        this.sizeId = sizeId;
    }

    public Double getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(Double sizePrice) {
        this.sizePrice = sizePrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    public String getSizeName() {
        return this.sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }
    
}
