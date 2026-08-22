package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public final class zzant implements zzaoo {
    private final zzamz zza;
    private final zzem zzb = new zzem(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzeu zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzant(zzamz zzamzVar) {
        this.zza = zzamzVar;
    }

    private final void zze(int i) {
        this.zzc = i;
        this.zzd = 0;
    }

    private final boolean zzf(zzen zzenVar, byte[] bArr, int i) {
        int iMin = Math.min(zzenVar.zza(), i - this.zzd);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            zzenVar.zzM(iMin);
        } else {
            zzenVar.zzH(bArr, this.zzd, iMin);
        }
        int i2 = this.zzd + iMin;
        this.zzd = i2;
        return i2 == i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r9v11, types: [com.google.android.gms.internal.ads.zzem] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v5, types: [int] */
    /* JADX WARN: Type inference failed for: r9v6, types: [com.google.android.gms.internal.ads.zzamz] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzaoo
    public final void zza(zzen zzenVar, int i) {
        int i2;
        int i3;
        ?? r2;
        int i4;
        zzen zzenVar2;
        int i5;
        int i6;
        ?? r9;
        long jZzb;
        zzen zzenVar3 = zzenVar;
        zzdd.zzb(this.zze);
        int i7 = -1;
        int i8 = 2;
        ?? r6 = 0;
        int i9 = 1;
        if ((i & 1) != 0) {
            int i10 = this.zzc;
            if (i10 != 0 && i10 != 1) {
                if (i10 != 2) {
                    int i11 = this.zzj;
                    if (i11 != -1) {
                        zzea.zzf("PesReader", "Unexpected start indicator: expected " + i11 + " more bytes");
                    }
                    this.zza.zzc(zzenVar.zzd() == 0);
                } else {
                    zzea.zzf("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zze(1);
        }
        int i12 = i;
        while (zzenVar.zza() > 0) {
            int i13 = this.zzc;
            if (i13 == 0) {
                i2 = i12;
                i3 = i8;
                r2 = r6;
                i4 = i9;
                zzenVar2 = zzenVar3;
                zzenVar2.zzM(zzenVar.zza());
            } else if (i13 == i9) {
                i2 = i12;
                zzem zzemVar = this.zzb;
                zzenVar2 = zzenVar;
                if (zzf(zzenVar2, zzemVar.zza, 9)) {
                    r2 = 0;
                    zzemVar.zzl(0);
                    int iZzd = zzemVar.zzd(24);
                    i4 = 1;
                    if (iZzd != 1) {
                        CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(iZzd, "Unexpected start code prefix: ", "PesReader");
                        this.zzj = -1;
                        i7 = -1;
                        i5 = 0;
                        i3 = 2;
                    } else {
                        zzemVar.zzn(8);
                        int iZzd2 = zzemVar.zzd(16);
                        zzemVar.zzn(5);
                        this.zzk = zzemVar.zzp();
                        i3 = 2;
                        zzemVar.zzn(2);
                        this.zzf = zzemVar.zzp();
                        this.zzg = zzemVar.zzp();
                        zzemVar.zzn(6);
                        int iZzd3 = zzemVar.zzd(8);
                        this.zzi = iZzd3;
                        i7 = -1;
                        if (iZzd2 == 0) {
                            this.zzj = -1;
                        } else {
                            int i14 = (iZzd2 - 3) - iZzd3;
                            this.zzj = i14;
                            if (i14 < 0) {
                                CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(i14, "Found negative packet payload size: ", "PesReader");
                                this.zzj = -1;
                            }
                        }
                        i5 = 2;
                    }
                    zze(i5);
                } else {
                    r2 = 0;
                    i7 = -1;
                    i4 = 1;
                    i3 = 2;
                }
            } else if (i13 != i8) {
                int iZza = zzenVar.zza();
                int i15 = this.zzj;
                if (i15 == i7) {
                    r9 = r6;
                } else {
                    i6 = iZza - i15;
                }
                if (r9 > 0) {
                    r9 = i6;
                    iZza -= r9;
                    zzenVar3.zzK(zzenVar.zzc() + iZza);
                }
                r9 = i6;
                ?? r10 = this.zza;
                r10.zza(zzenVar3);
                int i16 = this.zzj;
                if (i16 != i7) {
                    int i17 = i16 - iZza;
                    this.zzj = i17;
                    if (i17 == 0) {
                        r10.zzc(r6);
                        zze(i9);
                    }
                }
                i2 = i12;
                i3 = i8;
                r2 = r6;
                i4 = i9;
                zzenVar2 = zzenVar3;
            } else {
                int iMin = Math.min(10, this.zzi);
                ?? r11 = this.zzb;
                if (zzf(zzenVar3, r11.zza, iMin) && zzf(zzenVar3, null, this.zzi)) {
                    r11.zzl(r6);
                    if (this.zzf) {
                        r11.zzn(4);
                        long jZzd = r11.zzd(3);
                        r11.zzn(i9);
                        int iZzd4 = r11.zzd(15) << 15;
                        r11.zzn(i9);
                        long jZzd2 = r11.zzd(15);
                        r11.zzn(i9);
                        if (!this.zzh && this.zzg) {
                            r11.zzn(4);
                            long jZzd3 = ((long) r11.zzd(3)) << 30;
                            r11.zzn(i9);
                            int iZzd5 = r11.zzd(15) << 15;
                            r11.zzn(i9);
                            long jZzd4 = r11.zzd(15);
                            r11.zzn(i9);
                            this.zze.zzb(jZzd4 | ((long) iZzd5) | jZzd3);
                            this.zzh = true;
                        }
                        jZzb = this.zze.zzb((jZzd << 30) | ((long) iZzd4) | jZzd2);
                    } else {
                        i12 = i12;
                        jZzb = -9223372036854775807L;
                    }
                    int i18 = i12 | (true != this.zzk ? 0 : 4);
                    this.zza.zzd(jZzb, i18);
                    zze(3);
                    zzenVar3 = zzenVar;
                    i12 = i18;
                    i7 = -1;
                    i8 = 2;
                    r6 = 0;
                    i9 = 1;
                } else {
                    i2 = i12;
                    i3 = i8;
                    r2 = r6;
                    i4 = i9;
                    zzenVar2 = zzenVar;
                }
            }
            zzenVar3 = zzenVar2;
            i9 = i4;
            i8 = i3;
            r6 = r2;
            i12 = i2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaoo
    public final void zzb(zzeu zzeuVar, zzady zzadyVar, zzaon zzaonVar) {
        this.zze = zzeuVar;
        this.zza.zzb(zzadyVar, zzaonVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaoo
    public final void zzc() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zze();
    }

    public final boolean zzd(boolean z) {
        return this.zzc == 3 && this.zzj == -1;
    }
}
