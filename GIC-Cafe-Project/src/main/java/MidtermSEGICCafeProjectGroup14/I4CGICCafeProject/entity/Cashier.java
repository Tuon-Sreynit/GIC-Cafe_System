package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;


@Entity
@Table(name = "cashiers")

public class Cashier {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String sex;
    private Date dob;
    private Integer age;
    // @CreatedDate
    // private LocalDate lastusername;
    @Column(name = "username", unique=true)
    private String username;
    private String password;

    @Lob
    @Column(nullable = true,length = 214748)
    private String photo;

    @CreationTimestamp
    private LocalDate hiredDate;
    public LocalDate getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(LocalDate hiredDate) {
        this.hiredDate = hiredDate;
    }
    
    public Cashier(String firstName, String lastName, String username, String password, String sex, Integer age, Date dob, String photo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.dob = dob;
        this.username = username;
        this.password = password;
        this.photo = photo;
        this.age = age;
    }

    public Cashier() {

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Cashier [id=" +id+ ", firstName=" +firstName+ ", lastName=" +lastName+ ", username=" +username+", sex=" +sex+ ", age=" +age+ ", dob=" + dob+", passowrd=" +password+ ", photo=" +photo+ "]";
    }
}
