package Models;

/**
 * Created by tasos on 2/27/2017.
 */

public class Speaker {
    private String name, shortBio, bio;
    public Speaker(String name, String shortBio,String bio){
        this.name=name;
        this.shortBio=shortBio;
        this.bio=bio;
    }

    public String getBio() {
        return bio;
    }

    public String getName() {
        return name;
    }

    public String getShortBio() {
        return shortBio;
    }
}
