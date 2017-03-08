package Models;

/**
 * Created by tasos on 3/8/2017.
 */

public class Sponsor {
    private int image;
    private String site;
    public Sponsor(int image, String site){
        this.image=image;
        this.site=site;
    }
    public int getImage(){
        return image;
    }
    public String getSite(){
        return site;
    }
}
