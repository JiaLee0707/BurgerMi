package BurgerMi_ITShow;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import BurgerMi_ITShow.MouseListener.Listener;

public class Game extends JPanel {

	public DB db = new DB();
	public Order order = new Order(db);
	public Sales sales;
	public KeyListener keyListener = new KeyListener();
	public Timer timer;

	Toolkit toolkit = Main.burgermi.getToolkit();
	private Image ImageGame = toolkit.createImage("src/images/BurgerMi_3.gif");
	private Image ImageIntro = toolkit.createImage("src/images/intro.gif");
	public Image ImageRules = toolkit.createImage("src/images/GameRules.png");
	public Image ImageResult = toolkit.createImage("src/images/GameResult.png");

	public Image ImageBackground;

	// 쟁반
	public Image ImageTray = new ImageIcon("src/images/쟁반.png").getImage();
	public Image ImageTray2 = new ImageIcon("src/images/쟁반2.png").getImage();
	public Image ImageTray3 = new ImageIcon("src/images/쟁반3.png").getImage();
	public Image[] ImageTrayArray = { ImageTray2, ImageTray3, ImageTray };
	public Image TrayBasicImage = ImageTrayArray[2];

	// 던지는 햄버거
	public Image ImageThrowingBurger = new ImageIcon("src/images/ThrowBurger.png").getImage();
	public Image ImageBrokenBurger = new ImageIcon("src/images/BrokenBurger.png").getImage();
	public Image[] ImageThrow = { ImageThrowingBurger, ImageBrokenBurger };
	public Image ThrowImage;

	// 버튼
	MouseListener mouse = new MouseListener();
	Listener listener;
	private JButton StartBtn = new JButton(mouse.StartBasicImage);
	private JButton replayBtn = new JButton(mouse.ReplayBasicImage);

	Music gameMusic;

	int TrayY = 420;
	public boolean start = false;
	public boolean ThrowBurger = false;
	public boolean end = false;
	
	public void Game() {
		setLayout(null);
		ImageBackground = ImageIntro;
		Main.burgermi.background.introMusic.close();

		// 시작버튼
		StartBtn.setBounds(915, 565, 340, 120);
		StartBtn.setBorderPainted(false);
		StartBtn.setContentAreaFilled(false);
		StartBtn.setFocusPainted(false);
		listener = mouse.new Listener("GameIntro", mouse.StartBasicImage, mouse.StartEnteredImage);
		StartBtn.addMouseListener(listener);
		StartBtn.setVisible(true);
		this.add(StartBtn);

		gameMusic = new Music("in.mp3", false);
		gameMusic.start();
	}
	
	public void GameRules() {
		setLayout(null);
		ImageBackground = ImageRules;
		gameMusic.close();

		// 시작버튼
		StartBtn.removeMouseListener(listener);
		StartBtn.setBounds(915, 565, 340, 120);
		StartBtn.setBorderPainted(false);
		StartBtn.setContentAreaFilled(false);
		StartBtn.setFocusPainted(false);
		listener = mouse.new Listener("Game", mouse.StartBasicImage, mouse.StartEnteredImage);
		StartBtn.addMouseListener(listener);
		StartBtn.setVisible(true);
		this.add(StartBtn);
		

		Main.burgermi.game.getParent().repaint();
	}

	public void GameStart() {
		start = true;
		
		ImageBackground = ImageGame;
		gameMusic = new Music("요리.mp3", true);
		gameMusic.start();

		// 버튼 안보이게
		StartBtn.setVisible(false);
		replayBtn.setVisible(false);

		sales = new Sales(db);
		timer = new Timer();
		keyListener.KeyListener();

		ReGame();

		this.requestFocus(); // 컨텐트팬에 포커스 설정
		this.addKeyListener(keyListener);
	}

	public void ReGame() {
		Order.Guest guest = order.new Guest();
		order.Order();

		getParent().repaint();
	}

	// 화면 그리기
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// 배경화면
		g.drawImage(ImageBackground, 0, 0, this);
		if(end) { 
			g.drawImage(Main.burgermi.background.MenuImage, 0, 0, this);
		}

		Image burgerIngredient = null;
		int x = 0;
		int y = 0;

		Image MakeburgerIngredient = null;
		int Makex = 0;
		int Makey = 0;

		if (start) {
			// 재료대 음식
			if(keyListener.make.key!=0) {
				int z = 30;
				int zz = 430;
				for(int i=0; i<keyListener.make.IngredientsImage.length; i++, z+=120) {
					if(i==3) {
						z = 30;
						zz+=100;
					}
					g.drawImage(keyListener.make.IngredientsImage[i], z, zz, this);
				}
			}
			
			// 손님 그리기
			g.drawImage(order.thisGuest, 553, order.y, this);

			// 주문받은 버거
			for (int i = 0; i < order.orderBurger.size(); i++) {
				burgerIngredient = (Image) ((List<Object>) order.orderBurger.get(i)).get(0);
				x = (int) ((List<Object>) order.orderBurger.get(i)).get(1);
				y = (int) ((List<Object>) order.orderBurger.get(i)).get(2);
				g.drawImage(burgerIngredient, x, y, this);
			}

			// 쟁반
			g.drawImage(TrayBasicImage, 415, TrayY, this);

			if (ThrowBurger) {
				// 햄버거 던지기
				int BurgerX = 500, BurgerY = 290;
				if (ThrowImage != null && ThrowImage.equals(ImageThrow[1])) {
					BurgerX = 545;
					BurgerY = 180;
				}
				g.drawImage(ThrowImage, BurgerX, BurgerY, this);
			}

		}

		// 만드는 버거
		for (int i = 0; i < keyListener.make.MakeInformation.size(); i++) {
			MakeburgerIngredient = (Image) ((List<Object>) keyListener.make.MakeInformation.get(i)).get(0);
			Makex = (int) ((List<Object>) keyListener.make.MakeInformation.get(i)).get(1);
			Makey = (int) keyListener.make.i.get(i);
			g.drawImage(MakeburgerIngredient, Makex, Makey, this);
		}

	}

}