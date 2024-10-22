package com.StudentData.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentData.Entity.StudentModel;
import com.StudentData.Service.StudentINF;

@RestController
@RequestMapping("/stu")
public class StudentController {

	@Autowired
	StudentINF service;

	//
	@PostMapping("/save")
	public String Studentsave(@RequestBody StudentModel model) {
		return service.Studentsave(model);
	}

	@GetMapping("/getStu")
	public ResponseEntity<List<StudentModel>> getAllStudent() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllStudents());
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<List<StudentModel>> deleteStu(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.deleteStu(id));
	}

	@PutMapping("/update")
	public ResponseEntity<StudentModel> updateStu(@RequestBody StudentModel model) {
		return ResponseEntity.status(HttpStatus.OK).body(service.updateStu(model));
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<List<StudentModel>> getStudentId(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getStudentId(id));
	}
}
