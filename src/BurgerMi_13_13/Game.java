package BurgerMi_13_13;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Game extends JPanel {

	public Order order = new Order();
//	private Order.Guest guest = order.new Guest();
	public Score score;
	public KeyListener keyListener = new KeyListener();

	// 게임화면
	private Image ImageGame = new ImageIcon("src/images/GameBackground.png").getImage();
	private Image ImageRules = new ImageIcon("src/images/GameRules.png").getImage();
	public Image EndGame = new ImageIcon("src/images/결과화면.png").getImage();
	private Image ImageBackground;

	// 게임시작 버튼
	MouseListener mouse = new MouseListener();
	private JButton StartBtn = new JButton(mouse.StartBasicImage);

	boolean start = false;

	public void Game() {
		setLayout(null);
		ImageBackground = ImageRules;

		// 시작버튼
		StartBtn.setBounds(915, 560, 340, 120);
		StartBtn.setBorderPainted(false);
		StartBtn.setContentAreaFilled(false);
		StartBtn.setFocusPainted(false);
		StartBtn.addMouseListener(mouse.new Listener("Game", mouse.StartBasicImage, mouse.StartEnteredImage));
		StartBtn.setVisible(true);
		this.add(StartBtn);
	}

	public void GameStart() {
		start = true;
		ImageBackground = ImageGame;
		Main.burgermi.background.introMusic.close();
		Music gameMusic = new Music("요리.mp3", true);
		gameMusic.start();

		// 버튼 안보이게
		StartBtn.setVisible(false);

		score = new Score();
		keyListener.KeyListener();
		;

		ReGame();

		this.requestFocus(); // 컨텐트팬에 포커스 설정
		this.addKeyListener(keyListener);
	}

	public void ReGame() {
		Order.Guest guest = order.new Guest();
		order.Order();
		for (int i = 0; i < order.orderBurgerArray.length; i++) {
			order.Burger(i);
		}
		guest.Guest();

		getParent().repaint();
	}

	// 화면 그리기
	@SuppressWarnings("unchecked")
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// 배경화면
		g.drawImage(ImageBackground, 0, 0, this);

		Image burgerIngredient = null;
		int x = 0;
		int y = 0;

		Image MakeburgerIngredient = null;
		int Makex = 0;
		int Makey = 0;

		if (start) {
			// 손님 그리기
			g.drawImage(order.thisGuest, 553, order.y, this);

			// 주문받은 버거
			for (int i = 0; i < order.orderBurger.size(); i++) {
				burgerIngredient = (Image) ((List<Object>) order.orderBurger.get(i)).get(0);
				x = (int) ((List<Object>) order.orderBurger.get(i)).get(1);
				y = (int) ((List<Object>) order.orderBurger.get(i)).get(2);
				g.drawImage(burgerIngredient, x, y, this);
			}
		}

		// 만든 버거
		for (int i = 0; i < keyListener.burger.MakeBurgerObjectArray.size(); i++) {
			MakeburgerIngredient = (Image) ((List<Object>) keyListener.burger.MakeBurgerObjectArray.get(i)).get(0);
			Makex = (int) ((List<Object>) keyListener.burger.MakeBurgerObjectArray.get(i)).get(1);
			Makey = (int) ((List<Object>) keyListener.burger.MakeBurgerObjectArray.get(i)).get(2);
			g.drawImage(MakeburgerIngredient, Makex, Makey, this);
		}

		// 만드는 버거
		if (keyListener.burger.key) {
			for (int i = 0; i < keyListener.burger.burgerIngredient.size(); i++) {
				Image MakeImage = (Image) (((List<Object>) keyListener.burger.burgerIngredient.get(i)).get(0));
				int MakeX = (int) (((List<Object>) keyListener.burger.burgerIngredient.get(i)).get(1));
				int MakeY = (int) keyListener.burger.i;
				g.drawImage(MakeImage, MakeX, MakeY, this);
			}
		}

	}

}
