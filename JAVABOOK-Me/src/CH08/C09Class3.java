package CH08;

import java.util.Scanner;

class Song{
	private String title;
	private String artist;
	private int year;
	private String country;
	public Song() {};
	public Song(String title, String artist, int year, String country) {
		super();
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = country;
	}
	public void show() {
		System.out.println(this.year+"년 "+this.country+" 국적의 "+this.artist+"가 부른 "+this.title);
	}
	
}

public class C09Class3 {
	public static void main(String[] args) {
		Song me = new Song("Dancing Queen","ABBA", 1978, "스웨덴");
		me.show();
	}
}
