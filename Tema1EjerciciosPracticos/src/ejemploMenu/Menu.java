package ejemploMenu;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Menu extends JPanel {
	public Menu() {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 440, 22);
		add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem(".");
		menuBar.add(mntmNewMenuItem);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
