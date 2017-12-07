package zsk.newIdea;

import zsk.newIdea.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ShuduCanvers extends JPanel implements MouseListener{
	ShuduCell[][] cells;
	// �õ���������
	int[][] maps = new int[9][9];
	private SelectNumFrame selectNum;

	/*
	 * Ĭ�Ϲ��캯��
	 */
	public ShuduCanvers() {
		ShuduMainFrame.usedTime = 0;
		maps = ShuDuDemo.getMap();
		// ����������
		this.setLayout(null);
		cells = new ShuduCell[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				// this.remove(cells[i][j]);
				// ������Ԫ��
				cells[i][j] = new ShuduCell();
				// ����λ��
				cells[i][j].setLocation(20 + i * 50 + (i / 3) * 5, 20 + j * 50
						+ (j / 3) * 5);
				if (passRole(ShuduMainFrame.pass)) {
					cells[i][j].setText("" + maps[i][j]);
					// ���ñ�����ɫ
					cells[i][j].setBackground(getColor(maps[i][j]));
					cells[i][j].setEnabled(false);
					cells[i][j].setForeground(Color.gray);
				} else {
					cells[i][j].addMouseListener(this);
				}
				this.add(cells[i][j]);
			}
		}
		checkFinish();

		// reLoadCanvers();
	}

	/*
	 * ����Ƿ����
	 */
	private void checkFinish() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
					if (!check(i, j)) {
						return;
					}
				}
			}
		
		// ֹͣ�û���ʱ��ʱ��
		ShuduMainFrame.userTimeAction.stop();
		// �������cell����
		clearAllListener();
		// ��������һ
		ShuduMainFrame.pass += 1;
		if (ShuduMainFrame.pass > 10) {
			int o = JOptionPane
					.showConfirmDialog(this, "���Ѿ�ͨ���ˣ��Ƿ���ͷ��ʼ��", "", 0);
			if (o == 1) {
				System.exit(0);
			} else {
				ShuduMainFrame.pass = 1;
			}
		} else {
			JOptionPane.showMessageDialog(this, "��ϲ��ͨ�����أ���ʱ��"
					+ ShuduMainFrame.usedTime + "��\n����������һ�أ�");
		}
		// ���¹ؿ���ʾ
		ShuduMainFrame.lbPass.setText("" + ShuduMainFrame.pass);
		// ��ʼ�µĹؿ�
		reLoadCanvers();
		// ���û���ʱ��ʱ��
		ShuduMainFrame.userTimeAction.start();

	}

	/*
	 * ���ָ�����괦�ĵ�Ԫ��
	 */

	private boolean check(int i, int j) {
		if (cells[i][j].getText().isEmpty()) {
			return false;
		}
		
		for (int k = 0; k < 9; k++) {
			if (cells[i][j].getText().trim().equals(cells[i][k].getText().trim()) && j!=k) {
				return false;
			}
			if (cells[i][j].getText().trim().equals(cells[k][j].getText().trim()) && i != k) {
				return false;
			}
			int ii = (i / 3) * 3 + k / 3;
			int jj = (j / 3) * 3 + k % 3;
			if (cells[i][j].getText().trim().equals(cells[ii][jj].getText().trim()) &&!(i == ii && j == jj)) {
				return false;
			}

		}
		return true;
	}

	/*
	 * ���¼���������
	 */
	public void reLoadCanvers() {
		ShuduMainFrame.usedTime = 0;
		maps = ShuDuDemo.getMap();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.remove(cells[i][j]);
				// ������Ԫ��
				cells[i][j] = new ShuduCell();
				// ����λ��
				cells[i][j].setLocation(20 + i * 50 + (i / 3) * 5, 20 + j * 50
						+ (j / 3) * 5);
				if (passRole(ShuduMainFrame.pass)) {
					cells[i][j].setText("" + maps[i][j]);
					// ���ñ�����ɫ
					cells[i][j].setBackground(getColor(maps[i][j]));
					cells[i][j].setEnabled(false);
					cells[i][j].setForeground(Color.gray);
				} else {
					cells[i][j].addMouseListener(this);
				}
				this.add(cells[i][j]);
			}
		}
		this.repaint();
		checkFinish();

	}

	/*
	 * ���ݹؿ����������λ���Ƿ���ʾ����
	 */
	private boolean passRole(int pass) {
		// TODO Auto-generated method stub
		return Math.random() * 11 > pass;
	}

	/*
	 * �������ֻ����ɫ
	 */
	private Color getColor(int i) {
		Color color = Color.pink;
		switch (i) {
		case 1:
			color = new Color(255, 255, 204);
			break;
		case 2:
			color = new Color(204, 255, 255);
			break;
		case 3:
			color = new Color(255, 204, 204);
			break;
		case 4:
			color = new Color(255, 204, 153);
			break;
		case 5:
			color = new Color(204, 255, 153);
			break;
		case 6:
			color = new Color(204, 204, 204);
			break;
		case 7:
			color = new Color(255, 204, 204);
			break;
		case 8:
			color = new Color(255, 255, 255);
			break;
		case 9:
			color = new Color(153, 255, 153);
			break;
		default:
			break;
		}
		return color;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int modes = e.getModifiers();
		if ((modes & InputEvent.BUTTON3_MASK) != 0) {// �������Ҽ�
			// ��յ����Ԫ���ϵ�����
			((ShuduCell) e.getSource()).setText("");
		} else if ((modes & InputEvent.BUTTON1_MASK) != 0) {// ���������
			// ���ѡ�����ִ��ڴ���������
			if (selectNum != null) {
				selectNum.dispose();
			}
			// �½�һ��ѡ�񴰿�
			selectNum = new SelectNumFrame();
			// ���ó�ģ̬����
			selectNum.setModal(true);
			// ����ѡ�񴰿�����ʾ���ϵ�λ��
			selectNum.setLocation(e.getLocationOnScreen().x,
					e.getLocationOnScreen().y);
			// ������ĵ�Ԫ�񴫵ݸ�����ѡ�񴰿�
			selectNum.setCell((ShuduCell) e.getSource());
			// ��ʾ����ѡ�񴰿�
			selectNum.setVisible(true);
		}
		checkFinish();
	}

	/*
	 * �������cell�ĵ������
	 */
	private void clearAllListener() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				cells[i][j].removeMouseListener(this);
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}