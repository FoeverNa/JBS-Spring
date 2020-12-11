package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rubypaper.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
	
	@Query("SELECT b FROM Board b ORDER BY b.seq DESC")
	public List<Board> findAllDESC();

}
