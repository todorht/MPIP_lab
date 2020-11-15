package mk.ukim.finki.lab_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    Button implicitActivity;
    Button share;
    Button photo;
    Button explicitActivity;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        textView = findViewById(R.id.textView);
        Intent intent = getIntent();
        String str = intent.getStringExtra("type");
        textView.setText(str);

        explicitActivity = findViewById(R.id.explicitActivity);
        explicitActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ExplicitActivity.class));
            }
        });

        implicitActivity = findViewById(R.id.implicitActivity);
        implicitActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(MainActivity.this,ImplicitActivity.class);
                mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(mainIntent);
            }
        });

        share = findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = textView.getText().toString();
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                intent1.putExtra(Intent.EXTRA_SUBJECT,"naslov");
                intent1.putExtra(Intent.EXTRA_TEXT,string);
                startActivity(Intent.createChooser(intent1,"Send text via"));
            }
        });

        photo = findViewById(R.id.photo);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickPhoto = new Intent(Intent.ACTION_VIEW, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivity(pickPhoto);
            }
        });
    }
}