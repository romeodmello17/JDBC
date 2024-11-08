package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/Rahul?user=postgres&password=root";

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url);

			Statement stm = con.createStatement();

			String sql = "select * from employee order by empid";

			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				System.out.println("=======Emplyoee==========");
				int eid = rs.getInt(1);
				String ename = rs.getString(2);
				long enumber = rs.getLong(3);

				System.out.println(eid);
				System.out.println(ename);
				System.out.println(enumber);
				System.out.println("=================");
			}

			con.close();

			System.out.println("Executed");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
