package BurgerMi_14_14;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BurgerMi extends JFrame {
	
	public Background background;
	public Game game;

	public BurgerMi() {	
		setTitle("BurgerMi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		background = new Background();
		setContentPane(background);
		setSize(1280, 720);
		setResizable(false); // â ũ�� ����X
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null); // â��ġ ���
	}
	
	public void JPanelChange(String panel) {
		System.out.println("Change");
		if(panel.equals("game")) {
			System.out.println("game");
			background.setVisible(false);
			game = new Game();

			setContentPane(game);
			game.Game();
		} else {
			game.gameMusic.close();
			game.setVisible(false);
			
			background = new Background();
			setContentPane(background);
		}
	}
}

class Background extends JPanel {
	Music introMusic;
	MouseListener mouse = new MouseListener();
	
	private JButton StartBtn = new JButton(mouse.StartBasicImage);
	private JButton QuitBtn = new JButton(mouse.QuitBasicImage);
	
	private Image ImageBackground = new ImageIcon("src/images/BurgerMi���纻.png").getImage();
	private Image MenuImage = new ImageIcon("src/images/�޴�ȭ��.png").getImage();


	public Background() {
		setLayout(null);
		
		introMusic = new Music("BurgerMi Ÿ��Ʋ ����.mp3", true);
		introMusic.start();

		// ���۹�ư
		StartBtn.setBounds(10, 350, 340, 120);
		StartBtn.setBorderPainted(false);
		StartBtn.setContentAreaFilled(false);
		StartBtn.setFocusPainted(false);
		StartBtn.addMouseListener(mouse.new Listener("Background", mouse.StartBasicImage, mouse.StartEnteredImage));
		StartBtn.setVisible(true);
		this.add(StartBtn);

		// �����ư
		QuitBtn.setBounds(10, 470, 340, 120);
		QuitBtn.setBorderPainted(false);
		QuitBtn.setContentAreaFilled(false);
		QuitBtn.setFocusPainted(false);
		QuitBtn.addMouseListener(mouse.new Listener("Background", mouse.QuitBasicImage, mouse.QuitEnteredImage));
		QuitBtn.setVisible(true);
		this.add(QuitBtn);
	}

	// ȭ�� �׸���
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageBackground, 0, 0, this);
	}
}