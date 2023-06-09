package com.shivam.library.service;

import com.shivam.library.exception.ResourceNotFoundException;
import com.shivam.library.model.Book;
import com.shivam.library.model.Management;
import com.shivam.library.repository.ManagementRepository;
import org.springframework.stereotype.Service;

@Service
public class ManagementService {

    private final ManagementRepository managementRepository;

    public ManagementService(ManagementRepository managementRepository) {
        this.managementRepository = managementRepository;
    }

    public void approvePublication(Long id) {
        Management management = managementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Management", "id", id));

        Book book = management.getBook();
        // Do the logic to approve the publication of the book here
    }
}
