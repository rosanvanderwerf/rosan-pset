package com.example.rosan.pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityMain extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toSelection(View view) {

        Intent selection = new Intent(ActivityMain.this,SelectionActivity.class);
        startActivity(selection);
        finish();
    }
}
