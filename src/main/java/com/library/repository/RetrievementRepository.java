package com.library.repository;

import com.library.entity.Retrievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetrievementRepository extends JpaRepository<Retrievement, Integer> {
}

