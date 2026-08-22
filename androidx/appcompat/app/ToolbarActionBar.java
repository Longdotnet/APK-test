package androidx.appcompat.app;

import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.work.Worker;
import com.android.billingclient.api.zzcj;
import com.facebook.AccessTokenCache;
import com.facebook.ProfileCache;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ToolbarActionBar extends ActionBar {
    public final ToolbarWidgetWrapper mDecorToolbar;
    public boolean mLastMenuVisibility;
    public final AccessTokenCache mMenuCallback;
    public boolean mMenuCallbackSet;
    public boolean mToolbarMenuPrepared;
    public final AppCompatDelegateImpl.AppCompatWindowCallback mWindowCallback;
    public final ArrayList mMenuVisibilityListeners = new ArrayList();
    public final Worker.AnonymousClass1 mMenuInvalidator = new Worker.AnonymousClass1(this, 1);

    public ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, AppCompatDelegateImpl.AppCompatWindowCallback appCompatWindowCallback) {
        Fragment.AnonymousClass7 anonymousClass7 = new Fragment.AnonymousClass7(this, 3);
        toolbar.getClass();
        ToolbarWidgetWrapper toolbarWidgetWrapper = new ToolbarWidgetWrapper(toolbar, false);
        this.mDecorToolbar = toolbarWidgetWrapper;
        appCompatWindowCallback.getClass();
        this.mWindowCallback = appCompatWindowCallback;
        toolbarWidgetWrapper.mWindowCallback = appCompatWindowCallback;
        toolbar.setOnMenuItemClickListener(anonymousClass7);
        if (!toolbarWidgetWrapper.mTitleSet) {
            toolbarWidgetWrapper.mTitle = charSequence;
            if ((toolbarWidgetWrapper.mDisplayOpts & 8) != 0) {
                Toolbar toolbar2 = toolbarWidgetWrapper.mToolbar;
                toolbar2.setTitle(charSequence);
                if (toolbarWidgetWrapper.mTitleSet) {
                    ViewCompat.setAccessibilityPaneTitle(toolbar2.getRootView(), charSequence);
                }
            }
        }
        this.mMenuCallback = new AccessTokenCache(this, 1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean closeOptionsMenu() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.mDecorToolbar.mToolbar.mMenuView;
        return (actionMenuView == null || (actionMenuPresenter = actionMenuView.mPresenter) == null || !actionMenuPresenter.hideOverflowMenu()) ? false : true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean collapseActionView() {
        MenuItemImpl menuItemImpl;
        Toolbar.ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mDecorToolbar.mToolbar.mExpandedMenuPresenter;
        if (expandedActionViewMenuPresenter == null || (menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem) == null) {
            return false;
        }
        if (expandedActionViewMenuPresenter == null) {
            menuItemImpl = null;
        }
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
        return this.mDecorToolbar.mDisplayOpts;
    }

    public final Menu getMenu() {
        boolean z = this.mMenuCallbackSet;
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.mDecorToolbar;
        if (!z) {
            zzcj zzcjVar = new zzcj(this);
            ProfileCache profileCache = new ProfileCache(this, 3);
            Toolbar toolbar = toolbarWidgetWrapper.mToolbar;
            toolbar.mActionMenuPresenterCallback = zzcjVar;
            toolbar.mMenuBuilderCallback = profileCache;
            ActionMenuView actionMenuView = toolbar.mMenuView;
            if (actionMenuView != null) {
                actionMenuView.mActionMenuPresenterCallback = zzcjVar;
                actionMenuView.mMenuBuilderCallback = profileCache;
            }
            this.mMenuCallbackSet = true;
        }
        return toolbarWidgetWrapper.mToolbar.getMenu();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final Context getThemedContext() {
        return this.mDecorToolbar.mToolbar.getContext();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean invalidateOptionsMenu() {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.mDecorToolbar;
        Toolbar toolbar = toolbarWidgetWrapper.mToolbar;
        Worker.AnonymousClass1 anonymousClass1 = this.mMenuInvalidator;
        toolbar.removeCallbacks(anonymousClass1);
        Toolbar toolbar2 = toolbarWidgetWrapper.mToolbar;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        toolbar2.postOnAnimation(anonymousClass1);
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void onDestroy() {
        this.mDecorToolbar.mToolbar.removeCallbacks(this.mMenuInvalidator);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Menu menu = getMenu();
        if (menu == null) {
            return false;
        }
        menu.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menu.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean onMenuKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            openOptionsMenu();
        }
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean openOptionsMenu() {
        return this.mDecorToolbar.mToolbar.showOverflowMenu();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setDefaultDisplayHomeAsUpEnabled(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setShowHideAnimationEnabled(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setWindowTitle(CharSequence charSequence) {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.mDecorToolbar;
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
    public final void onConfigurationChanged() {
    }
}
