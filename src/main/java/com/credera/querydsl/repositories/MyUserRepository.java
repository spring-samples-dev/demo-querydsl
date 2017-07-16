package com.credera.querydsl.repositories;

import com.credera.querydsl.entities.BranchLocation;
import com.credera.querydsl.entities.QBranchLocation;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

public interface MyUserRepository extends JpaRepository<BranchLocation, Long>,
        QueryDslPredicateExecutor<BranchLocation>, QuerydslBinderCustomizer<QBranchLocation> {

    @Override
    default void customize(QuerydslBindings bindings, QBranchLocation root) {
        bindings
                .bind(String.class)
                .first((SingleValueBinding<StringPath, String>)
                        StringExpression::containsIgnoreCase);
        bindings.excluding(root.address);
    }
}

