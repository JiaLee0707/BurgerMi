package BurgerMi_11_11;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JPanel {
	
	private Order order = new Order();
	
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
		
		// 손님 Label
		JLabel guestJLabel = new JLabel(order.guestArray[order.guest.who]);	
		this.add(guestJLabel);	
		order.Order(guestJLabel);
		
		
	
	}
	
	// 화면 그리기
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		
		// 배경화면
		g.drawImage(ImageBackground, 0, 0, this);
//		g.drawImage(order.guestArray[order.guest.guest], 553, order.guest.y, this);
	}
}
