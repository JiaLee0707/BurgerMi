package BurgerMi_11_11;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JPanel {
	
	private Order order = new Order();
	
	// ����ȭ��
	private Image ImageGame = new ImageIcon("src/images/GameBackground.png").getImage();
	private Image ImageRules = new ImageIcon("src/images/GameRules.png").getImage();
	public Image EndGame = new ImageIcon("src/images/���ȭ��.png").getImage();
	private Image ImageBackground;
	
	// ���ӽ��� ��ư
	MouseListener mouse = new MouseListener();
	private JButton StartBtn = new JButton(mouse.StartBasicImage);
		
	public void Game() {
		setLayout(null);
		ImageBackground = ImageRules;
		System.out.println(ImageBackground);
		
		// ���۹�ư
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
		Music gameMusic = new Music("�丮.mp3", true);
		gameMusic.start();
		
		// ��ư �Ⱥ��̰�
		StartBtn.setVisible(false);
		
		// �մ� Label
		JLabel guestJLabel = new JLabel(order.guestArray[order.guest.who]);	
		this.add(guestJLabel);	
		order.Order(guestJLabel);
		
		
	
	}
	
	// ȭ�� �׸���
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		
		// ���ȭ��
		g.drawImage(ImageBackground, 0, 0, this);
//		g.drawImage(order.guestArray[order.guest.guest], 553, order.guest.y, this);
	}
}
