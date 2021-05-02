package com.example.lecture_10_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button button;
    EditText editText;
    ArrayList<String> friendArrayList;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        button = findViewById(R.id.addbutton);
        editText = findViewById(R.id.plaintext);

        String [] friendlist = {"Android", "iphone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu", "windows7", "Mac OS X"};
        friendArrayList = new ArrayList<String>();
        friendArrayList.add("Android");
        friendArrayList.add("WindowsMobile");
        friendArrayList.add("iphone");
        friendArrayList.add("Ubuntu");
        friendArrayList.add("Blackberry");
        friendArrayList.add("windows7");
        friendArrayList.add("WebOS");
        friendArrayList.add("Mac OS X");
        //arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, friendlist);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, friendArrayList );
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("You clicked", friendArrayList.get(position));

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("Friend Name", friendArrayList.get(position));
                startActivity(intent);
            }
        });
    }

    public void AddName(View view) {
        friendArrayList.add(editText.getText().toString());
        //listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();

        Collections.sort(friendArrayList);

    }
}