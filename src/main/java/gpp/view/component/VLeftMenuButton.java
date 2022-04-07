package gpp.view.component;

import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.border.AbstractBorder;

public class VLeftMenuButton {
	
	// URL: https://stackoverflow.com/questions/6008058/customizing-jtextfield
	@SuppressWarnings("serial")
	class CustomeBorder extends AbstractBorder {
		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			// TODO Auto-generated method stubs
			super.paintBorder(c, g, x, y, width, height);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setStroke(new BasicStroke(12));
			g2d.setColor(VColor.getGRAY_MENU());
			g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
		}
	}

}
