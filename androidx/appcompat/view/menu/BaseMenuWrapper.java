package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.IntentFilter;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import com.google.android.gms.ads.internal.util.zzq;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseMenuWrapper {
    public Object mContext;
    public Object mMenuItems;

    public BaseMenuWrapper(Context context) {
        this.mContext = context;
    }

    public void cleanup() {
        zzq zzqVar = (zzq) this.mContext;
        if (zzqVar != null) {
            try {
                ((AppCompatDelegateImpl) this.mMenuItems).mContext.unregisterReceiver(zzqVar);
            } catch (IllegalArgumentException unused) {
            }
            this.mContext = null;
        }
    }

    public void completeSpecialEffect() {
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) this.mContext;
        HashSet hashSet = specialEffectsController$FragmentStateManagerOperation.mSpecialEffectsSignals;
        if (hashSet.remove((CancellationSignal) this.mMenuItems) && hashSet.isEmpty()) {
            specialEffectsController$FragmentStateManagerOperation.complete();
        }
    }

    public abstract IntentFilter createIntentFilterForBroadcastReceiver();

    public abstract int getApplyableNightMode();

    public MenuItem getMenuItemWrapper(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (((SimpleArrayMap) this.mMenuItems) == null) {
            this.mMenuItems = new SimpleArrayMap();
        }
        MenuItem menuItem2 = (MenuItem) ((SimpleArrayMap) this.mMenuItems).getOrDefault(supportMenuItem, null);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS((Context) this.mContext, supportMenuItem);
        ((SimpleArrayMap) this.mMenuItems).put(supportMenuItem, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    public boolean isVisibilityUnchanged() {
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) this.mContext;
        int i_from = Fragment$$ExternalSyntheticOutline0._from(specialEffectsController$FragmentStateManagerOperation.mFragment.mView);
        int i = specialEffectsController$FragmentStateManagerOperation.mFinalState;
        return i_from == i || !(i_from == 2 || i == 2);
    }

    public abstract void onChange();

    public void setup() {
        cleanup();
        IntentFilter intentFilterCreateIntentFilterForBroadcastReceiver = createIntentFilterForBroadcastReceiver();
        if (intentFilterCreateIntentFilterForBroadcastReceiver.countActions() == 0) {
            return;
        }
        if (((zzq) this.mContext) == null) {
            this.mContext = new zzq(this, 2);
        }
        ((AppCompatDelegateImpl) this.mMenuItems).mContext.registerReceiver((zzq) this.mContext, intentFilterCreateIntentFilterForBroadcastReceiver);
    }

    public BaseMenuWrapper(SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation, CancellationSignal cancellationSignal) {
        this.mContext = specialEffectsController$FragmentStateManagerOperation;
        this.mMenuItems = cancellationSignal;
    }

    public BaseMenuWrapper(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.mMenuItems = appCompatDelegateImpl;
    }
}
