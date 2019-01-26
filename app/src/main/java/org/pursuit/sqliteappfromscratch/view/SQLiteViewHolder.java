package org.pursuit.sqliteappfromscratch.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.sqliteappfromscratch.R;

import java.util.List;

public class SQLiteViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public SQLiteViewHolder(@NonNull View itemView) {
        super(itemView);
        textView =itemView.findViewById(R.id.text2);

    }
    public void onBind (String name, List<String> message) {
        textView.getText().toString();

    }
}
