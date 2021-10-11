package ru.sokoltechvision.wwhtu_java;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.TextView;


import org.joda.time.LocalTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

   // private View start;

    private String[] MORN1;
    private String[] DIN1;
    private String[] DAY1;
    private String[] EVE1;
    private String[] NIGHT1;
    private String[] OVER1;

  /*  public String[] Tmorn;

    //утро ms
    public int tm_srt = 28800000;
    public int tm_end = 43200000;

    //обед ms
    public int tdi_srt = 43260000;
    public int tdi_end = 54000000;

    //день ms
    //public int

    //вечер ms


    //ночь ms


    //хуй ms
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //херачим ресы из файлов
        MORN1 = getResources().getStringArray(R.array.morning1);
        DIN1 = getResources().getStringArray(R.array.dinner);
        DAY1 = getResources().getStringArray(R.array.day1);
        EVE1 = getResources().getStringArray(R.array.eve);
        NIGHT1 = getResources().getStringArray(R.array.night);
        OVER1 = getResources().getStringArray(R.array.overnight);


        //выдираем время
        DateFormat DF = new SimpleDateFormat("HH:mm");
        String date = DF.format(Calendar.getInstance().getTime());








       // start = findViewById(R.id.button);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                YOBA();

              //  date.compareTo()
                //сраный алгоритм времени
                 _DAY1();
            }
        });
    }

    //ебанная хуйня не работает, удалить потом
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




    public void _MORN(){

        int randMornIndx = new Random().nextInt(MORN1.length);
        String randmornName = MORN1[randMornIndx];

        TextView outmor = (TextView) findViewById(R.id.textView2);
        outmor.setText(randmornName);
    }

    public void _DIN(){

        int randDinIndx = new Random().nextInt(DIN1.length);
        String randDinName = DIN1[randDinIndx];

        TextView outDin = (TextView) findViewById(R.id.textView2);
        outDin.setText(randDinName);
    }

    public void _DAY1(){

        int randomIndex = new Random().nextInt(DAY1.length);
        String randomName = DAY1[randomIndex];


        TextView out = (TextView) findViewById(R.id.textView2);
        out.setText(randomName);
    }

    public void _EVE(){

        int randEveIndx = new Random().nextInt(EVE1.length);
        String randEveName = EVE1[randEveIndx];

        TextView outEve = (TextView) findViewById(R.id.textView2);
        outEve.setText(randEveName);
    }

    public void _NIGHT(){

        int randNightIndx = new Random().nextInt(NIGHT1.length);
        String randNightName = NIGHT1[randNightIndx];

        TextView outNight = (TextView) findViewById(R.id.textView2);
        outNight.setText(randNightName);
    }

    public void _OVER(){

        int randOverIndx = new Random().nextInt(OVER1.length);
        String randOverName = OVER1[randOverIndx];

        TextView outOver = (TextView) findViewById(R.id.textView2);
        outOver.setText(randOverName);
    }


    //проверка функции
    public void YOBA(){
        LocalTime now = LocalTime.now();
        LocalTime start = new LocalTime(13,0,0,0);
        LocalTime end = new LocalTime(22,0,0,0);

        TextView outnow = (TextView) findViewById(R.id.textView_tmNow);
        TextView outstart = (TextView) findViewById(R.id.textView_tmstart);
        TextView outend = (TextView) findViewById(R.id.textView_tmEnd);

        String nowS = now.toString();
        String strS = start.toString();
        String endS= end.toString();

        outnow.setText(nowS);
        outstart.setText(strS);
        outend.setText(endS);


    }
}