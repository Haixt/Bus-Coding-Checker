package model;

import java.io.Serializable;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.*;


public class BusBean implements Serializable {

	private String busName;
	 private String plateNumber;
	 private String driverName;
	 private String codingDay;
	 private char lastDigit;
	 private  Connection connection;
	 
	 
	 public BusBean(){
		 
	 }
	 
	 
	public BusBean(String busName, String plateNumber, String driverName,
			String codingDay, char lastDigit) {
		super();
		this.busName = busName;
		this.plateNumber = plateNumber;
		this.driverName = driverName;
		this.codingDay = codingDay;
		this.lastDigit = lastDigit;
	}


	public String getBusName() {
		return busName;
	}


	public void setBusName(String busName) {
		this.busName = busName;
	}


	public String getPlateNumber() {
		return plateNumber;
	}


	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber.toUpperCase();
		
	}


	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	public String getCodingDay() {
		return codingDay;
	}


	public void setCodingDay(String codingDay) {
		this.codingDay = codingDay;
	}
	 

	public char getLastDigit() {
		return lastDigit;
	}




	public void setLastDigit(char lastDigit) {
		this.lastDigit = lastDigit;
	}




	public void codingCheck(){
		
		this.lastDigit = this.plateNumber.charAt(5);
		
		if(this.lastDigit == '1'|| this.lastDigit == '2'){
			this.codingDay = "Monday";
		}
		else if(this.lastDigit == '3'|| this.lastDigit == '4'){
			this.codingDay = "Tuesday";
		}
		else if(this.lastDigit == '5'|| this.lastDigit == '6'){
			this.codingDay = "Wednesday";
		}
		else if(this.lastDigit == '7'|| this.lastDigit == '8'){
			this.codingDay = "Thursday";
		}
		else if(this.lastDigit == '9'|| this.lastDigit == '0'){
			this.codingDay = "Friday";
		}
	}

	private Connection getConnection() {
		try {
			connection = ((DataSource)InitialContext
					.doLookup("java:/comp/env/jdbc/CSELEC09_DB"))
					.getConnection();
			
			if (connection != null) {
				System.out.println("connection is valid.");
				
			} else {
				System.out.println("connection is null.");
			}
		} catch (NamingException ne) {
			// TODO Auto-generated catch block
			ne.printStackTrace();
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
		} 
		return connection;
	}
	
	public void createTable(){
		
		String sql= "CREATE TABLE `seg31-cselec09_db`.`database` ( `id` INT NOT NULL AUTO_INCREMENT , `busName` VARCHAR(150) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL , `driverName` VARCHAR(150) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL , `plateNumber` VARCHAR(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL , `codingDay` VARCHAR(15) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL , `lastDigit` VARCHAR(15) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
		try{
			connection = getConnection();
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}finally{
			System.out.println(" Table Has Been Successfully Created ");
		}
	}
	
	public boolean insertRecord() {
			boolean isSuccess = false;
		
				String sql = "INSERT INTO `database`(busName, driverName, plateNumber, codingDay, lastDigit) VALUES (?,?,?,?,?)";
				
				try {
					
					if (getConnection() != null) {
						PreparedStatement ptsmnt = connection.prepareStatement(sql);
						
						ptsmnt.setString(1, this.busName);
						ptsmnt.setString(2, this.driverName);
						ptsmnt.setString(3, this.plateNumber);
						ptsmnt.setString(4, this.codingDay);
						ptsmnt.setString(5,String.valueOf(this.lastDigit));
					
						
						ptsmnt.executeUpdate();
						isSuccess = true;
					}
				} catch (SQLException sqle)  {
					sqle.printStackTrace();
				}
				return isSuccess;
	}
}


