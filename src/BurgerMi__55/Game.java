package BurgerMi__55;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JPanel {
	private Image ImageGame = new ImageIcon("src/images/GameBackground.png").getImage();
	private Image ImageRules = new ImageIcon("src/images/GameRules.jpg").getImage();
	private ImageIcon ImageNext = new ImageIcon("src/images/�����ʹ�ư.png");
	private Image ImageBackground = ImageRules;

	public Burger burger;
	public Order order;
	public Score score = new Score();

	private boolean gameStart = false; // ���� ����
	private boolean bool = false; // �������� �ȳ�������

	private JButton NextBtn = new JButton(ImageNext);
	public JLabel grade = new JLabel(score.score + "��");
	// �������� ���� �̹���, ��ǥ
	private Image ingredients;
	int Threadx, Thready;

	public Game() {
		setLayout(null);

		// ���ӹ�� Ȯ�ι�ư
		NextBtn.setBounds(10, 350, 340, 120);
		NextBtn.setBorderPainted(false);
		NextBtn.setContentAreaFilled(false);
		NextBtn.setFocusPainted(false);
		NextBtn.addMouseListener(new MouseListener());
		NextBtn.setVisible(true);
		this.add(NextBtn);

		this.setFocusable(true);

		grade.setFont(new Font("������������� ExtraBold", Font.ITALIC, 50)); // ��Ʈ ����
		grade.setSize(500, 500); // ũŰ ����
		grade.setLocation(1150, -200); // ��ġ ����


		order = new Order();
		System.out.println("");

		this.addKeyListener(new KeyListener());
	}

	public void Thread(Image image, int x, int y, boolean bool) {
		this.ingredients = image;
		Threadx = x;
		Thready = y;
		this.bool = bool;
	}

	// Ȯ�ι�ư ���콺������
	class MouseListener extends MouseAdapter {

		// �⺻��ư
		@Override
		public void mouseExited(MouseEvent e) {
			JButton button = (JButton) e.getSource();
		}

		// Ŭ����ư
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton button = (JButton) e.getSource();

			Music Button = new Music("buttonPressedMusic.mp3", false);
			Button.start();

			ImageBackground = ImageGame;
			gameStart = true;
			add(grade);
			button.setVisible(false);
			getParent().repaint();
		}

		// ��ư ���� �ø���
		@Override
		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setCursor(new Cursor(Cursor.HAND_CURSOR));

			Music Button = new Music("buttonEnteredMusic.mp3", false);
			Button.start();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// ���ȭ�� �׸���
		g.drawImage(ImageBackground, 0, 0, this);

		// �ֹ� ���� �ܹ��� ���(�̹���, x��ǥ, y��ǥ)
		Image OrderImage;
		int OrderX;
		int OrderY;

		// ������(����) �������(�̹���, x��ǥ, y��ǥ)
		Image MakeImage;
		int MakeX;
		int MakeY;

//		g.drawImage(order.ordertomatoImage, 0,0,this);

		if (gameStart) {
			// �ֹ����� ���� �׸���
			for (int i = 0; i < order.orderBurger.size(); i++) {
				OrderImage = (Image) ((List<Object>) order.orderBurger.get(i)).get(1);
				OrderX = (int) ((List<Object>) order.orderBurger.get(i)).get(2);
				OrderY = (int) ((List<Object>) order.orderBurger.get(i)).get(3);
				g.drawImage(OrderImage, OrderX, OrderY, this);
			}
		}

		// ������ ���
//		System.out.println(BurgerArray.size());
		for (int i = 0; i < order.MakeBurger.size(); i++) {
//			System.out.println("draw Order");
			MakeImage = (Image) ((List<Object>) order.MakeBurger.get(i)).get(1);
			MakeX = (Integer) ((List<Object>) order.MakeBurger.get(i)).get(2);
			MakeY = (Integer) ((List<Object>) order.MakeBurger.get(i)).get(3);
			g.drawImage(MakeImage, MakeX, MakeY, this);
		}

		// �������� ���
		if (this.bool) {
			g.drawImage(ingredients, Threadx, Thready, this);
		}
	}
}
