package sa.monshaat.test.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

@Entity(name = "CompanyActivity")
@Table(name = "company_activity", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "activity_id", "company_id" }) })
public class CompanyActivity extends Base {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY ,cascade =  {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "activity_id")
	@JsonIgnoreProperties("companyActivities")
	private Activity activity;

	@ManyToOne(fetch = FetchType.LAZY , cascade =  {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "company_id")
	@JsonIgnoreProperties("activities")
	private Company companyActivities;

	public CompanyActivity() {
	}

	public CompanyActivity(int id, Activity activity, Company companyActivities) {
		this.id = id;
		this.activity = activity;
		this.companyActivities = companyActivities;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Company getCompany() {
		return companyActivities;
	}

	public void setCompanyActivities(Company companyActivities) {
		this.companyActivities = companyActivities;
	}
	

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((activity == null) ? 0 : activity.hashCode());
//		result = prime * result + ((companyActivities == null) ? 0 : companyActivities.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		CompanyActivity other = (CompanyActivity) obj;
//		if (activity == null) {
//			if (other.activity != null)
//				return false;
//		} else if (!activity.equals(other.activity))
//			return false;
//		if (companyActivities == null) {
//			if (other.companyActivities != null)
//				return false;
//		} else if (!companyActivities.equals(other.companyActivities))
//			return false;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
//	}

}
