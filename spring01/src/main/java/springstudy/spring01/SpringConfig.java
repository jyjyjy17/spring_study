package springstudy.spring01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springstudy.spring01.repository.*;
import springstudy.spring01.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.swing.text.html.parser.Entity;

@Configuration
public class SpringConfig {
    //private final DataSource dataSource;

//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//    private final MemberRepository memberRepository;
//    public SpringConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
    private EntityManager em;
    //이게 왜 autowired 지? jpa 생성 하면서 만든 em을 di 받기 때문
    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em) ;
    }
}
