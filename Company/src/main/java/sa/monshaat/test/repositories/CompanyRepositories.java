package sa.monshaat.test.repositories;

import org.springframework.data.repository.CrudRepository;
import sa.monshaat.test.model.Company;

public  interface CompanyRepositories extends CrudRepository<Company,Integer> {

	

}
