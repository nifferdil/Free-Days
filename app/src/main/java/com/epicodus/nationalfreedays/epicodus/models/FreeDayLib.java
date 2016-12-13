package com.epicodus.nationalfreedays.epicodus.models;

import com.epicodus.nationalfreedays.R;

import java.util.ArrayList;
import java.util.Calendar;

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

        mFreeDays.add(new FreeDay (

                R.drawable.ic_popcorn,
                "National Popcorn Day",
                "January 19",
                Calendar.JANUARY,
                19,
                "Select movie theaters across the country offer a bag of free popcorn.",
                "http://www.popcorn.org/AboutUs/Media/NationalPopcornDay/tabid/115/Default.aspx/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_pancakes,
                "National Pancake Day",
                "March 8",
                Calendar.MARCH,
                8,
                "IHOP offers a free short stack of buttermilk pancakes, limited to dine-in guests visiting between 7am and 10pm, while supplies last.",
                "http://www.ihoppancakeday.com/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_ice_cream,
                "Free Cone Day",
                "April 14",
                Calendar.APRIL,
                14,
                "Starting at noon, customers at participating Ben & Jerry's locations are welcomed to choose their flavor of ice cream, on the house.",
                "http://www.benjerry.com/scoop-shops/free-cone-day/"

        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_pretzel,
                "National Pretzel Day",
                "April 26",
                Calendar.APRIL,
                26,
                "Free pretzels at Philly Pretzel Factory, Pretzelmaker, and Snyder's of Hanover.",
                ""
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_comic,
                "Free Comic Day",
                "First Saturday in May",
                Calendar.MAY,
                0,
                "Participating comic book stores across North America give away free comic books.",
                "http://www.freecomicbookday.com/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_doughnut,
                "National Donut Day",
                "First Friday in June",
                Calendar.JUNE,
                0,
                "Get a free donut at Krispy Kreme, LaMar's Donuts, and Shipley Do-Nuts.",
                ""
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_tea,
                "National Iced Tea Day",
                "June 10",
                Calendar.JUNE,
                10,
                "7-Eleven gives away a free Snapple tea and Teavana gives you a free tea with purchase.",
                ""
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_coffee_maker,
                "National Coffee Day",
                "September 29",
                Calendar.SEPTEMBER,
                29,
                "Select retailers offer a free small coffee: Dunkin' Donuts, Krispy Kreme, Lamar's Donuts, and McDonald's. Other retailers who offer BOGO are Eintstein's Bros Bagels, Noah's Bagels, and Peet's Coffee.",
                ""
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_sandwich,
                "National Sandwich Day",
                "November 3",
                Calendar.NOVEMBER,
                3,
                "Look for promotions from chains such as Subway and Jersey Mike's.",
                ""
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_cookie,
                "National Cookie Day",
                "December 4",
                Calendar.DECEMBER,
                4,
                "Check out stores like Great American Cookies and Quiznos to get your free cookie!",
                ""
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_brownie,
                "National Brownie Day",
                "December 8",
                Calendar.DECEMBER,
                8,
                "Free brownie at participating Nestle Toll House Cafe locations.",
                ""
        ));
    }

    public FreeDay nextFreeDay(FreeDay mCurrentFreeDay) {
        int index = mFreeDays.indexOf(mCurrentFreeDay);
        if (index == mFreeDays.size() - 1) {
            return mFreeDays.get(0);
        } else {
            return mFreeDays.get(index + 1);
        }
    }

    public FreeDay previousFreeDay(FreeDay mCurrentFreeDay) {
        int index = mFreeDays.indexOf(mCurrentFreeDay);
        if (index == mFreeDays.size() - mFreeDays.size()) {
            return mFreeDays.get(mFreeDays.size() - 1);
        } else {
            return mFreeDays.get(index - 1);
        }
    }

    public int getFirstFriday(int freeDayDay) {

        freeDayDay = Calendar.FRIDAY;
        return freeDayDay;
    }
}
