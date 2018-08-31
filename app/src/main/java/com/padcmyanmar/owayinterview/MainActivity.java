package com.padcmyanmar.owayinterview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edt_first_name)
    EditText editFirstName;

    @BindView(R.id.edt_last_name)
    EditText editLastName;

    @BindView(R.id.edt_fav_food)
    EditText editFavFood;

    @BindView(R.id.edt_fav_number)
    EditText editFavNumber;

    @BindView(R.id.btn_submit)
    Button btnSubmit;

    public static final String MESSAGE = "com.padcmyanmar.owayinterview.login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        // submit button action
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // form null check
                if ((editFirstName.getText().toString().equals("")) ||
                        (editLastName.getText().toString().equals("")) ||
                        (editFavFood.getText().toString().equals("")) ||
                        (editFavNumber.getText().toString().equals(""))) {
                    if (editFirstName.getText().toString().equals("")) {
                        Toast.makeText(MainActivity.this, " Fill First Name",
                                Toast.LENGTH_SHORT).show();
                    }
                    if (editLastName.getText().toString().equals("")) {
                        Toast.makeText(MainActivity.this, "Fill Last Name", Toast.LENGTH_SHORT).show();
                    }

                    if (editFavFood.getText().toString().equals("")) {
                        Toast.makeText(MainActivity.this, "Fill Favourite Food",
                                Toast.LENGTH_SHORT).show();
                    }
                    if (editFavNumber.getText().toString().equals("")) {
                        Toast.makeText(MainActivity.this, "Fill Favorite Number",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    logicSuccess();
                    Toast.makeText(MainActivity.this, "Success",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // call logicSuccess() when form's data are not null
    public void logicSuccess() {

        //send next screen when success
        Intent intent = new Intent(MainActivity.this, DisplayActivity.class);

        //get data from login form
        String firstName = editFirstName.getText().toString();
        String lastName = editLastName.getText().toString();
        String favFood = editFavFood.getText().toString();
        String favNumber = editFavNumber.getText().toString();

        String message = " ";
        int firstNum = 0;
        int secNum = 0;
        int thirdNum = 1;

        List<String> favList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            firstNum = secNum;
            secNum = thirdNum;
            thirdNum = firstNum + secNum;
            favList.add(String.valueOf(firstNum));
        }

        //check favourite number is fibonacci number or not
        if (favList.contains(favNumber)) {
            message += "Hello " + firstName + ", ";
            message += "today is your lucky day with your favourite number " + favNumber + ".";
        } else {
            message += "Hello Mr/Ms " + lastName + ", ";
            message += "I love " + favFood + " too. Lets go get that for lunch today.";
        }

        //send data to next screen
        intent.putExtra(MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
