package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.work.InputMergerFactory$1;
import com.android.billingclient.api.zzcj;
import com.facebook.ProfileCache;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    public zzcj mActionMenuPresenterCallback;
    public boolean mFormatItems;
    public int mFormatItemsWidth;
    public final int mGeneratedItemPadding;
    public MenuBuilder mMenu;
    public MenuBuilder.Callback mMenuBuilderCallback;
    public final int mMinCellSize;
    public OnMenuItemClickListener mOnMenuItemClickListener;
    public Context mPopupContext;
    public int mPopupTheme;
    public ActionMenuPresenter mPresenter;
    public boolean mReserveOverflow;

    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public final class LayoutParams extends LinearLayoutCompat.LayoutParams {
        public int cellsUsed;
        public boolean expandable;
        public boolean expanded;
        public int extraPixels;
        public boolean isOverflowButton;
        public boolean preventEdgeOffset;
    }

    public interface OnMenuItemClickListener {
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * f);
        this.mGeneratedItemPadding = (int) (f * 4.0f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateLayoutParams(layoutParams);
    }

    public Menu getMenu() {
        if (this.mMenu == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.mMenu = menuBuilder;
            menuBuilder.mCallback = new ProfileCache(this, 5);
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.mPresenter = actionMenuPresenter;
            actionMenuPresenter.mReserveOverflow = true;
            actionMenuPresenter.mReserveOverflowSet = true;
            MenuPresenter.Callback inputMergerFactory$1 = this.mActionMenuPresenterCallback;
            if (inputMergerFactory$1 == null) {
                inputMergerFactory$1 = new InputMergerFactory$1(3);
            }
            actionMenuPresenter.mCallback = inputMergerFactory$1;
            this.mMenu.addMenuPresenter(actionMenuPresenter, this.mPopupContext);
            ActionMenuPresenter actionMenuPresenter2 = this.mPresenter;
            actionMenuPresenter2.mMenuView = this;
            this.mMenu = actionMenuPresenter2.mMenu;
        }
        return this.mMenu;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        ActionMenuPresenter.OverflowMenuButton overflowMenuButton = actionMenuPresenter.mOverflowButton;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (actionMenuPresenter.mPendingOverflowIconSet) {
            return actionMenuPresenter.mPendingOverflowIcon;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public final boolean hasSupportDividerBeforeChildAt(int i) {
        boolean zNeedsDividerAfter = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            zNeedsDividerAfter = ((ActionMenuChildView) childAt).needsDividerAfter();
        }
        return (i <= 0 || !(childAt2 instanceof ActionMenuChildView)) ? zNeedsDividerAfter : zNeedsDividerAfter | ((ActionMenuChildView) childAt2).needsDividerBefore();
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public final void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public final boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, null, 0);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView();
            if (this.mPresenter.isOverflowMenuShowing()) {
                this.mPresenter.hideOverflowMenu();
                this.mPresenter.showOverflowMenu();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.hideOverflowMenu();
            ActionMenuPresenter.OverflowPopup overflowPopup = actionMenuPresenter.mActionButtonPopup;
            if (overflowPopup == null || !overflowPopup.isShowing()) {
                return;
            }
            overflowPopup.mPopup.dismiss();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int paddingLeft;
        if (!this.mFormatItems) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i5 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i6 = i3 - i;
        int paddingRight = (i6 - getPaddingRight()) - getPaddingLeft();
        boolean z2 = ViewUtils.sInitComputeFitSystemWindowsMethod;
        boolean z3 = getLayoutDirection() == 1;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isOverflowButton) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(i9)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (z3) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i10 = i5 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i10, width, measuredHeight + i10);
                    paddingRight -= measuredWidth;
                    i7 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams).leftMargin) + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    hasSupportDividerBeforeChildAt(i9);
                    i8++;
                }
            }
        }
        if (childCount == 1 && i7 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i11 = (i6 / 2) - (measuredWidth2 / 2);
            int i12 = i5 - (measuredHeight2 / 2);
            childAt2.layout(i11, i12, measuredWidth2 + i11, measuredHeight2 + i12);
            return;
        }
        int i13 = i8 - (i7 ^ 1);
        int iMax = Math.max(0, i13 > 0 ? paddingRight / i13 : 0);
        if (z3) {
            int width2 = getWidth() - getPaddingRight();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt3 = getChildAt(i14);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.isOverflowButton) {
                    int i15 = width2 - ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i16 = i5 - (measuredHeight3 / 2);
                    childAt3.layout(i15 - measuredWidth3, i16, i15, measuredHeight3 + i16);
                    width2 = i15 - ((measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt4 = getChildAt(i17);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.isOverflowButton) {
                int i18 = paddingLeft2 + ((LinearLayout.LayoutParams) layoutParams3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i19 = i5 - (measuredHeight4 / 2);
                childAt4.layout(i18, i19, i18 + measuredWidth4, measuredHeight4 + i19);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + iMax + i18;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v36 */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        int i4;
        boolean z2;
        int i5;
        ?? r4;
        int i6;
        MenuBuilder menuBuilder;
        boolean z3 = this.mFormatItems;
        boolean z4 = View.MeasureSpec.getMode(i) == 1073741824;
        this.mFormatItems = z4;
        if (z3 != z4) {
            this.mFormatItemsWidth = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.mFormatItems && (menuBuilder = this.mMenu) != null && size != this.mFormatItemsWidth) {
            this.mFormatItemsWidth = size;
            menuBuilder.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.mFormatItems || childCount <= 0) {
            for (int i7 = 0; i7 < childCount; i7++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i7).getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).rightMargin = 0;
                ((LinearLayout.LayoutParams) layoutParams).leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int size3 = View.MeasureSpec.getSize(i2);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingBottom, -2);
        int i8 = size2 - paddingRight;
        int i9 = this.mMinCellSize;
        int i10 = i8 / i9;
        int i11 = i8 % i9;
        if (i10 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i12 = (i11 / i10) + i9;
        int childCount2 = getChildCount();
        int iMax = 0;
        int i13 = 0;
        int iMax2 = 0;
        int i14 = 0;
        boolean z5 = false;
        int i15 = 0;
        long j = 0;
        while (true) {
            i3 = this.mGeneratedItemPadding;
            if (i14 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i14);
            int i16 = size3;
            int i17 = i8;
            if (childAt.getVisibility() != 8) {
                boolean z6 = childAt instanceof ActionMenuItemView;
                int i18 = i13 + 1;
                if (z6) {
                    childAt.setPadding(i3, 0, i3, 0);
                }
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                layoutParams2.expanded = false;
                layoutParams2.extraPixels = 0;
                layoutParams2.cellsUsed = 0;
                layoutParams2.expandable = false;
                ((LinearLayout.LayoutParams) layoutParams2).leftMargin = 0;
                ((LinearLayout.LayoutParams) layoutParams2).rightMargin = 0;
                layoutParams2.preventEdgeOffset = z6 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i19 = layoutParams2.isOverflowButton ? 1 : i10;
                LayoutParams layoutParams3 = (LayoutParams) childAt.getLayoutParams();
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z6 ? (ActionMenuItemView) childAt : null;
                boolean z7 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                if (i19 <= 0 || (z7 && i19 < 2)) {
                    i6 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i19 * i12, Integer.MIN_VALUE), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i6 = measuredWidth / i12;
                    if (measuredWidth % i12 != 0) {
                        i6++;
                    }
                    if (z7 && i6 < 2) {
                        i6 = 2;
                    }
                }
                layoutParams3.expandable = !layoutParams3.isOverflowButton && z7;
                layoutParams3.cellsUsed = i6;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i6 * i12, 1073741824), iMakeMeasureSpec);
                iMax2 = Math.max(iMax2, i6);
                if (layoutParams2.expandable) {
                    i15++;
                }
                if (layoutParams2.isOverflowButton) {
                    z5 = true;
                }
                i10 -= i6;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (i6 == 1) {
                    j |= (long) (1 << i14);
                }
                i13 = i18;
            }
            i14++;
            size3 = i16;
            i8 = i17;
            paddingBottom = paddingBottom;
            mode = mode;
        }
        int i20 = mode;
        int i21 = i8;
        int i22 = size3;
        boolean z8 = z5 && i13 == 2;
        boolean z9 = false;
        while (true) {
            if (i15 <= 0 || i10 <= 0) {
                z = z9;
                break;
            }
            int i23 = Integer.MAX_VALUE;
            int i24 = 0;
            int i25 = 0;
            long j2 = 0;
            while (i25 < childCount2) {
                LayoutParams layoutParams4 = (LayoutParams) getChildAt(i25).getLayoutParams();
                boolean z10 = z9;
                if (layoutParams4.expandable) {
                    int i26 = layoutParams4.cellsUsed;
                    if (i26 < i23) {
                        j2 = 1 << i25;
                        i23 = i26;
                        i24 = 1;
                    } else if (i26 == i23) {
                        j2 |= 1 << i25;
                        i24++;
                    }
                }
                i25++;
                z9 = z10;
            }
            z = z9;
            j |= j2;
            if (i24 > i10) {
                break;
            }
            int i27 = i23 + 1;
            int i28 = 0;
            while (i28 < childCount2) {
                View childAt2 = getChildAt(i28);
                LayoutParams layoutParams5 = (LayoutParams) childAt2.getLayoutParams();
                int i29 = iMax;
                int i30 = childMeasureSpec;
                int i31 = childCount2;
                long j3 = 1 << i28;
                if ((j2 & j3) != 0) {
                    if (z8 && layoutParams5.preventEdgeOffset) {
                        r4 = 1;
                        r4 = 1;
                        if (i10 == 1) {
                            childAt2.setPadding(i3 + i12, 0, i3, 0);
                        }
                    } else {
                        r4 = 1;
                    }
                    layoutParams5.cellsUsed += r4;
                    layoutParams5.expanded = r4;
                    i10--;
                } else if (layoutParams5.cellsUsed == i27) {
                    j |= j3;
                }
                i28++;
                childMeasureSpec = i30;
                iMax = i29;
                childCount2 = i31;
            }
            z9 = true;
        }
        int i32 = iMax;
        int i33 = childMeasureSpec;
        int i34 = childCount2;
        boolean z11 = !z5 && i13 == 1;
        if (i10 <= 0 || j == 0 || (i10 >= i13 - 1 && !z11 && iMax2 <= 1)) {
            i4 = i34;
            z2 = z;
        } else {
            float fBitCount = Long.bitCount(j);
            if (!z11) {
                if ((j & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                    fBitCount -= 0.5f;
                }
                int i35 = i34 - 1;
                if ((j & ((long) (1 << i35))) != 0 && !((LayoutParams) getChildAt(i35).getLayoutParams()).preventEdgeOffset) {
                    fBitCount -= 0.5f;
                }
            }
            int i36 = fBitCount > 0.0f ? (int) ((i10 * i12) / fBitCount) : 0;
            boolean z12 = z;
            i4 = i34;
            for (int i37 = 0; i37 < i4; i37++) {
                if ((j & ((long) (1 << i37))) != 0) {
                    View childAt3 = getChildAt(i37);
                    LayoutParams layoutParams6 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams6.extraPixels = i36;
                        layoutParams6.expanded = true;
                        if (i37 == 0 && !layoutParams6.preventEdgeOffset) {
                            ((LinearLayout.LayoutParams) layoutParams6).leftMargin = (-i36) / 2;
                        }
                        z12 = true;
                    } else if (layoutParams6.isOverflowButton) {
                        layoutParams6.extraPixels = i36;
                        layoutParams6.expanded = true;
                        ((LinearLayout.LayoutParams) layoutParams6).rightMargin = (-i36) / 2;
                        z12 = true;
                    } else {
                        if (i37 != 0) {
                            ((LinearLayout.LayoutParams) layoutParams6).leftMargin = i36 / 2;
                        }
                        if (i37 != i4 - 1) {
                            ((LinearLayout.LayoutParams) layoutParams6).rightMargin = i36 / 2;
                        }
                    }
                }
            }
            z2 = z12;
        }
        if (z2) {
            int i38 = 0;
            while (i38 < i4) {
                View childAt4 = getChildAt(i38);
                LayoutParams layoutParams7 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams7.expanded) {
                    i5 = i33;
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams7.cellsUsed * i12) + layoutParams7.extraPixels, 1073741824), i5);
                } else {
                    i5 = i33;
                }
                i38++;
                i33 = i5;
            }
        }
        setMeasuredDimension(i21, i20 != 1073741824 ? i32 : i22);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mPresenter.mExpandedActionViewsExclusive = z;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        ActionMenuPresenter.OverflowMenuButton overflowMenuButton = actionMenuPresenter.mOverflowButton;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
        } else {
            actionMenuPresenter.mPendingOverflowIconSet = true;
            actionMenuPresenter.mPendingOverflowIcon = drawable;
        }
    }

    public void setOverflowReserved(boolean z) {
        this.mReserveOverflow = z;
    }

    public void setPopupTheme(int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.mPresenter = actionMenuPresenter;
        actionMenuPresenter.mMenuView = this;
        this.mMenu = actionMenuPresenter.mMenu;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateLayoutParams(layoutParams);
    }

    public static LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.isOverflowButton = false;
        ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
        return layoutParams;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final LinearLayoutCompat.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams != null) {
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams3 = (LayoutParams) layoutParams;
                layoutParams2 = new LayoutParams(layoutParams3);
                layoutParams2.isOverflowButton = layoutParams3.isOverflowButton;
            } else {
                layoutParams2 = new LayoutParams(layoutParams);
            }
            if (((LinearLayout.LayoutParams) layoutParams2).gravity <= 0) {
                ((LinearLayout.LayoutParams) layoutParams2).gravity = 16;
            }
            return layoutParams2;
        }
        return generateDefaultLayoutParams();
    }
}
