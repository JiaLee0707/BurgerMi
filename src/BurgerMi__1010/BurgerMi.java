package BurgerMi__1010;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BurgerMi extends JFrame {
	private Image ImageBackground = new ImageIcon("src/images/BurgerMi복사본.png").getImage();
	private ImageIcon StartBasicImage = new ImageIcon("src/images/startButtonBasic.png");
	private ImageIcon StartEnteredImage = new ImageIcon("src/images/startButtonEntered.png");
	private ImageIcon QuitBasicImage = new ImageIcon("src/images/quitButtonBasic.png");
	private ImageIcon QuitEnteredImage = new ImageIcon("src/images/quitButtonEntered.png");
	public static Image MenuImage = new ImageIcon("src/images/메뉴화면.png").getImage();

	public static Music introMusic;

	public static Game game;
	public static Ranking ranking = new Ranking();
	public static boolean replay = false; // 게임 (첫시작/처음시작)
	public Background background;
	public static Font font = new Font("나눔스퀘어라운드 ExtraBold", Font.BOLD, 50); // ITALIC

	public static boolean Menu = false; // 메뉴

	public BurgerMi() {
		setTitle("BurgerMi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		background = new Background();
		setContentPane(background);
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 창 크기 변경X
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null); // 창위치 가운데
	}

	public void JPanelChange() {
		background = new Background();
		setContentPane(background);

//		game = new Game();
//		setContentPane(game);
//		game.Game();
	}

	// 화면 내부클래스(Panel)
	class Background extends JPanel {
		private JButton StartBtn = new JButton(StartBasicImage);
		private JButton QuitBtn = new JButton(QuitBasicImage);

		Background() {
			setLayout(null);

			introMusic = new Music("BurgerMi 타이틀 음악.mp3", true);
			introMusic.start();

			// 시작버튼
			StartBtn.setBounds(10, 350, 340, 120);
			StartBtn.setBorderPainted(false);
			StartBtn.setContentAreaFilled(false);
			StartBtn.setFocusPainted(false);
			StartBtn.addMouseListener(new MouseListener(StartBasicImage, StartEnteredImage));
			StartBtn.setVisible(true);
			this.add(StartBtn);

			// 종료버튼
			QuitBtn.setBounds(10, 470, 340, 120);
			QuitBtn.setBorderPainted(false);
			QuitBtn.setContentAreaFilled(false);
			QuitBtn.setFocusPainted(false);
			QuitBtn.addMouseListener(new MouseListener(QuitBasicImage, QuitEnteredImage));
			QuitBtn.setVisible(true);
			this.add(QuitBtn);
		}

		// 화면 그리기
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(ImageBackground, 0, 0, this);
		}
	}

	// 마우스 리스너
	class MouseListener extends MouseAdapter {
		ImageIcon Basic;
		ImageIcon Entered;

		public MouseListener(ImageIcon BasicImageIcon, ImageIcon EnteredImageIcon) {
			Basic = BasicImageIcon;
			Entered = EnteredImageIcon;
		}

		// 기본버튼
		@Override
		public void mouseExited(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Basic);
		}

		// 클릭버튼
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Entered);

			Music Button = new Music("buttonPressedMusic.mp3", false);
			Button.start();

			if (Entered.equals(QuitEnteredImage)) {
				System.exit(0);
			}

			background.setVisible(false);
			game = new Game();
			setContentPane(game);
			game.Game();
		}

		// 버튼 위에 올리면
		@Override
		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Entered);
			button.setCursor(new Cursor(Cursor.HAND_CURSOR));

			Music Button = new Music("buttonEnteredMusic.mp3", false);
			Button.start();
		}
	}

}