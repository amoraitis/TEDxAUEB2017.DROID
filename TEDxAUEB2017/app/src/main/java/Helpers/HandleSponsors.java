package Helpers;

import com.tedxaueb.tedxaueb2017.R;

import java.util.LinkedList;

import Models.Sponsor;

/**
 * Created by tasos on 3/8/2017.
 */

public class HandleSponsors {
    private LinkedList<Sponsor> platinum,gold,silver,friends,inkind,community,media;
    public Sponsor getAuspices(){
        return new Sponsor("http://2016.tedxaueb.com/images/aueb-logo.jpg","http://www.aueb.gr/");
    }
    public Sponsor getAcademic(){
        return new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/DMST-AUEB-logo.png","http://www.dmst.aueb.gr/index.php/el/");
    }

    public LinkedList<Sponsor> getPlatinum(){
        platinum= new LinkedList<Sponsor>();
        //sponsors.add(new Sponsor("",""));
        platinum.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/mba-1.png","http://imba.aueb.gr/"));
        platinum.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/stoiximan-2-300x229.png","https://www.stoiximan.gr/"));
        return platinum;
    }
    public LinkedList<Sponsor> getGold(){
        gold=new LinkedList<Sponsor>();
        gold.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/PAPASTRATOS-LOGO-01-copy.jpg","https://www.pmi.com/markets/greece/el"));
        gold.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/mba-2-300x202.png","http://www.bosch-home.gr/"));
        gold.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/cu.png","http://www.vodafonecu.gr/gr/upiresies-cu/ela-sto-cu/?gclid=CjwKEAiAoOvEBRDD25uyu9Lg9ycSJAD0cnByKjDyllkeJYtbhvim6UvV96gX0HUtY6NEBUa1Dlzv0xoCzhjw_wcB"));
        return gold;
    }
    public LinkedList<Sponsor> getSilver(){
        silver=new LinkedList<Sponsor>();
        silver.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/NEWlogo32years-2.jpg","http://mba.aueb.gr/"));
        silver.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/HRM-alt.2.Logo_vert.jpg","http://www.hrm.aueb.gr/"));
        silver.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/%CE%BC%CE%B5%CF%84%CE%B1%CF%80%CF%84.png","http://management.aueb.gr/"));
        silver.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/logo_global_gmat1-150x150.png","http://www.globalprep.gr/"));
        silver.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/Screenshot_1-150x150.png","https://www.facebook.com/cmmakris/"));
        silver.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/mentos-1-150x150.png",""));
        silver.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/ethniki-1-150x150.png","https://www.nbg.gr/el/i-bank"));
        silver.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/ipb-150x150.png","http://iphotobooth.gr/"));
        return silver;
    }

    public LinkedList<Sponsor> getFriends(){
        friends=new LinkedList<Sponsor>();
        friends.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/MScME-Enallakt.png","http://www.ment.aueb.gr/"));
        friends.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/shipping.png","http://msc-isfm.aueb.gr/en-US"));
        friends.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/loxrh.png","http://www.postgraduate-accfin.aueb.gr/"));
        friends.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/businness-analytics.jpg","http://analytics.aueb.gr/"));
        return friends;
    }
    public LinkedList<Sponsor> getInkind(){
        inkind=new LinkedList<Sponsor>();
        inkind.add(new Sponsor("",""));

        return inkind;
    }
    public LinkedList<Sponsor> getCommunity(){
        community=new LinkedList<Sponsor>();
        community.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/jobpairs_color1.jpg","http://www.job-pairs.gr/"));
        community.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/ThinkBiz-Logo-150x150.png","https://thinkbiz.gr/en/"));
        community.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/Youth_Speak_Forum_Logo-150x150.png","http://aiesec.org/youthspeak/forum/"));
        community.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/AIESEC.png","http://aiesec.gr/"));
        community.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/cruise.png","http://getcruiseinn.com/"));
        community.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/mindspace_logo-1-150x150.png","http://www.mindspace.gr/"));
        community.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/sdsn-1.png","http://sdsnyouth.org/"));
        return community;
    }
    public LinkedList<Sponsor> getMedia(){
        media = new LinkedList<Sponsor>();
        media.add(new Sponsor("",""));
        return media;
    }
}
