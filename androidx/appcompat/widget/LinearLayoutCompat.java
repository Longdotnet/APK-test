package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import com.google.firebase.auth.zzaa;

/* JADX INFO: loaded from: classes.dex */
public abstract class LinearLayoutCompat extends ViewGroup {
    public boolean mBaselineAligned;
    public int mBaselineAlignedChildIndex;
    public int mBaselineChildTop;
    public Drawable mDivider;
    public int mDividerHeight;
    public int mDividerPadding;
    public int mDividerWidth;
    public int mGravity;
    public int[] mMaxAscent;
    public int[] mMaxDescent;
    public int mOrientation;
    public int mShowDividers;
    public int mTotalLength;
    public boolean mUseLargestChild;
    public float mWeightSum;

    public class LayoutParams extends LinearLayout.LayoutParams {
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        int[] iArr = R$styleable.LinearLayoutCompat;
        zzaa zzaaVarObtainStyledAttributes = zzaa.obtainStyledAttributes(context, attributeSet, iArr, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, (TypedArray) zzaaVarObtainStyledAttributes.zzb, 0);
        TypedArray typedArray = (TypedArray) zzaaVarObtainStyledAttributes.zzb;
        int i = typedArray.getInt(1, -1);
        if (i >= 0) {
            setOrientation(i);
        }
        int i2 = typedArray.getInt(0, -1);
        if (i2 >= 0) {
            setGravity(i2);
        }
        boolean z = typedArray.getBoolean(2, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = typedArray.getFloat(4, -1.0f);
        this.mBaselineAlignedChildIndex = typedArray.getInt(3, -1);
        this.mUseLargestChild = typedArray.getBoolean(7, false);
        setDividerDrawable(zzaaVarObtainStyledAttributes.getDrawable(5));
        this.mShowDividers = typedArray.getInt(8, 0);
        this.mDividerPadding = typedArray.getDimensionPixelSize(6, 0);
        zzaaVarObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    public final void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.mBaselineAlignedChildIndex;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.mBaselineChildTop;
        if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public final boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if ((this.mShowDividers & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i;
        int bottom;
        if (this.mDivider == null) {
            return;
        }
        int i2 = 0;
        if (this.mOrientation == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i2 < virtualChildCount) {
                View childAt = getChildAt(i2);
                if (childAt != null && childAt.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
                    drawHorizontalDivider(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin) - this.mDividerHeight);
                }
                i2++;
            }
            if (hasDividerBeforeChildAt(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                if (childAt2 == null) {
                    bottom = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
                } else {
                    bottom = childAt2.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) childAt2.getLayoutParams())).bottomMargin;
                }
                drawHorizontalDivider(canvas, bottom);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean z = ViewUtils.sInitComputeFitSystemWindowsMethod;
        boolean z2 = getLayoutDirection() == 1;
        while (i2 < virtualChildCount2) {
            View childAt3 = getChildAt(i2);
            if (childAt3 != null && childAt3.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
                LayoutParams layoutParams = (LayoutParams) childAt3.getLayoutParams();
                drawVerticalDivider(canvas, z2 ? childAt3.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.mDividerWidth);
            }
            i2++;
        }
        if (hasDividerBeforeChildAt(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                LayoutParams layoutParams2 = (LayoutParams) childAt4.getLayoutParams();
                if (z2) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    i = this.mDividerWidth;
                    right = left - i;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                }
            } else if (z2) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.mDividerWidth;
                right = left - i;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0099  */
    /* JADX WARN: Code duplicated, block: B:61:0x0156  */
    /* JADX WARN: Code duplicated, block: B:64:0x015f  */
    /* JADX WARN: Code duplicated, block: B:66:0x0163  */
    /* JADX WARN: Code duplicated, block: B:68:0x0167  */
    /* JADX WARN: Code duplicated, block: B:69:0x016a  */
    /* JADX WARN: Code duplicated, block: B:71:0x0172  */
    /* JADX WARN: Code duplicated, block: B:72:0x0180  */
    /* JADX WARN: Code duplicated, block: B:74:0x0186  */
    /* JADX WARN: Code duplicated, block: B:75:0x018f  */
    /* JADX WARN: Code duplicated, block: B:78:0x01a1  */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        int i7;
        int i8;
        int baseline;
        int i9;
        int i10;
        int measuredHeight;
        int paddingTop;
        int i11;
        int i12;
        int i13;
        int i14 = 8;
        if (this.mOrientation == 1) {
            int paddingLeft2 = getPaddingLeft();
            int i15 = i3 - i;
            int paddingRight = i15 - getPaddingRight();
            int paddingRight2 = (i15 - paddingLeft2) - getPaddingRight();
            int virtualChildCount = getVirtualChildCount();
            int i16 = this.mGravity;
            int i17 = i16 & 112;
            int i18 = 8388615 & i16;
            if (i17 != 16) {
                paddingTop = i17 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.mTotalLength;
            } else {
                paddingTop = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
            }
            int i19 = 0;
            while (i19 < virtualChildCount) {
                View childAt = getChildAt(i19);
                if (childAt != null && childAt.getVisibility() != i14) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int i20 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                    if (i20 < 0) {
                        i20 = i18;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i20, getLayoutDirection()) & 7;
                    if (absoluteGravity != 1) {
                        if (absoluteGravity != 5) {
                            i13 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft2;
                        } else {
                            i11 = paddingRight - measuredWidth;
                            i12 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        }
                        if (hasDividerBeforeChildAt(i19)) {
                            paddingTop += this.mDividerHeight;
                        }
                        int i21 = paddingTop + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        childAt.layout(i13, i21, measuredWidth + i13, i21 + measuredHeight2);
                        paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i21;
                    } else {
                        i11 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft2 + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        i12 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    }
                    i13 = i11 - i12;
                    if (hasDividerBeforeChildAt(i19)) {
                        paddingTop += this.mDividerHeight;
                    }
                    int i22 = paddingTop + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    childAt.layout(i13, i22, measuredWidth + i13, i22 + measuredHeight2);
                    paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i22;
                }
                i19++;
                i14 = 8;
            }
            return;
        }
        boolean z2 = ViewUtils.sInitComputeFitSystemWindowsMethod;
        boolean z3 = getLayoutDirection() == 1;
        int paddingTop2 = getPaddingTop();
        int i23 = i4 - i2;
        int paddingBottom = i23 - getPaddingBottom();
        int paddingBottom2 = (i23 - paddingTop2) - getPaddingBottom();
        int virtualChildCount2 = getVirtualChildCount();
        int i24 = this.mGravity;
        int i25 = 8388615 & i24;
        int i26 = i24 & 112;
        boolean z4 = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i25, getLayoutDirection());
        if (absoluteGravity2 != 1) {
            paddingLeft = absoluteGravity2 != 5 ? getPaddingLeft() : ((getPaddingLeft() + i3) - i) - this.mTotalLength;
        } else {
            paddingLeft = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
        }
        if (z3) {
            i6 = virtualChildCount2 - 1;
            i5 = -1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i27 = 0;
        while (i27 < virtualChildCount2) {
            int i28 = (i5 * i27) + i6;
            View childAt2 = getChildAt(i28);
            if (childAt2 == null) {
                i5 = i5;
                i7 = virtualChildCount2;
                i26 = i26;
                i8 = 1;
            } else {
                if (childAt2.getVisibility() != 8) {
                    int measuredWidth2 = childAt2.getMeasuredWidth();
                    int measuredHeight3 = childAt2.getMeasuredHeight();
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (z4) {
                        i7 = virtualChildCount2;
                        baseline = ((LinearLayout.LayoutParams) layoutParams2).height != -1 ? childAt2.getBaseline() : -1;
                        i9 = ((LinearLayout.LayoutParams) layoutParams2).gravity;
                        if (i9 < 0) {
                            i9 = i26;
                        }
                        i10 = i9 & 112;
                        if (i10 != 16) {
                            measuredHeight = ((((paddingBottom2 - measuredHeight3) / 2) + paddingTop2) + ((LinearLayout.LayoutParams) layoutParams2).topMargin) - ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                        } else if (i10 != 48) {
                            measuredHeight = ((LinearLayout.LayoutParams) layoutParams2).topMargin + paddingTop2;
                            if (baseline != -1) {
                                measuredHeight = (iArr[1] - baseline) + measuredHeight;
                            }
                        } else if (i10 != 80) {
                            measuredHeight = paddingTop2;
                        } else {
                            measuredHeight = (paddingBottom - measuredHeight3) - ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                            if (baseline != -1) {
                                measuredHeight -= iArr2[2] - (childAt2.getMeasuredHeight() - baseline);
                            }
                        }
                        if (hasDividerBeforeChildAt(i28)) {
                            paddingLeft += this.mDividerWidth;
                        }
                        int i29 = paddingLeft + ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                        childAt2.layout(i29, measuredHeight, i29 + measuredWidth2, measuredHeight + measuredHeight3);
                        paddingLeft = measuredWidth2 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + i29;
                    } else {
                        i7 = virtualChildCount2;
                    }
                    i9 = ((LinearLayout.LayoutParams) layoutParams2).gravity;
                    if (i9 < 0) {
                        i9 = i26;
                    }
                    i10 = i9 & 112;
                    if (i10 != 16) {
                        measuredHeight = ((((paddingBottom2 - measuredHeight3) / 2) + paddingTop2) + ((LinearLayout.LayoutParams) layoutParams2).topMargin) - ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                    } else if (i10 != 48) {
                        measuredHeight = ((LinearLayout.LayoutParams) layoutParams2).topMargin + paddingTop2;
                        if (baseline != -1) {
                            measuredHeight = (iArr[1] - baseline) + measuredHeight;
                        }
                    } else if (i10 != 80) {
                        measuredHeight = paddingTop2;
                    } else {
                        measuredHeight = (paddingBottom - measuredHeight3) - ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                        if (baseline != -1) {
                            measuredHeight -= iArr2[2] - (childAt2.getMeasuredHeight() - baseline);
                        }
                    }
                    if (hasDividerBeforeChildAt(i28)) {
                        paddingLeft += this.mDividerWidth;
                    }
                    int i210 = paddingLeft + ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    childAt2.layout(i210, measuredHeight, i210 + measuredWidth2, measuredHeight + measuredHeight3);
                    paddingLeft = measuredWidth2 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + i210;
                } else {
                    i7 = virtualChildCount2;
                }
                i8 = 1;
            }
            i27 += i8;
            i6 = i6;
            i5 = i5;
            virtualChildCount2 = i7;
            i26 = i26;
        }
    }

    /* JADX WARN: Code duplicated, block: B:153:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:213:0x0486  */
    /* JADX WARN: Code duplicated, block: B:214:0x048b  */
    /* JADX WARN: Code duplicated, block: B:217:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:218:0x04b8  */
    /* JADX WARN: Code duplicated, block: B:221:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:222:0x04cc  */
    /* JADX WARN: Code duplicated, block: B:224:0x04de  */
    /* JADX WARN: Code duplicated, block: B:230:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:240:0x0537  */
    /* JADX WARN: Code duplicated, block: B:246:0x0548  */
    /* JADX WARN: Code duplicated, block: B:249:0x0550 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:250:0x0552  */
    /* JADX WARN: Code duplicated, block: B:252:0x055b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:253:0x055d  */
    /* JADX WARN: Code duplicated, block: B:280:0x05e4  */
    /* JADX WARN: Code duplicated, block: B:282:0x05ea  */
    /* JADX WARN: Code duplicated, block: B:283:0x05ef  */
    /* JADX WARN: Code duplicated, block: B:286:0x05f8  */
    /* JADX WARN: Code duplicated, block: B:288:0x0600  */
    /* JADX WARN: Code duplicated, block: B:289:0x060c  */
    /* JADX WARN: Code duplicated, block: B:313:0x0691  */
    /* JADX WARN: Code duplicated, block: B:315:0x0698  */
    /* JADX WARN: Code duplicated, block: B:318:0x06b4  */
    /* JADX WARN: Code duplicated, block: B:320:0x06ba  */
    /* JADX WARN: Code duplicated, block: B:322:0x06c2  */
    /* JADX WARN: Code duplicated, block: B:368:0x07cb  */
    /* JADX WARN: Code duplicated, block: B:373:0x07f5  */
    /* JADX WARN: Code duplicated, block: B:381:0x0806  */
    /* JADX WARN: Code duplicated, block: B:388:0x083d  */
    /* JADX WARN: Code duplicated, block: B:391:0x0860  */
    /* JADX WARN: Code duplicated, block: B:393:0x086e  */
    /* JADX WARN: Code duplicated, block: B:395:0x087a  */
    /* JADX WARN: Code duplicated, block: B:397:0x0886  */
    /* JADX WARN: Code duplicated, block: B:398:0x089b  */
    /* JADX WARN: Code duplicated, block: B:429:0x061c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:437:0x089c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:442:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        char c;
        int iMax;
        int i3;
        float f;
        int i4;
        int i5;
        int i6;
        char c2;
        int i7;
        View childAt;
        int i8;
        int i9;
        int i10;
        int baseline;
        int i11;
        int iMakeMeasureSpec;
        int i12;
        View childAt2;
        LayoutParams layoutParams;
        int i13;
        View childAt3;
        LayoutParams layoutParams2;
        float f2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z;
        boolean z2;
        LayoutParams layoutParams3;
        int measuredWidth;
        boolean z3;
        int i20;
        boolean z4;
        int i21;
        int measuredHeight;
        boolean z5;
        int baseline2;
        int i22;
        int i23;
        boolean z6;
        int i24;
        int i25;
        boolean z7;
        LayoutParams layoutParams4;
        boolean z8;
        int i26;
        boolean z9;
        int iMax2;
        int i27 = -2;
        int i28 = 1073741824;
        int i29 = 8;
        int i30 = Integer.MIN_VALUE;
        float f3 = 0.0f;
        boolean z10 = true;
        if (this.mOrientation == 1) {
            this.mTotalLength = 0;
            int virtualChildCount = getVirtualChildCount();
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int i31 = this.mBaselineAlignedChildIndex;
            boolean z11 = this.mUseLargestChild;
            boolean z12 = true;
            int i32 = 0;
            int iMax3 = 0;
            int iMax4 = 0;
            boolean z13 = false;
            int iMax5 = 0;
            int i33 = 0;
            int i34 = 0;
            boolean z14 = false;
            float f4 = 0.0f;
            while (i32 < virtualChildCount) {
                View childAt4 = getChildAt(i32);
                if (childAt4 == null) {
                    this.mTotalLength = this.mTotalLength;
                } else {
                    if (childAt4.getVisibility() != i29) {
                        if (hasDividerBeforeChildAt(i32)) {
                            this.mTotalLength += this.mDividerHeight;
                        }
                        LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                        float f5 = ((LinearLayout.LayoutParams) layoutParams5).weight;
                        f4 += f5;
                        if (mode2 == i28 && ((LinearLayout.LayoutParams) layoutParams5).height == 0 && f5 > f3) {
                            int i35 = this.mTotalLength;
                            this.mTotalLength = Math.max(i35, ((LinearLayout.LayoutParams) layoutParams5).topMargin + i35 + ((LinearLayout.LayoutParams) layoutParams5).bottomMargin);
                            layoutParams4 = layoutParams5;
                            z8 = true;
                            z7 = true;
                        } else {
                            if (((LinearLayout.LayoutParams) layoutParams5).height != 0 || f5 <= f3) {
                                i25 = i30;
                            } else {
                                ((LinearLayout.LayoutParams) layoutParams5).height = i27;
                                i25 = 0;
                            }
                            int i36 = f4 == f3 ? this.mTotalLength : 0;
                            z7 = true;
                            layoutParams4 = layoutParams5;
                            measureChildWithMargins(childAt4, i, 0, i2, i36);
                            if (i25 != i30) {
                                ((LinearLayout.LayoutParams) layoutParams4).height = i25;
                            }
                            int measuredHeight2 = childAt4.getMeasuredHeight();
                            int i37 = this.mTotalLength;
                            this.mTotalLength = Math.max(i37, i37 + measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams4).topMargin + ((LinearLayout.LayoutParams) layoutParams4).bottomMargin);
                            int i38 = iMax5;
                            if (z11) {
                                iMax5 = Math.max(measuredHeight2, i38);
                            }
                            z8 = z13;
                        }
                        if (i31 >= 0 && i31 == i32 + 1) {
                            this.mBaselineChildTop = this.mTotalLength;
                        }
                        if (i32 < i31 && ((LinearLayout.LayoutParams) layoutParams4).weight > 0.0f) {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                        i26 = mode;
                        if (i26 == 1073741824 || ((LinearLayout.LayoutParams) layoutParams4).width != -1) {
                            z9 = false;
                        } else {
                            z9 = z7;
                            z14 = z9;
                        }
                        int i39 = ((LinearLayout.LayoutParams) layoutParams4).leftMargin + ((LinearLayout.LayoutParams) layoutParams4).rightMargin;
                        int measuredWidth2 = childAt4.getMeasuredWidth() + i39;
                        iMax2 = Math.max(i33, measuredWidth2);
                        int iCombineMeasuredStates = View.combineMeasuredStates(i34, childAt4.getMeasuredState());
                        boolean z15 = (z12 && ((LinearLayout.LayoutParams) layoutParams4).width == -1) ? z7 : false;
                        if (((LinearLayout.LayoutParams) layoutParams4).weight > 0.0f) {
                            if (!z9) {
                                i39 = measuredWidth2;
                            }
                            iMax4 = Math.max(iMax4, i39);
                        } else {
                            int i40 = iMax4;
                            if (!z9) {
                                i39 = measuredWidth2;
                            }
                            iMax3 = Math.max(iMax3, i39);
                            iMax4 = i40;
                        }
                        z13 = z8;
                        i34 = iCombineMeasuredStates;
                        z12 = z15;
                    }
                    i32++;
                    mode = i26;
                    i33 = iMax2;
                    i31 = i31;
                    z10 = z7;
                    mode2 = mode2;
                    virtualChildCount = virtualChildCount;
                    i27 = -2;
                    i28 = 1073741824;
                    i29 = 8;
                    i30 = Integer.MIN_VALUE;
                    f3 = 0.0f;
                }
                i31 = i31;
                mode2 = mode2;
                i26 = mode;
                virtualChildCount = virtualChildCount;
                iMax2 = i33;
                z7 = true;
                i32++;
                mode = i26;
                i33 = iMax2;
                i31 = i31;
                z10 = z7;
                mode2 = mode2;
                virtualChildCount = virtualChildCount;
                i27 = -2;
                i28 = 1073741824;
                i29 = 8;
                i30 = Integer.MIN_VALUE;
                f3 = 0.0f;
            }
            int i41 = mode2;
            int i42 = mode;
            int i43 = virtualChildCount;
            boolean z16 = z10;
            int iMax6 = iMax3;
            int i44 = iMax4;
            int i45 = iMax5;
            int i46 = i33;
            int iCombineMeasuredStates2 = i34;
            if (this.mTotalLength > 0 && hasDividerBeforeChildAt(i43)) {
                this.mTotalLength += this.mDividerHeight;
            }
            int i47 = i41;
            if (z11 && (i47 == Integer.MIN_VALUE || i47 == 0)) {
                this.mTotalLength = 0;
                for (int i48 = 0; i48 < i43; i48++) {
                    View childAt5 = getChildAt(i48);
                    if (childAt5 == null) {
                        this.mTotalLength = this.mTotalLength;
                    } else if (childAt5.getVisibility() != 8) {
                        LayoutParams layoutParams6 = (LayoutParams) childAt5.getLayoutParams();
                        int i49 = this.mTotalLength;
                        this.mTotalLength = Math.max(i49, i49 + i45 + ((LinearLayout.LayoutParams) layoutParams6).topMargin + ((LinearLayout.LayoutParams) layoutParams6).bottomMargin);
                    }
                }
            }
            int paddingBottom = getPaddingBottom() + getPaddingTop() + this.mTotalLength;
            this.mTotalLength = paddingBottom;
            int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, 0);
            int i50 = (16777215 & iResolveSizeAndState) - this.mTotalLength;
            if (z13 || (i50 != 0 && f4 > 0.0f)) {
                float f6 = this.mWeightSum;
                if (f6 > 0.0f) {
                    f4 = f6;
                }
                this.mTotalLength = 0;
                int i51 = 0;
                while (i51 < i43) {
                    View childAt6 = getChildAt(i51);
                    if (childAt6.getVisibility() == 8) {
                        i22 = i47;
                    } else {
                        LayoutParams layoutParams7 = (LayoutParams) childAt6.getLayoutParams();
                        float f7 = ((LinearLayout.LayoutParams) layoutParams7).weight;
                        if (f7 > 0.0f) {
                            int i52 = (int) ((i50 * f7) / f4);
                            f4 -= f7;
                            int i53 = i50 - i52;
                            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams7).leftMargin + ((LinearLayout.LayoutParams) layoutParams7).rightMargin, ((LinearLayout.LayoutParams) layoutParams7).width);
                            if (((LinearLayout.LayoutParams) layoutParams7).height == 0) {
                                i24 = 1073741824;
                                if (i47 == 1073741824) {
                                    if (i52 <= 0) {
                                        i52 = 0;
                                    }
                                    childAt6.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i52, 1073741824));
                                }
                                iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, childAt6.getMeasuredState() & (-256));
                                i50 = i53;
                            } else {
                                i24 = 1073741824;
                            }
                            int measuredHeight3 = childAt6.getMeasuredHeight() + i52;
                            if (measuredHeight3 < 0) {
                                measuredHeight3 = 0;
                            }
                            childAt6.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight3, i24));
                            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, childAt6.getMeasuredState() & (-256));
                            i50 = i53;
                        }
                        int i54 = ((LinearLayout.LayoutParams) layoutParams7).leftMargin + ((LinearLayout.LayoutParams) layoutParams7).rightMargin;
                        int measuredWidth3 = childAt6.getMeasuredWidth() + i54;
                        int iMax7 = Math.max(i46, measuredWidth3);
                        if (i42 != 1073741824) {
                            i22 = i47;
                            i23 = -1;
                            if (((LinearLayout.LayoutParams) layoutParams7).width != -1) {
                            }
                            iMax6 = Math.max(iMax6, i54);
                            if (z12 || ((LinearLayout.LayoutParams) layoutParams7).width != i23) {
                                z6 = false;
                            } else {
                                z6 = z16;
                            }
                            int i55 = this.mTotalLength;
                            this.mTotalLength = Math.max(i55, childAt6.getMeasuredHeight() + i55 + ((LinearLayout.LayoutParams) layoutParams7).topMargin + ((LinearLayout.LayoutParams) layoutParams7).bottomMargin);
                            z12 = z6;
                            i46 = iMax7;
                        } else {
                            i22 = i47;
                            i23 = -1;
                        }
                        i54 = measuredWidth3;
                        iMax6 = Math.max(iMax6, i54);
                        if (z12) {
                            z6 = false;
                        } else {
                            z6 = false;
                        }
                        int i56 = this.mTotalLength;
                        this.mTotalLength = Math.max(i56, childAt6.getMeasuredHeight() + i56 + ((LinearLayout.LayoutParams) layoutParams7).topMargin + ((LinearLayout.LayoutParams) layoutParams7).bottomMargin);
                        z12 = z6;
                        i46 = iMax7;
                    }
                    i51++;
                    i47 = i22;
                }
                this.mTotalLength = getPaddingBottom() + getPaddingTop() + this.mTotalLength;
            } else {
                iMax6 = Math.max(iMax6, i44);
                if (z11 && i47 != 1073741824) {
                    for (int i57 = 0; i57 < i43; i57++) {
                        View childAt7 = getChildAt(i57);
                        if (childAt7 != null && childAt7.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) childAt7.getLayoutParams())).weight > 0.0f) {
                            childAt7.measure(View.MeasureSpec.makeMeasureSpec(childAt7.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i45, 1073741824));
                        }
                    }
                }
            }
            int i58 = i46;
            if (z12 || i42 == 1073741824) {
                iMax6 = i58;
            }
            setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax6, getSuggestedMinimumWidth()), i, iCombineMeasuredStates2), iResolveSizeAndState);
            if (z14) {
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                for (int i59 = 0; i59 < i43; i59++) {
                    View childAt8 = getChildAt(i59);
                    if (childAt8.getVisibility() != 8) {
                        LayoutParams layoutParams8 = (LayoutParams) childAt8.getLayoutParams();
                        if (((LinearLayout.LayoutParams) layoutParams8).width == -1) {
                            int i60 = ((LinearLayout.LayoutParams) layoutParams8).height;
                            ((LinearLayout.LayoutParams) layoutParams8).height = childAt8.getMeasuredHeight();
                            measureChildWithMargins(childAt8, iMakeMeasureSpec2, 0, i2, 0);
                            ((LinearLayout.LayoutParams) layoutParams8).height = i60;
                        }
                    }
                }
                return;
            }
            return;
        }
        this.mTotalLength = 0;
        int virtualChildCount2 = getVirtualChildCount();
        int mode3 = View.MeasureSpec.getMode(i);
        int mode4 = View.MeasureSpec.getMode(i2);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z17 = this.mBaselineAligned;
        boolean z18 = this.mUseLargestChild;
        boolean z19 = mode3 == 1073741824;
        boolean z20 = true;
        int iMax8 = 0;
        float f8 = 0.0f;
        int i61 = 0;
        int i62 = 0;
        int i63 = 0;
        int iMax9 = 0;
        int iMax10 = 0;
        boolean z21 = false;
        boolean z22 = false;
        while (i62 < virtualChildCount2) {
            View childAt9 = getChildAt(i62);
            if (childAt9 == null) {
                this.mTotalLength = this.mTotalLength;
                i19 = i62;
                z = z18;
                z2 = z17;
            } else {
                int i64 = iMax8;
                int i65 = i61;
                if (childAt9.getVisibility() == 8) {
                    z2 = z17;
                    iMax8 = i64;
                    i61 = i65;
                    i19 = i62;
                    z = z18;
                } else {
                    if (hasDividerBeforeChildAt(i62)) {
                        this.mTotalLength += this.mDividerWidth;
                    }
                    LayoutParams layoutParams9 = (LayoutParams) childAt9.getLayoutParams();
                    float f9 = ((LinearLayout.LayoutParams) layoutParams9).weight;
                    float f10 = f8 + f9;
                    if (mode3 == 1073741824 && ((LinearLayout.LayoutParams) layoutParams9).width == 0 && f9 > 0.0f) {
                        if (z19) {
                            this.mTotalLength = ((LinearLayout.LayoutParams) layoutParams9).leftMargin + ((LinearLayout.LayoutParams) layoutParams9).rightMargin + this.mTotalLength;
                        } else {
                            int i66 = this.mTotalLength;
                            this.mTotalLength = Math.max(i66, ((LinearLayout.LayoutParams) layoutParams9).leftMargin + i66 + ((LinearLayout.LayoutParams) layoutParams9).rightMargin);
                        }
                        if (z17) {
                            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(0, 0);
                            childAt9.measure(iMakeMeasureSpec3, iMakeMeasureSpec3);
                            layoutParams3 = layoutParams9;
                            i16 = i64;
                            i17 = i65;
                            i19 = i62;
                            z = z18;
                            z2 = z17;
                        } else {
                            layoutParams3 = layoutParams9;
                            i16 = i64;
                            i17 = i65;
                            i19 = i62;
                            i20 = 1073741824;
                            z = z18;
                            z2 = z17;
                            z3 = true;
                        }
                        if (mode4 == i20 && ((LinearLayout.LayoutParams) layoutParams3).height == -1) {
                            z4 = true;
                            z22 = true;
                        } else {
                            z4 = false;
                        }
                        i21 = ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin;
                        measuredHeight = childAt9.getMeasuredHeight() + i21;
                        int iCombineMeasuredStates3 = View.combineMeasuredStates(i63, childAt9.getMeasuredState());
                        if (!z2 && (baseline2 = childAt9.getBaseline()) != -1) {
                            int i67 = ((LinearLayout.LayoutParams) layoutParams3).gravity;
                            if (i67 < 0) {
                                i67 = this.mGravity;
                            }
                            int i68 = (((i67 & 112) >> 4) & (-2)) >> 1;
                            iArr[i68] = Math.max(iArr[i68], baseline2);
                            iArr2[i68] = Math.max(iArr2[i68], measuredHeight - baseline2);
                        }
                        int iMax11 = Math.max(i17, measuredHeight);
                        if (z20 || ((LinearLayout.LayoutParams) layoutParams3).height != -1) {
                            z5 = false;
                        } else {
                            z5 = true;
                        }
                        if (((LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                            if (z4) {
                                measuredHeight = i21;
                            }
                            iMax10 = Math.max(iMax10, measuredHeight);
                            iMax8 = i16;
                        } else {
                            if (z4) {
                                measuredHeight = i21;
                            }
                            iMax8 = Math.max(i16, measuredHeight);
                        }
                        i61 = iMax11;
                        i63 = iCombineMeasuredStates3;
                        z21 = z3;
                        z20 = z5;
                        f8 = f10;
                    } else {
                        int i69 = i62;
                        if (((LinearLayout.LayoutParams) layoutParams9).width == 0) {
                            f2 = 0.0f;
                            if (f9 > 0.0f) {
                                ((LinearLayout.LayoutParams) layoutParams9).width = -2;
                                i14 = 0;
                            }
                            if (f10 == f2) {
                                i15 = this.mTotalLength;
                            } else {
                                i15 = 0;
                            }
                            i16 = i64;
                            i17 = i65;
                            i18 = i14;
                            i19 = i69;
                            z = z18;
                            z2 = z17;
                            measureChildWithMargins(childAt9, i, i15, i2, 0);
                            if (i18 != Integer.MIN_VALUE) {
                                layoutParams3 = layoutParams9;
                                ((LinearLayout.LayoutParams) layoutParams3).width = i18;
                            } else {
                                layoutParams3 = layoutParams9;
                            }
                            measuredWidth = childAt9.getMeasuredWidth();
                            if (z19) {
                                this.mTotalLength = ((LinearLayout.LayoutParams) layoutParams3).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + this.mTotalLength;
                            } else {
                                int i70 = this.mTotalLength;
                                this.mTotalLength = Math.max(i70, i70 + measuredWidth + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin);
                            }
                            if (z) {
                                iMax9 = Math.max(measuredWidth, iMax9);
                            }
                        } else {
                            f2 = 0.0f;
                        }
                        i14 = Integer.MIN_VALUE;
                        if (f10 == f2) {
                            i15 = this.mTotalLength;
                        } else {
                            i15 = 0;
                        }
                        i16 = i64;
                        i17 = i65;
                        i18 = i14;
                        i19 = i69;
                        z = z18;
                        z2 = z17;
                        measureChildWithMargins(childAt9, i, i15, i2, 0);
                        if (i18 != Integer.MIN_VALUE) {
                            layoutParams3 = layoutParams9;
                            ((LinearLayout.LayoutParams) layoutParams3).width = i18;
                        } else {
                            layoutParams3 = layoutParams9;
                        }
                        measuredWidth = childAt9.getMeasuredWidth();
                        if (z19) {
                            this.mTotalLength = ((LinearLayout.LayoutParams) layoutParams3).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + this.mTotalLength;
                        } else {
                            int i71 = this.mTotalLength;
                            this.mTotalLength = Math.max(i71, i71 + measuredWidth + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin);
                        }
                        if (z) {
                            iMax9 = Math.max(measuredWidth, iMax9);
                        }
                    }
                    z3 = z21;
                    i20 = 1073741824;
                    if (mode4 == i20) {
                        z4 = false;
                    } else {
                        z4 = false;
                    }
                    i21 = ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin;
                    measuredHeight = childAt9.getMeasuredHeight() + i21;
                    int iCombineMeasuredStates4 = View.combineMeasuredStates(i63, childAt9.getMeasuredState());
                    if (!z2) {
                    }
                    int iMax12 = Math.max(i17, measuredHeight);
                    if (z20) {
                        z5 = false;
                    } else {
                        z5 = false;
                    }
                    if (((LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                        if (z4) {
                            measuredHeight = i21;
                        }
                        iMax10 = Math.max(iMax10, measuredHeight);
                        iMax8 = i16;
                    } else {
                        if (z4) {
                            measuredHeight = i21;
                        }
                        iMax8 = Math.max(i16, measuredHeight);
                    }
                    i61 = iMax12;
                    i63 = iCombineMeasuredStates4;
                    z21 = z3;
                    z20 = z5;
                    f8 = f10;
                }
            }
            i62 = i19 + 1;
            z18 = z;
            z17 = z2;
        }
        int i72 = i61;
        boolean z23 = z18;
        boolean z24 = z17;
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount2)) {
            this.mTotalLength += this.mDividerWidth;
        }
        int i73 = iArr[1];
        if (i73 == -1 && iArr[0] == -1 && iArr[2] == -1) {
            c = 3;
            if (iArr[3] == -1) {
                iMax = i72;
            }
            if (z23 && (mode3 == Integer.MIN_VALUE || mode3 == 0)) {
                this.mTotalLength = 0;
                for (i13 = 0; i13 < virtualChildCount2; i13++) {
                    childAt3 = getChildAt(i13);
                    if (childAt3 == null) {
                        this.mTotalLength = this.mTotalLength;
                    } else if (childAt3.getVisibility() == 8) {
                        layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                        if (z19) {
                            this.mTotalLength = ((LinearLayout.LayoutParams) layoutParams2).leftMargin + iMax9 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + this.mTotalLength;
                        } else {
                            int i74 = this.mTotalLength;
                            this.mTotalLength = Math.max(i74, i74 + iMax9 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin);
                        }
                    }
                }
            }
            int paddingRight = getPaddingRight() + getPaddingLeft() + this.mTotalLength;
            this.mTotalLength = paddingRight;
            int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, 0);
            i3 = (16777215 & iResolveSizeAndState2) - this.mTotalLength;
            if (!z21 || (i3 != 0 && f8 > 0.0f)) {
                f = this.mWeightSum;
                if (f > 0.0f) {
                    f8 = f;
                }
                iArr[3] = -1;
                iArr[2] = -1;
                iArr[1] = -1;
                iArr[0] = -1;
                iArr2[3] = -1;
                iArr2[2] = -1;
                iArr2[1] = -1;
                iArr2[0] = -1;
                this.mTotalLength = 0;
                int iCombineMeasuredStates5 = i63;
                iMax = -1;
                i4 = 0;
                while (i4 < virtualChildCount2) {
                    childAt = getChildAt(i4);
                    if (childAt != null || childAt.getVisibility() == 8) {
                        i8 = i3;
                        virtualChildCount2 = virtualChildCount2;
                    } else {
                        LayoutParams layoutParams10 = (LayoutParams) childAt.getLayoutParams();
                        float f11 = ((LinearLayout.LayoutParams) layoutParams10).weight;
                        if (f11 > 0.0f) {
                            int i75 = (int) ((i3 * f11) / f8);
                            float f12 = f8 - f11;
                            int i76 = i3 - i75;
                            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop() + ((LinearLayout.LayoutParams) layoutParams10).topMargin + ((LinearLayout.LayoutParams) layoutParams10).bottomMargin, ((LinearLayout.LayoutParams) layoutParams10).height);
                            if (((LinearLayout.LayoutParams) layoutParams10).width == 0) {
                                i11 = 1073741824;
                                if (mode3 == 1073741824) {
                                    if (i75 <= 0) {
                                        i75 = 0;
                                    }
                                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i75, 1073741824), childMeasureSpec2);
                                }
                                iCombineMeasuredStates5 = View.combineMeasuredStates(iCombineMeasuredStates5, childAt.getMeasuredState() & (-16777216));
                                f8 = f12;
                                i9 = i76;
                            } else {
                                i11 = 1073741824;
                            }
                            int measuredWidth4 = childAt.getMeasuredWidth() + i75;
                            if (measuredWidth4 < 0) {
                                measuredWidth4 = 0;
                            }
                            childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth4, i11), childMeasureSpec2);
                            iCombineMeasuredStates5 = View.combineMeasuredStates(iCombineMeasuredStates5, childAt.getMeasuredState() & (-16777216));
                            f8 = f12;
                            i9 = i76;
                        } else {
                            i9 = i3;
                        }
                        if (z19) {
                            this.mTotalLength = childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams10).leftMargin + ((LinearLayout.LayoutParams) layoutParams10).rightMargin + this.mTotalLength;
                        } else {
                            int i77 = this.mTotalLength;
                            this.mTotalLength = Math.max(i77, childAt.getMeasuredWidth() + i77 + ((LinearLayout.LayoutParams) layoutParams10).leftMargin + ((LinearLayout.LayoutParams) layoutParams10).rightMargin);
                        }
                        boolean z25 = mode4 != 1073741824 && ((LinearLayout.LayoutParams) layoutParams10).height == -1;
                        int i78 = ((LinearLayout.LayoutParams) layoutParams10).topMargin + ((LinearLayout.LayoutParams) layoutParams10).bottomMargin;
                        int measuredHeight4 = childAt.getMeasuredHeight() + i78;
                        iMax = Math.max(iMax, measuredHeight4);
                        if (!z25) {
                            i78 = measuredHeight4;
                        }
                        iMax8 = Math.max(iMax8, i78);
                        if (z20) {
                            i10 = -1;
                            boolean z26 = ((LinearLayout.LayoutParams) layoutParams10).height == -1;
                            if (!z24 && (baseline = childAt.getBaseline()) != i10) {
                                int i79 = ((LinearLayout.LayoutParams) layoutParams10).gravity;
                                if (i79 < 0) {
                                    i79 = this.mGravity;
                                }
                                int i80 = (((i79 & 112) >> 4) & (-2)) >> 1;
                                iArr[i80] = Math.max(iArr[i80], baseline);
                                iArr2[i80] = Math.max(iArr2[i80], measuredHeight4 - baseline);
                            }
                            z20 = z26;
                            i8 = i9;
                            f8 = f8;
                        } else {
                            i10 = -1;
                        }
                        if (!z24) {
                        }
                        z20 = z26;
                        i8 = i9;
                        f8 = f8;
                    }
                    i4++;
                    i3 = i8;
                    virtualChildCount2 = virtualChildCount2;
                }
                i5 = virtualChildCount2;
                this.mTotalLength = getPaddingRight() + getPaddingLeft() + this.mTotalLength;
                i6 = iArr[1];
                if (i6 != -1 && iArr[0] == -1 && iArr[2] == -1) {
                    c2 = 3;
                    if (iArr[3] == -1) {
                        i7 = 0;
                    }
                    i63 = iCombineMeasuredStates5;
                } else {
                    c2 = 3;
                }
                i7 = 0;
                iMax = Math.max(iMax, Math.max(iArr2[c2], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c2], Math.max(iArr[0], Math.max(i6, iArr[2]))));
                i63 = iCombineMeasuredStates5;
            } else {
                iMax8 = Math.max(iMax8, iMax10);
                if (z23 && mode3 != 1073741824) {
                    for (int i81 = 0; i81 < virtualChildCount2; i81++) {
                        View childAt10 = getChildAt(i81);
                        if (childAt10 != null && childAt10.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) childAt10.getLayoutParams())).weight > 0.0f) {
                            childAt10.measure(View.MeasureSpec.makeMeasureSpec(iMax9, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt10.getMeasuredHeight(), 1073741824));
                        }
                    }
                }
                i5 = virtualChildCount2;
                i7 = 0;
            }
            if (z20 || mode4 == 1073741824) {
                iMax8 = iMax;
            }
            setMeasuredDimension((i63 & (-16777216)) | iResolveSizeAndState2, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax8, getSuggestedMinimumHeight()), i2, i63 << 16));
            if (z22) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
                i12 = i5;
                while (i7 < i12) {
                    childAt2 = getChildAt(i7);
                    if (childAt2.getVisibility() != 8) {
                        layoutParams = (LayoutParams) childAt2.getLayoutParams();
                        if (((LinearLayout.LayoutParams) layoutParams).height == -1) {
                            int i82 = ((LinearLayout.LayoutParams) layoutParams).width;
                            ((LinearLayout.LayoutParams) layoutParams).width = childAt2.getMeasuredWidth();
                            measureChildWithMargins(childAt2, i, 0, iMakeMeasureSpec, 0);
                            ((LinearLayout.LayoutParams) layoutParams).width = i82;
                        }
                    }
                    i7++;
                }
            }
        }
        c = 3;
        iMax = Math.max(i72, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c], Math.max(iArr[0], Math.max(i73, iArr[2]))));
        if (z23) {
            this.mTotalLength = 0;
            while (i13 < virtualChildCount2) {
                childAt3 = getChildAt(i13);
                if (childAt3 == null) {
                    this.mTotalLength = this.mTotalLength;
                } else if (childAt3.getVisibility() == 8) {
                    layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                    if (z19) {
                        this.mTotalLength = ((LinearLayout.LayoutParams) layoutParams2).leftMargin + iMax9 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + this.mTotalLength;
                    } else {
                        int i710 = this.mTotalLength;
                        this.mTotalLength = Math.max(i710, i710 + iMax9 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin);
                    }
                }
            }
        }
        int paddingRight2 = getPaddingRight() + getPaddingLeft() + this.mTotalLength;
        this.mTotalLength = paddingRight2;
        int iResolveSizeAndState3 = View.resolveSizeAndState(Math.max(paddingRight2, getSuggestedMinimumWidth()), i, 0);
        i3 = (16777215 & iResolveSizeAndState3) - this.mTotalLength;
        if (z21) {
            f = this.mWeightSum;
            if (f > 0.0f) {
                f8 = f;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.mTotalLength = 0;
            int iCombineMeasuredStates6 = i63;
            iMax = -1;
            i4 = 0;
            while (i4 < virtualChildCount2) {
                childAt = getChildAt(i4);
                if (childAt != null) {
                    i8 = i3;
                    virtualChildCount2 = virtualChildCount2;
                } else {
                    i8 = i3;
                    virtualChildCount2 = virtualChildCount2;
                }
                i4++;
                i3 = i8;
                virtualChildCount2 = virtualChildCount2;
            }
            i5 = virtualChildCount2;
            this.mTotalLength = getPaddingRight() + getPaddingLeft() + this.mTotalLength;
            i6 = iArr[1];
            if (i6 != -1) {
                c2 = 3;
                i7 = 0;
                iMax = Math.max(iMax, Math.max(iArr2[c2], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c2], Math.max(iArr[0], Math.max(i6, iArr[2]))));
            } else {
                c2 = 3;
                i7 = 0;
                iMax = Math.max(iMax, Math.max(iArr2[c2], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c2], Math.max(iArr[0], Math.max(i6, iArr[2]))));
            }
            i63 = iCombineMeasuredStates6;
        } else {
            f = this.mWeightSum;
            if (f > 0.0f) {
                f8 = f;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.mTotalLength = 0;
            int iCombineMeasuredStates7 = i63;
            iMax = -1;
            i4 = 0;
            while (i4 < virtualChildCount2) {
                childAt = getChildAt(i4);
                if (childAt != null) {
                    i8 = i3;
                    virtualChildCount2 = virtualChildCount2;
                } else {
                    i8 = i3;
                    virtualChildCount2 = virtualChildCount2;
                }
                i4++;
                i3 = i8;
                virtualChildCount2 = virtualChildCount2;
            }
            i5 = virtualChildCount2;
            this.mTotalLength = getPaddingRight() + getPaddingLeft() + this.mTotalLength;
            i6 = iArr[1];
            if (i6 != -1) {
                c2 = 3;
                i7 = 0;
                iMax = Math.max(iMax, Math.max(iArr2[c2], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c2], Math.max(iArr[0], Math.max(i6, iArr[2]))));
            } else {
                c2 = 3;
                i7 = 0;
                iMax = Math.max(iMax, Math.max(iArr2[c2], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c2], Math.max(iArr[0], Math.max(i6, iArr[2]))));
            }
            i63 = iCombineMeasuredStates7;
        }
        if (z20) {
            iMax8 = iMax;
        } else {
            iMax8 = iMax;
        }
        setMeasuredDimension((i63 & (-16777216)) | iResolveSizeAndState3, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax8, getSuggestedMinimumHeight()), i2, i63 << 16));
        if (z22) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
            i12 = i5;
            while (i7 < i12) {
                childAt2 = getChildAt(i7);
                if (childAt2.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (((LinearLayout.LayoutParams) layoutParams).height == -1) {
                        int i83 = ((LinearLayout.LayoutParams) layoutParams).width;
                        ((LinearLayout.LayoutParams) layoutParams).width = childAt2.getMeasuredWidth();
                        measureChildWithMargins(childAt2, i, 0, iMakeMeasureSpec, 0);
                        ((LinearLayout.LayoutParams) layoutParams).width = i83;
                    }
                }
                i7++;
            }
        }
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.mBaselineAlignedChildIndex = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.mGravity;
        if ((8388615 & i3) != i2) {
            this.mGravity = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.mGravity;
        if ((i3 & 112) != i2) {
            this.mGravity = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
