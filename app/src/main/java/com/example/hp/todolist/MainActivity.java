package com.example.hp.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    public Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.Btn1);
        button.setOnClickListener(new View.OnClickListeners() {

                                      public void onclick(view v) {

                                          Intent intent = new Intent(MainActivity.this, Main2Activity2.class);
                                       startActivity(intent);
                                      }

                                  }

        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        }


        public void loginBtn(View view){

        String user = user.getText().tostring();
        String pass = pass.getText().tostring();

        background bg = new background();
        bg.execute(user,pass);




        }
}
