package com.StudentData.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.StudentData.Entity.StudentModel;
import com.StudentData.Repo.Studentrepo;

@Service
public class StudentService implements StudentINF {

	@Autowired
	Studentrepo repo;

	// TO SAVE STUDENT
	@Override
	public String Studentsave(StudentModel model) {
		try {
			repo.save(model);
			return "Student Registered Successfully: " + model.getId();
		} catch (Exception e) {
			System.out.println(e);
		}

		return "Registration Failed";
	}

	// TO FIND ALL STUDENT FROM THE DB
	@Override
	public List<StudentModel> getAllStudents() {

		try {
			return repo.findAll();
		} catch (Exception e) {
			System.out.println(e);
		}

		return (List<StudentModel>) ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong");
	}

	// DELETE STUDENT IF IT IS PRESENT IN DATABASE
	@Override
	public List<StudentModel> deleteStu(int id) {

		try {
			Optional<StudentModel> model = repo.findById(id);
			// IF STUDENT PRESENT IN THE DATABASE
			if (model.isPresent()) {
				repo.deleteById(id);
			} else {
				throw new StudentNotFoundException("Student Not Found");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// UPDATE STUDENT DATA
	@Override
	public StudentModel updateStu(StudentModel model) {
		try {
			repo.save(model);
			return repo.findById(model.getId()).get();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<StudentModel> getStudentId(int id) {
		return repo.getStudentById(id);
	}

}
