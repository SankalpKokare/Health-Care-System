package com.cdac.rest.entities;

import java.util.List;

public class AppointmentTimeRequest {
	
	   private List<String> selectedSlots;
	    private Integer loginId;
	    private String date;
	    
	    
		public List<String> getSelectedSlots() {
			return selectedSlots;
		}
		public void setSelectedSlots(List<String> selectedSlots) {
			this.selectedSlots = selectedSlots;
		}
		public Integer getLoginId() {
			return loginId;
		}
		public void setLoginId(Integer loginId) {
			this.loginId = loginId;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}

	    

}
