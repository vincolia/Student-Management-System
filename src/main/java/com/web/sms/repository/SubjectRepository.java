package com.web.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.sms.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer>{

}
