package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import com.daerisoft.thespikerm.R;
import com.facebook.appevents.internal.SessionInfo;
import com.google.firebase.auth.zzaa;
import kotlin.ranges.RangesKt;
import okhttp3.Headers;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatCheckedTextView extends CheckedTextView implements TintableCompoundDrawablesView {
    public AppCompatEmojiTextHelper mAppCompatEmojiTextHelper;
    public final SessionInfo mBackgroundTintHelper;
    public final AppCompatCompoundButtonHelper mCheckedHelper;
    public final AppCompatTextHelper mTextHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        super(context, attributeSet, R.attr.checkedTextViewStyle);
        TintContextWrapper.wrap(context);
        ThemeUtils.checkAppCompatTheme(getContext(), this);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, R.attr.checkedTextViewStyle);
        appCompatTextHelper.applyCompoundDrawablesTints();
        SessionInfo sessionInfo = new SessionInfo(this);
        this.mBackgroundTintHelper = sessionInfo;
        sessionInfo.loadFromAttributes(attributeSet, R.attr.checkedTextViewStyle);
        this.mCheckedHelper = new AppCompatCompoundButtonHelper(this);
        Context context2 = getContext();
        int[] iArr = R$styleable.CheckedTextView;
        zzaa zzaaVarObtainStyledAttributes = zzaa.obtainStyledAttributes(context2, attributeSet, iArr, R.attr.checkedTextViewStyle);
        TypedArray typedArray = (TypedArray) zzaaVarObtainStyledAttributes.zzb;
        ViewCompat.saveAttributeDataForStyleable(this, getContext(), iArr, attributeSet, (TypedArray) zzaaVarObtainStyledAttributes.zzb, R.attr.checkedTextViewStyle);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    setCheckMarkDrawable(Headers.Companion.getDrawable(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        setCheckMarkDrawable(Headers.Companion.getDrawable(getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                setCheckMarkDrawable(Headers.Companion.getDrawable(getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                setCheckMarkTintList(zzaaVarObtainStyledAttributes.getColorStateList(2));
            }
            if (typedArray.hasValue(3)) {
                setCheckMarkTintMode(DrawableUtils.parseTintMode(typedArray.getInt(3, -1), null));
            }
            zzaaVarObtainStyledAttributes.recycle();
            getEmojiTextViewHelper().loadFromAttributes(attributeSet, R.attr.checkedTextViewStyle);
        } catch (Throwable th) {
            zzaaVarObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new AppCompatEmojiTextHelper(this);
        }
        return this.mAppCompatEmojiTextHelper;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.applySupportBackgroundTint();
        }
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCheckedHelper;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.applyCheckMarkTint();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return RangesKt.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
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

    public ColorStateList getSupportCheckMarkTintList() {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCheckedHelper;
        if (appCompatCompoundButtonHelper != null) {
            return appCompatCompoundButtonHelper.mButtonTintList;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCheckedHelper;
        if (appCompatCompoundButtonHelper != null) {
            return appCompatCompoundButtonHelper.mButtonTintMode;
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
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().setAllCaps(z);
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

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCheckedHelper;
        if (appCompatCompoundButtonHelper != null) {
            if (appCompatCompoundButtonHelper.mSkipNextApply) {
                appCompatCompoundButtonHelper.mSkipNextApply = false;
            } else {
                appCompatCompoundButtonHelper.mSkipNextApply = true;
                appCompatCompoundButtonHelper.applyCheckMarkTint();
            }
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

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(RangesKt.wrapCustomSelectionActionModeCallback(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().setEnabled(z);
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

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCheckedHelper;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.mButtonTintList = colorStateList;
            appCompatCompoundButtonHelper.mHasButtonTint = true;
            appCompatCompoundButtonHelper.applyCheckMarkTint();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCheckedHelper;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.mButtonTintMode = mode;
            appCompatCompoundButtonHelper.mHasButtonTintMode = true;
            appCompatCompoundButtonHelper.applyCheckMarkTint();
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

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(Headers.Companion.getDrawable(getContext(), i));
    }
}
