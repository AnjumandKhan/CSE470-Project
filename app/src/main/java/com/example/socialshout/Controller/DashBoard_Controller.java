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
import android.widget.Toast;

import com.example.socialshout.Model.DashBoard_Model;
import com.example.socialshout.R;
import com.example.socialshout.login.login;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

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

        if(item.getItemId() == R.id.menu_explore){
            startActivity(new Intent(getApplicationContext(), explorer_controller.class));
            finish();
        }
        else if (item.getItemId() == R.id.menu_manageProfile){
            Toast.makeText(this, "Userprofile", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), userProfile_Controller.class));
            finish();
        }
        else if(item.getItemId() == R.id.menu_logOut){
            Toast.makeText(this, "Signing Out", Toast.LENGTH_SHORT).show();
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), login.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }
}