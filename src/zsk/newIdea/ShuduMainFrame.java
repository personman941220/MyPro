package zsk.newIdea;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;
public class ShuduMainFrame extends JFrame {
	public static int pass = 1; // �ؿ�
	public static JLabel lbPass; // ��ʾ�ؿ���lable
	public static long usedTime = 0; // 
	private ShuduCanvers panelCanvers; // ����Ϸ��
	public static Timer userTimeAction;

	/*
	 * Ĭ�Ϲ��캯��
	 */
	public ShuduMainFrame() {
		// ��ʼ������
		init();
		// ������
		addComponent();
		// �������Ϸ��
		addCanvers();

	}

	/*
	 * �������Ϸ��
	 */
	private void addCanvers() {
		panelCanvers = new ShuduCanvers();
		panelCanvers.setBorder(new TitledBorder("��Ϸ��"));

		// ������Ϸ����ӵ�������
		this.add(panelCanvers, BorderLayout.CENTER);

	}

	/*
	 * ��������
	 */
	private void addComponent() {
		JPanel panelComponent = new JPanel();
		// �����Ϣ��
		addPanelMsg(panelComponent);
		// ���ʱ����
		addPanelTime(panelComponent);

		// �������ӵ����嶥��
		this.add(panelComponent, BorderLayout.NORTH);

	}

	private void addPanelTime(JPanel panelComponent) {
		JPanel panelTime = new JPanel();
		panelTime.setBorder(new TitledBorder("ʱ��"));
		panelTime.setLayout(new GridLayout(2, 1));

		final JLabel lbSysTime = new JLabel();
		final JLabel lbUserTime = new JLabel();

		panelTime.add(lbSysTime, BorderLayout.NORTH);
		panelTime.add(lbUserTime, BorderLayout.SOUTH);

		// ����ϵͳʱ�䶨ʱ��
		Timer sysTimeAction = new Timer(500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				long timeMillis = System.currentTimeMillis();
				SimpleDateFormat df = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				lbSysTime.setText("    ϵͳʱ�䣺  " + df.format(timeMillis));
			}
		});
		sysTimeAction.start();
		userTimeAction = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lbUserTime.setText("    ������ʱ��  " + (++usedTime)+ " sec.");
			}
		});
		userTimeAction.start();

		panelComponent.add(panelTime, BorderLayout.EAST);

	}

	/*
	 * �����Ϣ��
	 */
	private void addPanelMsg(JPanel panelComponent) {
		// panelComponent.setBorder(new TitledBorder("��Ϣ��"));
		panelComponent.setLayout(new GridLayout(1, 3));
		Font font14 = new Font("", 4, 14);
		Font font28 = new Font("", 2, 28);

		JPanel panelMsg = new JPanel();
		panelMsg.setBorder(new TitledBorder("��Ϣ��"));

		JLabel lbPass1 = new JLabel("�ؿ�����");
		lbPass1.setFont(font14);
		panelMsg.add(lbPass1);

		// ��ʾ�ؿ���
		lbPass = new JLabel("" + pass);
		lbPass.setForeground(Color.RED);
		lbPass.setFont(font28);
		panelMsg.add(lbPass);

		JLabel lbPass2 = new JLabel("��/�ܹ�10��");
		lbPass2.setFont(font14);
		panelMsg.add(lbPass2);

		
//		Icon icon = new ImageIcon("icon/load.png");
//		JButton btnReLoad = new JButton("����", icon);
//		btnReLoad.setFont(font14);
//		// ���ذ�ť����
//		btnReLoad.setContentAreaFilled(false);
//		// ȡ����ť�߿�
//		btnReLoad.setBorderPainted(false);
//		btnReLoad.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				panelCanvers.reLoadCanvers();
//			}
//		});
//		// ����ť��ӵ���Ϣ��
//		 panelMsg.add(btnReLoad);
		panelComponent.add(panelMsg, BorderLayout.CENTER);

	}

	/*
	 * �����ʼ��
	 */
	private void init() {
		ImageIcon image = new ImageIcon("icon/icon.png");
		this.setIconImage(image.getImage());
		// ���ô��ڳ�ʼ��С
		this.setSize(515, 600);
		// ���ô��ڳ�ʼλ��
		this.setLocation(500, 50);
		// ���ô��ڱ���
		this.setTitle("������Ϸ(By������)");
		// ���ô��岻����ı��С
		this.setResizable(false);
		// ����Ĭ�Ϲرղ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

