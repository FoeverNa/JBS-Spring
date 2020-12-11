package com.rubypaepr.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.rubypaepr.domain.Board;

public interface DynamicBoardRepository extends CrudRepository<Board, Long>,
											    QuerydslPredicateExecutor<Board> {

}
