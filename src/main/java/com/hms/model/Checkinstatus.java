package com.hms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "checkinstatus")
public class Checkinstatus implements Serializable {
	
	@Id
	@Column
	private int visitid;
	
	@Column
	private Checkinstate checkinstate;

	public int getVisitid() {
		return visitid;
	}

	public void setVisitid(int visitid) {
		this.visitid = visitid;
	}

	public Checkinstate getCheckinstate() {
		return checkinstate;
	}

	public void setCheckinstate(Checkinstate checkinstate) {
		this.checkinstate = checkinstate;
	}
	
	
	
	

}
