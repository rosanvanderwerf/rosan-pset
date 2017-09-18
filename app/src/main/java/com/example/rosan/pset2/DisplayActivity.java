package com.example.rosan.pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        /* Get intent: newText */
        Intent intent = getIntent();
        Story story = (Story) intent.getSerializableExtra("story");

        String madlib = story.toString();

        TextView received = (TextView) findViewById(R.id.finalText);
        received.setText(madlib);

        story.clear();
        }

    /* Go to ActivityMain when back button is pressed. */
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this,ActivityMain.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);
    }

    /* Attempt in saving a word, but should be used to save data upon rotation */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        TextView received = (TextView) findViewById(R.id.finalText);
        String commitValue = received.getText().toString();
        outState.putString("commit",commitValue);
    }

    @Override
    public void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);

        TextView received = (TextView) findViewById(R.id.finalText);
        String commitRestored = inState.getString("commit");
        received.setText(commitRestored);
    }
}
