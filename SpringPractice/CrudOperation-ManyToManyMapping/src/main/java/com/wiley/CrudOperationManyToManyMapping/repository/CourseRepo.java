package com.wiley.CrudOperationManyToManyMapping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiley.CrudOperationManyToManyMapping.model.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {
	List<Course> findByFeeLessThan(double fee);
}
