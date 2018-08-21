package com.Sample.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Sample.Entity.Person;
import com.Sample.Service.PersonService;

@RestController
@RequestMapping("gestor")
public class PersonController {
	
	@Autowired
	  private PersonService personService;
		
		@RequestMapping(value = "/person", method = RequestMethod.GET)		
		@ResponseBody
		public Object index(){ 
			return personService.findAll();
		}
	
	  @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)	  
	  @ResponseBody
	  //public String create(@RequestParam(value = "id", required = true) Long id, @RequestParam("name")String name,@RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("PhoneNo") String PhoneNo) {
	  public String create(@RequestBody Person person) {
		  String userId = "";
	    try {	    
	      //Person user = new Person();
	    	personService.save(person);
	     // userId = String.valueOf(user.getId());
	      userId = String.valueOf(person.getId());
	    }
	    catch (Exception ex) {
	      return "Error creating the user: " + ex.toString();
	    }
	    return "User succesfully created with id = " + userId;
	  }
	  @RequestMapping(value = "/register", method = RequestMethod.POST)
		public ResponseEntity<Person> createUser(@RequestBody Person appUser) {
			
			return new ResponseEntity<Person>(personService.save(appUser), HttpStatus.CREATED);
		}
	 
	  @RequestMapping("/delete/{id}")
	  @ResponseBody
	  public String delete(@PathVariable long id) {
	    try {
	    	Person user = personService.findById(id);
	    	personService.delete(user);
	    }
	    catch (Exception ex) {
	      return "Error deleting the user:" + ex.toString();
	    }
	    return "User succesfully deleted!";
	  }
	  
	  
	  @RequestMapping("/get-by-email")
	  @ResponseBody
	  public String getByEmail(String email) {
	    String userId = "";
	    try {
	    	Person user = personService.findByEmail(email);
	        userId = String.valueOf(user.getId());
	    }
	    catch (Exception ex) {
	      return "User not found";
	    }
	    return "The user id is: " + userId;
	  }
	  
	  
	 @GetMapping(path="a/{id}")
	 public ResponseEntity<?>hsj(@PathVariable("id") Long id){
		 Person p=personService.findById(id);
		 
		 return new ResponseEntity<>(p,HttpStatus.OK);
	 }

	  
}
