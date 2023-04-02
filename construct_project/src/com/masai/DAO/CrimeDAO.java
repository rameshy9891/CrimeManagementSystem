package com.masai.DAO;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.masai.DTO.CrimeDTO;
import com.masai.DTO.CrimeStationDTO;

public interface CrimeDAO {

	public void ADDCrime(CrimeDTO cr) throws SQLException;

	public void UpdateCrime(CrimeDTO cr) throws SQLException;

	void RemoveCrime(CrimeDTO cr) throws SQLException;

	ArrayList<CrimeDTO> SACrimes() throws SQLException;

	ArrayList<CrimeStationDTO> viewCrByDRange(LocalDate sd, LocalDate ed) throws SQLException;

}
