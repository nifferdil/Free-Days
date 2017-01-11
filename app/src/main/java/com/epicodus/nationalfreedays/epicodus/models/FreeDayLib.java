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
                "Select movie theaters across the country offer a bag of free popcorn.",
                "http://www.popcorn.org/Facts-Fun/National-Popcorn-Day/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.donut,
                "National Bagel Day",
                "February 9",
                Calendar.FEBRUARY,
                9,
                "Einstein Bros. and Noah's Bagels offer a free bagel and schmear with any purchase. Panera Bread gives away a free bagel with coffee purchase.",
                "http://www.nationalbagelday.com/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_pancakes,
                "National Pancake Day",
                "March 7",
                Calendar.MARCH,
                7,
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
                "https://www.punchbowl.com/holidays/national-pretzel-day/"
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
                "http://www.krispykreme.com/nationaldoughnutday/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ice_tea,
                "National Iced Tea Day",
                "June 10",
                Calendar.JUNE,
                10,
                "7-Eleven gives away a free Snapple tea and Teavana gives you a free tea with purchase.",
                "http://www.nationalicedteaday.com/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.slurpee,
                "7-Eleven Day",
                "July 11",
                Calendar.JULY,
                11,
                "Celebrate 7/11 with a free small Slurpee and sometimes other items from 11am to 7pm.",
                "http://fiftee.slurpee.com/post/146738790096/celebrate-711-with-a-free-small-slurpee-from-11am/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.chicken,
                "National Chicken Wing Day",
                "July 29",
                Calendar.JULY,
                29,
                "Free or discounted wings at Buffalo Wild Wings, Wingstop, Wing Zone, and Wild Wing Cafe and others.",
                "http://www.nationalchickenwingday.com/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.rootbeer,
                "National Rootbeer Float Day",
                "August 6",
                Calendar.AUGUST,
                6,
                "Stop in to any A&W Restaurant location from 2pm-close and enjoy a Float on them.",
                "http://awrestaurants.com/rootbeerfloatday/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.cheeseburger,
                "National Cheeseburger Day",
                "September 18",
                Calendar.SEPTEMBER,
                18,
                "Free, discounted and specialty burgers at select locations including Ruby Tuesday, Black Angus, Johnny Rockets and many more.",
                "http://www.offers.com/blog/post/national-cheeseburger-day/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_coffee_maker,
                "National Coffee Day",
                "September 29",
                Calendar.SEPTEMBER,
                29,
                "Select retailers offer a free small coffee: Dunkin' Donuts, Krispy Kreme, Lamar's Donuts, and McDonald's. Other retailers who offer BOGO are Eintstein's Bros Bagels, Noah's Bagels, and Peet's Coffee.",
                "https://www.punchbowl.com/holidays/national-coffee-day/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.taco,
                "National Taco Day",
                "October 4",
                Calendar.OCTOBER,
                4,
                "Freebies and deals across the country at TacoTime, El Pollo Loco, Del Taco and other select locations.",
                "http://www.offers.com/blog/post/national-taco-day/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_sandwich,
                "National Sandwich Day",
                "November 3",
                Calendar.NOVEMBER,
                3,
                "Look for promotions from chains such as Subway and Jersey Mike's.",
                "https://www.punchbowl.com/holidays/national-sandwich-day/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_cookie,
                "National Cookie Day",
                "December 4",
                Calendar.DECEMBER,
                4,
                "Check out stores like Great American Cookies and Quiznos to get your free cookie!",
                "https://www.punchbowl.com/holidays/national-cookie-day/"
        ));

        mFreeDays.add(new FreeDay(
                R.drawable.ic_brownie,
                "National Brownie Day",
                "December 8",
                Calendar.DECEMBER,
                8,
                "Free brownie at participating Nestle Toll House Cafe locations.",
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
