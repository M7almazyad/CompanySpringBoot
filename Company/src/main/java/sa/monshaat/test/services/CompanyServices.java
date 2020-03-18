package sa.monshaat.test.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sa.monshaat.test.controller.JsonCompany;
import sa.monshaat.test.model.Activity;
import sa.monshaat.test.model.Company;
import sa.monshaat.test.model.CompanyActivity;
import sa.monshaat.test.repositories.CompanyRepositories;

@Service
public class CompanyServices {
	@Autowired
	private CompanyRepositories companyRepositories;
	
	public List<Company> getAllCompanys(){
		return (List<Company>) companyRepositories.findAll();
	}
	public Company getCompany(int id){
		return companyRepositories.findById(id).get();
	}
	public void addCompany(Company company) {
		companyRepositories.save(company);
	}
	
	public void updateCompany(Company company) {
		companyRepositories.save(company);
	}
	public void deleteCompany(int id) {
		companyRepositories.deleteById(id);;
	}
	
	
	
	
}
