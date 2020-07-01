package com.elfin.Boat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ProgressImageWiev extends ImageView {

private Context mContext;
private Paint paint;
private Paint paint1;
private RectF rectf;
private RectF rectf1;

private int maximalValue = 100;
private int level = 0;
private int width;
private int height;

public ProgressImageWiev(Context context) 
{
	super(context);
	init(context, null, 0);
}

public ProgressImageWiev(Context context, AttributeSet attrs) 
{
	super(context, attrs);
	init(context, attrs, 0);
}

public ProgressImageWiev(Context context, AttributeSet attrs, int defStyleAttr) 
{
	super(context, attrs, defStyleAttr);
	init(context, attrs, defStyleAttr);
}

private  void init(Context context, AttributeSet attrs, int defStyleAttr)
{
	mContext = context;
	paint = new Paint();
	paint1 = new Paint();
	rectf = new RectF();
	rectf1 = new RectF();
	paint.setColor(Color.YELLOW);
	paint.setStyle(Paint.Style.FILL);
	paint1.setColor(Color.GRAY);
	paint1.setStyle(Paint.Style.FILL);
};

@Override
protected void onDraw(Canvas canvas) 
{
	float dif = (float) height / (float) maximalValue;
	int newHeight = height - (int) (dif * level);

	rectf1.set(0,0, width, newHeight);
	canvas.drawRect(rectf1, paint1);
	rectf.set(0,newHeight, width, height);
	canvas.drawRect(rectf, paint);
	//super.onDraw(canvas);
}

@Override
protected void onSizeChanged(int w, int h, int oldw, int oldh) 
{
	super.onSizeChanged(w, h, oldw, oldh);
	this.width = w;
	this.height = h;
}

public void setMaximalValue(int maximalValue) 
{
	this.maximalValue = maximalValue;
	invalidate();
}

public void setLevel(int level) 
{
	if (level < 0) level = 0;
	if (level>this.maximalValue) level = this.maximalValue;
	if (level != this.level) {
		this.level = level;
		invalidate();
	}
}

public Integer getLevel() 
{
	return this.level;
}

public void setColor(int color)
{
	if (paint != null){
		paint.setColor(color);
		invalidate();
	}
}

}