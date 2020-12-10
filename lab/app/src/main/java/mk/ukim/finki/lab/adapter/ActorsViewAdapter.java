package mk.ukim.finki.lab.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import mk.ukim.finki.lab.R;
import mk.ukim.finki.lab.model.Actor;

public class ActorsViewAdapter<T>  extends BaseAdapter {

    private Context context;
    private List<Actor> actors;

    public ActorsViewAdapter(Context context, List<Actor> actors){
        this.context = context;
        this.actors = actors;
    }

    @Override
    public int getCount() {
        return actors.size();
    }

    @Override
    public Object getItem(int position) {
        return actors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.actors,null,false);
        }
        Actor actor = actors.get(position);
        TextView name = convertView.findViewById(R.id.actorName);
        TextView surname = convertView.findViewById(R.id.actorSurname);
        name.setText(actor.getName());
        surname.setText(actor.getSurname());
        return convertView;
    }
}
