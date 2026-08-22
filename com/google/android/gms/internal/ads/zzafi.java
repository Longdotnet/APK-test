package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzafi implements zzadv {
    private static final int[] zza = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] zzb = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    private static final byte[] zzc;
    private static final byte[] zzd;
    private final byte[] zze;
    private final zzafb zzf;
    private boolean zzg;
    private long zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private zzady zzn;
    private zzafb zzo;
    private zzafb zzp;
    private zzaeu zzq;
    private long zzr;
    private boolean zzs;

    static {
        String str = zzex.zza;
        Charset charset = StandardCharsets.UTF_8;
        zzc = "#!AMR\n".getBytes(charset);
        zzd = "#!AMR-WB\n".getBytes(charset);
    }

    public zzafi() {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002c  */
    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0081  */
    private final int zza(zzadw zzadwVar) throws zzaz {
        int i = this.zzj;
        if (i == 0) {
            try {
                zzadwVar.zzj();
                byte[] bArr = this.zze;
                zzadwVar.zzh(bArr, 0, 1);
                byte b = bArr[0];
                if ((b & 131) > 0) {
                    throw zzaz.zza("Invalid padding bits for frame header " + ((int) b), null);
                }
                int i2 = b >> 3;
                boolean z = this.zzg;
                int i3 = i2 & 15;
                if (!z) {
                    if (!z) {
                        if (i3 >= 12 && i3 <= 14) {
                        }
                    }
                    throw zzaz.zza("Illegal AMR " + (true != z ? "NB" : "WB") + " frame type " + i3, null);
                }
                if (i3 >= 10 && i3 <= 13) {
                    if (!z) {
                        if (i3 >= 12) {
                        }
                    }
                    if (true != z) {
                    }
                    throw zzaz.zza("Illegal AMR " + (true != z ? "NB" : "WB") + " frame type " + i3, null);
                }
                i = z ? zzb[i3] : zza[i3];
                this.zzi = i;
                this.zzj = i;
                int i4 = this.zzk;
                if (i4 == -1) {
                    this.zzk = i;
                    i4 = i;
                }
                if (i4 == i) {
                    this.zzl++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iZzf = this.zzp.zzf(zzadwVar, i, true);
        if (iZzf == -1) {
            return -1;
        }
        int i5 = this.zzj - iZzf;
        this.zzj = i5;
        if (i5 > 0) {
            return 0;
        }
        this.zzp.zzt(this.zzh, 1, this.zzi, 0, null);
        this.zzh += 20000;
        return 0;
    }

    private static boolean zzg(zzadw zzadwVar, byte[] bArr) {
        zzadwVar.zzj();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        zzadwVar.zzh(bArr2, 0, length);
        return Arrays.equals(bArr2, bArr);
    }

    private final boolean zzh(zzadw zzadwVar) {
        byte[] bArr = zzc;
        if (zzg(zzadwVar, bArr)) {
            this.zzg = false;
            zzadwVar.zzk(bArr.length);
            return true;
        }
        byte[] bArr2 = zzd;
        if (!zzg(zzadwVar, bArr2)) {
            return false;
        }
        this.zzg = true;
        zzadwVar.zzk(bArr2.length);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws zzaz {
        zzdd.zzb(this.zzo);
        String str = zzex.zza;
        if (zzadwVar.zzf() == 0 && !zzh(zzadwVar)) {
            throw zzaz.zza("Could not find AMR header.", null);
        }
        if (!this.zzs) {
            this.zzs = true;
            boolean z = this.zzg;
            String str2 = true != z ? "audio/amr" : "audio/amr-wb";
            String str3 = true != z ? "audio/3gpp" : "audio/amr-wb";
            int i = true != z ? 8000 : 16000;
            int i2 = z ? zzb[8] : zza[7];
            zzafb zzafbVar = this.zzo;
            zzx zzxVar = new zzx();
            zzxVar.zzG(str2);
            zzxVar.zzah(str3);
            zzxVar.zzX(i2);
            zzxVar.zzD(1);
            zzxVar.zzai(i);
            zzafbVar.zzm(zzxVar.zzan());
        }
        int iZza = zza(zzadwVar);
        if (this.zzq == null) {
            zzaet zzaetVar = new zzaet(-9223372036854775807L, 0L);
            this.zzq = zzaetVar;
            this.zzn.zzP(zzaetVar);
        }
        return iZza == -1 ? -1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ zzadv zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ List zzd() {
        return zzfyq.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zze(zzady zzadyVar) {
        this.zzn = zzadyVar;
        zzafb zzafbVarZzw = zzadyVar.zzw(0, 1);
        this.zzo = zzafbVarZzw;
        this.zzp = zzafbVarZzw;
        zzadyVar.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        this.zzh = 0L;
        this.zzi = 0;
        this.zzj = 0;
        this.zzr = j2;
        this.zzm = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) {
        return zzh(zzadwVar);
    }

    public zzafi(int i) {
        this.zze = new byte[1];
        this.zzk = -1;
        zzadr zzadrVar = new zzadr();
        this.zzf = zzadrVar;
        this.zzp = zzadrVar;
    }
}
