package com.example.vehiclerentalsystem.dto;

public class TestimonialDTO {
	private long testimonialsid;
	private long userid;
	private String feedback;
	private boolean isactive;
	
	public TestimonialDTO() {
		super();
	}
	public TestimonialDTO(long testimonialsid, long userid, String feedback, boolean isactive) {
		super();
		this.testimonialsid = testimonialsid;
		this.userid = userid;
		this.feedback = feedback;
		this.isactive = isactive;
	}
	public long getTestimonialsid() {
		return testimonialsid;
	}
	public void setTestimonialsid(long testimonialsid) {
		this.testimonialsid = testimonialsid;
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
