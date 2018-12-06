package com.wlf456.fix.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

public class FixedScaleLayout extends FrameLayout {
	private float scale = 1;

	public FixedScaleLayout(Context context) {
		this(context, null);

	}

	public FixedScaleLayout(Context context, AttributeSet attrs) {
		this(context, attrs, 0);

	}

	public FixedScaleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
				R.styleable.FixedScaleLayout, 0, 0);

		try {
			scale = a.getFloat(R.styleable.FixedScaleLayout_scale, 1);

		} finally {
			a.recycle();
		}
		Log.i("logutils", "scale" + scale);

	}
	
	public void setScale(float scale){
		this.scale=scale;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int mode = MeasureSpec.getMode(widthMeasureSpec);
		int width = MeasureSpec.getSize(widthMeasureSpec);
		int height = (int) (scale * width);
		heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, mode);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		// setMeasuredDimension(width, height);
	}

}
