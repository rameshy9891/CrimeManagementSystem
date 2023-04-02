package com.masai.DTO;

import java.time.LocalDate;

public interface CrimeDTO {
	public int getCrime_id();
	public String getType() ;
	public String getDescription() ;
	public String getPs_area();
	public LocalDate getDate();
	public String getVictim();
	void setCrime_id(int crime_id);
	void setType(String type);
	void setDescription(String description);
	void setPs_area(String ps_area);
	void setDate(LocalDate date);
	void setVictim(String victim);
		
}
