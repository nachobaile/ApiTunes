package tablerocolores.cfic.edu.apitunes;

public class Cancion {

    private String artistName;
    private String trackName;
    private String artistId;



    public String getArtistName() {
        return artistName;
    }



    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }



    public String getTrackName() {
        return trackName;
    }



    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }



    public String getArtistId() {
        return artistId;
    }



    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }



    public Cancion(){}




    public Cancion(String artistName, String trackName, String artistId) {
        this.artistName = artistName;
        this.trackName = trackName;
        this.artistId = artistId;
    }
}
