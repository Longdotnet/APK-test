package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.cardview.R$styleable;
import androidx.room.RoomOpenHelper;
import androidx.work.InputMergerFactory$1;

/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {
    public static final int[] COLOR_BACKGROUND_ATTR = {R.attr.colorBackground};
    public static final InputMergerFactory$1 IMPL = new InputMergerFactory$1(5);
    public final RoomOpenHelper mCardViewDelegate;
    public boolean mCompatPadding;
    public final Rect mContentPadding;
    public boolean mPreventCornerOverlap;
    public final Rect mShadowBounds;

    public CardView(Context context, AttributeSet attributeSet) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, com.daerisoft.thespikerm.R.attr.cardViewStyle);
        Rect rect = new Rect();
        this.mContentPadding = rect;
        this.mShadowBounds = new Rect();
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(this);
        this.mCardViewDelegate = roomOpenHelper;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CardView, com.daerisoft.thespikerm.R.attr.cardViewStyle, com.daerisoft.thespikerm.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(com.daerisoft.thespikerm.R.color.cardview_light_background) : getResources().getColor(com.daerisoft.thespikerm.R.color.cardview_dark_background));
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
        this.mCompatPadding = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.mPreventCornerOverlap = typedArrayObtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        InputMergerFactory$1 inputMergerFactory$1 = IMPL;
        RoundRectDrawable roundRectDrawable = new RoundRectDrawable(colorStateListValueOf, dimension);
        roomOpenHelper.mConfiguration = roundRectDrawable;
        setBackgroundDrawable(roundRectDrawable);
        setClipToOutline(true);
        setElevation(dimension2);
        inputMergerFactory$1.setMaxElevation(roomOpenHelper, dimension3);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((RoundRectDrawable) ((Drawable) this.mCardViewDelegate.mConfiguration)).mBackground;
    }

    public float getCardElevation() {
        return ((CardView) this.mCardViewDelegate.mDelegate).getElevation();
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return ((RoundRectDrawable) ((Drawable) this.mCardViewDelegate.mConfiguration)).mPadding;
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return ((RoundRectDrawable) ((Drawable) this.mCardViewDelegate.mConfiguration)).mRadius;
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        RoundRectDrawable roundRectDrawable = (RoundRectDrawable) ((Drawable) this.mCardViewDelegate.mConfiguration);
        if (colorStateListValueOf == null) {
            roundRectDrawable.getClass();
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        roundRectDrawable.mBackground = colorStateListValueOf;
        roundRectDrawable.mPaint.setColor(colorStateListValueOf.getColorForState(roundRectDrawable.getState(), roundRectDrawable.mBackground.getDefaultColor()));
        roundRectDrawable.invalidateSelf();
    }

    public void setCardElevation(float f) {
        ((CardView) this.mCardViewDelegate.mDelegate).setElevation(f);
    }

    public void setMaxCardElevation(float f) {
        IMPL.setMaxElevation(this.mCardViewDelegate, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z;
            InputMergerFactory$1 inputMergerFactory$1 = IMPL;
            RoomOpenHelper roomOpenHelper = this.mCardViewDelegate;
            inputMergerFactory$1.setMaxElevation(roomOpenHelper, ((RoundRectDrawable) ((Drawable) roomOpenHelper.mConfiguration)).mPadding);
        }
    }

    public void setRadius(float f) {
        RoundRectDrawable roundRectDrawable = (RoundRectDrawable) ((Drawable) this.mCardViewDelegate.mConfiguration);
        if (f == roundRectDrawable.mRadius) {
            return;
        }
        roundRectDrawable.mRadius = f;
        roundRectDrawable.updateBounds(null);
        roundRectDrawable.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            InputMergerFactory$1 inputMergerFactory$1 = IMPL;
            RoomOpenHelper roomOpenHelper = this.mCardViewDelegate;
            inputMergerFactory$1.setMaxElevation(roomOpenHelper, ((RoundRectDrawable) ((Drawable) roomOpenHelper.mConfiguration)).mPadding);
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        RoundRectDrawable roundRectDrawable = (RoundRectDrawable) ((Drawable) this.mCardViewDelegate.mConfiguration);
        if (colorStateList == null) {
            roundRectDrawable.getClass();
            colorStateList = ColorStateList.valueOf(0);
        }
        roundRectDrawable.mBackground = colorStateList;
        roundRectDrawable.mPaint.setColor(colorStateList.getColorForState(roundRectDrawable.getState(), roundRectDrawable.mBackground.getDefaultColor()));
        roundRectDrawable.invalidateSelf();
    }
}
