package com.shivam.library.service;

import com.shivam.library.model.Approved;
import com.shivam.library.repository.ApprovedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovedService {
    @Autowired
    private final ApprovedRepository approved;

    public ApprovedService(ApprovedRepository approved) {
        this.approved = approved;
    }


    public Approved addApproval(Approved approve) {
         return approved.save(approve);
    }

    public List<Approved> getAllApproved() {
        return approved.findAll();
    }
}
