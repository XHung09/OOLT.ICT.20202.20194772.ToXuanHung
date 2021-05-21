package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable, Comparable<Track> {
	
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}
	
	public int getLength() {
		return length;
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public Track(String title) {
		super();
		this.title = title;
	}
	
	// play
	public void play() throws PlayerException {
		System.out.println("Playing track: " + this.getTitle());
		if (this.getLength() > 0) {
			System.out.println("Track length: " + this.getLength());
		} else {
			throw new PlayerException("ERORR: DVD length is non-positive");
		}
	}
	
	// override equals()
	@Override
	public boolean equals(Object obj) {	
		if (obj instanceof Track) {
			Track tempTrack = (Track) obj;
			if ((this.title == tempTrack.title) && (this.length == tempTrack.length)) {
				return true;
			} else  {
				return false;
			}
 		} else {
 			return false;
 		}
	}
	
	// compareTo()
	@Override
	public int compareTo(Track obj) {
		int cmp = this.title.compareTo(obj.title);
		
		if (cmp == 0) {
			cmp = this.length = obj.length;
		}
		return cmp;
	}
	
}
