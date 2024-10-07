package ch04_pjt_01.ems.member.service;

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.dao.StudentDao;

public class StudentModifyService {

	private StudentDao studentDao; // 객체 선언

	public StudentModifyService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void modify(Student student) {
		if (verify(student.getsNum())) {
			studentDao.update(student);
		} else {
			System.out.println("Student information is available.");
		}
	}

							//   학번
	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student != null ? true : false;
	}

}