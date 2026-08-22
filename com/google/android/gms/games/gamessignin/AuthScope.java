package com.google.android.gms.games.gamessignin;

import androidx.core.internal.view.Oteb.nYVxXTZQ;
import com.google.android.gms.internal.games_v2.zzhd;
import com.google.android.gms.internal.games_v2.zzhf;
import com.google.android.gms.internal.games_v2.zzhg;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
public enum AuthScope {
    EMAIL("email"),
    PROFILE("profile"),
    OPEN_ID("openid"),
    GAMES_LITE("https://www.googleapis.com/auth/games_lite"),
    DRIVE_APP_FOLDER(nYVxXTZQ.xBWFyp);

    public static final zzhg zzd;
    public final String zzc;

    AuthScope(String str) {
        this.zzc = str;
    }

    public static zzhd zza(List list) {
        Objects.requireNonNull(list, "Input scopes list cannot be null");
        Stream stream = list.stream();
        zzb zzbVar = zzb.zza;
        return (zzhd) stream.map(zzb.zza).distinct().collect(zzhd.zzh());
    }

    public static zzhd zzb(List list) {
        Objects.requireNonNull(list, "Input values list cannot be null");
        Stream stream = list.stream();
        zza zzaVar = zza.zza;
        return (zzhd) stream.map(zza.zza).collect(zzhd.zzh());
    }

    public String getValue() {
        return this.zzc;
    }

    static {
        zzhf zzhfVar = new zzhf();
        for (AuthScope authScope : values()) {
            zzhfVar.zza(authScope.zzc, authScope);
        }
        zzd = zzhfVar.zzb();
    }
}
