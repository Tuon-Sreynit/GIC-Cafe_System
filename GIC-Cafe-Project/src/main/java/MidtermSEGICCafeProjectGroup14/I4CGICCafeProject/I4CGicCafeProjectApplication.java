package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.DrinkSize;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.FoodSize;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.DrinkSizeRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.FoodSizeRepository;

@SpringBootApplication
public class I4CGicCafeProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		
		SpringApplication.run(I4CGicCafeProjectApplication.class, args);
	}

	@Autowired
	private DrinkSizeRepository drinkSizeRepository;
	@Autowired
	private FoodSizeRepository foodSizeRepository;

	@Override
	public void run(String... args) throws Exception {
		if(drinkSizeRepository.count() == 0){
			DrinkSize drink_size_small = new DrinkSize("small", (double) 0);
			DrinkSize drink_size_medium = new DrinkSize("medium", (double) 0.25);
			DrinkSize drink_size_large = new DrinkSize("large", (double) 0.5);
			
			drinkSizeRepository.save(drink_size_small);
			drinkSizeRepository.save(drink_size_medium);
			drinkSizeRepository.save(drink_size_large);
			
		}
		if(foodSizeRepository.count() == 0){
			FoodSize food_size_small = new FoodSize("small", (double) 0);
			FoodSize food_size_medium = new FoodSize("medium", (double) 1);
			FoodSize food_size_large = new FoodSize("large", (double) 2);
			
			foodSizeRepository.save(food_size_small);
			foodSizeRepository.save(food_size_medium);
			foodSizeRepository.save(food_size_large);
			
		}
	}

}
