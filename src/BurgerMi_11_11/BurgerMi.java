package BurgerMi_11_11;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BurgerMi extends JFrame{
	
	public Background background;
	
	public BurgerMi() {
		setTitle("BurgerMi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		background = new Background();
		setContentPane(background);
		setSize(1280, 720);
		setResizable(false);	//창 크기 변경X
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);	//창위치 가운데
	}
}
class Background extends JPanel{
	private Image ImageBackground = new ImageIcon("src/images/BurgerMi복사본.png").getImage();
	private ImageIcon StartBasicImage = new ImageIcon("src/images/startButtonBasic.png");
	private ImageIcon StartEnteredImage = new ImageIcon("src/images/startButtonEntered.png");
	private ImageIcon QuitBasicImage = new ImageIcon("src/images/quitButtonBasic.png");
	private ImageIcon QuitEnteredImage = new ImageIcon("src/images/quitButtonEntered.png");
	private Image MenuImage = new ImageIcon("src/images/메뉴화면.png").getImage();
	
	private JButton StartBtn = new JButton(StartBasicImage);
	private JButton QuitBtn = new JButton(QuitBasicImage);
	
	public Background() {
		
	}
	
	
	
	// 화면 그리기
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageBackground, 0, 0, this);
	}
}