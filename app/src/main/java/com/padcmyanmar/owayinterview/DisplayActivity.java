package com.padcmyanmar.owayinterview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DisplayActivity extends AppCompatActivity {

    @BindView(R.id.txt_result)
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        ButterKnife.bind(this, this);

        //sent data from main to display activity
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MESSAGE);

        //set data to screen
        txtResult.setText(message);
    }

    @Override
    public void onResume() {
        super.onResume();

        // Display the back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    // Back arrow click event to go to the parent Activity
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
