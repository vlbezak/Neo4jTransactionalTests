package sk.gov.finance.metais.neo4j.config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.data.neo4j.rest.SpringCypherRestGraphDatabase;
import org.springframework.stereotype.Service;

import sk.gov.finance.metais.neo4j.service.BusinessService;
import sk.gov.finance.metais.neo4j.service.Neo4jTransactionalService;
import sk.gov.finance.metais.neo4j.service.impl.BusinessServiceImpl;
import sk.gov.finance.metais.neo4j.service.impl.Neo4jTransactionalServiceImpl;


@Configuration
@EnableNeo4jRepositories(basePackages={"sk.gov.finance"})
@ComponentScan(basePackages={"sk.gov.finance"})
public class RootConfig extends Neo4jConfiguration {
    
    private static final Logger log = LoggerFactory.getLogger(RootConfig.class);
    
    public RootConfig() {
        //Toto je teraz povinne sakra !!!!!
        setBasePackage("sk.gov.finance");
    }

    @Autowired
    GraphDatabase graphDatabase;

    @Bean
    GraphDatabaseService graphDatabaseService() {
        
        log.debug("in graphDatabaseService");
        SpringCypherRestGraphDatabase db = new SpringCypherRestGraphDatabase("http://localhost:7474/db/data", "neo4j", "zaq123");
        log.debug("database: " + db );
        
        return db;
    }
    
    

//    @Bean
//    public BusinessService businessService(){
//        return new BusinessServiceImpl();
//    }
//    
//    @Bean
//    public Neo4jTransactionalService neo4jTransactionalService(){
//        return new Neo4jTransactionalServiceImpl();
//    }


}
