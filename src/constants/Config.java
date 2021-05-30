package constants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public final class Config {
	public static class FVMainFrame{
		public static final String frameName = "������û";
		public static final Point location = new Point(200, 300);
		public static final Dimension size = new Dimension(400, 600);
		
	}
	
	public static class FVMainPanel{
		public static final Color backgroundColor = Color.white;
	}
	
	public static class FVLectureSearch{
		public static final Dimension tableSize = new Dimension(400, 100);
		public static final String[] campusColName = {"ķ�۽�"};
		public static final String[] collegeColName = {"����"};
		public static final String[] departmentColName = {"�а�"};
		public static final String[] lectureColName = {"���¹�ȣ", "�����", "��米��", "����", "�����ð�"};
	}
	
	public static class FVLogin{
		public static final String frameName = "�α���";
		
		public static final String idLabelText = "���̵�(�й�)";
		public static final String passwordLabelText = "��й�ȣ";
		public static final int textFieldLength = 20;
		
		public static final String loginButtonText = "�α���";
		public static final String registrationButtonText = "ȸ������";
		
		public static final Color validTextColor = Color.red;
		public static final String idValidMSG = "���̵𿡴� ���ڸ� �Է��� �� �ֽ��ϴ�";
		public static final String idBlankMSG = "���̵� �Է��ϼ���";
		public static final String PSWDBlankMSG = "��й�ȣ�� �Է��ϼ���"; 
		public static final String loginFailMSG = "�α��ο� �����Ͽ����ϴ�";
	}
	
	public static class FVRegistration{
		public static final String frameName = "ȸ������";
		public static final String nameLabelText = "�̸�";
		public static final String idLabelText = "�й�";
		public static final String addressLabelText = "�ּ�";
		public static final String departmentLabelText = "�а�(�к�)";
		public static final String passwordLabelText = "��й�ȣ";
		public static final String checkLabelText = "��й�ȣ(Ȯ��)";
		
		public static final int textFieldLength = 20;

		public static final String registrationButtonText = "ȸ�������ϱ�";
		
		public static final Color validTextColor = Color.red;
		
		public static final String notMatchMSG = "��й�ȣ�� ��ġ���� �ʽ��ϴ�";
		public static final String blankMSG = "�Է��� �ʿ��մϴ�"; 
		public static final String alreadyExits = "�̹� ��ϵ� ȸ���Դϴ�";
	}
	
	
}
