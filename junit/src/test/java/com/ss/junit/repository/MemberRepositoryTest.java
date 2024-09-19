package com.ss.junit.repository;

import com.ss.junit.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

// spring boot에서
@Slf4j
@SpringBootTest
public class MemberRepositoryTest {

    // 실제 MemberRepository에 있는 객체를 똑같이 생성함.
    @Autowired
    private MemberRepository repository;

    // 실제 서버를 실행하는게 아니고
    // Junit의 테스트 메스트가 여러 개 일 수 있음.
    // 그럴 때 특정 메서드를 생성해서 그 안에 테스트할 내용을 작성함
    // 실행 : ctrl + f11 -> 모든 메서드 다 실행
    //      : 메서드명 위에 커서를 두고 ctrl + f11 누르면 커서가 올라간 메서드만 실행

    @Test
    @Transactional
    void crud_test1() {

        // 저장된 데이터의 개수를 얻어오기
        long count = repository.count();
        log.info(String.valueOf(count));
        log.info("총 개수 : " + count);

        // 지정된 아이디에 해당되는 데이터가 존재하는지 여부 (boolean)
        boolean exists = repository.existsById(1L);
        log.info("존재 여부확인:" + exists);

    }

    @Test
    @Transactional
    void crud_test2() {


    }

    @Test
    @Transactional
    void select_test1() {

        // 전체 멤버 목록 조회
        List<Member> members = repository.findAll();
        members.forEach(System.out::println);       // 람다식으로 리스트나 컬렉션 데이터들을 하나씩 출력하는 방식

        // 이름으로 조회했을 때
        List<Member> list = repository.findByName("IU");

    }

    @Test
    @Transactional  // 여러 작업을 하나의 트랜젝션으로 묶어서 실행
                    // 테스트 중에서 데이터베이스에 추가되거나 삭제 혹은 변경된 데이터가 실제로 반영되지 않도록 테스트 전 상태로 돌리기
    void del_test1() {

        // 한번에 여러 개를 삭제하는 명령문
//        repository.deleteAlById(1L);
        // List.of보다 간단하고 명확하게 Gjava 라이브러리에서 제공하는 메서드 이용
//        repository.deleteAll(repository.deleteById(Lists.newArrayList(1L,3L,5L)));

        // 단일 데이터 삭제하기 Id
        repository.deleteById(1L);
        List<Member> members = repository.findAll();
        members.forEach(System.out::println);

    }

    @Test
    @Transactional
    void select_paging_test1() {
        // 페이징 처리하기 위한 단위 테스트

        Page<Member> memberPage = repository.findAll(PageRequest.of(1, 3));
        System.out.println(memberPage);

        // 총 페이지 수 확인
        int totalPages = memberPage.getTotalPages();
        System.out.println("page totalPages : " + totalPages);

        // 전체 데이터의 개수
        long totalData = memberPage.getTotalElements();
        System.out.println("page totalData : " + totalData);


        // 현재 페이지의 데이터 개수
        int currentPage = memberPage.getNumber();
        System.out.println("currentPage : " + currentPage);

        memberPage.get().forEach(System.out::println);  // 현재 페이지의 멤버 출력

        // 정렬 여부
        // PageRequest.of(얻어올 페이지 번호, 페이지의 크기, 정렬방식)
        // - Sort.by() : 정렬방식 지정. 기본적으로 오름차순
        log.info("정렬");
        memberPage.getSort().forEach(System.out::println);

        log.info("오름차순");
        Page<Member> findName = repository.findAll(PageRequest.of(0, 3, Sort.by(Sort.Order.by("id"))));
        findName.get().forEach(System.out::println);

        log.info("내림차순");
        Page<Member> findNameDesc = repository.findAll(PageRequest.of(0, 3, Sort.by(Sort.Order.by("id")).descending()));
        findNameDesc.get().forEach(System.out::println);
    }



}
