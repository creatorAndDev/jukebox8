import java.io.*;
import java.util.*;

public class Jukebox8 {
	ArrayList<Song> songList = new ArrayList<Song>();
	
	public static void main(String[] args) {
		new Jukebox8().go();
	}
	
	public void go(){
		getSongs();
		System.out.println("Без сортировки: " + songList);
		System.out.println("---");

		Collections.sort(songList);
		System.out.println("Сортировка A-Z: " + songList);
		System.out.println("---");
		
		HashSet<Song> songSet = new HashSet<Song>();
		songSet.addAll(songList);
		System.out.println("Без дубликатов: " + songSet);
	}
	void getSongs(){
		try{
			File file = new File("SongsList.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null){
				addSong(line);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Ошибка в загрзуки файла");
		}
	}
	void addSong(String lineToParse){
		String[] tokens = lineToParse.split("/");
		Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		songList.add(nextSong);
	}
}
