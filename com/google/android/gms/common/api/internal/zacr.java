package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.AccountAccessor;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
final class zacr implements Runnable {
    public final /* synthetic */ com.google.android.gms.signin.internal.zak zaa;
    public final /* synthetic */ zact zab;

    public zacr(zact zactVar, com.google.android.gms.signin.internal.zak zakVar) {
        this.zab = zactVar;
        this.zaa = zakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAccountAccessor zzwVar;
        com.google.android.gms.signin.zaa zaaVar = zact.zaa;
        com.google.android.gms.signin.internal.zak zakVar = this.zaa;
        ConnectionResult connectionResult = zakVar.zab;
        boolean zIsSuccess = connectionResult.isSuccess();
        zact zactVar = this.zab;
        if (zIsSuccess) {
            com.google.android.gms.common.internal.zav zavVar = zakVar.zac;
            zzah.checkNotNull(zavVar);
            ConnectionResult connectionResult2 = zavVar.zac;
            if (!connectionResult2.isSuccess()) {
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(connectionResult2)), new Exception());
                zactVar.zah.zae(connectionResult2);
                zactVar.zag.disconnect();
                return;
            }
            zacs zacsVar = zactVar.zah;
            IBinder iBinder = zavVar.zab;
            if (iBinder == null) {
                zzwVar = null;
            } else {
                int i = AccountAccessor.$r8$clinit;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                zzwVar = iInterfaceQueryLocalInterface instanceof IAccountAccessor ? (IAccountAccessor) iInterfaceQueryLocalInterface : new zzw(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }
            zacsVar.zaf(zzwVar, zactVar.zae);
        } else {
            zactVar.zah.zae(connectionResult);
        }
        zactVar.zag.disconnect();
    }
}
