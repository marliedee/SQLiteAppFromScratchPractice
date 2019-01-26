package org.pursuit.sqliteappfromscratch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import org.pursuit.sqliteappfromscratch.controller.SQLiteViewAdapter;

public class MainActivity extends AppCompatActivity {
    private Button buttonNext;
    private Button buttonDisplay;
    private Intent intent;
    private Intent intentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, NoteActivity.class);
                startActivity(intent);

            }
        });

        buttonDisplay = findViewById(R.id.buttonDisplay);
        buttonDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentView = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intentView);
            }
        });


    }
}
