package BurgerMi__1010;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.StringCharacterIterator;
import java.util.Scanner;

public class Ranking {
	Scanner sc=new Scanner(System.in);

	Connection conn=null;
	PreparedStatement pstmt = null;
	
	public Ranking() {
		Insert insert = new Insert();
		Update update = new Update();
	}
	
	// insert (내부class)
	class Insert {
		Insert() {
			System.out.print("name를 입력하시오. >>");
			String name = sc.next();
			try {
				Class.forName("org.gjt.mm.mysql.Driver").newInstance();
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/burgermi", "root", "mirim2");
				System.out.println("DB 연결 완료");
				String sql = "insert into student (ranking, name, score) values(?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, dept);
				pstmt.setString(3, id);
				
				pstmt.executeUpdate();
				
				sql = "select * from student";
				pstmt = conn.prepareStatement(sql);
				ResultSet srs = pstmt.executeQuery();
				while(srs.next()) {
					System.out.print(srs.getString("name")+" ");
					System.out.print(srs.getString("dept")+" ");
					System.out.print(srs.getString("id")+" ");
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
	
	// Update && Select (내부class)
	class Update {
		Update() {
			try {
				Class.forName("org.gjt.mm.mysql.Driver").newInstance();
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/buregrmi", "root", "mirim2");
				System.out.println("DB 연결 완료");
				String sql = "select * from ranking order by score desc;";
				pstmt = conn.prepareStatement(sql);
				ResultSet srs = pstmt.executeQuery();
				int count = 0;
				while(srs.next()) {
					System.out.print(srs.getString("name")+" ");
					System.out.print(srs.getString("dept")+" ");
					System.out.print(srs.getString("id")+" ");
					System.out.println();
					
					String sql2 = "update ranking set ranking = ? where name = ?";
					pstmt.setString(1, Integer.toString(count));
					pstmt.setString(2, srs.getString("name"));
					pstmt.executeUpdate(); //실행시키는 거
					
					count++;
					if(count <= 5) {
						// 화면 출력
					}
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
	
}
