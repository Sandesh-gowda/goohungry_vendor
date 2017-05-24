package com.pinlab.vendor.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by admin on 20/07/16.
 */
public class GooTextView extends TextView {

    public GooTextView(Context paramContext) {
        super(paramContext);
        init(paramContext, null);
    }

    public GooTextView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramContext, paramAttributeSet);
    }

    public GooTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init(paramContext, paramAttributeSet);
    }

    public void init(Context paramContext, AttributeSet paramAttributeSet) {
        if (paramAttributeSet != null)
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/novaregular.ttf"));
    }
}

