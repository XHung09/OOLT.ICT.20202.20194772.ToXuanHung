package hust.soict.globalict.aims.media;

public class Track implements Playable {
	
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
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		if (this.getLength() > 0) {
			System.out.println("Track length: " + this.getLength() + "\n");
		} else {
			System.out.println("This track cannot be played!\n");
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
	
}
