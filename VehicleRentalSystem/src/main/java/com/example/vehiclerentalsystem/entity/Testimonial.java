package com.example.vehiclerentalsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Testimonial {
	@Id
	private  long testimonialid;
	private long userid;//foreign key
	private String feedback;
	private boolean isactive;
	
	public Testimonial() {
		super();
	}
	public Testimonial(long testimonialid, long userid, String feedback, boolean isactive) {
		super();
		this.testimonialid = testimonialid;
		this.userid = userid;
		this.feedback = feedback;
		this.isactive = isactive;
	}
	public long getTestimonialid() {
		return testimonialid;
	}
	public void setTestimonialid(long testimonialid) {
		this.testimonialid = testimonialid;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	
	

}
