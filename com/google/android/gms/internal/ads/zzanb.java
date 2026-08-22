package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class zzanb implements zzamz {
    private static final double[] zza = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String zzb;
    private zzafb zzc;
    private final zzaor zzd;
    private final String zze;
    private final zzen zzf;
    private final zzanr zzg;
    private final boolean[] zzh = new boolean[4];
    private final zzana zzi = new zzana(128);
    private long zzj;
    private boolean zzk;
    private boolean zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private boolean zzq;
    private boolean zzr;

    public zzanb(zzaor zzaorVar, String str) {
        zzen zzenVar;
        this.zzd = zzaorVar;
        this.zze = str;
        if (zzaorVar != null) {
            this.zzg = new zzanr(178, 128);
            zzenVar = new zzen();
        } else {
            zzenVar = null;
            this.zzg = null;
        }
        this.zzf = zzenVar;
        this.zzn = -9223372036854775807L;
        this.zzp = -9223372036854775807L;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0131  */
    /* JADX WARN: Code duplicated, block: B:55:0x0174  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zza(zzen zzenVar) {
        boolean z;
        boolean z2;
        int i;
        float f;
        int i2;
        int i3;
        char c = 4;
        zzdd.zzb(this.zzc);
        int iZzc = zzenVar.zzc();
        int iZzd = zzenVar.zzd();
        byte[] bArrZzN = zzenVar.zzN();
        this.zzj += (long) zzenVar.zza();
        this.zzc.zzr(zzenVar, zzenVar.zza());
        while (true) {
            int iZza = zzfv.zza(bArrZzN, iZzc, iZzd, this.zzh);
            if (iZza == iZzd) {
                break;
            }
            int i4 = iZza + 3;
            int i5 = zzenVar.zzN()[i4] & 255;
            int i6 = iZza - iZzc;
            if (!this.zzl) {
                if (i6 > 0) {
                    this.zzi.zza(bArrZzN, iZzc, iZza);
                }
                int i7 = i6 < 0 ? -i6 : 0;
                zzana zzanaVar = this.zzi;
                if (zzanaVar.zzc(i5, i7)) {
                    String str = this.zzb;
                    str.getClass();
                    String str2 = this.zze;
                    byte[] bArrCopyOf = Arrays.copyOf(zzanaVar.zzc, zzanaVar.zza);
                    int i8 = bArrCopyOf[c] & 255;
                    byte b = bArrCopyOf[5];
                    int i9 = bArrCopyOf[6] & 255;
                    int i10 = ((b & 255) >> 4) | (i8 << 4);
                    int i11 = (bArrCopyOf[7] & 240) >> 4;
                    int i12 = ((b & 15) << 8) | i9;
                    if (i11 != 2) {
                        if (i11 == 3) {
                            i2 = i12 * 16;
                            i3 = i10 * 9;
                        } else if (i11 != 4) {
                            f = 1.0f;
                        } else {
                            i2 = i12 * 121;
                            i3 = i10 * 100;
                        }
                        f = i2 / i3;
                    } else {
                        f = (i12 * 4) / (i10 * 3);
                    }
                    zzx zzxVar = new zzx();
                    zzxVar.zzS(str);
                    zzxVar.zzG(str2);
                    zzxVar.zzah("video/mpeg2");
                    zzxVar.zzam(i10);
                    zzxVar.zzQ(i12);
                    zzxVar.zzad(f);
                    zzxVar.zzT(Collections.singletonList(bArrCopyOf));
                    zzz zzzVarZzan = zzxVar.zzan();
                    int i13 = (bArrCopyOf[7] & 15) - 1;
                    long j = 0;
                    if (i13 >= 0 && i13 < 8) {
                        double d = zza[i13];
                        byte b2 = bArrCopyOf[zzanaVar.zzb + 9];
                        int i14 = (b2 & 96) >> 5;
                        int i15 = b2 & 31;
                        if (i14 != i15) {
                            d *= (((double) i14) + 1.0d) / ((double) (i15 + 1));
                        }
                        j = (long) (1000000.0d / d);
                    }
                    Pair pairCreate = Pair.create(zzzVarZzan, Long.valueOf(j));
                    this.zzc.zzm((zzz) pairCreate.first);
                    this.zzm = ((Long) pairCreate.second).longValue();
                    this.zzl = true;
                }
            }
            zzanr zzanrVar = this.zzg;
            if (zzanrVar != null) {
                if (i6 > 0) {
                    zzanrVar.zza(bArrZzN, iZzc, iZza);
                    i = 0;
                } else {
                    i = -i6;
                }
                if (zzanrVar.zzd(i)) {
                    int iZzc2 = zzfv.zzc(zzanrVar.zza, zzanrVar.zzb);
                    zzen zzenVar2 = this.zzf;
                    String str3 = zzex.zza;
                    zzenVar2.zzJ(zzanrVar.zza, iZzc2);
                    this.zzd.zzb(this.zzp, zzenVar2);
                }
                if (i5 == 178) {
                    if (zzenVar.zzN()[iZza + 2] == 1) {
                        zzanrVar.zzc(178);
                    }
                    i5 = 178;
                }
            }
            if (i5 == 0 || i5 == 179) {
                int i16 = iZzd - iZza;
                if (this.zzr && this.zzl) {
                    long j2 = this.zzp;
                    if (j2 != -9223372036854775807L) {
                        this.zzc.zzt(j2, this.zzq ? 1 : 0, ((int) (this.zzj - this.zzo)) - i16, i16, null);
                    }
                }
                if (!this.zzk || this.zzr) {
                    this.zzo = this.zzj - ((long) i16);
                    long j3 = this.zzn;
                    if (j3 == -9223372036854775807L) {
                        long j4 = this.zzp;
                        j3 = j4 != -9223372036854775807L ? j4 + this.zzm : -9223372036854775807L;
                    }
                    this.zzp = j3;
                    z = false;
                    this.zzq = false;
                    this.zzn = -9223372036854775807L;
                    z2 = true;
                    this.zzk = true;
                } else {
                    z = false;
                    z2 = true;
                }
                this.zzr = i5 == 0 ? z2 : z;
            } else if (i5 == 184) {
                this.zzq = true;
            }
            iZzc = i4;
            iZzd = iZzd;
            c = 4;
        }
        if (!this.zzl) {
            this.zzi.zza(bArrZzN, iZzc, iZzd);
        }
        zzanr zzanrVar2 = this.zzg;
        if (zzanrVar2 != null) {
            zzanrVar2.zza(bArrZzN, iZzc, iZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzb(zzady zzadyVar, zzaon zzaonVar) {
        zzaonVar.zzc();
        this.zzb = zzaonVar.zzb();
        this.zzc = zzadyVar.zzw(zzaonVar.zza(), 2);
        zzaor zzaorVar = this.zzd;
        if (zzaorVar != null) {
            zzaorVar.zzc(zzadyVar, zzaonVar);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzc(boolean z) {
        zzdd.zzb(this.zzc);
        if (z) {
            boolean z2 = this.zzq;
            long j = this.zzj - this.zzo;
            this.zzc.zzt(this.zzp, z2 ? 1 : 0, (int) j, 0, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzd(long j, int i) {
        this.zzn = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zze() {
        zzfv.zzi(this.zzh);
        this.zzi.zzb();
        zzanr zzanrVar = this.zzg;
        if (zzanrVar != null) {
            zzanrVar.zzb();
        }
        this.zzj = 0L;
        this.zzk = false;
        this.zzn = -9223372036854775807L;
        this.zzp = -9223372036854775807L;
    }
}
