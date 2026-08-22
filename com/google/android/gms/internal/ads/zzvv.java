package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* JADX INFO: loaded from: classes.dex */
final class zzvv implements zzvf, zzve {
    private final zzvf[] zza;
    private final boolean[] zzb;
    private zzve zzf;
    private zzxk zzg;
    private final ArrayList zzd = new ArrayList();
    private final HashMap zze = new HashMap();
    private zzxb zzi = new zzur(zzfyq.zzn(), zzfyq.zzn());
    private final IdentityHashMap zzc = new IdentityHashMap();
    private zzvf[] zzh = new zzvf[0];

    public zzvv(zzus zzusVar, long[] jArr, zzvf... zzvfVarArr) {
        this.zza = zzvfVarArr;
        this.zzb = new boolean[zzvfVarArr.length];
        for (int i = 0; i < zzvfVarArr.length; i++) {
            long j = jArr[i];
            if (j != 0) {
                this.zzb[i] = true;
                this.zza[i] = new zzxh(zzvfVarArr[i], j);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zza(long j, zzmi zzmiVar) {
        zzvf[] zzvfVarArr = this.zzh;
        return (zzvfVarArr.length > 0 ? zzvfVarArr[0] : this.zza[0]).zza(j, zzmiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final long zzb() {
        return this.zzi.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final long zzc() {
        return this.zzi.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zzd() {
        long j = -9223372036854775807L;
        for (zzvf zzvfVar : this.zzh) {
            long jZzd = zzvfVar.zzd();
            if (jZzd == -9223372036854775807L) {
                if (j != -9223372036854775807L && zzvfVar.zze(j) != j) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j == -9223372036854775807L) {
                for (zzvf zzvfVar2 : this.zzh) {
                    if (zzvfVar2 == zzvfVar) {
                        break;
                    }
                    if (zzvfVar2.zze(jZzd) != jZzd) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j = jZzd;
            } else if (jZzd != j) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zze(long j) {
        long jZze = this.zzh[0].zze(j);
        int i = 1;
        while (true) {
            zzvf[] zzvfVarArr = this.zzh;
            if (i >= zzvfVarArr.length) {
                return jZze;
            }
            if (zzvfVarArr[i].zze(jZze) != jZze) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zzf(zzyw[] zzywVarArr, boolean[] zArr, zzwz[] zzwzVarArr, boolean[] zArr2, long j) {
        int length;
        int length2 = zzywVarArr.length;
        int[] iArr = new int[length2];
        int[] iArr2 = new int[length2];
        int i = 0;
        int i2 = 0;
        while (true) {
            length = zzywVarArr.length;
            if (i2 >= length) {
                break;
            }
            zzwz zzwzVar = zzwzVarArr[i2];
            Integer num = zzwzVar == null ? null : (Integer) this.zzc.get(zzwzVar);
            iArr[i2] = num == null ? -1 : num.intValue();
            zzyw zzywVar = zzywVarArr[i2];
            if (zzywVar != null) {
                String str = zzywVar.zzc().zzb;
                iArr2[i2] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i2] = -1;
            }
            i2++;
        }
        IdentityHashMap identityHashMap = this.zzc;
        identityHashMap.clear();
        zzvf[] zzvfVarArr = this.zza;
        zzwz[] zzwzVarArr2 = new zzwz[length];
        zzwz[] zzwzVarArr3 = new zzwz[length];
        zzyw[] zzywVarArr2 = new zzyw[length];
        ArrayList arrayList = new ArrayList(zzvfVarArr.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < zzvfVarArr.length) {
            int i4 = i;
            while (i4 < zzywVarArr.length) {
                zzwzVarArr3[i4] = iArr[i4] == i3 ? zzwzVarArr[i4] : null;
                if (iArr2[i4] == i3) {
                    zzyw zzywVar2 = zzywVarArr[i4];
                    zzywVar2.getClass();
                    zzbm zzbmVar = (zzbm) this.zze.get(zzywVar2.zzc());
                    zzbmVar.getClass();
                    zzywVarArr2[i4] = new zzvu(zzywVar2, zzbmVar);
                } else {
                    zzywVarArr2[i4] = null;
                }
                i4++;
                arrayList = arrayList;
            }
            ArrayList arrayList2 = arrayList;
            int i5 = i3;
            zzyw[] zzywVarArr3 = zzywVarArr2;
            zzwz[] zzwzVarArr4 = zzwzVarArr3;
            long jZzf = zzvfVarArr[i3].zzf(zzywVarArr2, zArr, zzwzVarArr3, zArr2, j2);
            if (i5 == 0) {
                j2 = jZzf;
            } else if (jZzf != j2) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i6 = 0; i6 < zzywVarArr.length; i6++) {
                if (iArr2[i6] == i5) {
                    zzwz zzwzVar2 = zzwzVarArr4[i6];
                    zzwzVar2.getClass();
                    zzwzVarArr2[i6] = zzwzVar2;
                    identityHashMap.put(zzwzVar2, Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    zzdd.zzf(zzwzVarArr4[i6] == null);
                }
            }
            if (z) {
                arrayList2.add(zzvfVarArr[i5]);
            }
            i3 = i5 + 1;
            arrayList = arrayList2;
            zzywVarArr2 = zzywVarArr3;
            zzwzVarArr3 = zzwzVarArr4;
            i = 0;
        }
        int i7 = i;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzwzVarArr2, i7, zzwzVarArr, i7, length);
        this.zzh = (zzvf[]) arrayList3.toArray(new zzvf[i7]);
        this.zzi = new zzur(arrayList3, zzfzg.zzc(arrayList3, new zzfve() { // from class: com.google.android.gms.internal.ads.zzvt
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                return ((zzvf) obj).zzg().zzc();
            }
        }));
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final zzxk zzg() {
        zzxk zzxkVar = this.zzg;
        zzxkVar.getClass();
        return zzxkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzh(long j, boolean z) {
        for (zzvf zzvfVar : this.zzh) {
            zzvfVar.zzh(j, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzi() {
        int i = 0;
        while (true) {
            zzvf[] zzvfVarArr = this.zza;
            if (i >= zzvfVarArr.length) {
                return;
            }
            zzvfVarArr[i].zzi();
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final /* bridge */ /* synthetic */ void zzj(zzxb zzxbVar) {
        zzve zzveVar = this.zzf;
        zzveVar.getClass();
        zzveVar.zzj(this);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzk(zzve zzveVar, long j) {
        this.zzf = zzveVar;
        ArrayList arrayList = this.zzd;
        zzvf[] zzvfVarArr = this.zza;
        Collections.addAll(arrayList, zzvfVarArr);
        for (zzvf zzvfVar : zzvfVarArr) {
            zzvfVar.zzk(this, j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final void zzl(zzvf zzvfVar) {
        ArrayList arrayList = this.zzd;
        arrayList.remove(zzvfVar);
        if (arrayList.isEmpty()) {
            zzvf[] zzvfVarArr = this.zza;
            int i = 0;
            for (zzvf zzvfVar2 : zzvfVarArr) {
                i += zzvfVar2.zzg().zzb;
            }
            zzbm[] zzbmVarArr = new zzbm[i];
            int i2 = 0;
            for (int i3 = 0; i3 < zzvfVarArr.length; i3++) {
                zzxk zzxkVarZzg = zzvfVarArr[i3].zzg();
                int i4 = zzxkVarZzg.zzb;
                int i5 = 0;
                while (i5 < i4) {
                    zzbm zzbmVarZzb = zzxkVarZzg.zzb(i5);
                    int i6 = zzbmVarZzb.zza;
                    zzz[] zzzVarArr = new zzz[i6];
                    for (int i7 = 0; i7 < i6; i7++) {
                        zzz zzzVarZzb = zzbmVarZzb.zzb(i7);
                        zzx zzxVarZzb = zzzVarZzb.zzb();
                        String str = zzzVarZzb.zza;
                        if (str == null) {
                            str = "";
                        }
                        zzxVarZzb.zzS(i3 + ":" + str);
                        zzzVarArr[i7] = zzxVarZzb.zzan();
                    }
                    zzbm zzbmVar = new zzbm(i3 + ":" + zzbmVarZzb.zzb, zzzVarArr);
                    this.zze.put(zzbmVar, zzbmVarZzb);
                    zzbmVarArr[i2] = zzbmVar;
                    i5++;
                    i2++;
                }
            }
            this.zzg = new zzxk(zzbmVarArr);
            zzve zzveVar = this.zzf;
            zzveVar.getClass();
            zzveVar.zzl(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final void zzm(long j) {
        this.zzi.zzm(j);
    }

    public final zzvf zzn(int i) {
        return this.zzb[i] ? ((zzxh) this.zza[i]).zzn() : this.zza[i];
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final boolean zzo(zzla zzlaVar) {
        ArrayList arrayList = this.zzd;
        if (arrayList.isEmpty()) {
            return this.zzi.zzo(zzlaVar);
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((zzvf) arrayList.get(i)).zzo(zzlaVar);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final boolean zzp() {
        return this.zzi.zzp();
    }
}
