package windowsView;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Config.FVForm;
import global.Global;

public class VFormPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int inputRowCount;
	private int buttonRowCount;

	private JPanel inputPanel;
	private JLabel validText;
	private JPanel buttonPanel;

	public VFormPanel() {

		// �ֻ��� �г�
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// �ֻ��� > �Է� �г� (���̵�, �н������� ��, �ؽ�Ʈ �ʵ�)
		inputPanel = new JPanel(new GridBagLayout());
		this.add(inputPanel);

		// �ֻ��� > �޽���
		// ���̵� �ùٸ� �������� �˷��ִ� �޽���
		validText = new JLabel(" ");
		validText.setForeground(FVForm.validTextColor);
		this.add(validText);

		// �ֻ��� > ��ư �г�
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		this.add(buttonPanel);
	}
	
	public void addInputRow(JLabel label, JTextField textField) {
		GridBagConstraints labelGbc = Global.getGbc(FVForm.labelGridX, inputRowCount);
		inputPanel.add(label, labelGbc);
		
		GridBagConstraints textGbc = Global.getGbc(FVForm.textFieldGridX, inputRowCount, FVForm.textFieldWidht, FVForm.textFieldHeight);
		inputPanel.add(textField, textGbc);
		
		inputRowCount++;
	}
	
	public void addButton(JButton button) {
		buttonPanel.add(button, Global.getGbc(FVForm.buttonGridX, buttonRowCount++, FVForm.buttonWidht, FVForm.buttonHeight));
	}
	
	public JLabel getValidText() {
		return validText;
	}

}
