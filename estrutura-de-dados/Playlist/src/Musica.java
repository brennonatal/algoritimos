
public class Musica {
	String title;
	String artist;
	String genre;
	int played;
	
	public Musica(String title, String artist, String genre, int played) {
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.played = played;
	}
	
	
	@Override
	public String toString() {
		String aux = "";
		aux += "T�tulo: "+title+"\n";
		aux += "Artista: "+artist+"\n";
		aux += "G�nero: "+genre+"\n";
		if(played == 1) {
			aux += "M�sica tocada apenas "+played+" vez.\n";
		} else {
			aux += "M�sica tocada "+played+" vezes.\n";
		}
		
		return aux;
	}
}
