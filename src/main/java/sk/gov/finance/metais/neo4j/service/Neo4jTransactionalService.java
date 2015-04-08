package sk.gov.finance.metais.neo4j.service;

import java.util.Map;

import org.springframework.data.neo4j.conversion.Result;
import org.springframework.stereotype.Service;

@Service
public interface Neo4jTransactionalService {
    public  Result<Map<String, Object>> executeCypher(String statement, Map<String,Object> params);

}
