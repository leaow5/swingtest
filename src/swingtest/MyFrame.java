package swingtest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.api.SubstanceSkin;
import org.jvnet.substance.skin.BusinessBlueSteelSkin;
import org.jvnet.substance.skin.SubstanceBusinessBlueSteelLookAndFeel;

import com.spark.core.SerialPortFactory;
import com.spark.utils.WinEnvUtils;

public class MyFrame extends JFrame {

	/**
	 * 常量.
	 */
	private static final long serialVersionUID = 8999460803054277945L;
	static Logger logger = LogManager.getLogger(MyFrame.class.getName());
	final ImageIcon icon_connect = new ImageIcon("resource//green.jpg");
	final ImageIcon icon_disconnect = new ImageIcon(
			"resource//green_disconnect.jpg");
	final ImageIcon icon_main = new ImageIcon("resource//green2.jpg");
	final ImageIcon icon_green = new ImageIcon("resource//green0.jpg");
	final ImageIcon icon_green2 = new ImageIcon("resource//green1.jpg");
	final ImageIcon icon_red = new ImageIcon("resource//red_main.jpg");
	final ImageIcon icon_red2 = new ImageIcon("resource//red_dark.jpg");
	private JPanel panel; // panel Main
	private JTextField textField_simmer;
	protected JLabel lab_connect;
	protected JPanel panel_Connect;
	protected JButton btnConnect;
	protected JSlider slider;
	protected JMenuItem mntmAbout;
	protected JLabel label_red_9;
	protected JLabel label_red_21;
	protected JLabel label_red_16;
	protected JLabel label_red_11;
	protected JLabel label_red_18;
	protected JLabel label_red_19;
	protected JLabel label_red_20;
	protected JLabel label_red_22;
	protected JLabel label_red_23;
	protected JLabel label_HBR;
	protected JLabel label_MTR;
	protected JLabel label_HTR;
	protected JLabel label_SF;
	protected JLabel label_APS;
	protected JLabel label_A24;
	protected JLabel label_Warning;
	protected JLabel label_LaserReady;
	protected JLabel label_ESA;
	protected JLabel label_GESA;
	protected JLabel label_PRRH;
	protected JLabel label_PRRL;
	protected JLabel label_MONTL;
	protected JLabel label_MOFTL;
	protected JLabel label_Emission;
	protected JLabel label_24VS;
	protected JLabel label_24VHS;
	protected JLabel label_5VHS;
	private JTable table_OperParam;
	private JTable tableNomParam;
	private JTable table_Monitor;
	private JTable table_Info;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final MyFrame frame = new MyFrame();
					frame.addWindowListener(new WindowListener() {

						@Override
						public void windowOpened(WindowEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void windowIconified(WindowEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void windowDeiconified(WindowEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void windowDeactivated(WindowEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void windowClosing(WindowEvent e) {
							JOptionPane.showMessageDialog(frame, "测试退出事件\r\n");

						}

						@Override
						public void windowClosed(WindowEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void windowActivated(WindowEvent e) {
							// TODO Auto-generated method stub

						}
					});
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame() {

		// try {
		// org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		// } catch (Exception e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// 设置LookAndFeel样式
		// try {
		// javax.swing.UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessBlueSteelLookAndFeel");
		// } catch (ClassNotFoundException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (InstantiationException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (IllegalAccessException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (UnsupportedLookAndFeelException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }

		SubstanceSkin skin = new BusinessBlueSteelSkin(); // 初始化有水印的皮肤

		try {
			UIManager.setLookAndFeel(
					new SubstanceBusinessBlueSteelLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SubstanceLookAndFeel.setSkin(skin);
		//
		handleFrameAttr();

		handleMenu();

		handleConnect();

		bindEvent();
	}

	/**
	 * 设置frame属性
	 */
	private void handleFrameAttr() {
		// UI大小不可更改
		setResizable(false);
		setTitle("安扬Series Control Utility");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		this.setIconImage(icon_main.getImage());
	}

	/**
	 * 处理菜单栏
	 */
	private void handleMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMain = new JMenu("Main");
		menuBar.add(mnMain);

		JMenuItem mntmMain = new JMenuItem("Main");
		mnMain.add(mntmMain);

		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);

		mntmAbout = new JMenuItem("About");
		mnAbout.add(mntmAbout);
	}

	/**
	 * 处理连接
	 */
	private void handleConnect() {
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		this.panel_Connect = new JPanel();
		this.panel_Connect.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"Connect", TitledBorder.LEADING, TitledBorder.TOP, null,
						SystemColor.desktop));
		this.panel_Connect.setToolTipText("Connect");
		this.panel_Connect.setBounds(10, 10, 280, 74);
		panel.add(panel_Connect);
		panel_Connect.setLayout(null);

		this.btnConnect = new JButton("Connect");
		this.btnConnect.setBounds(69, 23, 91, 29);
		panel_Connect.add(btnConnect);

		JComboBox<String> comboBox = new JComboBox<String>();
		final List<String> portNames = WinEnvUtils.getPortId();
		for (String name : portNames) {
			comboBox.addItem(name);
		}
		comboBox.setBounds(170, 23, 91, 29);
		panel_Connect.add(comboBox);

		lab_connect = new JLabel(icon_disconnect);
		lab_connect.setBounds(29, 22, 30, 30);
		panel_Connect.add(lab_connect);
	}

	/**
	 * 启动页面内容
	 */
	private void handleMain() {

	}

	/**
	 * 处理itemNo.和Mode内容
	 */
	private void handleItemAndMode() {
		JPanel panel_ItemType = new JPanel();
		panel_ItemType.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"Item NO.", TitledBorder.LEADING, TitledBorder.TOP,
						null, SystemColor.desktop));
		panel_ItemType.setBounds(300, 10, 91, 74);
		panel.add(panel_ItemType);

		JButton btnMode = new JButton("MODE");
		btnMode.setBounds(401, 19, 91, 64);
		panel.add(btnMode);
	}

	/**
	 * DB25页面内容
	 */
	private void handleDB25() {
		handleItemAndMode();
		handleDB25_Control();
		handlePRRAndSet();
		handleStats();
		handleInfos();
	}

	/**
	 * DB25_Control 显示区
	 */
	private void handleDB25_Control() {
		JPanel panel_DB25_Control = new JPanel();
		panel_DB25_Control.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"DB25 Control", TitledBorder.LEADING, TitledBorder.TOP,
						null, SystemColor.desktop));
		panel_DB25_Control.setBounds(10, 94, 484, 235);
		panel.add(panel_DB25_Control);
		panel_DB25_Control.setLayout(null);

		JLabel lblNewLabel = new JLabel("Power percent ");
		lblNewLabel.setBounds(10, 22, 95, 15);
		panel_DB25_Control.add(lblNewLabel);

		JLabel label_db25_pp = new JLabel("xx");
		label_db25_pp.setBounds(101, 22, 18, 15);
		panel_DB25_Control.add(label_db25_pp);

		JLabel label = new JLabel("%");
		label.setBounds(120, 22, 18, 15);
		panel_DB25_Control.add(label);

		JLabel lblNewLabel_1 = new JLabel("Pulse Repetition Rate");
		lblNewLabel_1.setBounds(10, 46, 134, 15);
		panel_DB25_Control.add(lblNewLabel_1);

		JLabel label_db25_prr = new JLabel("xx");
		label_db25_prr.setBounds(143, 46, 18, 15);
		panel_DB25_Control.add(label_db25_prr);

		JLabel label_2 = new JLabel("%");
		label_2.setBounds(162, 46, 18, 15);
		panel_DB25_Control.add(label_2);

		JPanel panel_Alarm = new JPanel();
		panel_Alarm.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"Alarm", TitledBorder.LEADING, TitledBorder.TOP, null,
						SystemColor.desktop));
		panel_Alarm.setBounds(10, 185, 464, 34);
		panel_DB25_Control.add(panel_Alarm);
		panel_Alarm.setLayout(null);

		JLabel label_Alarm = new JLabel("Laser is not ready for emission");
		label_Alarm.setBounds(10, 10, 444, 24);
		panel_Alarm.add(label_Alarm);

		label_red_9 = new JLabel(icon_red2);
		label_red_9.setBounds(200, 15, 30, 30);
		panel_DB25_Control.add(label_red_9);

		label_red_21 = new JLabel(icon_red2);
		label_red_21.setBounds(200, 50, 30, 30);
		panel_DB25_Control.add(label_red_21);

		label_red_16 = new JLabel(icon_red2);
		label_red_16.setBounds(200, 85, 30, 30);
		panel_DB25_Control.add(label_red_16);

		label_red_11 = new JLabel(icon_red2);
		label_red_11.setBounds(200, 120, 30, 30);
		panel_DB25_Control.add(label_red_11);

		JLabel lbllatch = new JLabel((Icon) null);
		lbllatch.setText("9-Latch");
		lbllatch.setBounds(240, 15, 50, 30);
		panel_DB25_Control.add(lbllatch);

		JLabel lblalarm = new JLabel((Icon) null);
		lblalarm.setText("21-Alarm 1");
		lblalarm.setBounds(240, 50, 70, 30);
		panel_DB25_Control.add(lblalarm);

		JLabel lblalarm_1 = new JLabel((Icon) null);
		lblalarm_1.setText("16-Alarm 0");
		lblalarm_1.setBounds(240, 85, 70, 30);
		panel_DB25_Control.add(lblalarm_1);

		JLabel lblalarm_2 = new JLabel((Icon) null);
		lblalarm_2.setText("12-Alarm 2");
		lblalarm_2.setBounds(240, 120, 70, 30);
		panel_DB25_Control.add(lblalarm_2);

		label_red_18 = new JLabel(icon_red2);
		label_red_18.setBounds(320, 15, 30, 30);
		panel_DB25_Control.add(label_red_18);

		label_red_19 = new JLabel(icon_red2);
		label_red_19.setBounds(320, 50, 30, 30);
		panel_DB25_Control.add(label_red_19);

		label_red_20 = new JLabel(icon_red2);
		label_red_20.setBounds(320, 85, 30, 30);
		panel_DB25_Control.add(label_red_20);

		label_red_22 = new JLabel(icon_red2);
		label_red_22.setBounds(320, 120, 30, 30);
		panel_DB25_Control.add(label_red_22);

		label_red_23 = new JLabel(icon_red2);
		label_red_23.setBounds(320, 155, 30, 30);
		panel_DB25_Control.add(label_red_23);

		JLabel lblenmisson = new JLabel((Icon) null);
		lblenmisson.setHorizontalAlignment(SwingConstants.LEFT);
		lblenmisson.setText("18-Emisson Enable");
		lblenmisson.setBounds(365, 15, 110, 30);
		panel_DB25_Control.add(lblenmisson);

		JLabel lblbooster = new JLabel((Icon) null);
		lblbooster.setHorizontalAlignment(SwingConstants.LEFT);
		lblbooster.setText("19-Booster");
		lblbooster.setBounds(365, 50, 110, 30);
		panel_DB25_Control.add(lblbooster);

		JLabel lbls = new JLabel((Icon) null);
		lbls.setText("20-Svncronization");
		lbls.setHorizontalAlignment(SwingConstants.LEFT);
		lbls.setBounds(365, 85, 110, 30);
		panel_DB25_Control.add(lbls);

		JLabel lblguide = new JLabel((Icon) null);
		lblguide.setText("22-Guide Laser");
		lblguide.setHorizontalAlignment(SwingConstants.LEFT);
		lblguide.setBounds(365, 120, 110, 30);
		panel_DB25_Control.add(lblguide);

		JLabel lblemerg = new JLabel((Icon) null);
		lblemerg.setText("23-Emergency Stop");
		lblemerg.setHorizontalAlignment(SwingConstants.LEFT);
		lblemerg.setBounds(365, 155, 110, 30);
		panel_DB25_Control.add(lblemerg);
	}

	/**
	 * 左下区域PRR、Set显示
	 */
	private void handlePRRAndSet() {

		JPanel panel_DB25_PRR = new JPanel();
		panel_DB25_PRR.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"Extended PRR", TitledBorder.LEADING, TitledBorder.TOP,
						null, SystemColor.desktop));
		panel_DB25_PRR.setBounds(10, 335, 484, 85);
		panel.add(panel_DB25_PRR);
		panel_DB25_PRR.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Minimun PRR     16.0 KHz");
		lblNewLabel_3.setBounds(10, 20, 149, 24);
		panel_DB25_PRR.add(lblNewLabel_3);

		JLabel lblMaxmunPrr = new JLabel("Maxmun PRR     1000.0 KHz");
		lblMaxmunPrr.setBounds(307, 20, 167, 24);
		panel_DB25_PRR.add(lblMaxmunPrr);

		JPanel panel_PulseMode = new JPanel();
		panel_PulseMode.setLayout(null);
		panel_PulseMode.setBorder(new TitledBorder(
				UIManager.getBorder("TitledBorder.border"),
				"Adjustable Pulse Mode", TitledBorder.LEADING, TitledBorder.TOP,
				null, UIManager.getColor("TitledBorder.titleColor")));
		panel_PulseMode.setBounds(10, 430, 484, 74);
		panel.add(panel_PulseMode);

		JButton btnMutilpulse = new JButton("Mutilpulse");
		// btnMutilpulse.setActionCommand("Save to laser\r\nEEPROM");
		btnMutilpulse.setBounds(10, 22, 153, 42);
		panel_PulseMode.add(btnMutilpulse);

		JButton btnMonopulse = new JButton("Monopulse");
		btnMonopulse.setBounds(187, 22, 153, 42);
		panel_PulseMode.add(btnMonopulse);
		// btnMonopulse.setActionCommand("Save to laser\r\nEEPROM");

		JPanel panel_PulseDuration = new JPanel();
		panel_PulseDuration.setLayout(null);
		panel_PulseDuration.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"Adjustable Pulse Duration", TitledBorder.LEADING,
						TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_PulseDuration.setBounds(8, 505, 484, 70);
		panel.add(panel_PulseDuration);

		JLabel label_3 = new JLabel("ns");
		label_3.setBounds(140, 20, 39, 38);
		panel_PulseDuration.add(label_3);

		JButton btnSaveLaser = new JButton("Save to laser \r\nEEPROM");
		// btnSaveLaser.setActionCommand("Save to laser\r\nEEPROM");
		btnSaveLaser.setBounds(190, 22, 153, 42);
		panel_PulseDuration.add(btnSaveLaser);

		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(10, 22, 120, 36);
		panel_PulseDuration.add(formattedTextField_2);

		JPanel panel_Burst = new JPanel();
		panel_Burst.setLayout(null);
		panel_Burst.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"Burst", TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(0, 0, 0)));
		panel_Burst.setBounds(10, 575, 484, 64);
		panel.add(panel_Burst);

		JButton btnSet_Burst = new JButton("Set");
		btnSet_Burst.setActionCommand("");
		btnSet_Burst.setBounds(190, 14, 153, 42);
		panel_Burst.add(btnSet_Burst);

		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(10, 18, 120, 36);
		panel_Burst.add(formattedTextField_1);

		JPanel panel_Simmer = new JPanel();
		panel_Simmer.setLayout(null);
		panel_Simmer.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"Simmer Current", TitledBorder.LEADING,
						TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Simmer.setBounds(10, 640, 482, 75);
		panel.add(panel_Simmer);

		JButton btnSet_Simmer = new JButton("Set");
		btnSet_Simmer.setActionCommand("");
		btnSet_Simmer.setBounds(238, 22, 153, 42);
		panel_Simmer.add(btnSet_Simmer);

		slider = new JSlider(1, 100, 1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(1);
		slider.setBounds(10, 16, 153, 48);
		panel_Simmer.add(slider);

		textField_simmer = new JTextField("1 %");
		textField_simmer.setEditable(false);
		textField_simmer.setBounds(173, 33, 55, 21);
		panel_Simmer.add(textField_simmer);
		textField_simmer.setColumns(10);

	}

	/**
	 * 处理status页面内容
	 */
	private void handleStats() {
		JPanel panel_Status = new JPanel();
		panel_Status.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"Status", TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(0, 0, 0)));
		panel_Status.setBounds(504, 10, 504, 320);
		panel.add(panel_Status);
		panel_Status.setLayout(null);

		JPanel panel_Monitor1 = new JPanel();
		panel_Monitor1.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"Monitor", TitledBorder.LEADING, TitledBorder.TOP, null,
						SystemColor.desktop));
		panel_Monitor1.setBounds(10, 15, 227, 300);
		panel_Status.add(panel_Monitor1);
		panel_Monitor1.setLayout(null);

		label_HBR = new JLabel(icon_red2);
		label_HBR.setBounds(15, 15, 20, 20);
		panel_Monitor1.add(label_HBR);

		label_MTR = new JLabel(icon_red2);
		label_MTR.setBounds(15, 40, 20, 20);
		panel_Monitor1.add(label_MTR);

		label_HTR = new JLabel(icon_red2);
		label_HTR.setBounds(15, 65, 20, 20);
		panel_Monitor1.add(label_HTR);

		label_SF = new JLabel(icon_red2);
		label_SF.setBounds(15, 90, 20, 20);
		panel_Monitor1.add(label_SF);

		label_APS = new JLabel(icon_red2);
		label_APS.setBounds(15, 115, 20, 20);
		panel_Monitor1.add(label_APS);

		label_A24 = new JLabel(icon_red2);
		label_A24.setBounds(15, 140, 20, 20);
		panel_Monitor1.add(label_A24);

		label_Warning = new JLabel(icon_red2);
		label_Warning.setBounds(15, 165, 20, 20);
		panel_Monitor1.add(label_Warning);

		JButton btnResetAlarms = new JButton("Reset Alarms");
		btnResetAlarms.setBounds(58, 222, 137, 48);
		panel_Monitor1.add(btnResetAlarms);

		JLabel lblHighBackReflection = new JLabel((Icon) null);
		lblHighBackReflection.setHorizontalAlignment(SwingConstants.LEFT);
		lblHighBackReflection.setText("High Back Reflection");
		lblHighBackReflection.setBounds(55, 15, 150, 20);
		panel_Monitor1.add(lblHighBackReflection);

		JLabel lblModuleTempOut = new JLabel((Icon) null);
		lblModuleTempOut.setText("Module Temp. out of Range");
		lblModuleTempOut.setHorizontalAlignment(SwingConstants.LEFT);
		lblModuleTempOut.setBounds(55, 40, 150, 20);
		panel_Monitor1.add(lblModuleTempOut);

		JLabel lblHeadTempOut = new JLabel((Icon) null);
		lblHeadTempOut.setText("Head Temp. out of Range");
		lblHeadTempOut.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeadTempOut.setBounds(55, 65, 150, 20);
		panel_Monitor1.add(lblHeadTempOut);

		JLabel lblSystemFailure = new JLabel((Icon) null);
		lblSystemFailure.setText("System Failure");
		lblSystemFailure.setHorizontalAlignment(SwingConstants.LEFT);
		lblSystemFailure.setBounds(55, 90, 150, 20);
		panel_Monitor1.add(lblSystemFailure);

		JLabel lblAlarmPowerSupply = new JLabel((Icon) null);
		lblAlarmPowerSupply.setToolTipText("");
		lblAlarmPowerSupply.setText("Alarm Power Supply 24V");
		lblAlarmPowerSupply.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlarmPowerSupply.setBounds(55, 115, 150, 20);
		panel_Monitor1.add(lblAlarmPowerSupply);

		JLabel lblAlarmvHousekeeping = new JLabel((Icon) null);
		lblAlarmvHousekeeping.setToolTipText("");
		lblAlarmvHousekeeping.setText("Alarm 24V housekeeping");
		lblAlarmvHousekeeping.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlarmvHousekeeping.setBounds(55, 140, 150, 20);
		panel_Monitor1.add(lblAlarmvHousekeeping);

		JLabel lblWarnings = new JLabel((Icon) null);
		lblWarnings.setToolTipText("");
		lblWarnings.setText("Warnings");
		lblWarnings.setHorizontalAlignment(SwingConstants.LEFT);
		lblWarnings.setBounds(55, 165, 150, 20);
		panel_Monitor1.add(lblWarnings);

		JPanel panel_Monitor2 = new JPanel();
		panel_Monitor2.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"Monitor", TitledBorder.LEADING, TitledBorder.TOP, null,
						SystemColor.desktop));
		panel_Monitor2.setBounds(247, 15, 237, 300);
		panel_Status.add(panel_Monitor2);
		panel_Monitor2.setLayout(null);

		label_LaserReady = new JLabel(icon_red2);
		label_LaserReady.setBounds(15, 15, 20, 20);
		panel_Monitor2.add(label_LaserReady);

		label_ESA = new JLabel(icon_red2);
		label_ESA.setBounds(15, 40, 20, 20);
		panel_Monitor2.add(label_ESA);

		label_GESA = new JLabel(icon_red2);
		label_GESA.setBounds(15, 65, 20, 20);
		panel_Monitor2.add(label_GESA);

		label_PRRH = new JLabel(icon_red2);
		label_PRRH.setBounds(15, 90, 20, 20);
		panel_Monitor2.add(label_PRRH);

		label_PRRL = new JLabel(icon_red2);
		label_PRRL.setBounds(15, 115, 20, 20);
		panel_Monitor2.add(label_PRRL);

		label_MONTL = new JLabel(icon_red2);
		label_MONTL.setBounds(15, 140, 20, 20);
		panel_Monitor2.add(label_MONTL);

		label_MOFTL = new JLabel(icon_red2);
		label_MOFTL.setBounds(15, 165, 20, 20);
		panel_Monitor2.add(label_MOFTL);

		label_Emission = new JLabel(icon_red2);
		label_Emission.setBounds(15, 190, 20, 20);
		panel_Monitor2.add(label_Emission);

		label_24VS = new JLabel(icon_red2);
		label_24VS.setBounds(15, 215, 20, 20);
		panel_Monitor2.add(label_24VS);

		label_24VHS = new JLabel(icon_red2);
		label_24VHS.setBounds(15, 240, 20, 20);
		panel_Monitor2.add(label_24VHS);

		label_5VHS = new JLabel((icon_red2));
		label_5VHS.setBounds(15, 265, 20, 20);
		panel_Monitor2.add(label_5VHS);

		JLabel lblLaserIsReady = new JLabel((Icon) null);
		lblLaserIsReady.setText("Laser is ready for emission");
		lblLaserIsReady.setHorizontalAlignment(SwingConstants.LEFT);
		lblLaserIsReady.setBounds(52, 15, 168, 20);
		panel_Monitor2.add(lblLaserIsReady);

		JLabel lblEnergencyStopActivated = new JLabel((Icon) null);
		lblEnergencyStopActivated.setText("Energency Stop Activated");
		lblEnergencyStopActivated.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnergencyStopActivated.setBounds(52, 40, 168, 20);
		panel_Monitor2.add(lblEnergencyStopActivated);

		JLabel lblGlEmissionStop = new JLabel((Icon) null);
		lblGlEmissionStop.setToolTipText("GL Emission Stop Activated");
		lblGlEmissionStop.setText("GL Emission Stop Activated");
		lblGlEmissionStop.setHorizontalAlignment(SwingConstants.LEFT);
		lblGlEmissionStop.setBounds(52, 65, 168, 20);
		panel_Monitor2.add(lblGlEmissionStop);

		JLabel lblPrrHigh = new JLabel((Icon) null);
		lblPrrHigh.setToolTipText("");
		lblPrrHigh.setText("PRR High");
		lblPrrHigh.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrrHigh.setBounds(52, 90, 168, 20);
		panel_Monitor2.add(lblPrrHigh);

		JLabel lblPrrLow = new JLabel((Icon) null);
		lblPrrLow.setToolTipText("");
		lblPrrLow.setText("PRR Low");
		lblPrrLow.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrrLow.setBounds(52, 115, 168, 20);
		panel_Monitor2.add(lblPrrLow);

		JLabel lblModulationOnTime = new JLabel((Icon) null);
		lblModulationOnTime.setToolTipText("");
		lblModulationOnTime.setText("Modulation ON Time LOW");
		lblModulationOnTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblModulationOnTime.setBounds(52, 140, 168, 20);
		panel_Monitor2.add(lblModulationOnTime);

		JLabel lblModulationOffTime = new JLabel((Icon) null);
		lblModulationOffTime.setToolTipText("");
		lblModulationOffTime.setText("Modulation OFF Time LOW");
		lblModulationOffTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblModulationOffTime.setBounds(52, 165, 168, 20);
		panel_Monitor2.add(lblModulationOffTime);

		JLabel lblEmission = new JLabel((Icon) null);
		lblEmission.setToolTipText("");
		lblEmission.setText("Emission");
		lblEmission.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmission.setBounds(52, 190, 168, 20);
		panel_Monitor2.add(lblEmission);

		JLabel lblvSupply = new JLabel((Icon) null);
		lblvSupply.setToolTipText("");
		lblvSupply.setText("24V Supply");
		lblvSupply.setHorizontalAlignment(SwingConstants.LEFT);
		lblvSupply.setBounds(52, 215, 168, 20);
		panel_Monitor2.add(lblvSupply);

		JLabel lblvHousekeepingSupply = new JLabel((Icon) null);
		lblvHousekeepingSupply.setToolTipText("");
		lblvHousekeepingSupply.setText("24V Housekeeping Supply");
		lblvHousekeepingSupply.setHorizontalAlignment(SwingConstants.LEFT);
		lblvHousekeepingSupply.setBounds(52, 240, 168, 20);
		panel_Monitor2.add(lblvHousekeepingSupply);

		JLabel lblvHousekeepingSupply_1 = new JLabel((Icon) null);
		lblvHousekeepingSupply_1.setToolTipText("");
		lblvHousekeepingSupply_1.setText("5V Housekeeping Supply");
		lblvHousekeepingSupply_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblvHousekeepingSupply_1.setBounds(52, 265, 168, 20);
		panel_Monitor2.add(lblvHousekeepingSupply_1);
	}

	/**
	 * 处理页面右下显示区域
	 */
	private void handleInfos() {
		JPanel panel_Monitor3 = new JPanel();
		panel_Monitor3.setBackground(UIManager.getColor("Panel.background"));
		panel_Monitor3.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"Monitor", TitledBorder.LEADING, TitledBorder.TOP, null,
						SystemColor.desktop));
		panel_Monitor3.setBounds(502, 333, 248, 180);
		panel.add(panel_Monitor3);
		panel_Monitor3.setLayout(new BorderLayout(0, 0));

		table_Monitor = new JTable();
		table_Monitor
				.setModel(
						new DefaultTableModel(
								new Object[][] {
										{ "Module Tempelete", "19.4",
												"\u2103" },
										{ "Remote Head Temp.", "-", "\u2103" },
										{ "Main Supply Voltage ", "23.7", "V" },
										{ "Housekeeping Voltage ", "23.5",
												"V" },
										{ "Back Refl. Counter ", "0", "" },
										{ "Current Session BR ", "0", null }, },
								new String[] { "", "", "" }));
		table_Monitor.getColumnModel().getColumn(0).setPreferredWidth(159);
		table_Monitor.getColumnModel().getColumn(2).setPreferredWidth(45);
		table_Monitor.setShowGrid(false);
		table_Monitor.setEnabled(false);
		table_Monitor.setBackground(UIManager.getColor("Panel.background"));
		panel_Monitor3.add(table_Monitor);

		JPanel panel_info = new JPanel();
		panel_info
				.setBorder(new TitledBorder(null, "Info", TitledBorder.LEADING,
						TitledBorder.TOP, null, SystemColor.desktop));
		panel_info.setBounds(760, 333, 248, 180);
		panel.add(panel_info);
		panel_info.setLayout(new BorderLayout(0, 0));

		table_Info = new JTable();
		table_Info.setEnabled(false);
		table_Info.setShowGrid(false);
		table_Info.setModel(new DefaultTableModel(
				new Object[][] { { "Model", "XXXX" },
						{ "Manufacturer", "XXXX" },
						{ "Serial Number ", "XXXX" }, { "Firmware", "XXXX" }, },
				new String[] { "", "" }));
		table_Info.getColumnModel().getColumn(0).setPreferredWidth(141);
		table_Info.setBackground(UIManager.getColor("Panel.background"));
		panel_info.add(table_Info);

		JPanel panel_OParam = new JPanel();
		panel_OParam.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"Operating Parameters", TitledBorder.LEADING,
						TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_OParam.setBounds(504, 524, 246, 191);
		panel.add(panel_OParam);
		panel_OParam.setLayout(new BorderLayout(0, 0));

		table_OperParam = new JTable();
		table_OperParam.setBackground(UIManager.getColor("Panel.background"));
		table_OperParam.setShowGrid(false);
		table_OperParam.setEnabled(false);
		table_OperParam
				.setModel(
						new DefaultTableModel(
								new Object[][] { { "Average Power", "0", "W" },
										{ "Max Average Power", "1.6", "W" },
										{ "Pulse Duration", "-", "ns" },
										{ "Pulse Energy", "0", "mJ" },
										{ "Peak Power", "-", "kW" },
										{ "Set Power", "0", "%" },
										{ "Pulse Repetition Rate", "1.5",
												"kHz" }, },
								new String[] { "", "", "" }));
		table_OperParam.getColumnModel().getColumn(0).setResizable(false);
		table_OperParam.getColumnModel().getColumn(0).setPreferredWidth(136);
		table_OperParam.getColumnModel().getColumn(1).setPreferredWidth(44);
		table_OperParam.getColumnModel().getColumn(2).setResizable(false);
		table_OperParam.getColumnModel().getColumn(2).setPreferredWidth(46);
		panel_OParam.add(table_OperParam, BorderLayout.CENTER);

		JPanel panel_NParam = new JPanel();
		panel_NParam.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"Nominal Parameters", TitledBorder.LEADING,
						TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_NParam.setBounds(760, 524, 248, 191);
		panel.add(panel_NParam);

		tableNomParam = new JTable();
		tableNomParam.setBackground(UIManager.getColor("Panel.background"));
		tableNomParam.setModel(new DefaultTableModel(
				new Object[][] { { "Average Power", "20.0", "W" },
						{ "Pulse Duration", "80", "ns" },
						{ "Pulse Energy", "1.00", "mJ" },
						{ "Peak Power", "12.5", "kW" },
						{ "Minimun PRR", "19.9", "kHz" },
						{ "Maxmun PRR", "1000", "kHz" }, },
				new String[] { "", "", "" }));
		tableNomParam.getColumnModel().getColumn(0).setResizable(false);
		tableNomParam.getColumnModel().getColumn(0).setPreferredWidth(121);
		tableNomParam.getColumnModel().getColumn(1).setResizable(false);
		panel_NParam.setLayout(new BorderLayout(0, 0));
		tableNomParam.setShowGrid(false);
		tableNomParam.setEnabled(false);
		panel_NParam.add(tableNomParam);
	}

	/**
	 * 处理gate页面内容
	 */
	private void handleGate() {

	}

	/**
	 * 事件绑定
	 */
	private void bindEvent() {
		this.bindAboutEvent();
		this.bindSliderEvent();
		this.bindConnectEvent();
	}

	/**
	 * 关于
	 */
	private void bindAboutEvent() {
		this.mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MyFrame.this,
						"武汉安扬激光技术有限责任公司\r\n");
			}
		});
	}

	/**
	 * 滑块滑动事件
	 */
	private void bindSliderEvent() {
		// 获取具体刻度值
		if (this.slider != null) {
			this.slider.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					JSlider source = (JSlider) e.getSource();
					if (source.getValueIsAdjusting() != true) {
						int value = slider.getValue();
						textField_simmer.setText(String.valueOf(value + " %"));
					}
				}
			});
		}
	}

	/**
	 * 连接事件
	 */
	private void bindConnectEvent() {
		// 连接事件
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String connect_text = btnConnect.getText();
				// 选择框对象，连接和关闭都需要
				int count = panel_Connect.getComponentCount();
				// 端口号
				String name = "";
				JComboBox<String> comboBox = null;
				for (int i = 0; i < count; i++) {
					Component comp = panel_Connect.getComponent(i);
					if (comp instanceof JComboBox) {
						comboBox = (JComboBox<String>) comp;
						name = comboBox.getSelectedItem().toString();
					}
				}
				if ("Connect".equalsIgnoreCase(connect_text)) {
					// 非空判断
					if (StringUtils.isEmpty(name)) {
						return;
					}
					// 连接判断,此方法用来是否可联通，不保持回话
					if (WinEnvUtils.getAvailableSerialPorts(name)) {
						// 初始化连接对象
						try {
							SerialPortFactory.getSerialPort(name);
						} catch (Exception ex) {
							logger.error("打开连接时发生异常", ex);
						}
						// 优化点，连接后，选择框不可选择
						comboBox.setEnabled(false);
						// 界面重绘
						btnConnect.setText("Disconnect");
						panel_Connect.remove(lab_connect);
						lab_connect = new JLabel(icon_connect);
						lab_connect.setBounds(29, 22, 30, 30);
						panel_Connect.add(lab_connect);
						// 局部重绘
						lab_connect.repaint();
						// 进入主页面
						handleDB25();
						// 界面重绘
						panel.repaint();
						// 处理每隔500毫秒刷新状态
						dealConnect();
					}
				} else {
					// 断开连接操作
					try {
						SerialPortFactory.getSerialPort(null).close();
					} catch (Exception ex) {
						logger.error("关闭连接时发生异常", ex);
					}
					// 界面重绘
					comboBox.setEnabled(true);
					btnConnect.setText("Connect");
					panel_Connect.remove(lab_connect);
					lab_connect = new JLabel(icon_disconnect);
					lab_connect.setBounds(29, 22, 30, 30);
					panel_Connect.add(lab_connect);
					lab_connect.repaint();
					panel.repaint();
				}
			}
		});
	}

	/**
	 * 处理连接内容，每500ms进行一次连接通信
	 */
	private void dealConnect() {
		// TODO
	}

}
