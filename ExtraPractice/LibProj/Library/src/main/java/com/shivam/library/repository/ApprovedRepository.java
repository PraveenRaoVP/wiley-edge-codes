package com.shivam.library.repository;

import com.shivam.library.model.Approved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovedRepository extends JpaRepository<Approved,Long> {
}
