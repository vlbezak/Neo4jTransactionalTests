package sk.gov.finance.metais.neo4j.service;

import javax.annotation.PostConstruct;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sk.gov.finance.metais.neo4j.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class Neo4jTransactionalServiceTest {

    private static final Logger log = LoggerFactory.getLogger(Neo4jTransactionalServiceTest.class);

    @Autowired
    private BusinessService businessService;

    @PostConstruct
    public void setupTests() throws Exception {
        log.info("setupTests");
    }

    @Ignore
    @Test
    public void testNeo4jTemplate() throws Exception {
        log.info("testQuery");
        businessService.someBusinessMethod();
    }
    
    @Test
    public void testStudent() throws Exception {
        log.info("testStudent");
        businessService.someStudentMethod();
    }
}
