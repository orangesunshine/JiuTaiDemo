package com.jiutai.demo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.jiutai.demo.R;

public class CircleChartView extends android.support.v7.widget.AppCompatTextView {
    private int mNoteColor, mWinColor, mProfitLossColor, mNotebgColor, mTextColor;
    private String mText;
    private float mTextSize, mSweepAngle;
    private Paint mPaint;
    private int mWidth = -1;
    private RectF mOutRectF, mInnerRectF;

    public CircleChartView(Context context) {
        super(context);
    }

    public CircleChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleChartView);
        mTextSize = a.getDimension(R.styleable.CircleChartView_textSize, 50);
        mTextColor = a.getColor(R.styleable.CircleChartView_textColor, getContext().getResources().getColor(R.color.text_light_white));
        mText = a.getString(R.styleable.CircleChartView_text);
        mNoteColor = a.getColor(R.styleable.CircleChartView_noteColor, Color.parseColor("#F7B142"));
        mWinColor = a.getColor(R.styleable.CircleChartView_winColor, Color.parseColor("#FF6545"));
        mProfitLossColor = a.getColor(R.styleable.CircleChartView_profitlossColor, Color.parseColor("#0888FF"));
        mNotebgColor = a.getColor(R.styleable.CircleChartView_notebgColor, Color.parseColor("#303038"));
        mSweepAngle = a.getFloat(R.styleable.CircleChartView_sweepAngle, 0);
        a.recycle();

        init();
    }

    public CircleChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mPaint.setStrokeWidth(mWidth / 12);
        mOutRectF = new RectF(mWidth / 12, mWidth / 12, mWidth * 11 / 12, mWidth * 11 / 12);
        mInnerRectF = new RectF(mWidth / 4, mWidth / 4, mWidth * 3 / 4, mWidth * 3 / 4);
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mProfitLossColor);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    private void setSweepAngle(float sweepAngle) {
        mSweepAngle = sweepAngle;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mWidth / 2, mWidth / 2, mWidth * 5 / 12, mPaint);
        mPaint.setColor(mWinColor);
        canvas.drawArc(mOutRectF, 235 - mSweepAngle / 2, mSweepAngle, false, mPaint);

        mPaint.setColor(mNotebgColor);
        canvas.drawCircle(mWidth / 2, mWidth / 2, mWidth * 1 / 4, mPaint);
        mPaint.setColor(mNoteColor);
        canvas.drawArc(mInnerRectF, 235 - mSweepAngle / 2, mSweepAngle, false, mPaint);
        if (!TextUtils.isEmpty(mText)) {
            mPaint.setColor(mTextColor);
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setStrokeWidth(12);
            mPaint.setTextAlign(Paint.Align.CENTER);
            mPaint.setTextSize(sp2px(getContext(), 14));
            //canvas.drawText(mText, mWidth / 2, mWidth / 2, mPaint);
            Paint.FontMetrics fontMetrics=mPaint.getFontMetrics();
            float distance=(fontMetrics.bottom - fontMetrics.top)/2 - fontMetrics.bottom;
            float baseline=mInnerRectF.centerY()+distance;
            canvas.drawText(mText, mInnerRectF.centerX(), baseline, mPaint);
        }
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @return
     */
    private int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
