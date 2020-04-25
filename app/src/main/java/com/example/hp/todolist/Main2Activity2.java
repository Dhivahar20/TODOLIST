package com.example.hp.todolist;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.M;

public class Main2Activity2 extends AppCompatActivity {

    DbHelper dbHelper;
    ArrayAdapter<String> adepter;
    ListView lstItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);

        dbHelper = new DbHelper(this);
        lstItems = (ListView) findViewById(R.id.lstItems);

        ShowItemlist();


    }

    private void ShowItemlist() {
        ArrayList<String> itemList = dbHelper.getToDoList();
        if (adapter == null) {

            adapter = new ArrayAdapter<String>(this, R.layout.row, R.id.item_title, itemList);
            lstItems.setAdapter(adepter);
        } else {

            adapter.clear();
            adapter.addAll(itemList);
            adapter.notifyDataSetchanged();

        }

    }

    public boolean oncreateoptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        //chang menu icon color
        Drawable icon = menu.getItem(0).getIcon();
        icon.mutate();
        if(RemoteInput.Builder.VERSION.SDK_INT>=M){
            icon.setColorFilter(Color.WHITE, porterDuff.Mode.SRC_IN);

        }
           return super.onCreateoptionsMenu(menu);

        }

        public boolean onoptionsItemSelected(MenuItem item){

        switch(item.getItemid()){
            case R.id.action_add_item:
                final EditText itemEditText = new EditText(this);
                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("Add New Item")
                        .setMessage("whats next")
                        .setView(itemEditText)
                        setpositiveButton("Add", new DialogInterface.OnClikListner() {

                            public void onClick(DialogInterface dialog,int which){
                                String item = String.valueOf(itemEditText.getText());
                                dbHelper.insertNewItem(item);
                                showItemList();

                                }
                                })

             .setNegativeButton("cancel" , null)
             .create();
              dialog.show();
              return true;

              }

              return super.onOptionsItemSelected(item);

              }

              public void deleteItem(View view){
            View parent = (View)view.getParent();
                  TextView itemTextView = (TextView) findViewById(R.id.item_title);
                  String item = String.valueOf(itemTextView.getText());
                  dbHelper.deleteItem(item);
                  showItemList();
                  
              }

        }