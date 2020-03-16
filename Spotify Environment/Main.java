package HW4;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	
	
	public static void main(String[] args) {
		InputText txt = new InputText();
		
		// THESEE LINES FOR GETTING A COMMAND FROM CONSOLE JUST LIKE IN input.txt FILE
		Scanner input = new Scanner(System.in);
		
		while(true) {
		String Lines = input.nextLine();
		
		StringTokenizer token = new StringTokenizer(Lines);
		String commands = token.nextToken();
		char commandcontrol = commands.charAt(0);
		
		if(commandcontrol=='O') {
			try{String direction = token.nextToken(commands).trim();
			System.out.println(direction);
			txt.InputTxt(direction);}
			catch (Exception e) {
				System.out.println("Give");
			}
		}
		if(commandcontrol=='I') {
		 String name = token.nextToken(commands).trim();
		 txt.I(name);
		}
		if(commandcontrol=='L') {
			   String tmpperson = token.nextToken();
			   String songname = token.nextToken(commands).trim();
			   txt.L(tmpperson,songname);
		}
		if(commandcontrol=='E') {
			
			   String tmpperson =  token.nextToken();
			   String SongName= token.nextToken(commands).trim();
			   System.out.println(SongName);
			   txt.E(tmpperson,SongName);
		}
		if (commandcontrol =='D') {
			String tmpperson = token.nextToken();
			txt.D(tmpperson);
			
			
		}
		if(commandcontrol=='P') {
			String tmpperson = token.nextToken();
			txt.P(tmpperson);
		}
		if(commandcontrol=='M') {
			String tmpperson = token.nextToken();
			txt.M(tmpperson);
		}
		if(commandcontrol=='R') {
			String tmpperson = token.nextToken();
			txt.R(tmpperson);
		}
		if(commandcontrol=='X') {
			break;
		}
		
	
		}
		input.close();
	}
	
}
