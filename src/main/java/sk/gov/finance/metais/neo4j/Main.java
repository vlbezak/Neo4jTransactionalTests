package sk.gov.finance.metais.neo4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sk.gov.finance.metais.neo4j.config.RootConfig;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    
    public static void main(String[] args){
        log.info("Starting application");
        
        new AnnotationConfigApplicationContext(RootConfig.class).getBean("graphDatabase");
    }
}
