package org.demo.querydsl.controllers;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.demo.querydsl.entities.BranchLocation;
import org.demo.querydsl.repositories.BranchLocationRepository;
import org.demo.querydsl.repositories.MyUserRepository;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/branch")
public class BranchLocationController {

    private final MyUserRepository repository;
    private final BranchLocationRepository branchLocationRepository;

    @PostMapping(path = "/find")
    public Iterable<BranchLocation> find(@RequestBody @QuerydslPredicate(root = BranchLocation.class) Predicate predicate){
        System.out.println(predicate.toString());
//        Example<BranchLocation> example = new Example<BranchLocation>();
//        return repository.findAll(example);

        return repository.findAll(predicate);
    }


    @GetMapping(value = "/search")
    @ResponseBody
    public Iterable<BranchLocation> findAllByWebQuerydsl(
            @QuerydslPredicate(root = BranchLocation.class) Predicate predicate) {

        System.out.println(predicate.toString());
        return repository.findAll(predicate);
    }

}
