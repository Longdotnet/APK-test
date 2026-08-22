package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.MenuItemCompat$Api26Impl;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public final class SupportMenuInflater extends MenuInflater {
    public static final Class[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
    public static final Class[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    public final Object[] mActionProviderConstructorArguments;
    public final Object[] mActionViewConstructorArguments;
    public final Context mContext;
    public Object mRealOwner;

    /* JADX INFO: loaded from: classes.dex */
    public final class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        public static final Class[] PARAM_TYPES = {MenuItem.class};
        public Method mMethod;
        public Object mRealOwner;

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            Method method = this.mMethod;
            try {
                Class<?> returnType = method.getReturnType();
                Class<?> cls = Boolean.TYPE;
                Object obj = this.mRealOwner;
                if (returnType == cls) {
                    return ((Boolean) method.invoke(obj, menuItem)).booleanValue();
                }
                method.invoke(obj, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class MenuState {
        public MenuItemWrapperICS.ActionProviderWrapper itemActionProvider;
        public String itemActionViewClassName;
        public int itemActionViewLayout;
        public boolean itemAdded;
        public int itemAlphabeticModifiers;
        public char itemAlphabeticShortcut;
        public int itemCategoryOrder;
        public int itemCheckable;
        public boolean itemChecked;
        public CharSequence itemContentDescription;
        public boolean itemEnabled;
        public int itemIconResId;
        public int itemId;
        public String itemListenerMethodName;
        public int itemNumericModifiers;
        public char itemNumericShortcut;
        public int itemShowAsAction;
        public CharSequence itemTitle;
        public CharSequence itemTitleCondensed;
        public CharSequence itemTooltipText;
        public boolean itemVisible;
        public final Menu menu;
        public ColorStateList itemIconTintList = null;
        public PorterDuff.Mode itemIconTintMode = null;
        public int groupId = 0;
        public int groupCategory = 0;
        public int groupOrder = 0;
        public int groupCheckable = 0;
        public boolean groupVisible = true;
        public boolean groupEnabled = true;

        public MenuState(Menu menu) {
            this.menu = menu;
        }

        public final Object newInstance(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.mContext.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        public final void setItem(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled).setCheckable(this.itemCheckable >= 1).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
            int i = this.itemShowAsAction;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            String str = this.itemListenerMethodName;
            SupportMenuInflater supportMenuInflater = SupportMenuInflater.this;
            if (str != null) {
                if (supportMenuInflater.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                if (supportMenuInflater.mRealOwner == null) {
                    supportMenuInflater.mRealOwner = SupportMenuInflater.findRealOwner(supportMenuInflater.mContext);
                }
                Object obj = supportMenuInflater.mRealOwner;
                String str2 = this.itemListenerMethodName;
                InflatedOnMenuItemClickListener inflatedOnMenuItemClickListener = new InflatedOnMenuItemClickListener();
                inflatedOnMenuItemClickListener.mRealOwner = obj;
                Class<?> cls = obj.getClass();
                try {
                    inflatedOnMenuItemClickListener.mMethod = cls.getMethod(str2, InflatedOnMenuItemClickListener.PARAM_TYPES);
                    menuItem.setOnMenuItemClickListener(inflatedOnMenuItemClickListener);
                } catch (Exception e) {
                    StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("Couldn't resolve menu item onClick handler ", str2, " in class ");
                    sbM21m.append(cls.getName());
                    InflateException inflateException = new InflateException(sbM21m.toString());
                    inflateException.initCause(e);
                    throw inflateException;
                }
            }
            if (this.itemCheckable >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
                    menuItemImpl.mFlags = (menuItemImpl.mFlags & (-5)) | 4;
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    MenuItemWrapperICS menuItemWrapperICS = (MenuItemWrapperICS) menuItem;
                    try {
                        Method method = menuItemWrapperICS.mSetExclusiveCheckableMethod;
                        SupportMenuItem supportMenuItem = menuItemWrapperICS.mWrappedObject;
                        if (method == null) {
                            menuItemWrapperICS.mSetExclusiveCheckableMethod = supportMenuItem.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        menuItemWrapperICS.mSetExclusiveCheckableMethod.invoke(supportMenuItem, Boolean.TRUE);
                    } catch (Exception e2) {
                        Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
                    }
                }
            }
            String str3 = this.itemActionViewClassName;
            if (str3 != null) {
                menuItem.setActionView((View) newInstance(str3, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, supportMenuInflater.mActionViewConstructorArguments));
                z = true;
            }
            int i2 = this.itemActionViewLayout;
            if (i2 > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i2);
                }
            }
            MenuItemWrapperICS.ActionProviderWrapper actionProviderWrapper = this.itemActionProvider;
            if (actionProviderWrapper != null) {
                if (menuItem instanceof SupportMenuItem) {
                    ((SupportMenuItem) menuItem).setSupportActionProvider(actionProviderWrapper);
                } else {
                    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
                }
            }
            CharSequence charSequence = this.itemContentDescription;
            boolean z2 = menuItem instanceof SupportMenuItem;
            if (z2) {
                ((SupportMenuItem) menuItem).setContentDescription(charSequence);
            } else if (Build.VERSION.SDK_INT >= 26) {
                MenuItemCompat$Api26Impl.setContentDescription(menuItem, charSequence);
            }
            CharSequence charSequence2 = this.itemTooltipText;
            if (z2) {
                ((SupportMenuItem) menuItem).setTooltipText(charSequence2);
            } else if (Build.VERSION.SDK_INT >= 26) {
                MenuItemCompat$Api26Impl.setTooltipText(menuItem, charSequence2);
            }
            char c = this.itemAlphabeticShortcut;
            int i3 = this.itemAlphabeticModifiers;
            if (z2) {
                ((SupportMenuItem) menuItem).setAlphabeticShortcut(c, i3);
            } else if (Build.VERSION.SDK_INT >= 26) {
                MenuItemCompat$Api26Impl.setAlphabeticShortcut(menuItem, c, i3);
            }
            char c2 = this.itemNumericShortcut;
            int i4 = this.itemNumericModifiers;
            if (z2) {
                ((SupportMenuItem) menuItem).setNumericShortcut(c2, i4);
            } else if (Build.VERSION.SDK_INT >= 26) {
                MenuItemCompat$Api26Impl.setNumericShortcut(menuItem, c2, i4);
            }
            PorterDuff.Mode mode = this.itemIconTintMode;
            if (mode != null) {
                if (z2) {
                    ((SupportMenuItem) menuItem).setIconTintMode(mode);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    MenuItemCompat$Api26Impl.setIconTintMode(menuItem, mode);
                }
            }
            ColorStateList colorStateList = this.itemIconTintList;
            if (colorStateList != null) {
                if (z2) {
                    ((SupportMenuItem) menuItem).setIconTintList(colorStateList);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    MenuItemCompat$Api26Impl.setIconTintList(menuItem, colorStateList);
                }
            }
        }
    }

    static {
        Class[] clsArr = {Context.class};
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = clsArr;
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = clsArr;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.mContext = context;
        Object[] objArr = {context};
        this.mActionViewConstructorArguments = objArr;
        this.mActionProviderConstructorArguments = objArr;
    }

    public static Object findRealOwner(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? findRealOwner(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i, Menu menu) {
        if (!(menu instanceof MenuBuilder)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z = false;
        try {
            try {
                layout = this.mContext.getResources().getLayout(i);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof MenuBuilder) {
                    MenuBuilder menuBuilder = (MenuBuilder) menu;
                    if (!menuBuilder.mPreventDispatchingItemsChanged) {
                        menuBuilder.stopDispatchingItemsChanged();
                        z = true;
                    }
                }
                parseMenu(layout, attributeSetAsAttributeSet, menu);
                if (z) {
                    ((MenuBuilder) menu).startDispatchingItemsChanged();
                }
                layout.close();
            } catch (IOException e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } catch (Throwable th) {
            if (z) {
                ((MenuBuilder) menu).startDispatchingItemsChanged();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0, types: [androidx.appcompat.view.SupportMenuInflater] */
    /* JADX WARN: Type inference failed for: r3v15, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v60 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public final void parseMenu(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        ?? r4;
        int i;
        ?? r6;
        ColorStateList colorStateList;
        int resourceId;
        MenuState menuState = new MenuState(menu);
        int eventType = xmlResourceParser.getEventType();
        do {
            r4 = 1;
            i = 2;
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
                eventType = xmlResourceParser.next();
                break;
            }
            eventType = xmlResourceParser.next();
        } while (eventType != 1);
        boolean z = false;
        boolean z2 = false;
        String str = null;
        while (!z) {
            if (eventType == r4) {
                throw new RuntimeException("Unexpected end of document");
            }
            String str2 = FKidOcdAYt.YXlfjTVasgPwOX;
            if (eventType == i) {
                if (!z2) {
                    String name2 = xmlResourceParser.getName();
                    boolean zEquals = name2.equals("group");
                    SupportMenuInflater supportMenuInflater = SupportMenuInflater.this;
                    if (zEquals) {
                        ?? ObtainStyledAttributes = supportMenuInflater.mContext.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
                        menuState.groupId = ObtainStyledAttributes.getResourceId(r4, 0);
                        menuState.groupCategory = ObtainStyledAttributes.getInt(3, 0);
                        menuState.groupOrder = ObtainStyledAttributes.getInt(4, 0);
                        menuState.groupCheckable = ObtainStyledAttributes.getInt(5, 0);
                        menuState.groupVisible = ObtainStyledAttributes.getBoolean(2, r4);
                        menuState.groupEnabled = ObtainStyledAttributes.getBoolean(0, r4);
                        ObtainStyledAttributes.recycle();
                    } else if (name2.equals(str2)) {
                        Context context = supportMenuInflater.mContext;
                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MenuItem);
                        menuState.itemId = typedArrayObtainStyledAttributes.getResourceId(2, 0);
                        menuState.itemCategoryOrder = (typedArrayObtainStyledAttributes.getInt(5, menuState.groupCategory) & (-65536)) | (typedArrayObtainStyledAttributes.getInt(6, menuState.groupOrder) & 65535);
                        menuState.itemTitle = typedArrayObtainStyledAttributes.getText(7);
                        menuState.itemTitleCondensed = typedArrayObtainStyledAttributes.getText(8);
                        menuState.itemIconResId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
                        String string = typedArrayObtainStyledAttributes.getString(9);
                        menuState.itemAlphabeticShortcut = string == null ? (char) 0 : string.charAt(0);
                        menuState.itemAlphabeticModifiers = typedArrayObtainStyledAttributes.getInt(16, 4096);
                        String string2 = typedArrayObtainStyledAttributes.getString(10);
                        menuState.itemNumericShortcut = string2 == null ? (char) 0 : string2.charAt(0);
                        menuState.itemNumericModifiers = typedArrayObtainStyledAttributes.getInt(20, 4096);
                        if (typedArrayObtainStyledAttributes.hasValue(11)) {
                            menuState.itemCheckable = typedArrayObtainStyledAttributes.getBoolean(11, false) ? 1 : 0;
                        } else {
                            menuState.itemCheckable = menuState.groupCheckable;
                        }
                        menuState.itemChecked = typedArrayObtainStyledAttributes.getBoolean(3, false);
                        menuState.itemVisible = typedArrayObtainStyledAttributes.getBoolean(4, menuState.groupVisible);
                        menuState.itemEnabled = typedArrayObtainStyledAttributes.getBoolean(1, menuState.groupEnabled);
                        menuState.itemShowAsAction = typedArrayObtainStyledAttributes.getInt(21, -1);
                        menuState.itemListenerMethodName = typedArrayObtainStyledAttributes.getString(12);
                        menuState.itemActionViewLayout = typedArrayObtainStyledAttributes.getResourceId(13, 0);
                        menuState.itemActionViewClassName = typedArrayObtainStyledAttributes.getString(15);
                        String string3 = typedArrayObtainStyledAttributes.getString(14);
                        boolean z3 = string3 != null;
                        if (z3 && menuState.itemActionViewLayout == 0 && menuState.itemActionViewClassName == null) {
                            menuState.itemActionProvider = (MenuItemWrapperICS.ActionProviderWrapper) menuState.newInstance(string3, ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, supportMenuInflater.mActionProviderConstructorArguments);
                        } else {
                            if (z3) {
                                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                            }
                            menuState.itemActionProvider = null;
                        }
                        menuState.itemContentDescription = typedArrayObtainStyledAttributes.getText(17);
                        menuState.itemTooltipText = typedArrayObtainStyledAttributes.getText(22);
                        if (typedArrayObtainStyledAttributes.hasValue(19)) {
                            menuState.itemIconTintMode = DrawableUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(19, -1), menuState.itemIconTintMode);
                        } else {
                            menuState.itemIconTintMode = null;
                        }
                        if (typedArrayObtainStyledAttributes.hasValue(18)) {
                            if (!typedArrayObtainStyledAttributes.hasValue(18) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(18, 0)) == 0 || (colorStateList = ContextCompat.getColorStateList(context, resourceId)) == null) {
                                colorStateList = typedArrayObtainStyledAttributes.getColorStateList(18);
                            }
                            menuState.itemIconTintList = colorStateList;
                        } else {
                            menuState.itemIconTintList = null;
                        }
                        typedArrayObtainStyledAttributes.recycle();
                        menuState.itemAdded = false;
                        r6 = 1;
                    } else if (name2.equals("menu")) {
                        r6 = 1;
                        menuState.itemAdded = true;
                        SubMenu subMenuAddSubMenu = menuState.menu.addSubMenu(menuState.groupId, menuState.itemId, menuState.itemCategoryOrder, menuState.itemTitle);
                        menuState.setItem(subMenuAddSubMenu.getItem());
                        parseMenu(xmlResourceParser, attributeSet, subMenuAddSubMenu);
                    } else {
                        r6 = 1;
                        str = name2;
                        z2 = true;
                    }
                }
                r6 = r4;
                z = z;
            } else if (eventType != 3) {
                r6 = r4;
                z = z;
            } else {
                String name3 = xmlResourceParser.getName();
                if (z2 && name3.equals(str)) {
                    r6 = r4;
                    z2 = false;
                    str = null;
                } else {
                    if (name3.equals("group")) {
                        menuState.groupId = 0;
                        menuState.groupCategory = 0;
                        menuState.groupOrder = 0;
                        menuState.groupCheckable = 0;
                        menuState.groupVisible = r4;
                        menuState.groupEnabled = r4;
                    } else if (name3.equals(str2)) {
                        if (!menuState.itemAdded) {
                            MenuItemWrapperICS.ActionProviderWrapper actionProviderWrapper = menuState.itemActionProvider;
                            if (actionProviderWrapper == null || !actionProviderWrapper.mInner.hasSubMenu()) {
                                menuState.itemAdded = r4;
                                menuState.setItem(menuState.menu.add(menuState.groupId, menuState.itemId, menuState.itemCategoryOrder, menuState.itemTitle));
                            } else {
                                menuState.itemAdded = r4;
                                menuState.setItem(menuState.menu.addSubMenu(menuState.groupId, menuState.itemId, menuState.itemCategoryOrder, menuState.itemTitle).getItem());
                            }
                        }
                    } else if (name3.equals("menu")) {
                        ?? r7 = r4;
                        z = r7 == true ? 1 : 0;
                        r6 = r7;
                    }
                    r6 = r4;
                    z = z;
                }
            }
            eventType = xmlResourceParser.next();
            r4 = r6;
            i = 2;
            z = z;
            z2 = z2;
        }
    }
}
