package BurgerMi_ITShow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class DB {

	String name;
	Connection conn = null;
	PreparedStatement pstmt = null;

	DB() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/burgermi?serverTimezone=Asia/Seoul&useSSL=false", "root", "mirim2");
			System.out.println("DB 연결 완료");
		} catch (SQLException ex) {
			System.out.println("SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
	}

	public LinkedList RandomOrder(int i, String who) {
		LinkedList<Object[]> menu = new LinkedList<Object[]>();
		try {
			// 메뉴 전체 랜덤
			String sql = null;
			if(who.equals("All")) {	// 메뉴 전체
				sql = "SELECT * FROM menu ORDER BY RAND() LIMIT ?";
			} else if(who.equals("badCustomer")) {	// 진상 메뉴
				sql = "SELECT * FROM menu WHERE sort LIKE '%진상%' ORDER BY RAND() LIMIT ?";				
			} else {	// 일반 메뉴
				sql = "SELECT * FROM menu WHERE sort NOT LIKE '%진상%' ORDER BY RAND() LIMIT ?";								
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, i);
			ResultSet srs = pstmt.executeQuery();
			
			while (srs.next()) {
				String[] menu2 = new String[4];
				menu2[0] = srs.getString("name");
				menu2[1] = srs.getString("ingredients");
				menu2[2] = srs.getString("price");
				menu2[3] = srs.getString("sort");
				System.out.print(srs.getString("name") + " ");
				System.out.print(srs.getString("ingredients") + " ");
				System.out.print(srs.getString("price") + " ");
				System.out.print(srs.getString("sort") + " ");
				System.out.println();
				menu.add(menu2);
			}
		}  catch (SQLException ex) {
			System.out.println("RandomOrder SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("RandomOrder Exception:" + ex);
		}
		return menu;
	}
	////////////////////////////
	public LinkedList SideRandomOrder(int i, String kind, String who) {
		LinkedList<Object[]> menu = new LinkedList<Object[]>();
		try {
			String sql = null;
			// 음료, 사이드 메뉴 랜덤
			if(who.equals("badCustomer")) {
				sql = "SELECT menu.name, menu.ingredients, menu.price, menu.sort, recipes.kind FROM "
							+ "menu, recipes WHERE menu.name=recipes.name AND recipes.kind=? AND sort LIKE '%진상%' "
							+ "ORDER BY RAND() LIMIT ?";
			} else {
				sql = "SELECT menu.name, menu.ingredients, menu.price, menu.sort, recipes.kind FROM "
						+ "menu, recipes WHERE menu.name=recipes.name AND recipes.kind=? AND sort NOT LIKE '%진상%' "
						+ "ORDER BY RAND() LIMIT ?";				
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			pstmt.setInt(2, i);
			
			ResultSet srs = pstmt.executeQuery();
			
			while (srs.next()) {
				String[] menu2 = new String[5];
				menu2[0] = srs.getString("name");
				menu2[1] = srs.getString("ingredients");
				menu2[2] = srs.getString("price");
				menu2[3] = srs.getString("sort");
				menu2[4] = srs.getString("kind");
				System.out.print(srs.getString("name") + " ");
				System.out.print(srs.getString("ingredients") + " ");
				System.out.print(srs.getString("price") + " ");
				System.out.print(srs.getString("sort") + " ");
				System.out.print(srs.getString("kind") + " ");
				System.out.println();
				menu.add(menu2);
			}
		}  catch (SQLException ex) {
			System.out.println("RandomOrder SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("RandomOrder Exception:" + ex);
		}
		return menu;
	}
	
	public LinkedList<String> recipes(String burger) {
		LinkedList<String> recipes = new LinkedList<String>();
		String[] ingredients = null;
		try {
			String sql = "SELECT * FROM recipes WHERE name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, burger);
			ResultSet srs = pstmt.executeQuery();
			
			if(srs.next()) {
//				String s = srs.getString("ingredients");
//				ingredients = s.split(";");
				recipes.add(srs.getString("ingredients"));
				recipes.add(srs.getString("kind"));
				
				
//				for(int i=0; i<ingredients.length; i++) {
//					System.out.print(ingredients[i] + " ");
//				}
//				System.out.println();
			}
		}  catch (SQLException ex) {
			System.out.println("RandomOrder SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("RandomOrder Exception:" + ex);
		}
		return recipes;
	}
	
	public LinkedList Select() {
//		Ranking ranking = new Ranking();
		LinkedList<String[]> rankList = new LinkedList<String[]>();
		try {
			String sql = "SELECT * FROM ranking ORDER BY rank ASC";
			pstmt = conn.prepareStatement(sql);
			ResultSet srs = pstmt.executeQuery();
			while (srs.next()) {
				String[] rank = new String[3];
				rank[0] = srs.getString("name");
				rank[1] = srs.getString("score");
				rank[2] = srs.getString("rank");
				System.out.print(srs.getString("no") + " ");
				System.out.print(srs.getString("rank") + " ");
				System.out.print(srs.getString("name") + " ");
				System.out.print(srs.getString("score") + " ");
				System.out.println();
				rankList.add(rank);
			}
		} catch (SQLException ex) {
			System.out.println("Select SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Select Exception:" + ex);
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle) {
				}
		}
//		ranking.Ranking(rankList);
		return rankList;
	}

	public void Insert(int s) {
		int num = 0;
		String rank = null;
		String score = Integer.toString(s);
		boolean update = false;

		name = JOptionPane.showInputDialog("이름을 입력하세요.\n(취소를 누르면 순위에 오르지 못합니다.)");

		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet srs = stmt.executeQuery("SELECT * FROM ranking");
			srs.last(); // 커서의 위치를 제일 뒤로 이동
			num = srs.getRow(); // 현재 커서의 Row Index 값을 저장
			String no = Integer.toString(num + 1);
			System.out.println(no);

			String sql = "SELECT * FROM ranking ORDER BY score DESC";
			pstmt = conn.prepareStatement(sql);
			srs = pstmt.executeQuery();

			if (Integer.parseInt(no) <= 1) {
				rank = "1";
			} else {
				while (srs.next()) {
					int dbScore = Integer.parseInt((srs.getString("score")));
					if (s > dbScore) {
						if (srs.getString("rank").equals("1")) {
							System.out.println("rank 1");
							rank = "1";
							if(s == dbScore) break;
						} else {
							rank = Integer.toString(Integer.parseInt(srs.getString("rank")));
						}
						update = true;
						Update(rank);
						break;
					} else if (s == dbScore) {
						rank = Integer.toString(Integer.parseInt(srs.getString("rank")));
						update = true;
						break;
					}
					else{
						rank = Integer.toString(Integer.parseInt(srs.getString("rank")) + 1);						
						update = false;
					}
				}
				if(!update) Update(rank);
			}

			sql = "insert into ranking (no, score, name, rank) values (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, score);
			pstmt.setString(3, name);
			pstmt.setString(4, rank);
			System.out.println("insert!!");

			pstmt.executeUpdate();


			Main.burgermi.game.end = true;
//			Select();

		} catch (SQLException ex) {
			System.out.println("Insert SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Insert Exception:" + ex);
		}
	}

	public void Update(String rank) {
		int num, num2=0;
		try {
			System.out.println("update");
			String sql = "SELECT * FROM ranking WHERE rank>=? ORDER BY score ASC";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rank);
			ResultSet srs = pstmt.executeQuery();
			srs.first();
			int rankInt = Integer.parseInt(srs.getString("rank"));
			
			//Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			sql = "SELECT DISTINCT rank FROM ranking WHERE rank>=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rank);
			ResultSet rankSrs = pstmt.executeQuery();
			rankSrs.last(); // 커서의 위치를 제일 뒤로 이동
			num = rankSrs.getRow(); // 현재 커서의 Row Index 값을 저장
			System.out.println("num : " + num);
			rankInt++;
			
			
//			int rankInt = Integer.parseInt(rank);
			do {
				if(num2==num) break;
				else num2++;
				System.out.println("while");
				sql = "UPDATE ranking set rank = ? where rank = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, Integer.toString(rankInt));
				pstmt.setString(2, Integer.toString(--rankInt));
				pstmt.executeUpdate(); // 실행시키는 거
			} while (srs.next());

//			rank = Integer.toString(Integer.parseInt(rank)+1);
		} catch (SQLException ex) {
			System.out.println("Update SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Update Exception:" + ex);
		}
	}
}
