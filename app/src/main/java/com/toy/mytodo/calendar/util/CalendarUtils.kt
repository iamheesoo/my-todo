package com.toy.mytodo.calendar.util

import org.joda.time.DateTime
import org.joda.time.DateTimeConstants
import java.text.SimpleDateFormat
import java.util.*

class CalendarUtils {
    companion object{
        fun getMonthList(dateTime: DateTime):List<DateTime>{
            val list= mutableListOf<DateTime>()

            val date=dateTime.withDayOfMonth(1)
            val prev= getPrevOffset(date)
            val startValue=date.minusDays(prev)
            val totalDay=DateTimeConstants.DAYS_PER_WEEK*6

            for(i in 0 until totalDay){
                list.add(DateTime(startValue.plusDays(i)))
            }

            return list
        }

        private fun getPrevOffset(dateTime: DateTime):Int{
            var prevMonthTailOffset=dateTime.dayOfWeek
            if(prevMonthTailOffset>=7) prevMonthTailOffset%=7
            return prevMonthTailOffset
        }

        fun getWeekList(dateTime: DateTime):List<DateTime>{
            val list= mutableListOf<DateTime>()

            val c=Calendar.getInstance()
            c.set(Calendar.DAY_OF_WEEK, Calendar.MONTH)
            val format=SimpleDateFormat("dd")
            val monday=format.format(c.time).toInt()
            val startValue=DateTime(dateTime)
            for (i in 0 until 7){
                list.add(DateTime(startValue.plusDays(i)))
            }

            return list
        }
    }
}