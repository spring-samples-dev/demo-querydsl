package org.demo.querydsl.repositories;

import org.demo.querydsl.entities.BranchLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface BranchLocationRepository  extends JpaRepository<BranchLocation, Long>, QueryDslPredicateExecutor<BranchLocation> {
}
