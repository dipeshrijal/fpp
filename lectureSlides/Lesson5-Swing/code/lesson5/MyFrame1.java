package lesson5;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * This version of MyFrame illustrates some initialization, including
 * centering on the desktop and configuring window closing. It does
 * not add any components to the content pane.
 *
 */
public class MyFrame1 extends JFrame {

	public MyFrame1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hello World");
		setSize(320, 240); 
		centerFrameOnDesktop(this);
		setResizable(false);
	}

	public static void centerFrameOnDesktop(Component f) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height;
		int width = toolkit.getScreenSize().width;
		int frameHeight = f.getSize().height;
		int frameWidth = f.getSize().width;
		f.setLocation(((width - frameWidth) / 2), (height - frameHeight) / 3);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				MyFrame1 mf = new MyFrame1();				
				mf.setVisible(true);
			}
		});
	}

	private static final long serialVersionUID = 3618976789175941431L;
}
