package study.datajpa.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.domain.Member;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void findByUsernameAndAgeGreaterThen(){
        Member m1 = new Member("AAA", 10);
        Member m2 = new Member("AAA", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> result = memberRepository.findByUsernameAndAgeGreaterThan("AAA", 10);

        Assertions.assertThat(result.get(0).getUsername()).isEqualTo("AAA");
        Assertions.assertThat(result.get(0).getAge()).isEqualTo(20);
        Assertions.assertThat(result.size()).isEqualTo(1);
    }
    
    @Test
    public void findByQuery() throws Exception{
        //given
        Member member = new Member("HI MAN", 25);
        memberRepository.save(member);

        List<Member> result = memberRepository.findUser("HI MAN", 25);

        Assertions.assertThat(result.get(0).getUsername()).isEqualTo("HI MAN");
        Assertions.assertThat(result.get(0).getAge()).isEqualTo(25);
        //when
    }

    @Test
    public void QueryNameList() throws Exception{
        //given
        Member m1 = new Member("Hyun Jin");
        Member m2 = new Member("Kim");

        memberRepository.save(m1);
        memberRepository.save(m2);

        List<String> userNameList = memberRepository.findUserNameList();
        //when

        Assertions.assertThat(userNameList.get(0)).isEqualTo("Hyun Jin");
        Assertions.assertThat(userNameList.get(1)).isEqualTo("Kim");
    }
    
    @Test
    public void QueryDto() throws Exception{
        //given

        //when
    }
    
    @Test
    public void QueryParameter() throws Exception{
        //given
        Member m = new Member("HJ", 32);
        memberRepository.save(m);

        Member members = memberRepository.findMembers("HJ");
        //when
        Assertions.assertThat(members.getUsername()).isEqualTo("HJ");
    }
    
    @Test
    public void QueryCollection() throws Exception{
        //given
        Member m1 = new Member("KHJ", 22);
        Member m2 = new Member("Kim", 24);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<String> names = new ArrayList<>();
        names.add("KHJ");
        names.add("Kim");

        List<Member> results = memberRepository.findNames(names);

        //when
        Assertions.assertThat(results.get(0)).isEqualTo("KHJ");
        Assertions.assertThat(results.get(1)).isEqualTo("Kim");

    }



}