package com.StudentData.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentData.Entity.StudentModel;

@Repository
public interface Studentrepo extends JpaRepository<StudentModel, Integer>{

	public List<StudentModel> getStudentById(int id);
}
