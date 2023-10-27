package src.main.java.com.leonardo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SopaDeLetrasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SopaDeLetrasApplication.class, args);
		
		
		// Desde aqui se ejecuta la aplicacion
	}

}
