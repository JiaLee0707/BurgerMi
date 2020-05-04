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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgermi?serverTimezone=Asia/Seoul&useSSL=false", "root", "mirim2");
			System.out.println("DB 연결 완료");
		} catch (SQLException ex) {
			System.out.println("SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
	}

	public void Select() {
		try {
			String sql = "SELECT * FROM ranking ORDER BY score ASC";
			pstmt = conn.prepareStatement(sql);
			ResultSet srs = pstmt.executeQuery();
			while(srs.next()) {
				System.out.print(srs.getString("no")+" ");
				System.out.print(srs.getString("score")+" ");
				System.out.print(srs.getString("name")+" ");
				System.out.print(srs.getString("rank")+" ");
				System.out.println();
			}
		} catch(SQLException ex) {
			System.out.println("Select SQLException:" + ex);
		} catch(Exception ex) {
		 	System.out.println("Select Exception:" + ex);
		} finally {
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
	
	public void Insert(int s) {
		int num = 0;
		String rank = null;
		String score = Integer.toString(s);
		
		name = JOptionPane.showInputDialog("이름을 입력하세요.");
		
		try {		
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet srs = stmt.executeQuery("SELECT * FROM ranking");
			srs.last(); //커서의 위치를 제일 뒤로 이동
			num = srs.getRow(); //현재 커서의 Row Index 값을 저장
			String no = Integer.toString(num+1);
			System.out.println(no);

			String sql = "SELECT * FROM ranking ORDER BY score DESC";
			pstmt = conn.prepareStatement(sql);
			srs = pstmt.executeQuery();
			
			if (Integer.parseInt(no) <= 1) {
				rank = "1";
			} else {
				while(srs.next()) {
					int dbScore = Integer.parseInt((srs.getString("score")));
					if(s > dbScore) {
						
						rank = Integer.toString(Integer.parseInt(srs.getString("rank"))-1);
						Update(rank);
						break;
					}
				}
			}
//			while(srs.next()) {
//				if (Integer.parseInt(no) <= 1) {
//					rank = "1";
//				} else {
//					int dbScore = Integer.parseInt((srs.getString("score")));
//					if(s > dbScore) {
//						rank = Integer.toString(Integer.parseInt(srs.getString("rank"))-1);
//					} else if (s == dbScore) {
//						rank = Integer.toString(Integer.parseInt(srs.getString("rank")));
//					} else {
//						rank = Integer.toString(Integer.parseInt(srs.getString("rank"))+1);
//					}
//				}
//			}
			
			sql = "insert into ranking (no, score, name, rank) values (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, score);
			pstmt.setString(3, name);
			pstmt.setString(4, rank);
		
			pstmt.executeUpdate();
			
			Select();
			
		} catch(SQLException ex) {
			System.out.println("Insert SQLException:" + ex);
		} catch(Exception ex) {
			System.out.println("Insert Exception:" + ex);
		}
	}
	
	public void Update(String rank) {
		try {
			String sql = "SELECT * FROM ranking WHERE rank>=? ORDER BY score DESC";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rank);
			ResultSet srs = pstmt.executeQuery();
			int rankInt = Integer.parseInt(rank);
			while(srs.next()) {
				sql = "UPDATE ranking set rank = ? where rank = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(2, Integer.toString(rankInt));
				pstmt.setString(1, Integer.toString(++rankInt));
				pstmt.executeUpdate(); //실행시키는 거
			}

//			rank = Integer.toString(Integer.parseInt(rank)+1);
		} catch(SQLException ex) {
			System.out.println("Insert SQLException:" + ex);
		} catch(Exception ex) {
			System.out.println("Insert Exception:" + ex);
		}
	}
}
