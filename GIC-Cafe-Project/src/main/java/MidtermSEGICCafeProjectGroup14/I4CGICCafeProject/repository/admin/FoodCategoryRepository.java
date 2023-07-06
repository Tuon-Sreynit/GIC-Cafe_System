package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
    List<FoodCategory> findAll();
}
