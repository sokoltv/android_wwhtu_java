package ru.sokoltechvision.wwhtu_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

   // private View start;

    private String[] DAY1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DAY1 = getResources().getStringArray(R.array.day1);

       // start = findViewById(R.id.button);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _start();
            }
        });
    }

  /*  public void getAllResourceId() {
        final R.id idResources = new R.id();
        final Class<R.id> c = R.id.class;
        final java.lang.reflect.Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            final int resourceId;
            try {
                resourceId = field.getInt(idResources);
                Log.i("ID", "resourceId: " + resourceId + " Name:" + field.getName());

            } catch (Exception e) {
                Log.e("Exception", e.getLocalizedMessage());
            }
        }
    }
*/




    public void _start(){

        int randomIndex = new Random().nextInt(DAY1.length);
        String randomName = DAY1[randomIndex];


        TextView out= (TextView) findViewById(R.id.textView2);

        out.setText(randomName);

     /*   String[] Day1 = getResources().getStringArray(R.array.day1);
        for(int i = 0; i < Day1.length; i++) {




        } */
    }
}