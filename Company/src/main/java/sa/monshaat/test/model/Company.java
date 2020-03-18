package sa.monshaat.test.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Nationalized;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "Company")
@Table(name = "company", uniqueConstraints = { @UniqueConstraint(columnNames = { "crNumber" })
		/* ,@UniqueConstraint(columnNames = { "nationalNumber" }) */ })
public class Company  {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String crNumber;

	private String nationalNumber;

	@Nationalized
	private String crName;

	@Nationalized
	private String crNameAr;

	@Nationalized
	private String crType;

	private String mainCRNumber;
	private double capital;

	@Nationalized
	private String legalTypeAr;

	@Nationalized
	private String legalTypeEn;

	@Nationalized
	private String status;

	@Nationalized
	private String statusDate;

	@Nationalized
	private String statusReason;

	private String issueDate;

	private String expiryDate;

//	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
//	@JsonIgnoreProperties("company")
//	private Set<IndividualCompany> individuals = new HashSet<>();
	
	
//	cascade without remove because if remove CompanyActivity don't remove Company
	@OneToMany(mappedBy = "companyActivities", cascade =  {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH}, orphanRemoval = true)
	@JsonIgnoreProperties("companyActivities")
	private Set<CompanyActivity> activities = new HashSet<>();

	public Company() {
	}

	public String getCrNumber() {
		return crNumber;
	}

	public void setCrNumber(String crNumber) {
		this.crNumber = crNumber;
	}

	public String getNationalNumber() {
		return nationalNumber;
	}

	public void setNationalNumber(String nationalNumber) {
		this.nationalNumber = nationalNumber;
	}

	public String getCrName() {
		return crName;
	}

	public void setCrName(String crName) {
		this.crName = crName;
	}

	public String getCrNameAr() {
		return crNameAr;
	}

	public void setCrNameAr(String crNameAr) {
		this.crNameAr = crNameAr;
	}

	public String getCrType() {
		return crType;
	}

	public void setCrType(String crType) {
		this.crType = crType;
	}

	public String getMainCRNumber() {
		return mainCRNumber;
	}

	public void setMainCRNumber(String mainCRNumber) {
		this.mainCRNumber = mainCRNumber;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public String getLegalTypeAr() {
		return legalTypeAr;
	}

	public void setLegalTypeAr(String legalTypeAr) {
		this.legalTypeAr = legalTypeAr;
	}

	public String getLegalTypeEn() {
		return legalTypeEn;
	}

	public void setLegalTypeEn(String legalTypeEn) {
		this.legalTypeEn = legalTypeEn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public String getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Set<CompanyActivity> getActivities() {
		return activities;
	}

	public void setActivities(Set<CompanyActivity> activities) {
		this.activities = activities;
	}
	public void addActivity(CompanyActivity companyActivity) {
		companyActivity.setCompanyActivities(this);
		activities.add(companyActivity);
	}

//	public void addIndividual(Individual individual) {
//		IndividualCompany individualCompany = new IndividualCompany(individual, this);
//		individuals.add(individualCompany);
//		individual.getCompanies().add(individualCompany);
//	}
//
//	public void removeIndividual(Individual individual) {
//		for (Iterator<IndividualCompany> iterator = individuals.iterator(); iterator.hasNext();) {
//			IndividualCompany individualCompanies = iterator.next();
//
//			if (individualCompanies.getCompany().equals(this)
//					&& individualCompanies.getIndividual().equals(individual)) {
//				iterator.remove();
//				individualCompanies.getIndividual().getCompanies().remove(individualCompanies);
//				individualCompanies.setCompany(null);
//				individualCompanies.setIndividual(null);
//			}
//		}
//	}

//	@Override
//	public boolean equals(Object o) {
//		if (this == o)
//			return true;
//		if (o == null || getClass() != o.getClass())
//			return false;
//		Company company = (Company) o;
//		return Objects.equals(this.getId(), company.getId());
//	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(this.getId());
//	}
//
//	public Set<IndividualCompany> getIndividuals() {
//		return individuals;
//	}
//
//	public void setIndividuals(Set<IndividualCompany> individuals) {
//		this.individuals = individuals;
//	}

}
