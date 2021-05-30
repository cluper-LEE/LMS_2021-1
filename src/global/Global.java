package global;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import constants.Config.FVRegistration;

public final class Global {
	public static GridBagConstraints getGbc(int x, int y) {
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1;
		gbc.weighty = 1;
		return gbc;
	}
	
	public static GridBagConstraints getGbc(int x, int y, int width, int height) {
		GridBagConstraints gbc = getGbc(x, y);
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.fill = GridBagConstraints.BOTH;
		return gbc;
	}
	
	public static boolean validBlank(JTextField textField) {
		if(textField.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, FVRegistration.blankMSG);
			textField.requestFocus();
			textField.selectAll();
			return false;
		}
		return true;
	}
	
	public static boolean validPasswordMatch(JTextField passwordText, JTextField checkText) {
		if(!passwordText.getText().equals(checkText.getText())) {
			JOptionPane.showMessageDialog(null, FVRegistration.notMatchMSG);
			passwordText.requestFocus();
			passwordText.selectAll();
			return false;
		}
		return true;
	}
}
