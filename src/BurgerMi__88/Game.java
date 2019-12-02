package BurgerMi__88;

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
	private Image ImageRules = new ImageIcon("src/images/GameRules.png").getImage();
	private ImageIcon ImageNext = new ImageIcon("src/images/�����ʹ�ư.png");
	private Image ImageBackground;

	// ���
	public Image ImageTray = new ImageIcon("src/images/���.png").getImage();
	public Image ImageTray2 = new ImageIcon("src/images/���2.png").getImage();
	public Image ImageTray3 = new ImageIcon("src/images/���3.png").getImage();
	public Image[] TrayImage = { ImageTray2, ImageTray3, ImageTray };
	public Image TrayBasicImage = TrayImage[2];

	public Image ImageThrowBurger = new ImageIcon("src/images/ThrowBurger.png").getImage();
	public Image EndGame = new ImageIcon("src/images/���ȭ��.png").getImage();

	public Burger burger;
	public Order order;
	public Score score;// = new Score();
	public Timer timer;// = new Timer();
	public Throw th;
//	public MyLabel bar = new MyLabel(100); 

	public boolean gameStart = false; // ���� ����
	private boolean bool = false; // �������� �ȳ�������
	public boolean throwburger = false;
	public boolean End = false;
	public static boolean replay = false;
	
	private JButton NextBtn = new JButton(ImageNext);
	public JLabel grade;

	// �������� ���� �̹���, ��ǥ
	private Image ingredients;
	int Threadx, Thready;
	

	public void Game() {
		System.out.println(End);
		setLayout(null);
		ImageBackground = ImageRules;

//		if(replay) {
//			score = new Score();
//			timer = new Timer();
//		}
		
		// ���ӹ�� Ȯ�ι�ư
		NextBtn.setBounds(10, 350, 340, 120);
		NextBtn.setBorderPainted(false);
		NextBtn.setContentAreaFilled(false);
		NextBtn.setFocusPainted(false);
		NextBtn.addMouseListener(new MouseListener());
		NextBtn.setVisible(true);
		this.add(NextBtn);

		this.setFocusable(true);


		order = new Order();
		order.start();
		
		System.out.println("");

		this.addKeyListener(new KeyListener());

		// ��
//		bar.setBackground(Color.ORANGE);
//		bar.setOpaque(true);
//		bar.setLocation(20,  50);
//		bar.setSize(300, 20); 
//		add(bar);
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
			
			score = new Score();
			timer = new Timer();
			
			grade = new JLabel(score.score + "��");
			grade.setFont(new Font("������������� ExtraBold", Font.ITALIC, 50)); // ��Ʈ ����
			grade.setSize(500, 500); // ũŰ ����
			grade.setLocation(1160, -150); // ��ġ ����
			
			score = new Score();
			timer = new Timer();
			
			add(grade);
			add(timer.time);
			
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

		if (gameStart) {
			// �ֹ����� ���� �׸���
			for (int i = 0; i < order.orderBurger.size(); i++) {
				OrderImage = (Image) ((List<Object>) order.orderBurger.get(i)).get(1);
				OrderX = (int) ((List<Object>) order.orderBurger.get(i)).get(2);
				OrderY = (int) ((List<Object>) order.orderBurger.get(i)).get(3);
				g.drawImage(OrderImage, OrderX, OrderY, this);
			}
			g.drawImage(order.guestArray[order.guest], 553, order.y, this); // 136
			// ���
			int y = 450;
			if (TrayBasicImage == ImageTray3) {
				y = 400;
			}
			g.drawImage(TrayBasicImage, 400, y, this);
		}


		// ������
		if (throwburger) {
			g.drawImage(ImageThrowBurger, 500, 290, this);
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

		if (End) {
			g.drawImage(EndGame, 0, 0, this);
		}
		
	}
}
