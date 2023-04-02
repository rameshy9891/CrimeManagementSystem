package com.masai.DTO;


import java.time.LocalDate;

public class CriminalDTOImpl implements CriminalDTO {
	// System.out.println(name+" "+dob+" "+gender+" "+identify_mark+" "+fa_date+"
	// "+ps_area);
	private int criminal_id;
	private String name;
	private LocalDate dob;
	private String gender;
	private String identify_mark;
	private LocalDate fa_date;
	private String ps_area;

	public CriminalDTOImpl() {
		super();
	}

	public CriminalDTOImpl(int criminal_id, String name, LocalDate dob, String gender, String identify_mark,
			LocalDate fa_date, String ps_area) {
		super();
		this.criminal_id = criminal_id;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.identify_mark = identify_mark;
		this.fa_date = fa_date;
		this.ps_area = ps_area;
	}

	@Override
	public int getCriminal_id() {
		return criminal_id;
	}

//	@Override
//	public void setCriminal_id(String criminal_id) {
//		this.criminal_id = criminal_id;
//	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public LocalDate getDob() {
		return dob;
	}

	@Override
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String getIdentify_mark() {
		return identify_mark;
	}

	@Override
	public void setIdentify_mark(String identify_mark) {
		this.identify_mark = identify_mark;
	}

	@Override
	public LocalDate getFa_date() {
		return fa_date;
	}

	@Override
	public void setFa_date(LocalDate fa_date) {
		this.fa_date = fa_date;
	}

	@Override
	public String getPs_area() {
		return ps_area;
	}

	@Override
	public void setPs_area(String ps_area) {
		this.ps_area = ps_area;
	}
}
