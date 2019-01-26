package org.pursuit.sqliteappfromscratch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.pursuit.sqliteappfromscratch.database.SQLiteSingleton;
import org.pursuit.sqliteappfromscratch.model.Notes;

import java.sql.SQLException;
import java.util.zip.DataFormatException;

public class NoteActivity extends AppCompatActivity {
private EditText editTextName;
private EditText editTextMessage;
private Button button;
private SQLiteSingleton databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        editTextName = findViewById(R.id.edit_text);
        editTextMessage = findViewById(R.id.edit_text_two);
        button = findViewById(R.id.buttonNote);
        databaseHelper = SQLiteSingleton.getInstance(getApplicationContext());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name = editTextName.getText().toString();
                    String message = editTextMessage.getText().toString();
                    Notes note = new Notes(name, message);
                    databaseHelper.addNotes(note);
                    Toast toast = Toast.makeText(getApplicationContext(), "This is a message has been added.", Toast.LENGTH_LONG);
                    toast.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < databaseHelper.getNoteList().size(); i++) {

                    Log.d("database row", databaseHelper.getNoteList().get(i).getName() + " " +
                            databaseHelper.getNoteList().get(i).getMessage());

                }
            }

        });

    }
}
