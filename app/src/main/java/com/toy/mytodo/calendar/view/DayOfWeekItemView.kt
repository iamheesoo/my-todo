package com.toy.mytodo.calendar.view

import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.core.content.withStyledAttributes
import com.toy.mytodo.R

class DayOfWeekItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?=null,
    @AttrRes private val defStyleAttr: Int = R.attr.itemViewStyle,
    @StyleRes private val defStyleRes: Int = R.style.Calendar_ItemViewStyle,
    private val dayOfWeek: String = ""
    ): View(ContextThemeWrapper(context, defStyleRes), attrs, defStyleAttr) {

    private var paint: Paint=Paint()
    private val bounds= Rect()

    init{
        context.withStyledAttributes(attrs, R.styleable.CalendarWeekView, defStyleAttr, defStyleRes){
            val dayTextSize=getDimensionPixelSize(R.styleable.CalendarWeekView_dayOfWeekTextSize, 0).toFloat()

            paint= TextPaint().apply {
                isAntiAlias=true
                textSize=dayTextSize
                color= Color.BLACK
                typeface= Typeface.DEFAULT_BOLD
            }
        }

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if(canvas==null) return

        paint.getTextBounds(dayOfWeek, 0, dayOfWeek.length, bounds)
        canvas.drawText(
            dayOfWeek,
            (width/2-bounds.width()/2).toFloat()-2,
            (height/2+bounds.height()/2).toFloat(),
            paint
        )
    }

}