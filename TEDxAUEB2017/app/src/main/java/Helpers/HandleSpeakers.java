package Helpers;

import android.support.annotation.NonNull;

import com.example.tedxaueb.tedxaueb2017.R;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import Models.Speaker;

/**
 * Created by tasos on 3/1/2017.
 */

public class HandleSpeakers {
    private LinkedList<Speaker> myspeakers;
    public LinkedList<Speaker> getMyspeakers(){
        myspeakers=new LinkedList<Speaker>();
        myspeakers.add(new Speaker("Tsapatakis","Paralympic athlet","bla bla bla", R.drawable.tsapatakis));
       /* myspeakers.add(new Speaker());
        myspeakers.add(new Speaker());
        myspeakers.add(new Speaker());
        myspeakers.add(new Speaker());
        myspeakers.add(new Speaker());
        myspeakers.add(new Speaker());
        myspeakers.add(new Speaker());
        myspeakers.add(new Speaker());
        myspeakers.add(new Speaker());
        myspeakers.add(new Speaker());
        myspeakers.add(new Speaker());
        myspeakers.add(new Speaker());
        myspeakers.add(new Speaker());
        myspeakers.add(new Speaker());
        myspeakers.add(new Speaker());
        myspeakers.add(new Speaker());*/

        return myspeakers;
    }
}
