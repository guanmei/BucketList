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
import android.widget.CheckedTextView;
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
            CheckedTextView checkedTextView = (CheckedTextView)v;
            boolean itemIsChecked = ((CheckedTextView) v).isChecked();
            if(!itemIsChecked) {
                Toast.makeText(getApplicationContext(), itemList.get(position).substring(4) + " completed!", Toast.LENGTH_SHORT).show();
            }
            ((CheckedTextView) v).setChecked(!itemIsChecked);
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
/*
    public void addItem(View view) {
        EditText editText = (EditText)findViewById(R.id.textView);
        itemList.add(editText.getText().toString());
        adapter.notifyDataSetChanged();
        Log.d("BuildingListView", itemList.toString());
    }*/

    private void displayList() {
        ArrayList<String> thingsToDo = new ArrayList<String>();
        itemList.add(" 1. Visit Monticello");
        itemList.add(" 2. Hug Ms. Kathy");
        itemList.add(" 3. Pick apples at Carter's Mountain");
        itemList.add(" 4. Volunteer through Madison House");
        itemList.add(" 5. Stargaze on the Lawn");
        itemList.add(" 6. Tube down the James River");
        itemList.add(" 7. Visit Carr's Hill");
        itemList.add(" 8. Relive O'Hill Brunch");
        itemList.add(" 9. Ice skate Downtown");
        itemList.add("10. Eat at a food truck");
        itemList.add("11. Make a poster for a basketball game");
        itemList.add("12. Attend Tom Tom Festival");
        itemList.add("13. Celebrate Lighting of the Lawn");
        itemList.add("14. Play in Mad Bowl");
        itemList.add("15. Run the 4th Year 5K");
        itemList.add("16. Jam at Fridays After Five");
        itemList.add("17. Appreciate a horse at Foxfield");
        itemList.add("18. Eat at Duck Donuts");
        itemList.add("19. Witness a Probate");
        itemList.add("20. Visit a Pavilion Resident");
    }
}
