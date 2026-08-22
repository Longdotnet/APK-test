package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat$Api21Impl;
import androidx.core.widget.CompoundButtonCompat$Api23Impl;
import com.google.firebase.auth.zzaa;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatCompoundButtonHelper {
    public ColorStateList mButtonTintList = null;
    public PorterDuff.Mode mButtonTintMode = null;
    public boolean mHasButtonTint = false;
    public boolean mHasButtonTintMode = false;
    public boolean mSkipNextApply;
    public final TextView mView;

    public /* synthetic */ AppCompatCompoundButtonHelper(TextView textView) {
        this.mView = textView;
    }

    public void applyButtonTint() {
        CompoundButton compoundButton = (CompoundButton) this.mView;
        Drawable buttonDrawable = CompoundButtonCompat$Api23Impl.getButtonDrawable(compoundButton);
        if (buttonDrawable != null) {
            if (this.mHasButtonTint || this.mHasButtonTintMode) {
                Drawable drawableMutate = buttonDrawable.mutate();
                if (this.mHasButtonTint) {
                    DrawableCompat$Api21Impl.setTintList(drawableMutate, this.mButtonTintList);
                }
                if (this.mHasButtonTintMode) {
                    DrawableCompat$Api21Impl.setTintMode(drawableMutate, this.mButtonTintMode);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(drawableMutate);
            }
        }
    }

    public void applyCheckMarkTint() {
        AppCompatCheckedTextView appCompatCheckedTextView = (AppCompatCheckedTextView) this.mView;
        Drawable checkMarkDrawable = appCompatCheckedTextView.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.mHasButtonTint || this.mHasButtonTintMode) {
                Drawable drawableMutate = checkMarkDrawable.mutate();
                if (this.mHasButtonTint) {
                    DrawableCompat$Api21Impl.setTintList(drawableMutate, this.mButtonTintList);
                }
                if (this.mHasButtonTintMode) {
                    DrawableCompat$Api21Impl.setTintMode(drawableMutate, this.mButtonTintMode);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(appCompatCheckedTextView.getDrawableState());
                }
                appCompatCheckedTextView.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = (CompoundButton) this.mView;
        Context context = compoundButton.getContext();
        int[] iArr = R$styleable.CompoundButton;
        zzaa zzaaVarObtainStyledAttributes = zzaa.obtainStyledAttributes(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) zzaaVarObtainStyledAttributes.zzb;
        ViewCompat.saveAttributeDataForStyleable(compoundButton, compoundButton.getContext(), iArr, attributeSet, (TypedArray) zzaaVarObtainStyledAttributes.zzb, i);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(Headers.Companion.getDrawable(compoundButton.getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        compoundButton.setButtonDrawable(Headers.Companion.getDrawable(compoundButton.getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                compoundButton.setButtonDrawable(Headers.Companion.getDrawable(compoundButton.getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                CompoundButtonCompat$Api21Impl.setButtonTintList(compoundButton, zzaaVarObtainStyledAttributes.getColorStateList(2));
            }
            if (typedArray.hasValue(3)) {
                CompoundButtonCompat$Api21Impl.setButtonTintMode(compoundButton, DrawableUtils.parseTintMode(typedArray.getInt(3, -1), null));
            }
        } finally {
            zzaaVarObtainStyledAttributes.recycle();
        }
    }
}
