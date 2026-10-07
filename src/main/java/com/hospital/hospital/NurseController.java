package com.hospital.hospital;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;

// import jave.net.URI


@RestController // configured to listen for and handle HTTP request

@RequestMapping("/nurse") //from url starting with

public class NurseController {
	
	private final List<Nurse> nurses = List.of(
			new Nurse("root", "1234")
			);


  @GetMapping("/index")

  // Get requests that match nurse/ will be handled by this method.

  private @ResponseBody ResponseEntity(Iterable<Nurse>> getall(){

    return ResponseEntity.ok(//Nose)

  }

  @PostMapping("/login")
  
  public @ResponseBody ResponseEntity<Boolean> login(@RequestBody Nurse inputNurse){
	  
	  boolean found = false;
	  for(Nurse n : nurses) {
		  
		  if((n.getUser().equals(inputNurse.getUser)) && (n.getPw().equals(inputNurse.getPw())) {
			  found = true;
			  break;
		  }  
	  }	     
	  return ResponseEntity.status(found ? HttpsStatus.OK : HttpsStatus.UNAUTHORIZED).body(found);  
	  
  }
  


}



  