package windowsView;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Config.FVLogin;
import global.Global;

public class VFormPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int inputRowCount;
	private int buttonRowCount;

	private JPanel inputPanel;
	private JLabel validText;
	private JPanel buttonPanel;

	public VFormPanel() {

		// 최상위 패널
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// 최상위 > 입력 패널 (아이디, 패스워드의 라벨, 텍스트 필드)
		inputPanel = new JPanel(new GridBagLayout());
		this.add(inputPanel);

		// 최상위 > 메시지
		// 아이디가 올바른 형식인지 알려주는 메시지
		validText = new JLabel(" ");
		validText.setForeground(FVLogin.validTextColor);
		this.add(validText);

		// 최상위 > 버튼 패널
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		this.add(buttonPanel);
	}
	
	public void addInputRow(JLabel label, JTextField textField) {
		GridBagConstraints labelGbc = Global.getGbc(0, inputRowCount);
		inputPanel.add(label, labelGbc);
		
		GridBagConstraints textGbc = Global.getGbc(1, inputRowCount, 4, 1);
		inputPanel.add(textField, textGbc);
		
		inputRowCount++;
	}
	
	public void addButton(JButton button) {
		buttonPanel.add(button, Global.getGbc(0, buttonRowCount++, 5, 1));
	}
	
	public JLabel getValidText() {
		return validText;
	}

}
