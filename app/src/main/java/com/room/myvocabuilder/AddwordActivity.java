package com.room.myvocabuilder;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddwordActivity extends AppCompatActivity {


    public static final String EXTRA_ID =
            "com.room.myvocabuilder.EXTRA_ID";

    public static final String EXTRA_TITLE =
            "com.room.myvocabuilder.EXTRA_TITLE";

    public static final String EXTRA_MEANING =
            "com.room.myvocabuilder.EXTRA_MEANING";

    public static final String EXTRA_EXAMPLE =
            "com.room.myvocabuilder.EXTRA_EXAMPLE";

    public static final String EXTRA_DATE =
            "com.room.myvocabuilder.EXTRA_DATE";
    public static final String EXTRA_TIME =
            "com.room.myvocabuilder.EXTRA_TIME";

    private  EditText title;
    private  EditText meaning;
    private EditText example;
    private Toolbar toolbar;

    private WordRepository wordRepository;
    private WordViewModel wordViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addword);

        toolbar=(Toolbar)findViewById(R.id.edit_toolbar) ;
        title=(EditText)findViewById(R.id.edit_text_title);
        meaning=(EditText)findViewById(R.id.edit_text_meaning);
        example=(EditText)findViewById(R.id.edit_text_example);

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_close_black_24dp);

        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);
        setTitle("Note word");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_menu, menu);

        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.save_id:
                saveWord();
                //Toast.makeText(this,"saved word",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
    private void saveWord() {

        String WordTitle=title.getText().toString().trim();

        String Meaning=meaning.getText().toString().trim();

        String Example= example.getText().toString().trim();

        if (WordTitle.trim().isEmpty() || Meaning.trim().isEmpty() || Example.trim().isEmpty()) {
            Toast.makeText(this, "plese insert title & description", Toast.LENGTH_LONG).show();
            return;
        }

        Calendar calforDate= Calendar.getInstance();
        SimpleDateFormat currentDateFoemat= new SimpleDateFormat("MMM dd,yyyy");
        String date=currentDateFoemat.format(calforDate.getTime());

        Calendar calForTime= Calendar.getInstance();
        SimpleDateFormat currentTimeformat= new SimpleDateFormat("hh:mm a");
        String time=currentTimeformat.format(calForTime.getTime());

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE,WordTitle);
        data.putExtra(EXTRA_MEANING, Meaning);
        data.putExtra(EXTRA_EXAMPLE, Example);
        data.putExtra(EXTRA_DATE, date);
        data.putExtra(EXTRA_TIME, time);

        setResult(RESULT_OK,data);

        //Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();

        finish();

    }
}
