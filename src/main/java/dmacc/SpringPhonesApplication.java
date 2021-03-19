package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dmacc.beans.Phone;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.PhoneRepository;

@SpringBootApplication
public class SpringPhonesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringPhonesApplication.class, args);		
	}

	@Autowired
	PhoneRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		//using existing bean
		Phone p = appContext.getBean("phone", Phone.class);
		repo.save(p);
		
		//new phone not managed by Spring
		Phone p2 = new Phone("Samsung", "Galaxy Z Fold 3", true, 8);
		repo.save(p2);
		
		//show all table entries
		List<Phone> allPhones = repo.findAll();
		for(Phone phone: allPhones) {
			System.out.println(phone.toString());
		}
	}
	
}
