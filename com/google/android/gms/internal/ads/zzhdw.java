package com.google.android.gms.internal.ads;

import com.google.android.gms.games.event.AfJ.oKjScaD;

/* JADX INFO: loaded from: classes2.dex */
public final class zzhdw extends zzgzh implements zzhat {
    private static final zzhdw zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgxz zzd;
    private zzgxz zze;
    private byte zzf = 2;

    static {
        zzhdw zzhdwVar = new zzhdw();
        zza = zzhdwVar;
        zzgzh.zzbZ(zzhdw.class, zzhdwVar);
    }

    private zzhdw() {
        zzgxz zzgxzVar = zzgxz.zzb;
        this.zzd = zzgxzVar;
        this.zze = zzgxzVar;
    }

    public static zzhdv zzc() {
        return (zzhdv) zza.zzaZ();
    }

    public static /* synthetic */ void zzf(zzhdw zzhdwVar, zzgxz zzgxzVar) {
        zzhdwVar.zzc |= 1;
        zzhdwVar.zzd = zzgxzVar;
    }

    public static /* synthetic */ void zzg(zzhdw zzhdwVar, zzgxz zzgxzVar) {
        zzhdwVar.zzc |= 2;
        zzhdwVar.zze = zzgxzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhfx zzhfxVar = null;
        switch (zzgzgVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzf);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzf = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgzh.zzbQ(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{oKjScaD.MDoLOAJ, "zzd", "zze"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhdw();
            case NEW_BUILDER:
                return new zzhdv(zzhfxVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzhba zzgzcVar = zzb;
                if (zzgzcVar == null) {
                    synchronized (zzhdw.class) {
                        try {
                            zzgzcVar = zzb;
                            if (zzgzcVar == null) {
                                zzgzcVar = new zzgzc(zza);
                                zzb = zzgzcVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                }
                return zzgzcVar;
            default:
                throw null;
        }
    }
}
