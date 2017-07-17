package org.demo.querydsl.controllers;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.demo.querydsl.entities.BranchLocation;
import org.demo.querydsl.entities.QBranchLocation;
import org.demo.querydsl.repositories.BranchLocationRepository;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/branch")
public class BranchLocationController {

    private final BranchLocationRepository repository;

    @PostMapping(path = "/find")
    public Iterable<BranchLocation> find(@RequestBody BranchLocation branchLocation) {
        System.out.println(branchLocation.toString());
        QBranchLocation qb = QBranchLocation.branchLocation;
        BooleanBuilder builder = new BooleanBuilder();
        if (branchLocation.getState() != null) {
            builder.and(qb.state.equalsIgnoreCase(branchLocation.getState()));
        }
        if (branchLocation.getCity() != null) {
            builder.and(qb.city.equalsIgnoreCase(branchLocation.getCity()));
        }

        return repository.findAll(builder);
    }


    @GetMapping(value = "/search")
    public Iterable<BranchLocation> search(@QuerydslPredicate(root = BranchLocation.class) Predicate predicate) {
        System.out.println(predicate.toString());
        return repository.findAll(predicate);
    }

}
