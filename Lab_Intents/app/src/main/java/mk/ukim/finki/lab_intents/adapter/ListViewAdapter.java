package mk.ukim.finki.lab_intents.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import mk.ukim.finki.lab_intents.R;

public class ListViewAdapter<T> extends BaseAdapter{

    private Context context;
    private List<ResolveInfo> appInfo;

    public ListViewAdapter(Context context, List<ResolveInfo> appInfo){
        this.context = context;
        this.appInfo = appInfo;
    }

    @Override
    public int getCount() {
        return appInfo.size();
    }

    @Override
    public Object getItem(int position) {
        return appInfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row, null, false);
        }

        ResolveInfo info = appInfo.get(position);

        TextView appInfoText = convertView.findViewById(R.id.appInfo);

        appInfoText.setText(info.activityInfo.applicationInfo.name);

        return convertView;
    }
}
