package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Drink;
@Repository
public interface DrinkRepository extends JpaRepository< Drink , Long>{
    
}
