package com.hospital.hospital;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nurse")
public class NurseController {
	
	private List<Nurse> nurses = new ArrayList<>();

	// Constructor
	public NurseController() {

		try {

			InputStream inputStream = getClass().getResourceAsStream("/nurses.json");

			ObjectMapper objectMapper = new ObjectMapper();

			Nurse[] nursesArray = objectMapper.readValue(inputStream, Nurse[].class);

			nurses = Arrays.asList(nursesArray);

		} catch (IOException e) {

			e.printStackTrace();

		}
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

	@GetMapping("/index")
	public List<Nurse> getAll() {
		return nurses;
	}
}


@GetMapping("/name/{name}")
public Nurse findByName(@PathVariable String name) {
    for (Nurse nurse : nurses) {
        if (nurse.getName().equalsIgnoreCase(name)) {
            return nurse;
        }
    }
    return null;
}