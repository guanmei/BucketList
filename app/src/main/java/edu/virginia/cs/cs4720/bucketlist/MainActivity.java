package edu.virginia.cs.cs4720.bucketlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> itemList = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Bucket List", "MainActivity onCreate");
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, itemList);

        listView.setOnItemClickListener(mMessageClickHandler);
        listView.setAdapter(adapter);

        displayList();
    }

    private AdapterView.OnItemClickListener mMessageClickHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            Toast.makeText(getApplicationContext(), itemList.get(position), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Bucket List", "MainActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Bucket List", "MainActivity onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Bucket List", "MainActivity onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Bucket List", "MainActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Bucket List", "MainActivity onStop");
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

    public void addItem(View view) {
        EditText editText = (EditText)findViewById(R.id.textView);
        itemList.add(editText.getText().toString());
        adapter.notifyDataSetChanged();
        Log.d("BuildingListView", itemList.toString());
    }

    private void displayList() {
        ArrayList<String> thingsToDo = new ArrayList<String>();
        itemList.add("Visit Monticello");
        itemList.add("Hug Ms. Kathy");
        itemList.add("Pick apples at Carter's Mountain");
        itemList.add("Volunteer through Madison House");
        itemList.add("Stargaze on the Lawn");
        itemList.add("Tube down the James River");
        itemList.add("Visit Carr's Hill");
        itemList.add("Relive O'Hill Brunch");
        itemList.add("Ice skate Downtown");
        itemList.add("Eat at a food truck");
        itemList.add("Make a poster for a basketball game");
        itemList.add("Attend Tom Tom Festival");
        itemList.add("Celebrate Lighting of the Lawn");
        itemList.add("Play in Mad Bowl");
        itemList.add("Run the 4th Year 5K");
        itemList.add("Jam at Fridays After Five");
        itemList.add("Appreciate a horse at Foxfield");
        itemList.add("Eat at Duck Donuts");
        itemList.add("Witness a Probate");
        itemList.add("Visit a Pavilion Resident");
    }
}
