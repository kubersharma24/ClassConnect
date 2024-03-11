package com.example.MasterRoom.Repositories.ClassRepository;

import com.example.MasterRoom.Model.Entitys.ClassRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassRoom , Long> {
    boolean existsByClassCode(String classCode);

    Page<ClassRoom> findByHandlerIdId(long id, PageRequest pageable);
}
