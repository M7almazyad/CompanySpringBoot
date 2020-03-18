package sa.monshaat.test.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Nationalized;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

@Entity(name = "Activity")
@Table(name = "activity", uniqueConstraints = { @UniqueConstraint(columnNames = { "isicCode" }) })
public class Activity extends Base {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String isicCode;

	@Nationalized
	@Column(nullable = false)
	private String isicName;
//	cascade without remove because if remove CompanyActivity don't remove activity
	@OneToMany(mappedBy = "activity", cascade = {CascadeType.DETACH,CascadeType.MERGE,
										CascadeType.PERSIST,CascadeType.REFRESH}, orphanRemoval = true)
	private Set<CompanyActivity> activities = new HashSet<>();


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsicCode() {
		return isicCode;
	}

	public void setIsicCode(String isicCode) {
		this.isicCode = isicCode;
	}

	public String getIsicName() {
		return isicName;
	}

	public void setIsicName(String isicName) {
		this.isicName = isicName;
	}
	public void addCompany(CompanyActivity companyActivity) {
		companyActivity.setActivity(this);
		activities.add(companyActivity);
	}

}
