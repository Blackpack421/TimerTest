package ajou.eslab.dkey.timertest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    Timer mTimer = new Timer();
    TextView tvHello;
    Button btnCancel, btnResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello = (TextView) findViewById(R.id.tvHello);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnResume = (Button) findViewById(R.id.btnResume);

        btnCancel.setOnClickListener(mOnClickListener);
        btnResume.setOnClickListener(mOnClickListener);

        mTimer.schedule(testTimerTask, 10000, 10000);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    TimerTask testTimerTask = new TimerTask() {
        @Override
        public void run() {
            //tvHello.setText("TIMER ACT!");
            Log.d("TEST.DKEY", "TIMER ACTIVE !!!");
        }
    };

    Button.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.btnCancel: {
                    //testTimerTask.cancel();
                    //Log.d("TEST.DKEY", "timertask cancel()");
                    //mTimer.cancel();
                    //Log.d("TEST.DKEY", "timer cancel()");
                    //mTimer.purge();
                    //Log.d("TEST.DKEY", "timer purge() canceled task");
                    stopTimer();
                    Log.d("TEST.DKEY", "stopTimer called");
                    break;
                }
                case R.id.btnResume: {
                    //mTimer.schedule(testTimerTask, 10000, 10000);
                    //Log.d("TEST.DKEY", "resume timertask! [Timer.schedule]");
                    restartTimer();
                    Log.d("TEST.DKEY", "startTimer called");
                    break;
                }
            }
        }
    };

    // finally, i choose below to stop/restart timer

    public void stopTimer(){
        if (testTimerTask !=null){
            testTimerTask.cancel();
            testTimerTask=null;
        }
        if (mTimer != null){
            mTimer.cancel();  mTimer.purge();
            mTimer=null;
        }
    }
    public void restartTimer(){
        mTimer = new Timer();
        testTimerTask = new TimerTask() {
            @Override
            public void run() {
                //tvHello.setText("TIMER ACT!");
                Log.d("TEST.DKEY", "TIMER ACTIVE !!!");
            }
        };
        mTimer.schedule(testTimerTask, 10000, 10000);
    }
}
