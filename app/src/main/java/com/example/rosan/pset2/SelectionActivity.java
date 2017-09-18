package com.example.rosan.pset2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
    }

    public void toSimple(View view) {
        Intent intent = new Intent(SelectionActivity.this,MadlibActivity.class);

        AssetManager assetManager = getAssets();
        InputStream input;

        try {
            /* Get the storyText*/
            input = assetManager.open("madlib0_simple.txt");
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            String text = new String(buffer);

            InputStream stream;
            try {
                stream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8.name()));
                Story story = new Story(stream);

                intent.putExtra("story",story);
                startActivity(intent);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void toTarzan(View view) {
        Intent intent = new Intent(SelectionActivity.this,MadlibActivity.class);


        AssetManager assetManager = getAssets();
        InputStream input;

        try {
            input = assetManager.open("madlib1_tarzan.txt");
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            String text = new String(buffer);
            InputStream stream;
            try {
                stream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8.name()));
                Story story = new Story(stream);

                intent.putExtra("story",story);
                startActivity(intent);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toUniversity(View view) {
        Intent intent = new Intent(SelectionActivity.this,MadlibActivity.class);


        AssetManager assetManager = getAssets();
        InputStream input;

        try {
            input = assetManager.open("madlib2_university.txt");
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            String text = new String(buffer);
            InputStream stream;
            try {
                stream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8.name()));
                Story story = new Story(stream);

                intent.putExtra("story",story);
                startActivity(intent);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toClothes(View view) {
        Intent intent = new Intent(SelectionActivity.this,MadlibActivity.class);


        AssetManager assetManager = getAssets();
        InputStream input;

        try {
            input = assetManager.open("madlib3_clothes.txt");
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            String text = new String(buffer);
            InputStream stream;
            try {
                stream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8.name()));
                Story story = new Story(stream);

                intent.putExtra("story",story);
                startActivity(intent);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toDance(View view) {
        Intent intent = new Intent(SelectionActivity.this,MadlibActivity.class);


        AssetManager assetManager = getAssets();
        InputStream input;

        try {
            input = assetManager.open("madlib4_dance.txt");
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            String text = new String(buffer);
            InputStream stream;
            try {
                stream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8.name()));
                Story story = new Story(stream);

                intent.putExtra("story",story);
                startActivity(intent);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toRandom(View view) {
        Intent intent = new Intent(SelectionActivity.this,MadlibActivity.class);


        AssetManager assetManager = getAssets();
        InputStream input;

        // Create a 'randomizer'
        String[] stories = new String[] {"madlib0_simple.txt","madlib1_tarzan.txt","madlib2_university.txt","madlib3_clothes.txt","madlib4_dance.txt"};
        String randomStory = stories[new Random().nextInt(stories.length)];

        try {
            input = assetManager.open(randomStory);
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            String text = new String(buffer);
            InputStream stream;
            try {
                stream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8.name()));
                Story story = new Story(stream);

                intent.putExtra("story",story);
                startActivity(intent);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
