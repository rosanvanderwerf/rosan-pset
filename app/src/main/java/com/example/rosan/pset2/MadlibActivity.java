package com.example.rosan.pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class MadlibActivity extends AppCompatActivity {

    Button submit;
    EditText inputWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madlib);

        // Initialize views
        inputWord = (EditText) findViewById(R.id.inputWord);
        submit = (Button) findViewById(R.id.submit);

        Intent intent = getIntent();
        Story story = (Story)intent.getSerializableExtra("story");

        /* Display x words left */
        int count = story.getPlaceholderRemainingCount();
        TextView counter = (TextView) findViewById(R.id.counter);
        counter.setText(String.format("%d", count));

        /* Get placeholder */
        String holder = story.getNextPlaceholder();
        TextView wordType = (TextView) findViewById(R.id.wordType);
        wordType.setText(holder);
    }

    public void display(View view) {
        Intent intent = getIntent();
        Story story = (Story)intent.getSerializableExtra("story");

        /* inputWord into placeholders */
        String commit = inputWord.getText().toString();
        story.fillInPlaceholder(commit);

        /* Clear inputWord */
        inputWord = (EditText) findViewById(R.id.inputWord);
        inputWord.setText("");

        /* Get next placeholder adj, noun */
        String holder = story.getNextPlaceholder();
        TextView wordType = (TextView) findViewById(R.id.wordType);
        wordType.setText(holder);

        /* Display x words left */
        int count = story.getPlaceholderRemainingCount();
        TextView counter = (TextView) findViewById(R.id.counter);
        counter.setText(String.format("%d", count));

        /* Get placeholder */
        wordType.setText(holder);

        /* If all inputWords are filled in */
        if (story.isFilledIn() == true) {
            Intent toDisplay = new Intent(this,DisplayActivity.class);

            toDisplay.putExtra("story",story);

            startActivity(toDisplay);
        }
    }
}
