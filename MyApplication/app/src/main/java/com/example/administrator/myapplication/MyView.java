package com.example.administrator.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/7/6.
 */
public class MyView extends View {
    private Paint paint;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint=new Paint();
        paint.setColor(getResources().getColor(R.color.colorPrimary));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0, 50, 200, 200, paint);
        Log.i("Log","halo=======================");
    }
}
