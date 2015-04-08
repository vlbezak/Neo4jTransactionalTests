package sk.gov.finance.metais.neo4j.service.impl;

import java.util.Map;

import org.neo4j.graphdb.GraphDatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sk.gov.finance.metais.neo4j.service.Neo4jTransactionalService;

@Component
public class Neo4jTransactionalServiceImpl implements Neo4jTransactionalService{

    private static final Logger log = LoggerFactory.getLogger(Neo4jTransactionalServiceImpl.class);
    
    @Autowired
    GraphDatabase graphDatabase;
    
    @Autowired
    Neo4jTemplate neo4jTemplate;
    
    public Neo4jTransactionalServiceImpl(){
        log.info("graphDatabase:" + graphDatabase);
    }
    
    public Result<Map<String, Object>> executeCypher(String statement, Map<String, Object> params) {
        log.debug("Executing:" + statement + " " + graphDatabase + " " + neo4jTemplate );
        return neo4jTemplate.query(statement, params);
    }

    
}
