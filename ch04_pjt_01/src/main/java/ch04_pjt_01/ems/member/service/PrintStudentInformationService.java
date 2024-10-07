package ch04_pjt_01.ems.member.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ch04_pjt_01.ems.member.Student;

public class PrintStudentInformationService {

	StudentAllSelectService allSelectService;

	public PrintStudentInformationService(StudentAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}

	public void printStudentsInfo() {
			// 키  , 밸류
		Map<String, Student> allStudent = allSelectService.allSelect();
			// 중복x, 순서x 			키(학번)를 관리하는 세트
		Set<String> keys = allStudent.keySet();
		// 컬렉션에 저장된 요소 순회
		Iterator<String> iterator = keys.iterator();
		System.out.println("\n----------- 학생 리스트 -----------");
		while (iterator.hasNext()) {
			String key = iterator.next();
			Student student = allStudent.get(key);
			System.out.print("학번:" + student.getsNum() + "\t");
			System.out.print("|ID:" + student.getsId() + "\t");
			System.out.print("|비밀번호:" + student.getsPw() + "\t");
			System.out.print("|이름:" + student.getsName() + "\t");
			System.out.print("|나이:" + student.getsAge() + "\t");
			System.out.print("|성별:" + student.getsGender() + "\t");
			System.out.println("|전공:" + student.getsMajor() + "\t");

		}
		System.out.println("--------------------------------");
	}

}