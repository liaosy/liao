package com.example.administrator.halo;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private  ProgressBar p;
    private TextView t;
    private Handler handler=new Handler();
    private int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         p= (ProgressBar) findViewById(R.id.progressBar);
         t=(TextView)findViewById(R.id.yeliangchen);
         p.setProgress(0);
        halo();
       /* kity k=new kity();
        k.execute();*/

    }
    /*class kity extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... params) {
            //publishProgress();
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            p.setProgress(0);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            while (p.getMax()!=p.getProgress()){
                try {
                    Thread.sleep(1000);
                    int progress= p.getProgress();
                    progress+=p.getMax()/10;
                    p.setProgress(progress);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }*/

    private void halo() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(p.getProgress()!=p.getMax()){
                        Thread.sleep(1000);
                        int max=p.getMax()/10;
                        int progress=p.getProgress();
                        progress+=max;
                        p.setProgress(progress);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (a%2==0)t.setText("赵日天");
                                else t.setText("叶良辰");
                                        a++;
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
