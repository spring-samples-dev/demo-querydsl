package org.demo.querydsl.repositories;

import org.demo.querydsl.entities.BranchLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface MyUserRepository extends JpaRepository<BranchLocation, Long>,
        QueryDslPredicateExecutor<BranchLocation>{
//        ,
//        QuerydslBinderCustomizer<QBranchLocation> {

//    @Override
//    default void customize(QuerydslBindings bindings, QBranchLocation root) {
//        bindings.bind(String.class).
//                first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
//        bindings.excluding(root.state);
//    }

}

