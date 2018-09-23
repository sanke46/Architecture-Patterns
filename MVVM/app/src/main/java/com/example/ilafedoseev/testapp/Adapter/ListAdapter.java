package com.example.ilafedoseev.testapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilafedoseev.testapp.Model.Item;
import com.example.ilafedoseev.testapp.R;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<Item> mListItems;

    public ListAdapter(Context context, ArrayList<Item> listItems) {

        this.mContext = context;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mListItems = listItems;
    }

    @Override
    public int getCount() {
        return mListItems.size();
    }

    @Override
    public Item getItem(int position) {
        return mListItems.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
           view = mLayoutInflater.inflate(R.layout.item, viewGroup, false);
        }

        final Item item = getItem(position);

        LinearLayout mainLayout = view.findViewById(R.id.main_layout);
        TextView symbol = view.findViewById(R.id.symbol);
        TextView name = view.findViewById(R.id.name);
        TextView webSlug = view.findViewById(R.id.web_slug);

        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mContext.getString(R.string.Item_id) + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        symbol.setText(item.getSymbol());
        name.setText(mContext.getString(R.string.name) + item.getName());
        webSlug.setText(mContext.getString(R.string.website_slug) + item.getName());

        return view;
    }
}
