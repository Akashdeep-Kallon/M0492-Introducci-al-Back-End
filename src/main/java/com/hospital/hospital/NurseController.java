package com.hospital.hospital;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tools.jackson.databind.json.JsonMapper;

@RestController
@RequestMapping("/nurse")
public class NurseController {

	private List<Nurse> nurses = new ArrayList<>();

	// Constructor
	public NurseController() {

		try (InputStream inputStream = getClass().getResourceAsStream("/nurses.json")) {

			JsonMapper objectMapper = JsonMapper.builder().build();

			Nurse[] nursesArray = objectMapper.readValue(inputStream, Nurse[].class);

			nurses = Arrays.asList(nursesArray);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	@PostMapping("/login")
	public ResponseEntity<Boolean> login(@RequestBody Nurse inputNurse) {

		boolean found = false;
		for (Nurse n : nurses) {

			if (n.getUser().equals(inputNurse.getUser()) && n.getPw().equals(inputNurse.getPw())) {
				found = true;
				break;
			}
		}
		return ResponseEntity.status(found ? HttpStatus.OK : HttpStatus.UNAUTHORIZED).body(found);

	}

	@GetMapping("/index")
	public ResponseEntity<List<Nurse>> getAll() {
		return ResponseEntity.ok(nurses);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Nurse> findByName(@PathVariable String name) {
		for (Nurse nurse : nurses) {
			if (nurse.getName().equalsIgnoreCase(name)) {
				return ResponseEntity.ok(nurse);
			}
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
	}

}