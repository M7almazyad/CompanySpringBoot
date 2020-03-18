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
import sa.monshaat.test.repositories.ActivityRepositories;

@Service
public class ActivityServices {
	@Autowired
	private ActivityRepositories ActivityRepositories;

	public List<Activity> getAllActivitys(){
		return (List<Activity>) ActivityRepositories.findAll();
	}
	
	public Activity getActivity(int id){
		return  ActivityRepositories.findById(id).get();
	}
	
	
	public void addActivity(Activity activity) {
		ActivityRepositories.save(activity);
	}
	public void updateActivity(Activity activity) {
		ActivityRepositories.save(activity);
	}
	
	public void deleteActivity(int id) {
		ActivityRepositories.deleteById(id);
	}	

	
	
}
