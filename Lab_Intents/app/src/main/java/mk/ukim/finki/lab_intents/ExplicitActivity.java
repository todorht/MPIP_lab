package mk.ukim.finki.lab_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExplicitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);
        Button cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExplicitActivity.this,MainActivity.class));
            }
        });
        Button send = findViewById(R.id.send);
        EditText type = findViewById(R.id.inputText);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = type.getText().toString();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("type",text);
                startActivity(intent);
            }
        });
    }
}