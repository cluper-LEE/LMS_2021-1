package dataAccessObject;

import model.MMember;
import valueObject.OMember;

public class DMember {

	public DMember() {
	}

	public void save(OMember oMember) {
		MMember mMember = new MMember();
		// oMember에서 mMember로 데이터를 이동
		// mMember를 통해서 파일에 저장
		
	}

	public OMember read() {
		// mMember를 통해 Data read
		// oMember 생성
		// mMember에서 oMember로 데이터 이동
		return null;
	}

}
