package ICS4U4;

/*
 * Simple class representing a person, with a name and age
 */

public class Person {
	String name;
	int age;
	
	//Create a Person
	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	//Get the name
	public String getName()
	{
		return this.name;
	}
	
	//Get the age
	public int getAge()
	{
		return this.age;
	}

}
