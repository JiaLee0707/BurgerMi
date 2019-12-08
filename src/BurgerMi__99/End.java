package BurgerMi__99;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class End{
	public Image EndGame = new ImageIcon("src/images/���ȭ��.png").getImage();
	private ImageIcon ReplayBasicImage = new ImageIcon("src/images/replayButtonBasic.png");
	private ImageIcon ReplayEnteredImage = new ImageIcon("src/images/replayButtonEntered.png");
	private ImageIcon QuitBasicImage = new ImageIcon("src/images/quitButtonBasic.png");
	private ImageIcon QuitEnteredImage = new ImageIcon("src/images/quitButtonEntered.png");
	public JLabel allGrade = new JLabel("�� : " + BurgerMi.game.score.score + "��");
	private JButton replayBtn = new JButton(ReplayBasicImage);
	private JButton QuitBtn = new JButton(QuitBasicImage);

	End() {
		BurgerMi.game.grade.setVisible(false);
		BurgerMi.game.timer.time.setVisible(false);
		
		// �ܹ��Ű� �������� �� ������ ���� �־
		// �ѹ� �� �ʱ�ȭ
		BurgerMi.game.order.orderBurger.clear();
		BurgerMi.game.order.MakeBurger.clear();
		BurgerMi.game.ingredients = null;
		
		BurgerMi.game.gameStart = false;

		BurgerMi.game.gameMusic.close();
		
		replayBtn.setBounds(10, 10, 340, 120);
		replayBtn.setBorderPainted(false);
		replayBtn.setContentAreaFilled(false);
		replayBtn.setFocusPainted(false);
		replayBtn.addMouseListener(new MouseListener(ReplayBasicImage, ReplayEnteredImage));
		replayBtn.setVisible(true);
		BurgerMi.game.add(replayBtn);

		// �����ư
		QuitBtn.setBounds(500, 470, 340, 120);
		QuitBtn.setBorderPainted(false);
		QuitBtn.setContentAreaFilled(false);
		QuitBtn.setFocusPainted(false);
		QuitBtn.addMouseListener(new MouseListener(QuitBasicImage, QuitEnteredImage));
		QuitBtn.setVisible(true);
		BurgerMi.game.add(QuitBtn);

		BurgerMi.game.End = true;

		allGrade.setFont(new Font("������������� ExtraBold", Font.ITALIC, 50)); // ��Ʈ ����
		allGrade.setSize(700, 700); // ũŰ ����
		allGrade.setLocation(200, 200); // ��ġ ����
		BurgerMi.game.add(allGrade);
		allGrade.setVisible(true);


		BurgerMi.game.revalidate();
		BurgerMi.game.repaint();
		
		return;
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
			
			button.setVisible(false);
			replayBtn.setVisible(false);
			QuitBtn.setVisible(false);
			allGrade.setVisible(false);

			BurgerMi.game.revalidate();
			BurgerMi.game.repaint();
			BurgerMi.game.getParent().repaint();
			
			BurgerMi.game.End = false;
			BurgerMi.game.replay = true;
			BurgerMi.game.Game();
			return;
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
