package BurgerMi__88888;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class End {
	public Image EndGame = new ImageIcon("src/images/���ȭ��.png").getImage();
	private ImageIcon ImageNext = new ImageIcon("src/images/�����ʹ�ư.png");
	private JButton r = new JButton(ImageNext);
	public JLabel allGrade = new JLabel("�� : " + BurgerMi.game.score + "��");

	End() {
		System.out.println("End : "+BurgerMi.game.End);
//		BurgerMi.game.grade.setVisible(false);
//		BurgerMi.game.timer.time.setVisible(false);
		
		r.setBounds(10, 10, 1280, 720);
		r.setBorderPainted(false);
		r.setContentAreaFilled(false);
		r.setFocusPainted(false);
		r.addMouseListener(new MouseListener());
		r.setVisible(true);
		BurgerMi.game.add(r);
		BurgerMi.game.End = true;
		System.out.println("End2 : "+BurgerMi.game.End);
		BurgerMi.game.repaint();

		
//		allGrade.setFont(new Font("������������� ExtraBold", Font.ITALIC, 50)); // ��Ʈ ����
//		allGrade.setSize(500, 500); // ũŰ ����
//		allGrade.setLocation(500, 500); // ��ġ ����
//		BurgerMi.game.add(allGrade);

		r.setVisible(true);
//		allGrade.setVisible(true);

	}

	// Ȯ�ι�ư ���콺������
	class MouseListener extends MouseAdapter {

		// �⺻��ư
		@Override
		public void mouseExited(MouseEvent e) {
			JButton button = (JButton) e.getSource();
		}

		// Ŭ����ư
		@Override
		public void mouseClicked(MouseEvent e) {

			System.out.println("mouse : "+BurgerMi.game.End);
			JButton butt = (JButton) e.getSource();

			Music Button = new Music("buttonPressedMusic.mp3", false);
			Button.start();
			System.out.println("dddd");
//			new BurgerMi();
//			BurgerMi(true);
			butt.setVisible(false);
//			BurgerMi.background(true);
			BurgerMi.game.End = false;
			System.out.println("mouse2 : "+BurgerMi.game.End);

			BurgerMi.game.burger = null;
			BurgerMi.game.score = null;
			BurgerMi.game.timer = null;
			BurgerMi.game.th = null;
//			BurgerMi.game.repaint();
			BurgerMi.game = null;

			BurgerMi.game = new Game();
			game.revalidate();
			game.repaint();
		}


		// ��ư ���� �ø���
		@Override
		public void mouseEntered(MouseEvent e) {
			JButton butt = (JButton) e.getSource();
			butt.setCursor(new Cursor(Cursor.HAND_CURSOR));

			Music Button = new Music("buttonEnteredMusic.mp3", false);
			Button.start();
		}
	}

}
