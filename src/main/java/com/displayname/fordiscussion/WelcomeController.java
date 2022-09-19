package com.displayname.fordiscussion;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
public class WelcomeController {
		@GetMapping("/welcome")
		public String welcome() {	
			return "Hello Spring Boot"; 	
		}
		
		@PostMapping(path= "/getUsers", consumes = "application/json", produces = "application/json")
		public void getUsers(){ 
		    final String uri = "igotkarmayogi.gov.in/api/user/v1/search";

		    RestTemplate restTemplate = new RestTemplate();
		    
		    HttpHeaders headers = new HttpHeaders();
		    headers.set("Authorization", "Bearer  eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiI5a04xTW1TcGVuVTAyam8zVHg1U2p0amhTOFVXeGVSUiJ9.LWAgFust4e0wntxqY8_MQjf5WQ9RSD6Hg45jX_NoCXY");    
		    headers.set("X-Authenticated-User-Token", "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI2V1JvWndCZTRJU0U1c2lkWlY5YW55NTZXTmp3clk0eWlPTy0zUC1uY3A4In0.eyJqdGkiOiIzMWU0YmNjYS1jNWY2LTQzNmQtYWZiMy00NTNmNzc1MjMxY2MiLCJleHAiOjE2NjMzOTUxMTUsIm5iZiI6MCwiaWF0IjoxNjYzMzA4NzE1LCJpc3MiOiJodHRwczovL2lnb3RrYXJtYXlvZ2kuZ292LmluL2F1dGgvcmVhbG1zL3N1bmJpcmQiLCJzdWIiOiJmOmVmMmRjZWRmLWVkMmItNDhmYS04NWU5LWVlYWI5YTI3ODMyNToxYTYzY2I4ZC05YTgyLTQyMWEtYmRlYS05N2FhMGI5OWVkNjQiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJhZG1pbi1jbGkiLCJhdXRoX3RpbWUiOjAsInNlc3Npb25fc3RhdGUiOiI2OGNkOTBlNy02YjkzLTRiZDMtOGM4Yi0yNzZlZmRjMzhjY2IiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInNjb3BlIjoiIiwibmFtZSI6Ik5hbGluaSBTaGFybWEiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJuYWxpbmluYXV0aXlhbF94MWpnIiwiZ2l2ZW5fbmFtZSI6Ik5hbGluaSIsImZhbWlseV9uYW1lIjoiU2hhcm1hIiwiZW1haWwiOiJuYSoqKipAbmljLmluIn0.CG3qSsVe0nc-knv_-k_FGCN6FZSa_OFJU3pe6F41C6a3DtLNKejapNbV1IcKy_lZVpGpae6jUVIvYqw6tkcQU8GbS44aWRbe_Z0MvWj27GbD2GYaenxkmKb6SbxnpEjKT1m82-p6Ak0gG2I4tV1rgTI5T9l8sXPay5GVxKTTkiGzy5eBLchQZtXXKv0frhN9AOESnwsRJcasPdjPqwb6ZBQth-CCSAlFHWfgA2CJ6j6ZywaqxEc_EqUYvUM4KMuUXsE5mQ4KlYqm99DdiF6LxFcxYpfFixTGENYaAXHCxDcTewfZfxqhWJe3VhsQ8Pv_9uMPauYvKixaeWVlrYLzcQ");      
		    headers.set("Content-Type", "application/json");
		    
		 // set `accept` header
		    JsonParser jp = new JsonParser(); 
		    JsonObject jsonObject = (JsonObject) jp.parse("{\"request\": {\"filters\": {},\"fields\": [],\"sortBy\": {\"createdDate\": \"Desc\"}}}"); 
		    
		    String response = restTemplate.postForObject(uri, jsonObject, String.class);

		    System.out.println(response);
		    // convert your result into json
		}
		
		@GetMapping(value="/countries")
		private List<Object> getCountries()
		{
			String uri = "https://restcountries.eu/rest/v2/all";
			RestTemplate rt= new RestTemplate() ; 
			Object[] countries  = rt.getForObject(uri, Object[].class); 
			return Arrays.asList(countries)  ; 
		}
		/*	@GetMapping("/userList")
		private String userList()
		{
			String uri = "https://igotkarmayogi.gov.in/api/user/v1/search";
			RestTemplate rt= new RestTemplate() ; 
			String msg = rt.getForObject(uri, String.class); 
			return msg+"This is from Welcome call" ; 
		}
		*/
}