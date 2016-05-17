package swingtest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class JWindowSetup extends JWindow implements Runnable {
	Thread splashThread; // 进度条更新线程
	JProgressBar progress; // 进度条

	public JWindowSetup() {
		Container container = getContentPane(); // 得到容器
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); // 设置光标
		String loginfile = "resource//login.jpg"; // 图片的位置
		if (loginfile != null) {
			container.add(new JLabel(new ImageIcon(loginfile)), BorderLayout.CENTER); // 增加图片
		}
		progress = new JProgressBar(1, 100); // 实例化进度条
		progress.setStringPainted(true); // 描绘文字
		progress.setString("加载程序中,请稍候......"); // 设置显示文字
		progress.setBackground(Color.white); // 设置背景色
		container.add(progress, BorderLayout.SOUTH); // 增加进度条到容器上

		Dimension screen = getToolkit().getScreenSize(); // 得到屏幕尺寸
		pack(); // 窗口适应组件尺寸
		setLocation((screen.width - getSize().width) / 2,
				(screen.height - getSize().height) / 2); // 设置窗口位置
	}
	//启动
	public void start() {
		this.toFront(); // 窗口前端显示
		splashThread = new Thread(this); // 实例化线程
		splashThread.start(); // 开始运行线程
	}
	//运行
	public void run() {
		setVisible(true); // 显示窗口
		try {
			for (int i = 0; i < 30; i++) {
				Thread.sleep(100); // 线程休眠
				progress.setValue(progress.getValue() + 3); // 设置进度条值
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		dispose(); // 释放窗口
		showFrame(); // 运行主程序
	}
	//打开主窗体
	static void showFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		JWindowSetup splash = new JWindowSetup();
		splash.start(); // 运行启动界面
	}
}
