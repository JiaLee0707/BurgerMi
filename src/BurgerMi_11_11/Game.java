package BurgerMi_11_11;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Game extends JPanel {
	
	Background background;
	
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
		ImageBackground =ImageGame;
		background.introMusic.close();
		Music gameMusic = new Music("�丮.mp3", true);
		gameMusic.start();
	}
	
	// ȭ�� �׸���
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		g.drawImage(ImageBackground, 0, 0, this);
	}
}
