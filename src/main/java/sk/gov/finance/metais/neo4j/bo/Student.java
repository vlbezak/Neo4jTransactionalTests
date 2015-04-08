package sk.gov.finance.metais.neo4j.bo;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
@NodeEntity
public class Student { 
	@GraphId
	Long id;
	public String name;
	
	public Student(){}
	public Student(String name){
		this.name=name;
	}
}
