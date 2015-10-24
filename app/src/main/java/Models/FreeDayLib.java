package Models;

import java.util.ArrayList;

/**
 * Created by niffer on 10/23/15.
 */

public class FreeDayLib {

    private ArrayList<FreeDay> mFreeDays;

    public FreeDayLib() {
        setFreeDays();
    }

    public ArrayList<FreeDay> getFreeDays() {
        return mFreeDays;
    }

    private void setFreeDays() {
        mFreeDays = new ArrayList<>();



        mFreeDays.add(new FreeDay(
            "National Popcorn Day",
            "January 19",
            "http://www.popcorn.org/AboutUs/Media/NationalPopcornDay/tabid/115/Default.aspx",
            "Select movie theaters across the country offer a bag of free popcorn."
        ));

        mFreeDays.add(new FreeDay(
            "National Pancake Day",
            "March 8",
            "IHOP offers a free short stack of buttermilk pancakes, limited to dine-in guests visiting between 7am and 10pm, while supplies last.",
            "http://www.ihoppancakeday.com/index.html/"
        ));

        mFreeDays.add(new FreeDay(
            "Free Cone Day",
            "April 14",
            "Starting at noon, customers at participating Ben & Jerry's locations are welcomed to choose their flavor of ice cream, on the house.",
            "http://www.benjerry.com/scoop-shops/free-cone-day/"
        ));
    }

    public FreeDay nextFreeDay(FreeDay mCurrentFreeDay) {
        int index = mFreeDays.indexOf(mCurrentFreeDay);
        if (index ==  mFreeDays.size() - 1) {
            return mFreeDays.get(0);
        } else {
            return mFreeDays.get(index + 1);
        }
    }
}
