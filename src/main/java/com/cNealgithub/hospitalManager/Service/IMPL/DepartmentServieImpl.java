package com.cNealgithub.hospitalManager.Service.IMPL;

import com.cNealgithub.hospitalManager.Entity.Department;
import com.cNealgithub.hospitalManager.Repository.DepartmentRepository;
import com.cNealgithub.hospitalManager.Service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServieImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department addDeptInfo(Department dept) {
        departmentRepository.save(dept);
        return dept;
    }
}
