package com.rasmuslykke.customrecyclerviewweek13.storage;

import com.rasmuslykke.customrecyclerviewweek13.R;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public List<String> noteList = new ArrayList<>();
    public List<Integer> imageList = new ArrayList<>();

    public Storage(){
        noteList.add("A busy highway");
        noteList.add("City cars");
        noteList.add("Plane over city");
        noteList.add("Mountains");
        noteList.add("Snow house");
        noteList.add("A working man");

        imageList.add(R.drawable.busy_highway);
        imageList.add(R.drawable.city_cars);
        imageList.add(R.drawable.city_plane);
        imageList.add(R.drawable.mountains);
        imageList.add(R.drawable.snow_house);
        imageList.add(R.drawable.working_man);
    }
}
