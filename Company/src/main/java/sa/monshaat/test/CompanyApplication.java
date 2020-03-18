package sa.monshaat.test;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import sa.monshaat.test.controller.JsonCompany;
import sa.monshaat.test.model.Company;

@SpringBootApplication
@ComponentScan(basePackages={"sa.monshaat.test"})
public class CompanyApplication {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		SpringApplication.run(CompanyApplication.class, args);
		
	
	}
	


}
