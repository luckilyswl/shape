package com.qingshangzuo.shape_demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;


/**
 *   继承Button,覆盖onDraw(Canvas canvas),
 *   在onDraw中先将canvas进行translate平移，
 *   再调用父类onDraw进行绘制。
 *
 *   农民伯伯： http://www.cnblogs.com/over140/
 */

public class DrawableButton extends AppCompatButton {


    public DrawableButton(Context context) {
        super(context);
    }

    // 传入参数attrs，要不会导致不显示
    public DrawableButton(Context context, AttributeSet attrs) {
        super(context,attrs);
    }

    public DrawableButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context,attrs,defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        if (drawables != null) {
            Drawable drawableLeft = drawables[0];
            if (drawableLeft != null) {
                float buttonWidth = getPaint().measureText(getText().toString());
                int drawablePadding = getCompoundDrawablePadding();
                int drawableWidth = 0;
                drawableWidth = drawableLeft.getIntrinsicWidth();
                float bodyWidth = buttonWidth + drawableWidth + drawablePadding;
                canvas.translate((getWidth() - bodyWidth) / 2, 0);
            }
        }
        super.onDraw(canvas);
    }
}
