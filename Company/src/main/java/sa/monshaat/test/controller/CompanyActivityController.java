package sa.monshaat.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
public class CompanyActivityController {

	@Autowired
	private CompanyServices companyServices ; 
	@Autowired
	private ActivityServices activityServices;
	@Autowired
	private CompanyActivityServices companyActivityServices;
	

	@RequestMapping(method = RequestMethod.POST,value="/CompanyActivity/{companyId}/{activityId}")
	public void addActivityToCompany(@PathVariable int companyId ,@PathVariable int activityId) {
		Company tempCompany =companyServices.getCompany(companyId);
		Activity tempActivity=activityServices.getActivity(activityId);
		CompanyActivity tempCompanyActivity= new CompanyActivity();
		tempCompanyActivity.setActivity(tempActivity);
		tempCompanyActivity.setCompanyActivities(tempCompany);
		tempCompany.addActivity(tempCompanyActivity);
		tempActivity.addCompany(tempCompanyActivity);
		companyActivityServices.addCompanyActivity(tempCompanyActivity);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/CompanyActivity/{companyActivityId}")
	public void deleteCompanyActivity(@PathVariable int companyActivityId) {
		companyActivityServices.deleteCompanyActivity(companyActivityId);
	}
//	first take companyActivityId form this id  extract the obj Company then remove old CompanyActivity 
	@RequestMapping(method = RequestMethod.PUT,value="/CompanyActivity/{companyActivityId}/{activityId}")
	public void updateComapanyActivity(@PathVariable int companyActivityId ,@PathVariable int activityId) {
//		this new Activity
		Activity tempActivity=activityServices.getActivity(activityId);
//		 extract  Company from companyActivityId
		Company tempCompany =companyActivityServices.getCompanyActivity(companyActivityId).getCompany();
		companyActivityServices.deleteCompanyActivity(companyActivityId);
//		make new CompanyActivity and put the tempActivity and tempCompany
		CompanyActivity tempCompanyActivity=new CompanyActivity() ;
		tempCompanyActivity.setActivity(tempActivity);
		tempCompanyActivity.setCompanyActivities(tempCompany);
		
		tempActivity.addCompany(tempCompanyActivity);
		tempCompany.addActivity(tempCompanyActivity);
		
		companyActivityServices.addCompanyActivity(tempCompanyActivity);
	}
	
}
