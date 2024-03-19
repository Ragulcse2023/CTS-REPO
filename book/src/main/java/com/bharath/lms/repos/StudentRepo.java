package com.bharath.lms.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.lms.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
