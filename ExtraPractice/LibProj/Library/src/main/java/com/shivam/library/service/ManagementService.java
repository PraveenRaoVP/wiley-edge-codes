package com.shivam.library.service;

import com.shivam.library.exception.ResourceNotFoundException;
import com.shivam.library.model.Author;
import com.shivam.library.model.Book;
import com.shivam.library.model.Management;
import com.shivam.library.repository.ManagementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementService {

    private final ManagementRepository managementRepository;

    public ManagementService(ManagementRepository managementRepository) {
        this.managementRepository = managementRepository;
    }

    public Management addManager(Management management) {
        return managementRepository.save(management);
    }

    public List<Management> getAllManagers() {
        return managementRepository.findAll();
    }


}
