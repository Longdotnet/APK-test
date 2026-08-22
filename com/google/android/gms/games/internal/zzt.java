package com.google.android.gms.games.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.games_v2.zzfn;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class zzt extends com.google.android.gms.internal.games_v2.zzab {
    public final /* synthetic */ zzah zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzt(zzah zzahVar) {
        super(zzahVar.getContext().getMainLooper(), 1000);
        Objects.requireNonNull(zzahVar);
        this.zza = zzahVar;
    }

    @Override // com.google.android.gms.internal.games_v2.zzab
    public final void zza(String str, int i) {
        String str2 = GsPcpBmONXh.imJCoTfIhYied;
        try {
            zzah zzahVar = this.zza;
            if (zzahVar.isConnected()) {
                ((zzam) zzahVar.getService()).zzJ(str, i);
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30 + String.valueOf(i).length() + 48);
            sb.append("Unable to increment event ");
            sb.append(str);
            sb.append(" by ");
            sb.append(i);
            sb.append(" because the games client is no longer connected");
            zzfn.zzg(str2, sb.toString());
        } catch (RemoteException e) {
            zzfn.zzf(str2, "service died", e);
        } catch (SecurityException e2) {
            zzfn.zzh(str2, "Is player signed out?", e2);
        }
    }
}
