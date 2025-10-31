package com.Test.repository;



import java.util.Optional;





public interface MemberRepository extends JpaRepository<Member, Long>{
   //지원 메서드-save(), findAll(), findById(), deleteById()
	

	

	public void save(java.lang.reflect.Member member);
}
