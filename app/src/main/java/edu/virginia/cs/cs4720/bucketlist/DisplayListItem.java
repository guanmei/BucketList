package edu.virginia.cs.cs4720.bucketlist;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class DisplayListItem extends AppCompatActivity {

    public int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_item);

    }

    @Override
    protected void onStart() {
        super.onStart();

        id = getIntent().getExtras().getInt("id");
        TextView titleText = (TextView)findViewById(R.id.title);
        titleText.setText(getIntent().getExtras().getString("title"));

        TextView descriptionText = (TextView)findViewById(R.id.description);
        descriptionText.setText(getIntent().getExtras().getString("description"));

        Switch toggleSwitch = (Switch)findViewById(R.id.toggleSwitch);
        boolean checked = getIntent().getExtras().getBoolean("completed");
        if(checked) {
            toggleSwitch.setChecked(true);
        } else {
            toggleSwitch.setChecked(false);
        }
    }

    public void returnOnClick(View v) {
        Switch toggleSwitch = (Switch)findViewById(R.id.toggleSwitch);
        boolean completed = toggleSwitch.isChecked();
        Intent intent = new Intent();
        intent.putExtra("id", id);
        intent.putExtra("completed", completed);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
