package com.app.companyfp_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.app.companyfp_app.adapter.AutoFitGridLayoutManager;
import com.app.companyfp_app.adapter.DataModel;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {


    RecyclerView recyclerView;
    ArrayList<DataModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();
        arrayList.add(new DataModel("Students", R.drawable.students, "#09A9FF"));
        arrayList.add(new DataModel("Inventario", R.drawable.computers, "#3E51B1"));
        arrayList.add(new DataModel("Teachers", R.drawable.students, "#673BB7"));
        arrayList.add(new DataModel("Agenda", R.drawable.agenda, "#4BAA50"));
        arrayList.add(new DataModel("Informes", R.drawable.reports, "#F94336"));
        arrayList.add(new DataModel("Avisos", R.drawable.avisos, "#0A9B88"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList, this);
        recyclerView.setAdapter(adapter);


        /**
         AutoFitGridLayoutManager that auto fits the cells by the column width defined.
         **/

        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
        recyclerView.setLayoutManager(layoutManager);


        /**
         Simple GridLayoutManager that spans two columns
         **/
        /*GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);*/
    }

    @Override
    public void onItemClick(DataModel item) {

        switch (item.text) {
            case "Students":
                startActivity(new Intent(this,StudentsActivity.class));
        }
    }
}
