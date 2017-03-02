package Models;

import android.net.Uri;

import java.io.Serializable;

/**
 * Created by tasos on 2/27/2017.
 */

public class Speaker implements Serializable {
    private String name, shortBio, bio;
    private int smallImg;
    private Uri  largeImg;
    public Speaker(String name, String shortBio,String bio, int smallImg){
        this.name=name;
        this.shortBio=shortBio;
        this.bio=bio;
        this.smallImg=smallImg;
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
    public int getSmallImg(){
        return smallImg;
    }

}
