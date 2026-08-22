package com.google.android.gms.internal.ads;

import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;

/* JADX INFO: loaded from: classes2.dex */
public final class zzhee extends zzgzh implements zzhat {
    private static final zzhee zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzhed zzd;
    private zzgxz zzf;
    private zzgxz zzg;
    private int zzh;
    private zzgxz zzi;
    private byte zzj = 2;
    private zzgzt zze = zzgzh.zzbK();

    static {
        zzhee zzheeVar = new zzhee();
        zza = zzheeVar;
        zzgzh.zzbZ(zzhee.class, zzheeVar);
    }

    private zzhee() {
        zzgxz zzgxzVar = zzgxz.zzb;
        this.zzf = zzgxzVar;
        this.zzg = zzgxzVar;
        this.zzi = zzgxzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhfx zzhfxVar = null;
        switch (zzgzgVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzj);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzj = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgzh.zzbQ(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzc", DaWYVMJ.JWkfpXkvS, "zze", zzhdw.class, "zzf", "zzg", "zzh", "zzi"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhee();
            case NEW_BUILDER:
                return new zzheb(zzhfxVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzhba zzgzcVar = zzb;
                if (zzgzcVar == null) {
                    synchronized (zzhee.class) {
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
