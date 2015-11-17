package com.utility.cric_grap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.ashok.android.cric_grap.R;
import com.ashok.android.cric_grap.ScoreBoard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANDROID on 16-11-2015.
 */

public class Custom_List_Adapter extends ArrayAdapter<Player_Info> {
    public static List<Player_Info> items;
    private Context context;
    private int resource;
    Holder holder = null;

    public Custom_List_Adapter(Context context, int resource, ArrayList<Player_Info> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.items = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        try {
            View vi = convertView;

            if (convertView == null) {
                LayoutInflater inflater = ((Activity) context)
                        .getLayoutInflater();
                vi = inflater.inflate(resource, parent, false);
                holder = new Holder();
                holder.username = (TextView) vi.findViewById(R.id.userName);
                vi.setTag(holder);

            } else {
                holder = (Holder) vi.getTag();

            }
            if (items.size() <= 0) {
                holder.username.setText("No Data");
            } else {

                holder.username.setText(items.get(position).getPlayer_name());
                vi.setOnClickListener(new OnItemClick(position));
            }
            return vi;
        } catch (Exception vi) {
            vi.printStackTrace();
        }

        return null;
    }

    public class Holder {

        TextView username;
    }

    private class OnItemClick implements View.OnClickListener {
        private int mPosition;

        public OnItemClick(int position) {
            // TODO Auto-generated constructor stub
            mPosition = position;
        }

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent intent=new Intent(context.getApplicationContext(), ScoreBoard.class);
            intent.putExtra("mPosition",mPosition);
            context.startActivity(intent);
            Toast.makeText(context, items.get(mPosition).getPlayer_name(), Toast.LENGTH_SHORT).show();

        }
    }
}
