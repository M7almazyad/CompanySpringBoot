package sa.monshaat.test.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sa.monshaat.test.model.CompanyActivity;
import sa.monshaat.test.repositories.CompanyActivityRepositories;

@Service
public class CompanyActivityServices {
	@Autowired
	private CompanyActivityRepositories CompanyActivityRepositories;

	public List<CompanyActivity> getAllCompanyActivities(){
		return (List<CompanyActivity>) CompanyActivityRepositories.findAll();
	}
	public CompanyActivity getCompanyActivity(int id){
		return  CompanyActivityRepositories.findById(id).get();
	}
	
	
	public void addCompanyActivity(CompanyActivity companyActivity) {
		CompanyActivityRepositories.save(companyActivity);
	}
	public void updateCompanyActivity(CompanyActivity companyActivity) {
		CompanyActivityRepositories.save(companyActivity);
	}
	public void deleteCompanyActivity(int id) {
		CompanyActivityRepositories.deleteById(id);;
	}
}
