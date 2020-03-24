package BurgerMi_12_12;

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
	
	// ����ȭ��
	private Image ImageGame = new ImageIcon("src/images/GameBackground.png").getImage();
	private Image ImageRules = new ImageIcon("src/images/GameRules.png").getImage();
	public Image EndGame = new ImageIcon("src/images/���ȭ��.png").getImage();
	private Image ImageBackground;
	
	// ���ӽ��� ��ư
	MouseListener mouse = new MouseListener();
	private JButton StartBtn = new JButton(mouse.StartBasicImage);
	
	JLabel[] BurgerJLabel = new JLabel[5];
		
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
		
		score = new Score(order);
		keyListener = new KeyListener(score);
		
		// �մ� Label
		JLabel guestJLabel = new JLabel(order.guestArray[order.guest.who]);	
//		JLabel[] BurgerJLabel = new JLabel[5];
		guest.Guest(guestJLabel);
		this.add(guestJLabel);
		
		// �ֹ� ���� Label
		for(int i=0; i<5; i++) {
			BurgerJLabel[i] = new JLabel(order.orderBurgerImageArray[order.orderBurgerArray[i]]);
			order.Order(BurgerJLabel[i], i);
//			this.setComponentZOrder(BurgerJLabel[i], i);	// JLabel�� �յ� ��ġ�� ������ �� ����
		}
		for(int i=4; i>-1; i--) {
			this.add(BurgerJLabel[i]);
		}
		getParent().repaint();

//		this.setFocusable(true);
		this.requestFocus(); // ����Ʈ�ҿ� ��Ŀ�� ����
		this.addKeyListener(keyListener);
	}
	
	// ȭ�� �׸���
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		
		// ���ȭ��
		g.drawImage(ImageBackground, 0, 0, this);
	}
}