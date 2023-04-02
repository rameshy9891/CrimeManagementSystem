package com.masai.DTO;

import java.time.LocalDate;

public interface CriminalDTO {

	public int getCriminal_id();

	//public void setCriminal_id(String criminal_id);

	public String getName();

	public void setName(String name);

	public LocalDate getDob();

	public void setDob(LocalDate dob);

	public String getGender();

	public void setGender(String gender);

	public String getIdentify_mark();

	public void setIdentify_mark(String identify_mark);

	public LocalDate getFa_date();

	public void setFa_date(LocalDate fa_date);

	public String getPs_area();

	public void setPs_area(String ps_area);
}
