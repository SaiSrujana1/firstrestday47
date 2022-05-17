package com.jobiak.empapi.resources;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobiak.empapi.model.Customer;
import com.jobiak.empapi.service.CustomerService;

//import com.jobiak.empapi.Model;


import antlr.collections.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins="http://localhost:4200")
public class CustomerResource {

	@Autowired
	CustomerService service;
	@CrossOrigin(origins= {"*"},maxAge=4800,allowCredentials="false")
	@GetMapping(value="/display",produces=MediaType.APPLICATION_JSON_VALUE)
public java.util.List<Customer> showAll(){
		System.out.println("request received.....");
		return service.getAll();
	}
	
	
	@GetMapping(value="/customer",produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer showCatalog()
	{
		Customer customer=new Customer();
		customer.setName("Samsung");
		customer.setCusid(12L);
		customer.setBalance(49999);
	return customer;
	}
	
	
	@GetMapping("/intro")
	public String introduction() {
		return new String("The #1 Manfacture of Digital Mobiles in Asia");
	}
	
	/*@GetMapping("/search/{modelId}/name/{name}")
	public String searchModel(@PathVariable(value="modelId")String modelId,@PathVariable(value="brand")String brand) {
		return new String(modelId+brand+"currently not available for your location");
	}*/
	
	@PostMapping(value="/create",consumes =MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer addCustomer(@RequestBody Customer customer) {
		
		
		//System.out.println(mobile);
		//repo.save(mobile);
		Customer ref= service.addCustomer(customer);
		return ref;
	}
	
	@PutMapping(value="/modify",consumes =MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer modifyCustomer(@RequestBody Customer customer) {
		Customer ref= service.modifyCustomer(customer);
		return ref;
	}

	/*
	 * @DeleteMapping(value="/remove/{id}") public void removeCustomer(@PathVariable
	 * Long id) { service.removeCustomer(id); }
	 */
}