package com.alvayonara.mamanga.common.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Matrix
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.ImageView
import com.alvayonara.mamanga.common.R

/**
 * A {@link ImageView} with 2 new custom scale types :  app:scaleType="fitTop" & app:scaleType="fitBottom".
 * Use it if you need something like scaleType="centerCrop|fitTop" or scaleType="centerCrop|fitBottom"
 */
@SuppressLint("AppCompatCustomView")
class ImageScaleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = -1
) : ImageView(context, attrs, defStyleAttr) {

    private var matrixType: MatrixType? = null

    init {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.ImageScaleView, defStyleAttr, 0)
        val customScaleType =
            ScaleType.getType(typedArray.getString(R.styleable.ImageScaleView_scaleType))
        scaleType = when (customScaleType) {
            ScaleType.CENTER -> ImageView.ScaleType.CENTER
            ScaleType.CENTER_CROP -> ImageView.ScaleType.CENTER_CROP
            ScaleType.CENTER_INSIDE -> ImageView.ScaleType.CENTER_INSIDE
            ScaleType.FIT_CENTER -> ImageView.ScaleType.FIT_CENTER
            ScaleType.FIT_END -> ImageView.ScaleType.FIT_END
            ScaleType.FIT_START -> ImageView.ScaleType.FIT_START
            ScaleType.FIT_XY -> ImageView.ScaleType.FIT_XY
            ScaleType.MATRIX -> ImageView.ScaleType.MATRIX
            ScaleType.FIT_TOP -> ImageView.ScaleType.MATRIX.also { matrixType = MatrixType.FIT_TOP }
            ScaleType.FIT_BOTTOM -> ImageView.ScaleType.MATRIX.also { matrixType =
                MatrixType.FIT_BOTTOM
            }
        }
    }

    override fun setFrame(l: Int, t: Int, r: Int, b: Int): Boolean {
        matrixType?.let { computeDrawableMatrix(it) }
        return super.setFrame(l, t, r, b)
    }

    private fun computeDrawableMatrix(matrixType: MatrixType) = drawable?.let {
        val matrix = imageMatrix
        val viewWidth = (measuredWidth - (paddingLeft + paddingRight)).toFloat()
        val viewHeight = (measuredHeight - (paddingTop + paddingBottom)).toFloat()
        val drawableHeight = it.intrinsicHeight.toFloat()
        val drawableWidth = it.intrinsicWidth.toFloat()
        val scale =
            if (it.intrinsicWidth * viewHeight > it.intrinsicHeight * viewWidth)
                viewHeight / drawableHeight
            else
                viewWidth / drawableWidth
        val offset = viewHeight / scale

        val drawableRect = when (matrixType) {
            MatrixType.FIT_BOTTOM -> RectF(0f, drawableHeight - offset, drawableWidth, drawableHeight - TRUNCATE_PATCH)
            MatrixType.FIT_TOP -> RectF(0f, TRUNCATE_PATCH, drawableWidth, offset)
        }
        val viewRect = RectF(0f, 0f, viewWidth, viewHeight)
        matrix.setRectToRect(drawableRect, viewRect, Matrix.ScaleToFit.FILL)
        imageMatrix = matrix
    }

    companion object {
        private const val TRUNCATE_PATCH = 0.5f
    }

    private enum class ScaleType(val id: String) {
        CENTER("0"),
        CENTER_CROP("1"),
        CENTER_INSIDE("2"),
        FIT_CENTER("3"),
        FIT_END("4"),
        FIT_START("5"),
        FIT_XY("6"),
        FIT_TOP("7"),
        FIT_BOTTOM("8"),
        MATRIX("9");

        companion object {
            fun getType(id: String?) = values().firstOrNull { it.id == id } ?: FIT_BOTTOM
        }
    }

    private enum class MatrixType { FIT_TOP, FIT_BOTTOM }
}