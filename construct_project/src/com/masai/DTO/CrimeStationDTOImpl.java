package com.masai.DTO;

public class CrimeStationDTOImpl implements CrimeStationDTO {
	private int count;
	private String p_station;
	public CrimeStationDTOImpl() {
		super();
	}
	public CrimeStationDTOImpl(int count, String p_station) {
		super();
		this.count = count;
		this.p_station = p_station;
	}
	
	@Override
	public int getCount() {
		return count;
	}
	
	@Override
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String getP_station() {
		return p_station;
	}
	
	@Override
	public void setP_station(String p_station) {
		this.p_station = p_station;
	}
	
}
