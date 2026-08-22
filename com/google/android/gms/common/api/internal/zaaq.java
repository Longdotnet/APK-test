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
final class zaaq extends zabg {
    public final /* synthetic */ zaaw zaa;
    public final /* synthetic */ com.google.android.gms.signin.internal.zak zab;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaaq(zaaw zaawVar, zaaw zaawVar2, com.google.android.gms.signin.internal.zak zakVar) {
        super(zaawVar);
        this.zaa = zaawVar2;
        this.zab = zakVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabg
    public final void zaa() {
        IAccountAccessor zzwVar;
        zaaw zaawVar = this.zaa;
        if (zaawVar.zaG(0)) {
            com.google.android.gms.signin.internal.zak zakVar = this.zab;
            ConnectionResult connectionResult = zakVar.zab;
            if (!connectionResult.isSuccess()) {
                if (!zaawVar.zal || connectionResult.hasResolution()) {
                    zaawVar.zaD(connectionResult);
                    return;
                } else {
                    zaawVar.zaA();
                    zaawVar.zaF();
                    return;
                }
            }
            com.google.android.gms.common.internal.zav zavVar = zakVar.zac;
            zzah.checkNotNull(zavVar);
            ConnectionResult connectionResult2 = zavVar.zac;
            if (!connectionResult2.isSuccess()) {
                Log.wtf("GACConnecting", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(connectionResult2)), new Exception());
                zaawVar.zaD(connectionResult2);
                return;
            }
            zaawVar.zan = true;
            IBinder iBinder = zavVar.zab;
            if (iBinder == null) {
                zzwVar = null;
            } else {
                int i = AccountAccessor.$r8$clinit;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                zzwVar = iInterfaceQueryLocalInterface instanceof IAccountAccessor ? (IAccountAccessor) iInterfaceQueryLocalInterface : new zzw(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }
            zzah.checkNotNull(zzwVar);
            zaawVar.zao = zzwVar;
            zaawVar.zap = zavVar.zad;
            zaawVar.zaq = zavVar.zae;
            zaawVar.zaF();
        }
    }
}
