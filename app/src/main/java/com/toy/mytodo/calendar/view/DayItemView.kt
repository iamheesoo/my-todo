package com.toy.mytodo.calendar.view

import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.ContextThemeWrapper
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.core.content.withStyledAttributes
import com.toy.mytodo.R
import org.joda.time.DateTime
import kotlin.math.min

class DayItemView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet?=null,
        @AttrRes private val defStyleAttr: Int = R.attr.itemViewStyle,
        @StyleRes private val defStyleRes: Int = R.style.Calendar_ItemViewStyle,
        private val date: DateTime = DateTime(),
        private val firstDayOfMonth: DateTime=DateTime()
    ): View(ContextThemeWrapper(context, defStyleRes), attrs, defStyleAttr) {

    private val TAG="DayItemView"
    private val bounds= Rect()
    private var paint: Paint=Paint()
    private var recPaint: Paint = Paint()

    init{
        context.withStyledAttributes(attrs, R.styleable.CalendarWeekView, defStyleAttr, defStyleRes){
            val dayTextSize=getDimensionPixelSize(R.styleable.CalendarWeekView_dayTextSize, 0).toFloat()

            paint=TextPaint().apply {
                isAntiAlias=true
                textSize=dayTextSize
                color= Color.parseColor("#FFFFFF")
            }

            recPaint.apply {
                color=Color.parseColor("#443F79")
                style=Paint.Style.FILL

            }
        }
        setOnClickListener(View.OnClickListener {
            Log.i(TAG, DateTime(date).toString())
        })

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if(canvas==null) return

        val radius= min(height/2, width/2)
        canvas.drawRect((width/2-radius).toFloat(), (height/2-radius).toFloat(), (width/2+radius).toFloat(), (height/2+radius).toFloat(), recPaint)

        val date=date.dayOfMonth.toString()
        paint.getTextBounds(date, 0, date.length, bounds)
        canvas.drawText(
            date,
            (width/2-bounds.width()/2).toFloat()-2,
            (height/2+bounds.height()/2).toFloat(),
            paint
        )

    }


}