package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.graphics.drawable.DrawableCompat$Api23Impl;
import androidx.core.view.ViewCompat;
import com.daerisoft.thespikerm.R;
import com.google.firebase.auth.zzaa;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
    public boolean mHasTickMarkTint;
    public boolean mHasTickMarkTintMode;
    public Drawable mTickMark;
    public ColorStateList mTickMarkTintList;
    public PorterDuff.Mode mTickMarkTintMode;
    public final AppCompatSeekBar mView;

    public AppCompatSeekBarHelper(AppCompatSeekBar appCompatSeekBar) {
        super(appCompatSeekBar);
        this.mTickMarkTintList = null;
        this.mTickMarkTintMode = null;
        this.mHasTickMarkTint = false;
        this.mHasTickMarkTintMode = false;
        this.mView = appCompatSeekBar;
    }

    public final void applyTickMarkTint() {
        Drawable drawable = this.mTickMark;
        if (drawable != null) {
            if (this.mHasTickMarkTint || this.mHasTickMarkTintMode) {
                Drawable drawableMutate = drawable.mutate();
                this.mTickMark = drawableMutate;
                if (this.mHasTickMarkTint) {
                    DrawableCompat$Api21Impl.setTintList(drawableMutate, this.mTickMarkTintList);
                }
                if (this.mHasTickMarkTintMode) {
                    DrawableCompat$Api21Impl.setTintMode(this.mTickMark, this.mTickMarkTintMode);
                }
                if (this.mTickMark.isStateful()) {
                    this.mTickMark.setState(this.mView.getDrawableState());
                }
            }
        }
    }

    public final void drawTickMarks(Canvas canvas) {
        if (this.mTickMark != null) {
            AppCompatSeekBar appCompatSeekBar = this.mView;
            int max = appCompatSeekBar.getMax();
            if (max > 1) {
                int intrinsicWidth = this.mTickMark.getIntrinsicWidth();
                int intrinsicHeight = this.mTickMark.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.mTickMark.setBounds(-i, -i2, i, i2);
                float width = ((appCompatSeekBar.getWidth() - appCompatSeekBar.getPaddingLeft()) - appCompatSeekBar.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(appCompatSeekBar.getPaddingLeft(), appCompatSeekBar.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.mTickMark.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    public final void loadFromAttributes(AttributeSet attributeSet, int i) {
        super.loadFromAttributes(attributeSet, R.attr.seekBarStyle);
        AppCompatSeekBar appCompatSeekBar = this.mView;
        Context context = appCompatSeekBar.getContext();
        int[] iArr = R$styleable.AppCompatSeekBar;
        zzaa zzaaVarObtainStyledAttributes = zzaa.obtainStyledAttributes(context, attributeSet, iArr, R.attr.seekBarStyle);
        ViewCompat.saveAttributeDataForStyleable(appCompatSeekBar, appCompatSeekBar.getContext(), iArr, attributeSet, (TypedArray) zzaaVarObtainStyledAttributes.zzb, R.attr.seekBarStyle);
        Drawable drawableIfKnown = zzaaVarObtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            appCompatSeekBar.setThumb(drawableIfKnown);
        }
        Drawable drawable = zzaaVarObtainStyledAttributes.getDrawable(1);
        Drawable drawable2 = this.mTickMark;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTickMark = drawable;
        if (drawable != null) {
            drawable.setCallback(appCompatSeekBar);
            DrawableCompat$Api23Impl.setLayoutDirection(drawable, appCompatSeekBar.getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(appCompatSeekBar.getDrawableState());
            }
            applyTickMarkTint();
        }
        appCompatSeekBar.invalidate();
        TypedArray typedArray = (TypedArray) zzaaVarObtainStyledAttributes.zzb;
        if (typedArray.hasValue(3)) {
            this.mTickMarkTintMode = DrawableUtils.parseTintMode(typedArray.getInt(3, -1), this.mTickMarkTintMode);
            this.mHasTickMarkTintMode = true;
        }
        if (typedArray.hasValue(2)) {
            this.mTickMarkTintList = zzaaVarObtainStyledAttributes.getColorStateList(2);
            this.mHasTickMarkTint = true;
        }
        zzaaVarObtainStyledAttributes.recycle();
        applyTickMarkTint();
    }
}
