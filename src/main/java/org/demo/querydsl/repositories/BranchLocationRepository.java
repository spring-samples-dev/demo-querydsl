package org.demo.querydsl.repositories;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.demo.querydsl.entities.BranchLocation;
import org.demo.querydsl.entities.QBranchLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

public interface BranchLocationRepository  extends JpaRepository<BranchLocation, Long>,
        QueryDslPredicateExecutor<BranchLocation> ,
        QuerydslBinderCustomizer<QBranchLocation> {


    @Override
    default void customize(QuerydslBindings bindings, QBranchLocation root) {
        bindings.bind(String.class).
                first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }
}
