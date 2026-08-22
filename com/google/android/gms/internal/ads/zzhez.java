package com.google.android.gms.internal.ads;

import androidx.core.internal.view.Oteb.nYVxXTZQ;

/* JADX INFO: loaded from: classes2.dex */
public final class zzhez extends zzgzh implements zzhat {
    private static final zzhez zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzhea zzf;
    private zzhee zzg;
    private int zzh;
    private int zzk;
    private byte zzm = 2;
    private String zze = "";
    private zzgzp zzi = zzgzh.zzbG();
    private String zzj = "";
    private zzgzt zzl = zzgzh.zzbK();

    static {
        zzhez zzhezVar = new zzhez();
        zza = zzhezVar;
        zzgzh.zzbZ(zzhez.class, zzhezVar);
    }

    private zzhez() {
    }

    public static zzhey zzd() {
        return (zzhey) zza.zzaZ();
    }

    public static /* synthetic */ void zzh(zzhez zzhezVar, String str) {
        str.getClass();
        zzgzt zzgztVar = zzhezVar.zzl;
        if (!zzgztVar.zzc()) {
            zzhezVar.zzl = zzgzh.zzbL(zzgztVar);
        }
        zzhezVar.zzl.add(str);
    }

    public static /* synthetic */ void zzi(zzhez zzhezVar, int i) {
        zzhezVar.zzc |= 1;
        zzhezVar.zzd = i;
    }

    public static /* synthetic */ void zzj(zzhez zzhezVar, zzhea zzheaVar) {
        zzheaVar.getClass();
        zzhezVar.zzf = zzheaVar;
        zzhezVar.zzc |= 4;
    }

    public static /* synthetic */ void zzk(zzhez zzhezVar, String str) {
        str.getClass();
        zzhezVar.zzc |= 2;
        zzhezVar.zze = str;
    }

    public static /* synthetic */ void zzl(zzhez zzhezVar, int i) {
        zzhezVar.zzk = i - 1;
        zzhezVar.zzc |= 64;
    }

    public final int zzc() {
        return this.zzl.size();
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhfx zzhfxVar = null;
        switch (zzgzgVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzm);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzm = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgzh.zzbQ(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\b᠌\u0006\t\u001a", new Object[]{"zzc", "zzd", "zze", "zzf", nYVxXTZQ.ZMEbxmLWhciK, "zzh", "zzi", "zzj", "zzk", zzhew.zza, "zzl"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhez();
            case NEW_BUILDER:
                return new zzhey(zzhfxVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzhba zzgzcVar = zzb;
                if (zzgzcVar == null) {
                    synchronized (zzhez.class) {
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

    public final String zzg() {
        return this.zze;
    }
}
