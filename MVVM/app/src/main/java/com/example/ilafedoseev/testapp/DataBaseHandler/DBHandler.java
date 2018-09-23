package com.example.ilafedoseev.testapp.DataBaseHandler;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.ilafedoseev.testapp.Adapter.ListAdapter;
import com.example.ilafedoseev.testapp.MainActivity;
import com.example.ilafedoseev.testapp.Model.Item;
import com.example.ilafedoseev.testapp.ModelView.MainModelView;
import com.example.ilafedoseev.testapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DBHandler {

    private MainModelView mainModelView;
    private MainActivity mainActivity;

    public DBHandler(MainModelView mainModelView , MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.mainModelView = mainModelView;
    }

    public void dbHandler(final ArrayList<Item> listItem, final ListAdapter arrayAdapter) {
        listItem.clear();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, mainModelView.URL_JSON, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject employee = jsonArray.getJSONObject(i);

                        int id = employee.getInt("id");
                        String name = employee.getString("name");
                        String symbol = employee.getString("symbol");
                        String websiteSlug = employee.getString("website_slug");

                        listItem.add(new Item(id,name,symbol,websiteSlug));
                    }
                    mainActivity.numberOfItems.setText("Result: " + String.valueOf(jsonArray.length()));
                    arrayAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                mainActivity.isEmptyScreen(listItem);
            }
        });

        mainModelView.queue.add(request);
    }
}
