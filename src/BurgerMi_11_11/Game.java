package BurgerMi_11_11;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Game extends JPanel {
	
	Background background;
	
	// 게임화면
	private Image ImageGame = new ImageIcon("src/images/GameBackground.png").getImage();
	private Image ImageRules = new ImageIcon("src/images/GameRules.png").getImage();
	public Image EndGame = new ImageIcon("src/images/결과화면.png").getImage();
	private Image ImageBackground;
	
	// 게임시작 버튼
	MouseListener mouse = new MouseListener();
	private JButton StartBtn = new JButton(mouse.StartBasicImage);
		
	public void Game() {
		setLayout(null);
		ImageBackground = ImageRules;
		
		// 시작버튼
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
		Music gameMusic = new Music("요리.mp3", true);
		gameMusic.start();
	}
	
	// 화면 그리기
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		g.drawImage(ImageBackground, 0, 0, this);
	}
}
