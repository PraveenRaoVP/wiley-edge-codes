package com.example.appointmentauthor.repository;

import com.example.appointmentauthor.model.Management;
import com.example.appointmentauthor.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagementRepository extends JpaRepository<Management, Long> {
    @Query("SELECT m FROM Management m")
    Management getManagement();
}
