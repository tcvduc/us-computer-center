package HCMUS.Computer.Center.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import HCMUS.Computer.Center.Logic.DBConfig;

public class LopHocDB extends DBConfig {

	private String tblName="lophoc";
	
	private Vector<String>maLopHocData=new Vector<String>(0);
	private Vector<String>tenLopHocData=new Vector<String>(0);
	
	public LopHocDB() {
		layThongTin();
	}
	
	public void layThongTin() {
		try {
			Connection conn= DriverManager.getConnection(url,username,password);
			System.out.println("Connected to Database");
			
			
			Statement stmt=conn.createStatement();
			String sql="select * from "+tblName;
			
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				String maLop=rs.getString("maLop");
				String tenLop=rs.getString("tenLop");
		
				maLopHocData.add(maLop);
				tenLopHocData.add(tenLop);
	
			}
			

			stmt.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Connection to database have been errors");
			System.out.println(e);
		}
		
	}
	
	public Vector<String> layTatCaMaLopHoc() {
//		layThongTin();
		return maLopHocData;
	}
	
	public Vector<String> layTatCaTenLopHoc() {
//		layThongTin();
		return tenLopHocData;
	}
}
