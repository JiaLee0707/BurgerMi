package BurgerMi__1010;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.StringCharacterIterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ranking {
	Scanner sc = new Scanner(System.in);

	Connection conn = null;
	PreparedStatement pstmt = null;

	public Select select = new Select();
	public Insert insert = new Insert();
	public Update update = new Update();

	Ranking() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/burgermi", "root", "mirim2");
			System.out.println("DB 연결 완료");
		} catch (SQLException ex) {
			System.out.println("SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
//		} finally {
//			if(conn != null)
//				try {
//					conn.close();
//				}catch(SQLException sqle) {}
//			if(pstmt != null) 
//				try {
//					pstmt.close();
//				}catch(SQLException sqle) {}
//		}
	}

	// 출력 (내부 class)
	class Select {
		public void Select() {
			try {
//				Class.forName("org.gjt.mm.mysql.Driver").newInstance();
//				conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/buregrmi", "root", "mirim2");
//				System.out.println("DB 연결 완료");

				String sql = "select * from ranking order by score desc;";
				pstmt = conn.prepareStatement(sql);
				ResultSet srs = pstmt.executeQuery();
				int count = 0;
				while (srs.next()) {
					if (count < 5) {
						// 화면 출력
					}

					count++;
				}
			} catch (SQLException ex) {
				System.out.println("SQLException:" + ex);
			} catch (Exception ex) {
				System.out.println("Exception:" + ex);
			}
		}
	}

	// 추가 (내부class)
	class Insert {
		public void Insert(int score) {
			String name = JOptionPane.showInputDialog("이름을 입력하세요");

			try {
//				Class.forName("org.gjt.mm.mysql.Driver").newInstance();
//				conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/burgermi", "root", "mirim2");
//				System.out.println("DB 연결 완료");

				String sql = "insert into ranking (name, score) values (?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, Integer.toString(score));

				pstmt.executeUpdate();

				sql = "select * from ranking";
				pstmt = conn.prepareStatement(sql);
				ResultSet srs = pstmt.executeQuery();
				while (srs.next()) {
					System.out.print(srs.getString("rank") + " ");
					System.out.print(srs.getString("name") + " ");
					System.out.print(srs.getString("score") + " ");
					System.out.println();
				}
			} catch (SQLException ex) {
				System.out.println("SQLException:" + ex);
			} catch (Exception ex) {
				System.out.println("Exception:" + ex);
			}
		}
	}

	// 업데이트 (내부class)
	class Update {
		public void Update() {
			try {
//				Class.forName("org.gjt.mm.mysql.Driver").newInstance();
//				conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/buregrmi", "root", "mirim2");
//				System.out.println("DB 연결 완료");

//				update ranking set ranking = ? where name = (select name from ranking order by score desc)

				String sql = "select * from ranking order by score desc";
				pstmt = conn.prepareStatement(sql);
				ResultSet srs = pstmt.executeQuery();
				int count = 0;
				while (srs.next()) {
					count++;

//					String sql2 = "update ranking set rank = ? where name = (select name from (select * from ranking) as r order by score desc)";
					pstmt = conn.prepareStatement(sql);
//					ResultSet srs2 = pstmt.executeQuery();

//					sql = "update ranking set ranking = ? where name = ?";
					sql = "update ranking set ranking = ? where name = (select name from ranking order by score desc)";
					pstmt.setString(1, Integer.toString(count));
//					pstmt.setString(2, srs.getString("name"));
					pstmt.executeUpdate(); // 실행시키는 거

					if (count <= 5) {
						// 화면 출력
						System.out.print(srs.getString("rank") + " ");
						System.out.print(srs.getString("name") + " ");
						System.out.print(srs.getString("score") + " ");
						System.out.println();
					}
				}
			} catch (SQLException ex) {
				System.out.println("SQLException:" + ex);
			} catch (Exception ex) {
				System.out.println("Exception:" + ex);
			}
		}
	}

}