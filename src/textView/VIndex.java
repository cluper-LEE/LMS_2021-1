package textView;

import java.util.Scanner;
import java.util.Vector;

import control.CIndex;
import valueObject.OIndex;

public class VIndex {
	protected Scanner scanner;
	protected CIndex cIndex;
	
	public VIndex() {}
	public VIndex(Scanner scanner) {
		this.cIndex = new CIndex();
		this.scanner = scanner;
	}

	public OIndex show(String fileName, String message) {
		System.out.println(message + " 선택 하세요.");
		Vector<OIndex> indices = cIndex.getAll(fileName);
		for(OIndex index : indices) {
			System.out.println(index.toString());
		}
		String id = this.scanner.next();
		for(OIndex index : indices) {
			if(index.getId().equals(id)) {
				return index;
			}
		}
		return null;
	}

}
