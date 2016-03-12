package com.example.dennis.cards;

import android.content.Context;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by dennis on 26/01/2016.
 */
public class CardRandomizer {
    public ArrayList<Integer> getIDs(Context context){

        ArrayList<Integer> res = new ArrayList<>();
        final R.drawable drawableResources = new R.drawable();
        final Class<R.drawable> c = R.drawable.class;
        final Field[] fields = c.getDeclaredFields();

        for (int i = 0, max = fields.length; i < max; i++) {
            final int resourceId;
            try {
                resourceId = fields[i].getInt(drawableResources);
                String name = context.getResources().getResourceEntryName(resourceId);
                //Use regex to filter out system ressources
                if (name.matches("(clubs|joker|spades|diamonds|hearts).*"))
                    res.add(resourceId);
            } catch (Exception e) {
                continue;
            }
        }
        //return the resulting array
        return res;
    }

}
