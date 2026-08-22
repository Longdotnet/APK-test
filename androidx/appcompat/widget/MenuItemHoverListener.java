package androidx.appcompat.widget;

import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: loaded from: classes.dex */
public interface MenuItemHoverListener {
    void onItemHoverEnter(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl);

    void onItemHoverExit(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl);
}
