package com.hrw.mineloainganimview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hrw.loainganimviewlibrary.ball.BallAnimView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final BallAnimView ballAnimView = findViewById(R.id.bav_base_loading_anim);
        ballAnimView.startAnimator();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ballAnimView.stopAnimator();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
