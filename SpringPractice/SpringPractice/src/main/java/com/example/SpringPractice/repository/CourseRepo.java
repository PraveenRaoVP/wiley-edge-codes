package com.example.SpringPractice.repository;

import com.example.SpringPractice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
   // method for finding fee less than price
   @Query("SELECT c FROM Course c WHERE c.fee < ?1")
   List<Course> findByFeeLessThan(double price);

}
