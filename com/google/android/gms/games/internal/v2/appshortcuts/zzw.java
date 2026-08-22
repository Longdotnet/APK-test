package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzw extends com.google.android.gms.internal.games_v2.zzb implements zzx {
    public zzw() {
        super("com.google.android.gms.games.internal.v2.appshortcuts.IAppShortcutsServiceCallback");
    }

    @Override // com.google.android.gms.internal.games_v2.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            Status status = (Status) com.google.android.gms.internal.games_v2.zzc.zzb(parcel, Status.CREATOR);
            com.google.android.gms.internal.games_v2.zzc.zze(parcel);
            zzd(status);
        } else if (i == 2) {
            zzg zzgVar = (zzg) com.google.android.gms.internal.games_v2.zzc.zzb(parcel, zzg.CREATOR);
            com.google.android.gms.internal.games_v2.zzc.zze(parcel);
            zzb(zzgVar);
        } else {
            if (i != 3) {
                return false;
            }
            Intent intent = (Intent) com.google.android.gms.internal.games_v2.zzc.zzb(parcel, Intent.CREATOR);
            com.google.android.gms.internal.games_v2.zzc.zze(parcel);
            zzc(intent);
        }
        return true;
    }
}
