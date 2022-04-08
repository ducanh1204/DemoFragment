package com.example.demofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnRemove,btnReplace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRemove = findViewById(R.id.btn_remove);
        btnReplace = findViewById(R.id.btn_replace);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.content_frame,new HomeFragment());
        fragmentTransaction.commitAllowingStateLoss();
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction12 = fragmentManager2.beginTransaction();
                Fragment fragment = fragmentManager2.findFragmentById(R.id.content_frame);
                if(fragment==null){
                    Toast.makeText(MainActivity.this, "sssss", Toast.LENGTH_SHORT).show();
                }
                else{
                    fragmentTransaction12.remove(fragment);
                    fragmentTransaction12.commitAllowingStateLoss();
                }
            }
        });

        btnReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction12 = fragmentManager2.beginTransaction();
                fragmentTransaction12.replace(R.id.content_frame,new MainFragment());
                fragmentTransaction12.commitAllowingStateLoss();
            }
        });
    }
}