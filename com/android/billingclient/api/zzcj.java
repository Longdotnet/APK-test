package com.android.billingclient.api;

import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.lifecycle.Observer;
import com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossType;
import com.facebook.ProfileCache;
import com.google.android.datatransport.AutoValue_Event;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.auth.api.signin.internal.zbc;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzhe;
import com.google.firebase.auth.zzaa;

/* JADX INFO: loaded from: classes.dex */
public final class zzcj implements MenuPresenter.Callback, Observer {
    public final /* synthetic */ int $r8$classId;
    public boolean zza;
    public Object zzb;

    public /* synthetic */ zzcj(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(Object obj) {
        ProfileCache profileCache = (ProfileCache) this.zzb;
        profileCache.getClass();
        SignInHubActivity signInHubActivity = (SignInHubActivity) profileCache.sharedPreferences;
        signInHubActivity.setResult(signInHubActivity.zbe, signInHubActivity.zbf);
        signInHubActivity.finish();
        this.zza = true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        ActionMenuPresenter actionMenuPresenter;
        if (this.zza) {
            return;
        }
        this.zza = true;
        ToolbarActionBar toolbarActionBar = (ToolbarActionBar) this.zzb;
        ActionMenuView actionMenuView = toolbarActionBar.mDecorToolbar.mToolbar.mMenuView;
        if (actionMenuView != null && (actionMenuPresenter = actionMenuView.mPresenter) != null) {
            actionMenuPresenter.hideOverflowMenu();
            ActionMenuPresenter.OverflowPopup overflowPopup = actionMenuPresenter.mActionButtonPopup;
            if (overflowPopup != null && overflowPopup.isShowing()) {
                overflowPopup.mPopup.dismiss();
            }
        }
        toolbarActionBar.mWindowCallback.onPanelClosed(TossType.TOSS_FIXED_MED_FOR_BEGINNER_VALUE, menuBuilder);
        this.zza = false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        ((ToolbarActionBar) this.zzb).mWindowCallback.onMenuOpened(TossType.TOSS_FIXED_MED_FOR_BEGINNER_VALUE, menuBuilder);
        return true;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 2:
                return ((ProfileCache) this.zzb).toString();
            default:
                return super.toString();
        }
    }

    public void zza(zzhe zzheVar) {
        if (this.zza) {
            zzb.zzk("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            ((zzaa) this.zzb).send(new AutoValue_Event(zzheVar));
        } catch (Throwable unused) {
            zzb.zzk("BillingLogger", "logging failed.");
        }
    }

    public zzcj(zbc zbcVar, ProfileCache profileCache) {
        this.$r8$classId = 2;
        this.zza = false;
        this.zzb = profileCache;
    }

    public zzcj(ToolbarActionBar toolbarActionBar) {
        this.$r8$classId = 1;
        this.zzb = toolbarActionBar;
    }
}
