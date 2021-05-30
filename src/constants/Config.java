package constants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public final class Config {
	public static class FVMainFrame{
		public static final String frameName = "수강신청";
		public static final Point location = new Point(200, 300);
		public static final Dimension size = new Dimension(400, 600);
		
	}
	
	public static class FVMainPanel{
		public static final Color backgroundColor = Color.white;
	}
	
	public static class FVLectureSearch{
		public static final Dimension tableSize = new Dimension(400, 100);
		public static final String[] campusColName = {"캠퍼스"};
		public static final String[] collegeColName = {"대학"};
		public static final String[] departmentColName = {"학과"};
		public static final String[] lectureColName = {"강좌번호", "과목명", "담당교수", "학점", "수업시간"};
	}
	
	public static class FVLogin{
		public static final String frameName = "로그인";
		
		public static final String idLabelText = "아이디(학번)";
		public static final String passwordLabelText = "비밀번호";
		public static final int textFieldLength = 20;
		
		public static final String loginButtonText = "로그인";
		public static final String registrationButtonText = "회원가입";
		
		public static final Color validTextColor = Color.red;
		public static final String idValidMSG = "아이디에는 숫자만 입력할 수 있습니다";
		public static final String idBlankMSG = "아이디를 입력하세요";
		public static final String PSWDBlankMSG = "비밀번호를 입력하세요"; 
		public static final String loginFailMSG = "로그인에 실패하였습니다";
	}
	
	public static class FVRegistration{
		public static final String frameName = "회원가입";
		public static final String nameLabelText = "이름";
		public static final String idLabelText = "학번";
		public static final String addressLabelText = "주소";
		public static final String departmentLabelText = "학과(학부)";
		public static final String passwordLabelText = "비밀번호";
		public static final String checkLabelText = "비밀번호(확인)";
		
		public static final int textFieldLength = 20;

		public static final String registrationButtonText = "회원가입하기";
		
		public static final Color validTextColor = Color.red;
		
		public static final String notMatchMSG = "비밀번호가 일치하지 않습니다";
		public static final String blankMSG = "입력이 필요합니다"; 
		public static final String alreadyExits = "이미 등록된 회원입니다";
	}
	
	
}
