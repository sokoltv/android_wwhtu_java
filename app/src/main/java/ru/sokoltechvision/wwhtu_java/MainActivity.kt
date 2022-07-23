package ru.sokoltechvision.wwhtu_java;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.TextView;


import org.joda.time.LocalTime;

import java.security.PublicKey;
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
  /*  public int _NT;
    public int _MTB;
    public int _MTE;
    public int _DTB;
    public int _DTE;
    public int _DayTB;
    public int _DayTE;
    public int _EvTB;
    public int _EvTE;
    public int _NightTB;
    public int _nightTE;
    public int _OverTB;
    public int _OverTE;

*/
   public LocalTime NowTime = LocalTime.now();
   public int _NTh = NowTime.getHourOfDay();
   public int _NTm = NowTime.getMinuteOfHour();
   public int _NTs = NowTime.getSecondOfMinute();
   public int _NTms = NowTime.getMillisOfSecond();
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
   //     DateFormat DF = new SimpleDateFormat("HH:mm");
    //    String date = DF.format(Calendar.getInstance().getTime());


        // Утро
        LocalTime MornTimeBegin = new LocalTime(8,0,0,0);

        int _MornT_Bh = MornTimeBegin.getHourOfDay();

        LocalTime MornTimeEnd = new LocalTime(12,0,59,99);

        int _MornT_Eh = MornTimeEnd.getHourOfDay();
        int _MornT_Em = MornTimeEnd.getMinuteOfHour();
        int _MornT_Es = MornTimeEnd.getSecondOfMinute();
        int _MornT_Ems = MornTimeEnd.getMillisOfSecond();

        // Обед
        LocalTime DinTimeBegin = new LocalTime(12,1,0,0);
        LocalTime DinTimeEnd = new LocalTime(15,0,59,99);

        // День
        LocalTime DayTimeBegin = new LocalTime(15,1,0,0);
        LocalTime DayTimeEnd = new LocalTime(17,30,59,99);

        // Вечер
        LocalTime EveTimeBegin = new LocalTime(17,31,0,0);
        LocalTime EveTimeEnd = new LocalTime(20,30,59,99);

        // Ночь
        LocalTime NightTimeBegin = new LocalTime(20,31,0,0);
        LocalTime NightTimeEnd = new LocalTime(23,59,59,99);

        // OverNight
        LocalTime OverTimeBegin = new LocalTime(0,0,0,0);
        LocalTime OverTimeEnd = new LocalTime(7,59,59,99);

        int _OverTB_h = OverTimeBegin.getHourOfDay();
        int _OverTB_m = OverTimeBegin.getMinuteOfHour();
        int _OverTB_s = OverTimeBegin.getSecondOfMinute();
        int _OverTB_ms = OverTimeBegin.getMillisOfSecond();

        int _OverTE_h = OverTimeEnd.getHourOfDay();
        int _OverTE_m = OverTimeEnd.getMinuteOfHour();
        int _OverTE_s = OverTimeEnd.getSecondOfMinute();
        int _OverTE_ms = OverTimeEnd.getMillisOfSecond();




        // Опять костыли





       // start = findViewById(R.id.button);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                YOBA();

                if (_NTh >= _OverTB_h){
                    if (_NTh <= _OverTE_h){
                        _OVER();
                    }
                    if (_NTh <= _MornT_Eh && _NTh >= _MornT_Bh){
                        _MORN();
                    }

                }
                else {

                    _DAY1();
                }

     /*           if (_NT2 > _OverTB2){
                    if (_NT2 < _OverTE2){

                        _OVER();

                    }
                    else if (_NT <= _MTE){

                        _MORN();
                    }
                    else if (_NT <= _DTE){

                        _DIN();
                    }
                    else if (_NT <= _DayTE){
                        _DAY1();
                    }
                    else if (_NT <= _EvTE){

                        _EVE();
                    }
                    else if (_NT <= _nightTE){

                        _NIGHT();
                    }
                }
                else {

                    _DAY1();
                }
*/
                //  date.compareTo()
                //сраный алгоритм времени
                 // _DAY1();
            }
        });
    }





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
        int _n = 0;
        int _s = 0;
        int _e = 0;

        long nowT = now.getMillisOfSecond();
        start.getValue(_s);
        end.getValue(_e);

        LocalTime OverTimeBeginLog = new LocalTime(0,0,0,0);
        LocalTime OverTimeEndLog = new LocalTime(7,59,59,99);


        TextView outnow = (TextView) findViewById(R.id.textView_tmNow);
        TextView outstart = (TextView) findViewById(R.id.textView_tmstart);
        TextView outend = (TextView) findViewById(R.id.textView_tmEnd);

        String nowS = now.toString();
        String strS = OverTimeBeginLog.toString();
        String endS= OverTimeEndLog.toString();

        outnow.setText(nowS);
        outstart.setText(strS);
        outend.setText(endS);


    }
}