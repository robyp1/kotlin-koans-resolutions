package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int =
            when {
                year != other.year -> year - other.year
                month != other.month -> month - other.month
                else -> dayOfMonth -other.dayOfMonth
            }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)/*todoTask27()*/


enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {

    override fun contains(value: MyDate): Boolean = value >= start && value <= endInclusive

    override fun iterator(): Iterator<MyDate> = DateIterator(this)
}

class DateIterator(val dateRange: DateRange) : Iterator<MyDate> {

    var current : MyDate = dateRange.start
    override fun hasNext(): Boolean = current <= dateRange.endInclusive

    override fun next(): MyDate {
        val result = current
        current = current.nextDay()
        return result
    }
}

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)

//per la somma (+) tra Mydate e timeInterval
operator fun MyDate.plus(timeInterval: TimeInterval) = addTimeIntervals(timeInterval, 1)

//per il prodotto (*) tra TimeIntervals e interi (costanti es: DAY * 2)
operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this, number)

//per la somma (+) tra MyDate e RepeatedTimeInterval (es : x + DAY * 2, dove x : Mytdate)
operator fun MyDate.plus(timeIntervals: RepeatedTimeInterval) = addTimeIntervals(timeIntervals.timeInterval, timeIntervals.number)


