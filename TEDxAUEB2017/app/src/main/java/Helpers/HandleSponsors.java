package Helpers;

import com.tedxaueb.tedxaueb2017.R;

import java.util.LinkedList;

import Models.Sponsor;

/**
 * Created by tasos on 3/8/2017.
 */

public class HandleSponsors {
    private LinkedList<Sponsor> platinum,gold,silver,friends,inkind,community, workshops,media;
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
        silver.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/execmba-1.png","http://executivemba.aueb.gr/"));
        silver.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/logo_global_gmat1-150x150.png","http://www.globalprep.gr/"));
        silver.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/Screenshot_1-150x150.png","https://www.facebook.com/cmmakris/"));
        silver.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/mentos-1-150x150.png",""));
        silver.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/ethniki-1-150x150.png","https://www.nbg.gr/el/i-bank"));
        silver.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/ipb-150x150.png","http://iphotobooth.gr/"));
        silver.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/latsis.png","http://www.latsis-foundation.org/"));
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
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/coca-cola-150x150.png","http://www.coca-cola.gr/el/home/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/momix.png","http://www.momixbar.com/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/NISSOS_corporate-2.jpg","http://nissos.beer/el/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/SKAG-Logo_2016.jpg","http://skag.gr/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/starbucks1.jpg","http://www.starbucks.com.gr/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/e-food_logo-01--150x150.png","https://www.e-food.gr/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/nature_v.jpg","http://www.naturevalley.gr/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/lavdas.jpg","http://www.lavdas.gr/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/aegean-150x150.png","https://el.aegeanair.com/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/bic-150x150.png","http://gr.bicworld.com/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/%CF%80%CE%B1%CF%80%CE%B1%CE%B4%CE%BF%CF%80%CE%BF%CF%85%CE%BB%CE%BF%CF%82.png","http://papadopoulou.gr/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/yamas-150x150.png","http://www.yamasdrink.com/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/FO-150x150.png","http://www.fibreone.gr/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/lafazanis-1-150x150.png","https://lafazanis.gr/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/%CF%83%CF%87%CE%AF%CE%B6%CE%B1%CF%82-150x150.png","https://www.facebook.com/sxizas.shop/?fref=ts"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/KRI-KRI_SUPER-SPOON_LOGO_new-01-150x150.png","http://www.krikrisuperspoon.gr/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/uniliver-150x150.png","https://www.unilever.gr/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/kayak-150x150.png","http://www.kayak.gr/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/opashop-150x150.png","http://shop.aueb.gr/el/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/vivechrom-150x150.png","https://www.vivechrom.gr/en/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/GrandmaSyndrome-150x150.png","https://www.facebook.com/GrandmaSyndrome/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/7days.png","http://www.7days.com/gr/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/FJB-150x148.png","https://www.facebook.com/Froots-Juice-Bar-559242057548186/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/ioniki.png","http://www.ioniki.com/gr/index.php?l=4"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/%CF%83%CF%80%CE%B9%CF%84%CE%B9%CE%BA%CF%8C-150x150.png","http://www.tospitiko.gr/"));
        inkind.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/thinking-cup.png","https://www.facebook.com/ThinkingCupAthens/"));
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
        community.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/givmed-150x150.png","https://www.givmed.com/"));
        return community;
    }
    public LinkedList<Sponsor> getWorkshops(){
        workshops = new LinkedList<Sponsor>();
        workshops.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/logo-100m-1-300x225.png","https://www.100mentors.com/"));
        workshops.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/17238323_271108929995633_1669589158_n-1.png","http://www.exodusathens.gr/"));
        return workshops;
    }
    public LinkedList<Sponsor> getMedia(){
        media = new LinkedList<Sponsor>();
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/SKAI-Logo.jpg","http://www.skai.gr/"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/best.png",""));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/24media.png","http://www.24media.gr/"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/%CE%BA%CE%B1%CE%B8%CE%B7%CE%BC%CE%B5%CF%81%CE%B9%CE%BD%CE%B7.png","http://www.kathimerini.gr/"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/rise.jpg","http://rise.gr/"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/sxedia.png","http://www.shedia.gr/"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/LogoHighResolution960.jpg","http://www.livinlovin.gr/"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/chill-out.png","http://www.chill-out.gr/web-tv/"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/pepper.png","http://www.pepper966.gr/"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/debop.jpg","http://www.debop.gr/"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/frapress.png","http://frapress.gr/"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/neolaia.png","http://www.neolaia.gr/"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/iq.png","http://iq.pocketwarp.com/iq-magazine-web-January/iq-magazine.html"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/mycampus.png","http://www.mycampus.gr/"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/mystudentpass.png","http://mystudentpass.gr/"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/step-up.png","http://stepup.gr/"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/neoperativa-150x150.png","https://neoperativa.media/"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/college-link.png","https://www.collegelink.gr/?gclid=CjwKEAiAoOvEBRDD25uyu9Lg9ycSJAD0cnByuJ7nDtj2btKWZdkj4OA2l0tWqAp_3CxsGUroX0xx4xoCM6rw_wcB"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/aode.png","http://www.aode.gr/"));
        media.add(new Sponsor("http://2017.tedxaueb.com/wp-content/uploads/2017/01/aoth.png","http://www.aoth.edu.gr/"));
        return media;
    }
}
