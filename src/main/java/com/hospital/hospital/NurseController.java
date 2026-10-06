package com.hospital.hospital;



import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;



// import jave.net.URI





@RestController // configured to listen for and handle HTTP request

@RequestMapping("/nurse") //from url starting with

public class NurseController {



  @GetMapping("/index")

  // Get requests that match nurse/ will be handled by this method.

  private @ResponseBody ResponseEntity(Iterable<Nurse>> getall(){

    return ResponseEntity.ok(nsnsnsnsnsnsnsnsnsn)

  }

  

}



  

}