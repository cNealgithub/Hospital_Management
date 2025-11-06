package com.cNealgithub.hospitalManager.Repository;

import com.cNealgithub.hospitalManager.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}