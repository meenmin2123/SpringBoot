package com.ss.jpa.repository;

import com.ss.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // findById() 메서드와 유사하게 id 대신 다른 필드의 내용을 이용해서 검색하는 메서드를 만들 수 있음.
    public List<Member> findAll();

    //이름으로 검색
    //public Member findByName(String name);

    // 이름으로 검색했을 때 중복되는 데이터를
    // 모두 가져올 때는 메서드를 직접 작성
    public List<Member> findByName(String name);

    //이메일을 검색하는 메서드를 생성
    // 접두어만 다르게 사용해서 같은기능을 실행하는
    // 메서드를 만들 수있다.
    public List<Member> findByEmail(String string);
    public List<Member> getByEmail(String email);
    public Member readByEmail(String email);
    public Member queryByEmail(String email);
    public Member searchByEmail(String email);
    public Member streamByEmail(String email);
    public Member findMemberByEmail(String email);
    // findBy필드명()
    // 단순히 데이터를 조회한다.
    // 가장 일반적으로 많이 사용하는 메서드
    // 네이밍기법이다!

    // getBy필드명()
    // 무조건 데이터가 있다는 가정하에 찾는다.
    // 만약 데이터가 없으면 에러를 발생시킨다.

    // First,Top 사용되는 메서드를 만들어서
    // limit가 사용되는 쿼리를 만들수있다.

    // First를 사용하면 검색 결과의 앞 부분부터
    // First뒤에 지정한 숫자 만큼데이터를
    // 얻어온다.
    public List<Member> findFirst1ByName(String name);
    public List<Member> findList2ByName(String name);

    // and or 조건

    public List<Member> findByEmailAndName (String email,String name);
    public List<Member> findByNameAndEmail (String email,String name);

    public List<Member> findByEmailOrName (String email,String name);
    public List<Member> findByNameOrEmail (String email,String name);

    // null 값 조회
    // IsNotEmpty
    // IsEmpty

    // null이 아닌가 비교
    public List<Member> findByIdNotNull();

    // null 이니? 비교
    public List<Member> findByIdIsNull();

    // find...By필드명
    // ... 키워드 spring jpa사이트 참조!

    // like
    // 시작하는
    public List<Member> findByNameStartingWith(String name);

    // 끝나는
    public List<Member> findByNameEndingWith(String name);

    // 포함하는
    public List<Member> findByNameContains(String name);


    // 정렬
    // 이름을 기준으로 오름차순
//	public List<Member> findAllOrderByNameAsc();
//
//	// 이름을 기준으로 내림차순
//	public List<Member> findAllOrderByNameDesc();
//
    // 이름이 같으면 이메일의 내림차순
    public List<Member> findFirst3ByNameOrderByEmailDesc(String name);

    // 네이티브 쿼리
    // @Query(value="select * from member limit 1;")
//	public Map<String, Object> findRawRecord();
//
    // 이상,이하 조건
    // Between

    // 특정 날짜 이후에 가입,작성,수정 내용을
    // 검색할 때 (크거나 같다)
    public List<Member> findByCreateAtGreaterThanEqual (LocalDateTime date);

    // 특정 날짜 이전에 가입,작성,수정 내용을
    // 검색할 때 ( 작거나 같다)
    public List<Member> findByCreateAtLessThanEqual (LocalDateTime date);

    // 특정 날짜를 기준으로 범위값을 반환하는메서드
    // 특정 기간에 작성된 글,가입한 멤버,등등

    public List<Member> findByCreateAtBetween (LocalDateTime date1, LocalDateTime date2);
    public List<Member> findByCreateAtGreaterThanEqualAndCreateAtLessThanEqual(LocalDateTime date1, LocalDateTime date2);

    // 컬럼명 순서에 따라서 매개변수 순서를 정해서 작성하면 된다.

    // 1. 특정날짜 이후에 가입한 특정 이름을 가진 회원을 조회
    //    2023년 1월 1일 이후에 가입한 회원중에 아이유가 조회
    public List<Member> findByCreateAtAfterAndName (LocalDateTime date1, LocalDateTime date2, String name);

    // 2. 특정 아이디를 기준으로 ID범위가 3부터 7까지 중에 이메일문자 중에 i가 포함된 내용을 조회할 수있도록 메서드!
    // 매개변수로 특정범위 id시작,id끝,문자
    public List<Member> findByIdBetweenAndEmailContaining (Long idStart, Long idEnd, String email);


}
