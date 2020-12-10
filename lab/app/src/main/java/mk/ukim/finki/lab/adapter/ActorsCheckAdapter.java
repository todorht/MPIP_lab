package mk.ukim.finki.lab.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import mk.ukim.finki.lab.model.Actor;

public class ActorsCheckAdapter<T> extends BaseAdapter {
    private Context context;
    private List<Actor> actors;

    public ActorsCheckAdapter(Context context, List<Actor> actors){
        this.context = context;
        this.actors = actors;
    }

    @Override
    public int getCount() {
        return actors.size();
    }

    @Override
    public Actor getItem(int position) {
        return actors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_multiple_choice,null,false);
        }
        Actor actor = actors.get(position);
        TextView name = convertView.findViewById(android.R.id.text1);
        name.setText(String.format("%s %s", actor.getName(), actor.getSurname()));
        return convertView;
    }
}
