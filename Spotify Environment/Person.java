package HW4;


public class Person {
	String PersonName;
	Person next;
	
	public Person(String PersonName) { // I added this for more efficiency so i don't need to define the personname and next one everytime.
		this.PersonName= PersonName;
		this.next=null;
		
	}

}
