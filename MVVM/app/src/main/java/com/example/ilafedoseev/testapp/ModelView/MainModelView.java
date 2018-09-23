package com.example.ilafedoseev.testapp.ModelView;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ilafedoseev.testapp.Adapter.ListAdapter;
import com.example.ilafedoseev.testapp.DataBaseHandler.DBHandler;
import com.example.ilafedoseev.testapp.MainActivity;
import com.example.ilafedoseev.testapp.Model.Item;
import com.example.ilafedoseev.testapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainModelView {

    public static final String URL_JSON = "https://api.coinmarketcap.com/v2/listings/";
    MainActivity mainActivity;
    DBHandler dbHandler;
    public RequestQueue queue;


    public MainModelView(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        dbHandler = new DBHandler(this, mainActivity);
        queue = Volley.newRequestQueue(mainActivity.getApplicationContext());
    }

    public ArrayList<Item> getAllDBlist(ArrayList<Item> listItem, final ListAdapter arrayAdapter) {
        dbHandler.dbHandler(listItem, arrayAdapter);
        return listItem;
    }

}
