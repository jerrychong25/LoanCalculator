package my.com.codeplay.loancalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private long delay = 1000;
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            startActivity(new Intent(MainActivity.this,
                    CalculatorActivity.class));
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timer timer = new Timer();
        timer.schedule(task, delay);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1){
            if(resultCode== Activity.RESULT_OK) {
                String name = data.getStringExtra("COL_NAME");
            }
        }
    }
}
