package BurgerMi_11_11;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Game extends JPanel {
	// ����ȭ��
	private Image ImageGame = new ImageIcon("src/images/GameBackground.png").getImage();
	private Image ImageRules = new ImageIcon("src/images/GameRules.png").getImage();
	public Image EndGame = new ImageIcon("src/images/���ȭ��.png").getImage();
	private Image ImageBackground;
		
	public void Game() {
		setLayout(null);
		ImageBackground = ImageRules;
	}
	
	// ȭ�� �׸���
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		g.drawImage(ImageBackground, 0, 0, this);
	}
}
