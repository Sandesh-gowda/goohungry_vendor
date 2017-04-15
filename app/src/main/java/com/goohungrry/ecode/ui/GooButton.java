package com.goohungrry.ecode.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;


/**
 * Created by admin on 21/07/16.
 */
public class GooButton extends Button {


    private boolean nextAction = false;

    public GooButton(Context paramContext) {
        super(paramContext);
        init(paramContext, null);
    }

    public GooButton(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramContext, paramAttributeSet);
    }

    public GooButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init(paramContext, paramAttributeSet);
    }

    public void hideKeyboard(View paramView) {
        ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(paramView.getWindowToken(), 0);

    }

    public void init(Context paramContext, AttributeSet paramAttributeSet) {
        setClickable(true);
        if (paramAttributeSet != null)
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/novasemibold.ttf"));
    }
}

