package in.robotix.robotixapp.opener;

/**
 * Created by root on 16/5/17.
 */

public class OpenerHome {
    private String name;
    private int thumbnail;
    public OpenerHome() {
    }

    public OpenerHome(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
