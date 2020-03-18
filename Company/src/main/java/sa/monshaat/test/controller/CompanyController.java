package sa.monshaat.test.controller;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sa.monshaat.test.model.Activity;
import sa.monshaat.test.model.Company;
import sa.monshaat.test.model.CompanyActivity;
import sa.monshaat.test.services.ActivityServices;
import sa.monshaat.test.services.CompanyActivityServices;
import sa.monshaat.test.services.CompanyServices;


@RestController
public class CompanyController {
	
	@Autowired
	private CompanyServices companyServices ; 
	
	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/company/get/all")
	public String getAllCompany( ) {
		return companyServices.getAllCompanys().toString();
	}
	
//		this will get company with Activity
	@RequestMapping(method=RequestMethod.GET,value="/company/get/{id}")
	public String getCompany(@PathVariable int id) {
		String str ="";
		Company company = companyServices.getCompany(id);
		for(CompanyActivity act : company.getActivities()) {
			System.out.println(act.getActivity().getIsicCode());
			System.out.println(act.getActivity().getIsicName());
			str=act.getActivity().getIsicCode()+"  /  "+act.getActivity().getIsicName() ;
		}
		return str;
	}

	@RequestMapping(method=RequestMethod.POST,value="/company")
	public void addCompany(@RequestBody Company company ) {
		companyServices.addCompany(company);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/company")
	public void updateCompany(@RequestBody Company company ) {
		companyServices.updateCompany(company);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/company/id")
	public void deleteCompany(@PathVariable int id ) {
		companyServices.deleteCompany(id);
	}
	
	
	
	
	
//	
//	public static String excuteGet(String targetURL)
//	  {
//	    URL url;
//	    HttpURLConnection connection = null;  
//	    try {
//	      //Create connection
//	      url = new URL(targetURL);
//	      connection = (HttpURLConnection)url.openConnection();
//	      connection.setRequestMethod("GET");
//	      connection.setRequestProperty("Content-Type", "application/json");
//
//	      //Get Response	
//	      InputStream is = connection.getInputStream();
//	      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//	      String line;
//	      StringBuffer response = new StringBuffer(); 
//	      while((line = rd.readLine()) != null) {
//	        response.append(line);
//	        response.append('\r');
//	      }
//	      rd.close();
//	      return response.toString();
//
//	    } catch (Exception e) {
//
//	      e.printStackTrace();
//	      return null;
//
//	    } finally {
//
//	      if(connection != null) {
//	        connection.disconnect(); 
//	      }
//	    }
//	  }
//	
	 
	
	
}
