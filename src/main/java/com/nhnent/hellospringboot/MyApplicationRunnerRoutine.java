package com.nhnent.hellospringboot;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.nhnent.hellospringboot.dao.MemberRepository;
import com.nhnent.hellospringboot.entity.Member;

@Component
public class MyApplicationRunnerRoutine implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyApplicationRunnerRoutine.class);
    
    @Autowired
    private YAMLTest yamlTest;
    
    @Autowired
    private MemberRepository memberRepository;
    
    public void run(ApplicationArguments args) {
        
        logger.info("ApplicationRunner Do.");
        
        List<String> servers = yamlTest.getServers();
        
        for (String server : servers) {
            
            logger.info("server: " + server);
        }
        
        memberRepository.save(new Member("a", 10));
        memberRepository.save(new Member("b", 15));
        memberRepository.save(new Member("c", 10));
        memberRepository.save(new Member("a", 5));
        
        Iterable<Member> memberList = memberRepository.findAll();
        
        logger.info("findAll() method");
        for (Member member : memberList) {
            logger.info(member.toString());
        }
        
        memberList = memberRepository.findByNameAndAgeLessThan("a", 10);
        
        logger.info("findByNameAndAgeLessThan() method");
        for (Member member : memberList) {
            logger.info(member.toString());
        }
        
        memberList = memberRepository.findByNameAndAgeLessThanSQL("a", 10);
        
        logger.info("findByNameAndAgeLessThanSQL() method");
        for (Member member : memberList) {
            logger.info(member.toString());
        }
        
        memberList = memberRepository.findByNameAndAgeLessThanOrderByAgeDesc("a", 15);
        
        logger.info("findByNameAndAgeLessThanOrderByAgeDesc() method");
        for (Member member : memberList) {
            logger.info(member.toString());
        }
        
        memberRepository.deleteAll();
    }
}
