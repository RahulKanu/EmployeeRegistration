package com.example.EmployeeRegistration;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.controller.EmployeeRegistrationController;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeRegistrationController.class, secure = false)
public class EmployeeTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeRepository employeeService;
	@Test
	public void retrieveDetailsForAllEmployee() throws Exception {
		Employee employee = new Employee(1,"Rahul","Kanu","Male","18.08.1987","CSE");
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(employee);
		Mockito.when(
				( employeeService.findAll())).thenReturn(employeeList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/employee/all").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "[{id:1,firstName:Rahul,lastName:Kanu,gender:Male,dateOfBirth:18.08.1987,department:CSE}]";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

	@Test
	public void retrieveDetailsForAllEmployeeEmpty() throws Exception {
		Employee employee = new Employee(1,"Rahul","Kanu","Male","18.08.1987","CSE");
		List<Employee> employeeList = new ArrayList<>();
		// employeeList.add(employee);
		Mockito.when(
				( employeeService.findAll())).thenReturn(employeeList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/employee/all").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "[]";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
/*	@Test
	public void postDetailsEmployee() throws Exception {
		Employee employee = new Employee(1,"Rahul","Kanu","Male","18.08.1987","CSE");
		List<Employee> employeeList = new ArrayList<>();
		Optional<Employee> employeeOpt = Optional.of(employee);
		employeeList.add(employee);
	
		
		Mockito.when(
				( employeeService.findById(employee.getId()))).thenReturn(employeeOpt);
		
		Mockito.when(
				( employeeService.save(employee))).thenReturn(employee);
		
		String mockRequest = "{\"firstName\": \"Rahul\",\"lastName\": \"Kanu\",\"gender\": \"Male\",\"dateOfBirth\": \"18/08/1987\",\"department\": \"CSE\"}";
		// Add the Json to the body of the request
		RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/employee/load")
        .content(mockRequest)
        .contentType(MediaType.APPLICATION_JSON);
		 MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	    String response = result.getResponse().getContentAsString();
	    JSONAssert.assertEquals(result.toString(),response.toString(), false);
	} */
	
	@Test
	public void getDetailsById() throws Exception {
		Employee employee = new Employee(1,"Rahul","Kanu","Male","18.08.1987","CSE");
		Optional<Employee> employeeOpt = Optional.of(employee);

		Mockito.when(
				( employeeService.findById(employee.getId()))).thenReturn(employeeOpt);
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/employee/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		String expected = "{id:1,firstName:Rahul,lastName:Kanu,gender:Male,dateOfBirth:18.08.1987,department:CSE}";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void exceptionDetailsById() throws Exception {
		Employee employee = new Employee(1,"Rahul","Kanu","Male","18.08.1987","CSE");
		Optional<Employee> employeeOpt = Optional.of(employee);

		Mockito.when(employeeService.findById(employee.getId()))
	      .thenThrow(NoSuchElementException.class);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/employee/2").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		employeeService.findById(employee.getId());
	}
	
	
	@Test
	public void deleteDetailsById() throws Exception {
		Employee employee = new Employee(1,"Rahul","Kanu","Male","18.08.1987","CSE");
		Optional<Employee> employeeOpt = Optional.of(employee);

		Mockito.when(
				( employeeService.findById(employee.getId()))).thenReturn(employeeOpt);
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/employee/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		String expected = "{id:1,firstName:Rahul,lastName:Kanu,gender:Male,dateOfBirth:18.08.1987,department:CSE}";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
}