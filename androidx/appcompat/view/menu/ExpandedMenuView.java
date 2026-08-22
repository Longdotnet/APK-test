package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.google.firebase.auth.zzaa;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements MenuBuilder.ItemInvoker, MenuView, AdapterView.OnItemClickListener {
    public static final int[] TINT_ATTRS = {R.attr.background, R.attr.divider};
    public MenuBuilder mMenu;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        zzaa zzaaVarObtainStyledAttributes = zzaa.obtainStyledAttributes(context, attributeSet, TINT_ATTRS, R.attr.listViewStyle);
        TypedArray typedArray = (TypedArray) zzaaVarObtainStyledAttributes.zzb;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(zzaaVarObtainStyledAttributes.getDrawable(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(zzaaVarObtainStyledAttributes.getDrawable(1));
        }
        zzaaVarObtainStyledAttributes.recycle();
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public final void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public final boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, null, 0);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        invokeItem((MenuItemImpl) getAdapter().getItem(i));
    }
}
