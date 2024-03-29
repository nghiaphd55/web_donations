package com.web.donations.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "donation")
public class Donation {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	  private int id;;

	  @Column(name = "code")
	  private String code;
	  
	  @Column(name = "created")
	  private String created;
	  
	  @Column(name = "description")
	  private String description;
	 
	  @Column(name = "end_date")
	  private String end_date;
	  
	  @Column(name = "money")
	  private int money;
	
	  @Column(name = "name")
	  private String name;
	  
	  @Column(name = "organization_name")
	  private String organizationName;
	  
	  @Column(name = "phone_number")
	  private String phoneNumber;
	  
	  @Column(name = "start_date")
	  private String startDate;
	  
	 @Column(name = "status")
	 private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Donation [id=" + id + ", code=" + code + ", created=" + created + ", description=" + description
				+ ", end_date=" + end_date + ", money=" + money + ", name=" + name + ", organizationName="
				+ organizationName + ", phoneNumber=" + phoneNumber + ", startDate=" + startDate + ", status=" + status
				+ "]";
	}
}
