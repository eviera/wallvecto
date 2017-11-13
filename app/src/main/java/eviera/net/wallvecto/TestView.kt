package eviera.net.wallvecto

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import android.view.MotionEvent




class TestView(context: Context) : View(context) {


    val paint = Paint()
    var xtouch = 0f
    var ytouch = 0f

    /*
    init {
        viewTreeObserver.addOnGlobalLayoutListener {
            xtouch = width / 2f
            ytouch = height / 2f
        }
    }
    */

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        xtouch = w / 2f
        ytouch = h / 2f

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (canvas != null) {
            val radius = 100f
            paint.style = Paint.Style.FILL
            paint.color = Color.WHITE
            canvas.drawPaint(paint)
            // Use Color.parseColor to define HTML colors
            paint.color = Color.parseColor("#AA5A5C")
            canvas.drawCircle(xtouch, ytouch, radius, paint)
        }

    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                xtouch = event.x
                ytouch = event.y
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                xtouch = event.x
                ytouch = event.y
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
            }
        }
        return true
    }
}