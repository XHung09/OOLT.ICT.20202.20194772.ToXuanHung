package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	// getter
	public String getArtist() {
		return artist;
	}
	
	public int getLength() {
		int totalLength = 0;
		for (int i = 0; i < tracks.size(); i++) {
			totalLength += tracks.get(i).getLength();			
		}
		
		return totalLength;
	}
	
	// constructors
	public CompactDisc(String title, String artist, List<Track> tracks) {
		super(title);
		++nbMedia;
		this.id = nbMedia;
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(String title, String category, String artist, List<Track> tracks, float cost) {
		super(title, category, cost);
		++nbMedia;
		this.id = nbMedia;
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(String title, String category, String director, String artist, List<Track> tracks, float cost) {
		super(title, category, director, cost);
		++nbMedia;
		this.id = nbMedia;
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(String title, String category, String director, String artist, float cost) {
		super(title, category, director, cost);
		++nbMedia;
		this.id = nbMedia;
		this.artist = artist;
	}	
	
	// add track
	public void addTrack(Track track) {
		if (tracks.contains(track) == false) {
			tracks.add(track);
			System.out.println("Succeed!");
		} else {
			System.out.println("This track has already existed!");
		}
	}
	
	// remove author
	public void removeTrack(Track track) {
		if (tracks.contains(track) == true) {
			tracks.remove(track);
			System.out.println("Succeed!");
		} else {
			System.out.println("This track does not exist!");
		}
	}
	
	// play
	public void play() {
        System.out.println("____________________ ____________________");
        System.out.println("artist: " + artist);
        for(int i = 0; i < tracks.size(); i++) {
            tracks.get(i).play();
        }
        System.out.println("____________________ ____________________");
    }
	
}
