package BurgerMi_15_15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			System.out.println("DB ���� �Ϸ�");
		} catch (SQLException ex) {
			System.out.println("SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
	}

	public void Insert(int s) {
		String rank = null;
		String score = Integer.toString(s);
		
		name = JOptionPane.showInputDialog("�̸��� �Է��ϼ���.");
		// name�� ��Java Kim�� ����
		// ����ڰ� �Է� ���� â�� ������ null ����

		try {
			String sql = "SELECT * FROM ranking order by score asc;";
			pstmt = conn.prepareStatement(sql);
			ResultSet srs = pstmt.executeQuery();
			while(srs.next()) {
				int dbScore = Integer.parseInt((srs.getString("score")));
				if(s >= dbScore) {
					rank = Integer.toString(Integer.parseInt(srs.getString("rank"))-1);
					break;
				}
			}
		
			sql = "insert into ranking (rank, name, score) values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rank);
			pstmt.setString(2, name);
			pstmt.setString(3, score);
		
			pstmt.executeUpdate();
			
			sql = "select * from ranking";
			pstmt = conn.prepareStatement(sql);
			srs = pstmt.executeQuery();
			while(srs.next()) {
				System.out.print(srs.getString("rank")+" ");
				System.out.print(srs.getString("name")+" ");
				System.out.print(srs.getString("score")+" ");
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
