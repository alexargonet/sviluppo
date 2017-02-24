package com.crunchify.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cpm.crunchify.model.Materiale;


public class MagDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*public int insertCar(Car car) {
		String inserQuery = "insert into cars (id, model, price) values (?, ?, ?) ";
		Object[] params = new Object[] { car.getId(), car.getModel(), car.getPrice() };
		int[] types = new int[] { Types.INTEGER, Types.VARCHAR, Types.INTEGER };

		return jdbcTemplate.update(inserQuery, params, types);
	}

	public void deleteCar(int model) {
		String delQuery = "delete from cars where id = ?";
		int count = jdbcTemplate.update(delQuery, new Object[] { model });
		if (count != 0)
			System.out.println("Car deleted successfully.");
		else
			System.out.println("Car with given id as it doesn't exist");
	}*/
	
	public List<Materiale> listMag() {
		String selQuery = "select * from `dettaglio carico`";
		return jdbcTemplate.query(selQuery, new RowMapper<Materiale>() {		 
	        public Materiale mapRow(ResultSet rs, int rowNum) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Materiale materiale = new Materiale();
	            	materiale.setID(rs.getString("ID"));
	            	materiale.setID_CARICO(rs.getString("ID_CARICO"));
	            	materiale.setC_L(rs.getString("C_L"));
	            	materiale.setDEPOSITO(rs.getString("DEPOSITO"));
	            	materiale.setSP(rs.getDouble("SP"));
	            	materiale.setSV(rs.getDouble("SV"));
	            	materiale.setSL(rs.getDouble("SL"));
	            	materiale.setL(rs.getDouble("L"));
	            	materiale.setVOCE(rs.getString("VOCE"));
	            	materiale.setQUAL(rs.getString("QUAL"));
	            	materiale.setET_FORN(rs.getString("ET_FORN"));
	            	materiale.setPESO(rs.getDouble("PESO"));
	            	materiale.setNUMPZ(rs.getInt("NUMPZ"));
	            	materiale.setNOTA(rs.getString("NOTA"));
	                return materiale;
	            }
	            return null;
	        }
	    });
	}
	
}