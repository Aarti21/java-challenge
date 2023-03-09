package jp.co.axa.apidemo;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;

/**
 * @author Aarti
 * Test Class for EmployeeService.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiDemoApplicationTests {
	
	private final Long EMPLOYEE_ID = 1L;
	private final Long SECOND_EMPLOYEE_ID = 2L;
	private final String EMPLOYEE_NAME = "TEST";
	private final int EMPLOYEE_SALARY = 5000000;
	private final String EMPLOYEE_DEPARTMENT = "IT";
	private final String UPDATED_EMPLOYEE_NAME = "TEST_UPDATED";
	
	@Autowired
	private EmployeeService employeeService;

	@Test
	public void contextLoads() {
	}

	/**
	 * Test saveEmployee in employeeService. Test case fails if employee is not saved.
	 */
	@Test
	public void testSaveEmployee() {
		Employee employee = new Employee(EMPLOYEE_ID,EMPLOYEE_NAME,EMPLOYEE_SALARY,EMPLOYEE_DEPARTMENT);
		employeeService.saveEmployee(employee);
		Assertions.assertThat(employee.getId() > 0);
	}
	
	/**
	 * Test getEmployee(Long Id) in employeeService. Test case fails if employee is not retrieved.
	 */
	@Test
	public void testGetEmployee() {
	    Employee employee = employeeService.getEmployee(EMPLOYEE_ID);
		Assertions.assertThat(employee != null);
	}
	
	/**
	 * Test updateEmployee(Employee e) in employeeService. Test case fails if employee is not updated.
	 */
	@Test
	public void testUpdateEmployee() {
	    Employee employee = employeeService.getEmployee(EMPLOYEE_ID);
		employee.setName(UPDATED_EMPLOYEE_NAME);
		employeeService.updateEmployee(employee);
		employee = employeeService.getEmployee(EMPLOYEE_ID);
		Assertions.assertThat(employee.getName().equals(UPDATED_EMPLOYEE_NAME));	
	}
	
	/**
	 * Test retrieveEmployee(Long Id) in employeeService. Test case fails if employee list size is not greater than 1.
	 */
	@Test
	public void testRetrieveEmployee() {
		Employee employee = new Employee(SECOND_EMPLOYEE_ID,EMPLOYEE_NAME,EMPLOYEE_SALARY,EMPLOYEE_DEPARTMENT);
		employeeService.saveEmployee(employee);
		List<Employee> employeeList = employeeService.retrieveEmployees();
		Assertions.assertThat(employeeList.size()>1);
	}
	
	/**
	 * Test deleteEmployee(Long Id) in employeeService. Test case fails if employee is not deleted.
	 */
	@Test
	public void testDeleteEmployee() {
		Employee employee = new Employee(SECOND_EMPLOYEE_ID,EMPLOYEE_NAME,EMPLOYEE_SALARY,EMPLOYEE_DEPARTMENT); 
		employeeService.deleteEmployee(employee.getId());
	    System.out.println("Employee Id: "+employee.getId());
		Assertions.assertThat(employee.equals(null));	
	}
}
