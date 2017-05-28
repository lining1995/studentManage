package com.biz.std.repository;

import com.biz.std.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/5/21.
 */
@Repository
public interface GradeRepository extends JpaRepository<Grade ,Long> {
    Grade findById(int id);
    @Transactional
    int deleteById(int id);
}
