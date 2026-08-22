package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatPopupWindow;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.fragment.app.FragmentStateManager;
import com.daerisoft.thespikerm.R;
import com.facebook.ProfileCache;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class CascadingMenuPopup extends MenuPopup implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public View mAnchorView;
    public final FragmentStateManager.AnonymousClass1 mAttachStateChangeListener;
    public final Context mContext;
    public final AppCompatSpinner.AnonymousClass2 mGlobalLayoutListener;
    public boolean mHasXOffset;
    public boolean mHasYOffset;
    public int mLastPosition;
    public final int mMenuMaxWidth;
    public MenuPopupHelper.AnonymousClass1 mOnDismissListener;
    public final boolean mOverflowOnly;
    public final int mPopupStyleAttr;
    public MenuPresenter.Callback mPresenterCallback;
    public boolean mShouldCloseImmediately;
    public boolean mShowTitle;
    public View mShownAnchorView;
    public final Handler mSubMenuHoverHandler;
    public ViewTreeObserver mTreeObserver;
    public int mXOffset;
    public int mYOffset;
    public final ArrayList mPendingMenus = new ArrayList();
    public final ArrayList mShowingMenus = new ArrayList();
    public final ProfileCache mMenuItemHoverListener = new ProfileCache(this, 4);
    public int mRawDropDownGravity = 0;
    public int mDropDownGravity = 0;
    public boolean mForceShowIcon = false;

    public final class CascadingMenuInfo {
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i) {
            this.window = menuPopupWindow;
            this.menu = menuBuilder;
            this.position = i;
        }
    }

    public CascadingMenuPopup(Context context, View view, int i, boolean z) {
        int i2 = 1;
        this.mGlobalLayoutListener = new AppCompatSpinner.AnonymousClass2(this, i2);
        this.mAttachStateChangeListener = new FragmentStateManager.AnonymousClass1(this, i2);
        this.mContext = context;
        this.mAnchorView = view;
        this.mPopupStyleAttr = i;
        this.mOverflowOnly = z;
        this.mLastPosition = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.mMenuMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.mSubMenuHoverHandler = new Handler();
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void addMenu(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.mContext);
        if (isShowing()) {
            showMenu(menuBuilder);
        } else {
            this.mPendingMenus.add(menuBuilder);
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void dismiss() {
        ArrayList arrayList = this.mShowingMenus;
        int size = arrayList.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) arrayList.toArray(new CascadingMenuInfo[size]);
            for (int i = size - 1; i >= 0; i--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i];
                if (cascadingMenuInfo.window.mPopup.isShowing()) {
                    cascadingMenuInfo.window.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final DropDownListView getListView() {
        ArrayList arrayList = this.mShowingMenus;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((CascadingMenuInfo) arrayList.get(arrayList.size() - 1)).window.mDropDownList;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final boolean isShowing() {
        ArrayList arrayList = this.mShowingMenus;
        return arrayList.size() > 0 && ((CascadingMenuInfo) arrayList.get(0)).window.mPopup.isShowing();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        ArrayList arrayList = this.mShowingMenus;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (menuBuilder == ((CascadingMenuInfo) arrayList.get(i)).menu) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        int i2 = i + 1;
        if (i2 < arrayList.size()) {
            ((CascadingMenuInfo) arrayList.get(i2)).menu.close(false);
        }
        CascadingMenuInfo cascadingMenuInfo = (CascadingMenuInfo) arrayList.remove(i);
        cascadingMenuInfo.menu.removeMenuPresenter(this);
        boolean z2 = this.mShouldCloseImmediately;
        MenuPopupWindow menuPopupWindow = cascadingMenuInfo.window;
        if (z2) {
            MenuPopupWindow.Api23Impl.setExitTransition(menuPopupWindow.mPopup, null);
            menuPopupWindow.mPopup.setAnimationStyle(0);
        }
        menuPopupWindow.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.mLastPosition = ((CascadingMenuInfo) arrayList.get(size2 - 1)).position;
        } else {
            this.mLastPosition = this.mAnchorView.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z) {
                ((CascadingMenuInfo) arrayList.get(0)).menu.close(false);
                return;
            }
            return;
        }
        dismiss();
        MenuPresenter.Callback callback = this.mPresenterCallback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, true);
        }
        ViewTreeObserver viewTreeObserver = this.mTreeObserver;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            }
            this.mTreeObserver = null;
        }
        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        this.mOnDismissListener.onDismiss();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        ArrayList arrayList = this.mShowingMenus;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                cascadingMenuInfo = null;
                break;
            }
            cascadingMenuInfo = (CascadingMenuInfo) arrayList.get(i);
            if (!cascadingMenuInfo.window.mPopup.isShowing()) {
                break;
            } else {
                i++;
            }
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.menu.close(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        for (CascadingMenuInfo cascadingMenuInfo : this.mShowingMenus) {
            if (subMenuBuilder == cascadingMenuInfo.menu) {
                cascadingMenuInfo.window.mDropDownList.requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        addMenu(subMenuBuilder);
        MenuPresenter.Callback callback = this.mPresenterCallback;
        if (callback != null) {
            callback.onOpenSubMenu(subMenuBuilder);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setAnchorView(View view) {
        if (this.mAnchorView != view) {
            this.mAnchorView = view;
            this.mDropDownGravity = Gravity.getAbsoluteGravity(this.mRawDropDownGravity, view.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void setCallback(MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setGravity(int i) {
        if (this.mRawDropDownGravity != i) {
            this.mRawDropDownGravity = i;
            this.mDropDownGravity = Gravity.getAbsoluteGravity(i, this.mAnchorView.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setHorizontalOffset(int i) {
        this.mHasXOffset = true;
        this.mXOffset = i;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = (MenuPopupHelper.AnonymousClass1) onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setShowTitle(boolean z) {
        this.mShowTitle = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setVerticalOffset(int i) {
        this.mHasYOffset = true;
        this.mYOffset = i;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void show() {
        if (isShowing()) {
            return;
        }
        ArrayList arrayList = this.mPendingMenus;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            showMenu((MenuBuilder) it.next());
        }
        arrayList.clear();
        View view = this.mAnchorView;
        this.mShownAnchorView = view;
        if (view != null) {
            boolean z = this.mTreeObserver == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.mTreeObserver = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            }
            this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x013e  */
    public final void showMenu(MenuBuilder menuBuilder) {
        View childAt;
        CascadingMenuInfo cascadingMenuInfo;
        int i;
        char c;
        int i2;
        int i3;
        int width;
        MenuItem item;
        MenuAdapter menuAdapter;
        int headersCount;
        int i4;
        int firstVisiblePosition;
        Context context = this.mContext;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        MenuAdapter menuAdapter2 = new MenuAdapter(menuBuilder, layoutInflaterFrom, this.mOverflowOnly, R.layout.abc_cascading_menu_item_layout);
        if (!isShowing() && this.mForceShowIcon) {
            menuAdapter2.mForceShowIcon = true;
        } else if (isShowing()) {
            menuAdapter2.mForceShowIcon = MenuPopup.shouldPreserveIconSpacing(menuBuilder);
        }
        int iMeasureIndividualMenuWidth = MenuPopup.measureIndividualMenuWidth(menuAdapter2, context, this.mMenuMaxWidth);
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(context, null, this.mPopupStyleAttr);
        AppCompatPopupWindow appCompatPopupWindow = menuPopupWindow.mPopup;
        menuPopupWindow.mHoverListener = this.mMenuItemHoverListener;
        menuPopupWindow.mItemClickListener = this;
        appCompatPopupWindow.setOnDismissListener(this);
        menuPopupWindow.mDropDownAnchorView = this.mAnchorView;
        menuPopupWindow.mDropDownGravity = this.mDropDownGravity;
        menuPopupWindow.mModal = true;
        appCompatPopupWindow.setFocusable(true);
        appCompatPopupWindow.setInputMethodMode(2);
        menuPopupWindow.setAdapter(menuAdapter2);
        menuPopupWindow.setContentWidth(iMeasureIndividualMenuWidth);
        menuPopupWindow.mDropDownGravity = this.mDropDownGravity;
        ArrayList arrayList = this.mShowingMenus;
        if (arrayList.size() > 0) {
            cascadingMenuInfo = (CascadingMenuInfo) arrayList.get(arrayList.size() - 1);
            MenuBuilder menuBuilder2 = cascadingMenuInfo.menu;
            int size = menuBuilder2.mItems.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    item = null;
                    break;
                }
                item = menuBuilder2.getItem(i5);
                if (item.hasSubMenu() && menuBuilder == item.getSubMenu()) {
                    break;
                } else {
                    i5++;
                }
            }
            if (item == null) {
                childAt = null;
            } else {
                DropDownListView dropDownListView = cascadingMenuInfo.window.mDropDownList;
                ListAdapter adapter = dropDownListView.getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    menuAdapter = (MenuAdapter) adapter;
                    headersCount = 0;
                }
                int count = menuAdapter.getCount();
                int i6 = 0;
                while (true) {
                    if (i6 >= count) {
                        i4 = -1;
                        i6 = -1;
                        break;
                    } else {
                        if (item == menuAdapter.getItem(i6)) {
                            i4 = -1;
                            break;
                        }
                        i6++;
                    }
                }
                childAt = (i6 != i4 && (firstVisiblePosition = (i6 + headersCount) - dropDownListView.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < dropDownListView.getChildCount()) ? dropDownListView.getChildAt(firstVisiblePosition) : null;
            }
        } else {
            childAt = null;
            cascadingMenuInfo = null;
        }
        if (childAt != null) {
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = MenuPopupWindow.sSetTouchModalMethod;
                if (method != null) {
                    try {
                        method.invoke(appCompatPopupWindow, Boolean.FALSE);
                    } catch (Exception unused) {
                        Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                    }
                }
            } else {
                MenuPopupWindow.Api29Impl.setTouchModal(appCompatPopupWindow, false);
            }
            MenuPopupWindow.Api23Impl.setEnterTransition(appCompatPopupWindow, null);
            DropDownListView dropDownListView2 = ((CascadingMenuInfo) arrayList.get(arrayList.size() - 1)).window.mDropDownList;
            int[] iArr = new int[2];
            dropDownListView2.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            this.mShownAnchorView.getWindowVisibleDisplayFrame(rect);
            if (this.mLastPosition == 1) {
                if (dropDownListView2.getWidth() + iArr[0] + iMeasureIndividualMenuWidth > rect.right) {
                    i = 0;
                } else {
                    i = 1;
                }
            } else if (iArr[0] - iMeasureIndividualMenuWidth < 0) {
                i = 1;
            } else {
                i = 0;
            }
            boolean z = i == 1;
            this.mLastPosition = i;
            if (Build.VERSION.SDK_INT >= 26) {
                menuPopupWindow.mDropDownAnchorView = childAt;
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr2 = new int[2];
                this.mAnchorView.getLocationOnScreen(iArr2);
                int[] iArr3 = new int[2];
                childAt.getLocationOnScreen(iArr3);
                if ((this.mDropDownGravity & 7) == 5) {
                    c = 0;
                    iArr2[0] = this.mAnchorView.getWidth() + iArr2[0];
                    iArr3[0] = childAt.getWidth() + iArr3[0];
                } else {
                    c = 0;
                }
                i2 = iArr3[c] - iArr2[c];
                i3 = iArr3[1] - iArr2[1];
            }
            if ((this.mDropDownGravity & 5) == 5) {
                width = z ? i2 + iMeasureIndividualMenuWidth : i2 - childAt.getWidth();
            } else {
                width = z ? i2 + childAt.getWidth() : i2 - iMeasureIndividualMenuWidth;
            }
            menuPopupWindow.mDropDownHorizontalOffset = width;
            menuPopupWindow.mOverlapAnchorSet = true;
            menuPopupWindow.mOverlapAnchor = true;
            menuPopupWindow.setVerticalOffset(i3);
        } else {
            if (this.mHasXOffset) {
                menuPopupWindow.mDropDownHorizontalOffset = this.mXOffset;
            }
            if (this.mHasYOffset) {
                menuPopupWindow.setVerticalOffset(this.mYOffset);
            }
            Rect rect2 = this.mEpicenterBounds;
            menuPopupWindow.mEpicenterBounds = rect2 != null ? new Rect(rect2) : null;
        }
        arrayList.add(new CascadingMenuInfo(menuPopupWindow, menuBuilder, this.mLastPosition));
        menuPopupWindow.show();
        DropDownListView dropDownListView3 = menuPopupWindow.mDropDownList;
        dropDownListView3.setOnKeyListener(this);
        if (cascadingMenuInfo == null && this.mShowTitle && menuBuilder.mHeaderTitle != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) dropDownListView3, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(menuBuilder.mHeaderTitle);
            dropDownListView3.addHeaderView(frameLayout, null, false);
            menuPopupWindow.show();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void updateMenuView() {
        Iterator it = this.mShowingMenus.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((CascadingMenuInfo) it.next()).window.mDropDownList.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((MenuAdapter) adapter).notifyDataSetChanged();
        }
    }
}
