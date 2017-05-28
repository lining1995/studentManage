package com.biz.std.repository;

import com.biz.std.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/5/21.
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    Subject findById(int id);
    @Transactional
    void deleteById(int id);
}
