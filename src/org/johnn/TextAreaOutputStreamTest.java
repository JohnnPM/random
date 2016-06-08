package org.johnn;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintStream;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class TextAreaOutputStreamTest extends JPanel {

	private JTextArea textArea = new JTextArea(15, 30);
	private TextAreaOutputStream taOutputStream = new TextAreaOutputStream(textArea, "Test");

	public TextAreaOutputStreamTest() {
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		System.setOut(new PrintStream(taOutputStream));

		int timerDelay = 1000;
		
	}

	static void createAndShowGui() {
		JFrame frame = new JFrame("Random Username Gen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setSize(400, 720);
		frame.setMinimumSize(new Dimension(400, 250));
		frame.setMaximumSize(new Dimension(2560, 1440));

		// Window Listeners
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			} // windowClosing
		});
		frame.getContentPane().add(new TextAreaOutputStreamTest());
		JToggleButton toggleButton = new JToggleButton("Toggle Button");
        final JToggleButton toggleButton1 = new JToggleButton("Another Toggle Button");
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
                boolean selected = abstractButton.getModel().isSelected();
                System.out.println("Stopped=" + selected + "\n");
                Username.ayyy = !selected;
                new Thread(
                        new Runnable() {
                          public void run() {
                                if (!selected) Username.runthis();
                          
                          }
                        }
                      ).start();
                toggleButton1.setSelected(selected);
            }
        };
        toggleButton.addActionListener(actionListener);
        frame.add(toggleButton, BorderLayout.SOUTH);
	}

}