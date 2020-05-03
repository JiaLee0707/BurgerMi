package BurgerMi__11;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.*;

public class BurgerMi extends JFrame {
	private ImageIcon StartBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon StartEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));

	public Image ImageBackground = new ImageIcon(Main.class.getResource("../images/BurgerMi복사본.png")).getImage();
	private Image ScreenBackground;
	private Graphics GraphicsBackground;

	private JButton StartBtn = new JButton(StartBasicImage);

	private Music introMusic = new Music("쾌활한 행복하고 이동 지중해 요리에 가장 적합한 악기 음악.mp3", true);
	private boolean isGameScreen = false;

	public static Game game = new Game();

	public BurgerMi() {
		setTitle("BurgerMi");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		setLayout(null);

		introMusic.start();

		StartBtn.setBounds(40, 340, 550, 400);
		StartBtn.setBorderPainted(false);
		StartBtn.setContentAreaFilled(false);
		StartBtn.setFocusPainted(false);
		StartBtn.addMouseListener(new MouseListener(StartBasicImage, StartEnteredImage));
		StartBtn.setVisible(true);
		this.add(StartBtn);

	}

	class MouseListener extends MouseAdapter {
		ImageIcon Basic;
		ImageIcon Entered;

		public MouseListener(ImageIcon BasicImageIcon, ImageIcon EnteredImageIcon) {
			Basic = BasicImageIcon;
			Entered = EnteredImageIcon;
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Basic);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Entered);

			Music Button = new Music("buttonPressedMusic.mp3", false);
			Button.start();
			introMusic.close();

			ImageBackground = new ImageIcon(Main.class.getResource("../images/GameImage.png")).getImage();
			StartBtn.setVisible(false);
			isGameScreen = true;
			requestFocus();
//			game.Game();
			addKeyListener(new KeyListener());
//			setFocusable(true);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Entered);
			button.setCursor(new Cursor(Cursor.HAND_CURSOR));

			Music Button = new Music("buttonEnteredMusic.mp3", false);
			Button.start();
		}
	}

	public void paint(Graphics g) {
		ScreenBackground = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		GraphicsBackground = ScreenBackground.getGraphics();
		screenDraw(GraphicsBackground);
		g.drawImage(ScreenBackground, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(ImageBackground, 0, 0, null);
		if (isGameScreen) {
			game.screenDraw(g);
		}
//		paintComponents(g);
		this.repaint();
	}
}
