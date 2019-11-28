package com.example.materiadesigndeno.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.materiadesigndeno.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("Android 5.0");
        toolbar.setSubtitle("Material Design Support控件");
        setSupportActionBar(toolbar);

        Button recycler=findViewById(R.id.recycler);
        Button tablayout=findViewById(R.id.tablayout);
        Button navigation=findViewById(R.id.navigation);
        Button coordinator=findViewById(R.id.coordinator);

        navigation.setOnClickListener(this);
        tablayout.setOnClickListener(this);
        recycler.setOnClickListener(this);
        coordinator.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.recycler:
                Intent intent = new Intent(MainActivity.this,RecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.coordinator:
                Intent intent1 = new Intent(MainActivity.this,CoordinatorActivity.class);
                startActivity(intent1);
                break;
            case R.id.tablayout:
                Intent intent2 = new Intent(MainActivity.this,TabLayoutActivity.class);
                startActivity(intent2);
                break;
            case R.id.navigation:
                Intent intent3 = new Intent(MainActivity.this,DrawerNavigationActivity.class);
                startActivity(intent3);
                break;
        }

    }
}
