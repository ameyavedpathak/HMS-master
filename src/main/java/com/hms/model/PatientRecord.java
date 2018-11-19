package com.hms.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patientrecord")
public class PatientRecord implements Serializable
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int visitid;
	
	@Column
	private int pid;
	
	@Column
	private Date visitdatetime;
	
	@Column
	private String reasonforvisit;
	
	@Column
	private String paymenttype;	
	

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public int getVisitid() {
		return visitid;
	}

	public void setVisitid(int visitid) {
		this.visitid = visitid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Date getVisitdatetime() {
		return visitdatetime;
	}

	public void setVisitdatetime(Date visitdatetime) {
		this.visitdatetime = visitdatetime;
	}

	public String getReasonforvisit() {
		return reasonforvisit;
	}

	public void setReasonforvisit(String reasonforvisit) {
		this.reasonforvisit = reasonforvisit;
	}
	
	
	
	
	
	
}
