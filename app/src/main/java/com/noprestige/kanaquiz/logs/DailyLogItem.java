package com.noprestige.kanaquiz.logs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.noprestige.kanaquiz.Fraction;
import com.noprestige.kanaquiz.R;

import org.threeten.bp.LocalDate;
import org.threeten.bp.format.TextStyle;

import java.text.DecimalFormat;
import java.util.Locale;

public class DailyLogItem extends View
{
    private float correctAnswers = -1;
    private int totalAnswers = -1;
    private LocalDate date;
    private boolean isDynamicSize;

    private String dateString1 = "";
    private String dateString3 = "";
    private String dateString2 = "";
    private String correctString = "";
    private String totalString = "";
    private String percentageString = "";

    private TextPaint datePaint = new TextPaint();
    private TextPaint ratioPaint = new TextPaint();
    private TextPaint percentagePaint = new TextPaint();
    private Paint linePaint = new Paint();

    private float dateXPoint;
    private float dateYPoint1;
    private float dateYPoint2;
    private float dateYPoint3;
    private float correctXPoint;
    private float slashXPoint;
    private float totalXPoint;
    private float percentageXPoint;
    private float dataYPoint;

    private float lineXPoint1;
    private float lineXPoint2;
    private float lineYPoint;

    private float dateWidth1;
    private float dateWidth2;
    private float dateWidth3;
    private float correctWidth;
    private float slashWidth;
    private float totalWidth;
    private float percentageWidth;

    private float dateHeight;
    private float dataHeight;

    private int internalVerticalPadding;

    private static final DecimalFormat PERCENT_FORMATTER = new DecimalFormat("#0%");
    private static final String SLASH = "/";

    public DailyLogItem(Context context)
    {
        super(context);
        init(null, 0);
    }

    public DailyLogItem(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(attrs, 0);
    }

    public DailyLogItem(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    @SuppressLint("ResourceType")
    private void init(AttributeSet attrs, int defStyle)
    {
        Context context = getContext();

        // Load attributes
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DailyLogItem, defStyle, 0);

        setDate(a.getString(R.styleable.DailyLogItem_date));
        setCorrectAnswers(a.getFloat(R.styleable.DailyLogItem_correctAnswers, -1));
        setTotalAnswers(a.getInt(R.styleable.DailyLogItem_totalAnswers, -1));
        setFontSize(a.getDimension(R.styleable.DailyLogItem_fontSize,
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 14, context.getResources().getDisplayMetrics())));
        setMainColour(a.getColor(R.styleable.DailyLogItem_mainColour,
                context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.textColorTertiary}).getColor(0, 0)));
        setIsDynamicSize(a.getBoolean(R.styleable.DailyLogItem_isDynamicSize, true));

        a.recycle();

        datePaint.setAntiAlias(true);
        ratioPaint.setAntiAlias(true);
        percentagePaint.setAntiAlias(true);

        linePaint.setColor(context.getResources().getColor(R.color.dividingLine));
        linePaint.setStrokeWidth(context.getResources().getDimension(R.dimen.dividingLine));

        internalVerticalPadding = getResources().getDimensionPixelSize(R.dimen.logItemInternalVerticalPadding);

        setBackground(context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.selectableItemBackground})
                .getDrawable(0));

        setOnClickListener(view ->
        {
            //ref: https://stackoverflow.com/a/3913735/3582371
            Intent intent = new Intent(getContext(), LogDetailView.class);
            intent.putExtra("date", getDate());
            view.getContext().startActivity(intent);
        });
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight)
    {
        super.onSizeChanged(width, height, oldWidth, oldHeight);

        repositionItems(width, height);
    }

    private void repositionItems(int width, int height)
    {
        int contentWidth = width - getPaddingLeft() - getPaddingRight();
        int contentHeight = height - getPaddingTop() - getPaddingBottom() - (internalVerticalPadding * 2);

        dateXPoint = getPaddingLeft();
        dateYPoint1 = getPaddingTop() + internalVerticalPadding +
                (((contentHeight - dateHeight) / 2) - datePaint.getFontMetrics().descent);
        dateYPoint2 = dateYPoint1 + dateHeight;
        dateYPoint3 = dateYPoint2 + dateHeight;

        slashXPoint = getPaddingLeft() + ((contentWidth - slashWidth) / 2);

        correctXPoint = slashXPoint - correctWidth;
        totalXPoint = slashXPoint + slashWidth;
        percentageXPoint = getPaddingLeft() + (contentWidth - percentageWidth);
        dataYPoint = getPaddingTop() + internalVerticalPadding +
                (((contentHeight + dataHeight) / 2) - ratioPaint.getFontMetrics().descent);

        lineXPoint1 = getPaddingLeft();
        lineXPoint2 = width - getPaddingRight();
        lineYPoint = height - getPaddingBottom() - linePaint.getStrokeWidth();
    }

    //ref: http://stackoverflow.com/questions/13273838/onmeasure-wrap-content-how-do-i-know-the-size-to-wrap
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int desiredWidth = desiredWidth();
        int desiredHeight =
                Math.round(Math.max(dateHeight * 3, dataHeight) + linePaint.getStrokeWidth()) + getPaddingTop() +
                        getPaddingBottom() + (internalVerticalPadding * 2);

        int width = calculateSize(widthMeasureSpec, desiredWidth);
        int height = calculateSize(heightMeasureSpec, desiredHeight);

        setMeasuredDimension(width, height);
    }

    private int desiredWidth()
    {
        return Math.round((Math.max(Math.max(dateWidth1, Math.max(dateWidth2, dateWidth3)) + correctWidth,
                totalWidth + percentageWidth) * 2) + slashWidth) + getPaddingLeft() + getPaddingRight();
    }

    private static int calculateSize(int measureSpec, int desired)
    {
        switch (MeasureSpec.getMode(measureSpec))
        {
            case MeasureSpec.EXACTLY:
                return MeasureSpec.getSize(measureSpec);
            case MeasureSpec.AT_MOST:
                return Math.min(desired, MeasureSpec.getSize(measureSpec));
            case MeasureSpec.UNSPECIFIED:
            default:
                return desired;
        }
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        correctFontSize();

        canvas.drawText(dateString1, dateXPoint, dateYPoint1, datePaint);
        canvas.drawText(dateString2, dateXPoint, dateYPoint2, datePaint);
        canvas.drawText(dateString3, dateXPoint, dateYPoint3, datePaint);
        canvas.drawText(correctString, correctXPoint, dataYPoint, ratioPaint);
        canvas.drawText(SLASH, slashXPoint, dataYPoint, ratioPaint);
        canvas.drawText(totalString, totalXPoint, dataYPoint, ratioPaint);
        canvas.drawText(percentageString, percentageXPoint, dataYPoint, percentagePaint);
        canvas.drawLine(lineXPoint1, lineYPoint, lineXPoint2, lineYPoint, linePaint);
    }

    public void correctFontSize()
    {
        if (isDynamicSize)
        {
            while (desiredWidth() > getWidth())
                setDataFontSize(ratioPaint.getTextSize() - 1);
            repositionItems(getWidth(), getHeight());
        }
    }

    public void setFromRecord(DailyRecord record)
    {
        setDate(record.getDate());
        setCorrectAnswers(record.getCorrectAnswers());
        setTotalAnswers(record.getTotalAnswers());
    }

    public LocalDate getDate()
    {
        return date;
    }

    public float getCorrectAnswers()
    {
        return correctAnswers;
    }

    public int getTotalAnswers()
    {
        return totalAnswers;
    }

    public float getFontSize()
    {
        return datePaint.getTextSize();
    }

    public int getMainColour()
    {
        return datePaint.getColor();
    }

    public boolean getIsDynamicSize()
    {
        return isDynamicSize;
    }

    public boolean setDate(String date)
    {
        if (date == null)
            return false;
        else
        {
            setDate(LocalDate.parse(date));
            return true;
        }
    }

    public void setDate(LocalDate date)
    {
        this.date = date;


        dateString1 = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());

        dateString2 = date.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
        dateString2 += " ";
        dateString2 += Integer.toString(date.getDayOfMonth());

        dateString3 = Integer.toString(date.getYear());

        dateWidth1 = datePaint.measureText(dateString1);
        dateWidth2 = datePaint.measureText(dateString2);
        dateWidth3 = datePaint.measureText(dateString3);
    }

    public void setCorrectAnswers(float correctAnswers)
    {
        this.correctAnswers = correctAnswers;
        updateAnswers();
    }

    public void setTotalAnswers(int totalAnswers)
    {
        this.totalAnswers = totalAnswers;
        updateAnswers();
    }

    public void setFontSize(float fontSize)
    {
        datePaint.setTextSize(fontSize);

        dateHeight = datePaint.getFontMetrics().descent - datePaint.getFontMetrics().ascent;

        dateWidth1 = datePaint.measureText(dateString1);
        dateWidth2 = datePaint.measureText(dateString2);
        dateWidth3 = datePaint.measureText(dateString3);

        setDataFontSize(fontSize * 3);
    }

    private void setDataFontSize(float fontSize)
    {
        ratioPaint.setTextSize(fontSize);
        percentagePaint.setTextSize(fontSize);

        dataHeight = ratioPaint.getFontMetrics().descent - ratioPaint.getFontMetrics().ascent;

        correctWidth = ratioPaint.measureText(correctString);
        slashWidth = ratioPaint.measureText(SLASH);
        totalWidth = ratioPaint.measureText(totalString);
        percentageWidth = percentagePaint.measureText(percentageString);
    }

    public void setMainColour(int colour)
    {
        datePaint.setColor(colour);
        ratioPaint.setColor(colour);
    }

    public void setIsDynamicSize(boolean isDynamicSize)
    {
        this.isDynamicSize = isDynamicSize;
    }

    public static String parseCount(float count)
    {
        return (count < 100) ? new Fraction(count).toString() : parseCount(Math.round(count));
    }

    public static String parseCount(int count)
    {
        if (count < 1000)
            return Integer.toString(count);
        else if (count < 10000)
            return Float.toString(Math.round((float) count / 100f) / 10f) + "k";
        else //if (count < 100000)
            return Integer.toString(Math.round((float) count / 1000f)) + "k";
    }

    private void updateAnswers()
    {
        if ((correctAnswers >= 0) && (totalAnswers >= 0))
        {
            correctString = parseCount(correctAnswers);
            totalString = parseCount(totalAnswers);
            float percentage = correctAnswers / (float) totalAnswers;
            percentageString = PERCENT_FORMATTER.format(percentage);
            percentagePaint.setColor(getPercentageColour(percentage, getResources()));

            correctWidth = ratioPaint.measureText(correctString);
            slashWidth = ratioPaint.measureText(SLASH);
            totalWidth = ratioPaint.measureText(totalString);
            percentageWidth = percentagePaint.measureText(percentageString);
        }
    }

    public static int getPercentageColour(float percentage, Resources resources)
    {
        int tenth = Math.round(percentage * 100) / 10;
        if (tenth <= 4)
            return resources.getColor(R.color.below_fifty);
        else if (tenth == 5)
            return resources.getColor(R.color.fifty_to_sixty);
        else if (tenth == 6)
            return resources.getColor(R.color.sixty_to_seventy);
        else if (tenth == 7)
            return resources.getColor(R.color.seventy_to_eighty);
        else if (tenth == 8)
            return resources.getColor(R.color.eighty_to_ninety);
        else //if (tenth >= 9)
            return resources.getColor(R.color.above_ninety);
    }
}
