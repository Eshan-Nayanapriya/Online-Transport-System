package com.rental;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
	private static Connection conn = null;
	private static Statement stmt = null;
	private static boolean updated;
	private static boolean deleted;
	private static boolean Inserted;

	public static boolean validateLogin(String username, String password) {
		try {
			conn = DBconnect.getDBConnection();
			stmt = conn.createStatement();

			String sql = "SELECT * FROM login_details WHERE tusername = '" + username + "' AND tpassword = '" + password
					+ "'";
			ResultSet rs = stmt.executeQuery(sql);

			return rs.next(); // If a row is found, the login is valid.
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static List<RentDetails> read() {
		ArrayList<RentDetails> rent = new ArrayList<>();

		try { 
			conn = DBconnect.getDBConnection();
			stmt = conn.createStatement();

			String sql = "select * from new_table ORDER BY rentid DESC LIMIT 1";// *******************************table
																				// name and rentid
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String pickloc = rs.getString(3);
				String droploc = rs.getString(4);
				String email = rs.getString(5);
				String phone = rs.getString(6);
				String other = rs.getString(7);

				RentDetails r = new RentDetails(id, name, pickloc, droploc, email, phone, other);
	
				rent.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rent;
	}

	public static boolean insert(String DBVname, String DBVpickLocation, String DBVdropLocation, String DBVemail,
			String DBVphone, String DBVother) {
		try {
			conn = DBconnect.getDBConnection();
			stmt = conn.createStatement();

			String sql = "insert into new_table values(0, '" + DBVname + "', '" + DBVpickLocation + "', '"
					+ DBVdropLocation + "', '" + DBVemail + "','" + DBVphone + "','" + DBVother + "')";// **************table
																										// name
			int sqlQueryCheck = stmt.executeUpdate(sql); // this returns 1 ,if the insert is done.

			if (sqlQueryCheck > 0) {
				Inserted = true;
			} else {
				Inserted = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Inserted;
	}

	public static boolean update(String DBUid, String DBUname, String DBUpickLocation, String DBUdropLocation,
			String DBUemail, String DBUphone, String DBUother) {
		try {
			conn = DBconnect.getDBConnection();
			stmt = conn.createStatement();

			String sql = "update new_table set dbb='" + DBUname + "', dbb2='" + DBUpickLocation + "', dbb3='"
					+ DBUdropLocation + "', dbb4='" + DBUemail + "', dbb5='" + DBUphone + "', dbb6='" + DBUother + "'"
					+ "where rentid='" + DBUid + "'";
			int rs = stmt.executeUpdate(sql);
			if (rs > 0) {
				updated = true;
			} else {
				updated = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updated;
	}

	public static boolean delete(String DBDUid) {

		int deleteID = Integer.parseInt(DBDUid); // wrapper class

		try {

			conn = DBconnect.getDBConnection();
			stmt = conn.createStatement();
			String sql = "delete from new_table where rentid='" + deleteID + "'";
			int r = stmt.executeUpdate(sql);

			if (r > 0) {
				deleted = true;
			} else {
				deleted = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleted;
	}
	
	
	//************
	
	public static double CalculateDistance(String pickupLocation,String dropLocation) {
		
		 double distance = 0;
		 double amount = 0;

	        if ((pickupLocation.equals("matara") && dropLocation.equals("weligama")) || (pickupLocation.equals("weligama") && dropLocation.equals("matara"))) {
	            distance = 17;
	        } else if ((pickupLocation.equals("matara") && dropLocation.equals("dickwella")) || (pickupLocation.equals("dickwella") && dropLocation.equals("matara"))) {
	            distance = 22;
	        } else if ((pickupLocation.equals("matara") && dropLocation.equals("kamburugamuwa")) || (pickupLocation.equals("kamburugamuwa") && dropLocation.equals("matara"))) {
	            distance = 7;
	        } else if ((pickupLocation.equals("matara") && dropLocation.equals("galle")) || (pickupLocation.equals("galle") && dropLocation.equals("matara"))) {
	            distance = 44;
	        } else if ((pickupLocation.equals("weligama") && dropLocation.equals("dickwella")) || (pickupLocation.equals("dickwella") && dropLocation.equals("weligama"))) {
	            distance = 42;
	        } else if ((pickupLocation.equals("weligama") && dropLocation.equals("kamburugamuwa")) || (pickupLocation.equals("kamburugamuwa") && dropLocation.equals("weligama"))) {
	            distance = 11.5;
	        } else if ((pickupLocation.equals("weligama") && dropLocation.equals("galle")) || (pickupLocation.equals("galle") && dropLocation.equals("weligama"))) {
	            distance = 28;
	        } else if ((pickupLocation.equals("dickwella") && dropLocation.equals("kamburugamuwa")) || (pickupLocation.equals("kamburugamuwa") && dropLocation.equals("dickwella"))) {
	            distance = 28.5;
	        } else if ((pickupLocation.equals("dickwella") && dropLocation.equals("galle")) || (pickupLocation.equals("galle") && dropLocation.equals("dickwella"))) {
	            distance = 61.5;
	        } else if ((pickupLocation.equals("kamburugamuwa") && dropLocation.equals("galle")) || (pickupLocation.equals("galle") && dropLocation.equals("kamburugamuwa"))) {
	            distance = 39;
	        } else {
	            distance = 1;
	            }
		
	        amount = CalcAmount(distance);
	        
		return amount ;
	}
	
	public static double CalcAmount(double Distance) {
		double amount = 0;
		double pricePerKM = 30;
		double priceForVehicle = 1000;
		
		if(Distance == 1) {
			amount = 500;
		}
		else {
		amount = (Distance * pricePerKM) + priceForVehicle;
		}
		return amount;
	}

}
