package com.room.myvocabuilder;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {

    public static final int ADD_REQUEST_CODE=1;

    private WordViewModel wordViewModel;

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabAccesAdapter myTabAccessAdapter;
    private FloatingActionButton floatingActionButton;

    public static FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.main_page_toolbar);
        floatingActionButton=(FloatingActionButton) findViewById(R.id.add_button_note);
        viewPager=(ViewPager)findViewById(R.id.main_tbs_pager);
        tabLayout= (TabLayout) findViewById(R.id.mainTab);


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Vocabuilder");

        myTabAccessAdapter = new TabAccesAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myTabAccessAdapter);
        tabLayout.setupWithViewPager(viewPager);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"click",Toast.LENGTH_LONG).show();

                Intent intent=new Intent(MainActivity.this,AddwordActivity.class);

                startActivity(intent);
            }
        });




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.main_menu,menu );

        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.About_id:
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    };
}
