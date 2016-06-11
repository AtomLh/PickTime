package com.example.tanglianghui.picktime.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tanglianghui.picktime.Adapters.MyRecyclerViewAdapter;
import com.example.tanglianghui.picktime.R;
import com.example.tanglianghui.picktime.database.DairyDB;
import com.example.tanglianghui.picktime.model.Dairy;

import java.util.List;

public class entriesFragment extends Fragment {
     RecyclerView recyclerView;
     List<Dairy>  myDate;
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_entries, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
         recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
         myDate = DairyDB.getInstance(container.getContext()).loadDairies();
        recyclerView.setAdapter(new MyRecyclerViewAdapter(R.layout.entries_item,myDate));
        return view;
    }




}
