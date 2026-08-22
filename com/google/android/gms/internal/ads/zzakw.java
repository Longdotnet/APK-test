package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzakw implements zzafb {
    private final zzafb zza;
    private final zzakr zzb;
    private zzakt zzg;
    private zzz zzh;
    private boolean zzi;
    private int zzd = 0;
    private int zze = 0;
    private byte[] zzf = zzex.zzb;
    private final zzen zzc = new zzen();

    public zzakw(zzafb zzafbVar, zzakr zzakrVar) {
        this.zza = zzafbVar;
        this.zzb = zzakrVar;
    }

    public static /* synthetic */ void zza(zzakw zzakwVar, long j, int i, zzakl zzaklVar) {
        zzdd.zzb(zzakwVar.zzh);
        zzfyq zzfyqVar = zzaklVar.zza;
        long j2 = zzaklVar.zzc;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(zzfyqVar.size());
        Iterator<E> it = zzfyqVar.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzcu) it.next()).zza());
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayList);
        bundle.putLong("d", j2);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        zzen zzenVar = zzakwVar.zzc;
        int length = bArrMarshall.length;
        zzenVar.zzJ(bArrMarshall, length);
        zzafb zzafbVar = zzakwVar.zza;
        zzafbVar.zzr(zzenVar, length);
        long j3 = zzaklVar.zzb;
        if (j3 == -9223372036854775807L) {
            zzdd.zzf(zzakwVar.zzh.zzt == Long.MAX_VALUE);
        } else {
            long j4 = zzakwVar.zzh.zzt;
            j = j4 == Long.MAX_VALUE ? j + j3 : j3 + j4;
        }
        zzafbVar.zzt(j, i | 1, length, 0, null);
    }

    private final void zzc(int i) {
        int length = this.zzf.length;
        int i2 = this.zze;
        if (length - i2 >= i) {
            return;
        }
        int i3 = i2 - this.zzd;
        int iMax = Math.max(i3 + i3, i + i3);
        byte[] bArr = this.zzf;
        byte[] bArr2 = iMax <= bArr.length ? bArr : new byte[iMax];
        System.arraycopy(bArr, this.zzd, bArr2, 0, i3);
        this.zzd = 0;
        this.zze = i3;
        this.zzf = bArr2;
    }

    public final void zzb(boolean z) {
        this.zzi = true;
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final /* synthetic */ int zzf(zzl zzlVar, int i, boolean z) {
        return zzaez.zza(this, zzlVar, i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final int zzg(zzl zzlVar, int i, boolean z, int i2) throws EOFException {
        if (this.zzg == null) {
            return this.zza.zzg(zzlVar, i, z, 0);
        }
        zzc(i);
        int iZza = zzlVar.zza(this.zzf, this.zze, i);
        if (iZza != -1) {
            this.zze += iZza;
            return iZza;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final /* synthetic */ void zzl(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final void zzm(zzz zzzVar) {
        String str = zzzVar.zzo;
        str.getClass();
        zzdd.zzd(zzay.zzb(str) == 3);
        if (!zzzVar.equals(this.zzh)) {
            this.zzh = zzzVar;
            zzakr zzakrVar = this.zzb;
            this.zzg = zzakrVar.zzc(zzzVar) ? zzakrVar.zzb(zzzVar) : null;
        }
        if (this.zzg == null) {
            this.zza.zzm(zzzVar);
            return;
        }
        zzafb zzafbVar = this.zza;
        zzx zzxVarZzb = zzzVar.zzb();
        zzxVarZzb.zzah("application/x-media3-cues");
        zzxVarZzb.zzE(str);
        zzxVarZzb.zzal(Long.MAX_VALUE);
        zzxVarZzb.zzI(this.zzb.zza(zzzVar));
        zzafbVar.zzm(zzxVarZzb.zzan());
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final /* synthetic */ void zzr(zzen zzenVar, int i) {
        zzaez.zzb(this, zzenVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final void zzs(zzen zzenVar, int i, int i2) {
        if (this.zzg == null) {
            this.zza.zzs(zzenVar, i, i2);
            return;
        }
        zzc(i);
        zzenVar.zzH(this.zzf, this.zze, i);
        this.zze += i;
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final void zzt(final long j, final int i, int i2, int i3, zzafa zzafaVar) {
        if (this.zzg == null) {
            this.zza.zzt(j, i, i2, i3, zzafaVar);
            return;
        }
        zzdd.zze(zzafaVar == null, "DRM on subtitles is not supported");
        int i4 = (this.zze - i3) - i2;
        try {
            this.zzg.zza(this.zzf, i4, i2, zzaks.zza(), new zzdn() { // from class: com.google.android.gms.internal.ads.zzakv
                @Override // com.google.android.gms.internal.ads.zzdn
                public final void zza(Object obj) {
                    zzakw.zza(this.zza, j, i, (zzakl) obj);
                }
            });
        } catch (RuntimeException e) {
            if (!this.zzi) {
                throw e;
            }
            zzea.zzg("SubtitleTranscodingTO", "Parsing subtitles failed, ignoring sample.", e);
        }
        int i5 = i4 + i2;
        this.zzd = i5;
        if (i5 == this.zze) {
            this.zzd = 0;
            this.zze = 0;
        }
    }
}
