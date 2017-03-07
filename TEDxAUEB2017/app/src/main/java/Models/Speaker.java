package Models;

import android.net.Uri;

import java.io.Serializable;

/**
 * Created by tasos on 2/27/2017.
 */

public class Speaker implements Serializable {
    private String name, shortBio, bio, moreLink;
    private int smallImg,largeImg;
    public Speaker(String name, String shortBio,String bio, int smallImg,int largeImg, String moreLink){
        this.name=name;
        this.shortBio=shortBio;
        this.bio=bio;
        this.smallImg=smallImg;
        this.largeImg=largeImg;
        this.moreLink=moreLink;
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
    public int getLargeImg(){return largeImg; }
    public String getMoreLink(){
        return moreLink;
    }

}
