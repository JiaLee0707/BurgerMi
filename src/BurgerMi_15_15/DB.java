package BurgerMi_15_15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DB {

	String name;
	Connection conn = null;
	PreparedStatement pstmt = null;

	DB() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgermi", "root", "apmsetup");
			System.out.println("DB 연결 완료");
		} catch (SQLException ex) {
			System.out.println("SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
	}

	public void Insert(int s) {
		String rank = null;
		String score = Integer.toString(s);
		
		name = JOptionPane.showInputDialog("이름을 입력하세요.");
		
		try {
			String sql = "SELECT * FROM ranking ORDER BY score ASC;";
			
			int num = 0;
//			ResultSet rs = pstmt.executeQuery("SELECT COUNT(*) FROM test_tbl");
			ResultSet rs = pstmt.executeQuery("SELECT * FROM ranking;");
//	        if(rs.next()) {
//	        	num = rs.getInt(1);
//	        	System.out.println("Total rows : " + num);
//	        }
			rs.last();
			num = rs.getRow();
	        	
			String no = Integer.toString(num+1);
			System.out.println(no);
			
			pstmt = conn.prepareStatement(sql);
			ResultSet srs = pstmt.executeQuery();
			do {
				int dbScore = Integer.parseInt((srs.getString("score")));
				if (Integer.parseInt(no) <= 1) {
					rank = "1";
				} else if(s > dbScore) {
					rank = Integer.toString(Integer.parseInt(srs.getString("rank"))-1);
				} else if (s == dbScore) {
					rank = Integer.toString(Integer.parseInt(srs.getString("rank")));
				}
				break;
			}while(srs.next());
			
			System.out.println(no + ", " + score + ", " + name + ", " + rank);
			
			sql = "insert into ranking (no, score, name, rank) values (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
//			String no = "1";
			pstmt.setString(1, no);
			pstmt.setString(2, score);
			pstmt.setString(3, name);
			pstmt.setString(4, rank);
		
			pstmt.executeUpdate();
			
			sql = "select * from ranking";
			pstmt = conn.prepareStatement(sql);
			srs = pstmt.executeQuery();
			while(srs.next()) {
				System.out.print(srs.getString("no")+" ");
				System.out.print(srs.getString("score")+" ");
				System.out.print(srs.getString("name")+" ");
				System.out.print(srs.getString("rank")+" ");
				System.out.println();
			}
		}catch(SQLException ex) {
			System.out.println("SQLException:" + ex);
		}catch(Exception ex) {
			System.out.println("Exception:" + ex);
		}finally {
			if(conn != null)
				try {
					conn.close();
				}catch(SQLException sqle) {}
			if(pstmt != null) 
				try {
					pstmt.close();
				}catch(SQLException sqle) {}
		}
	}
}
