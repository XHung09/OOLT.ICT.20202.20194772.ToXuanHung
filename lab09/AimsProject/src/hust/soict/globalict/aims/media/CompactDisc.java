package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	private static int nbTrack = 0;

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
	
	public static int getNbTrack() {
		return nbTrack;
	}
	
	// constructors
	public CompactDisc(String title, String artist, List<Track> tracks) {
		super(title);
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(String title, String category, String artist, List<Track> tracks, float cost) {
		super(title, category, cost);
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(String title, String category, String director, String artist, List<Track> tracks, float cost) {
		super(title, category, director, cost);
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(String title, String category, String director, String artist, float cost) {
		super(title, category, director, cost);
		this.artist = artist;
	}	
	
	// add track
	public void addTrack(Track track) {
		if (tracks.contains(track) == false) {
			tracks.add(track);
			++nbTrack;
		} else {
			System.out.println("This track has already existed!");
		}
	}
	
	// remove author
	public void removeTrack(Track track) {
		if (tracks.contains(track) == true) {
			tracks.remove(track);
			--nbTrack;
		} else {
			System.out.println("This track does not exist!");
		}
	}
	
	// get detail
	public String toString() {
		return "CD - " + getTitle() + " - " + getCategory() + " - " + getDirector() 
				+ " - " + getNbTrack() + " tracks" + " - " + getLength() + ": " + getCost() + "$";
	}
	
	// get tracks' detail
	public void displayTracksDetails() {
		for (Track track : this.tracks) {
			System.out.println("Track title: " + track.getTitle());
			System.out.println("Track length: " + track.getLength());
		}
	}
	
	// play
	public void play() {
        System.out.println("Playing CD: " + title);
        System.out.println("ARTIST: " + artist);
        for(int i = 0; i < tracks.size(); i++) {
            tracks.get(i).play();
        }
    }
	
	// play for GUI
	public String playGUI() {
		String str = null;
       
		for(int i = 0; i < tracks.size(); i++) {
            str = "Playing track" + tracks.get(i).getTitle()
            		+ "\nTrack length: " + tracks.get(i).getLength();
        }
        
		return str;
	}
}
