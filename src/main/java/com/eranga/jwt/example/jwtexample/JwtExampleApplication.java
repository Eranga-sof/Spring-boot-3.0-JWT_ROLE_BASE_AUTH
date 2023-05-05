package com.eranga.jwt.example.jwtexample;

import com.eranga.jwt.example.jwtexample.Entity.Role;
import com.eranga.jwt.example.jwtexample.Entity.User;
import com.eranga.jwt.example.jwtexample.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@SpringBootApplication
public class JwtExampleApplication {

	@Autowired
	private  UserRepository userRepository;

	@Autowired
	private  PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(JwtExampleApplication.class, args);
	}

	@Component
	public class MyCommandLineRunenr implements CommandLineRunner{

		@Override
		public void run(String... args) throws Exception {
		 Optional<User> existUser =  userRepository.findByEmail("admin@admin.com");
			System.out.println(existUser);
		 if (existUser.isEmpty()) {
				var user = User.builder()
						.id(1)
						.firstName("Admin")
						.lastName("Admin")
						.email("admin@admin.com")
						.password(passwordEncoder.encode("test1234"))
						.role(Role.ADMIN)
						.build();

				userRepository.save(user);

			}{
				System.out.println("User Already Exist");
			}



		}
	}

}
