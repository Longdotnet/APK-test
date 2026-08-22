package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.daerisoft.thespikerm.R;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static TooltipCompatHandler sActiveHandler;
    public static TooltipCompatHandler sPendingHandler;
    public final View mAnchor;
    public int mAnchorX;
    public int mAnchorY;
    public boolean mForceNextChangeSignificant;
    public boolean mFromTouch;
    public final TooltipCompatHandler$$ExternalSyntheticLambda0 mHideRunnable;
    public final int mHoverSlop;
    public TooltipPopup mPopup;
    public final TooltipCompatHandler$$ExternalSyntheticLambda0 mShowRunnable;
    public final CharSequence mTooltipText;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.appcompat.widget.TooltipCompatHandler$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.TooltipCompatHandler$$ExternalSyntheticLambda0] */
    public TooltipCompatHandler(View view, CharSequence charSequence) {
        final int i = 0;
        this.mShowRunnable = new Runnable(this) { // from class: androidx.appcompat.widget.TooltipCompatHandler$$ExternalSyntheticLambda0
            public final /* synthetic */ TooltipCompatHandler f$0;

            {
                this.f$0 = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case 0:
                        this.f$0.show(false);
                        break;
                    default:
                        this.f$0.hide();
                        break;
                }
            }
        };
        final int i2 = 1;
        this.mHideRunnable = new Runnable(this) { // from class: androidx.appcompat.widget.TooltipCompatHandler$$ExternalSyntheticLambda0
            public final /* synthetic */ TooltipCompatHandler f$0;

            {
                this.f$0 = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        this.f$0.show(false);
                        break;
                    default:
                        this.f$0.hide();
                        break;
                }
            }
        };
        this.mAnchor = view;
        this.mTooltipText = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        int i3 = ViewConfigurationCompat.$r8$clinit;
        this.mHoverSlop = Build.VERSION.SDK_INT >= 28 ? ViewConfigurationCompat.Api28Impl.getScaledHoverSlop(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
        this.mForceNextChangeSignificant = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void setPendingHandler(TooltipCompatHandler tooltipCompatHandler) {
        TooltipCompatHandler tooltipCompatHandler2 = sPendingHandler;
        if (tooltipCompatHandler2 != null) {
            tooltipCompatHandler2.mAnchor.removeCallbacks(tooltipCompatHandler2.mShowRunnable);
        }
        sPendingHandler = tooltipCompatHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.mAnchor.postDelayed(tooltipCompatHandler.mShowRunnable, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void hide() {
        TooltipCompatHandler tooltipCompatHandler = sActiveHandler;
        View view = this.mAnchor;
        if (tooltipCompatHandler == this) {
            sActiveHandler = null;
            TooltipPopup tooltipPopup = this.mPopup;
            if (tooltipPopup != null) {
                View view2 = (View) tooltipPopup.mContentView;
                if (view2.getParent() != null) {
                    ((WindowManager) ((Context) tooltipPopup.mContext).getSystemService("window")).removeView(view2);
                }
                this.mPopup = null;
                this.mForceNextChangeSignificant = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (sPendingHandler == this) {
            setPendingHandler(null);
        }
        view.removeCallbacks(this.mHideRunnable);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0066  */
    @Override // android.view.View.OnHoverListener
    public final boolean onHover(View view, MotionEvent motionEvent) {
        if (this.mPopup != null && this.mFromTouch) {
            return false;
        }
        View view2 = this.mAnchor;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view2.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                this.mForceNextChangeSignificant = true;
                hide();
            }
        } else if (view2.isEnabled() && this.mPopup == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (this.mForceNextChangeSignificant) {
                this.mAnchorX = x;
                this.mAnchorY = y;
                this.mForceNextChangeSignificant = false;
                setPendingHandler(this);
            } else {
                int iAbs = Math.abs(x - this.mAnchorX);
                int i = this.mHoverSlop;
                if (iAbs > i || Math.abs(y - this.mAnchorY) > i) {
                    this.mAnchorX = x;
                    this.mAnchorY = y;
                    this.mForceNextChangeSignificant = false;
                    setPendingHandler(this);
                }
            }
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.mAnchorX = view.getWidth() / 2;
        this.mAnchorY = view.getHeight() / 2;
        show(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        hide();
    }

    public final void show(boolean z) {
        int height;
        int i;
        int i2;
        long longPressTimeout;
        long j;
        long j2;
        View view = this.mAnchor;
        if (view.isAttachedToWindow()) {
            setPendingHandler(null);
            TooltipCompatHandler tooltipCompatHandler = sActiveHandler;
            if (tooltipCompatHandler != null) {
                tooltipCompatHandler.hide();
            }
            sActiveHandler = this;
            this.mFromTouch = z;
            Context context = view.getContext();
            TooltipPopup tooltipPopup = new TooltipPopup();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            tooltipPopup.mLayoutParams = layoutParams;
            tooltipPopup.mTmpDisplayFrame = new Rect();
            tooltipPopup.mTmpAnchorPos = new int[2];
            tooltipPopup.mTmpAppPos = new int[2];
            tooltipPopup.mContext = context;
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
            tooltipPopup.mContentView = viewInflate;
            tooltipPopup.mMessageView = (TextView) viewInflate.findViewById(R.id.message);
            layoutParams.setTitle("TooltipPopup");
            layoutParams.packageName = context.getPackageName();
            layoutParams.type = 1002;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
            layoutParams.flags = 24;
            this.mPopup = tooltipPopup;
            int width = this.mAnchorX;
            int i3 = this.mAnchorY;
            boolean z2 = this.mFromTouch;
            View view2 = (View) tooltipPopup.mContentView;
            ViewParent parent = view2.getParent();
            Context context2 = (Context) tooltipPopup.mContext;
            if (parent != null && view2.getParent() != null) {
                ((WindowManager) context2.getSystemService("window")).removeView(view2);
            }
            ((TextView) tooltipPopup.mMessageView).setText(this.mTooltipText);
            WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) tooltipPopup.mLayoutParams;
            layoutParams2.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = context2.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                width = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context2.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
                height = i3 + dimensionPixelOffset2;
                i = i3 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i = 0;
            }
            layoutParams2.gravity = 49;
            int dimensionPixelOffset3 = context2.getResources().getDimensionPixelOffset(z2 ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams3 = rootView.getLayoutParams();
            if (!(layoutParams3 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams3).type != 2) {
                for (Context context3 = view.getContext(); context3 instanceof ContextWrapper; context3 = ((ContextWrapper) context3).getBaseContext()) {
                    if (context3 instanceof Activity) {
                        rootView = ((Activity) context3).getWindow().getDecorView();
                        break;
                    }
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
            } else {
                Rect rect = (Rect) tooltipPopup.mTmpDisplayFrame;
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rect.left >= 0 || rect.top >= 0) {
                    i2 = 0;
                } else {
                    Resources resources = context2.getResources();
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i2 = 0;
                    rect.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                int[] iArr = (int[]) tooltipPopup.mTmpAppPos;
                rootView.getLocationOnScreen(iArr);
                int[] iArr2 = (int[]) tooltipPopup.mTmpAnchorPos;
                view.getLocationOnScreen(iArr2);
                int i4 = iArr2[i2] - iArr[i2];
                iArr2[i2] = i4;
                iArr2[1] = iArr2[1] - iArr[1];
                layoutParams2.x = (i4 + width) - (rootView.getWidth() / 2);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, i2);
                view2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredHeight = view2.getMeasuredHeight();
                int i5 = iArr2[1];
                int i6 = ((i + i5) - dimensionPixelOffset3) - measuredHeight;
                int i7 = i5 + height + dimensionPixelOffset3;
                if (z2) {
                    if (i6 >= 0) {
                        layoutParams2.y = i6;
                    } else {
                        layoutParams2.y = i7;
                    }
                } else if (measuredHeight + i7 <= rect.height()) {
                    layoutParams2.y = i7;
                } else {
                    layoutParams2.y = i6;
                }
            }
            ((WindowManager) context2.getSystemService("window")).addView(view2, layoutParams2);
            view.addOnAttachStateChangeListener(this);
            if (this.mFromTouch) {
                j2 = 2500;
            } else {
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                if ((view.getWindowSystemUiVisibility() & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 15000;
                }
                j2 = j - longPressTimeout;
            }
            TooltipCompatHandler$$ExternalSyntheticLambda0 tooltipCompatHandler$$ExternalSyntheticLambda0 = this.mHideRunnable;
            view.removeCallbacks(tooltipCompatHandler$$ExternalSyntheticLambda0);
            view.postDelayed(tooltipCompatHandler$$ExternalSyntheticLambda0, j2);
        }
    }
}
