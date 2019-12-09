package BurgerMi__99;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BurgerMi extends JFrame {
	public Image ImageBackground = new ImageIcon("src/images/BurgerMi���纻.png").getImage();
	private ImageIcon StartBasicImage = new ImageIcon("src/images/startButtonBasic.png");
	private ImageIcon StartEnteredImage = new ImageIcon("src/images/startButtonEntered.png");
	private ImageIcon QuitBasicImage = new ImageIcon("src/images/quitButtonBasic.png");
	private ImageIcon QuitEnteredImage = new ImageIcon("src/images/quitButtonEntered.png");

	private JButton StartBtn = new JButton(StartBasicImage);
	private JButton QuitBtn = new JButton(QuitBasicImage);

	public static Music introMusic;

	public static Game game = new Game();
	public static boolean replay = false; // ���� (ù����/ó������)
	public Background background;

	public BurgerMi() {
		setTitle("BurgerMi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if (replay) {
			setContentPane(game);
			game.Game();
		} else {
			background = new Background();
			setContentPane(background);
			setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
			setResizable(false);
			setLayout(null);
			setVisible(true);
			setLocationRelativeTo(null);
		}
	}

	// ȭ�� ����Ŭ����(Panel)
	class Background extends JPanel {
		Background() {
			introMusic = new Music("��Ȱ�� �ູ�ϰ� �̵� ������ �丮�� ���� ������ �Ǳ� ����.mp3", true);
			introMusic.start();

			// ���۹�ư
			StartBtn.setBounds(10, 350, 340, 120);
			StartBtn.setBorderPainted(false);
			StartBtn.setContentAreaFilled(false);
			StartBtn.setFocusPainted(false);
			StartBtn.addMouseListener(new MouseListener(StartBasicImage, StartEnteredImage));
			StartBtn.setVisible(true);
			this.add(StartBtn);

			// �����ư
			QuitBtn.setBounds(10, 470, 340, 120);
			QuitBtn.setBorderPainted(false);
			QuitBtn.setContentAreaFilled(false);
			QuitBtn.setFocusPainted(false);
			QuitBtn.addMouseListener(new MouseListener(QuitBasicImage, QuitEnteredImage));
			QuitBtn.setVisible(true);
			this.add(QuitBtn);
		}

		// ȭ�� �׸���
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(ImageBackground, 0, 0, this);
		}
	}

	// ���콺 ������
	class MouseListener extends MouseAdapter {
		ImageIcon Basic;
		ImageIcon Entered;

		public MouseListener(ImageIcon BasicImageIcon, ImageIcon EnteredImageIcon) {
			Basic = BasicImageIcon;
			Entered = EnteredImageIcon;
		}

		// �⺻��ư
		@Override
		public void mouseExited(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Basic);
		}

		// Ŭ����ư
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
			setContentPane(game);
			game.Game();
		}

		// ��ư ���� �ø���
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
