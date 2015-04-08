package sk.gov.finance.metais.neo4j.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sk.gov.finance.metais.neo4j.bo.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
   @Query("Match (student:Student) Where student.name = {0} return student")	
   Student getStudentByName(String name);

}
