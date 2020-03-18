package sa.monshaat.test.controller;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONObject;

import sa.monshaat.test.model.Activity;
import sa.monshaat.test.model.Company;
import sa.monshaat.test.model.CompanyActivity;

public class JsonCompany {

public Company getCompanyJson(String json) {

		JSONObject js = new JSONObject(json);
		Company company= new Company();
		company.setNationalNumber(js.getString("nationalNumber"));
		company.setCrType(js.getString("crType"));
//		company.setMainCRNumber(js.getString("mainCRNumber").toString());
		company.setIssueDate(js.getJSONObject("expiryDate").getString("gregorianDate"));
		company.setCrNameAr(js.getString("nameAr"));
		company.setCapital(js.getDouble("capital"));
//		company.setLegalTypeEn(js.getString("legalTypeEn"));
		company.setLegalTypeEn(js.getString("legalTypeAr"));
		company.setStatus(js.getJSONObject("status").getString("status"));
	//			company.setStatusDate(js.getJSONObject("status").getString("statusDate"));
	//			company.setStatusReason(js.getJSONObject("status").getString("statusReason"));
		Activity temp=new Activity();
		
		temp.setIsicCode(js.getJSONObject("activities")
				.getJSONArray("isicActivities").get(0).toString());
		temp.setIsicName(js.getJSONObject("activities")
				.getJSONArray("isicActivities").get(0).toString());
		
		CompanyActivity companyActivity = new CompanyActivity();
		companyActivity.setActivity(temp);
		company.addActivity(companyActivity);
		return company;

	}
	
}
