package com.example.authorstudent.service;

import com.example.authorstudent.model.Management;
import com.example.authorstudent.repository.ManagementRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ManagementService {
    private final ManagementRepository managementRepository;

    public ManagementService(ManagementRepository managementRepository) {
        this.managementRepository = managementRepository;
    }

    public List<Management> getAllManagement() {
        return managementRepository.findAll();
    }

    public Management getManagementById(Long id) {
        return managementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Management not found with id: " + id));
    }

    public Management createManagement(Management management) {
        return managementRepository.save(management);
    }

    public void deleteManagement(Long id) {
        managementRepository.deleteById(id);
    }

    // Other service methods, if needed
}

