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

        mFreeDays.add(new FreeDay(

                R.drawable.ic_popcorn,
                "National Popcorn Day",
                "January 19",
                Calendar.JANUARY,
                19,
                R.string.popcorn_desc,
                "http://www.popcorn.org/Facts-Fun/National-Popcorn-Day/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.bagel,
                "National Bagel Day",
                "February 9",
                Calendar.FEBRUARY,
                9,
                R.string.bagel_desc,
                "http://www.nationalbagelday.com/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_pancakes,
                "National Pancake Day",
                "March 7",
                Calendar.MARCH,
                7,
                R.string.pancake_desc,
                "http://www.ihoppancakeday.com/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_ice_cream,
                "Free Cone Day",
                "April 14",
                Calendar.APRIL,
                14,
                R.string.ice_cream_desc,
                "http://www.benjerry.com/scoop-shops/free-cone-day/"

        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_pretzel,
                "National Pretzel Day",
                "April 26",
                Calendar.APRIL,
                26,
                R.string.pretzel_desc,
                "https://www.punchbowl.com/holidays/national-pretzel-day/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_comic,
                "Free Comic Day",
                "First Saturday in May",
                Calendar.MAY,
                0,
                R.string.comic_desc,
                "http://www.freecomicbookday.com/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_doughnut,
                "National Donut Day",
                "First Friday in June",
                Calendar.JUNE,
                0,
                R.string.doughnut_desc,
                "http://www.krispykreme.com/nationaldoughnutday/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.icetea,
                "National Iced Tea Day",
                "June 10",
                Calendar.JUNE,
                10,
                R.string.ice_tea_desc,
                "http://www.nationalicedteaday.com/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.slurpee,
                "7-Eleven Day",
                "July 11",
                Calendar.JULY,
                11,
                R.string.slurpee_desc,
                "http://fiftee.slurpee.com/post/146738790096/celebrate-711-with-a-free-small-slurpee-from-11am/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.chicken,
                "National Chicken Wing Day",
                "July 29",
                Calendar.JULY,
                29,
                R.string.chicken_wing_desc,
                "http://www.nationalchickenwingday.com/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.rootbeer,
                "National Rootbeer Float Day",
                "August 6",
                Calendar.AUGUST,
                6,
                R.string.root_beer_desc,
                "http://awrestaurants.com/rootbeerfloatday/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.cheeseburger,
                "National Cheeseburger Day",
                "September 18",
                Calendar.SEPTEMBER,
                18,
                R.string.cheeseburger_desc,
                "http://www.offers.com/blog/post/national-cheeseburger-day/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_coffee_maker,
                "National Coffee Day",
                "September 29",
                Calendar.SEPTEMBER,
                29,
                R.string.coffee_desc,
                "https://www.punchbowl.com/holidays/national-coffee-day/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_taco,
                "National Taco Day",
                "October 4",
                Calendar.OCTOBER,
                4,
                R.string.taco_desc,
                "http://www.offers.com/blog/post/national-taco-day/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_sandwich,
                "National Sandwich Day",
                "November 3",
                Calendar.NOVEMBER,
                3,
                R.string.sandwich_desc,
                "https://www.punchbowl.com/holidays/national-sandwich-day/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_cookie,
                "National Cookie Day",
                "December 4",
                Calendar.DECEMBER,
                4,
                R.string.cookie_desc,
                "https://www.punchbowl.com/holidays/national-cookie-day/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_brownie,
                "National Brownie Day",
                "December 8",
                Calendar.DECEMBER,
                8,
                R.string.brownie_desc,
                "https://foodimentary.com/2016/12/08/december-8th-is-national-brownie-day-2/"
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
