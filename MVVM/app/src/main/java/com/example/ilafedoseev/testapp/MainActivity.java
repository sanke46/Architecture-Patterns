package com.example.ilafedoseev.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ilafedoseev.testapp.Adapter.ListAdapter;
import com.example.ilafedoseev.testapp.Model.Item;
import com.example.ilafedoseev.testapp.ModelView.MainModelView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Item> listItem;

    private MainModelView mainModelView;
    public TextView numberOfItems;
    private ListView listOfItems;
    private LinearLayout emptyScreen;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItem = new ArrayList<>();
        mainModelView = new MainModelView(this);
        numberOfItems = findViewById(R.id.number_of_items);
        listOfItems = findViewById(R.id.list_of_items);
        emptyScreen = findViewById(R.id.empty_screen);
        listAdapter = new ListAdapter(this, listItem);

        mainModelView.getAllDBlist(listItem, listAdapter);
        listOfItems.setAdapter(listAdapter);
    }

    /** change Visibility View **/
    public void isEmptyScreen(ArrayList list) {
        if(list.size() == 0) {
            changeVisibility(emptyScreen, listOfItems);
        } else {
            changeVisibility(listOfItems, emptyScreen);
        }
    }

    public void changeVisibility(View show, View hide) {
        show.setVisibility(View.VISIBLE);
        hide.setVisibility(View.GONE);
    }
}
