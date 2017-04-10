package com.example.xvhuichuang.lianxi.com.lianxi.UI;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Random;

/**
 * Created by xvhuichuang on 2017/4/9.
 */

/**
 * 会呼吸的泡泡
 */
public class BreatheView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    /**
     * 是否处于绘制状态
     */
    private boolean mIsDrawing;
    /**
     * 帮助类
     */
    private SurfaceHolder mHolder;
    /**
     * 画布
     */
    private Canvas mCanvas;
    /**
     * 画笔
     */
    private Paint mPaint;
    private Paint mPaintTwo;
    private Paint mPaintThree;
    private Paint mPaintFour;
    /**
     * 宽高
     */
    private float width;
    private float height;

    private final int ALPHA = 50;
    private final int SLEEP_TIME = 100;
    /**
     * 坐标
     */
    PointF oneStartPoint;
    PointF twoStartPoint;
    PointF threeStartPoint;
    PointF fourStartPoint;
    /**
     * 判断是否绘制
     */
    boolean isDraw = true;
    boolean isDrawTwo = true;
    boolean isDrawThree = true;
    boolean isDrawFour = true;

    public BreatheView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    public BreatheView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public BreatheView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        mHolder = getHolder();
        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.CYAN);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAlpha(ALPHA);

        mPaintTwo = new Paint();
        mPaintTwo.setAntiAlias(true);
        mPaintTwo.setColor(Color.BLUE);
        mPaintTwo.setStyle(Paint.Style.FILL);
        mPaintTwo.setAlpha(ALPHA);

        mPaintThree = new Paint(mPaint);
        mPaintThree.setAntiAlias(true);
        mPaintThree.setColor(Color.RED);
        mPaintThree.setStyle(Paint.Style.FILL);
        mPaintThree.setAlpha(ALPHA);

        mPaintFour = new Paint();
        mPaintFour.setAntiAlias(true);
        mPaintFour.setColor(Color.GREEN);
        mPaintFour.setStyle(Paint.Style.FILL);
        mPaintFour.setAlpha(ALPHA);

        oneStartPoint = new PointF(300, 220);
        twoStartPoint = new PointF(20, 250);
        threeStartPoint = new PointF(500, 90);
        fourStartPoint = new PointF(0, 0);
    }

    private Canvas getCanvas(){
        return mCanvas;
    }

    private void setCanvas(Canvas aCanvas){
        this.mCanvas = aCanvas;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while (mIsDrawing) {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            draw();
        }
        long end = System.currentTimeMillis();
        if (end - start < SLEEP_TIME) {
            try {
                Thread.sleep(SLEEP_TIME - (end - start));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder arg0) {
        mIsDrawing = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {
        mIsDrawing = false;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    private synchronized void draw() {
        try {
            lockCanvas();
            drawOne();
            drawTwo();
            drawThree();
            drawFour();
            unlockCanvas();
        } catch (Exception e) {
        }
    }

    private void drawOne() {
        getCanvas().drawColor(Color.WHITE);
        if (oneStartPoint.x == 300 || oneStartPoint.y == 220) {
            isDraw = true;
        } else if (oneStartPoint.x == 330 || oneStartPoint.y == 250) {
            isDraw = false;
        }
        if (isDraw) {
            getCanvas().drawCircle(oneStartPoint.x++, oneStartPoint.y++, 180, mPaint);
        } else {
            getCanvas().drawCircle(oneStartPoint.x--, oneStartPoint.y--, 180, mPaint);
        }
    }

    private void lockCanvas() {
        setCanvas(mHolder.lockCanvas());
    }

    private void unlockCanvas() {
        if (getCanvas() != null) {
            mHolder.unlockCanvasAndPost(getCanvas());
        }
    }

    private void drawFour() {
        //第四个泡泡
        if (fourStartPoint.x == 0 || fourStartPoint.y == 0) {
            isDrawFour = true;
        } else if (fourStartPoint.x == 20 || fourStartPoint.y == 20) {
            isDrawFour = false;
        }
        if (isDrawFour) {
            getCanvas().drawCircle(fourStartPoint.x++, fourStartPoint.y++, 220, mPaintFour);
        } else {
            getCanvas().drawCircle(fourStartPoint.x--, fourStartPoint.y--, 220, mPaintFour);
        }
    }

    private void drawThree() {
        //第三个泡泡
        if (threeStartPoint.x == 500 || threeStartPoint.y == 200) {
            isDrawThree = true;
        } else if (threeStartPoint.x == 520 || threeStartPoint.y == 520) {
            isDrawThree = false;
        }
        if (isDrawThree) {
            getCanvas().drawCircle(threeStartPoint.x++, threeStartPoint.y++, 220, mPaintThree);
        } else {
            getCanvas().drawCircle(threeStartPoint.x--, threeStartPoint.y--, 220, mPaintThree);
        }
    }

    private void drawTwo() {
        //第二个泡泡
        if (twoStartPoint.x == 20 || twoStartPoint.y == 250) {
            isDrawTwo = true;
        } else if (twoStartPoint.x == 35 || twoStartPoint.y == 265) {
            isDrawTwo = false;
        }
        if (isDrawTwo) {
            getCanvas().drawCircle(twoStartPoint.x++, twoStartPoint.y++, 240, mPaintTwo);
        } else {
            getCanvas().drawCircle(twoStartPoint.x--, twoStartPoint.y--, 240, mPaintTwo);
        }
    }
}
