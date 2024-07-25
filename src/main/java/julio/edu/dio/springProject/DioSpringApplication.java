package julio.edu.dio.springProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DioSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DioSpringApplication.class, args);
	}

}
