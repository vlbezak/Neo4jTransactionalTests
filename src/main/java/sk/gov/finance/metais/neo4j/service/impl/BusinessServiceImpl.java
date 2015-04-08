package sk.gov.finance.metais.neo4j.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sk.gov.finance.metais.neo4j.bo.Student;
import sk.gov.finance.metais.neo4j.repository.StudentRepository;
import sk.gov.finance.metais.neo4j.service.BusinessService;
import sk.gov.finance.metais.neo4j.service.Neo4jTransactionalService;

@Component
public class BusinessServiceImpl implements BusinessService {

    @Autowired 
    Neo4jTransactionalService neo4jService;
    
    @Autowired
    StudentRepository studentRepository;
    
    private static final Logger log = LoggerFactory.getLogger(BusinessServiceImpl.class);
    
    @Transactional("neo4jTransactionManager")
    public void someBusinessMethod(){
        
        String createStmt = "create (testnode:TestNode1 {uuid: 'test_4'} )";
        neo4jService.executeCypher(createStmt, null);
        
        neo4jService.executeCypher("match (n) return n.name", null);
        
        neo4jService.executeCypher("match (n) return n.name", null);
        
        throw new RuntimeException("Exception on purpose");
        
//        createStmt = "create (testnode:TestNode1 {uuid: 'test_2'} )";
//        neo4jService.executeCypher(createStmt, null);
//        
//        neo4jService.executeCypher("match (n) return n.name", null);
       
        //other query
    }

    @Transactional(value = "neo4jTransactionManager")
    public void someStudentMethod() {
        log.info ("someStudentMethod");
        
        Student std1 = new Student();
        std1.name = "First student";
        studentRepository.save(std1);
        
        throw new RuntimeException("Exception on purpose");
        
//        Student std2 = new Student();
//        std2.name = "Second student";
//        studentRepository.save(std2);
        
        
    }
}
