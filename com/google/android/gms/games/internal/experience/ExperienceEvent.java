package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.games.Game;

/* JADX INFO: loaded from: classes.dex */
public interface ExperienceEvent extends Parcelable {
    /* synthetic */ Object freeze();

    @Deprecated
    String getIconImageUrl();

    /* synthetic */ boolean isDataValid();

    String zza();

    Game zzb();

    String zzc();

    String zzd();

    Uri zze();

    long zzf();

    long zzg();

    long zzh();

    int zzi();

    int zzj();
}
