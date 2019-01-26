package org.pursuit.sqliteappfromscratch.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.sqliteappfromscratch.R;
import org.pursuit.sqliteappfromscratch.model.Notes;
import org.pursuit.sqliteappfromscratch.view.SQLiteViewHolder;

import java.util.Collections;
import java.util.List;


public class SQLiteViewAdapter extends RecyclerView.Adapter <SQLiteViewHolder>{
    private static String textList;
    private static String messageList;

    public SQLiteViewAdapter(String textList,String messageList) {
        this.textList = textList;
        this.messageList = messageList;
    }

    public SQLiteViewAdapter(List<String> note) {

    }

    @Override
    public SQLiteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.textview_list, viewGroup, false);
        return new SQLiteViewHolder(childView);      }

    @Override
    public void onBindViewHolder(@NonNull SQLiteViewHolder sqLiteViewHolder, int i) {
        String name = textList;
        String message = messageList;
        sqLiteViewHolder.onBind(name, Collections.singletonList(message));

    }

    @Override
    public int getItemCount() {
        return 0;

    }
}
