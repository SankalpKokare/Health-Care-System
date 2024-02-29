package com.cdac.rest.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment_time")
public class AppointmentTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appoint_id")
    private Integer id;

    @Column(name = "doc_id")
    private Integer doctorId;

    @Column(name = "slot_start")
    private String slotStart;

    @Column(name = "slot_end")
    private String slotEnd;

    @Column(name = "flag")
    private int flag;

    @Column(name = "day")
    private String day;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getSlotStart() {
		return slotStart;
	}

	public void setSlotStart(String slotStart) {
		this.slotStart = slotStart;
	}

	public String getSlotEnd() {
		return slotEnd;
	}

	public void setSlotEnd(String slotEnd) {
		this.slotEnd = slotEnd;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

    
}
