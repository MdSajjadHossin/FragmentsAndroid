package com.example.fragmentationandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1.findViewById(R.id.fragmentBtn1);
        button2.findViewById(R.id.fragmentBtn2);
        button3.findViewById(R.id.fragmentBtn3);

        loadFragment(new Dummy2Fragment(), 0);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new DummyFragment(), 1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Dummy2Fragment(), 1);
            }
        });

         button3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 loadFragment(new Dummy3Fragment(), 1);
             }
         });
    }

    public void loadFragment(Fragment fragment, int flag){
        FragmentManager fM = getSupportFragmentManager();
        FragmentTransaction fT = fM.beginTransaction();

//      DummyFragment dummyFragment = new DummyFragment();
        if(flag == 0)
            fT.add(R.id.frameContainer, fragment);
        else
            fT.replace(R.id.frameContainer, fragment);


        fT.commit();
    }
}