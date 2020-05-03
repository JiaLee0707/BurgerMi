package BurgerMi_11_11;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JPanel {

	public Order order = new Order();
	private Order.Guest guest = order.new Guest();
	private Score score;
	public KeyListener keyListener;

	// 게임화면
	private Image ImageGame = new ImageIcon("src/images/GameBackground.png").getImage();
	private Image ImageRules = new ImageIcon("src/images/GameRules.png").getImage();
	public Image EndGame = new ImageIcon("src/images/결과화면.png").getImage();
	private Image ImageBackground;

	// 게임시작 버튼
	MouseListener mouse = new MouseListener();
	private JButton StartBtn = new JButton(mouse.StartBasicImage);

	public void Game() {
		setLayout(null);
		ImageBackground = ImageRules;
		System.out.println(ImageBackground);

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
		ImageBackground = ImageGame;
		Main.burgermi.background.introMusic.close();
		Music gameMusic = new Music("요리.mp3", true);
		gameMusic.start();

		// 버튼 안보이게
		StartBtn.setVisible(false);

		score = new Score(order);
		keyListener = new KeyListener(score);

		// 손님 Label
		JLabel guestJLabel = new JLabel(order.guestArray[order.guest.who]);
//		JLabel[] BurgerJLabel = new JLabel[5];
		guest.Guest(guestJLabel);
		this.add(guestJLabel);

		// 주문 버거 Label
		for (int i = 4; i > -1; i--) {
			JLabel BurgerJLabel = new JLabel(order.orderBurgerImageArray[order.orderBurgerArray[i]]);
			order.Order(BurgerJLabel, i);
			this.add(BurgerJLabel);
		}
		getParent().repaint();

//		this.setFocusable(true);
		this.requestFocus(); // 컨텐트팬에 포커스 설정
		this.addKeyListener(keyListener);
	}

	// 화면 그리기
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// 배경화면
		g.drawImage(ImageBackground, 0, 0, this);
	}
}