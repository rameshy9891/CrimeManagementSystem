package com.masai.DAO;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.masai.DTO.CrimeDTO;
import com.masai.DTO.CrimeDTOImpl;
import com.masai.DTO.CrimeStationDTO;
import com.masai.DTO.CrimeStationDTOImpl;
import com.masai.exceptions.SomethingWentWrong;

public class CrimeDAOImpl implements CrimeDAO {

	// ======================= ADD CRIME DATA IN DATABASE ==========================
	@Override
	public void ADDCrime(CrimeDTO cr) throws SQLException {

		try {
			Connection cn = DBUtil.establishDBConnection();
			String querry = "INSERT INTO Crime (type, description, ps_area, crime_date, name_of_victim) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement ps = cn.prepareStatement(querry);
			ps.setString(1, cr.getType());
			ps.setString(2, cr.getDescription());
			ps.setString(3, cr.getPs_area());
			ps.setDate(4, Date.valueOf(cr.getDate()));
			ps.setString(5, cr.getVictim());

			ps.executeUpdate();
			DBUtil.closeConnection(cn);
		} catch (SQLException x) {
			throw new SQLException(x);
		}
	}

	// =========================== UPDATE CRIME DATA IN DATABASE =====================================
	@Override
	public void UpdateCrime(CrimeDTO cr) throws SQLException {

		try {
			Connection cn = DBUtil.establishDBConnection();
			String querry = "UPDATE Crime SET type = ? , description = ? , ps_area = ? , crime_date = ? , name_of_victim = ? WHERE crime_id = ?";
			PreparedStatement ps = cn.prepareStatement(querry);
			ps.setString(1, cr.getType());
			ps.setString(2, cr.getDescription());
			ps.setString(3, cr.getPs_area());
			ps.setDate(4, Date.valueOf(cr.getDate()));
			ps.setString(5, cr.getVictim());
			ps.setInt(6, cr.getCrime_id());

			ps.executeUpdate();
			DBUtil.closeConnection(cn);
		} catch (SQLException x) {
			throw new SQLException(x);
		}
	}
	
	//================================ REMOVE CRIME DETAILS FROM DATABASE =====================================
	
	@Override
	public void RemoveCrime(CrimeDTO cr) throws SQLException{
		try {
			Connection cn = DBUtil.establishDBConnection();
			String querry = "DELETE FROM Crime WHERE crime_id =  ?";
			PreparedStatement ps = cn.prepareStatement(querry);

			ps.setInt(1, cr.getCrime_id());

			ps.executeUpdate();
			DBUtil.closeConnection(cn);
		} catch (SQLException x) {
			throw new SQLException(x);
		}
	}
	
	//====== SEARCH CRIME BY DATE RANGE AND GRP BY PS_AREA ======================
	@Override
	public ArrayList<CrimeStationDTO> viewCrByDRange(LocalDate sd, LocalDate ed) throws SQLException {
		ArrayList<CrimeStationDTO> list = new ArrayList<>();
		try {
			Connection cn = DBUtil.establishDBConnection();
			String querry = "SELECT COUNT(*), ps_area FROM Crime where crime_date BETWEEN ? AND ? GROUP BY ps_area";
			PreparedStatement ps = cn.prepareStatement(querry);

			ps.setDate(1, Date.valueOf(sd));
			ps.setDate(2, Date.valueOf(ed));

			ResultSet rs = ps.executeQuery();
			if(!DBUtil.isResultSetEmpty(rs)) {
				while(rs.next()) {
					list.add(new CrimeStationDTOImpl(rs.getInt(1), rs.getString(2)));
				}
			}
			//ADD HERE EMPTY RESULT EXCEPTION
			DBUtil.closeConnection(cn);
		} catch (SQLException x) {
			throw new SQLException(x);
		}
		
		return list;
	}
	
	//========================= SHOW ALL CRIME =====================================
	@Override
	public ArrayList<CrimeDTO> SACrimes() throws SQLException {
		
		ArrayList<CrimeDTO> list = new ArrayList<>();
		try {
			Connection cn = DBUtil.establishDBConnection();
			String querry = "SELECT * FROM Crime";
			PreparedStatement ps = cn.prepareStatement(querry);
		
			ResultSet rs = ps.executeQuery();
			if(!DBUtil.isResultSetEmpty(rs)) {
				
				while(rs.next()) {
					//new CrimeDTOImpl(0, querry, querry, ps_area, ed, querry);
					list.add(new CrimeDTOImpl(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDate(5).toLocalDate() , rs.getString(6)));
				}
			}else {
				//THROW EXCEPTION HERE RESULT IS EMPLTY
				System.out.println("empty");
			}
			DBUtil.closeConnection(cn);
		} catch (SQLException x) {
			//System.out.println("I am here");
			x.printStackTrace();
			//throw new SQLException(x);
		}
		return list;
	}
	


}

