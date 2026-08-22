package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.core.widget.TintableCompoundDrawablesView;
import com.facebook.appevents.internal.SessionInfo;
import com.google.firebase.auth.zzaa;
import okhttp3.Headers;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements TintableCompoundDrawablesView {
    public static final int[] TINT_ATTRS = {R.attr.popupBackground};
    public final AppCompatProgressBarHelper mAppCompatEmojiEditTextHelper;
    public final SessionInfo mBackgroundTintHelper;
    public final AppCompatTextHelper mTextHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.daerisoft.thespikerm.R.attr.autoCompleteTextViewStyle);
        TintContextWrapper.wrap(context);
        ThemeUtils.checkAppCompatTheme(getContext(), this);
        zzaa zzaaVarObtainStyledAttributes = zzaa.obtainStyledAttributes(getContext(), attributeSet, TINT_ATTRS, com.daerisoft.thespikerm.R.attr.autoCompleteTextViewStyle);
        if (((TypedArray) zzaaVarObtainStyledAttributes.zzb).hasValue(0)) {
            setDropDownBackgroundDrawable(zzaaVarObtainStyledAttributes.getDrawable(0));
        }
        zzaaVarObtainStyledAttributes.recycle();
        SessionInfo sessionInfo = new SessionInfo(this);
        this.mBackgroundTintHelper = sessionInfo;
        sessionInfo.loadFromAttributes(attributeSet, com.daerisoft.thespikerm.R.attr.autoCompleteTextViewStyle);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, com.daerisoft.thespikerm.R.attr.autoCompleteTextViewStyle);
        appCompatTextHelper.applyCompoundDrawablesTints();
        AppCompatProgressBarHelper appCompatProgressBarHelper = new AppCompatProgressBarHelper(this);
        this.mAppCompatEmojiEditTextHelper = appCompatProgressBarHelper;
        appCompatProgressBarHelper.loadFromAttributes(attributeSet, com.daerisoft.thespikerm.R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = isFocusable();
        boolean zIsClickable = isClickable();
        boolean zIsLongClickable = isLongClickable();
        int inputType = getInputType();
        KeyListener keyListener2 = appCompatProgressBarHelper.getKeyListener(keyListener);
        if (keyListener2 == keyListener) {
            return;
        }
        super.setKeyListener(keyListener2);
        setRawInputType(inputType);
        setFocusable(zIsFocusable);
        setClickable(zIsClickable);
        setLongClickable(zIsLongClickable);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.applySupportBackgroundTint();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            return sessionInfo.getSupportBackgroundTintList();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            return sessionInfo.getSupportBackgroundTintMode();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.getCompoundDrawableTintList();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.getCompoundDrawableTintMode();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        Protocol.Companion.onCreateInputConnection(editorInfo, inputConnectionOnCreateInputConnection, this);
        return this.mAppCompatEmojiEditTextHelper.onCreateInputConnection(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.onSetBackgroundDrawable();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.onSetBackgroundResource(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(Headers.Companion.getDrawable(getContext(), i));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.mAppCompatEmojiEditTextHelper.setEnabled(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.getKeyListener(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        appCompatTextHelper.setCompoundDrawableTintList(colorStateList);
        appCompatTextHelper.applyCompoundDrawablesTints();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        appCompatTextHelper.setCompoundDrawableTintMode(mode);
        appCompatTextHelper.applyCompoundDrawablesTints();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.onSetTextAppearance(context, i);
        }
    }
}
