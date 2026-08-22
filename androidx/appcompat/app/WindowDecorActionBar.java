package androidx.appcompat.app;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.fragment.app.Fragment;
import androidx.room.RoomOpenHelper;
import com.daerisoft.thespikerm.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes.dex */
public final class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    public static final AccelerateInterpolator sHideInterpolator = new AccelerateInterpolator();
    public static final DecelerateInterpolator sShowInterpolator = new DecelerateInterpolator();
    public ActionModeImpl mActionMode;
    public ActionBarContainer mContainerView;
    public boolean mContentAnimations;
    public final View mContentView;
    public Context mContext;
    public ActionBarContextView mContextView;
    public int mCurWindowVisibility;
    public ViewPropertyAnimatorCompatSet mCurrentShowAnim;
    public DecorToolbar mDecorToolbar;
    public ActionModeImpl mDeferredDestroyActionMode;
    public RoomOpenHelper mDeferredModeDestroyCallback;
    public boolean mDisplayHomeAsUpSet;
    public boolean mHiddenBySystem;
    public final AnonymousClass1 mHideListener;
    public boolean mHideOnContentScroll;
    public boolean mLastMenuVisibility;
    public final ArrayList mMenuVisibilityListeners;
    public boolean mNowShowing;
    public ActionBarOverlayLayout mOverlayLayout;
    public boolean mShowHideAnimationEnabled;
    public final AnonymousClass1 mShowListener;
    public boolean mShowingForMode;
    public Context mThemedContext;
    public final Fragment.AnonymousClass7 mUpdateListener;

    /* JADX INFO: renamed from: androidx.appcompat.app.WindowDecorActionBar$1, reason: invalid class name */
    public final class AnonymousClass1 extends MediaType.Companion {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ WindowDecorActionBar this$0;

        public /* synthetic */ AnonymousClass1(WindowDecorActionBar windowDecorActionBar, int i) {
            this.$r8$classId = i;
            this.this$0 = windowDecorActionBar;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationEnd() {
            View view;
            WindowDecorActionBar windowDecorActionBar = this.this$0;
            switch (this.$r8$classId) {
                case 0:
                    if (windowDecorActionBar.mContentAnimations && (view = windowDecorActionBar.mContentView) != null) {
                        view.setTranslationY(0.0f);
                        windowDecorActionBar.mContainerView.setTranslationY(0.0f);
                    }
                    windowDecorActionBar.mContainerView.setVisibility(8);
                    windowDecorActionBar.mContainerView.setTransitioning(false);
                    windowDecorActionBar.mCurrentShowAnim = null;
                    RoomOpenHelper roomOpenHelper = windowDecorActionBar.mDeferredModeDestroyCallback;
                    if (roomOpenHelper != null) {
                        roomOpenHelper.onDestroyActionMode(windowDecorActionBar.mDeferredDestroyActionMode);
                        windowDecorActionBar.mDeferredDestroyActionMode = null;
                        windowDecorActionBar.mDeferredModeDestroyCallback = null;
                    }
                    ActionBarOverlayLayout actionBarOverlayLayout = windowDecorActionBar.mOverlayLayout;
                    if (actionBarOverlayLayout != null) {
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        ViewCompat.Api20Impl.requestApplyInsets(actionBarOverlayLayout);
                    }
                    break;
                default:
                    windowDecorActionBar.mCurrentShowAnim = null;
                    windowDecorActionBar.mContainerView.requestLayout();
                    break;
            }
        }
    }

    public final class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        public final Context mActionModeContext;
        public RoomOpenHelper mCallback;
        public WeakReference mCustomView;
        public final MenuBuilder mMenu;

        public ActionModeImpl(Context context, RoomOpenHelper roomOpenHelper) {
            this.mActionModeContext = context;
            this.mCallback = roomOpenHelper;
            MenuBuilder menuBuilder = new MenuBuilder(context);
            menuBuilder.mDefaultShowAsAction = 1;
            this.mMenu = menuBuilder;
            menuBuilder.mCallback = this;
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void finish() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.mActionMode != this) {
                return;
            }
            if (windowDecorActionBar.mHiddenBySystem) {
                windowDecorActionBar.mDeferredDestroyActionMode = this;
                windowDecorActionBar.mDeferredModeDestroyCallback = this.mCallback;
            } else {
                this.mCallback.onDestroyActionMode(this);
            }
            this.mCallback = null;
            windowDecorActionBar.animateToMode(false);
            ActionBarContextView actionBarContextView = windowDecorActionBar.mContextView;
            if (actionBarContextView.mClose == null) {
                actionBarContextView.killMode();
            }
            windowDecorActionBar.mOverlayLayout.setHideOnContentScrollEnabled(windowDecorActionBar.mHideOnContentScroll);
            windowDecorActionBar.mActionMode = null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public final View getCustomView() {
            WeakReference weakReference = this.mCustomView;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public final MenuBuilder getMenu() {
            return this.mMenu;
        }

        @Override // androidx.appcompat.view.ActionMode
        public final MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.mActionModeContext);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final CharSequence getSubtitle() {
            return WindowDecorActionBar.this.mContextView.getSubtitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public final CharSequence getTitle() {
            return WindowDecorActionBar.this.mContextView.getTitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void invalidate() {
            if (WindowDecorActionBar.this.mActionMode != this) {
                return;
            }
            MenuBuilder menuBuilder = this.mMenu;
            menuBuilder.stopDispatchingItemsChanged();
            try {
                this.mCallback.onPrepareActionMode(this, menuBuilder);
            } finally {
                menuBuilder.startDispatchingItemsChanged();
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public final boolean isTitleOptional() {
            return WindowDecorActionBar.this.mContextView.mTitleOptional;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            RoomOpenHelper roomOpenHelper = this.mCallback;
            if (roomOpenHelper != null) {
                return ((ActionMode.Callback) roomOpenHelper.mConfiguration).onActionItemClicked(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public final void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.mCallback == null) {
                return;
            }
            invalidate();
            ActionMenuPresenter actionMenuPresenter = WindowDecorActionBar.this.mContextView.mActionMenuPresenter;
            if (actionMenuPresenter != null) {
                actionMenuPresenter.showOverflowMenu();
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setCustomView(View view) {
            WindowDecorActionBar.this.mContextView.setCustomView(view);
            this.mCustomView = new WeakReference(view);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.mContextView.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.mContextView.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setTitleOptionalHint(boolean z) {
            this.mTitleOptionalHint = z;
            WindowDecorActionBar.this.mContextView.setTitleOptional(z);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setSubtitle(int i) {
            setSubtitle(WindowDecorActionBar.this.mContext.getResources().getString(i));
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setTitle(int i) {
            setTitle(WindowDecorActionBar.this.mContext.getResources().getString(i));
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        new ArrayList();
        this.mMenuVisibilityListeners = new ArrayList();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new AnonymousClass1(this, 0);
        this.mShowListener = new AnonymousClass1(this, 1);
        this.mUpdateListener = new Fragment.AnonymousClass7(this, 4);
        init(dialog.getWindow().getDecorView());
    }

    public final void animateToMode(boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        if (z) {
            if (!this.mShowingForMode) {
                this.mShowingForMode = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                updateVisibility(false);
            }
        } else if (this.mShowingForMode) {
            this.mShowingForMode = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.mOverlayLayout;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            updateVisibility(false);
        }
        if (!this.mContainerView.isLaidOut()) {
            if (z) {
                ((ToolbarWidgetWrapper) this.mDecorToolbar).mToolbar.setVisibility(4);
                this.mContextView.setVisibility(0);
                return;
            } else {
                ((ToolbarWidgetWrapper) this.mDecorToolbar).mToolbar.setVisibility(0);
                this.mContextView.setVisibility(8);
                return;
            }
        }
        if (z) {
            ToolbarWidgetWrapper toolbarWidgetWrapper = (ToolbarWidgetWrapper) this.mDecorToolbar;
            viewPropertyAnimatorCompatAnimate = ViewCompat.animate(toolbarWidgetWrapper.mToolbar);
            viewPropertyAnimatorCompatAnimate.alpha(0.0f);
            viewPropertyAnimatorCompatAnimate.setDuration(100L);
            viewPropertyAnimatorCompatAnimate.setListener(new ToolbarWidgetWrapper.AnonymousClass2(toolbarWidgetWrapper, 4));
            viewPropertyAnimatorCompat = this.mContextView.setupAnimatorToVisibility(0, 200L);
        } else {
            ToolbarWidgetWrapper toolbarWidgetWrapper2 = (ToolbarWidgetWrapper) this.mDecorToolbar;
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate2 = ViewCompat.animate(toolbarWidgetWrapper2.mToolbar);
            viewPropertyAnimatorCompatAnimate2.alpha(1.0f);
            viewPropertyAnimatorCompatAnimate2.setDuration(200L);
            viewPropertyAnimatorCompatAnimate2.setListener(new ToolbarWidgetWrapper.AnonymousClass2(toolbarWidgetWrapper2, 0));
            viewPropertyAnimatorCompatAnimate = this.mContextView.setupAnimatorToVisibility(8, 100L);
            viewPropertyAnimatorCompat = viewPropertyAnimatorCompatAnimate2;
        }
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        ArrayList arrayList = viewPropertyAnimatorCompatSet.mAnimators;
        arrayList.add(viewPropertyAnimatorCompatAnimate);
        View view = (View) viewPropertyAnimatorCompatAnimate.mView.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) viewPropertyAnimatorCompat.mView.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompatSet.start();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean collapseActionView() {
        Toolbar.ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter;
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar == null || (expandedActionViewMenuPresenter = ((ToolbarWidgetWrapper) decorToolbar).mToolbar.mExpandedMenuPresenter) == null || expandedActionViewMenuPresenter.mCurrentExpandedItem == null) {
            return false;
        }
        Toolbar.ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter2 = ((ToolbarWidgetWrapper) decorToolbar).mToolbar.mExpandedMenuPresenter;
        MenuItemImpl menuItemImpl = expandedActionViewMenuPresenter2 == null ? null : expandedActionViewMenuPresenter2.mCurrentExpandedItem;
        if (menuItemImpl == null) {
            return true;
        }
        menuItemImpl.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void dispatchMenuVisibilityChanged(boolean z) {
        if (z == this.mLastMenuVisibility) {
            return;
        }
        this.mLastMenuVisibility = z;
        ArrayList arrayList = this.mMenuVisibilityListeners;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final int getDisplayOptions() {
        return ((ToolbarWidgetWrapper) this.mDecorToolbar).mDisplayOpts;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final Context getThemedContext() {
        if (this.mThemedContext == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.mThemedContext = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.mThemedContext = this.mContext;
            }
        }
        return this.mThemedContext;
    }

    public final void init(View view) {
        DecorToolbar wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        this.mOverlayLayout = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(R.id.action_bar);
        if (callbackFindViewById instanceof DecorToolbar) {
            wrapper = (DecorToolbar) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) callbackFindViewById).getWrapper();
        }
        this.mDecorToolbar = wrapper;
        this.mContextView = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        this.mContainerView = actionBarContainer;
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar == null || this.mContextView == null || actionBarContainer == null) {
            throw new IllegalStateException("WindowDecorActionBar can only be used with a compatible window decor layout");
        }
        Context context = ((ToolbarWidgetWrapper) decorToolbar).mToolbar.getContext();
        this.mContext = context;
        if ((((ToolbarWidgetWrapper) this.mDecorToolbar).mDisplayOpts & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        this.mDecorToolbar.getClass();
        setHasEmbeddedTabs(context.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs));
        TypedArray typedArrayObtainStyledAttributes = this.mContext.obtainStyledAttributes(null, R$styleable.ActionBar, R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.mOverlayLayout;
            if (!actionBarOverlayLayout2.mOverlayMode) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.mHideOnContentScroll = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.mContainerView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api21Impl.setElevation(actionBarContainer2, dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void onConfigurationChanged() {
        setHasEmbeddedTabs(this.mContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs));
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        MenuBuilder menuBuilder;
        ActionModeImpl actionModeImpl = this.mActionMode;
        if (actionModeImpl == null || (menuBuilder = actionModeImpl.mMenu) == null) {
            return false;
        }
        menuBuilder.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuBuilder.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        if (this.mDisplayHomeAsUpSet) {
            return;
        }
        int i = z ? 4 : 0;
        ToolbarWidgetWrapper toolbarWidgetWrapper = (ToolbarWidgetWrapper) this.mDecorToolbar;
        int i2 = toolbarWidgetWrapper.mDisplayOpts;
        this.mDisplayHomeAsUpSet = true;
        toolbarWidgetWrapper.setDisplayOptions((i & 4) | (i2 & (-5)));
    }

    public final void setHasEmbeddedTabs(boolean z) {
        if (z) {
            this.mContainerView.setTabContainer(null);
            ((ToolbarWidgetWrapper) this.mDecorToolbar).getClass();
        } else {
            ((ToolbarWidgetWrapper) this.mDecorToolbar).getClass();
            this.mContainerView.setTabContainer(null);
        }
        this.mDecorToolbar.getClass();
        ((ToolbarWidgetWrapper) this.mDecorToolbar).mToolbar.setCollapsible(false);
        this.mOverlayLayout.setHasNonEmbeddedTabs(false);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setShowHideAnimationEnabled(boolean z) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.mShowHideAnimationEnabled = z;
        if (z || (viewPropertyAnimatorCompatSet = this.mCurrentShowAnim) == null) {
            return;
        }
        viewPropertyAnimatorCompatSet.cancel();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setWindowTitle(CharSequence charSequence) {
        ToolbarWidgetWrapper toolbarWidgetWrapper = (ToolbarWidgetWrapper) this.mDecorToolbar;
        if (toolbarWidgetWrapper.mTitleSet) {
            return;
        }
        toolbarWidgetWrapper.mTitle = charSequence;
        if ((toolbarWidgetWrapper.mDisplayOpts & 8) != 0) {
            Toolbar toolbar = toolbarWidgetWrapper.mToolbar;
            toolbar.setTitle(charSequence);
            if (toolbarWidgetWrapper.mTitleSet) {
                ViewCompat.setAccessibilityPaneTitle(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final ActionMode startActionMode(RoomOpenHelper roomOpenHelper) {
        ActionModeImpl actionModeImpl = this.mActionMode;
        if (actionModeImpl != null) {
            actionModeImpl.finish();
        }
        this.mOverlayLayout.setHideOnContentScrollEnabled(false);
        this.mContextView.killMode();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.mContextView.getContext(), roomOpenHelper);
        MenuBuilder menuBuilder = actionModeImpl2.mMenu;
        menuBuilder.stopDispatchingItemsChanged();
        try {
            boolean zOnCreateActionMode = ((ActionMode.Callback) actionModeImpl2.mCallback.mConfiguration).onCreateActionMode(actionModeImpl2, menuBuilder);
            menuBuilder.startDispatchingItemsChanged();
            if (!zOnCreateActionMode) {
                return null;
            }
            this.mActionMode = actionModeImpl2;
            actionModeImpl2.invalidate();
            this.mContextView.initForMode(actionModeImpl2);
            animateToMode(true);
            return actionModeImpl2;
        } catch (Throwable th) {
            menuBuilder.startDispatchingItemsChanged();
            throw th;
        }
    }

    public final void updateVisibility(boolean z) {
        boolean z2 = this.mShowingForMode || !this.mHiddenBySystem;
        View view = this.mContentView;
        final Fragment.AnonymousClass7 anonymousClass7 = this.mUpdateListener;
        if (!z2) {
            if (this.mNowShowing) {
                this.mNowShowing = false;
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
                if (viewPropertyAnimatorCompatSet != null) {
                    viewPropertyAnimatorCompatSet.cancel();
                }
                int i = this.mCurWindowVisibility;
                AnonymousClass1 anonymousClass1 = this.mHideListener;
                if (i != 0 || (!this.mShowHideAnimationEnabled && !z)) {
                    anonymousClass1.onAnimationEnd();
                    return;
                }
                this.mContainerView.setAlpha(1.0f);
                this.mContainerView.setTransitioning(true);
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
                float f = -this.mContainerView.getHeight();
                if (z) {
                    int[] iArr = {0, 0};
                    this.mContainerView.getLocationInWindow(iArr);
                    f -= iArr[1];
                }
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate = ViewCompat.animate(this.mContainerView);
                viewPropertyAnimatorCompatAnimate.translationY(f);
                final View view2 = (View) viewPropertyAnimatorCompatAnimate.mView.get();
                if (view2 != null) {
                    view2.animate().setUpdateListener(anonymousClass7 != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ((View) ((WindowDecorActionBar) anonymousClass7.this$0).mContainerView.getParent()).invalidate();
                        }
                    } : null);
                }
                boolean z3 = viewPropertyAnimatorCompatSet2.mIsStarted;
                ArrayList arrayList = viewPropertyAnimatorCompatSet2.mAnimators;
                if (!z3) {
                    arrayList.add(viewPropertyAnimatorCompatAnimate);
                }
                if (this.mContentAnimations && view != null) {
                    ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate2 = ViewCompat.animate(view);
                    viewPropertyAnimatorCompatAnimate2.translationY(f);
                    if (!viewPropertyAnimatorCompatSet2.mIsStarted) {
                        arrayList.add(viewPropertyAnimatorCompatAnimate2);
                    }
                }
                AccelerateInterpolator accelerateInterpolator = sHideInterpolator;
                boolean z4 = viewPropertyAnimatorCompatSet2.mIsStarted;
                if (!z4) {
                    viewPropertyAnimatorCompatSet2.mInterpolator = accelerateInterpolator;
                }
                if (!z4) {
                    viewPropertyAnimatorCompatSet2.mDuration = 250L;
                }
                if (!z4) {
                    viewPropertyAnimatorCompatSet2.mListener = anonymousClass1;
                }
                this.mCurrentShowAnim = viewPropertyAnimatorCompatSet2;
                viewPropertyAnimatorCompatSet2.start();
                return;
            }
            return;
        }
        if (this.mNowShowing) {
            return;
        }
        this.mNowShowing = true;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet3 = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet3 != null) {
            viewPropertyAnimatorCompatSet3.cancel();
        }
        this.mContainerView.setVisibility(0);
        int i2 = this.mCurWindowVisibility;
        AnonymousClass1 anonymousClass2 = this.mShowListener;
        if (i2 == 0 && (this.mShowHideAnimationEnabled || z)) {
            this.mContainerView.setTranslationY(0.0f);
            float f2 = -this.mContainerView.getHeight();
            if (z) {
                int[] iArr2 = {0, 0};
                this.mContainerView.getLocationInWindow(iArr2);
                f2 -= iArr2[1];
            }
            this.mContainerView.setTranslationY(f2);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet4 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate3 = ViewCompat.animate(this.mContainerView);
            viewPropertyAnimatorCompatAnimate3.translationY(0.0f);
            final View view3 = (View) viewPropertyAnimatorCompatAnimate3.mView.get();
            if (view3 != null) {
                view3.animate().setUpdateListener(anonymousClass7 != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ((View) ((WindowDecorActionBar) anonymousClass7.this$0).mContainerView.getParent()).invalidate();
                    }
                } : null);
            }
            boolean z5 = viewPropertyAnimatorCompatSet4.mIsStarted;
            ArrayList arrayList2 = viewPropertyAnimatorCompatSet4.mAnimators;
            if (!z5) {
                arrayList2.add(viewPropertyAnimatorCompatAnimate3);
            }
            if (this.mContentAnimations && view != null) {
                view.setTranslationY(f2);
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate4 = ViewCompat.animate(view);
                viewPropertyAnimatorCompatAnimate4.translationY(0.0f);
                if (!viewPropertyAnimatorCompatSet4.mIsStarted) {
                    arrayList2.add(viewPropertyAnimatorCompatAnimate4);
                }
            }
            DecelerateInterpolator decelerateInterpolator = sShowInterpolator;
            boolean z6 = viewPropertyAnimatorCompatSet4.mIsStarted;
            if (!z6) {
                viewPropertyAnimatorCompatSet4.mInterpolator = decelerateInterpolator;
            }
            if (!z6) {
                viewPropertyAnimatorCompatSet4.mDuration = 250L;
            }
            if (!z6) {
                viewPropertyAnimatorCompatSet4.mListener = anonymousClass2;
            }
            this.mCurrentShowAnim = viewPropertyAnimatorCompatSet4;
            viewPropertyAnimatorCompatSet4.start();
        } else {
            this.mContainerView.setAlpha(1.0f);
            this.mContainerView.setTranslationY(0.0f);
            if (this.mContentAnimations && view != null) {
                view.setTranslationY(0.0f);
            }
            anonymousClass2.onAnimationEnd();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api20Impl.requestApplyInsets(actionBarOverlayLayout);
        }
    }

    public WindowDecorActionBar(boolean z, Activity activity) {
        new ArrayList();
        this.mMenuVisibilityListeners = new ArrayList();
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = true;
        this.mNowShowing = true;
        this.mHideListener = new AnonymousClass1(this, 0);
        this.mShowListener = new AnonymousClass1(this, 1);
        this.mUpdateListener = new Fragment.AnonymousClass7(this, 4);
        View decorView = activity.getWindow().getDecorView();
        init(decorView);
        if (z) {
            return;
        }
        this.mContentView = decorView.findViewById(android.R.id.content);
    }
}
