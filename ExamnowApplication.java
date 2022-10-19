
package com.examer.examnow;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.examer.examnow.model.Role;
import com.examer.examnow.model.User;
import com.examer.examnow.model.UserRole;
import com.examer.examnow.service.UserService;

@SpringBootApplication
public class ExamnowApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamnowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code!");
		/*User user = new User();
		user.setFirstName("Amit");
		user.setLastName("Yadav");
		user.setUsername("Amitawa");
		user.setPassword(this.bCryptPasswordEncoder.encode("amy25"));
		user.setEmail("amma@gmail.com");
		
		user.setPhone("5588774466");
		Role role1 = new Role();
		role1.setRoleId(1L);
		role1.setRoleName("ADMIN");
		Set <UserRole> userRoleSet = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		userRoleSet.add(userRole);
		User user1 = this.userService.createUser(user, userRoleSet);
		System.out.println(user1.getUsername());


*/
	}

}
