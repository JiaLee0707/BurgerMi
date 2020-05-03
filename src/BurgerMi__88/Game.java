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
	private ImageIcon ImageNext = new ImageIcon("src/images/오른쪽버튼.png");
	private Image ImageBackground;

	// 쟁반
	public Image ImageTray = new ImageIcon("src/images/쟁반.png").getImage();
	public Image ImageTray2 = new ImageIcon("src/images/쟁반2.png").getImage();
	public Image ImageTray3 = new ImageIcon("src/images/쟁반3.png").getImage();
	public Image[] TrayImage = { ImageTray2, ImageTray3, ImageTray };
	public Image TrayBasicImage = TrayImage[2];

	public Image ImageThrowBurger = new ImageIcon("src/images/ThrowBurger.png").getImage();
	public Image EndGame = new ImageIcon("src/images/결과화면.png").getImage();

	public Burger burger;
	public Order order;
	public Score score;// = new Score();
	public Timer timer;// = new Timer();
	public Throw th;
//	public MyLabel bar = new MyLabel(100); 

	public boolean gameStart = false; // 게임 시작
	private boolean bool = false; // 내려오냐 안내려오냐
	public boolean throwburger = false;
	public boolean End = false;
	public static boolean replay = false;

	private JButton NextBtn = new JButton(ImageNext);
	public JLabel grade;

	// 내려오는 버거 이미지, 좌표
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

		// 게임방범 확인버튼
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

		// 바
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

	// 확인버튼 마우스리스너
	class MouseListener extends MouseAdapter {

		// 기본버튼
		@Override
		public void mouseExited(MouseEvent e) {
			JButton button = (JButton) e.getSource();
		}

		// 클릭버튼
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton button = (JButton) e.getSource();

			Music Button = new Music("buttonPressedMusic.mp3", false);
			Button.start();

			ImageBackground = ImageGame;
			gameStart = true;

			score = new Score();
			timer = new Timer();

			grade = new JLabel(score.score + "점");
			grade.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.ITALIC, 50)); // 폰트 설정
			grade.setSize(500, 500); // 크키 설정
			grade.setLocation(1160, -150); // 위치 설정

			score = new Score();
			timer = new Timer();

			add(grade);
			add(timer.time);

			button.setVisible(false);
			getParent().repaint();
		}

		// 버튼 위에 올리면
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

		// 배경화면 그리기
		g.drawImage(ImageBackground, 0, 0, this);

		// 주문 받은 햄버거 재료(이미지, x좌표, y좌표)
		Image OrderImage;
		int OrderX;
		int OrderY;

		// 내려온(만든) 버거재료(이미지, x좌표, y좌표)
		Image MakeImage;
		int MakeX;
		int MakeY;

		if (gameStart) {
			// 주문받은 버거 그리기
			for (int i = 0; i < order.orderBurger.size(); i++) {
				OrderImage = (Image) ((List<Object>) order.orderBurger.get(i)).get(1);
				OrderX = (int) ((List<Object>) order.orderBurger.get(i)).get(2);
				OrderY = (int) ((List<Object>) order.orderBurger.get(i)).get(3);
				g.drawImage(OrderImage, OrderX, OrderY, this);
			}
			g.drawImage(order.guestArray[order.guest], 553, order.y, this); // 136
			// 쟁반
			int y = 450;
			if (TrayBasicImage == ImageTray3) {
				y = 400;
			}
			g.drawImage(TrayBasicImage, 400, y, this);
		}

		// 던지기
		if (throwburger) {
			g.drawImage(ImageThrowBurger, 500, 290, this);
		}

		// 내려온 재료
//		System.out.println(BurgerArray.size());
		for (int i = 0; i < order.MakeBurger.size(); i++) {
//			System.out.println("draw Order");
			MakeImage = (Image) ((List<Object>) order.MakeBurger.get(i)).get(1);
			MakeX = (Integer) ((List<Object>) order.MakeBurger.get(i)).get(2);
			MakeY = (Integer) ((List<Object>) order.MakeBurger.get(i)).get(3);
			g.drawImage(MakeImage, MakeX, MakeY, this);
		}

		// 내려오는 재료
		if (this.bool) {
			g.drawImage(ingredients, Threadx, Thready, this);
		}

		if (End) {
			g.drawImage(EndGame, 0, 0, this);
		}

	}
}