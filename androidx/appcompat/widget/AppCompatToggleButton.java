package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import androidx.core.widget.TintableCompoundDrawablesView;
import com.facebook.appevents.internal.SessionInfo;
import okio.Okio;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatToggleButton extends ToggleButton implements TintableCompoundDrawablesView {
    public AppCompatEmojiTextHelper mAppCompatEmojiTextHelper;
    public final SessionInfo mBackgroundTintHelper;
    public final AppCompatTextHelper mTextHelper;

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyleToggle);
        ThemeUtils.checkAppCompatTheme(getContext(), this);
        SessionInfo sessionInfo = new SessionInfo(this);
        this.mBackgroundTintHelper = sessionInfo;
        sessionInfo.loadFromAttributes(attributeSet, R.attr.buttonStyleToggle);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, R.attr.buttonStyleToggle);
        getEmojiTextViewHelper().loadFromAttributes(attributeSet, R.attr.buttonStyleToggle);
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new AppCompatEmojiTextHelper(this);
        }
        return this.mAppCompatEmojiTextHelper;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
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

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().setAllCaps(z);
    }

    @Override // android.widget.ToggleButton, android.view.View
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

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().setEnabled(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((Okio) getEmojiTextViewHelper().mEmojiTextViewHelper.sharedPreferences).getFilters(inputFilterArr));
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
}
