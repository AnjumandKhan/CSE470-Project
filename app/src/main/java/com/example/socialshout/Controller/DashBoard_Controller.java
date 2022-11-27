package com.example.socialshout.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.socialshout.Model.DashBoard_Model;
import com.example.socialshout.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashBoard_Controller extends AppCompatActivity {

    FloatingActionButton floatingActionButton;

    DashBoard_Model dashBoard_model;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board2);
        floatingActionButton = findViewById(R.id.dashboard_floating_actionButton);
        recyclerView = findViewById(R.id.dashBoard_recView);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), addVideo_Controller.class));
                finish();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        dashBoard_model = new DashBoard_Model(getApplicationContext());
        FirebaseRecyclerAdapter firebaseRecyclerAdapter = dashBoard_model.fetch_Value_From_FireBase_Adapter(); // getting all the videos value from databse
        firebaseRecyclerAdapter.startListening(); // setting the adapter
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    // for menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // for menu item selected=
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_manageProfile:
                startActivity(new Intent(getApplicationContext(), userProfile_Controller.class));
                finish();
            /*case R.id.menu_explore:
                startActivity(new Intent(getApplicationContext(), explore_Controller.class));
                finish();*/
        }
        return super.onOptionsItemSelected(item);
    }

}