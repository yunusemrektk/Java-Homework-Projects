package HW4;



public class Song {
	
	String SongName;
	Song next;
	
	public Song(String PersonName) {// I added this for more efficiency so i don't need to define the personname and next one everytime.
		this.SongName= PersonName;
		this.next=null;
		
	}
	
}


