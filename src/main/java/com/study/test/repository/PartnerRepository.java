package com.study.test.repository;

import java.util.List;

import com.study.test.model.entity.Category;
import com.study.test.model.entity.Partner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    List<Partner> findByCategory(Category category);

}
