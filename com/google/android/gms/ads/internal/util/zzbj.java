package com.google.android.gms.ads.internal.util;

import androidx.room.RoomOpenHelper;
import com.facebook.AccessTokenCache;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.internal.ads.zzari;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzbj extends zzari {
    public final /* synthetic */ byte[] zza;
    public final /* synthetic */ HashMap zzb;
    public final /* synthetic */ zzl zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbj(zzbo zzboVar, int i, String str, zzbk zzbkVar, RoomOpenHelper roomOpenHelper, byte[] bArr, HashMap map, zzl zzlVar) {
        super(i, str, zzbkVar, roomOpenHelper);
        this.zza = bArr;
        this.zzb = map;
        this.zzc = zzlVar;
        Objects.requireNonNull(zzboVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaqd
    public final Map zzl() {
        HashMap map = this.zzb;
        return map == null ? Collections.emptyMap() : map;
    }

    @Override // com.google.android.gms.internal.ads.zzaqd
    public final byte[] zzx() {
        byte[] bArr = this.zza;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzari, com.google.android.gms.internal.ads.zzaqd
    /* JADX INFO: renamed from: zzz */
    public final void zzo(String str) {
        zzl zzlVar = this.zzc;
        if (zzl.zzk() && str != null) {
            zzlVar.zzn("onNetworkResponseBody", new AccessTokenCache(str.getBytes(), 18));
        }
        super.zzo(str);
    }
}
