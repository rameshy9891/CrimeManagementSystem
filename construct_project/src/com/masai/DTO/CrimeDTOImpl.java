package com.masai.DTO;

import java.time.LocalDate;

public class CrimeDTOImpl implements CrimeDTO {

	private int crime_id = 0;
	private String type;
	private String description;
	private String ps_area;
	private LocalDate date;
	private String victim;

	public CrimeDTOImpl() {
		super();
	}

	public CrimeDTOImpl(int crime_id, String type, String description, String ps_area, LocalDate date, String victim) {
		super();
		this.crime_id = crime_id;
		this.type = type;
		this.description = description;
		this.ps_area = ps_area;
		this.date = date;
		this.victim = victim;
	}

	@Override
	public int getCrime_id() {
		return crime_id;
	}

	@Override
	public void setCrime_id(int crime_id) {
		this.crime_id = crime_id;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getPs_area() {
		return ps_area;
	}

	@Override
	public void setPs_area(String ps_area) {
		this.ps_area = ps_area;
	}

	@Override
	public LocalDate getDate() {
		return date;
	}

	@Override
	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String getVictim() {
		return victim;
	}

	@Override
	public void setVictim(String victim) {
		this.victim = victim;
	}

}
