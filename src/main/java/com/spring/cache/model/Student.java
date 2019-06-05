package com.spring.cache.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

/*@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
*/
//@Entity
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Student extends StudentSerializer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * @Id
	 * 
	 * @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER",
	 * allocationSize = 1)
	 * 
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	 */
	private int id;
	private String name;
	private int age;


	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Student() {
		super();
	}

	/*
	 * private void readObject(ObjectInputStream ois) throws Exception {
	 * ois.defaultReadObject(); String objStr = (String) ois.readObject();
	 * ObjectMapper objMapper = new ObjectMapper(); Student s =
	 * objMapper.readValue(objStr, Student.class); id = s.id; name = s.name; age =
	 * s.age; }
	 * 
	 * @Override public Object deserialize(byte[] bytes) { // TODO Auto-generated
	 * method stub return super.deserialize(bytes); }
	 * 
	 * @Override public byte[] serialize(Object object) { // TODO Auto-generated
	 * method stub return super.serialize(object); }
	 * 
	 * private void writeObject(ObjectOutputStream oos) throws Exception {
	 * oos.defaultWriteObject(); oos.writeObject(toString()); }
	 */
}
