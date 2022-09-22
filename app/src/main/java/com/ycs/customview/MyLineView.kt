package com.ycs.customview


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * <pre>
 *     author : yangchaosheng
 *     e-mail : yangchaosheng@hisense.com
 *     time   : 2022/09/20
 *     desc   :
 * </pre>
 */
@Preview
@Composable
fun MyLineView() {
    Canvas(
        modifier = Modifier
            .padding(10.dp)
            .width(200.dp)
            .height(100.dp)
    ) {
        drawIntoCanvas { canvas ->
            val paint = Paint()
            paint.color = Color.Gray
            paint.style = PaintingStyle.Stroke
            paint.strokeWidth = 3f
            canvas.translate(0f, size.height)
            canvas.scale(1f, -1f)
            //paint相当于画笔
            //canvas相当于画布
            val pathY = Path()
            pathY.moveTo(0f, 0f)
            pathY.relativeLineTo(0f, size.height)
            canvas.drawPath(pathY, paint)

            var pathX = Path()
            pathX.moveTo(0f, 0f)
            pathX.relativeLineTo(size.width, 0f)
            canvas.drawPath(pathX, paint)

            val dataList: MutableList<Offset> = mutableListOf(
                Offset(20f, 60f),
                Offset(40f, 30f),
                Offset(40f, 30f),
                Offset(50f, 34f),
                Offset(80f, 54f),
                Offset(100f, 34f),
                Offset(200f, 134f),
                Offset(400f, 154f),
                Offset(480f, 134f)
            )
            val linePath = Path()
            paint.color = Color.Blue
            val colors: MutableList<Color> = mutableListOf(Color.Red, Color.Blue, Color.Green)
            paint.shader = LinearGradientShader(
                Offset(0f, 0f),
                Offset(size.width, 0f),
                colors,
                null,
                TileMode.Clamp
            )
            paint.isAntiAlias = true
            for (index in 0 until dataList.size) {
                linePath.lineTo(dataList[index].x, dataList[index].y)
            }
            linePath.lineTo(dataList[dataList.size - 1].x, 0f)
            linePath.close()

            val paintFill = Paint()
            paintFill.color = Color.Gray
            paintFill.style = PaintingStyle.Fill
            paintFill.strokeWidth = 3f
            paintFill.shader = LinearGradientShader(
                Offset(0f, size.height),
                Offset(0f, 0f),
                arrayListOf(Color(59, 157, 254, 161),
                    Color(59, 157, 254, 21)),
                null,
                TileMode.Clamp
            )
            canvas.drawPath(linePath,paintFill)
            val line= Path()
            for(index in 0 until dataList.size){
                line.lineTo(dataList[index].x,dataList[index].y)

            }
            paint.style=PaintingStyle.Stroke
            canvas.drawPath(line,paint)

            paint.style=PaintingStyle.Fill
            for(index in 0 until dataList.size){
                canvas.drawCircle(Offset(dataList[index].x,dataList[index].y),6f,paint)
            }
           // canvas.drawImage(image = Bitmap(), Offset(100f,100f),paint)


        }
    }
}