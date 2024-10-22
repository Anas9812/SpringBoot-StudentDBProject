package com.StudentData.Service;

import java.util.List;

import com.StudentData.Entity.StudentModel;


public interface StudentINF {

	String Studentsave(StudentModel model);

	List<StudentModel> getAllStudents();

	List<StudentModel> deleteStu(int id);

	StudentModel updateStu(StudentModel model);

	List<StudentModel> getStudentId(int id);




}
