package mk.ukim.finki.lab_intents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import mk.ukim.finki.lab_intents.adapter.ListViewAdapter;

public class ImplicitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        ListView listView = findViewById(R.id.listView);

        Intent mainIntent = new Intent(Intent.ACTION_MAIN,null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> appList = getApplicationContext().getPackageManager().queryIntentActivities(mainIntent,0);

        ListViewAdapter<ResolveInfo> adapter = new ListViewAdapter<ResolveInfo>(this, appList);
       // ArrayAdapter<ResolveInfo> arrayAdapter = new ArrayAdapter<ResolveInfo>(this, android.R.layout.simple_list_item_1, appList);

        listView.setAdapter(adapter);

    }
}