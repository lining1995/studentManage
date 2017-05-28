package com.biz.std.repository;

import com.biz.std.model.Student;
import com.google.common.collect.Lists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lining on 2017/5/21.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable);
    Student findById(int id);
    @Transactional
    void deleteById(int id);

}
