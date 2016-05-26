package models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="person")
public class Person {
	
	@Id
	@SequenceGenerator(name="personSeq", sequenceName="sq_person", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="personSeq")
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	@Column(name = "name")
	private String name;
	
	public Person() {
		
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
