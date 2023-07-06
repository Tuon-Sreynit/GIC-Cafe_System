package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.DrinkCategory;

@Repository
public interface DrinkCategoryRepository extends JpaRepository<DrinkCategory, Long>{
    List<DrinkCategory> findAll();
}
