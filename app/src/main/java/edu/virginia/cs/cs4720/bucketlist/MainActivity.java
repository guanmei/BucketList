package edu.virginia.cs.cs4720.bucketlist;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> itemList = new ArrayList<String>();
    ArrayList<ListItem> bucketList = new ArrayList<ListItem>();
    CheckAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Bucket List", "MainActivity onCreate");
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        adapter = new CheckAdapter(this, bucketList);

        listView.setOnItemClickListener(mMessageClickHandler);
        listView.setAdapter(adapter);

        try {
            displayList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private AdapterView.OnItemClickListener mMessageClickHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            System.out.println("adapter listener");
            Intent intent = new Intent(v.getContext(), DisplayListItem.class);
            ListItem selectedItem = bucketList.get((int)id);
            intent.putExtra("id", selectedItem.id);
            intent.putExtra("title", selectedItem.title);
            intent.putExtra("description", selectedItem.description);
            intent.putExtra("completed", selectedItem.completed);
            startActivityForResult(intent, 1);
        }
    };


    private class CheckAdapter extends ArrayAdapter<ListItem> {

        public CheckAdapter(Context context, ArrayList<ListItem> objects) {
            super(context, R.layout.checkview, R.id.text_view, objects);
        }

        private class ViewHolder {
            TextView name;
            CheckBox check;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ListItem l = bucketList.get(position);
            final ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.checkview, parent, false);
                holder.name = (TextView) convertView.findViewById(R.id.text_view);
                holder.check = (CheckBox) convertView.findViewById(R.id.cbox);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    l.completed = !l.completed;
                }
            });
            holder.check.setChecked(l.completed);

            holder.name.setText(l.title);

            return convertView;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int id = data.getIntExtra("id", 0);
        boolean completed = data.getBooleanExtra("completed", false);
        ListItem listItem = bucketList.get(id);
        listItem.completed = completed;
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //should go through bucketList and set checkboxes
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

    public void checkboxOnClick(View v) {
        CheckBox checkbox = (CheckBox)findViewById(R.id.cbox);
        System.out.println("other listener");
    }

    private void displayList() throws IOException {
        ArrayList<String> thingsToDo = new ArrayList<String>();
        AssetManager am = this.getAssets();
        Scanner sc = new Scanner(am.open("ListItems.txt"));
        while(sc.hasNext()) {
            ListItem li = new ListItem();
            li.id = Integer.parseInt(sc.nextLine());
            li.title = sc.nextLine();
            li.description = sc.nextLine();
            li.completed = false;
            itemList.add(li.title);
            bucketList.add(li);
        }
        sc.close();
   /*     itemList.add("Visit Monticello");
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
        itemList.add("Visit a Pavilion Resident");*/
    }
}
