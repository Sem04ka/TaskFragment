package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button currButton,complButton,homebutton;
    CurrentTaskFragment currentTaskFragment;
    CompleteTaskFragment completeTaskFragment;
    HomeTask homeTask;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currButton=findViewById(R.id.curr_button);
        complButton=findViewById(R.id.compl_button);
        completeTaskFragment=new CompleteTaskFragment();
        currentTaskFragment=new CurrentTaskFragment();
        homeTask=new HomeTask();

        fragmentManager=getSupportFragmentManager();
        homebutton=findViewById(R.id.home_button);
        if(savedInstanceState==null){
            FragmentTransaction ft=fragmentManager.beginTransaction();
            ft.add(R.id.container,currentTaskFragment);
            ft.commit();
        }

            complButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction ft=fragmentManager.beginTransaction();
                    ft.replace(R.id.container,completeTaskFragment);
                    ft.commit();
                }
            });
            currButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction ft=fragmentManager.beginTransaction();
                    ft.replace(R.id.container,currentTaskFragment);
                    ft.commit();
                }
            });
            homebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction ft=fragmentManager.beginTransaction();
                    ft.replace(R.id.container,homeTask);
                    ft.commit();
                }
            });
    }
}