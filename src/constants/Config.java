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
	
	public static class FPath{
		public static final String lecturesPath = "lectures/";
		public static final String basketPath = "baskets/";
		public static final String enrollmentPath = "enrollment_lists/";
	}
	
	public static class FVLectureSearch{
		public static final Dimension tableSize = new Dimension(200, 100);
		public static final Dimension basketSize = new Dimension(440, 400);
		public static final String[] campusColName = {"ķ�۽�"};
		public static final String[] collegeColName = {"����"};
		public static final String[] departmentColName = {"�а�"};
		public static final String[] lectureColName = {"���¹�ȣ", "�����", "��米��", "����", "�����ð�"};
	}
	
	public static class FVLogin{
		public static final String frameName = "�α���";
		
		public static final String idLabelText = "���̵�(�й�)";
		public static final String passwordLabelText = "��й�ȣ";
		
		public static final String loginButtonText = "�α���";
		public static final String registrationButtonText = "ȸ������";
		
		
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
		

		public static final String registrationButtonText = "ȸ�������ϱ�";
		
		public static final String notMatchMSG = "��й�ȣ�� ��ġ���� �ʽ��ϴ�";
		public static final String blankMSG = "�Է��� �ʿ��մϴ�"; 
		public static final String alreadyExits = "�̹� ��ϵ� ȸ���Դϴ�";
	}
	
	public static class FVForm{
		public static final Color validTextColor = Color.red;
		public static final int textFieldLength = 20;
		public static final int textFieldWidht = 4;
		public static final int textFieldHeight = 1;
		public static final int labelGridX = 0;
		public static final int textFieldGridX = 1;
		public static final int buttonWidht = 5;
		public static final int buttonHeight = 1;
		public static final int buttonGridX = 0;
	}
	
	public static class FVLectureControl{
		public static final String addToBasketButtonText = "�̸����";
		public static final String addToEnrollmentListText = "��û";
		public static final String deleteFromBasketButtonText = "����";
		public static final String deleteFromEnrollmentListText = "���";
		
		public static final String existInBasketMessage = "�̹� ����ִ� �����Դϴ�.";
		public static final String existInEnrollmentListMessage = "�̹� ��û�� �����Դϴ�.";
		public static final String failToSaveMessage = "�����Ͽ����ϴ�.";
		public static final String timeOverlapMessage = "������ ����� ���¿� �ð��� ��Ĩ�ϴ�.";
	}
	
	public static enum FCLectureControl{
		ALREADY_EXIST_LECTURE,
		TIME_OVERlAP,
		FAIL_TO_SAVE_IN_FILE,
		SUCCESS, EXIST_IN_BASKET, EXIST_IN_ENROLLMENT_LIST
	}
}
