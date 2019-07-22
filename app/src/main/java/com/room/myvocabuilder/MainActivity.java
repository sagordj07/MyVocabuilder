package com.room.myvocabuilder;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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


        floatingActionButton.setOnClickListener(this);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.main_menu,menu );

        return  true;
    }

    @Override
    public void onClick(View v) {


    }
}
