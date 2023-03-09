package jp.co.axa.apidemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.entities.Role;
import jp.co.axa.apidemo.entities.User;
import jp.co.axa.apidemo.services.EmployeeService;
import jp.co.axa.apidemo.services.RoleService;
import jp.co.axa.apidemo.services.UserService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableCaching
public class ApiDemoApplication implements CommandLineRunner {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args){
		SpringApplication.run(ApiDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Create a Role
		Role role = new Role();
		role.setName("Admin");
		roleService.saveRole(role);
		
		// Create a User
		User user = new User();
		user.setName("Admin User");
		user.setEmail("admin@test.com");
		user.setPassword(new BCryptPasswordEncoder().encode("password"));
		user.setRole(roleService.getRole(1L));
		userService.saveUser(user);
		
		//Create an employee
		Employee employee = new Employee(1L, "Test Employee", 8000000, "IT");
		employeeService.saveEmployee(employee);	
	}

}
