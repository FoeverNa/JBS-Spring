package com.rubypaepr.persistence;

import org.springframework.data.repository.CrudRepository;

import com.rubypaepr.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {
	
	
}
