package ru.sokoltechvision.wwhtu_java

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.sokoltechvision.wwhtu_java.R
import android.widget.TextView
import org.joda.time.LocalTime
import java.util.*

class MainActivity : AppCompatActivity() {
    // private View start;
    private lateinit var MORN1: Array<String>
    private lateinit var DIN1: Array<String>
    private lateinit var DAY1: Array<String>
    private lateinit var EVE1: Array<String>
    private lateinit var NIGHT1: Array<String>
    private lateinit var OVER1: Array<String>

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
    var NowTime = LocalTime.now()
    var _NTh = NowTime.hourOfDay
    var _NTm = NowTime.minuteOfHour
    var _NTs = NowTime.secondOfMinute
    var _NTms = NowTime.millisOfSecond

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //херачим ресы из файлов
        MORN1 = resources.getStringArray(R.array.morning1)
        DIN1 = resources.getStringArray(R.array.dinner)
        DAY1 = resources.getStringArray(R.array.day1)
        EVE1 = resources.getStringArray(R.array.eve)
        NIGHT1 = resources.getStringArray(R.array.night)
        OVER1 = resources.getStringArray(R.array.overnight)


        //выдираем время
        //     DateFormat DF = new SimpleDateFormat("HH:mm");
        //    String date = DF.format(Calendar.getInstance().getTime());


        // Утро
        val MornTimeBegin = LocalTime(8, 0, 0, 0)
        val _MornT_Bh = MornTimeBegin.hourOfDay
        val MornTimeEnd = LocalTime(12, 0, 59, 99)
        val _MornT_Eh = MornTimeEnd.hourOfDay
        val _MornT_Em = MornTimeEnd.minuteOfHour
        val _MornT_Es = MornTimeEnd.secondOfMinute
        val _MornT_Ems = MornTimeEnd.millisOfSecond

        // Обед
        val DinTimeBegin = LocalTime(12, 1, 0, 0)
        val DinTimeEnd = LocalTime(15, 0, 59, 99)

        // День
        val DayTimeBegin = LocalTime(15, 1, 0, 0)
        val DayTimeEnd = LocalTime(17, 30, 59, 99)

        // Вечер
        val EveTimeBegin = LocalTime(17, 31, 0, 0)
        val EveTimeEnd = LocalTime(20, 30, 59, 99)

        // Ночь
        val NightTimeBegin = LocalTime(20, 31, 0, 0)
        val NightTimeEnd = LocalTime(23, 59, 59, 99)

        // OverNight
        val OverTimeBegin = LocalTime(0, 0, 0, 0)
        val OverTimeEnd = LocalTime(7, 59, 59, 99)
        val _OverTB_h = OverTimeBegin.hourOfDay
        val _OverTB_m = OverTimeBegin.minuteOfHour
        val _OverTB_s = OverTimeBegin.secondOfMinute
        val _OverTB_ms = OverTimeBegin.millisOfSecond
        val _OverTE_h = OverTimeEnd.hourOfDay
        val _OverTE_m = OverTimeEnd.minuteOfHour
        val _OverTE_s = OverTimeEnd.secondOfMinute
        val _OverTE_ms = OverTimeEnd.millisOfSecond


        // Опять костыли


        // start = findViewById(R.id.button);
        findViewById<View>(R.id.button).setOnClickListener {
            YOBA()
            if (_NTh >= _OverTB_h) {
                if (_NTh <= _OverTE_h) {
                    _OVER()
                }
                if (_NTh in _MornT_Bh.._MornT_Eh) {
                    _MORN()
                }
            } else {
                _DAY1()
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
    }

    fun _MORN() {
        val randMornIndx = Random().nextInt(MORN1.size)
        val randmornName = MORN1[randMornIndx]
        val outmor = findViewById<View>(R.id.textView2) as TextView
        outmor.text = randmornName
    }

    fun _DIN() {
        val randDinIndx = Random().nextInt(DIN1.size)
        val randDinName = DIN1[randDinIndx]
        val outDin = findViewById<View>(R.id.textView2) as TextView
        outDin.text = randDinName
    }

    fun _DAY1() {
        val randomIndex = Random().nextInt(DAY1.size)
        val randomName = DAY1[randomIndex]
        val out = findViewById<View>(R.id.textView2) as TextView
        out.text = randomName
    }

    fun _EVE() {
        val randEveIndx = Random().nextInt(EVE1.size)
        val randEveName = EVE1[randEveIndx]
        val outEve = findViewById<View>(R.id.textView2) as TextView
        outEve.text = randEveName
    }

    fun _NIGHT() {
        val randNightIndx = Random().nextInt(NIGHT1.size)
        val randNightName = NIGHT1[randNightIndx]
        val outNight = findViewById<View>(R.id.textView2) as TextView
        outNight.text = randNightName
    }

    fun _OVER() {
        val randOverIndx = Random().nextInt(OVER1.size)
        val randOverName = OVER1[randOverIndx]
        val outOver = findViewById<View>(R.id.textView2) as TextView
        outOver.text = randOverName
    }

    //проверка функции
    fun YOBA() {
        val now = LocalTime.now()
        val start = LocalTime(13, 0, 0, 0)
        val end = LocalTime(22, 0, 0, 0)
        val _n = 0
        val _s = 0
        val _e = 0
        val nowT = now.millisOfSecond.toLong()
        start.getValue(_s)
        end.getValue(_e)
        val OverTimeBeginLog = LocalTime(0, 0, 0, 0)
        val OverTimeEndLog = LocalTime(7, 59, 59, 99)
        val outnow = findViewById<View>(R.id.textView_tmNow) as TextView
        val outstart = findViewById<View>(R.id.textView_tmstart) as TextView
        val outend = findViewById<View>(R.id.textView_tmEnd) as TextView
        val nowS = now.toString()
        val strS = OverTimeBeginLog.toString()
        val endS = OverTimeEndLog.toString()
        outnow.text = nowS
        outstart.text = strS
        outend.text = endS
    }
}