package Models;

/**
 * Created by tasos on 3/8/2017.
 */

public class Sponsor {
    private String image;
    private String site;
    public Sponsor(String image, String site){
        this.image=image;
        this.site=site;
    }
    public String getImage(){
        return image;
    }
    public String getSite(){
        return site;
    }
}
