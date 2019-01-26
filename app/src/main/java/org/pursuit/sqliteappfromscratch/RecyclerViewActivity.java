package org.pursuit.sqliteappfromscratch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.pursuit.sqliteappfromscratch.controller.SQLiteViewAdapter;
import org.pursuit.sqliteappfromscratch.model.Notes;

import java.util.ArrayList;
import java.util.List;

import static org.pursuit.sqliteappfromscratch.model.Notes.message;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView sqlRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        List<String> note = new ArrayList<>();

        note.add(Notes.message);
        note.add(Notes.name);

        sqlRecycleView = findViewById(R.id.note_recyclerView);
        SQLiteViewAdapter imageAdapter = new SQLiteViewAdapter(note);
        sqlRecycleView.setAdapter(imageAdapter);
        sqlRecycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }
}
