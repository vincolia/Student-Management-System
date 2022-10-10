package com.web.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.sms.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
