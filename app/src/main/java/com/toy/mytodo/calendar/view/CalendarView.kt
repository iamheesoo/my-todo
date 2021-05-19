package com.toy.mytodo.calendar.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.ContextThemeWrapper
import android.view.ViewGroup
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.core.content.withStyledAttributes
import androidx.core.view.children
import com.toy.mytodo.R
import org.joda.time.DateTime
import org.joda.time.DateTimeConstants.DAYS_PER_WEEK
import kotlin.math.max

class CalendarView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet?=null,
        @AttrRes defStyleAttr: Int = R.attr.calendarViewStyle,
        @StyleRes defStyleRes: Int=R.style.Calendar_CalendarViewStyle
): ViewGroup(ContextThemeWrapper(context, defStyleRes), attrs, defStyleAttr) {

    private val TAG="CalendarView"
    private var _height:Float=0f

    init{
        context.withStyledAttributes(attrs, R.styleable.CalendarWeekView, defStyleAttr, defStyleRes){
            _height=getDimension(R.styleable.CalendarWeekView_dayHeight, 0f)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val h=paddingTop+paddingBottom+max(suggestedMinimumHeight, (_height*2).toInt())
        setMeasuredDimension(getDefaultSize(suggestedMinimumWidth, widthMeasureSpec), h)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val iWidth=(width/DAYS_PER_WEEK).toFloat()
        val iHeight=(height/2).toFloat()

        var index=0
        children.forEach { view ->
            val left=(index%DAYS_PER_WEEK)*iWidth
            val top=(index/DAYS_PER_WEEK)*iHeight//(index/DAYS_PER_WEEK)*iHeight
            view.layout(left.toInt(), top.toInt(), (left+iWidth).toInt(), (top+iHeight).toInt())

            index++
        }
    }

    fun initCalendar(firstDayOfMonth: DateTime, list:List<DateTime>, listener: DayItemView.EventListener){
        showDayOfWeek()

        list.forEach{
            addView(
                DayItemView(
                    context=context,
                    date=it,
                    firstDayOfMonth =firstDayOfMonth,
                    listener= listener
                )
            )
        }
    }

    private fun showDayOfWeek(){
        val week= arrayOf("Mon", "Tue", "Wed", "Thur", "Fri", "Sat", "Sun")
        week.forEach {
            addView(
                DayOfWeekItemView(
                    context=context,
                    dayOfWeek=it
                )
            )
        }
    }

}