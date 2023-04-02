package com.masai.DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.masai.DTO.CriminalDTO;
import com.masai.DTO.CriminalDTOImpl;

public class CriminalDAOImpl implements CriminalDAO {

	@Override
	public void AddCriminal(CriminalDTO cr) throws SQLException {

		try {
			Connection cn = DBUtil.establishDBConnection();
			String querry = "INSERT INTO Criminal (name, dob, gender, identifying_mark, first_arrest_date, arrested_from_ps_area) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = cn.prepareStatement(querry);
			ps.setString(1, cr.getName());
			ps.setDate(2, Date.valueOf(cr.getDob()));
			ps.setString(3, cr.getGender());
			ps.setString(4, cr.getIdentify_mark());
			ps.setDate(5, Date.valueOf(cr.getFa_date()));
			ps.setString(6, cr.getPs_area());

			ps.executeUpdate();
			DBUtil.closeConnection(cn);
		} catch (SQLException x) {
			throw new SQLException(x);
		}
	}

	@Override
	public void UpdateCriminal(CriminalDTO cr) throws SQLException {
		try {
			Connection cn = DBUtil.establishDBConnection();
			// criminal_id | name               | dob        | gender | identifying_mark   | first_arrest_date | arrested_from_ps_area
			String querry = "UPDATE Criminal SET name = ? , dob = ? , gender = ? , identifying_mark = ? , first_arrest_date = ?, arrested_from_ps_area = ?  WHERE criminal_id = ?";
			//String querry = "INSERT INTO Criminal (name, dob, gender, identifying_mark, first_arrest_date, arrested_from_ps_area) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = cn.prepareStatement(querry);
			ps.setString(1, cr.getName());
			ps.setDate(2, Date.valueOf(cr.getDob()));
			ps.setString(3, cr.getGender());
			ps.setString(4, cr.getIdentify_mark());
			ps.setDate(5, Date.valueOf(cr.getFa_date()));
			ps.setString(6, cr.getPs_area());
			ps.setInt(7, cr.getCriminal_id());
			
			ps.executeUpdate();
			DBUtil.closeConnection(cn);
		} catch (SQLException x) {
			throw new SQLException(x);
		}
	}
	
	@Override
	public void DeleteCriminal(CriminalDTO cr)throws SQLException{
		try {
			Connection cn = DBUtil.establishDBConnection();
			String querry = "DELETE FROM Criminal WHERE Criminal_id = ?";
			PreparedStatement ps = cn.prepareStatement(querry);
			ps.setInt(1, cr.getCriminal_id());

			ps.executeUpdate();
			DBUtil.closeConnection(cn);
		} catch (SQLException x) {
			throw new SQLException(x);
		}
		
	}
	
	//============================ SHOW ALL CRIMINALS ==============================
	@Override
	public ArrayList<CriminalDTO> SACriminals() throws SQLException{
		ArrayList<CriminalDTO> list = new ArrayList<>();
		try {
			Connection cn = DBUtil.establishDBConnection();
			String querry = "SELECT * FROM Criminal";
			PreparedStatement ps = cn.prepareStatement(querry);
		
			ResultSet rs = ps.executeQuery();
			if(!DBUtil.isResultSetEmpty(rs)) {
				
				while(rs.next()) {
				
					list.add(new CriminalDTOImpl(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4), rs.getString(5),rs.getDate(6).toLocalDate(), rs.getString(7)));
				}
			}else {
				//THROW EXCEPTION HERE RESULT IS EMPLTY
				System.out.println("empty");
			}
			DBUtil.closeConnection(cn);
		} catch (SQLException x) {
			throw new SQLException(x);
		}
		return list;
	}

}


