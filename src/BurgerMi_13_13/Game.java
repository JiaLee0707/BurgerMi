package BurgerMi_13_13;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Game extends JPanel {

	public Order order = new Order();
	private Order.Guest guest = order.new Guest();
//	private Score score;
	public KeyListener keyListener;

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

		guest.Guest();
//		order.orderBurger.clear();
		order.burgerIngredient.clear();
		for (int i = 0; i < order.orderBurgerArray.length-1; i++) {
			System.out.println("Asdf");
			order.Order(i);
		}

		getParent().repaint();
		System.out.println("+++" + ((List<Object>) order.orderBurger.get(1)));
	}

	// ȭ�� �׸���
	@SuppressWarnings("unchecked")
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// ���ȭ��
		g.drawImage(ImageBackground, 0, 0, this);

		// �մ� �׸���
		g.drawImage(order.thisGuest, 553, guest.y, this);

		Image burgerIngredient = null;
		int x = 0;
		int y = 0;

		// �ֹ����� ����
//		for (int i = 0; i < order.orderBurger.size(); i++) {
//			burgerIngredient = (Image) ((List<Object>) order.orderBurger.get(i));
//			x = (int) ((List<Object>) order.orderBurger.get(i)).get(1);
//			y = (int) ((List<Object>) order.orderBurger.get(i)).get(2);
//			g.drawImage(burgerIngredient, x, y, this);
//		}
	}

}