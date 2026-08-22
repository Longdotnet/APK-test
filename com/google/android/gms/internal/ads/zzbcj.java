package com.google.android.gms.internal.ads;

import androidx.core.text.jp.CyjpdoedCdLTIO;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import androidx.lifecycle.hSi.sgtsHsWT;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.firebase.inject.PVS.jIKWv;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbcj {

    /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$1 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] zza;

        static {
            int[] iArr = new int[zzgzg.values().length];
            zza = iArr;
            try {
                iArr[zzgzg.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                zza[zzgzg.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                zza[zzgzg.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                zza[zzgzg.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                zza[zzgzg.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                zza[zzgzg.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                zza[zzgzg.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public final class zza extends zzgzh<zza, zzb> implements zzf {
        public static final int zza = 7;
        public static final int zzb = 8;
        public static final int zzc = 9;
        public static final int zzd = 10;
        public static final int zze = 11;
        public static final int zzf = 12;
        public static final int zzg = 13;
        public static final int zzh = 14;
        public static final int zzi = 15;
        public static final int zzj = 16;
        public static final int zzk = 17;
        private static final zza zzl;
        private static volatile zzhba<zza> zzm;
        private zzx zzA;
        private zzz zzB;
        private int zzn;
        private int zzo;
        private zzg zzu;
        private zzi zzv;
        private zzk zzx;
        private zzah zzy;
        private zzac zzz;
        private int zzp = 1000;
        private zzgzt<zzd> zzw = zzgzh.zzbK();
        private zzgzt<zzat> zzC = zzgzh.zzbK();

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zza$zza */
        /* JADX INFO: loaded from: classes.dex */
        public enum EnumC0001zza implements zzgzl {
            AD_INITIATER_UNSPECIFIED(0),
            BANNER(1),
            DFP_BANNER(2),
            INTERSTITIAL(3),
            DFP_INTERSTITIAL(4),
            NATIVE_EXPRESS(5),
            AD_LOADER(6),
            REWARD_BASED_VIDEO_AD(7),
            BANNER_SEARCH_ADS(8),
            GOOGLE_MOBILE_ADS_SDK_ADAPTER(9),
            APP_OPEN(10),
            REWARDED_INTERSTITIAL(11);

            public static final int zzm = 0;
            public static final int zzn = 1;
            public static final int zzo = 2;
            public static final int zzp = 3;
            public static final int zzq = 4;
            public static final int zzr = 5;
            public static final int zzs = 6;
            public static final int zzt = 7;
            public static final int zzu = 8;
            public static final int zzv = 9;
            public static final int zzw = 10;
            public static final int zzx = 11;
            private static final zzgzm<EnumC0001zza> zzy = new zzgzm<EnumC0001zza>() { // from class: com.google.android.gms.internal.ads.zzbcj.zza.zza.1
                /* JADX INFO: renamed from: zza */
                public EnumC0001zza zzb(int i) {
                    return EnumC0001zza.zzb(i);
                }
            };
            private final int zzA;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zza$zza$1 */
            public class AnonymousClass1 implements zzgzm<EnumC0001zza> {
                /* JADX INFO: renamed from: zza */
                public EnumC0001zza zzb(int i) {
                    return EnumC0001zza.zzb(i);
                }
            }

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zza$zza$zza */
            final class C0002zza implements zzgzn {
                static final zzgzn zza = new C0002zza();

                private C0002zza() {
                }

                @Override // com.google.android.gms.internal.ads.zzgzn
                public boolean zza(int i) {
                    return EnumC0001zza.zzb(i) != null;
                }
            }

            EnumC0001zza(int i) {
                this.zzA = i;
            }

            public static EnumC0001zza zzb(int i) {
                switch (i) {
                    case 0:
                        return AD_INITIATER_UNSPECIFIED;
                    case 1:
                        return BANNER;
                    case 2:
                        return DFP_BANNER;
                    case 3:
                        return INTERSTITIAL;
                    case 4:
                        return DFP_INTERSTITIAL;
                    case 5:
                        return NATIVE_EXPRESS;
                    case 6:
                        return AD_LOADER;
                    case 7:
                        return REWARD_BASED_VIDEO_AD;
                    case 8:
                        return BANNER_SEARCH_ADS;
                    case 9:
                        return GOOGLE_MOBILE_ADS_SDK_ADAPTER;
                    case 10:
                        return APP_OPEN;
                    case 11:
                        return REWARDED_INTERSTITIAL;
                    default:
                        return null;
                }
            }

            public static zzgzm<EnumC0001zza> zzd() {
                return zzy;
            }

            public static zzgzn zze() {
                return C0002zza.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.zzA);
            }

            @Override // com.google.android.gms.internal.ads.zzgzl
            public final int zza() {
                return this.zzA;
            }
        }

        /* JADX INFO: loaded from: classes.dex */
        public final class zzb extends zzgzb<zza, zzb> implements zzf {
            public /* synthetic */ zzb() {
                this();
            }

            public zzb zzA(zzac zzacVar) {
                zzbu();
                ((zza) this.zza).zzcu(zzacVar);
                return this;
            }

            public zzb zzB(zzg zzgVar) {
                zzbu();
                ((zza) this.zza).zzcv(zzgVar);
                return this;
            }

            public zzb zzC(zzi zziVar) {
                zzbu();
                ((zza) this.zza).zzcw(zziVar);
                return this;
            }

            public zzb zzD(zzah zzahVar) {
                zzbu();
                ((zza) this.zza).zzcx(zzahVar);
                return this;
            }

            public zzb zzE(zzk zzkVar) {
                zzbu();
                ((zza) this.zza).zzcy(zzkVar);
                return this;
            }

            public zzb zzF(int i) {
                zzbu();
                ((zza) this.zza).zzcz(i);
                return this;
            }

            public zzb zzG(int i) {
                zzbu();
                ((zza) this.zza).zzcA(i);
                return this;
            }

            public zzb zzH(EnumC0001zza enumC0001zza) {
                zzbu();
                ((zza) this.zza).zzcB(enumC0001zza);
                return this;
            }

            public zzb zzI(zzx.zza zzaVar) {
                zzbu();
                ((zza) this.zza).zzcC(zzaVar.zzbr());
                return this;
            }

            public zzb zzJ(zzx zzxVar) {
                zzbu();
                ((zza) this.zza).zzcC(zzxVar);
                return this;
            }

            public zzb zzK(zzq zzqVar) {
                zzbu();
                ((zza) this.zza).zzcD(zzqVar);
                return this;
            }

            public zzb zzL(zzz.zza zzaVar) {
                zzbu();
                ((zza) this.zza).zzcE(zzaVar.zzbr());
                return this;
            }

            public zzb zzM(zzz zzzVar) {
                zzbu();
                ((zza) this.zza).zzcE(zzzVar);
                return this;
            }

            public zzb zzN(zzac.zza zzaVar) {
                zzbu();
                ((zza) this.zza).zzcF(zzaVar.zzbr());
                return this;
            }

            public zzb zzO(zzac zzacVar) {
                zzbu();
                ((zza) this.zza).zzcF(zzacVar);
                return this;
            }

            public zzb zzP(int i, zzd.zzb zzbVar) {
                zzbu();
                ((zza) this.zza).zzcG(i, zzbVar.zzbr());
                return this;
            }

            public zzb zzQ(int i, zzd zzdVar) {
                zzbu();
                ((zza) this.zza).zzcG(i, zzdVar);
                return this;
            }

            public zzb zzR(zzg.zza zzaVar) {
                zzbu();
                ((zza) this.zza).zzcH(zzaVar.zzbr());
                return this;
            }

            public zzb zzS(zzg zzgVar) {
                zzbu();
                ((zza) this.zza).zzcH(zzgVar);
                return this;
            }

            public zzb zzT(zzi.zza zzaVar) {
                zzbu();
                ((zza) this.zza).zzcI(zzaVar.zzbr());
                return this;
            }

            public zzb zzU(zzi zziVar) {
                zzbu();
                ((zza) this.zza).zzcI(zziVar);
                return this;
            }

            public zzb zzV(zzah.zza zzaVar) {
                zzbu();
                ((zza) this.zza).zzcJ(zzaVar.zzbr());
                return this;
            }

            public zzb zzW(zzah zzahVar) {
                zzbu();
                ((zza) this.zza).zzcJ(zzahVar);
                return this;
            }

            public zzb zzX(zzk.zza zzaVar) {
                zzbu();
                ((zza) this.zza).zzcK(zzaVar.zzbr());
                return this;
            }

            public zzb zzY(zzk zzkVar) {
                zzbu();
                ((zza) this.zza).zzcK(zzkVar);
                return this;
            }

            public zzb zzZ(int i, zzat.zza zzaVar) {
                zzbu();
                ((zza) this.zza).zzcL(i, zzaVar.zzbr());
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public int zza() {
                return ((zza) this.zza).zza();
            }

            public zzb zzaa(int i, zzat zzatVar) {
                zzbu();
                ((zza) this.zza).zzcL(i, zzatVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public zzd zzab(int i) {
                return ((zza) this.zza).zzab(i);
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public zzg zzac() {
                return ((zza) this.zza).zzac();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public zzi zzad() {
                return ((zza) this.zza).zzad();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public zzk zzae() {
                return ((zza) this.zza).zzae();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public zzq zzaf() {
                return ((zza) this.zza).zzaf();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public zzx zzag() {
                return ((zza) this.zza).zzag();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public zzz zzah() {
                return ((zza) this.zza).zzah();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public zzac zzai() {
                return ((zza) this.zza).zzai();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public zzah zzaj() {
                return ((zza) this.zza).zzaj();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public zzat zzak(int i) {
                return ((zza) this.zza).zzak(i);
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public List<zzd> zzal() {
                return Collections.unmodifiableList(((zza) this.zza).zzal());
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public List<zzat> zzam() {
                return Collections.unmodifiableList(((zza) this.zza).zzam());
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public boolean zzan() {
                return ((zza) this.zza).zzan();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public boolean zzao() {
                return ((zza) this.zza).zzao();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public boolean zzap() {
                return ((zza) this.zza).zzap();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public boolean zzaq() {
                return ((zza) this.zza).zzaq();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public boolean zzar() {
                return ((zza) this.zza).zzar();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public boolean zzas() {
                return ((zza) this.zza).zzas();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public boolean zzat() {
                return ((zza) this.zza).zzat();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public boolean zzau() {
                return ((zza) this.zza).zzau();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public boolean zzav() {
                return ((zza) this.zza).zzav();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public int zzb() {
                return ((zza) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzf
            public EnumC0001zza zzc() {
                return ((zza) this.zza).zzc();
            }

            public zzb zzd(Iterable<? extends zzd> iterable) {
                zzbu();
                ((zza) this.zza).zzaF(iterable);
                return this;
            }

            public zzb zze(Iterable<? extends zzat> iterable) {
                zzbu();
                ((zza) this.zza).zzaG(iterable);
                return this;
            }

            public zzb zzf(zzd.zzb zzbVar) {
                zzbu();
                ((zza) this.zza).zzaH(zzbVar.zzbr());
                return this;
            }

            public zzb zzg(zzd zzdVar) {
                zzbu();
                ((zza) this.zza).zzaH(zzdVar);
                return this;
            }

            public zzb zzh(int i, zzd.zzb zzbVar) {
                zzbu();
                ((zza) this.zza).zzaI(i, zzbVar.zzbr());
                return this;
            }

            public zzb zzi(int i, zzd zzdVar) {
                zzbu();
                ((zza) this.zza).zzaI(i, zzdVar);
                return this;
            }

            public zzb zzj(zzat.zza zzaVar) {
                zzbu();
                ((zza) this.zza).zzaJ(zzaVar.zzbr());
                return this;
            }

            public zzb zzk(zzat zzatVar) {
                zzbu();
                ((zza) this.zza).zzaJ(zzatVar);
                return this;
            }

            public zzb zzl(int i, zzat.zza zzaVar) {
                zzbu();
                ((zza) this.zza).zzaK(i, zzaVar.zzbr());
                return this;
            }

            public zzb zzm(int i, zzat zzatVar) {
                zzbu();
                ((zza) this.zza).zzaK(i, zzatVar);
                return this;
            }

            public zzb zzn() {
                zzbu();
                ((zza) this.zza).zzcf();
                return this;
            }

            public zzb zzo() {
                zzbu();
                ((zza) this.zza).zzcg();
                return this;
            }

            public zzb zzp() {
                zzbu();
                ((zza) this.zza).zzch();
                return this;
            }

            public zzb zzq() {
                zzbu();
                ((zza) this.zza).zzci();
                return this;
            }

            public zzb zzr() {
                zzbu();
                ((zza) this.zza).zzcj();
                return this;
            }

            public zzb zzs() {
                zzbu();
                ((zza) this.zza).zzck();
                return this;
            }

            public zzb zzt() {
                zzbu();
                ((zza) this.zza).zzcl();
                return this;
            }

            public zzb zzu() {
                zzbu();
                ((zza) this.zza).zzcm();
                return this;
            }

            public zzb zzv() {
                zzbu();
                ((zza) this.zza).zzcn();
                return this;
            }

            public zzb zzw() {
                zzbu();
                ((zza) this.zza).zzco();
                return this;
            }

            public zzb zzx() {
                zzbu();
                ((zza) this.zza).zzcp();
                return this;
            }

            public zzb zzy(zzx zzxVar) {
                zzbu();
                ((zza) this.zza).zzcs(zzxVar);
                return this;
            }

            public zzb zzz(zzz zzzVar) {
                zzbu();
                ((zza) this.zza).zzct(zzzVar);
                return this;
            }

            private zzb() {
                super(zza.zzl);
            }
        }

        static {
            zza zzaVar = new zza();
            zzl = zzaVar;
            zzgzh.zzbZ(zza.class, zzaVar);
        }

        private zza() {
        }

        public void zzaF(Iterable<? extends zzd> iterable) {
            zzcq();
            zzgxi.zzaQ(iterable, this.zzw);
        }

        public void zzaG(Iterable<? extends zzat> iterable) {
            zzcr();
            zzgxi.zzaQ(iterable, this.zzC);
        }

        public void zzaH(zzd zzdVar) {
            zzdVar.getClass();
            zzcq();
            this.zzw.add(zzdVar);
        }

        public void zzaI(int i, zzd zzdVar) {
            zzdVar.getClass();
            zzcq();
            this.zzw.add(i, zzdVar);
        }

        public void zzaJ(zzat zzatVar) {
            zzatVar.getClass();
            zzcr();
            this.zzC.add(zzatVar);
        }

        public void zzaK(int i, zzat zzatVar) {
            zzatVar.getClass();
            zzcr();
            this.zzC.add(i, zzatVar);
        }

        public void zzcA(int i) {
            zzcr();
            this.zzC.remove(i);
        }

        public void zzcB(EnumC0001zza enumC0001zza) {
            this.zzo = enumC0001zza.zza();
            this.zzn |= 1;
        }

        public void zzcC(zzx zzxVar) {
            zzxVar.getClass();
            this.zzA = zzxVar;
            this.zzn |= 128;
        }

        public void zzcD(zzq zzqVar) {
            this.zzp = zzqVar.zza();
            this.zzn |= 2;
        }

        public void zzcE(zzz zzzVar) {
            zzzVar.getClass();
            this.zzB = zzzVar;
            this.zzn |= 256;
        }

        public void zzcF(zzac zzacVar) {
            zzacVar.getClass();
            this.zzz = zzacVar;
            this.zzn |= 64;
        }

        public void zzcG(int i, zzd zzdVar) {
            zzdVar.getClass();
            zzcq();
            this.zzw.set(i, zzdVar);
        }

        public void zzcH(zzg zzgVar) {
            zzgVar.getClass();
            this.zzu = zzgVar;
            this.zzn |= 4;
        }

        public void zzcI(zzi zziVar) {
            zziVar.getClass();
            this.zzv = zziVar;
            this.zzn |= 8;
        }

        public void zzcJ(zzah zzahVar) {
            zzahVar.getClass();
            this.zzy = zzahVar;
            this.zzn |= 32;
        }

        public void zzcK(zzk zzkVar) {
            zzkVar.getClass();
            this.zzx = zzkVar;
            this.zzn |= 16;
        }

        public void zzcL(int i, zzat zzatVar) {
            zzatVar.getClass();
            zzcr();
            this.zzC.set(i, zzatVar);
        }

        public void zzcf() {
            this.zzn &= -2;
            this.zzo = 0;
        }

        public void zzcg() {
            this.zzA = null;
            this.zzn &= -129;
        }

        public void zzch() {
            this.zzn &= -3;
            this.zzp = 1000;
        }

        public void zzci() {
            this.zzB = null;
            this.zzn &= -257;
        }

        public void zzcj() {
            this.zzz = null;
            this.zzn &= -65;
        }

        public void zzck() {
            this.zzw = zzgzh.zzbK();
        }

        public void zzcl() {
            this.zzu = null;
            this.zzn &= -5;
        }

        public void zzcm() {
            this.zzv = null;
            this.zzn &= -9;
        }

        public void zzcn() {
            this.zzy = null;
            this.zzn &= -33;
        }

        public void zzco() {
            this.zzx = null;
            this.zzn &= -17;
        }

        public void zzcp() {
            this.zzC = zzgzh.zzbK();
        }

        private void zzcq() {
            zzgzt<zzd> zzgztVar = this.zzw;
            if (zzgztVar.zzc()) {
                return;
            }
            this.zzw = zzgzh.zzbL(zzgztVar);
        }

        private void zzcr() {
            zzgzt<zzat> zzgztVar = this.zzC;
            if (zzgztVar.zzc()) {
                return;
            }
            this.zzC = zzgzh.zzbL(zzgztVar);
        }

        public void zzcs(zzx zzxVar) {
            zzxVar.getClass();
            zzx zzxVar2 = this.zzA;
            if (zzxVar2 != null && zzxVar2 != zzx.zzh()) {
                zzx.zza zzaVarZzf = zzx.zzf(zzxVar2);
                zzaVarZzf.zzbj(zzxVar);
                zzxVar = zzaVarZzf.zzbs();
            }
            this.zzA = zzxVar;
            this.zzn |= 128;
        }

        public void zzct(zzz zzzVar) {
            zzzVar.getClass();
            zzz zzzVar2 = this.zzB;
            if (zzzVar2 != null && zzzVar2 != zzz.zzh()) {
                zzz.zza zzaVarZzf = zzz.zzf(zzzVar2);
                zzaVarZzf.zzbj(zzzVar);
                zzzVar = zzaVarZzf.zzbs();
            }
            this.zzB = zzzVar;
            this.zzn |= 256;
        }

        public void zzcu(zzac zzacVar) {
            zzacVar.getClass();
            zzac zzacVar2 = this.zzz;
            if (zzacVar2 != null && zzacVar2 != zzac.zzf()) {
                zzac.zza zzaVarZzc = zzac.zzc(zzacVar2);
                zzaVarZzc.zzbj(zzacVar);
                zzacVar = zzaVarZzc.zzbs();
            }
            this.zzz = zzacVar;
            this.zzn |= 64;
        }

        public void zzcv(zzg zzgVar) {
            zzgVar.getClass();
            zzg zzgVar2 = this.zzu;
            if (zzgVar2 != null && zzgVar2 != zzg.zzh()) {
                zzg.zza zzaVarZzf = zzg.zzf(zzgVar2);
                zzaVarZzf.zzbj(zzgVar);
                zzgVar = zzaVarZzf.zzbs();
            }
            this.zzu = zzgVar;
            this.zzn |= 4;
        }

        public void zzcw(zzi zziVar) {
            zziVar.getClass();
            zzi zziVar2 = this.zzv;
            if (zziVar2 != null && zziVar2 != zzi.zzh()) {
                zzi.zza zzaVarZzf = zzi.zzf(zziVar2);
                zzaVarZzf.zzbj(zziVar);
                zziVar = zzaVarZzf.zzbs();
            }
            this.zzv = zziVar;
            this.zzn |= 8;
        }

        public void zzcx(zzah zzahVar) {
            zzahVar.getClass();
            zzah zzahVar2 = this.zzy;
            if (zzahVar2 != null && zzahVar2 != zzah.zzn()) {
                zzah.zza zzaVarZzl = zzah.zzl(zzahVar2);
                zzaVarZzl.zzbj(zzahVar);
                zzahVar = zzaVarZzl.zzbs();
            }
            this.zzy = zzahVar;
            this.zzn |= 32;
        }

        public void zzcy(zzk zzkVar) {
            zzkVar.getClass();
            zzk zzkVar2 = this.zzx;
            if (zzkVar2 != null && zzkVar2 != zzk.zzh()) {
                zzk.zza zzaVarZzf = zzk.zzf(zzkVar2);
                zzaVarZzf.zzbj(zzkVar);
                zzkVar = zzaVarZzf.zzbs();
            }
            this.zzx = zzkVar;
            this.zzn |= 16;
        }

        public void zzcz(int i) {
            zzcq();
            this.zzw.remove(i);
        }

        public static zzb zzd() {
            return (zzb) zzl.zzaZ();
        }

        public static zzb zzf(zza zzaVar) {
            return (zzb) zzl.zzba(zzaVar);
        }

        public static zza zzh() {
            return zzl;
        }

        public static zza zzi(InputStream inputStream) {
            return (zza) zzgzh.zzbk(zzl, inputStream);
        }

        public static zza zzj(InputStream inputStream, zzgyr zzgyrVar) {
            return (zza) zzgzh.zzbl(zzl, inputStream, zzgyrVar);
        }

        public static zza zzk(zzgxz zzgxzVar) {
            return (zza) zzgzh.zzbm(zzl, zzgxzVar);
        }

        public static zza zzl(zzgyf zzgyfVar) {
            return (zza) zzgzh.zzbn(zzl, zzgyfVar);
        }

        public static zza zzm(InputStream inputStream) {
            return (zza) zzgzh.zzbo(zzl, inputStream);
        }

        public static zza zzn(ByteBuffer byteBuffer) {
            return (zza) zzgzh.zzbp(zzl, byteBuffer);
        }

        public static zza zzo(byte[] bArr) {
            return (zza) zzgzh.zzbq(zzl, bArr);
        }

        public static zza zzp(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zza) zzgzh.zzbr(zzl, zzgxzVar, zzgyrVar);
        }

        public static zza zzq(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zza) zzgzh.zzbs(zzl, zzgyfVar, zzgyrVar);
        }

        public static zza zzr(InputStream inputStream, zzgyr zzgyrVar) {
            return (zza) zzgzh.zzbu(zzl, inputStream, zzgyrVar);
        }

        public static zza zzs(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zza) zzgzh.zzbv(zzl, byteBuffer, zzgyrVar);
        }

        public static zza zzt(byte[] bArr, zzgyr zzgyrVar) {
            return (zza) zzgzh.zzbx(zzl, bArr, zzgyrVar);
        }

        public static zzhba<zza> zzw() {
            return zzl.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public int zza() {
            return this.zzw.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public zzd zzab(int i) {
            return this.zzw.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public zzg zzac() {
            zzg zzgVar = this.zzu;
            return zzgVar == null ? zzg.zzh() : zzgVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public zzi zzad() {
            zzi zziVar = this.zzv;
            return zziVar == null ? zzi.zzh() : zziVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public zzk zzae() {
            zzk zzkVar = this.zzx;
            return zzkVar == null ? zzk.zzh() : zzkVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public zzq zzaf() {
            zzq zzqVarZzb = zzq.zzb(this.zzp);
            return zzqVarZzb == null ? zzq.ENUM_UNKNOWN : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public zzx zzag() {
            zzx zzxVar = this.zzA;
            return zzxVar == null ? zzx.zzh() : zzxVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public zzz zzah() {
            zzz zzzVar = this.zzB;
            return zzzVar == null ? zzz.zzh() : zzzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public zzac zzai() {
            zzac zzacVar = this.zzz;
            return zzacVar == null ? zzac.zzf() : zzacVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public zzah zzaj() {
            zzah zzahVar = this.zzy;
            return zzahVar == null ? zzah.zzn() : zzahVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public zzat zzak(int i) {
            return this.zzC.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public List<zzd> zzal() {
            return this.zzw;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public List<zzat> zzam() {
            return this.zzC;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public boolean zzan() {
            return (this.zzn & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public boolean zzao() {
            return (this.zzn & 128) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public boolean zzap() {
            return (this.zzn & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public boolean zzaq() {
            return (this.zzn & 256) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public boolean zzar() {
            return (this.zzn & 64) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public boolean zzas() {
            return (this.zzn & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public boolean zzat() {
            return (this.zzn & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public boolean zzau() {
            return (this.zzn & 32) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public boolean zzav() {
            return (this.zzn & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public int zzb() {
            return this.zzC.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzf
        public EnumC0001zza zzc() {
            EnumC0001zza enumC0001zzaZzb = EnumC0001zza.zzb(this.zzo);
            return enumC0001zzaZzb == null ? EnumC0001zza.AD_INITIATER_UNSPECIFIED : enumC0001zzaZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzl, "\u0004\u000b\u0000\u0001\u0007\u0011\u000b\u0000\u0002\u0000\u0007᠌\u0000\b᠌\u0001\tဉ\u0002\nဉ\u0003\u000b\u001b\fဉ\u0004\rဉ\u0005\u000eဉ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011\u001b", new Object[]{"zzn", "zzo", EnumC0001zza.zze(), "zzp", zzq.zze(), "zzu", "zzv", "zzw", zzd.class, "zzx", "zzy", CyjpdoedCdLTIO.AHadWBz, jIKWv.TMWbDnmNC, "zzB", "zzC", zzat.class});
            }
            if (iOrdinal == 3) {
                return new zza();
            }
            if (iOrdinal == 4) {
                return new zzb();
            }
            if (iOrdinal == 5) {
                return zzl;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zza> zzgzcVar = zzm;
            if (zzgzcVar == null) {
                synchronized (zza.class) {
                    try {
                        zzgzcVar = zzm;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzl);
                            zzm = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        public zze zzu(int i) {
            return this.zzw.get(i);
        }

        public zzbi zzv(int i) {
            return this.zzC.get(i);
        }

        public List<? extends zze> zzx() {
            return this.zzw;
        }

        public List<? extends zzbi> zzy() {
            return this.zzC;
        }
    }

    public interface zzaa extends zzhat {
        boolean zzA();

        boolean zzB();

        int zza();

        zzq zzb();

        zzv zzc();

        zzan zzw(int i);

        zzap zzx();

        List<zzan> zzy();

        boolean zzz();
    }

    public final class zzab extends zzgzh<zzab, zza> implements zzae {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzab zzc;
        private static volatile zzhba<zzab> zzd;
        private int zze;
        private int zzf;
        private int zzg;

        public final class zza extends zzgzb<zzab, zza> implements zzae {
            public /* synthetic */ zza() {
                this();
            }

            public zza zza() {
                zzbu();
                ((zzab) this.zza).zzz();
                return this;
            }

            public zza zzb() {
                zzbu();
                ((zzab) this.zza).zzA();
                return this;
            }

            public zza zzc(zzb zzbVar) {
                zzbu();
                ((zzab) this.zza).zzB(zzbVar);
                return this;
            }

            public zza zzd(zzc zzcVar) {
                zzbu();
                ((zzab) this.zza).zzC(zzcVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzae
            public zzb zze() {
                return ((zzab) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzae
            public zzc zzf() {
                return ((zzab) this.zza).zzf();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzae
            public boolean zzg() {
                return ((zzab) this.zza).zzg();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzae
            public boolean zzh() {
                return ((zzab) this.zza).zzh();
            }

            private zza() {
                super(zzab.zzc);
            }
        }

        public enum zzb implements zzgzl {
            CELLULAR_NETWORK_TYPE_UNSPECIFIED(0),
            TWO_G(1),
            THREE_G(2),
            LTE(4);

            public static final int zze = 0;
            public static final int zzf = 1;
            public static final int zzg = 2;
            public static final int zzh = 4;
            private static final zzgzm<zzb> zzi = new zzgzm<zzb>() { // from class: com.google.android.gms.internal.ads.zzbcj.zzab.zzb.1
                /* JADX INFO: renamed from: zza */
                public zzb zzb(int i) {
                    return zzb.zzb(i);
                }
            };
            private final int zzk;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zzab$zzb$1 */
            public class AnonymousClass1 implements zzgzm<zzb> {
                /* JADX INFO: renamed from: zza */
                public zzb zzb(int i) {
                    return zzb.zzb(i);
                }
            }

            final class zza implements zzgzn {
                static final zzgzn zza = new zza();

                private zza() {
                }

                @Override // com.google.android.gms.internal.ads.zzgzn
                public boolean zza(int i) {
                    return zzb.zzb(i) != null;
                }
            }

            zzb(int i) {
                this.zzk = i;
            }

            public static zzb zzb(int i) {
                if (i == 0) {
                    return CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return TWO_G;
                }
                if (i == 2) {
                    return THREE_G;
                }
                if (i != 4) {
                    return null;
                }
                return LTE;
            }

            public static zzgzm<zzb> zzd() {
                return zzi;
            }

            public static zzgzn zze() {
                return zza.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.zzk);
            }

            @Override // com.google.android.gms.internal.ads.zzgzl
            public final int zza() {
                return this.zzk;
            }
        }

        public enum zzc implements zzgzl {
            NETWORKTYPE_UNSPECIFIED(0),
            CELL(1),
            WIFI(2);

            public static final int zzd = 0;
            public static final int zze = 1;
            public static final int zzf = 2;
            private static final zzgzm<zzc> zzg = new zzgzm<zzc>() { // from class: com.google.android.gms.internal.ads.zzbcj.zzab.zzc.1
                /* JADX INFO: renamed from: zza */
                public zzc zzb(int i) {
                    return zzc.zzb(i);
                }
            };
            private final int zzi;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zzab$zzc$1 */
            public class AnonymousClass1 implements zzgzm<zzc> {
                /* JADX INFO: renamed from: zza */
                public zzc zzb(int i) {
                    return zzc.zzb(i);
                }
            }

            final class zza implements zzgzn {
                static final zzgzn zza = new zza();

                private zza() {
                }

                @Override // com.google.android.gms.internal.ads.zzgzn
                public boolean zza(int i) {
                    return zzc.zzb(i) != null;
                }
            }

            zzc(int i) {
                this.zzi = i;
            }

            public static zzc zzb(int i) {
                if (i == 0) {
                    return NETWORKTYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return CELL;
                }
                if (i != 2) {
                    return null;
                }
                return WIFI;
            }

            public static zzgzm<zzc> zzd() {
                return zzg;
            }

            public static zzgzn zze() {
                return zza.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.zzi);
            }

            @Override // com.google.android.gms.internal.ads.zzgzl
            public final int zza() {
                return this.zzi;
            }
        }

        static {
            zzab zzabVar = new zzab();
            zzc = zzabVar;
            zzgzh.zzbZ(zzab.class, zzabVar);
        }

        private zzab() {
        }

        public void zzA() {
            this.zze &= -2;
            this.zzf = 0;
        }

        public void zzB(zzb zzbVar) {
            this.zzg = zzbVar.zza();
            this.zze |= 2;
        }

        public void zzC(zzc zzcVar) {
            this.zzf = zzcVar.zza();
            this.zze |= 1;
        }

        public static zza zza() {
            return (zza) zzc.zzaZ();
        }

        public static zza zzb(zzab zzabVar) {
            return (zza) zzc.zzba(zzabVar);
        }

        public static zzab zzd() {
            return zzc;
        }

        public static zzab zzi(InputStream inputStream) {
            return (zzab) zzgzh.zzbk(zzc, inputStream);
        }

        public static zzab zzj(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzab) zzgzh.zzbl(zzc, inputStream, zzgyrVar);
        }

        public static zzab zzk(zzgxz zzgxzVar) {
            return (zzab) zzgzh.zzbm(zzc, zzgxzVar);
        }

        public static zzab zzl(zzgyf zzgyfVar) {
            return (zzab) zzgzh.zzbn(zzc, zzgyfVar);
        }

        public static zzab zzm(InputStream inputStream) {
            return (zzab) zzgzh.zzbo(zzc, inputStream);
        }

        public static zzab zzn(ByteBuffer byteBuffer) {
            return (zzab) zzgzh.zzbp(zzc, byteBuffer);
        }

        public static zzab zzo(byte[] bArr) {
            return (zzab) zzgzh.zzbq(zzc, bArr);
        }

        public static zzab zzp(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzab) zzgzh.zzbr(zzc, zzgxzVar, zzgyrVar);
        }

        public static zzab zzq(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzab) zzgzh.zzbs(zzc, zzgyfVar, zzgyrVar);
        }

        public static zzab zzr(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzab) zzgzh.zzbu(zzc, inputStream, zzgyrVar);
        }

        public static zzab zzs(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzab) zzgzh.zzbv(zzc, byteBuffer, zzgyrVar);
        }

        public static zzab zzt(byte[] bArr, zzgyr zzgyrVar) {
            return (zzab) zzgzh.zzbx(zzc, bArr, zzgyrVar);
        }

        public static zzhba<zzab> zzu() {
            return zzc.zzbN();
        }

        public void zzz() {
            this.zze &= -3;
            this.zzg = 0;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", zzc.zze(), "zzg", zzb.zze()});
            }
            if (iOrdinal == 3) {
                return new zzab();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzc;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzab> zzgzcVar = zzd;
            if (zzgzcVar == null) {
                synchronized (zzab.class) {
                    try {
                        zzgzcVar = zzd;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzc);
                            zzd = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzae
        public zzb zze() {
            zzb zzbVarZzb = zzb.zzb(this.zzg);
            return zzbVarZzb == null ? zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED : zzbVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzae
        public zzc zzf() {
            zzc zzcVarZzb = zzc.zzb(this.zzf);
            return zzcVarZzb == null ? zzc.NETWORKTYPE_UNSPECIFIED : zzcVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzae
        public boolean zzg() {
            return (this.zze & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzae
        public boolean zzh() {
            return (this.zze & 1) != 0;
        }
    }

    public final class zzac extends zzgzh<zzac, zza> implements zzad {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzac zzc;
        private static volatile zzhba<zzac> zzd;
        private int zze;
        private int zzf;
        private zzap zzg;

        public final class zza extends zzgzb<zzac, zza> implements zzad {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzad
            public zzq zza() {
                return ((zzac) this.zza).zza();
            }

            public zza zzb() {
                zzbu();
                ((zzac) this.zza).zzB();
                return this;
            }

            public zza zzc() {
                zzbu();
                ((zzac) this.zza).zzC();
                return this;
            }

            public zza zzd(zzap zzapVar) {
                zzbu();
                ((zzac) this.zza).zzD(zzapVar);
                return this;
            }

            public zza zze(zzap.zza zzaVar) {
                zzbu();
                ((zzac) this.zza).zzE(zzaVar.zzbr());
                return this;
            }

            public zza zzf(zzap zzapVar) {
                zzbu();
                ((zzac) this.zza).zzE(zzapVar);
                return this;
            }

            public zza zzg(zzq zzqVar) {
                zzbu();
                ((zzac) this.zza).zzF(zzqVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzad
            public zzap zzh() {
                return ((zzac) this.zza).zzh();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzad
            public boolean zzi() {
                return ((zzac) this.zza).zzi();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzad
            public boolean zzj() {
                return ((zzac) this.zza).zzj();
            }

            private zza() {
                super(zzac.zzc);
            }
        }

        static {
            zzac zzacVar = new zzac();
            zzc = zzacVar;
            zzgzh.zzbZ(zzac.class, zzacVar);
        }

        private zzac() {
        }

        public void zzB() {
            this.zzg = null;
            this.zze &= -3;
        }

        public void zzC() {
            this.zze &= -2;
            this.zzf = 0;
        }

        public void zzD(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzg;
            if (zzapVar2 != null && zzapVar2 != zzap.zzi()) {
                zzap.zza zzaVarZzd = zzap.zzd(zzapVar2);
                zzaVarZzd.zzbj(zzapVar);
                zzapVar = zzaVarZzd.zzbs();
            }
            this.zzg = zzapVar;
            this.zze |= 2;
        }

        public void zzE(zzap zzapVar) {
            zzapVar.getClass();
            this.zzg = zzapVar;
            this.zze |= 2;
        }

        public void zzF(zzq zzqVar) {
            this.zzf = zzqVar.zza();
            this.zze |= 1;
        }

        public static zza zzb() {
            return (zza) zzc.zzaZ();
        }

        public static zza zzc(zzac zzacVar) {
            return (zza) zzc.zzba(zzacVar);
        }

        public static zzac zzf() {
            return zzc;
        }

        public static zzac zzg(InputStream inputStream) {
            return (zzac) zzgzh.zzbk(zzc, inputStream);
        }

        public static zzac zzk(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzac) zzgzh.zzbl(zzc, inputStream, zzgyrVar);
        }

        public static zzac zzl(zzgxz zzgxzVar) {
            return (zzac) zzgzh.zzbm(zzc, zzgxzVar);
        }

        public static zzac zzm(zzgyf zzgyfVar) {
            return (zzac) zzgzh.zzbn(zzc, zzgyfVar);
        }

        public static zzac zzn(InputStream inputStream) {
            return (zzac) zzgzh.zzbo(zzc, inputStream);
        }

        public static zzac zzo(ByteBuffer byteBuffer) {
            return (zzac) zzgzh.zzbp(zzc, byteBuffer);
        }

        public static zzac zzp(byte[] bArr) {
            return (zzac) zzgzh.zzbq(zzc, bArr);
        }

        public static zzac zzq(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzac) zzgzh.zzbr(zzc, zzgxzVar, zzgyrVar);
        }

        public static zzac zzr(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzac) zzgzh.zzbs(zzc, zzgyfVar, zzgyrVar);
        }

        public static zzac zzs(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzac) zzgzh.zzbu(zzc, inputStream, zzgyrVar);
        }

        public static zzac zzt(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzac) zzgzh.zzbv(zzc, byteBuffer, zzgyrVar);
        }

        public static zzac zzu(byte[] bArr, zzgyr zzgyrVar) {
            return (zzac) zzgzh.zzbx(zzc, bArr, zzgyrVar);
        }

        public static zzhba<zzac> zzv() {
            return zzc.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzad
        public zzq zza() {
            zzq zzqVarZzb = zzq.zzb(this.zzf);
            return zzqVarZzb == null ? zzq.ENUM_FALSE : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", zzq.zze(), "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzac();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzc;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzac> zzgzcVar = zzd;
            if (zzgzcVar == null) {
                synchronized (zzac.class) {
                    try {
                        zzgzcVar = zzd;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzc);
                            zzd = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzad
        public zzap zzh() {
            zzap zzapVar = this.zzg;
            return zzapVar == null ? zzap.zzi() : zzapVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzad
        public boolean zzi() {
            return (this.zze & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzad
        public boolean zzj() {
            return (this.zze & 1) != 0;
        }
    }

    public interface zzad extends zzhat {
        zzq zza();

        zzap zzh();

        boolean zzi();

        boolean zzj();
    }

    public interface zzae extends zzhat {
        zzab.zzb zze();

        zzab.zzc zzf();

        boolean zzg();

        boolean zzh();
    }

    public final class zzaf extends zzgzh<zzaf, zzc> implements zzag {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 8;
        private static final zzaf zzi;
        private static volatile zzhba<zzaf> zzj;
        private int zzk;
        private int zzm;
        private int zzn;
        private long zzo;
        private long zzv;
        private int zzw;
        private zzgzt<zza> zzl = zzgzh.zzbK();
        private String zzp = "";
        private String zzu = "";

        public final class zza extends zzgzh<zza, C0003zza> implements zzb {
            public static final int zza = 1;
            public static final int zzb = 2;
            public static final int zzc = 3;
            public static final int zzd = 4;
            public static final int zze = 5;
            public static final int zzf = 6;
            public static final int zzg = 7;
            public static final int zzh = 8;
            public static final int zzi = 9;
            public static final int zzj = 10;
            public static final int zzk = 11;
            public static final int zzl = 12;
            public static final int zzm = 13;
            private static final zzgzq<zzd.zza> zzn = new zzgzq<zzd.zza>() { // from class: com.google.android.gms.internal.ads.zzbcj.zzaf.zza.1
                @Override // com.google.android.gms.internal.ads.zzgzq
                /* JADX INFO: renamed from: zza */
                public zzd.zza zzb(int i) {
                    zzd.zza zzaVarZzb = zzd.zza.zzb(i);
                    return zzaVarZzb == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzb;
                }
            };
            private static final zza zzo;
            private static volatile zzhba<zza> zzp;
            private zzab zzA;
            private int zzB;
            private int zzC;
            private int zzD;
            private int zzE;
            private int zzF;
            private int zzG;
            private long zzH;
            private int zzu;
            private long zzv;
            private int zzw;
            private long zzx;
            private long zzy;
            private zzgzp zzz = zzgzh.zzbG();

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zzaf$zza$1 */
            public class AnonymousClass1 implements zzgzq<zzd.zza> {
                @Override // com.google.android.gms.internal.ads.zzgzq
                /* JADX INFO: renamed from: zza */
                public zzd.zza zzb(int i) {
                    zzd.zza zzaVarZzb = zzd.zza.zzb(i);
                    return zzaVarZzb == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzb;
                }
            }

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zzaf$zza$zza */
            public final class C0003zza extends zzgzb<zza, C0003zza> implements zzb {
                public /* synthetic */ C0003zza() {
                    this();
                }

                public C0003zza zzA() {
                    zzbu();
                    ((zza) this.zza).zzaI();
                    return this;
                }

                public C0003zza zzB() {
                    zzbu();
                    ((zza) this.zza).zzaJ();
                    return this;
                }

                public C0003zza zzC(zzab zzabVar) {
                    zzbu();
                    ((zza) this.zza).zzcf(zzabVar);
                    return this;
                }

                public C0003zza zzD(zzq zzqVar) {
                    zzbu();
                    ((zza) this.zza).zzcg(zzqVar);
                    return this;
                }

                public C0003zza zzE(zzq zzqVar) {
                    zzbu();
                    ((zza) this.zza).zzch(zzqVar);
                    return this;
                }

                public C0003zza zzF(int i, zzd.zza zzaVar) {
                    zzbu();
                    ((zza) this.zza).zzci(i, zzaVar);
                    return this;
                }

                public C0003zza zzG(int i) {
                    zzbu();
                    ((zza) this.zza).zzcj(i);
                    return this;
                }

                public C0003zza zzH(zzd zzdVar) {
                    zzbu();
                    ((zza) this.zza).zzck(zzdVar);
                    return this;
                }

                public C0003zza zzI(zzab.zza zzaVar) {
                    zzbu();
                    ((zza) this.zza).zzcl(zzaVar.zzbr());
                    return this;
                }

                public C0003zza zzJ(zzab zzabVar) {
                    zzbu();
                    ((zza) this.zza).zzcl(zzabVar);
                    return this;
                }

                public C0003zza zzK(zzq zzqVar) {
                    zzbu();
                    ((zza) this.zza).zzcm(zzqVar);
                    return this;
                }

                public C0003zza zzL(long j) {
                    zzbu();
                    ((zza) this.zza).zzcn(j);
                    return this;
                }

                public C0003zza zzM(long j) {
                    zzbu();
                    ((zza) this.zza).zzco(j);
                    return this;
                }

                public C0003zza zzN(zzq zzqVar) {
                    zzbu();
                    ((zza) this.zza).zzcp(zzqVar);
                    return this;
                }

                public C0003zza zzO(long j) {
                    zzbu();
                    ((zza) this.zza).zzcq(j);
                    return this;
                }

                public C0003zza zzP(long j) {
                    zzbu();
                    ((zza) this.zza).zzcr(j);
                    return this;
                }

                public C0003zza zzQ(zzq zzqVar) {
                    zzbu();
                    ((zza) this.zza).zzcs(zzqVar);
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public zzd zzR() {
                    return ((zza) this.zza).zzR();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public List<zzd.zza> zzS() {
                    return ((zza) this.zza).zzS();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public boolean zzT() {
                    return ((zza) this.zza).zzT();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public boolean zzU() {
                    return ((zza) this.zza).zzU();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public boolean zzV() {
                    return ((zza) this.zza).zzV();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public boolean zzW() {
                    return ((zza) this.zza).zzW();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public boolean zzX() {
                    return ((zza) this.zza).zzX();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public boolean zzY() {
                    return ((zza) this.zza).zzY();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public boolean zzZ() {
                    return ((zza) this.zza).zzZ();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public int zza() {
                    return ((zza) this.zza).zza();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public boolean zzaa() {
                    return ((zza) this.zza).zzaa();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public boolean zzab() {
                    return ((zza) this.zza).zzab();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public boolean zzac() {
                    return ((zza) this.zza).zzac();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public boolean zzad() {
                    return ((zza) this.zza).zzad();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public boolean zzae() {
                    return ((zza) this.zza).zzae();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public int zzb() {
                    return ((zza) this.zza).zzb();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public long zzc() {
                    return ((zza) this.zza).zzc();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public long zzd() {
                    return ((zza) this.zza).zzd();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public long zze() {
                    return ((zza) this.zza).zze();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public long zzf() {
                    return ((zza) this.zza).zzf();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public zzd.zza zzg(int i) {
                    return ((zza) this.zza).zzg(i);
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public zzq zzh() {
                    return ((zza) this.zza).zzh();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public zzq zzi() {
                    return ((zza) this.zza).zzi();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public zzq zzj() {
                    return ((zza) this.zza).zzj();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public zzq zzk() {
                    return ((zza) this.zza).zzk();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public zzq zzl() {
                    return ((zza) this.zza).zzl();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
                public zzab zzm() {
                    return ((zza) this.zza).zzm();
                }

                public C0003zza zzn(Iterable<? extends zzd.zza> iterable) {
                    zzbu();
                    ((zza) this.zza).zzav(iterable);
                    return this;
                }

                public C0003zza zzo(zzd.zza zzaVar) {
                    zzbu();
                    ((zza) this.zza).zzaw(zzaVar);
                    return this;
                }

                public C0003zza zzp() {
                    zzbu();
                    ((zza) this.zza).zzax();
                    return this;
                }

                public C0003zza zzq() {
                    zzbu();
                    ((zza) this.zza).zzay();
                    return this;
                }

                public C0003zza zzr() {
                    zzbu();
                    ((zza) this.zza).zzaz();
                    return this;
                }

                public C0003zza zzs() {
                    zzbu();
                    ((zza) this.zza).zzaA();
                    return this;
                }

                public C0003zza zzt() {
                    zzbu();
                    ((zza) this.zza).zzaB();
                    return this;
                }

                public C0003zza zzu() {
                    zzbu();
                    ((zza) this.zza).zzaC();
                    return this;
                }

                public C0003zza zzv() {
                    zzbu();
                    ((zza) this.zza).zzaD();
                    return this;
                }

                public C0003zza zzw() {
                    zzbu();
                    ((zza) this.zza).zzaE();
                    return this;
                }

                public C0003zza zzx() {
                    zzbu();
                    ((zza) this.zza).zzaF();
                    return this;
                }

                public C0003zza zzy() {
                    zzbu();
                    ((zza) this.zza).zzaG();
                    return this;
                }

                public C0003zza zzz() {
                    zzbu();
                    ((zza) this.zza).zzaH();
                    return this;
                }

                private C0003zza() {
                    super(zza.zzo);
                }
            }

            static {
                zza zzaVar = new zza();
                zzo = zzaVar;
                zzgzh.zzbZ(zza.class, zzaVar);
            }

            private zza() {
            }

            public static zza zzA(InputStream inputStream, zzgyr zzgyrVar) {
                return (zza) zzgzh.zzbu(zzo, inputStream, zzgyrVar);
            }

            public static zza zzB(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
                return (zza) zzgzh.zzbv(zzo, byteBuffer, zzgyrVar);
            }

            public static zza zzC(byte[] bArr, zzgyr zzgyrVar) {
                return (zza) zzgzh.zzbx(zzo, bArr, zzgyrVar);
            }

            public static zzhba<zza> zzD() {
                return zzo.zzbN();
            }

            public void zzaA() {
                this.zzu &= -257;
                this.zzE = 0;
            }

            public void zzaB() {
                this.zzu &= -1025;
                this.zzG = 0;
            }

            public void zzaC() {
                this.zzA = null;
                this.zzu &= -17;
            }

            public void zzaD() {
                this.zzu &= -513;
                this.zzF = 0;
            }

            public void zzaE() {
                this.zzu &= -9;
                this.zzy = 0L;
            }

            public void zzaF() {
                this.zzu &= -5;
                this.zzx = 0L;
            }

            public void zzaG() {
                this.zzu &= -3;
                this.zzw = 0;
            }

            public void zzaH() {
                this.zzu &= -2;
                this.zzv = 0L;
            }

            public void zzaI() {
                this.zzu &= -2049;
                this.zzH = 0L;
            }

            public void zzaJ() {
                this.zzu &= -33;
                this.zzB = 0;
            }

            private void zzaK() {
                zzgzp zzgzpVar = this.zzz;
                if (zzgzpVar.zzc()) {
                    return;
                }
                this.zzz = zzgzh.zzbH(zzgzpVar);
            }

            public void zzav(Iterable<? extends zzd.zza> iterable) {
                zzaK();
                Iterator<? extends zzd.zza> it = iterable.iterator();
                while (it.hasNext()) {
                    this.zzz.zzi(it.next().zza());
                }
            }

            public void zzaw(zzd.zza zzaVar) {
                zzaVar.getClass();
                zzaK();
                this.zzz.zzi(zzaVar.zza());
            }

            public void zzax() {
                this.zzu &= -65;
                this.zzC = 0;
            }

            public void zzay() {
                this.zzu &= -129;
                this.zzD = 0;
            }

            public void zzaz() {
                this.zzz = zzgzh.zzbG();
            }

            public void zzcf(zzab zzabVar) {
                zzabVar.getClass();
                zzab zzabVar2 = this.zzA;
                if (zzabVar2 != null && zzabVar2 != zzab.zzd()) {
                    zzab.zza zzaVarZzb = zzab.zzb(zzabVar2);
                    zzaVarZzb.zzbj(zzabVar);
                    zzabVar = zzaVarZzb.zzbs();
                }
                this.zzA = zzabVar;
                this.zzu |= 16;
            }

            public void zzcg(zzq zzqVar) {
                this.zzC = zzqVar.zza();
                this.zzu |= 64;
            }

            public void zzch(zzq zzqVar) {
                this.zzD = zzqVar.zza();
                this.zzu |= 128;
            }

            public void zzci(int i, zzd.zza zzaVar) {
                zzaVar.getClass();
                zzaK();
                this.zzz.zze(i, zzaVar.zza());
            }

            public void zzcj(int i) {
                this.zzu |= 256;
                this.zzE = i;
            }

            public void zzck(zzd zzdVar) {
                this.zzG = zzdVar.zza();
                this.zzu |= 1024;
            }

            public void zzcl(zzab zzabVar) {
                zzabVar.getClass();
                this.zzA = zzabVar;
                this.zzu |= 16;
            }

            public void zzcm(zzq zzqVar) {
                this.zzF = zzqVar.zza();
                this.zzu |= 512;
            }

            public void zzcn(long j) {
                this.zzu |= 8;
                this.zzy = j;
            }

            public void zzco(long j) {
                this.zzu |= 4;
                this.zzx = j;
            }

            public void zzcp(zzq zzqVar) {
                this.zzw = zzqVar.zza();
                this.zzu |= 2;
            }

            public void zzcq(long j) {
                this.zzu |= 1;
                this.zzv = j;
            }

            public void zzcr(long j) {
                this.zzu |= 2048;
                this.zzH = j;
            }

            public void zzcs(zzq zzqVar) {
                this.zzB = zzqVar.zza();
                this.zzu |= 32;
            }

            public static C0003zza zzn() {
                return (C0003zza) zzo.zzaZ();
            }

            public static C0003zza zzo(zza zzaVar) {
                return (C0003zza) zzo.zzba(zzaVar);
            }

            public static zza zzq() {
                return zzo;
            }

            public static zza zzr(InputStream inputStream) {
                return (zza) zzgzh.zzbk(zzo, inputStream);
            }

            public static zza zzs(InputStream inputStream, zzgyr zzgyrVar) {
                return (zza) zzgzh.zzbl(zzo, inputStream, zzgyrVar);
            }

            public static zza zzt(zzgxz zzgxzVar) {
                return (zza) zzgzh.zzbm(zzo, zzgxzVar);
            }

            public static zza zzu(zzgyf zzgyfVar) {
                return (zza) zzgzh.zzbn(zzo, zzgyfVar);
            }

            public static zza zzv(InputStream inputStream) {
                return (zza) zzgzh.zzbo(zzo, inputStream);
            }

            public static zza zzw(ByteBuffer byteBuffer) {
                return (zza) zzgzh.zzbp(zzo, byteBuffer);
            }

            public static zza zzx(byte[] bArr) {
                return (zza) zzgzh.zzbq(zzo, bArr);
            }

            public static zza zzy(zzgxz zzgxzVar, zzgyr zzgyrVar) {
                return (zza) zzgzh.zzbr(zzo, zzgxzVar, zzgyrVar);
            }

            public static zza zzz(zzgyf zzgyfVar, zzgyr zzgyrVar) {
                return (zza) zzgzh.zzbs(zzo, zzgyfVar, zzgyrVar);
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public zzd zzR() {
                zzd zzdVarZzb = zzd.zzb(this.zzG);
                return zzdVarZzb == null ? zzd.UNSPECIFIED : zzdVarZzb;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public List<zzd.zza> zzS() {
                return new zzgzr(this.zzz, zzn);
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public boolean zzT() {
                return (this.zzu & 64) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public boolean zzU() {
                return (this.zzu & 128) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public boolean zzV() {
                return (this.zzu & 256) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public boolean zzW() {
                return (this.zzu & 1024) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public boolean zzX() {
                return (this.zzu & 16) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public boolean zzY() {
                return (this.zzu & 512) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public boolean zzZ() {
                return (this.zzu & 8) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public int zza() {
                return this.zzz.size();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public boolean zzaa() {
                return (this.zzu & 4) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public boolean zzab() {
                return (this.zzu & 2) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public boolean zzac() {
                return (this.zzu & 1) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public boolean zzad() {
                return (this.zzu & 2048) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public boolean zzae() {
                return (this.zzu & 32) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public int zzb() {
                return this.zzE;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public long zzc() {
                return this.zzy;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public long zzd() {
                return this.zzx;
            }

            @Override // com.google.android.gms.internal.ads.zzgzh
            public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
                int iOrdinal = zzgzgVar.ordinal();
                if (iOrdinal == 0) {
                    return (byte) 1;
                }
                if (iOrdinal == 2) {
                    return zzgzh.zzbQ(zzo, "\u0004\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဂ\u0000\u0002᠌\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ࠞ\u0006ဉ\u0004\u0007᠌\u0005\b᠌\u0006\t᠌\u0007\nင\b\u000b᠌\t\f᠌\n\rဂ\u000b", new Object[]{"zzu", "zzv", "zzw", zzq.zze(), "zzx", "zzy", "zzz", zzd.zza.zze(), "zzA", "zzB", zzq.zze(), "zzC", zzq.zze(), "zzD", zzq.zze(), "zzE", "zzF", zzq.zze(), "zzG", zzd.zze(), "zzH"});
                }
                if (iOrdinal == 3) {
                    return new zza();
                }
                if (iOrdinal == 4) {
                    return new C0003zza();
                }
                if (iOrdinal == 5) {
                    return zzo;
                }
                if (iOrdinal != 6) {
                    throw null;
                }
                zzhba<zza> zzgzcVar = zzp;
                if (zzgzcVar == null) {
                    synchronized (zza.class) {
                        try {
                            zzgzcVar = zzp;
                            if (zzgzcVar == null) {
                                zzgzcVar = new zzgzc(zzo);
                                zzp = zzgzcVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                return zzgzcVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public long zze() {
                return this.zzv;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public long zzf() {
                return this.zzH;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public zzd.zza zzg(int i) {
                zzd.zza zzaVarZzb = zzd.zza.zzb(this.zzz.zzd(i));
                return zzaVarZzb == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzb;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public zzq zzh() {
                zzq zzqVarZzb = zzq.zzb(this.zzC);
                return zzqVarZzb == null ? zzq.ENUM_FALSE : zzqVarZzb;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public zzq zzi() {
                zzq zzqVarZzb = zzq.zzb(this.zzD);
                return zzqVarZzb == null ? zzq.ENUM_FALSE : zzqVarZzb;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public zzq zzj() {
                zzq zzqVarZzb = zzq.zzb(this.zzF);
                return zzqVarZzb == null ? zzq.ENUM_FALSE : zzqVarZzb;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public zzq zzk() {
                zzq zzqVarZzb = zzq.zzb(this.zzw);
                return zzqVarZzb == null ? zzq.ENUM_FALSE : zzqVarZzb;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public zzq zzl() {
                zzq zzqVarZzb = zzq.zzb(this.zzB);
                return zzqVarZzb == null ? zzq.ENUM_FALSE : zzqVarZzb;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaf.zzb
            public zzab zzm() {
                zzab zzabVar = this.zzA;
                return zzabVar == null ? zzab.zzd() : zzabVar;
            }
        }

        public interface zzb extends zzhat {
            zzd zzR();

            List<zzd.zza> zzS();

            boolean zzT();

            boolean zzU();

            boolean zzV();

            boolean zzW();

            boolean zzX();

            boolean zzY();

            boolean zzZ();

            int zza();

            boolean zzaa();

            boolean zzab();

            boolean zzac();

            boolean zzad();

            boolean zzae();

            int zzb();

            long zzc();

            long zzd();

            long zze();

            long zzf();

            zzd.zza zzg(int i);

            zzq zzh();

            zzq zzi();

            zzq zzj();

            zzq zzk();

            zzq zzl();

            zzab zzm();
        }

        public final class zzc extends zzgzb<zzaf, zzc> implements zzag {
            public /* synthetic */ zzc() {
                this();
            }

            public zzc zzA(int i) {
                zzbu();
                ((zzaf) this.zza).zzaA(i);
                return this;
            }

            public zzc zzB(long j) {
                zzbu();
                ((zzaf) this.zza).zzaB(j);
                return this;
            }

            public zzc zzC(int i, zza.C0003zza c0003zza) {
                zzbu();
                ((zzaf) this.zza).zzaC(i, c0003zza.zzbr());
                return this;
            }

            public zzc zzD(int i, zza zzaVar) {
                zzbu();
                ((zzaf) this.zza).zzaC(i, zzaVar);
                return this;
            }

            public zzc zzE(int i) {
                zzbu();
                ((zzaf) this.zza).zzaD(i);
                return this;
            }

            public zzc zzF(long j) {
                zzbu();
                ((zzaf) this.zza).zzaE(j);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public zzgxz zzG() {
                return ((zzaf) this.zza).zzG();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public zzgxz zzH() {
                return ((zzaf) this.zza).zzH();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public String zzI() {
                return ((zzaf) this.zza).zzI();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public String zzJ() {
                return ((zzaf) this.zza).zzJ();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public List<zza> zzK() {
                return Collections.unmodifiableList(((zzaf) this.zza).zzK());
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public boolean zzL() {
                return ((zzaf) this.zza).zzL();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public boolean zzM() {
                return ((zzaf) this.zza).zzM();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public boolean zzN() {
                return ((zzaf) this.zza).zzN();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public boolean zzO() {
                return ((zzaf) this.zza).zzO();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public boolean zzP() {
                return ((zzaf) this.zza).zzP();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public boolean zzQ() {
                return ((zzaf) this.zza).zzQ();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public boolean zzR() {
                return ((zzaf) this.zza).zzR();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public int zza() {
                return ((zzaf) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public int zzb() {
                return ((zzaf) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public int zzc() {
                return ((zzaf) this.zza).zzc();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public int zzd() {
                return ((zzaf) this.zza).zzd();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public long zze() {
                return ((zzaf) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public long zzf() {
                return ((zzaf) this.zza).zzf();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzag
            public zza zzg(int i) {
                return ((zzaf) this.zza).zzg(i);
            }

            public zzc zzh(Iterable<? extends zza> iterable) {
                zzbu();
                ((zzaf) this.zza).zzai(iterable);
                return this;
            }

            public zzc zzi(zza.C0003zza c0003zza) {
                zzbu();
                ((zzaf) this.zza).zzaj(c0003zza.zzbr());
                return this;
            }

            public zzc zzj(zza zzaVar) {
                zzbu();
                ((zzaf) this.zza).zzaj(zzaVar);
                return this;
            }

            public zzc zzk(int i, zza.C0003zza c0003zza) {
                zzbu();
                ((zzaf) this.zza).zzak(i, c0003zza.zzbr());
                return this;
            }

            public zzc zzl(int i, zza zzaVar) {
                zzbu();
                ((zzaf) this.zza).zzak(i, zzaVar);
                return this;
            }

            public zzc zzm() {
                zzbu();
                ((zzaf) this.zza).zzal();
                return this;
            }

            public zzc zzn() {
                zzbu();
                ((zzaf) this.zza).zzam();
                return this;
            }

            public zzc zzo() {
                zzbu();
                ((zzaf) this.zza).zzan();
                return this;
            }

            public zzc zzp() {
                zzbu();
                ((zzaf) this.zza).zzao();
                return this;
            }

            public zzc zzq() {
                zzbu();
                ((zzaf) this.zza).zzap();
                return this;
            }

            public zzc zzr() {
                zzbu();
                ((zzaf) this.zza).zzaq();
                return this;
            }

            public zzc zzs() {
                zzbu();
                ((zzaf) this.zza).zzar();
                return this;
            }

            public zzc zzt() {
                zzbu();
                ((zzaf) this.zza).zzas();
                return this;
            }

            public zzc zzu(int i) {
                zzbu();
                ((zzaf) this.zza).zzau(i);
                return this;
            }

            public zzc zzv(String str) {
                zzbu();
                ((zzaf) this.zza).zzav(str);
                return this;
            }

            public zzc zzw(zzgxz zzgxzVar) {
                zzbu();
                ((zzaf) this.zza).zzaw(zzgxzVar);
                return this;
            }

            public zzc zzx(int i) {
                zzbu();
                ((zzaf) this.zza).zzax(i);
                return this;
            }

            public zzc zzy(String str) {
                zzbu();
                ((zzaf) this.zza).zzay(str);
                return this;
            }

            public zzc zzz(zzgxz zzgxzVar) {
                zzbu();
                ((zzaf) this.zza).zzaz(zzgxzVar);
                return this;
            }

            private zzc() {
                super(zzaf.zzi);
            }
        }

        public enum zzd implements zzgzl {
            UNSPECIFIED(0),
            CONNECTING(1),
            CONNECTED(2),
            DISCONNECTING(3),
            DISCONNECTED(4),
            SUSPENDED(5);

            public static final int zzg = 0;
            public static final int zzh = 1;
            public static final int zzi = 2;
            public static final int zzj = 3;
            public static final int zzk = 4;
            public static final int zzl = 5;
            private static final zzgzm<zzd> zzm = new zzgzm<zzd>() { // from class: com.google.android.gms.internal.ads.zzbcj.zzaf.zzd.1
                /* JADX INFO: renamed from: zza */
                public zzd zzb(int i) {
                    return zzd.zzb(i);
                }
            };
            private final int zzo;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zzaf$zzd$1 */
            public class AnonymousClass1 implements zzgzm<zzd> {
                /* JADX INFO: renamed from: zza */
                public zzd zzb(int i) {
                    return zzd.zzb(i);
                }
            }

            final class zza implements zzgzn {
                static final zzgzn zza = new zza();

                private zza() {
                }

                @Override // com.google.android.gms.internal.ads.zzgzn
                public boolean zza(int i) {
                    return zzd.zzb(i) != null;
                }
            }

            zzd(int i) {
                this.zzo = i;
            }

            public static zzd zzb(int i) {
                if (i == 0) {
                    return UNSPECIFIED;
                }
                if (i == 1) {
                    return CONNECTING;
                }
                if (i == 2) {
                    return CONNECTED;
                }
                if (i == 3) {
                    return DISCONNECTING;
                }
                if (i == 4) {
                    return DISCONNECTED;
                }
                if (i != 5) {
                    return null;
                }
                return SUSPENDED;
            }

            public static zzgzm<zzd> zzd() {
                return zzm;
            }

            public static zzgzn zze() {
                return zza.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.zzo);
            }

            @Override // com.google.android.gms.internal.ads.zzgzl
            public final int zza() {
                return this.zzo;
            }
        }

        static {
            zzaf zzafVar = new zzaf();
            zzi = zzafVar;
            zzgzh.zzbZ(zzaf.class, zzafVar);
        }

        private zzaf() {
        }

        public void zzaA(int i) {
            this.zzk |= 1;
            this.zzm = i;
        }

        public void zzaB(long j) {
            this.zzk |= 32;
            this.zzv = j;
        }

        public void zzaC(int i, zza zzaVar) {
            zzaVar.getClass();
            zzat();
            this.zzl.set(i, zzaVar);
        }

        public void zzaD(int i) {
            this.zzk |= 2;
            this.zzn = i;
        }

        public void zzaE(long j) {
            this.zzk |= 4;
            this.zzo = j;
        }

        public void zzai(Iterable<? extends zza> iterable) {
            zzat();
            zzgxi.zzaQ(iterable, this.zzl);
        }

        public void zzaj(zza zzaVar) {
            zzaVar.getClass();
            zzat();
            this.zzl.add(zzaVar);
        }

        public void zzak(int i, zza zzaVar) {
            zzaVar.getClass();
            zzat();
            this.zzl.add(i, zzaVar);
        }

        public void zzal() {
            this.zzk &= -9;
            this.zzp = zzl().zzI();
        }

        public void zzam() {
            this.zzk &= -65;
            this.zzw = 0;
        }

        public void zzan() {
            this.zzk &= -17;
            this.zzu = zzl().zzJ();
        }

        public void zzao() {
            this.zzk &= -2;
            this.zzm = 0;
        }

        public void zzap() {
            this.zzk &= -33;
            this.zzv = 0L;
        }

        public void zzaq() {
            this.zzl = zzgzh.zzbK();
        }

        public void zzar() {
            this.zzk &= -3;
            this.zzn = 0;
        }

        public void zzas() {
            this.zzk &= -5;
            this.zzo = 0L;
        }

        private void zzat() {
            zzgzt<zza> zzgztVar = this.zzl;
            if (zzgztVar.zzc()) {
                return;
            }
            this.zzl = zzgzh.zzbL(zzgztVar);
        }

        public void zzau(int i) {
            zzat();
            this.zzl.remove(i);
        }

        public void zzav(String str) {
            str.getClass();
            this.zzk |= 8;
            this.zzp = str;
        }

        public void zzaw(zzgxz zzgxzVar) {
            this.zzp = zzgxzVar.zzx();
            this.zzk |= 8;
        }

        public void zzax(int i) {
            this.zzk |= 64;
            this.zzw = i;
        }

        public void zzay(String str) {
            str.getClass();
            this.zzk |= 16;
            this.zzu = str;
        }

        public void zzaz(zzgxz zzgxzVar) {
            this.zzu = zzgxzVar.zzx();
            this.zzk |= 16;
        }

        public static zzc zzi() {
            return (zzc) zzi.zzaZ();
        }

        public static zzc zzj(zzaf zzafVar) {
            return (zzc) zzi.zzba(zzafVar);
        }

        public static zzaf zzl() {
            return zzi;
        }

        public static zzaf zzm(InputStream inputStream) {
            return (zzaf) zzgzh.zzbk(zzi, inputStream);
        }

        public static zzaf zzn(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzaf) zzgzh.zzbl(zzi, inputStream, zzgyrVar);
        }

        public static zzaf zzo(zzgxz zzgxzVar) {
            return (zzaf) zzgzh.zzbm(zzi, zzgxzVar);
        }

        public static zzaf zzp(zzgyf zzgyfVar) {
            return (zzaf) zzgzh.zzbn(zzi, zzgyfVar);
        }

        public static zzaf zzq(InputStream inputStream) {
            return (zzaf) zzgzh.zzbo(zzi, inputStream);
        }

        public static zzaf zzr(ByteBuffer byteBuffer) {
            return (zzaf) zzgzh.zzbp(zzi, byteBuffer);
        }

        public static zzaf zzs(byte[] bArr) {
            return (zzaf) zzgzh.zzbq(zzi, bArr);
        }

        public static zzaf zzt(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzaf) zzgzh.zzbr(zzi, zzgxzVar, zzgyrVar);
        }

        public static zzaf zzu(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzaf) zzgzh.zzbs(zzi, zzgyfVar, zzgyrVar);
        }

        public static zzaf zzv(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzaf) zzgzh.zzbu(zzi, inputStream, zzgyrVar);
        }

        public static zzaf zzw(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzaf) zzgzh.zzbv(zzi, byteBuffer, zzgyrVar);
        }

        public static zzaf zzx(byte[] bArr, zzgyr zzgyrVar) {
            return (zzaf) zzgzh.zzbx(zzi, bArr, zzgyrVar);
        }

        public static zzhba<zzaf> zzy() {
            return zzi.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public zzgxz zzG() {
            return zzgxz.zzw(this.zzp);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public zzgxz zzH() {
            return zzgxz.zzw(this.zzu);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public String zzI() {
            return this.zzp;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public String zzJ() {
            return this.zzu;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public List<zza> zzK() {
            return this.zzl;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public boolean zzL() {
            return (this.zzk & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public boolean zzM() {
            return (this.zzk & 64) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public boolean zzN() {
            return (this.zzk & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public boolean zzO() {
            return (this.zzk & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public boolean zzP() {
            return (this.zzk & 32) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public boolean zzQ() {
            return (this.zzk & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public boolean zzR() {
            return (this.zzk & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public int zza() {
            return this.zzw;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public int zzb() {
            return this.zzm;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public int zzc() {
            return this.zzl.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public int zzd() {
            return this.zzn;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzi, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u001b\u0002င\u0000\u0003င\u0001\u0004ဂ\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဂ\u0005\bင\u0006", new Object[]{"zzk", "zzl", zza.class, "zzm", "zzn", "zzo", "zzp", "zzu", "zzv", "zzw"});
            }
            if (iOrdinal == 3) {
                return new zzaf();
            }
            if (iOrdinal == 4) {
                return new zzc();
            }
            if (iOrdinal == 5) {
                return zzi;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzaf> zzgzcVar = zzj;
            if (zzgzcVar == null) {
                synchronized (zzaf.class) {
                    try {
                        zzgzcVar = zzj;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzi);
                            zzj = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public long zze() {
            return this.zzv;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public long zzf() {
            return this.zzo;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzag
        public zza zzg(int i) {
            return this.zzl.get(i);
        }

        public zzb zzh(int i) {
            return this.zzl.get(i);
        }

        public List<? extends zzb> zzz() {
            return this.zzl;
        }
    }

    public interface zzag extends zzhat {
        zzgxz zzG();

        zzgxz zzH();

        String zzI();

        String zzJ();

        List<zzaf.zza> zzK();

        boolean zzL();

        boolean zzM();

        boolean zzN();

        boolean zzO();

        boolean zzP();

        boolean zzQ();

        boolean zzR();

        int zza();

        int zzb();

        int zzc();

        int zzd();

        long zze();

        long zzf();

        zzaf.zza zzg(int i);
    }

    public final class zzah extends zzgzh<zzah, zza> implements zzak {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 8;
        public static final int zzi = 9;
        public static final int zzj = 10;
        public static final int zzk = 11;
        private static final zzah zzl;
        private static volatile zzhba<zzah> zzm;
        private int zzA;
        private int zzB;
        private zzai zzC;
        private int zzn;
        private int zzo = 1000;
        private int zzp = 1000;
        private int zzu;
        private int zzv;
        private int zzw;
        private int zzx;
        private int zzy;
        private int zzz;

        public final class zza extends zzgzb<zzah, zza> implements zzak {
            public /* synthetic */ zza() {
                this();
            }

            public zza zzA(int i) {
                zzbu();
                ((zzah) this.zza).zzaA(i);
                return this;
            }

            public zza zzB(int i) {
                zzbu();
                ((zzah) this.zza).zzaB(i);
                return this;
            }

            public zza zzC(int i) {
                zzbu();
                ((zzah) this.zza).zzaC(i);
                return this;
            }

            public zza zzD(zzai.zza zzaVar) {
                zzbu();
                ((zzah) this.zza).zzaD(zzaVar.zzbr());
                return this;
            }

            public zza zzE(zzai zzaiVar) {
                zzbu();
                ((zzah) this.zza).zzaD(zzaiVar);
                return this;
            }

            public zza zzF(int i) {
                zzbu();
                ((zzah) this.zza).zzaE(i);
                return this;
            }

            public zza zzG(int i) {
                zzbu();
                ((zzah) this.zza).zzaF(i);
                return this;
            }

            public zza zzH(int i) {
                zzbu();
                ((zzah) this.zza).zzaG(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public zzai zzI() {
                return ((zzah) this.zza).zzI();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public boolean zzJ() {
                return ((zzah) this.zza).zzJ();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public boolean zzK() {
                return ((zzah) this.zza).zzK();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public boolean zzL() {
                return ((zzah) this.zza).zzL();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public boolean zzM() {
                return ((zzah) this.zza).zzM();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public boolean zzN() {
                return ((zzah) this.zza).zzN();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public boolean zzO() {
                return ((zzah) this.zza).zzO();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public boolean zzP() {
                return ((zzah) this.zza).zzP();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public boolean zzQ() {
                return ((zzah) this.zza).zzQ();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public boolean zzR() {
                return ((zzah) this.zza).zzR();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public boolean zzS() {
                return ((zzah) this.zza).zzS();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public boolean zzT() {
                return ((zzah) this.zza).zzT();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public int zza() {
                return ((zzah) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public int zzb() {
                return ((zzah) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public int zzc() {
                return ((zzah) this.zza).zzc();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public int zzd() {
                return ((zzah) this.zza).zzd();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public int zze() {
                return ((zzah) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public int zzf() {
                return ((zzah) this.zza).zzf();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public int zzg() {
                return ((zzah) this.zza).zzg();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public int zzh() {
                return ((zzah) this.zza).zzh();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public zzq zzi() {
                return ((zzah) this.zza).zzi();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzak
            public zzq zzj() {
                return ((zzah) this.zza).zzj();
            }

            public zza zzk() {
                zzbu();
                ((zzah) this.zza).zzak();
                return this;
            }

            public zza zzl() {
                zzbu();
                ((zzah) this.zza).zzal();
                return this;
            }

            public zza zzm() {
                zzbu();
                ((zzah) this.zza).zzam();
                return this;
            }

            public zza zzn() {
                zzbu();
                ((zzah) this.zza).zzan();
                return this;
            }

            public zza zzo() {
                zzbu();
                ((zzah) this.zza).zzao();
                return this;
            }

            public zza zzp() {
                zzbu();
                ((zzah) this.zza).zzap();
                return this;
            }

            public zza zzq() {
                zzbu();
                ((zzah) this.zza).zzaq();
                return this;
            }

            public zza zzr() {
                zzbu();
                ((zzah) this.zza).zzar();
                return this;
            }

            public zza zzs() {
                zzbu();
                ((zzah) this.zza).zzas();
                return this;
            }

            public zza zzt() {
                zzbu();
                ((zzah) this.zza).zzat();
                return this;
            }

            public zza zzu() {
                zzbu();
                ((zzah) this.zza).zzau();
                return this;
            }

            public zza zzv(zzai zzaiVar) {
                zzbu();
                ((zzah) this.zza).zzav(zzaiVar);
                return this;
            }

            public zza zzw(zzq zzqVar) {
                zzbu();
                ((zzah) this.zza).zzaw(zzqVar);
                return this;
            }

            public zza zzx(zzq zzqVar) {
                zzbu();
                ((zzah) this.zza).zzax(zzqVar);
                return this;
            }

            public zza zzy(int i) {
                zzbu();
                ((zzah) this.zza).zzay(i);
                return this;
            }

            public zza zzz(int i) {
                zzbu();
                ((zzah) this.zza).zzaz(i);
                return this;
            }

            private zza() {
                super(zzah.zzl);
            }
        }

        static {
            zzah zzahVar = new zzah();
            zzl = zzahVar;
            zzgzh.zzbZ(zzah.class, zzahVar);
        }

        private zzah() {
        }

        public static zzhba<zzah> zzA() {
            return zzl.zzbN();
        }

        public void zzaA(int i) {
            this.zzn |= 8;
            this.zzv = i;
        }

        public void zzaB(int i) {
            this.zzn |= 512;
            this.zzB = i;
        }

        public void zzaC(int i) {
            this.zzn |= 256;
            this.zzA = i;
        }

        public void zzaD(zzai zzaiVar) {
            zzaiVar.getClass();
            this.zzC = zzaiVar;
            this.zzn |= 1024;
        }

        public void zzaE(int i) {
            this.zzn |= 4;
            this.zzu = i;
        }

        public void zzaF(int i) {
            this.zzn |= 32;
            this.zzx = i;
        }

        public void zzaG(int i) {
            this.zzn |= 16;
            this.zzw = i;
        }

        public void zzak() {
            this.zzn &= -3;
            this.zzp = 1000;
        }

        public void zzal() {
            this.zzn &= -2;
            this.zzo = 1000;
        }

        public void zzam() {
            this.zzn &= -65;
            this.zzy = 0;
        }

        public void zzan() {
            this.zzn &= -129;
            this.zzz = 0;
        }

        public void zzao() {
            this.zzn &= -9;
            this.zzv = 0;
        }

        public void zzap() {
            this.zzn &= -513;
            this.zzB = 0;
        }

        public void zzaq() {
            this.zzn &= -257;
            this.zzA = 0;
        }

        public void zzar() {
            this.zzC = null;
            this.zzn &= -1025;
        }

        public void zzas() {
            this.zzn &= -5;
            this.zzu = 0;
        }

        public void zzat() {
            this.zzn &= -33;
            this.zzx = 0;
        }

        public void zzau() {
            this.zzn &= -17;
            this.zzw = 0;
        }

        public void zzav(zzai zzaiVar) {
            zzaiVar.getClass();
            zzai zzaiVar2 = this.zzC;
            if (zzaiVar2 != null && zzaiVar2 != zzai.zzi()) {
                zzai.zza zzaVarZzd = zzai.zzd(zzaiVar2);
                zzaVarZzd.zzbj(zzaiVar);
                zzaiVar = zzaVarZzd.zzbs();
            }
            this.zzC = zzaiVar;
            this.zzn |= 1024;
        }

        public void zzaw(zzq zzqVar) {
            this.zzp = zzqVar.zza();
            this.zzn |= 2;
        }

        public void zzax(zzq zzqVar) {
            this.zzo = zzqVar.zza();
            this.zzn |= 1;
        }

        public void zzay(int i) {
            this.zzn |= 64;
            this.zzy = i;
        }

        public void zzaz(int i) {
            this.zzn |= 128;
            this.zzz = i;
        }

        public static zza zzk() {
            return (zza) zzl.zzaZ();
        }

        public static zza zzl(zzah zzahVar) {
            return (zza) zzl.zzba(zzahVar);
        }

        public static zzah zzn() {
            return zzl;
        }

        public static zzah zzo(InputStream inputStream) {
            return (zzah) zzgzh.zzbk(zzl, inputStream);
        }

        public static zzah zzp(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzah) zzgzh.zzbl(zzl, inputStream, zzgyrVar);
        }

        public static zzah zzq(zzgxz zzgxzVar) {
            return (zzah) zzgzh.zzbm(zzl, zzgxzVar);
        }

        public static zzah zzr(zzgyf zzgyfVar) {
            return (zzah) zzgzh.zzbn(zzl, zzgyfVar);
        }

        public static zzah zzs(InputStream inputStream) {
            return (zzah) zzgzh.zzbo(zzl, inputStream);
        }

        public static zzah zzt(ByteBuffer byteBuffer) {
            return (zzah) zzgzh.zzbp(zzl, byteBuffer);
        }

        public static zzah zzu(byte[] bArr) {
            return (zzah) zzgzh.zzbq(zzl, bArr);
        }

        public static zzah zzv(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzah) zzgzh.zzbr(zzl, zzgxzVar, zzgyrVar);
        }

        public static zzah zzw(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzah) zzgzh.zzbs(zzl, zzgyfVar, zzgyrVar);
        }

        public static zzah zzx(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzah) zzgzh.zzbu(zzl, inputStream, zzgyrVar);
        }

        public static zzah zzy(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzah) zzgzh.zzbv(zzl, byteBuffer, zzgyrVar);
        }

        public static zzah zzz(byte[] bArr, zzgyr zzgyrVar) {
            return (zzah) zzgzh.zzbx(zzl, bArr, zzgyrVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public zzai zzI() {
            zzai zzaiVar = this.zzC;
            return zzaiVar == null ? zzai.zzi() : zzaiVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public boolean zzJ() {
            return (this.zzn & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public boolean zzK() {
            return (this.zzn & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public boolean zzL() {
            return (this.zzn & 64) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public boolean zzM() {
            return (this.zzn & 128) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public boolean zzN() {
            return (this.zzn & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public boolean zzO() {
            return (this.zzn & 512) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public boolean zzP() {
            return (this.zzn & 256) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public boolean zzQ() {
            return (this.zzn & 1024) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public boolean zzR() {
            return (this.zzn & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public boolean zzS() {
            return (this.zzn & 32) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public boolean zzT() {
            return (this.zzn & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public int zza() {
            return this.zzy;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public int zzb() {
            return this.zzz;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public int zzc() {
            return this.zzv;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public int zzd() {
            return this.zzB;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzl, "\u0004\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\tင\b\nင\t\u000bဉ\n", new Object[]{"zzn", "zzo", zzq.zze(), "zzp", zzq.zze(), "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC"});
            }
            if (iOrdinal == 3) {
                return new zzah();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzl;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzah> zzgzcVar = zzm;
            if (zzgzcVar == null) {
                synchronized (zzah.class) {
                    try {
                        zzgzcVar = zzm;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzl);
                            zzm = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public int zze() {
            return this.zzA;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public int zzf() {
            return this.zzu;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public int zzg() {
            return this.zzx;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public int zzh() {
            return this.zzw;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public zzq zzi() {
            zzq zzqVarZzb = zzq.zzb(this.zzp);
            return zzqVarZzb == null ? zzq.ENUM_UNKNOWN : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzak
        public zzq zzj() {
            zzq zzqVarZzb = zzq.zzb(this.zzo);
            return zzqVarZzb == null ? zzq.ENUM_UNKNOWN : zzqVarZzb;
        }
    }

    public final class zzai extends zzgzh<zzai, zza> implements zzaj {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzai zzc;
        private static volatile zzhba<zzai> zzd;
        private int zze;
        private int zzf;
        private int zzg;

        public final class zza extends zzgzb<zzai, zza> implements zzaj {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaj
            public int zza() {
                return ((zzai) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaj
            public int zzb() {
                return ((zzai) this.zza).zzb();
            }

            public zza zzc() {
                zzbu();
                ((zzai) this.zza).zzA();
                return this;
            }

            public zza zzd() {
                zzbu();
                ((zzai) this.zza).zzB();
                return this;
            }

            public zza zze(int i) {
                zzbu();
                ((zzai) this.zza).zzC(i);
                return this;
            }

            public zza zzf(int i) {
                zzbu();
                ((zzai) this.zza).zzD(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaj
            public boolean zzg() {
                return ((zzai) this.zza).zzg();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaj
            public boolean zzh() {
                return ((zzai) this.zza).zzh();
            }

            private zza() {
                super(zzai.zzc);
            }
        }

        static {
            zzai zzaiVar = new zzai();
            zzc = zzaiVar;
            zzgzh.zzbZ(zzai.class, zzaiVar);
        }

        private zzai() {
        }

        public void zzA() {
            this.zze &= -2;
            this.zzf = 0;
        }

        public void zzB() {
            this.zze &= -3;
            this.zzg = 0;
        }

        public void zzC(int i) {
            this.zze |= 1;
            this.zzf = i;
        }

        public void zzD(int i) {
            this.zze |= 2;
            this.zzg = i;
        }

        public static zza zzc() {
            return (zza) zzc.zzaZ();
        }

        public static zza zzd(zzai zzaiVar) {
            return (zza) zzc.zzba(zzaiVar);
        }

        public static zzai zzi() {
            return zzc;
        }

        public static zzai zzj(InputStream inputStream) {
            return (zzai) zzgzh.zzbk(zzc, inputStream);
        }

        public static zzai zzk(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzai) zzgzh.zzbl(zzc, inputStream, zzgyrVar);
        }

        public static zzai zzl(zzgxz zzgxzVar) {
            return (zzai) zzgzh.zzbm(zzc, zzgxzVar);
        }

        public static zzai zzm(zzgyf zzgyfVar) {
            return (zzai) zzgzh.zzbn(zzc, zzgyfVar);
        }

        public static zzai zzn(InputStream inputStream) {
            return (zzai) zzgzh.zzbo(zzc, inputStream);
        }

        public static zzai zzo(ByteBuffer byteBuffer) {
            return (zzai) zzgzh.zzbp(zzc, byteBuffer);
        }

        public static zzai zzp(byte[] bArr) {
            return (zzai) zzgzh.zzbq(zzc, bArr);
        }

        public static zzai zzq(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzai) zzgzh.zzbr(zzc, zzgxzVar, zzgyrVar);
        }

        public static zzai zzr(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzai) zzgzh.zzbs(zzc, zzgyfVar, zzgyrVar);
        }

        public static zzai zzs(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzai) zzgzh.zzbu(zzc, inputStream, zzgyrVar);
        }

        public static zzai zzt(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzai) zzgzh.zzbv(zzc, byteBuffer, zzgyrVar);
        }

        public static zzai zzu(byte[] bArr, zzgyr zzgyrVar) {
            return (zzai) zzgzh.zzbx(zzc, bArr, zzgyrVar);
        }

        public static zzhba<zzai> zzv() {
            return zzc.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaj
        public int zza() {
            return this.zzf;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaj
        public int zzb() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zze", "zzf", "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzai();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzc;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzai> zzgzcVar = zzd;
            if (zzgzcVar == null) {
                synchronized (zzai.class) {
                    try {
                        zzgzcVar = zzd;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzc);
                            zzd = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaj
        public boolean zzg() {
            return (this.zze & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaj
        public boolean zzh() {
            return (this.zze & 2) != 0;
        }
    }

    public interface zzaj extends zzhat {
        int zza();

        int zzb();

        boolean zzg();

        boolean zzh();
    }

    public interface zzak extends zzhat {
        zzai zzI();

        boolean zzJ();

        boolean zzK();

        boolean zzL();

        boolean zzM();

        boolean zzN();

        boolean zzO();

        boolean zzP();

        boolean zzQ();

        boolean zzR();

        boolean zzS();

        boolean zzT();

        int zza();

        int zzb();

        int zzc();

        int zzd();

        int zze();

        int zzf();

        int zzg();

        int zzh();

        zzq zzi();

        zzq zzj();
    }

    public final class zzal extends zzgzh<zzal, zza> implements zzam {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzal zzc;
        private static volatile zzhba<zzal> zzd;
        private int zze;
        private int zzf;
        private int zzg;

        public final class zza extends zzgzb<zzal, zza> implements zzam {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzam
            public int zza() {
                return ((zzal) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzam
            public int zzb() {
                return ((zzal) this.zza).zzb();
            }

            public zza zzc() {
                zzbu();
                ((zzal) this.zza).zzA();
                return this;
            }

            public zza zzd() {
                zzbu();
                ((zzal) this.zza).zzB();
                return this;
            }

            public zza zze(int i) {
                zzbu();
                ((zzal) this.zza).zzC(i);
                return this;
            }

            public zza zzf(int i) {
                zzbu();
                ((zzal) this.zza).zzD(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzam
            public boolean zzg() {
                return ((zzal) this.zza).zzg();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzam
            public boolean zzh() {
                return ((zzal) this.zza).zzh();
            }

            private zza() {
                super(zzal.zzc);
            }
        }

        static {
            zzal zzalVar = new zzal();
            zzc = zzalVar;
            zzgzh.zzbZ(zzal.class, zzalVar);
        }

        private zzal() {
        }

        public void zzA() {
            this.zze &= -3;
            this.zzg = 0;
        }

        public void zzB() {
            this.zze &= -2;
            this.zzf = 0;
        }

        public void zzC(int i) {
            this.zze |= 2;
            this.zzg = i;
        }

        public void zzD(int i) {
            this.zze |= 1;
            this.zzf = i;
        }

        public static zza zzc() {
            return (zza) zzc.zzaZ();
        }

        public static zza zzd(zzal zzalVar) {
            return (zza) zzc.zzba(zzalVar);
        }

        public static zzal zzi() {
            return zzc;
        }

        public static zzal zzj(InputStream inputStream) {
            return (zzal) zzgzh.zzbk(zzc, inputStream);
        }

        public static zzal zzk(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzal) zzgzh.zzbl(zzc, inputStream, zzgyrVar);
        }

        public static zzal zzl(zzgxz zzgxzVar) {
            return (zzal) zzgzh.zzbm(zzc, zzgxzVar);
        }

        public static zzal zzm(zzgyf zzgyfVar) {
            return (zzal) zzgzh.zzbn(zzc, zzgyfVar);
        }

        public static zzal zzn(InputStream inputStream) {
            return (zzal) zzgzh.zzbo(zzc, inputStream);
        }

        public static zzal zzo(ByteBuffer byteBuffer) {
            return (zzal) zzgzh.zzbp(zzc, byteBuffer);
        }

        public static zzal zzp(byte[] bArr) {
            return (zzal) zzgzh.zzbq(zzc, bArr);
        }

        public static zzal zzq(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzal) zzgzh.zzbr(zzc, zzgxzVar, zzgyrVar);
        }

        public static zzal zzr(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzal) zzgzh.zzbs(zzc, zzgyfVar, zzgyrVar);
        }

        public static zzal zzs(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzal) zzgzh.zzbu(zzc, inputStream, zzgyrVar);
        }

        public static zzal zzt(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzal) zzgzh.zzbv(zzc, byteBuffer, zzgyrVar);
        }

        public static zzal zzu(byte[] bArr, zzgyr zzgyrVar) {
            return (zzal) zzgzh.zzbx(zzc, bArr, zzgyrVar);
        }

        public static zzhba<zzal> zzv() {
            return zzc.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzam
        public int zza() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzam
        public int zzb() {
            return this.zzf;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zze", "zzf", "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzal();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzc;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzal> zzgzcVar = zzd;
            if (zzgzcVar == null) {
                synchronized (zzal.class) {
                    try {
                        zzgzcVar = zzd;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzc);
                            zzd = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzam
        public boolean zzg() {
            return (this.zze & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzam
        public boolean zzh() {
            return (this.zze & 1) != 0;
        }
    }

    public interface zzam extends zzhat {
        int zza();

        int zzb();

        boolean zzg();

        boolean zzh();
    }

    public final class zzan extends zzgzh<zzan, zza> implements zzao {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzan zzd;
        private static volatile zzhba<zzan> zze;
        private int zzf;
        private String zzg = "";
        private int zzh;
        private zzap zzi;

        public final class zza extends zzgzb<zzan, zza> implements zzao {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzao
            public zzq zza() {
                return ((zzan) this.zza).zza();
            }

            public zza zzb() {
                zzbu();
                ((zzan) this.zza).zzH();
                return this;
            }

            public zza zzc() {
                zzbu();
                ((zzan) this.zza).zzI();
                return this;
            }

            public zza zzd() {
                zzbu();
                ((zzan) this.zza).zzJ();
                return this;
            }

            public zza zze(zzap zzapVar) {
                zzbu();
                ((zzan) this.zza).zzK(zzapVar);
                return this;
            }

            public zza zzf(String str) {
                zzbu();
                ((zzan) this.zza).zzL(str);
                return this;
            }

            public zza zzg(zzgxz zzgxzVar) {
                zzbu();
                ((zzan) this.zza).zzM(zzgxzVar);
                return this;
            }

            public zza zzh(zzap.zza zzaVar) {
                zzbu();
                ((zzan) this.zza).zzN(zzaVar.zzbr());
                return this;
            }

            public zza zzi(zzap zzapVar) {
                zzbu();
                ((zzan) this.zza).zzN(zzapVar);
                return this;
            }

            public zza zzj(zzq zzqVar) {
                zzbu();
                ((zzan) this.zza).zzO(zzqVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzao
            public zzap zzk() {
                return ((zzan) this.zza).zzk();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzao
            public zzgxz zzl() {
                return ((zzan) this.zza).zzl();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzao
            public String zzm() {
                return ((zzan) this.zza).zzm();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzao
            public boolean zzn() {
                return ((zzan) this.zza).zzn();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzao
            public boolean zzo() {
                return ((zzan) this.zza).zzo();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzao
            public boolean zzp() {
                return ((zzan) this.zza).zzp();
            }

            private zza() {
                super(zzan.zzd);
            }
        }

        static {
            zzan zzanVar = new zzan();
            zzd = zzanVar;
            zzgzh.zzbZ(zzan.class, zzanVar);
        }

        private zzan() {
        }

        public void zzH() {
            this.zzf &= -2;
            this.zzg = zzf().zzm();
        }

        public void zzI() {
            this.zzi = null;
            this.zzf &= -5;
        }

        public void zzJ() {
            this.zzf &= -3;
            this.zzh = 0;
        }

        public void zzK(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzi;
            if (zzapVar2 != null && zzapVar2 != zzap.zzi()) {
                zzap.zza zzaVarZzd = zzap.zzd(zzapVar2);
                zzaVarZzd.zzbj(zzapVar);
                zzapVar = zzaVarZzd.zzbs();
            }
            this.zzi = zzapVar;
            this.zzf |= 4;
        }

        public void zzL(String str) {
            str.getClass();
            this.zzf |= 1;
            this.zzg = str;
        }

        public void zzM(zzgxz zzgxzVar) {
            this.zzg = zzgxzVar.zzx();
            this.zzf |= 1;
        }

        public void zzN(zzap zzapVar) {
            zzapVar.getClass();
            this.zzi = zzapVar;
            this.zzf |= 4;
        }

        public void zzO(zzq zzqVar) {
            this.zzh = zzqVar.zza();
            this.zzf |= 2;
        }

        public static zza zzb() {
            return (zza) zzd.zzaZ();
        }

        public static zza zzc(zzan zzanVar) {
            return (zza) zzd.zzba(zzanVar);
        }

        public static zzan zzf() {
            return zzd;
        }

        public static zzan zzg(InputStream inputStream) {
            return (zzan) zzgzh.zzbk(zzd, inputStream);
        }

        public static zzan zzh(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzan) zzgzh.zzbl(zzd, inputStream, zzgyrVar);
        }

        public static zzan zzi(zzgxz zzgxzVar) {
            return (zzan) zzgzh.zzbm(zzd, zzgxzVar);
        }

        public static zzan zzj(zzgyf zzgyfVar) {
            return (zzan) zzgzh.zzbn(zzd, zzgyfVar);
        }

        public static zzan zzq(InputStream inputStream) {
            return (zzan) zzgzh.zzbo(zzd, inputStream);
        }

        public static zzan zzr(ByteBuffer byteBuffer) {
            return (zzan) zzgzh.zzbp(zzd, byteBuffer);
        }

        public static zzan zzs(byte[] bArr) {
            return (zzan) zzgzh.zzbq(zzd, bArr);
        }

        public static zzan zzt(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzan) zzgzh.zzbr(zzd, zzgxzVar, zzgyrVar);
        }

        public static zzan zzu(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzan) zzgzh.zzbs(zzd, zzgyfVar, zzgyrVar);
        }

        public static zzan zzv(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzan) zzgzh.zzbu(zzd, inputStream, zzgyrVar);
        }

        public static zzan zzw(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzan) zzgzh.zzbv(zzd, byteBuffer, zzgyrVar);
        }

        public static zzan zzx(byte[] bArr, zzgyr zzgyrVar) {
            return (zzan) zzgzh.zzbx(zzd, bArr, zzgyrVar);
        }

        public static zzhba<zzan> zzy() {
            return zzd.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzao
        public zzq zza() {
            zzq zzqVarZzb = zzq.zzb(this.zzh);
            return zzqVarZzb == null ? zzq.ENUM_FALSE : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzd, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဉ\u0002", new Object[]{"zzf", "zzg", "zzh", zzq.zze(), "zzi"});
            }
            if (iOrdinal == 3) {
                return new zzan();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzd;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzan> zzgzcVar = zze;
            if (zzgzcVar == null) {
                synchronized (zzan.class) {
                    try {
                        zzgzcVar = zze;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzd);
                            zze = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzao
        public zzap zzk() {
            zzap zzapVar = this.zzi;
            return zzapVar == null ? zzap.zzi() : zzapVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzao
        public zzgxz zzl() {
            return zzgxz.zzw(this.zzg);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzao
        public String zzm() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzao
        public boolean zzn() {
            return (this.zzf & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzao
        public boolean zzo() {
            return (this.zzf & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzao
        public boolean zzp() {
            return (this.zzf & 2) != 0;
        }
    }

    public interface zzao extends zzhat {
        zzq zza();

        zzap zzk();

        zzgxz zzl();

        String zzm();

        boolean zzn();

        boolean zzo();

        boolean zzp();
    }

    public final class zzap extends zzgzh<zzap, zza> implements zzaq {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzap zzc;
        private static volatile zzhba<zzap> zzd;
        private int zze;
        private int zzf;
        private int zzg;

        public final class zza extends zzgzb<zzap, zza> implements zzaq {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaq
            public int zza() {
                return ((zzap) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaq
            public int zzb() {
                return ((zzap) this.zza).zzb();
            }

            public zza zzc() {
                zzbu();
                ((zzap) this.zza).zzA();
                return this;
            }

            public zza zzd() {
                zzbu();
                ((zzap) this.zza).zzB();
                return this;
            }

            public zza zze(int i) {
                zzbu();
                ((zzap) this.zza).zzC(i);
                return this;
            }

            public zza zzf(int i) {
                zzbu();
                ((zzap) this.zza).zzD(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaq
            public boolean zzg() {
                return ((zzap) this.zza).zzg();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaq
            public boolean zzh() {
                return ((zzap) this.zza).zzh();
            }

            private zza() {
                super(zzap.zzc);
            }
        }

        static {
            zzap zzapVar = new zzap();
            zzc = zzapVar;
            zzgzh.zzbZ(zzap.class, zzapVar);
        }

        private zzap() {
        }

        public void zzA() {
            this.zze &= -3;
            this.zzg = 0;
        }

        public void zzB() {
            this.zze &= -2;
            this.zzf = 0;
        }

        public void zzC(int i) {
            this.zze |= 2;
            this.zzg = i;
        }

        public void zzD(int i) {
            this.zze |= 1;
            this.zzf = i;
        }

        public static zza zzc() {
            return (zza) zzc.zzaZ();
        }

        public static zza zzd(zzap zzapVar) {
            return (zza) zzc.zzba(zzapVar);
        }

        public static zzap zzi() {
            return zzc;
        }

        public static zzap zzj(InputStream inputStream) {
            return (zzap) zzgzh.zzbk(zzc, inputStream);
        }

        public static zzap zzk(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzap) zzgzh.zzbl(zzc, inputStream, zzgyrVar);
        }

        public static zzap zzl(zzgxz zzgxzVar) {
            return (zzap) zzgzh.zzbm(zzc, zzgxzVar);
        }

        public static zzap zzm(zzgyf zzgyfVar) {
            return (zzap) zzgzh.zzbn(zzc, zzgyfVar);
        }

        public static zzap zzn(InputStream inputStream) {
            return (zzap) zzgzh.zzbo(zzc, inputStream);
        }

        public static zzap zzo(ByteBuffer byteBuffer) {
            return (zzap) zzgzh.zzbp(zzc, byteBuffer);
        }

        public static zzap zzp(byte[] bArr) {
            return (zzap) zzgzh.zzbq(zzc, bArr);
        }

        public static zzap zzq(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzap) zzgzh.zzbr(zzc, zzgxzVar, zzgyrVar);
        }

        public static zzap zzr(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzap) zzgzh.zzbs(zzc, zzgyfVar, zzgyrVar);
        }

        public static zzap zzs(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzap) zzgzh.zzbu(zzc, inputStream, zzgyrVar);
        }

        public static zzap zzt(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzap) zzgzh.zzbv(zzc, byteBuffer, zzgyrVar);
        }

        public static zzap zzu(byte[] bArr, zzgyr zzgyrVar) {
            return (zzap) zzgzh.zzbx(zzc, bArr, zzgyrVar);
        }

        public static zzhba<zzap> zzv() {
            return zzc.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaq
        public int zza() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaq
        public int zzb() {
            return this.zzf;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zze", "zzf", "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzap();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzc;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzap> zzgzcVar = zzd;
            if (zzgzcVar == null) {
                synchronized (zzap.class) {
                    try {
                        zzgzcVar = zzd;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzc);
                            zzd = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaq
        public boolean zzg() {
            return (this.zze & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaq
        public boolean zzh() {
            return (this.zze & 1) != 0;
        }
    }

    public interface zzaq extends zzhat {
        int zza();

        int zzb();

        boolean zzg();

        boolean zzh();
    }

    public final class zzar extends zzgzh<zzar, zza> implements zzas {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzar zzd;
        private static volatile zzhba<zzar> zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;

        public final class zza extends zzgzb<zzar, zza> implements zzas {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzas
            public int zza() {
                return ((zzar) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzas
            public int zzb() {
                return ((zzar) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzas
            public int zzc() {
                return ((zzar) this.zza).zzc();
            }

            public zza zzd() {
                zzbu();
                ((zzar) this.zza).zzE();
                return this;
            }

            public zza zze() {
                zzbu();
                ((zzar) this.zza).zzF();
                return this;
            }

            public zza zzf() {
                zzbu();
                ((zzar) this.zza).zzG();
                return this;
            }

            public zza zzg(int i) {
                zzbu();
                ((zzar) this.zza).zzH(i);
                return this;
            }

            public zza zzh(int i) {
                zzbu();
                ((zzar) this.zza).zzI(i);
                return this;
            }

            public zza zzi(int i) {
                zzbu();
                ((zzar) this.zza).zzJ(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzas
            public boolean zzj() {
                return ((zzar) this.zza).zzj();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzas
            public boolean zzk() {
                return ((zzar) this.zza).zzk();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzas
            public boolean zzl() {
                return ((zzar) this.zza).zzl();
            }

            private zza() {
                super(zzar.zzd);
            }
        }

        static {
            zzar zzarVar = new zzar();
            zzd = zzarVar;
            zzgzh.zzbZ(zzar.class, zzarVar);
        }

        private zzar() {
        }

        public void zzE() {
            this.zzf &= -2;
            this.zzg = 0;
        }

        public void zzF() {
            this.zzf &= -5;
            this.zzi = 0;
        }

        public void zzG() {
            this.zzf &= -3;
            this.zzh = 0;
        }

        public void zzH(int i) {
            this.zzf |= 1;
            this.zzg = i;
        }

        public void zzI(int i) {
            this.zzf |= 4;
            this.zzi = i;
        }

        public void zzJ(int i) {
            this.zzf |= 2;
            this.zzh = i;
        }

        public static zza zzd() {
            return (zza) zzd.zzaZ();
        }

        public static zza zzf(zzar zzarVar) {
            return (zza) zzd.zzba(zzarVar);
        }

        public static zzar zzh() {
            return zzd;
        }

        public static zzar zzi(InputStream inputStream) {
            return (zzar) zzgzh.zzbk(zzd, inputStream);
        }

        public static zzar zzm(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzar) zzgzh.zzbl(zzd, inputStream, zzgyrVar);
        }

        public static zzar zzn(zzgxz zzgxzVar) {
            return (zzar) zzgzh.zzbm(zzd, zzgxzVar);
        }

        public static zzar zzo(zzgyf zzgyfVar) {
            return (zzar) zzgzh.zzbn(zzd, zzgyfVar);
        }

        public static zzar zzp(InputStream inputStream) {
            return (zzar) zzgzh.zzbo(zzd, inputStream);
        }

        public static zzar zzq(ByteBuffer byteBuffer) {
            return (zzar) zzgzh.zzbp(zzd, byteBuffer);
        }

        public static zzar zzr(byte[] bArr) {
            return (zzar) zzgzh.zzbq(zzd, bArr);
        }

        public static zzar zzs(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzar) zzgzh.zzbr(zzd, zzgxzVar, zzgyrVar);
        }

        public static zzar zzt(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzar) zzgzh.zzbs(zzd, zzgyfVar, zzgyrVar);
        }

        public static zzar zzu(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzar) zzgzh.zzbu(zzd, inputStream, zzgyrVar);
        }

        public static zzar zzv(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzar) zzgzh.zzbv(zzd, byteBuffer, zzgyrVar);
        }

        public static zzar zzw(byte[] bArr, zzgyr zzgyrVar) {
            return (zzar) zzgzh.zzbx(zzd, bArr, zzgyrVar);
        }

        public static zzhba<zzar> zzx() {
            return zzd.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzas
        public int zza() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzas
        public int zzb() {
            return this.zzi;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzas
        public int zzc() {
            return this.zzh;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzd, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzf", "zzg", "zzh", "zzi"});
            }
            if (iOrdinal == 3) {
                return new zzar();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzd;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzar> zzgzcVar = zze;
            if (zzgzcVar == null) {
                synchronized (zzar.class) {
                    try {
                        zzgzcVar = zze;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzd);
                            zze = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzas
        public boolean zzj() {
            return (this.zzf & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzas
        public boolean zzk() {
            return (this.zzf & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzas
        public boolean zzl() {
            return (this.zzf & 2) != 0;
        }
    }

    public interface zzas extends zzhat {
        int zza();

        int zzb();

        int zzc();

        boolean zzj();

        boolean zzk();

        boolean zzl();
    }

    public final class zzat extends zzgzh<zzat, zza> implements zzbi {
        public static final int zza = 5;
        public static final int zzb = 6;
        public static final int zzc = 7;
        public static final int zzd = 8;
        public static final int zze = 9;
        public static final int zzf = 10;
        public static final int zzg = 11;
        public static final int zzh = 12;
        public static final int zzi = 13;
        public static final int zzj = 14;
        public static final int zzk = 15;
        public static final int zzl = 16;
        public static final int zzm = 17;
        public static final int zzn = 18;
        public static final int zzo = 19;
        public static final int zzp = 20;
        private static final zzat zzu;
        private static volatile zzhba<zzat> zzv;
        private zzbj zzA;
        private zzau zzB;
        private zzbc zzC;
        private zzay zzD;
        private int zzE;
        private int zzF;
        private zzap zzG;
        private int zzH;
        private int zzI;
        private int zzJ;
        private int zzK;
        private int zzL;
        private long zzM;
        private int zzw;
        private zzba zzx;
        private zzbe zzy;
        private zzbg zzz;

        public final class zza extends zzgzb<zzat, zza> implements zzbi {
            public /* synthetic */ zza() {
                this();
            }

            public zza zzA(zzay zzayVar) {
                zzbu();
                ((zzat) this.zza).zzcw(zzayVar);
                return this;
            }

            public zza zzB(zzba zzbaVar) {
                zzbu();
                ((zzat) this.zza).zzcx(zzbaVar);
                return this;
            }

            public zza zzC(zzbc zzbcVar) {
                zzbu();
                ((zzat) this.zza).zzcy(zzbcVar);
                return this;
            }

            public zza zzD(zzbe zzbeVar) {
                zzbu();
                ((zzat) this.zza).zzcz(zzbeVar);
                return this;
            }

            public zza zzE(zzbg zzbgVar) {
                zzbu();
                ((zzat) this.zza).zzcA(zzbgVar);
                return this;
            }

            public zza zzF(zzap zzapVar) {
                zzbu();
                ((zzat) this.zza).zzcB(zzapVar);
                return this;
            }

            public zza zzG(zzbj zzbjVar) {
                zzbu();
                ((zzat) this.zza).zzcC(zzbjVar);
                return this;
            }

            public zza zzH(zzau.zza zzaVar) {
                zzbu();
                ((zzat) this.zza).zzcD(zzaVar.zzbr());
                return this;
            }

            public zza zzI(zzau zzauVar) {
                zzbu();
                ((zzat) this.zza).zzcD(zzauVar);
                return this;
            }

            public zza zzJ(zzay.zza zzaVar) {
                zzbu();
                ((zzat) this.zza).zzcE(zzaVar.zzbr());
                return this;
            }

            public zza zzK(zzay zzayVar) {
                zzbu();
                ((zzat) this.zza).zzcE(zzayVar);
                return this;
            }

            public zza zzL(zzba.zza zzaVar) {
                zzbu();
                ((zzat) this.zza).zzcF(zzaVar.zzbr());
                return this;
            }

            public zza zzM(zzba zzbaVar) {
                zzbu();
                ((zzat) this.zza).zzcF(zzbaVar);
                return this;
            }

            public zza zzN(zzbc.zza zzaVar) {
                zzbu();
                ((zzat) this.zza).zzcG(zzaVar.zzbr());
                return this;
            }

            public zza zzO(zzbc zzbcVar) {
                zzbu();
                ((zzat) this.zza).zzcG(zzbcVar);
                return this;
            }

            public zza zzP(zzbe.zza zzaVar) {
                zzbu();
                ((zzat) this.zza).zzcH(zzaVar.zzbr());
                return this;
            }

            public zza zzQ(zzbe zzbeVar) {
                zzbu();
                ((zzat) this.zza).zzcH(zzbeVar);
                return this;
            }

            public zza zzR(zzbg.zza zzaVar) {
                zzbu();
                ((zzat) this.zza).zzcI(zzaVar.zzbr());
                return this;
            }

            public zza zzS(zzbg zzbgVar) {
                zzbu();
                ((zzat) this.zza).zzcI(zzbgVar);
                return this;
            }

            public zza zzT(int i) {
                zzbu();
                ((zzat) this.zza).zzcJ(i);
                return this;
            }

            public zza zzU(int i) {
                zzbu();
                ((zzat) this.zza).zzcK(i);
                return this;
            }

            public zza zzV(int i) {
                zzbu();
                ((zzat) this.zza).zzcL(i);
                return this;
            }

            public zza zzW(int i) {
                zzbu();
                ((zzat) this.zza).zzcM(i);
                return this;
            }

            public zza zzX(int i) {
                zzbu();
                ((zzat) this.zza).zzcN(i);
                return this;
            }

            public zza zzY(int i) {
                zzbu();
                ((zzat) this.zza).zzcO(i);
                return this;
            }

            public zza zzZ(int i) {
                zzbu();
                ((zzat) this.zza).zzcP(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public int zza() {
                return ((zzat) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public boolean zzaA() {
                return ((zzat) this.zza).zzaA();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public boolean zzaB() {
                return ((zzat) this.zza).zzaB();
            }

            public zza zzaa(zzap.zza zzaVar) {
                zzbu();
                ((zzat) this.zza).zzcQ(zzaVar.zzbr());
                return this;
            }

            public zza zzab(zzap zzapVar) {
                zzbu();
                ((zzat) this.zza).zzcQ(zzapVar);
                return this;
            }

            public zza zzac(long j) {
                zzbu();
                ((zzat) this.zza).zzcR(j);
                return this;
            }

            public zza zzad(zzbj.zza zzaVar) {
                zzbu();
                ((zzat) this.zza).zzcS(zzaVar.zzbr());
                return this;
            }

            public zza zzae(zzbj zzbjVar) {
                zzbu();
                ((zzat) this.zza).zzcS(zzbjVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public zzau zzaf() {
                return ((zzat) this.zza).zzaf();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public zzay zzag() {
                return ((zzat) this.zza).zzag();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public zzba zzah() {
                return ((zzat) this.zza).zzah();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public zzbc zzai() {
                return ((zzat) this.zza).zzai();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public zzbe zzaj() {
                return ((zzat) this.zza).zzaj();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public zzbg zzak() {
                return ((zzat) this.zza).zzak();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public zzbj zzal() {
                return ((zzat) this.zza).zzal();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public boolean zzam() {
                return ((zzat) this.zza).zzam();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public boolean zzan() {
                return ((zzat) this.zza).zzan();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public boolean zzao() {
                return ((zzat) this.zza).zzao();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public boolean zzap() {
                return ((zzat) this.zza).zzap();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public boolean zzaq() {
                return ((zzat) this.zza).zzaq();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public boolean zzar() {
                return ((zzat) this.zza).zzar();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public boolean zzas() {
                return ((zzat) this.zza).zzas();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public boolean zzat() {
                return ((zzat) this.zza).zzat();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public boolean zzau() {
                return ((zzat) this.zza).zzau();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public boolean zzav() {
                return ((zzat) this.zza).zzav();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public boolean zzaw() {
                return ((zzat) this.zza).zzaw();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public boolean zzax() {
                return ((zzat) this.zza).zzax();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public boolean zzay() {
                return ((zzat) this.zza).zzay();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public boolean zzaz() {
                return ((zzat) this.zza).zzaz();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public int zzb() {
                return ((zzat) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public int zzc() {
                return ((zzat) this.zza).zzc();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public int zzd() {
                return ((zzat) this.zza).zzd();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public int zze() {
                return ((zzat) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public int zzf() {
                return ((zzat) this.zza).zzf();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public int zzg() {
                return ((zzat) this.zza).zzg();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public long zzh() {
                return ((zzat) this.zza).zzh();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
            public zzap zzi() {
                return ((zzat) this.zza).zzi();
            }

            public zza zzj() {
                zzbu();
                ((zzat) this.zza).zzcf();
                return this;
            }

            public zza zzk() {
                zzbu();
                ((zzat) this.zza).zzcg();
                return this;
            }

            public zza zzl() {
                zzbu();
                ((zzat) this.zza).zzch();
                return this;
            }

            public zza zzm() {
                zzbu();
                ((zzat) this.zza).zzci();
                return this;
            }

            public zza zzn() {
                zzbu();
                ((zzat) this.zza).zzcj();
                return this;
            }

            public zza zzo() {
                zzbu();
                ((zzat) this.zza).zzck();
                return this;
            }

            public zza zzp() {
                zzbu();
                ((zzat) this.zza).zzcl();
                return this;
            }

            public zza zzq() {
                zzbu();
                ((zzat) this.zza).zzcm();
                return this;
            }

            public zza zzr() {
                zzbu();
                ((zzat) this.zza).zzcn();
                return this;
            }

            public zza zzs() {
                zzbu();
                ((zzat) this.zza).zzco();
                return this;
            }

            public zza zzt() {
                zzbu();
                ((zzat) this.zza).zzcp();
                return this;
            }

            public zza zzu() {
                zzbu();
                ((zzat) this.zza).zzcq();
                return this;
            }

            public zza zzv() {
                zzbu();
                ((zzat) this.zza).zzcr();
                return this;
            }

            public zza zzw() {
                zzbu();
                ((zzat) this.zza).zzcs();
                return this;
            }

            public zza zzx() {
                zzbu();
                ((zzat) this.zza).zzct();
                return this;
            }

            public zza zzy() {
                zzbu();
                ((zzat) this.zza).zzcu();
                return this;
            }

            public zza zzz(zzau zzauVar) {
                zzbu();
                ((zzat) this.zza).zzcv(zzauVar);
                return this;
            }

            private zza() {
                super(zzat.zzu);
            }
        }

        static {
            zzat zzatVar = new zzat();
            zzu = zzatVar;
            zzgzh.zzbZ(zzat.class, zzatVar);
        }

        private zzat() {
        }

        public void zzcA(zzbg zzbgVar) {
            zzbgVar.getClass();
            zzbg zzbgVar2 = this.zzz;
            if (zzbgVar2 != null && zzbgVar2 != zzbg.zzh()) {
                zzbg.zza zzaVarZzf = zzbg.zzf(zzbgVar2);
                zzaVarZzf.zzbj(zzbgVar);
                zzbgVar = zzaVarZzf.zzbs();
            }
            this.zzz = zzbgVar;
            this.zzw |= 4;
        }

        public void zzcB(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzG;
            if (zzapVar2 != null && zzapVar2 != zzap.zzi()) {
                zzap.zza zzaVarZzd = zzap.zzd(zzapVar2);
                zzaVarZzd.zzbj(zzapVar);
                zzapVar = zzaVarZzd.zzbs();
            }
            this.zzG = zzapVar;
            this.zzw |= 512;
        }

        public void zzcC(zzbj zzbjVar) {
            zzbjVar.getClass();
            zzbj zzbjVar2 = this.zzA;
            if (zzbjVar2 != null && zzbjVar2 != zzbj.zzg()) {
                zzbj.zza zzaVarZzd = zzbj.zzd(zzbjVar2);
                zzaVarZzd.zzbj(zzbjVar);
                zzbjVar = zzaVarZzd.zzbs();
            }
            this.zzA = zzbjVar;
            this.zzw |= 8;
        }

        public void zzcD(zzau zzauVar) {
            zzauVar.getClass();
            this.zzB = zzauVar;
            this.zzw |= 16;
        }

        public void zzcE(zzay zzayVar) {
            zzayVar.getClass();
            this.zzD = zzayVar;
            this.zzw |= 64;
        }

        public void zzcF(zzba zzbaVar) {
            zzbaVar.getClass();
            this.zzx = zzbaVar;
            this.zzw |= 1;
        }

        public void zzcG(zzbc zzbcVar) {
            zzbcVar.getClass();
            this.zzC = zzbcVar;
            this.zzw |= 32;
        }

        public void zzcH(zzbe zzbeVar) {
            zzbeVar.getClass();
            this.zzy = zzbeVar;
            this.zzw |= 2;
        }

        public void zzcI(zzbg zzbgVar) {
            zzbgVar.getClass();
            this.zzz = zzbgVar;
            this.zzw |= 4;
        }

        public void zzcJ(int i) {
            this.zzw |= 8192;
            this.zzK = i;
        }

        public void zzcK(int i) {
            this.zzw |= 16384;
            this.zzL = i;
        }

        public void zzcL(int i) {
            this.zzw |= 1024;
            this.zzH = i;
        }

        public void zzcM(int i) {
            this.zzw |= 128;
            this.zzE = i;
        }

        public void zzcN(int i) {
            this.zzw |= 256;
            this.zzF = i;
        }

        public void zzcO(int i) {
            this.zzw |= 2048;
            this.zzI = i;
        }

        public void zzcP(int i) {
            this.zzw |= 4096;
            this.zzJ = i;
        }

        public void zzcQ(zzap zzapVar) {
            zzapVar.getClass();
            this.zzG = zzapVar;
            this.zzw |= 512;
        }

        public void zzcR(long j) {
            this.zzw |= 32768;
            this.zzM = j;
        }

        public void zzcS(zzbj zzbjVar) {
            zzbjVar.getClass();
            this.zzA = zzbjVar;
            this.zzw |= 8;
        }

        public void zzcf() {
            this.zzB = null;
            this.zzw &= -17;
        }

        public void zzcg() {
            this.zzD = null;
            this.zzw &= -65;
        }

        public void zzch() {
            this.zzx = null;
            this.zzw &= -2;
        }

        public void zzci() {
            this.zzC = null;
            this.zzw &= -33;
        }

        public void zzcj() {
            this.zzy = null;
            this.zzw &= -3;
        }

        public void zzck() {
            this.zzz = null;
            this.zzw &= -5;
        }

        public void zzcl() {
            this.zzw &= -8193;
            this.zzK = 0;
        }

        public void zzcm() {
            this.zzw &= -16385;
            this.zzL = 0;
        }

        public void zzcn() {
            this.zzw &= -1025;
            this.zzH = 0;
        }

        public void zzco() {
            this.zzw &= -129;
            this.zzE = 0;
        }

        public void zzcp() {
            this.zzw &= -257;
            this.zzF = 0;
        }

        public void zzcq() {
            this.zzw &= -2049;
            this.zzI = 0;
        }

        public void zzcr() {
            this.zzw &= -4097;
            this.zzJ = 0;
        }

        public void zzcs() {
            this.zzG = null;
            this.zzw &= -513;
        }

        public void zzct() {
            this.zzw &= -32769;
            this.zzM = 0L;
        }

        public void zzcu() {
            this.zzA = null;
            this.zzw &= -9;
        }

        public void zzcv(zzau zzauVar) {
            zzauVar.getClass();
            zzau zzauVar2 = this.zzB;
            if (zzauVar2 != null && zzauVar2 != zzau.zzg()) {
                zzau.zza zzaVarZzd = zzau.zzd(zzauVar2);
                zzaVarZzd.zzbj(zzauVar);
                zzauVar = zzaVarZzd.zzbs();
            }
            this.zzB = zzauVar;
            this.zzw |= 16;
        }

        public void zzcw(zzay zzayVar) {
            zzayVar.getClass();
            zzay zzayVar2 = this.zzD;
            if (zzayVar2 != null && zzayVar2 != zzay.zzi()) {
                zzay.zza zzaVarZzg = zzay.zzg(zzayVar2);
                zzaVarZzg.zzbj(zzayVar);
                zzayVar = zzaVarZzg.zzbs();
            }
            this.zzD = zzayVar;
            this.zzw |= 64;
        }

        public void zzcx(zzba zzbaVar) {
            zzbaVar.getClass();
            zzba zzbaVar2 = this.zzx;
            if (zzbaVar2 != null && zzbaVar2 != zzba.zzi()) {
                zzba.zza zzaVarZzg = zzba.zzg(zzbaVar2);
                zzaVarZzg.zzbj(zzbaVar);
                zzbaVar = zzaVarZzg.zzbs();
            }
            this.zzx = zzbaVar;
            this.zzw |= 1;
        }

        public void zzcy(zzbc zzbcVar) {
            zzbcVar.getClass();
            zzbc zzbcVar2 = this.zzC;
            if (zzbcVar2 != null && zzbcVar2 != zzbc.zzh()) {
                zzbc.zza zzaVarZzf = zzbc.zzf(zzbcVar2);
                zzaVarZzf.zzbj(zzbcVar);
                zzbcVar = zzaVarZzf.zzbs();
            }
            this.zzC = zzbcVar;
            this.zzw |= 32;
        }

        public void zzcz(zzbe zzbeVar) {
            zzbeVar.getClass();
            zzbe zzbeVar2 = this.zzy;
            if (zzbeVar2 != null && zzbeVar2 != zzbe.zzj()) {
                zzbe.zza zzaVarZzh = zzbe.zzh(zzbeVar2);
                zzaVarZzh.zzbj(zzbeVar);
                zzbeVar = zzaVarZzh.zzbs();
            }
            this.zzy = zzbeVar;
            this.zzw |= 2;
        }

        public static zza zzj() {
            return (zza) zzu.zzaZ();
        }

        public static zza zzk(zzat zzatVar) {
            return (zza) zzu.zzba(zzatVar);
        }

        public static zzat zzm() {
            return zzu;
        }

        public static zzat zzn(InputStream inputStream) {
            return (zzat) zzgzh.zzbk(zzu, inputStream);
        }

        public static zzat zzo(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzat) zzgzh.zzbl(zzu, inputStream, zzgyrVar);
        }

        public static zzat zzp(zzgxz zzgxzVar) {
            return (zzat) zzgzh.zzbm(zzu, zzgxzVar);
        }

        public static zzat zzq(zzgyf zzgyfVar) {
            return (zzat) zzgzh.zzbn(zzu, zzgyfVar);
        }

        public static zzat zzr(InputStream inputStream) {
            return (zzat) zzgzh.zzbo(zzu, inputStream);
        }

        public static zzat zzs(ByteBuffer byteBuffer) {
            return (zzat) zzgzh.zzbp(zzu, byteBuffer);
        }

        public static zzat zzt(byte[] bArr) {
            return (zzat) zzgzh.zzbq(zzu, bArr);
        }

        public static zzat zzu(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzat) zzgzh.zzbr(zzu, zzgxzVar, zzgyrVar);
        }

        public static zzat zzv(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzat) zzgzh.zzbs(zzu, zzgyfVar, zzgyrVar);
        }

        public static zzat zzw(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzat) zzgzh.zzbu(zzu, inputStream, zzgyrVar);
        }

        public static zzat zzx(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzat) zzgzh.zzbv(zzu, byteBuffer, zzgyrVar);
        }

        public static zzat zzy(byte[] bArr, zzgyr zzgyrVar) {
            return (zzat) zzgzh.zzbx(zzu, bArr, zzgyrVar);
        }

        public static zzhba<zzat> zzz() {
            return zzu.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public int zza() {
            return this.zzK;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public boolean zzaA() {
            return (this.zzw & 32768) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public boolean zzaB() {
            return (this.zzw & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public zzau zzaf() {
            zzau zzauVar = this.zzB;
            return zzauVar == null ? zzau.zzg() : zzauVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public zzay zzag() {
            zzay zzayVar = this.zzD;
            return zzayVar == null ? zzay.zzi() : zzayVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public zzba zzah() {
            zzba zzbaVar = this.zzx;
            return zzbaVar == null ? zzba.zzi() : zzbaVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public zzbc zzai() {
            zzbc zzbcVar = this.zzC;
            return zzbcVar == null ? zzbc.zzh() : zzbcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public zzbe zzaj() {
            zzbe zzbeVar = this.zzy;
            return zzbeVar == null ? zzbe.zzj() : zzbeVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public zzbg zzak() {
            zzbg zzbgVar = this.zzz;
            return zzbgVar == null ? zzbg.zzh() : zzbgVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public zzbj zzal() {
            zzbj zzbjVar = this.zzA;
            return zzbjVar == null ? zzbj.zzg() : zzbjVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public boolean zzam() {
            return (this.zzw & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public boolean zzan() {
            return (this.zzw & 64) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public boolean zzao() {
            return (this.zzw & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public boolean zzap() {
            return (this.zzw & 32) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public boolean zzaq() {
            return (this.zzw & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public boolean zzar() {
            return (this.zzw & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public boolean zzas() {
            return (this.zzw & 8192) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public boolean zzat() {
            return (this.zzw & 16384) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public boolean zzau() {
            return (this.zzw & 1024) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public boolean zzav() {
            return (this.zzw & 128) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public boolean zzaw() {
            return (this.zzw & 256) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public boolean zzax() {
            return (this.zzw & 2048) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public boolean zzay() {
            return (this.zzw & 4096) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public boolean zzaz() {
            return (this.zzw & 512) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public int zzb() {
            return this.zzL;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public int zzc() {
            return this.zzH;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public int zzd() {
            return this.zzE;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzu, "\u0004\u0010\u0000\u0001\u0005\u0014\u0010\u0000\u0000\u0000\u0005ဉ\u0000\u0006ဉ\u0001\u0007ဉ\u0002\bဉ\u0003\tဉ\u0004\nဉ\u0005\u000bဉ\u0006\fင\u0007\rင\b\u000eဉ\t\u000fင\n\u0010င\u000b\u0011င\f\u0012င\r\u0013င\u000e\u0014ဃ\u000f", new Object[]{"zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzF", "zzG", "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM"});
            }
            if (iOrdinal == 3) {
                return new zzat();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzu;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzat> zzgzcVar = zzv;
            if (zzgzcVar == null) {
                synchronized (zzat.class) {
                    try {
                        zzgzcVar = zzv;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzu);
                            zzv = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public int zze() {
            return this.zzF;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public int zzf() {
            return this.zzI;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public int zzg() {
            return this.zzJ;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public long zzh() {
            return this.zzM;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbi
        public zzap zzi() {
            zzap zzapVar = this.zzG;
            return zzapVar == null ? zzap.zzi() : zzapVar;
        }
    }

    public final class zzau extends zzgzh<zzau, zza> implements zzav {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzau zzd;
        private static volatile zzhba<zzau> zze;
        private int zzf;
        private int zzg = 1000;
        private zzaw zzh;
        private zzap zzi;

        public final class zza extends zzgzb<zzau, zza> implements zzav {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzav
            public zzq zza() {
                return ((zzau) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzav
            public zzap zzb() {
                return ((zzau) this.zza).zzb();
            }

            public zza zzc() {
                zzbu();
                ((zzau) this.zza).zzG();
                return this;
            }

            public zza zzd() {
                zzbu();
                ((zzau) this.zza).zzH();
                return this;
            }

            public zza zze() {
                zzbu();
                ((zzau) this.zza).zzI();
                return this;
            }

            public zza zzf(zzaw zzawVar) {
                zzbu();
                ((zzau) this.zza).zzJ(zzawVar);
                return this;
            }

            public zza zzg(zzap zzapVar) {
                zzbu();
                ((zzau) this.zza).zzK(zzapVar);
                return this;
            }

            public zza zzh(zzaw.zza zzaVar) {
                zzbu();
                ((zzau) this.zza).zzL(zzaVar.zzbr());
                return this;
            }

            public zza zzi(zzaw zzawVar) {
                zzbu();
                ((zzau) this.zza).zzL(zzawVar);
                return this;
            }

            public zza zzj(zzap.zza zzaVar) {
                zzbu();
                ((zzau) this.zza).zzM(zzaVar.zzbr());
                return this;
            }

            public zza zzk(zzap zzapVar) {
                zzbu();
                ((zzau) this.zza).zzM(zzapVar);
                return this;
            }

            public zza zzl(zzq zzqVar) {
                zzbu();
                ((zzau) this.zza).zzN(zzqVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzav
            public zzaw zzm() {
                return ((zzau) this.zza).zzm();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzav
            public boolean zzn() {
                return ((zzau) this.zza).zzn();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzav
            public boolean zzo() {
                return ((zzau) this.zza).zzo();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzav
            public boolean zzp() {
                return ((zzau) this.zza).zzp();
            }

            private zza() {
                super(zzau.zzd);
            }
        }

        static {
            zzau zzauVar = new zzau();
            zzd = zzauVar;
            zzgzh.zzbZ(zzau.class, zzauVar);
        }

        private zzau() {
        }

        public void zzG() {
            this.zzh = null;
            this.zzf &= -3;
        }

        public void zzH() {
            this.zzi = null;
            this.zzf &= -5;
        }

        public void zzI() {
            this.zzf &= -2;
            this.zzg = 1000;
        }

        public void zzJ(zzaw zzawVar) {
            zzawVar.getClass();
            zzaw zzawVar2 = this.zzh;
            if (zzawVar2 != null && zzawVar2 != zzaw.zzg()) {
                zzaw.zza zzaVarZzb = zzaw.zzb(zzawVar2);
                zzaVarZzb.zzbj(zzawVar);
                zzawVar = zzaVarZzb.zzbs();
            }
            this.zzh = zzawVar;
            this.zzf |= 2;
        }

        public void zzK(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzi;
            if (zzapVar2 != null && zzapVar2 != zzap.zzi()) {
                zzap.zza zzaVarZzd = zzap.zzd(zzapVar2);
                zzaVarZzd.zzbj(zzapVar);
                zzapVar = zzaVarZzd.zzbs();
            }
            this.zzi = zzapVar;
            this.zzf |= 4;
        }

        public void zzL(zzaw zzawVar) {
            zzawVar.getClass();
            this.zzh = zzawVar;
            this.zzf |= 2;
        }

        public void zzM(zzap zzapVar) {
            zzapVar.getClass();
            this.zzi = zzapVar;
            this.zzf |= 4;
        }

        public void zzN(zzq zzqVar) {
            this.zzg = zzqVar.zza();
            this.zzf |= 1;
        }

        public static zza zzc() {
            return (zza) zzd.zzaZ();
        }

        public static zza zzd(zzau zzauVar) {
            return (zza) zzd.zzba(zzauVar);
        }

        public static zzau zzg() {
            return zzd;
        }

        public static zzau zzh(InputStream inputStream) {
            return (zzau) zzgzh.zzbk(zzd, inputStream);
        }

        public static zzau zzi(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzau) zzgzh.zzbl(zzd, inputStream, zzgyrVar);
        }

        public static zzau zzj(zzgxz zzgxzVar) {
            return (zzau) zzgzh.zzbm(zzd, zzgxzVar);
        }

        public static zzau zzk(zzgyf zzgyfVar) {
            return (zzau) zzgzh.zzbn(zzd, zzgyfVar);
        }

        public static zzau zzl(InputStream inputStream) {
            return (zzau) zzgzh.zzbo(zzd, inputStream);
        }

        public static zzau zzq(ByteBuffer byteBuffer) {
            return (zzau) zzgzh.zzbp(zzd, byteBuffer);
        }

        public static zzau zzr(byte[] bArr) {
            return (zzau) zzgzh.zzbq(zzd, bArr);
        }

        public static zzau zzs(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzau) zzgzh.zzbr(zzd, zzgxzVar, zzgyrVar);
        }

        public static zzau zzt(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzau) zzgzh.zzbs(zzd, zzgyfVar, zzgyrVar);
        }

        public static zzau zzu(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzau) zzgzh.zzbu(zzd, inputStream, zzgyrVar);
        }

        public static zzau zzv(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzau) zzgzh.zzbv(zzd, byteBuffer, zzgyrVar);
        }

        public static zzau zzw(byte[] bArr, zzgyr zzgyrVar) {
            return (zzau) zzgzh.zzbx(zzd, bArr, zzgyrVar);
        }

        public static zzhba<zzau> zzx() {
            return zzd.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzav
        public zzq zza() {
            zzq zzqVarZzb = zzq.zzb(this.zzg);
            return zzqVarZzb == null ? zzq.ENUM_UNKNOWN : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzav
        public zzap zzb() {
            zzap zzapVar = this.zzi;
            return zzapVar == null ? zzap.zzi() : zzapVar;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzd, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzf", "zzg", zzq.zze(), "zzh", "zzi"});
            }
            if (iOrdinal == 3) {
                return new zzau();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzd;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzau> zzgzcVar = zze;
            if (zzgzcVar == null) {
                synchronized (zzau.class) {
                    try {
                        zzgzcVar = zze;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzd);
                            zze = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzav
        public zzaw zzm() {
            zzaw zzawVar = this.zzh;
            return zzawVar == null ? zzaw.zzg() : zzawVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzav
        public boolean zzn() {
            return (this.zzf & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzav
        public boolean zzo() {
            return (this.zzf & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzav
        public boolean zzp() {
            return (this.zzf & 1) != 0;
        }
    }

    public interface zzav extends zzhat {
        zzq zza();

        zzap zzb();

        zzaw zzm();

        boolean zzn();

        boolean zzo();

        boolean zzp();
    }

    public final class zzaw extends zzgzh<zzaw, zza> implements zzax {
        public static final int zza = 1;
        private static final zzaw zzb;
        private static volatile zzhba<zzaw> zzc;
        private int zzd;
        private int zze;

        public final class zza extends zzgzb<zzaw, zza> implements zzax {
            public /* synthetic */ zza() {
                this();
            }

            public zza zza() {
                zzbu();
                ((zzaw) this.zza).zzw();
                return this;
            }

            public zza zzb(zzb zzbVar) {
                zzbu();
                ((zzaw) this.zza).zzx(zzbVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzax
            public zzb zzc() {
                return ((zzaw) this.zza).zzc();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzax
            public boolean zzd() {
                return ((zzaw) this.zza).zzd();
            }

            private zza() {
                super(zzaw.zzb);
            }
        }

        /* JADX INFO: loaded from: classes2.dex */
        public enum zzb implements zzgzl {
            VIDEO_ERROR_CODE_UNSPECIFIED(0),
            OPENGL_RENDERING_FAILED(1),
            zzc(2),
            zzd(3);

            public static final int zze = 0;
            public static final int zzf = 1;
            public static final int zzg = 2;
            public static final int zzh = 3;
            private static final zzgzm<zzb> zzi = new zzgzm<zzb>() { // from class: com.google.android.gms.internal.ads.zzbcj.zzaw.zzb.1
                /* JADX INFO: renamed from: zza */
                public zzb zzb(int i) {
                    return zzb.zzb(i);
                }
            };
            private final int zzk;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zzaw$zzb$1 */
            /* JADX INFO: loaded from: classes.dex */
            public class AnonymousClass1 implements zzgzm<zzb> {
                /* JADX INFO: renamed from: zza */
                public zzb zzb(int i) {
                    return zzb.zzb(i);
                }
            }

            /* JADX INFO: loaded from: classes.dex */
            final class zza implements zzgzn {
                static final zzgzn zza = new zza();

                private zza() {
                }

                @Override // com.google.android.gms.internal.ads.zzgzn
                public boolean zza(int i) {
                    return zzb.zzb(i) != null;
                }
            }

            zzb(int i) {
                this.zzk = i;
            }

            public static zzb zzb(int i) {
                if (i == 0) {
                    return VIDEO_ERROR_CODE_UNSPECIFIED;
                }
                if (i == 1) {
                    return OPENGL_RENDERING_FAILED;
                }
                if (i == 2) {
                    return zzc;
                }
                if (i != 3) {
                    return null;
                }
                return zzd;
            }

            public static zzgzm<zzb> zzd() {
                return zzi;
            }

            public static zzgzn zze() {
                return zza.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.zzk);
            }

            @Override // com.google.android.gms.internal.ads.zzgzl
            public final int zza() {
                return this.zzk;
            }
        }

        static {
            zzaw zzawVar = new zzaw();
            zzb = zzawVar;
            zzgzh.zzbZ(zzaw.class, zzawVar);
        }

        private zzaw() {
        }

        public static zza zza() {
            return (zza) zzb.zzaZ();
        }

        public static zza zzb(zzaw zzawVar) {
            return (zza) zzb.zzba(zzawVar);
        }

        public static zzaw zzg() {
            return zzb;
        }

        public static zzaw zzh(InputStream inputStream) {
            return (zzaw) zzgzh.zzbk(zzb, inputStream);
        }

        public static zzaw zzi(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzaw) zzgzh.zzbl(zzb, inputStream, zzgyrVar);
        }

        public static zzaw zzj(zzgxz zzgxzVar) {
            return (zzaw) zzgzh.zzbm(zzb, zzgxzVar);
        }

        public static zzaw zzk(zzgyf zzgyfVar) {
            return (zzaw) zzgzh.zzbn(zzb, zzgyfVar);
        }

        public static zzaw zzl(InputStream inputStream) {
            return (zzaw) zzgzh.zzbo(zzb, inputStream);
        }

        public static zzaw zzm(ByteBuffer byteBuffer) {
            return (zzaw) zzgzh.zzbp(zzb, byteBuffer);
        }

        public static zzaw zzn(byte[] bArr) {
            return (zzaw) zzgzh.zzbq(zzb, bArr);
        }

        public static zzaw zzo(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzaw) zzgzh.zzbr(zzb, zzgxzVar, zzgyrVar);
        }

        public static zzaw zzp(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzaw) zzgzh.zzbs(zzb, zzgyfVar, zzgyrVar);
        }

        public static zzaw zzq(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzaw) zzgzh.zzbu(zzb, inputStream, zzgyrVar);
        }

        public static zzaw zzr(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzaw) zzgzh.zzbv(zzb, byteBuffer, zzgyrVar);
        }

        public static zzaw zzs(byte[] bArr, zzgyr zzgyrVar) {
            return (zzaw) zzgzh.zzbx(zzb, bArr, zzgyrVar);
        }

        public static zzhba<zzaw> zzt() {
            return zzb.zzbN();
        }

        public void zzw() {
            this.zzd &= -2;
            this.zze = 0;
        }

        public void zzx(zzb zzbVar) {
            this.zze = zzbVar.zza();
            this.zzd |= 1;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzax
        public zzb zzc() {
            zzb zzbVarZzb = zzb.zzb(this.zze);
            return zzbVarZzb == null ? zzb.VIDEO_ERROR_CODE_UNSPECIFIED : zzbVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzax
        public boolean zzd() {
            return (this.zzd & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzb.zze()});
            }
            if (iOrdinal == 3) {
                return new zzaw();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzb;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzaw> zzgzcVar = zzc;
            if (zzgzcVar == null) {
                synchronized (zzaw.class) {
                    try {
                        zzgzcVar = zzc;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzb);
                            zzc = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }
    }

    public interface zzax extends zzhat {
        zzaw.zzb zzc();

        boolean zzd();
    }

    public final class zzay extends zzgzh<zzay, zza> implements zzaz {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        private static final zzay zze;
        private static volatile zzhba<zzay> zzf;
        private int zzg;
        private zzar zzh;
        private int zzi = 1000;
        private zzaw zzj;
        private zzap zzk;

        public final class zza extends zzgzb<zzay, zza> implements zzaz {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaz
            public zzq zza() {
                return ((zzay) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaz
            public zzap zzb() {
                return ((zzay) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaz
            public zzar zzc() {
                return ((zzay) this.zza).zzc();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaz
            public zzaw zzd() {
                return ((zzay) this.zza).zzd();
            }

            public zza zze() {
                zzbu();
                ((zzay) this.zza).zzL();
                return this;
            }

            public zza zzf() {
                zzbu();
                ((zzay) this.zza).zzM();
                return this;
            }

            public zza zzg() {
                zzbu();
                ((zzay) this.zza).zzN();
                return this;
            }

            public zza zzh() {
                zzbu();
                ((zzay) this.zza).zzO();
                return this;
            }

            public zza zzi(zzaw zzawVar) {
                zzbu();
                ((zzay) this.zza).zzP(zzawVar);
                return this;
            }

            public zza zzj(zzap zzapVar) {
                zzbu();
                ((zzay) this.zza).zzQ(zzapVar);
                return this;
            }

            public zza zzk(zzar zzarVar) {
                zzbu();
                ((zzay) this.zza).zzR(zzarVar);
                return this;
            }

            public zza zzl(zzaw.zza zzaVar) {
                zzbu();
                ((zzay) this.zza).zzS(zzaVar.zzbr());
                return this;
            }

            public zza zzm(zzaw zzawVar) {
                zzbu();
                ((zzay) this.zza).zzS(zzawVar);
                return this;
            }

            public zza zzn(zzap.zza zzaVar) {
                zzbu();
                ((zzay) this.zza).zzT(zzaVar.zzbr());
                return this;
            }

            public zza zzo(zzap zzapVar) {
                zzbu();
                ((zzay) this.zza).zzT(zzapVar);
                return this;
            }

            public zza zzp(zzq zzqVar) {
                zzbu();
                ((zzay) this.zza).zzU(zzqVar);
                return this;
            }

            public zza zzq(zzar.zza zzaVar) {
                zzbu();
                ((zzay) this.zza).zzV(zzaVar.zzbr());
                return this;
            }

            public zza zzr(zzar zzarVar) {
                zzbu();
                ((zzay) this.zza).zzV(zzarVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaz
            public boolean zzs() {
                return ((zzay) this.zza).zzs();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaz
            public boolean zzt() {
                return ((zzay) this.zza).zzt();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaz
            public boolean zzu() {
                return ((zzay) this.zza).zzu();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaz
            public boolean zzv() {
                return ((zzay) this.zza).zzv();
            }

            private zza() {
                super(zzay.zze);
            }
        }

        static {
            zzay zzayVar = new zzay();
            zze = zzayVar;
            zzgzh.zzbZ(zzay.class, zzayVar);
        }

        private zzay() {
        }

        public void zzL() {
            this.zzj = null;
            this.zzg &= -5;
        }

        public void zzM() {
            this.zzk = null;
            this.zzg &= -9;
        }

        public void zzN() {
            this.zzg &= -3;
            this.zzi = 1000;
        }

        public void zzO() {
            this.zzh = null;
            this.zzg &= -2;
        }

        public void zzP(zzaw zzawVar) {
            zzawVar.getClass();
            zzaw zzawVar2 = this.zzj;
            if (zzawVar2 != null && zzawVar2 != zzaw.zzg()) {
                zzaw.zza zzaVarZzb = zzaw.zzb(zzawVar2);
                zzaVarZzb.zzbj(zzawVar);
                zzawVar = zzaVarZzb.zzbs();
            }
            this.zzj = zzawVar;
            this.zzg |= 4;
        }

        public void zzQ(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzk;
            if (zzapVar2 != null && zzapVar2 != zzap.zzi()) {
                zzap.zza zzaVarZzd = zzap.zzd(zzapVar2);
                zzaVarZzd.zzbj(zzapVar);
                zzapVar = zzaVarZzd.zzbs();
            }
            this.zzk = zzapVar;
            this.zzg |= 8;
        }

        public void zzR(zzar zzarVar) {
            zzarVar.getClass();
            zzar zzarVar2 = this.zzh;
            if (zzarVar2 != null && zzarVar2 != zzar.zzh()) {
                zzar.zza zzaVarZzf = zzar.zzf(zzarVar2);
                zzaVarZzf.zzbj(zzarVar);
                zzarVar = zzaVarZzf.zzbs();
            }
            this.zzh = zzarVar;
            this.zzg |= 1;
        }

        public void zzS(zzaw zzawVar) {
            zzawVar.getClass();
            this.zzj = zzawVar;
            this.zzg |= 4;
        }

        public void zzT(zzap zzapVar) {
            zzapVar.getClass();
            this.zzk = zzapVar;
            this.zzg |= 8;
        }

        public void zzU(zzq zzqVar) {
            this.zzi = zzqVar.zza();
            this.zzg |= 2;
        }

        public void zzV(zzar zzarVar) {
            zzarVar.getClass();
            this.zzh = zzarVar;
            this.zzg |= 1;
        }

        public static zza zzf() {
            return (zza) zze.zzaZ();
        }

        public static zza zzg(zzay zzayVar) {
            return (zza) zze.zzba(zzayVar);
        }

        public static zzay zzi() {
            return zze;
        }

        public static zzay zzj(InputStream inputStream) {
            return (zzay) zzgzh.zzbk(zze, inputStream);
        }

        public static zzay zzk(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzay) zzgzh.zzbl(zze, inputStream, zzgyrVar);
        }

        public static zzay zzl(zzgxz zzgxzVar) {
            return (zzay) zzgzh.zzbm(zze, zzgxzVar);
        }

        public static zzay zzm(zzgyf zzgyfVar) {
            return (zzay) zzgzh.zzbn(zze, zzgyfVar);
        }

        public static zzay zzn(InputStream inputStream) {
            return (zzay) zzgzh.zzbo(zze, inputStream);
        }

        public static zzay zzo(ByteBuffer byteBuffer) {
            return (zzay) zzgzh.zzbp(zze, byteBuffer);
        }

        public static zzay zzp(byte[] bArr) {
            return (zzay) zzgzh.zzbq(zze, bArr);
        }

        public static zzay zzq(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzay) zzgzh.zzbr(zze, zzgxzVar, zzgyrVar);
        }

        public static zzay zzr(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzay) zzgzh.zzbs(zze, zzgyfVar, zzgyrVar);
        }

        public static zzay zzw(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzay) zzgzh.zzbu(zze, inputStream, zzgyrVar);
        }

        public static zzay zzx(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzay) zzgzh.zzbv(zze, byteBuffer, zzgyrVar);
        }

        public static zzay zzy(byte[] bArr, zzgyr zzgyrVar) {
            return (zzay) zzgzh.zzbx(zze, bArr, zzgyrVar);
        }

        public static zzhba<zzay> zzz() {
            return zze.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaz
        public zzq zza() {
            zzq zzqVarZzb = zzq.zzb(this.zzi);
            return zzqVarZzb == null ? zzq.ENUM_UNKNOWN : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaz
        public zzap zzb() {
            zzap zzapVar = this.zzk;
            return zzapVar == null ? zzap.zzi() : zzapVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaz
        public zzar zzc() {
            zzar zzarVar = this.zzh;
            return zzarVar == null ? zzar.zzh() : zzarVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaz
        public zzaw zzd() {
            zzaw zzawVar = this.zzj;
            return zzawVar == null ? zzaw.zzg() : zzawVar;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zze, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzg", "zzh", "zzi", zzq.zze(), "zzj", "zzk"});
            }
            if (iOrdinal == 3) {
                return new zzay();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zze;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzay> zzgzcVar = zzf;
            if (zzgzcVar == null) {
                synchronized (zzay.class) {
                    try {
                        zzgzcVar = zzf;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zze);
                            zzf = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaz
        public boolean zzs() {
            return (this.zzg & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaz
        public boolean zzt() {
            return (this.zzg & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaz
        public boolean zzu() {
            return (this.zzg & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaz
        public boolean zzv() {
            return (this.zzg & 1) != 0;
        }
    }

    public interface zzaz extends zzhat {
        zzq zza();

        zzap zzb();

        zzar zzc();

        zzaw zzd();

        boolean zzs();

        boolean zzt();

        boolean zzu();

        boolean zzv();
    }

    public final class zzb extends zzgzh<zzb, zzc> implements zzc {
        public static final int zza = 1;
        private static final zzb zzb;
        private static volatile zzhba<zzb> zzc;
        private zzgzt<zza> zzd = zzgzh.zzbK();

        public final class zza extends zzgzh<zza, C0004zza> implements InterfaceC0005zzb {
            public static final int zza = 1;
            public static final int zzb = 2;
            public static final int zzc = 3;
            private static final zza zzd;
            private static volatile zzhba<zza> zze;
            private int zzf;
            private int zzg;
            private zze zzh;
            private zzg zzi;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zzb$zza$zza */
            public final class C0004zza extends zzgzb<zza, C0004zza> implements InterfaceC0005zzb {
                public /* synthetic */ C0004zza() {
                    this();
                }

                public C0004zza zza() {
                    zzbu();
                    ((zza) this.zza).zzG();
                    return this;
                }

                public C0004zza zzb() {
                    zzbu();
                    ((zza) this.zza).zzH();
                    return this;
                }

                public C0004zza zzc() {
                    zzbu();
                    ((zza) this.zza).zzI();
                    return this;
                }

                public C0004zza zzd(zze zzeVar) {
                    zzbu();
                    ((zza) this.zza).zzJ(zzeVar);
                    return this;
                }

                public C0004zza zze(zzg zzgVar) {
                    zzbu();
                    ((zza) this.zza).zzK(zzgVar);
                    return this;
                }

                public C0004zza zzf(zzd zzdVar) {
                    zzbu();
                    ((zza) this.zza).zzL(zzdVar);
                    return this;
                }

                public C0004zza zzg(zze.zza zzaVar) {
                    zzbu();
                    ((zza) this.zza).zzM(zzaVar.zzbr());
                    return this;
                }

                public C0004zza zzh(zze zzeVar) {
                    zzbu();
                    ((zza) this.zza).zzM(zzeVar);
                    return this;
                }

                public C0004zza zzi(zzg.zza zzaVar) {
                    zzbu();
                    ((zza) this.zza).zzN(zzaVar.zzbr());
                    return this;
                }

                public C0004zza zzj(zzg zzgVar) {
                    zzbu();
                    ((zza) this.zza).zzN(zzgVar);
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzb.InterfaceC0005zzb
                public zzd zzk() {
                    return ((zza) this.zza).zzk();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzb.InterfaceC0005zzb
                public zze zzl() {
                    return ((zza) this.zza).zzl();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzb.InterfaceC0005zzb
                public zzg zzm() {
                    return ((zza) this.zza).zzm();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzb.InterfaceC0005zzb
                public boolean zzn() {
                    return ((zza) this.zza).zzn();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzb.InterfaceC0005zzb
                public boolean zzo() {
                    return ((zza) this.zza).zzo();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzb.InterfaceC0005zzb
                public boolean zzp() {
                    return ((zza) this.zza).zzp();
                }

                private C0004zza() {
                    super(zza.zzd);
                }
            }

            static {
                zza zzaVar = new zza();
                zzd = zzaVar;
                zzgzh.zzbZ(zza.class, zzaVar);
            }

            private zza() {
            }

            public void zzG() {
                this.zzf &= -2;
                this.zzg = 0;
            }

            public void zzH() {
                this.zzh = null;
                this.zzf &= -3;
            }

            public void zzI() {
                this.zzi = null;
                this.zzf &= -5;
            }

            public void zzJ(zze zzeVar) {
                zzeVar.getClass();
                zze zzeVar2 = this.zzh;
                if (zzeVar2 != null && zzeVar2 != zze.zzi()) {
                    zze.zza zzaVarZzc = zze.zzc(zzeVar2);
                    zzaVarZzc.zzbj(zzeVar);
                    zzeVar = zzaVarZzc.zzbs();
                }
                this.zzh = zzeVar;
                this.zzf |= 2;
            }

            public void zzK(zzg zzgVar) {
                zzgVar.getClass();
                zzg zzgVar2 = this.zzi;
                if (zzgVar2 != null && zzgVar2 != zzg.zzf()) {
                    zzg.zza zzaVarZzc = zzg.zzc(zzgVar2);
                    zzaVarZzc.zzbj(zzgVar);
                    zzgVar = zzaVarZzc.zzbs();
                }
                this.zzi = zzgVar;
                this.zzf |= 4;
            }

            public void zzL(zzd zzdVar) {
                this.zzg = zzdVar.zza();
                this.zzf |= 1;
            }

            public void zzM(zze zzeVar) {
                zzeVar.getClass();
                this.zzh = zzeVar;
                this.zzf |= 2;
            }

            public void zzN(zzg zzgVar) {
                zzgVar.getClass();
                this.zzi = zzgVar;
                this.zzf |= 4;
            }

            public static C0004zza zza() {
                return (C0004zza) zzd.zzaZ();
            }

            public static C0004zza zzb(zza zzaVar) {
                return (C0004zza) zzd.zzba(zzaVar);
            }

            public static zza zzd() {
                return zzd;
            }

            public static zza zzf(InputStream inputStream) {
                return (zza) zzgzh.zzbk(zzd, inputStream);
            }

            public static zza zzg(InputStream inputStream, zzgyr zzgyrVar) {
                return (zza) zzgzh.zzbl(zzd, inputStream, zzgyrVar);
            }

            public static zza zzh(zzgxz zzgxzVar) {
                return (zza) zzgzh.zzbm(zzd, zzgxzVar);
            }

            public static zza zzi(zzgyf zzgyfVar) {
                return (zza) zzgzh.zzbn(zzd, zzgyfVar);
            }

            public static zza zzj(InputStream inputStream) {
                return (zza) zzgzh.zzbo(zzd, inputStream);
            }

            public static zza zzq(ByteBuffer byteBuffer) {
                return (zza) zzgzh.zzbp(zzd, byteBuffer);
            }

            public static zza zzr(byte[] bArr) {
                return (zza) zzgzh.zzbq(zzd, bArr);
            }

            public static zza zzs(zzgxz zzgxzVar, zzgyr zzgyrVar) {
                return (zza) zzgzh.zzbr(zzd, zzgxzVar, zzgyrVar);
            }

            public static zza zzt(zzgyf zzgyfVar, zzgyr zzgyrVar) {
                return (zza) zzgzh.zzbs(zzd, zzgyfVar, zzgyrVar);
            }

            public static zza zzu(InputStream inputStream, zzgyr zzgyrVar) {
                return (zza) zzgzh.zzbu(zzd, inputStream, zzgyrVar);
            }

            public static zza zzv(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
                return (zza) zzgzh.zzbv(zzd, byteBuffer, zzgyrVar);
            }

            public static zza zzw(byte[] bArr, zzgyr zzgyrVar) {
                return (zza) zzgzh.zzbx(zzd, bArr, zzgyrVar);
            }

            public static zzhba<zza> zzx() {
                return zzd.zzbN();
            }

            @Override // com.google.android.gms.internal.ads.zzgzh
            public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
                int iOrdinal = zzgzgVar.ordinal();
                if (iOrdinal == 0) {
                    return (byte) 1;
                }
                if (iOrdinal == 2) {
                    return zzgzh.zzbQ(zzd, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzf", "zzg", zzd.zze(), "zzh", "zzi"});
                }
                if (iOrdinal == 3) {
                    return new zza();
                }
                if (iOrdinal == 4) {
                    return new C0004zza();
                }
                if (iOrdinal == 5) {
                    return zzd;
                }
                if (iOrdinal != 6) {
                    throw null;
                }
                zzhba<zza> zzgzcVar = zze;
                if (zzgzcVar == null) {
                    synchronized (zza.class) {
                        try {
                            zzgzcVar = zze;
                            if (zzgzcVar == null) {
                                zzgzcVar = new zzgzc(zzd);
                                zze = zzgzcVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                return zzgzcVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzb.InterfaceC0005zzb
            public zzd zzk() {
                zzd zzdVarZzb = zzd.zzb(this.zzg);
                return zzdVarZzb == null ? zzd.UNSPECIFIED : zzdVarZzb;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzb.InterfaceC0005zzb
            public zze zzl() {
                zze zzeVar = this.zzh;
                return zzeVar == null ? zze.zzi() : zzeVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzb.InterfaceC0005zzb
            public zzg zzm() {
                zzg zzgVar = this.zzi;
                return zzgVar == null ? zzg.zzf() : zzgVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzb.InterfaceC0005zzb
            public boolean zzn() {
                return (this.zzf & 1) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzb.InterfaceC0005zzb
            public boolean zzo() {
                return (this.zzf & 2) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzb.InterfaceC0005zzb
            public boolean zzp() {
                return (this.zzf & 4) != 0;
            }
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zzb$zzb */
        public interface InterfaceC0005zzb extends zzhat {
            zzd zzk();

            zze zzl();

            zzg zzm();

            boolean zzn();

            boolean zzo();

            boolean zzp();
        }

        public final class zzc extends zzgzb<zzb, zzc> implements zzc {
            public /* synthetic */ zzc() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzc
            public int zza() {
                return ((zzb) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzc
            public zza zzb(int i) {
                return ((zzb) this.zza).zzb(i);
            }

            public zzc zzc(Iterable<? extends zza> iterable) {
                zzbu();
                ((zzb) this.zza).zzD(iterable);
                return this;
            }

            public zzc zzd(zza.C0004zza c0004zza) {
                zzbu();
                ((zzb) this.zza).zzE(c0004zza.zzbr());
                return this;
            }

            public zzc zze(zza zzaVar) {
                zzbu();
                ((zzb) this.zza).zzE(zzaVar);
                return this;
            }

            public zzc zzf(int i, zza.C0004zza c0004zza) {
                zzbu();
                ((zzb) this.zza).zzF(i, c0004zza.zzbr());
                return this;
            }

            public zzc zzg(int i, zza zzaVar) {
                zzbu();
                ((zzb) this.zza).zzF(i, zzaVar);
                return this;
            }

            public zzc zzh() {
                zzbu();
                ((zzb) this.zza).zzG();
                return this;
            }

            public zzc zzi(int i) {
                zzbu();
                ((zzb) this.zza).zzI(i);
                return this;
            }

            public zzc zzj(int i, zza.C0004zza c0004zza) {
                zzbu();
                ((zzb) this.zza).zzJ(i, c0004zza.zzbr());
                return this;
            }

            public zzc zzk(int i, zza zzaVar) {
                zzbu();
                ((zzb) this.zza).zzJ(i, zzaVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzc
            public List<zza> zzl() {
                return Collections.unmodifiableList(((zzb) this.zza).zzl());
            }

            private zzc() {
                super(zzb.zzb);
            }
        }

        public enum zzd implements zzgzl {
            UNSPECIFIED(0),
            IN_MEMORY(1);

            public static final int zzc = 0;
            public static final int zzd = 1;
            private static final zzgzm<zzd> zze = new zzgzm<zzd>() { // from class: com.google.android.gms.internal.ads.zzbcj.zzb.zzd.1
                /* JADX INFO: renamed from: zza */
                public zzd zzb(int i) {
                    return zzd.zzb(i);
                }
            };
            private final int zzg;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zzb$zzd$1 */
            public class AnonymousClass1 implements zzgzm<zzd> {
                /* JADX INFO: renamed from: zza */
                public zzd zzb(int i) {
                    return zzd.zzb(i);
                }
            }

            final class zza implements zzgzn {
                static final zzgzn zza = new zza();

                private zza() {
                }

                @Override // com.google.android.gms.internal.ads.zzgzn
                public boolean zza(int i) {
                    return zzd.zzb(i) != null;
                }
            }

            zzd(int i) {
                this.zzg = i;
            }

            public static zzd zzb(int i) {
                if (i == 0) {
                    return UNSPECIFIED;
                }
                if (i != 1) {
                    return null;
                }
                return IN_MEMORY;
            }

            public static zzgzm<zzd> zzd() {
                return zze;
            }

            public static zzgzn zze() {
                return zza.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.zzg);
            }

            @Override // com.google.android.gms.internal.ads.zzgzl
            public final int zza() {
                return this.zzg;
            }
        }

        public final class zze extends zzgzh<zze, zza> implements zzf {
            public static final int zza = 1;
            public static final int zzb = 2;
            private static final zze zzc;
            private static volatile zzhba<zze> zzd;
            private int zze;
            private boolean zzf;
            private int zzg;

            public final class zza extends zzgzb<zze, zza> implements zzf {
                public /* synthetic */ zza() {
                    this();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzf
                public int zza() {
                    return ((zze) this.zza).zza();
                }

                public zza zzb() {
                    zzbu();
                    ((zze) this.zza).zzA();
                    return this;
                }

                public zza zzc() {
                    zzbu();
                    ((zze) this.zza).zzB();
                    return this;
                }

                public zza zzd(boolean z) {
                    zzbu();
                    ((zze) this.zza).zzC(z);
                    return this;
                }

                public zza zze(int i) {
                    zzbu();
                    ((zze) this.zza).zzD(i);
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzf
                public boolean zzf() {
                    return ((zze) this.zza).zzf();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzf
                public boolean zzg() {
                    return ((zze) this.zza).zzg();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzf
                public boolean zzh() {
                    return ((zze) this.zza).zzh();
                }

                private zza() {
                    super(zze.zzc);
                }
            }

            static {
                zze zzeVar = new zze();
                zzc = zzeVar;
                zzgzh.zzbZ(zze.class, zzeVar);
            }

            private zze() {
            }

            public void zzA() {
                this.zze &= -2;
                this.zzf = false;
            }

            public void zzB() {
                this.zze &= -3;
                this.zzg = 0;
            }

            public void zzC(boolean z) {
                this.zze |= 1;
                this.zzf = z;
            }

            public void zzD(int i) {
                this.zze |= 2;
                this.zzg = i;
            }

            public static zza zzb() {
                return (zza) zzc.zzaZ();
            }

            public static zza zzc(zze zzeVar) {
                return (zza) zzc.zzba(zzeVar);
            }

            public static zze zzi() {
                return zzc;
            }

            public static zze zzj(InputStream inputStream) {
                return (zze) zzgzh.zzbk(zzc, inputStream);
            }

            public static zze zzk(InputStream inputStream, zzgyr zzgyrVar) {
                return (zze) zzgzh.zzbl(zzc, inputStream, zzgyrVar);
            }

            public static zze zzl(zzgxz zzgxzVar) {
                return (zze) zzgzh.zzbm(zzc, zzgxzVar);
            }

            public static zze zzm(zzgyf zzgyfVar) {
                return (zze) zzgzh.zzbn(zzc, zzgyfVar);
            }

            public static zze zzn(InputStream inputStream) {
                return (zze) zzgzh.zzbo(zzc, inputStream);
            }

            public static zze zzo(ByteBuffer byteBuffer) {
                return (zze) zzgzh.zzbp(zzc, byteBuffer);
            }

            public static zze zzp(byte[] bArr) {
                return (zze) zzgzh.zzbq(zzc, bArr);
            }

            public static zze zzq(zzgxz zzgxzVar, zzgyr zzgyrVar) {
                return (zze) zzgzh.zzbr(zzc, zzgxzVar, zzgyrVar);
            }

            public static zze zzr(zzgyf zzgyfVar, zzgyr zzgyrVar) {
                return (zze) zzgzh.zzbs(zzc, zzgyfVar, zzgyrVar);
            }

            public static zze zzs(InputStream inputStream, zzgyr zzgyrVar) {
                return (zze) zzgzh.zzbu(zzc, inputStream, zzgyrVar);
            }

            public static zze zzt(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
                return (zze) zzgzh.zzbv(zzc, byteBuffer, zzgyrVar);
            }

            public static zze zzu(byte[] bArr, zzgyr zzgyrVar) {
                return (zze) zzgzh.zzbx(zzc, bArr, zzgyrVar);
            }

            public static zzhba<zze> zzv() {
                return zzc.zzbN();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzf
            public int zza() {
                return this.zzg;
            }

            @Override // com.google.android.gms.internal.ads.zzgzh
            public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
                int iOrdinal = zzgzgVar.ordinal();
                if (iOrdinal == 0) {
                    return (byte) 1;
                }
                if (iOrdinal == 2) {
                    return zzgzh.zzbQ(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဋ\u0001", new Object[]{"zze", "zzf", "zzg"});
                }
                if (iOrdinal == 3) {
                    return new zze();
                }
                if (iOrdinal == 4) {
                    return new zza();
                }
                if (iOrdinal == 5) {
                    return zzc;
                }
                if (iOrdinal != 6) {
                    throw null;
                }
                zzhba<zze> zzgzcVar = zzd;
                if (zzgzcVar == null) {
                    synchronized (zze.class) {
                        try {
                            zzgzcVar = zzd;
                            if (zzgzcVar == null) {
                                zzgzcVar = new zzgzc(zzc);
                                zzd = zzgzcVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                return zzgzcVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzf
            public boolean zzf() {
                return this.zzf;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzf
            public boolean zzg() {
                return (this.zze & 1) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzf
            public boolean zzh() {
                return (this.zze & 2) != 0;
            }
        }

        public interface zzf extends zzhat {
            int zza();

            boolean zzf();

            boolean zzg();

            boolean zzh();
        }

        public final class zzg extends zzgzh<zzg, zza> implements zzh {
            public static final int zza = 1;
            public static final int zzb = 2;
            public static final int zzc = 3;
            private static final zzg zzd;
            private static volatile zzhba<zzg> zze;
            private int zzf;
            private boolean zzg;
            private boolean zzh;
            private int zzi;

            public final class zza extends zzgzb<zzg, zza> implements zzh {
                public /* synthetic */ zza() {
                    this();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzh
                public int zza() {
                    return ((zzg) this.zza).zza();
                }

                public zza zzb() {
                    zzbu();
                    ((zzg) this.zza).zzE();
                    return this;
                }

                public zza zzc() {
                    zzbu();
                    ((zzg) this.zza).zzF();
                    return this;
                }

                public zza zzd() {
                    zzbu();
                    ((zzg) this.zza).zzG();
                    return this;
                }

                public zza zze(boolean z) {
                    zzbu();
                    ((zzg) this.zza).zzH(z);
                    return this;
                }

                public zza zzf(boolean z) {
                    zzbu();
                    ((zzg) this.zza).zzI(z);
                    return this;
                }

                public zza zzg(int i) {
                    zzbu();
                    ((zzg) this.zza).zzJ(i);
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzh
                public boolean zzh() {
                    return ((zzg) this.zza).zzh();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzh
                public boolean zzi() {
                    return ((zzg) this.zza).zzi();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzh
                public boolean zzj() {
                    return ((zzg) this.zza).zzj();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzh
                public boolean zzk() {
                    return ((zzg) this.zza).zzk();
                }

                @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzh
                public boolean zzl() {
                    return ((zzg) this.zza).zzl();
                }

                private zza() {
                    super(zzg.zzd);
                }
            }

            static {
                zzg zzgVar = new zzg();
                zzd = zzgVar;
                zzgzh.zzbZ(zzg.class, zzgVar);
            }

            private zzg() {
            }

            public void zzE() {
                this.zzf &= -2;
                this.zzg = false;
            }

            public void zzF() {
                this.zzf &= -3;
                this.zzh = false;
            }

            public void zzG() {
                this.zzf &= -5;
                this.zzi = 0;
            }

            public void zzH(boolean z) {
                this.zzf |= 1;
                this.zzg = z;
            }

            public void zzI(boolean z) {
                this.zzf |= 2;
                this.zzh = z;
            }

            public void zzJ(int i) {
                this.zzf |= 4;
                this.zzi = i;
            }

            public static zza zzb() {
                return (zza) zzd.zzaZ();
            }

            public static zza zzc(zzg zzgVar) {
                return (zza) zzd.zzba(zzgVar);
            }

            public static zzg zzf() {
                return zzd;
            }

            public static zzg zzg(InputStream inputStream) {
                return (zzg) zzgzh.zzbk(zzd, inputStream);
            }

            public static zzg zzm(InputStream inputStream, zzgyr zzgyrVar) {
                return (zzg) zzgzh.zzbl(zzd, inputStream, zzgyrVar);
            }

            public static zzg zzn(zzgxz zzgxzVar) {
                return (zzg) zzgzh.zzbm(zzd, zzgxzVar);
            }

            public static zzg zzo(zzgyf zzgyfVar) {
                return (zzg) zzgzh.zzbn(zzd, zzgyfVar);
            }

            public static zzg zzp(InputStream inputStream) {
                return (zzg) zzgzh.zzbo(zzd, inputStream);
            }

            public static zzg zzq(ByteBuffer byteBuffer) {
                return (zzg) zzgzh.zzbp(zzd, byteBuffer);
            }

            public static zzg zzr(byte[] bArr) {
                return (zzg) zzgzh.zzbq(zzd, bArr);
            }

            public static zzg zzs(zzgxz zzgxzVar, zzgyr zzgyrVar) {
                return (zzg) zzgzh.zzbr(zzd, zzgxzVar, zzgyrVar);
            }

            public static zzg zzt(zzgyf zzgyfVar, zzgyr zzgyrVar) {
                return (zzg) zzgzh.zzbs(zzd, zzgyfVar, zzgyrVar);
            }

            public static zzg zzu(InputStream inputStream, zzgyr zzgyrVar) {
                return (zzg) zzgzh.zzbu(zzd, inputStream, zzgyrVar);
            }

            public static zzg zzv(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
                return (zzg) zzgzh.zzbv(zzd, byteBuffer, zzgyrVar);
            }

            public static zzg zzw(byte[] bArr, zzgyr zzgyrVar) {
                return (zzg) zzgzh.zzbx(zzd, bArr, zzgyrVar);
            }

            public static zzhba<zzg> zzx() {
                return zzd.zzbN();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzh
            public int zza() {
                return this.zzi;
            }

            @Override // com.google.android.gms.internal.ads.zzgzh
            public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
                int iOrdinal = zzgzgVar.ordinal();
                if (iOrdinal == 0) {
                    return (byte) 1;
                }
                if (iOrdinal == 2) {
                    return zzgzh.zzbQ(zzd, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဋ\u0002", new Object[]{"zzf", "zzg", "zzh", "zzi"});
                }
                if (iOrdinal == 3) {
                    return new zzg();
                }
                if (iOrdinal == 4) {
                    return new zza();
                }
                if (iOrdinal == 5) {
                    return zzd;
                }
                if (iOrdinal != 6) {
                    throw null;
                }
                zzhba<zzg> zzgzcVar = zze;
                if (zzgzcVar == null) {
                    synchronized (zzg.class) {
                        try {
                            zzgzcVar = zze;
                            if (zzgzcVar == null) {
                                zzgzcVar = new zzgzc(zzd);
                                zze = zzgzcVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                return zzgzcVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzh
            public boolean zzh() {
                return this.zzg;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzh
            public boolean zzi() {
                return this.zzh;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzh
            public boolean zzj() {
                return (this.zzf & 1) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzh
            public boolean zzk() {
                return (this.zzf & 2) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzb.zzh
            public boolean zzl() {
                return (this.zzf & 4) != 0;
            }
        }

        public interface zzh extends zzhat {
            int zza();

            boolean zzh();

            boolean zzi();

            boolean zzj();

            boolean zzk();

            boolean zzl();
        }

        static {
            zzb zzbVar = new zzb();
            zzb = zzbVar;
            zzgzh.zzbZ(zzb.class, zzbVar);
        }

        private zzb() {
        }

        public void zzD(Iterable<? extends zza> iterable) {
            zzH();
            zzgxi.zzaQ(iterable, this.zzd);
        }

        public void zzE(zza zzaVar) {
            zzaVar.getClass();
            zzH();
            this.zzd.add(zzaVar);
        }

        public void zzF(int i, zza zzaVar) {
            zzaVar.getClass();
            zzH();
            this.zzd.add(i, zzaVar);
        }

        public void zzG() {
            this.zzd = zzgzh.zzbK();
        }

        private void zzH() {
            zzgzt<zza> zzgztVar = this.zzd;
            if (zzgztVar.zzc()) {
                return;
            }
            this.zzd = zzgzh.zzbL(zzgztVar);
        }

        public void zzI(int i) {
            zzH();
            this.zzd.remove(i);
        }

        public void zzJ(int i, zza zzaVar) {
            zzaVar.getClass();
            zzH();
            this.zzd.set(i, zzaVar);
        }

        public static zzc zzd() {
            return (zzc) zzb.zzaZ();
        }

        public static zzc zzf(zzb zzbVar) {
            return (zzc) zzb.zzba(zzbVar);
        }

        public static zzb zzh() {
            return zzb;
        }

        public static zzb zzi(InputStream inputStream) {
            return (zzb) zzgzh.zzbk(zzb, inputStream);
        }

        public static zzb zzj(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzb) zzgzh.zzbl(zzb, inputStream, zzgyrVar);
        }

        public static zzb zzk(zzgxz zzgxzVar) {
            return (zzb) zzgzh.zzbm(zzb, zzgxzVar);
        }

        public static zzb zzm(zzgyf zzgyfVar) {
            return (zzb) zzgzh.zzbn(zzb, zzgyfVar);
        }

        public static zzb zzn(InputStream inputStream) {
            return (zzb) zzgzh.zzbo(zzb, inputStream);
        }

        public static zzb zzo(ByteBuffer byteBuffer) {
            return (zzb) zzgzh.zzbp(zzb, byteBuffer);
        }

        public static zzb zzp(byte[] bArr) {
            return (zzb) zzgzh.zzbq(zzb, bArr);
        }

        public static zzb zzq(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzb) zzgzh.zzbr(zzb, zzgxzVar, zzgyrVar);
        }

        public static zzb zzr(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzb) zzgzh.zzbs(zzb, zzgyfVar, zzgyrVar);
        }

        public static zzb zzs(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzb) zzgzh.zzbu(zzb, inputStream, zzgyrVar);
        }

        public static zzb zzt(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzb) zzgzh.zzbv(zzb, byteBuffer, zzgyrVar);
        }

        public static zzb zzu(byte[] bArr, zzgyr zzgyrVar) {
            return (zzb) zzgzh.zzbx(zzb, bArr, zzgyrVar);
        }

        public static zzhba<zzb> zzv() {
            return zzb.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzc
        public int zza() {
            return this.zzd.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzc
        public zza zzb(int i) {
            return this.zzd.get(i);
        }

        public InterfaceC0005zzb zzc(int i) {
            return this.zzd.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zza.class});
            }
            if (iOrdinal == 3) {
                return new zzb();
            }
            if (iOrdinal == 4) {
                return new zzc();
            }
            if (iOrdinal == 5) {
                return zzb;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzb> zzgzcVar = zzc;
            if (zzgzcVar == null) {
                synchronized (zzb.class) {
                    try {
                        zzgzcVar = zzc;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzb);
                            zzc = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzc
        public List<zza> zzl() {
            return this.zzd;
        }

        public List<? extends InterfaceC0005zzb> zzw() {
            return this.zzd;
        }
    }

    public final class zzba extends zzgzh<zzba, zza> implements zzbb {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        private static final zzba zzf;
        private static volatile zzhba<zzba> zzg;
        private int zzh;
        private int zzi = 1000;
        private zzaw zzj;
        private int zzk;
        private int zzl;
        private int zzm;

        public final class zza extends zzgzb<zzba, zza> implements zzbb {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
            public int zza() {
                return ((zzba) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
            public int zzb() {
                return ((zzba) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
            public int zzc() {
                return ((zzba) this.zza).zzc();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
            public zzq zzd() {
                return ((zzba) this.zza).zzd();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
            public zzaw zze() {
                return ((zzba) this.zza).zze();
            }

            public zza zzf() {
                zzbu();
                ((zzba) this.zza).zzM();
                return this;
            }

            public zza zzg() {
                zzbu();
                ((zzba) this.zza).zzN();
                return this;
            }

            public zza zzh() {
                zzbu();
                ((zzba) this.zza).zzO();
                return this;
            }

            public zza zzi() {
                zzbu();
                ((zzba) this.zza).zzP();
                return this;
            }

            public zza zzj() {
                zzbu();
                ((zzba) this.zza).zzQ();
                return this;
            }

            public zza zzk(zzaw zzawVar) {
                zzbu();
                ((zzba) this.zza).zzR(zzawVar);
                return this;
            }

            public zza zzl(zzaw.zza zzaVar) {
                zzbu();
                ((zzba) this.zza).zzS(zzaVar.zzbr());
                return this;
            }

            public zza zzm(zzaw zzawVar) {
                zzbu();
                ((zzba) this.zza).zzS(zzawVar);
                return this;
            }

            public zza zzn(zzq zzqVar) {
                zzbu();
                ((zzba) this.zza).zzT(zzqVar);
                return this;
            }

            public zza zzo(int i) {
                zzbu();
                ((zzba) this.zza).zzU(i);
                return this;
            }

            public zza zzp(int i) {
                zzbu();
                ((zzba) this.zza).zzV(i);
                return this;
            }

            public zza zzq(int i) {
                zzbu();
                ((zzba) this.zza).zzW(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
            public boolean zzr() {
                return ((zzba) this.zza).zzr();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
            public boolean zzs() {
                return ((zzba) this.zza).zzs();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
            public boolean zzt() {
                return ((zzba) this.zza).zzt();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
            public boolean zzu() {
                return ((zzba) this.zza).zzu();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
            public boolean zzv() {
                return ((zzba) this.zza).zzv();
            }

            private zza() {
                super(zzba.zzf);
            }
        }

        static {
            zzba zzbaVar = new zzba();
            zzf = zzbaVar;
            zzgzh.zzbZ(zzba.class, zzbaVar);
        }

        private zzba() {
        }

        public static zzhba<zzba> zzA() {
            return zzf.zzbN();
        }

        public void zzM() {
            this.zzj = null;
            this.zzh &= -3;
        }

        public void zzN() {
            this.zzh &= -2;
            this.zzi = 1000;
        }

        public void zzO() {
            this.zzh &= -17;
            this.zzm = 0;
        }

        public void zzP() {
            this.zzh &= -5;
            this.zzk = 0;
        }

        public void zzQ() {
            this.zzh &= -9;
            this.zzl = 0;
        }

        public void zzR(zzaw zzawVar) {
            zzawVar.getClass();
            zzaw zzawVar2 = this.zzj;
            if (zzawVar2 != null && zzawVar2 != zzaw.zzg()) {
                zzaw.zza zzaVarZzb = zzaw.zzb(zzawVar2);
                zzaVarZzb.zzbj(zzawVar);
                zzawVar = zzaVarZzb.zzbs();
            }
            this.zzj = zzawVar;
            this.zzh |= 2;
        }

        public void zzS(zzaw zzawVar) {
            zzawVar.getClass();
            this.zzj = zzawVar;
            this.zzh |= 2;
        }

        public void zzT(zzq zzqVar) {
            this.zzi = zzqVar.zza();
            this.zzh |= 1;
        }

        public void zzU(int i) {
            this.zzh |= 16;
            this.zzm = i;
        }

        public void zzV(int i) {
            this.zzh |= 4;
            this.zzk = i;
        }

        public void zzW(int i) {
            this.zzh |= 8;
            this.zzl = i;
        }

        public static zza zzf() {
            return (zza) zzf.zzaZ();
        }

        public static zza zzg(zzba zzbaVar) {
            return (zza) zzf.zzba(zzbaVar);
        }

        public static zzba zzi() {
            return zzf;
        }

        public static zzba zzj(InputStream inputStream) {
            return (zzba) zzgzh.zzbk(zzf, inputStream);
        }

        public static zzba zzk(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzba) zzgzh.zzbl(zzf, inputStream, zzgyrVar);
        }

        public static zzba zzl(zzgxz zzgxzVar) {
            return (zzba) zzgzh.zzbm(zzf, zzgxzVar);
        }

        public static zzba zzm(zzgyf zzgyfVar) {
            return (zzba) zzgzh.zzbn(zzf, zzgyfVar);
        }

        public static zzba zzn(InputStream inputStream) {
            return (zzba) zzgzh.zzbo(zzf, inputStream);
        }

        public static zzba zzo(ByteBuffer byteBuffer) {
            return (zzba) zzgzh.zzbp(zzf, byteBuffer);
        }

        public static zzba zzp(byte[] bArr) {
            return (zzba) zzgzh.zzbq(zzf, bArr);
        }

        public static zzba zzq(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzba) zzgzh.zzbr(zzf, zzgxzVar, zzgyrVar);
        }

        public static zzba zzw(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzba) zzgzh.zzbs(zzf, zzgyfVar, zzgyrVar);
        }

        public static zzba zzx(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzba) zzgzh.zzbu(zzf, inputStream, zzgyrVar);
        }

        public static zzba zzy(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzba) zzgzh.zzbv(zzf, byteBuffer, zzgyrVar);
        }

        public static zzba zzz(byte[] bArr, zzgyr zzgyrVar) {
            return (zzba) zzgzh.zzbx(zzf, bArr, zzgyrVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
        public int zza() {
            return this.zzm;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
        public int zzb() {
            return this.zzk;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
        public int zzc() {
            return this.zzl;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
        public zzq zzd() {
            zzq zzqVarZzb = zzq.zzb(this.zzi);
            return zzqVarZzb == null ? zzq.ENUM_UNKNOWN : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzf, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zzh", "zzi", zzq.zze(), "zzj", "zzk", "zzl", "zzm"});
            }
            if (iOrdinal == 3) {
                return new zzba();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzba> zzgzcVar = zzg;
            if (zzgzcVar == null) {
                synchronized (zzba.class) {
                    try {
                        zzgzcVar = zzg;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzf);
                            zzg = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
        public zzaw zze() {
            zzaw zzawVar = this.zzj;
            return zzawVar == null ? zzaw.zzg() : zzawVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
        public boolean zzr() {
            return (this.zzh & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
        public boolean zzs() {
            return (this.zzh & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
        public boolean zzt() {
            return (this.zzh & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
        public boolean zzu() {
            return (this.zzh & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbb
        public boolean zzv() {
            return (this.zzh & 8) != 0;
        }
    }

    public interface zzbb extends zzhat {
        int zza();

        int zzb();

        int zzc();

        zzq zzd();

        zzaw zze();

        boolean zzr();

        boolean zzs();

        boolean zzt();

        boolean zzu();

        boolean zzv();
    }

    public final class zzbc extends zzgzh<zzbc, zza> implements zzbd {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzbc zzd;
        private static volatile zzhba<zzbc> zze;
        private int zzf;
        private int zzg = 1000;
        private zzaw zzh;
        private zzap zzi;

        public final class zza extends zzgzb<zzbc, zza> implements zzbd {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbd
            public zzq zza() {
                return ((zzbc) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbd
            public zzap zzb() {
                return ((zzbc) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbd
            public zzaw zzc() {
                return ((zzbc) this.zza).zzc();
            }

            public zza zzd() {
                zzbu();
                ((zzbc) this.zza).zzG();
                return this;
            }

            public zza zze() {
                zzbu();
                ((zzbc) this.zza).zzH();
                return this;
            }

            public zza zzf() {
                zzbu();
                ((zzbc) this.zza).zzI();
                return this;
            }

            public zza zzg(zzaw zzawVar) {
                zzbu();
                ((zzbc) this.zza).zzJ(zzawVar);
                return this;
            }

            public zza zzh(zzap zzapVar) {
                zzbu();
                ((zzbc) this.zza).zzK(zzapVar);
                return this;
            }

            public zza zzi(zzaw.zza zzaVar) {
                zzbu();
                ((zzbc) this.zza).zzL(zzaVar.zzbr());
                return this;
            }

            public zza zzj(zzaw zzawVar) {
                zzbu();
                ((zzbc) this.zza).zzL(zzawVar);
                return this;
            }

            public zza zzk(zzap.zza zzaVar) {
                zzbu();
                ((zzbc) this.zza).zzM(zzaVar.zzbr());
                return this;
            }

            public zza zzl(zzap zzapVar) {
                zzbu();
                ((zzbc) this.zza).zzM(zzapVar);
                return this;
            }

            public zza zzm(zzq zzqVar) {
                zzbu();
                ((zzbc) this.zza).zzN(zzqVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbd
            public boolean zzn() {
                return ((zzbc) this.zza).zzn();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbd
            public boolean zzo() {
                return ((zzbc) this.zza).zzo();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbd
            public boolean zzp() {
                return ((zzbc) this.zza).zzp();
            }

            private zza() {
                super(zzbc.zzd);
            }
        }

        static {
            zzbc zzbcVar = new zzbc();
            zzd = zzbcVar;
            zzgzh.zzbZ(zzbc.class, zzbcVar);
        }

        private zzbc() {
        }

        public void zzG() {
            this.zzh = null;
            this.zzf &= -3;
        }

        public void zzH() {
            this.zzi = null;
            this.zzf &= -5;
        }

        public void zzI() {
            this.zzf &= -2;
            this.zzg = 1000;
        }

        public void zzJ(zzaw zzawVar) {
            zzawVar.getClass();
            zzaw zzawVar2 = this.zzh;
            if (zzawVar2 != null && zzawVar2 != zzaw.zzg()) {
                zzaw.zza zzaVarZzb = zzaw.zzb(zzawVar2);
                zzaVarZzb.zzbj(zzawVar);
                zzawVar = zzaVarZzb.zzbs();
            }
            this.zzh = zzawVar;
            this.zzf |= 2;
        }

        public void zzK(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzi;
            if (zzapVar2 != null && zzapVar2 != zzap.zzi()) {
                zzap.zza zzaVarZzd = zzap.zzd(zzapVar2);
                zzaVarZzd.zzbj(zzapVar);
                zzapVar = zzaVarZzd.zzbs();
            }
            this.zzi = zzapVar;
            this.zzf |= 4;
        }

        public void zzL(zzaw zzawVar) {
            zzawVar.getClass();
            this.zzh = zzawVar;
            this.zzf |= 2;
        }

        public void zzM(zzap zzapVar) {
            zzapVar.getClass();
            this.zzi = zzapVar;
            this.zzf |= 4;
        }

        public void zzN(zzq zzqVar) {
            this.zzg = zzqVar.zza();
            this.zzf |= 1;
        }

        public static zza zzd() {
            return (zza) zzd.zzaZ();
        }

        public static zza zzf(zzbc zzbcVar) {
            return (zza) zzd.zzba(zzbcVar);
        }

        public static zzbc zzh() {
            return zzd;
        }

        public static zzbc zzi(InputStream inputStream) {
            return (zzbc) zzgzh.zzbk(zzd, inputStream);
        }

        public static zzbc zzj(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzbc) zzgzh.zzbl(zzd, inputStream, zzgyrVar);
        }

        public static zzbc zzk(zzgxz zzgxzVar) {
            return (zzbc) zzgzh.zzbm(zzd, zzgxzVar);
        }

        public static zzbc zzl(zzgyf zzgyfVar) {
            return (zzbc) zzgzh.zzbn(zzd, zzgyfVar);
        }

        public static zzbc zzm(InputStream inputStream) {
            return (zzbc) zzgzh.zzbo(zzd, inputStream);
        }

        public static zzbc zzq(ByteBuffer byteBuffer) {
            return (zzbc) zzgzh.zzbp(zzd, byteBuffer);
        }

        public static zzbc zzr(byte[] bArr) {
            return (zzbc) zzgzh.zzbq(zzd, bArr);
        }

        public static zzbc zzs(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzbc) zzgzh.zzbr(zzd, zzgxzVar, zzgyrVar);
        }

        public static zzbc zzt(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzbc) zzgzh.zzbs(zzd, zzgyfVar, zzgyrVar);
        }

        public static zzbc zzu(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzbc) zzgzh.zzbu(zzd, inputStream, zzgyrVar);
        }

        public static zzbc zzv(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzbc) zzgzh.zzbv(zzd, byteBuffer, zzgyrVar);
        }

        public static zzbc zzw(byte[] bArr, zzgyr zzgyrVar) {
            return (zzbc) zzgzh.zzbx(zzd, bArr, zzgyrVar);
        }

        public static zzhba<zzbc> zzx() {
            return zzd.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbd
        public zzq zza() {
            zzq zzqVarZzb = zzq.zzb(this.zzg);
            return zzqVarZzb == null ? zzq.ENUM_UNKNOWN : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbd
        public zzap zzb() {
            zzap zzapVar = this.zzi;
            return zzapVar == null ? zzap.zzi() : zzapVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbd
        public zzaw zzc() {
            zzaw zzawVar = this.zzh;
            return zzawVar == null ? zzaw.zzg() : zzawVar;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzd, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzf", "zzg", zzq.zze(), "zzh", "zzi"});
            }
            if (iOrdinal == 3) {
                return new zzbc();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzd;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzbc> zzgzcVar = zze;
            if (zzgzcVar == null) {
                synchronized (zzbc.class) {
                    try {
                        zzgzcVar = zze;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzd);
                            zze = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbd
        public boolean zzn() {
            return (this.zzf & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbd
        public boolean zzo() {
            return (this.zzf & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbd
        public boolean zzp() {
            return (this.zzf & 1) != 0;
        }
    }

    public interface zzbd extends zzhat {
        zzq zza();

        zzap zzb();

        zzaw zzc();

        boolean zzn();

        boolean zzo();

        boolean zzp();
    }

    public final class zzbe extends zzgzh<zzbe, zza> implements zzbf {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        private static final zzbe zzg;
        private static volatile zzhba<zzbe> zzh;
        private int zzi;
        private int zzj = 1000;
        private zzaw zzk;
        private int zzl;
        private int zzm;
        private int zzn;
        private long zzo;

        public final class zza extends zzgzb<zzbe, zza> implements zzbf {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
            public int zza() {
                return ((zzbe) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
            public int zzb() {
                return ((zzbe) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
            public int zzc() {
                return ((zzbe) this.zza).zzc();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
            public long zzd() {
                return ((zzbe) this.zza).zzd();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
            public zzq zze() {
                return ((zzbe) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
            public zzaw zzf() {
                return ((zzbe) this.zza).zzf();
            }

            public zza zzg() {
                zzbu();
                ((zzbe) this.zza).zzQ();
                return this;
            }

            public zza zzh() {
                zzbu();
                ((zzbe) this.zza).zzR();
                return this;
            }

            public zza zzi() {
                zzbu();
                ((zzbe) this.zza).zzS();
                return this;
            }

            public zza zzj() {
                zzbu();
                ((zzbe) this.zza).zzT();
                return this;
            }

            public zza zzk() {
                zzbu();
                ((zzbe) this.zza).zzU();
                return this;
            }

            public zza zzl() {
                zzbu();
                ((zzbe) this.zza).zzV();
                return this;
            }

            public zza zzm(zzaw zzawVar) {
                zzbu();
                ((zzbe) this.zza).zzW(zzawVar);
                return this;
            }

            public zza zzn(long j) {
                zzbu();
                ((zzbe) this.zza).zzX(j);
                return this;
            }

            public zza zzo(zzaw.zza zzaVar) {
                zzbu();
                ((zzbe) this.zza).zzY(zzaVar.zzbr());
                return this;
            }

            public zza zzp(zzaw zzawVar) {
                zzbu();
                ((zzbe) this.zza).zzY(zzawVar);
                return this;
            }

            public zza zzq(zzq zzqVar) {
                zzbu();
                ((zzbe) this.zza).zzZ(zzqVar);
                return this;
            }

            public zza zzr(int i) {
                zzbu();
                ((zzbe) this.zza).zzaa(i);
                return this;
            }

            public zza zzs(int i) {
                zzbu();
                ((zzbe) this.zza).zzab(i);
                return this;
            }

            public zza zzt(int i) {
                zzbu();
                ((zzbe) this.zza).zzac(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
            public boolean zzu() {
                return ((zzbe) this.zza).zzu();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
            public boolean zzv() {
                return ((zzbe) this.zza).zzv();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
            public boolean zzw() {
                return ((zzbe) this.zza).zzw();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
            public boolean zzx() {
                return ((zzbe) this.zza).zzx();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
            public boolean zzy() {
                return ((zzbe) this.zza).zzy();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
            public boolean zzz() {
                return ((zzbe) this.zza).zzz();
            }

            private zza() {
                super(zzbe.zzg);
            }
        }

        static {
            zzbe zzbeVar = new zzbe();
            zzg = zzbeVar;
            zzgzh.zzbZ(zzbe.class, zzbeVar);
        }

        private zzbe() {
        }

        public static zzbe zzA(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzbe) zzgzh.zzbv(zzg, byteBuffer, zzgyrVar);
        }

        public static zzbe zzB(byte[] bArr, zzgyr zzgyrVar) {
            return (zzbe) zzgzh.zzbx(zzg, bArr, zzgyrVar);
        }

        public static zzhba<zzbe> zzC() {
            return zzg.zzbN();
        }

        public void zzQ() {
            this.zzi &= -33;
            this.zzo = 0L;
        }

        public void zzR() {
            this.zzk = null;
            this.zzi &= -3;
        }

        public void zzS() {
            this.zzi &= -2;
            this.zzj = 1000;
        }

        public void zzT() {
            this.zzi &= -17;
            this.zzn = 0;
        }

        public void zzU() {
            this.zzi &= -5;
            this.zzl = 0;
        }

        public void zzV() {
            this.zzi &= -9;
            this.zzm = 0;
        }

        public void zzW(zzaw zzawVar) {
            zzawVar.getClass();
            zzaw zzawVar2 = this.zzk;
            if (zzawVar2 != null && zzawVar2 != zzaw.zzg()) {
                zzaw.zza zzaVarZzb = zzaw.zzb(zzawVar2);
                zzaVarZzb.zzbj(zzawVar);
                zzawVar = zzaVarZzb.zzbs();
            }
            this.zzk = zzawVar;
            this.zzi |= 2;
        }

        public void zzX(long j) {
            this.zzi |= 32;
            this.zzo = j;
        }

        public void zzY(zzaw zzawVar) {
            zzawVar.getClass();
            this.zzk = zzawVar;
            this.zzi |= 2;
        }

        public void zzZ(zzq zzqVar) {
            this.zzj = zzqVar.zza();
            this.zzi |= 1;
        }

        public void zzaa(int i) {
            this.zzi |= 16;
            this.zzn = i;
        }

        public void zzab(int i) {
            this.zzi |= 4;
            this.zzl = i;
        }

        public void zzac(int i) {
            this.zzi |= 8;
            this.zzm = i;
        }

        public static zza zzg() {
            return (zza) zzg.zzaZ();
        }

        public static zza zzh(zzbe zzbeVar) {
            return (zza) zzg.zzba(zzbeVar);
        }

        public static zzbe zzj() {
            return zzg;
        }

        public static zzbe zzk(InputStream inputStream) {
            return (zzbe) zzgzh.zzbk(zzg, inputStream);
        }

        public static zzbe zzl(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzbe) zzgzh.zzbl(zzg, inputStream, zzgyrVar);
        }

        public static zzbe zzm(zzgxz zzgxzVar) {
            return (zzbe) zzgzh.zzbm(zzg, zzgxzVar);
        }

        public static zzbe zzn(zzgyf zzgyfVar) {
            return (zzbe) zzgzh.zzbn(zzg, zzgyfVar);
        }

        public static zzbe zzo(InputStream inputStream) {
            return (zzbe) zzgzh.zzbo(zzg, inputStream);
        }

        public static zzbe zzp(ByteBuffer byteBuffer) {
            return (zzbe) zzgzh.zzbp(zzg, byteBuffer);
        }

        public static zzbe zzq(byte[] bArr) {
            return (zzbe) zzgzh.zzbq(zzg, bArr);
        }

        public static zzbe zzr(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzbe) zzgzh.zzbr(zzg, zzgxzVar, zzgyrVar);
        }

        public static zzbe zzs(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzbe) zzgzh.zzbs(zzg, zzgyfVar, zzgyrVar);
        }

        public static zzbe zzt(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzbe) zzgzh.zzbu(zzg, inputStream, zzgyrVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
        public int zza() {
            return this.zzn;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
        public int zzb() {
            return this.zzl;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
        public int zzc() {
            return this.zzm;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
        public long zzd() {
            return this.zzo;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzg, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006ဃ\u0005", new Object[]{"zzi", "zzj", zzq.zze(), "zzk", "zzl", "zzm", "zzn", "zzo"});
            }
            if (iOrdinal == 3) {
                return new zzbe();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzg;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzbe> zzgzcVar = zzh;
            if (zzgzcVar == null) {
                synchronized (zzbe.class) {
                    try {
                        zzgzcVar = zzh;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzg);
                            zzh = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
        public zzq zze() {
            zzq zzqVarZzb = zzq.zzb(this.zzj);
            return zzqVarZzb == null ? zzq.ENUM_UNKNOWN : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
        public zzaw zzf() {
            zzaw zzawVar = this.zzk;
            return zzawVar == null ? zzaw.zzg() : zzawVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
        public boolean zzu() {
            return (this.zzi & 32) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
        public boolean zzv() {
            return (this.zzi & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
        public boolean zzw() {
            return (this.zzi & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
        public boolean zzx() {
            return (this.zzi & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
        public boolean zzy() {
            return (this.zzi & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbf
        public boolean zzz() {
            return (this.zzi & 8) != 0;
        }
    }

    public interface zzbf extends zzhat {
        int zza();

        int zzb();

        int zzc();

        long zzd();

        zzq zze();

        zzaw zzf();

        boolean zzu();

        boolean zzv();

        boolean zzw();

        boolean zzx();

        boolean zzy();

        boolean zzz();
    }

    public final class zzbg extends zzgzh<zzbg, zza> implements zzbh {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzbg zzd;
        private static volatile zzhba<zzbg> zze;
        private int zzf;
        private int zzg = 1000;
        private zzaw zzh;
        private zzap zzi;

        public final class zza extends zzgzb<zzbg, zza> implements zzbh {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbh
            public zzq zza() {
                return ((zzbg) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbh
            public zzap zzb() {
                return ((zzbg) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbh
            public zzaw zzc() {
                return ((zzbg) this.zza).zzc();
            }

            public zza zzd() {
                zzbu();
                ((zzbg) this.zza).zzG();
                return this;
            }

            public zza zze() {
                zzbu();
                ((zzbg) this.zza).zzH();
                return this;
            }

            public zza zzf() {
                zzbu();
                ((zzbg) this.zza).zzI();
                return this;
            }

            public zza zzg(zzaw zzawVar) {
                zzbu();
                ((zzbg) this.zza).zzJ(zzawVar);
                return this;
            }

            public zza zzh(zzap zzapVar) {
                zzbu();
                ((zzbg) this.zza).zzK(zzapVar);
                return this;
            }

            public zza zzi(zzaw.zza zzaVar) {
                zzbu();
                ((zzbg) this.zza).zzL(zzaVar.zzbr());
                return this;
            }

            public zza zzj(zzaw zzawVar) {
                zzbu();
                ((zzbg) this.zza).zzL(zzawVar);
                return this;
            }

            public zza zzk(zzap.zza zzaVar) {
                zzbu();
                ((zzbg) this.zza).zzM(zzaVar.zzbr());
                return this;
            }

            public zza zzl(zzap zzapVar) {
                zzbu();
                ((zzbg) this.zza).zzM(zzapVar);
                return this;
            }

            public zza zzm(zzq zzqVar) {
                zzbu();
                ((zzbg) this.zza).zzN(zzqVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbh
            public boolean zzn() {
                return ((zzbg) this.zza).zzn();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbh
            public boolean zzo() {
                return ((zzbg) this.zza).zzo();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbh
            public boolean zzp() {
                return ((zzbg) this.zza).zzp();
            }

            private zza() {
                super(zzbg.zzd);
            }
        }

        static {
            zzbg zzbgVar = new zzbg();
            zzd = zzbgVar;
            zzgzh.zzbZ(zzbg.class, zzbgVar);
        }

        private zzbg() {
        }

        public void zzG() {
            this.zzh = null;
            this.zzf &= -3;
        }

        public void zzH() {
            this.zzi = null;
            this.zzf &= -5;
        }

        public void zzI() {
            this.zzf &= -2;
            this.zzg = 1000;
        }

        public void zzJ(zzaw zzawVar) {
            zzawVar.getClass();
            zzaw zzawVar2 = this.zzh;
            if (zzawVar2 != null && zzawVar2 != zzaw.zzg()) {
                zzaw.zza zzaVarZzb = zzaw.zzb(zzawVar2);
                zzaVarZzb.zzbj(zzawVar);
                zzawVar = zzaVarZzb.zzbs();
            }
            this.zzh = zzawVar;
            this.zzf |= 2;
        }

        public void zzK(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzi;
            if (zzapVar2 != null && zzapVar2 != zzap.zzi()) {
                zzap.zza zzaVarZzd = zzap.zzd(zzapVar2);
                zzaVarZzd.zzbj(zzapVar);
                zzapVar = zzaVarZzd.zzbs();
            }
            this.zzi = zzapVar;
            this.zzf |= 4;
        }

        public void zzL(zzaw zzawVar) {
            zzawVar.getClass();
            this.zzh = zzawVar;
            this.zzf |= 2;
        }

        public void zzM(zzap zzapVar) {
            zzapVar.getClass();
            this.zzi = zzapVar;
            this.zzf |= 4;
        }

        public void zzN(zzq zzqVar) {
            this.zzg = zzqVar.zza();
            this.zzf |= 1;
        }

        public static zza zzd() {
            return (zza) zzd.zzaZ();
        }

        public static zza zzf(zzbg zzbgVar) {
            return (zza) zzd.zzba(zzbgVar);
        }

        public static zzbg zzh() {
            return zzd;
        }

        public static zzbg zzi(InputStream inputStream) {
            return (zzbg) zzgzh.zzbk(zzd, inputStream);
        }

        public static zzbg zzj(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzbg) zzgzh.zzbl(zzd, inputStream, zzgyrVar);
        }

        public static zzbg zzk(zzgxz zzgxzVar) {
            return (zzbg) zzgzh.zzbm(zzd, zzgxzVar);
        }

        public static zzbg zzl(zzgyf zzgyfVar) {
            return (zzbg) zzgzh.zzbn(zzd, zzgyfVar);
        }

        public static zzbg zzm(InputStream inputStream) {
            return (zzbg) zzgzh.zzbo(zzd, inputStream);
        }

        public static zzbg zzq(ByteBuffer byteBuffer) {
            return (zzbg) zzgzh.zzbp(zzd, byteBuffer);
        }

        public static zzbg zzr(byte[] bArr) {
            return (zzbg) zzgzh.zzbq(zzd, bArr);
        }

        public static zzbg zzs(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzbg) zzgzh.zzbr(zzd, zzgxzVar, zzgyrVar);
        }

        public static zzbg zzt(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzbg) zzgzh.zzbs(zzd, zzgyfVar, zzgyrVar);
        }

        public static zzbg zzu(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzbg) zzgzh.zzbu(zzd, inputStream, zzgyrVar);
        }

        public static zzbg zzv(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzbg) zzgzh.zzbv(zzd, byteBuffer, zzgyrVar);
        }

        public static zzbg zzw(byte[] bArr, zzgyr zzgyrVar) {
            return (zzbg) zzgzh.zzbx(zzd, bArr, zzgyrVar);
        }

        public static zzhba<zzbg> zzx() {
            return zzd.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbh
        public zzq zza() {
            zzq zzqVarZzb = zzq.zzb(this.zzg);
            return zzqVarZzb == null ? zzq.ENUM_UNKNOWN : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbh
        public zzap zzb() {
            zzap zzapVar = this.zzi;
            return zzapVar == null ? zzap.zzi() : zzapVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbh
        public zzaw zzc() {
            zzaw zzawVar = this.zzh;
            return zzawVar == null ? zzaw.zzg() : zzawVar;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzd, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzf", "zzg", zzq.zze(), "zzh", "zzi"});
            }
            if (iOrdinal == 3) {
                return new zzbg();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzd;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzbg> zzgzcVar = zze;
            if (zzgzcVar == null) {
                synchronized (zzbg.class) {
                    try {
                        zzgzcVar = zze;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzd);
                            zze = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbh
        public boolean zzn() {
            return (this.zzf & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbh
        public boolean zzo() {
            return (this.zzf & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbh
        public boolean zzp() {
            return (this.zzf & 1) != 0;
        }
    }

    public interface zzbh extends zzhat {
        zzq zza();

        zzap zzb();

        zzaw zzc();

        boolean zzn();

        boolean zzo();

        boolean zzp();
    }

    public interface zzbi extends zzhat {
        int zza();

        boolean zzaA();

        boolean zzaB();

        zzau zzaf();

        zzay zzag();

        zzba zzah();

        zzbc zzai();

        zzbe zzaj();

        zzbg zzak();

        zzbj zzal();

        boolean zzam();

        boolean zzan();

        boolean zzao();

        boolean zzap();

        boolean zzaq();

        boolean zzar();

        boolean zzas();

        boolean zzat();

        boolean zzau();

        boolean zzav();

        boolean zzaw();

        boolean zzax();

        boolean zzay();

        boolean zzaz();

        int zzb();

        int zzc();

        int zzd();

        int zze();

        int zzf();

        int zzg();

        long zzh();

        zzap zzi();
    }

    public final class zzbj extends zzgzh<zzbj, zza> implements zzbk {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzbj zzc;
        private static volatile zzhba<zzbj> zzd;
        private int zze;
        private int zzf = 1000;
        private zzaw zzg;

        public final class zza extends zzgzb<zzbj, zza> implements zzbk {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbk
            public zzq zza() {
                return ((zzbj) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbk
            public zzaw zzb() {
                return ((zzbj) this.zza).zzb();
            }

            public zza zzc() {
                zzbu();
                ((zzbj) this.zza).zzB();
                return this;
            }

            public zza zzd() {
                zzbu();
                ((zzbj) this.zza).zzC();
                return this;
            }

            public zza zze(zzaw zzawVar) {
                zzbu();
                ((zzbj) this.zza).zzD(zzawVar);
                return this;
            }

            public zza zzf(zzaw.zza zzaVar) {
                zzbu();
                ((zzbj) this.zza).zzE(zzaVar.zzbr());
                return this;
            }

            public zza zzg(zzaw zzawVar) {
                zzbu();
                ((zzbj) this.zza).zzE(zzawVar);
                return this;
            }

            public zza zzh(zzq zzqVar) {
                zzbu();
                ((zzbj) this.zza).zzF(zzqVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbk
            public boolean zzi() {
                return ((zzbj) this.zza).zzi();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbk
            public boolean zzj() {
                return ((zzbj) this.zza).zzj();
            }

            private zza() {
                super(zzbj.zzc);
            }
        }

        static {
            zzbj zzbjVar = new zzbj();
            zzc = zzbjVar;
            zzgzh.zzbZ(zzbj.class, zzbjVar);
        }

        private zzbj() {
        }

        public void zzB() {
            this.zzg = null;
            this.zze &= -3;
        }

        public void zzC() {
            this.zze &= -2;
            this.zzf = 1000;
        }

        public void zzD(zzaw zzawVar) {
            zzawVar.getClass();
            zzaw zzawVar2 = this.zzg;
            if (zzawVar2 != null && zzawVar2 != zzaw.zzg()) {
                zzaw.zza zzaVarZzb = zzaw.zzb(zzawVar2);
                zzaVarZzb.zzbj(zzawVar);
                zzawVar = zzaVarZzb.zzbs();
            }
            this.zzg = zzawVar;
            this.zze |= 2;
        }

        public void zzE(zzaw zzawVar) {
            zzawVar.getClass();
            this.zzg = zzawVar;
            this.zze |= 2;
        }

        public void zzF(zzq zzqVar) {
            this.zzf = zzqVar.zza();
            this.zze |= 1;
        }

        public static zza zzc() {
            return (zza) zzc.zzaZ();
        }

        public static zza zzd(zzbj zzbjVar) {
            return (zza) zzc.zzba(zzbjVar);
        }

        public static zzbj zzg() {
            return zzc;
        }

        public static zzbj zzh(InputStream inputStream) {
            return (zzbj) zzgzh.zzbk(zzc, inputStream);
        }

        public static zzbj zzk(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzbj) zzgzh.zzbl(zzc, inputStream, zzgyrVar);
        }

        public static zzbj zzl(zzgxz zzgxzVar) {
            return (zzbj) zzgzh.zzbm(zzc, zzgxzVar);
        }

        public static zzbj zzm(zzgyf zzgyfVar) {
            return (zzbj) zzgzh.zzbn(zzc, zzgyfVar);
        }

        public static zzbj zzn(InputStream inputStream) {
            return (zzbj) zzgzh.zzbo(zzc, inputStream);
        }

        public static zzbj zzo(ByteBuffer byteBuffer) {
            return (zzbj) zzgzh.zzbp(zzc, byteBuffer);
        }

        public static zzbj zzp(byte[] bArr) {
            return (zzbj) zzgzh.zzbq(zzc, bArr);
        }

        public static zzbj zzq(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzbj) zzgzh.zzbr(zzc, zzgxzVar, zzgyrVar);
        }

        public static zzbj zzr(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzbj) zzgzh.zzbs(zzc, zzgyfVar, zzgyrVar);
        }

        public static zzbj zzs(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzbj) zzgzh.zzbu(zzc, inputStream, zzgyrVar);
        }

        public static zzbj zzt(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzbj) zzgzh.zzbv(zzc, byteBuffer, zzgyrVar);
        }

        public static zzbj zzu(byte[] bArr, zzgyr zzgyrVar) {
            return (zzbj) zzgzh.zzbx(zzc, bArr, zzgyrVar);
        }

        public static zzhba<zzbj> zzv() {
            return zzc.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbk
        public zzq zza() {
            zzq zzqVarZzb = zzq.zzb(this.zzf);
            return zzqVarZzb == null ? zzq.ENUM_UNKNOWN : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbk
        public zzaw zzb() {
            zzaw zzawVar = this.zzg;
            return zzawVar == null ? zzaw.zzg() : zzawVar;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", zzq.zze(), "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzbj();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzc;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzbj> zzgzcVar = zzd;
            if (zzgzcVar == null) {
                synchronized (zzbj.class) {
                    try {
                        zzgzcVar = zzd;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzc);
                            zzd = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbk
        public boolean zzi() {
            return (this.zze & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbk
        public boolean zzj() {
            return (this.zze & 1) != 0;
        }
    }

    public interface zzbk extends zzhat {
        zzq zza();

        zzaw zzb();

        boolean zzi();

        boolean zzj();
    }

    public final class zzbl extends zzgzh<zzbl, zza> implements zzbm {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzbl zzc;
        private static volatile zzhba<zzbl> zzd;
        private int zze;
        private boolean zzf;
        private int zzg;

        public final class zza extends zzgzb<zzbl, zza> implements zzbm {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbm
            public int zza() {
                return ((zzbl) this.zza).zza();
            }

            public zza zzb() {
                zzbu();
                ((zzbl) this.zza).zzA();
                return this;
            }

            public zza zzc() {
                zzbu();
                ((zzbl) this.zza).zzB();
                return this;
            }

            public zza zzd(boolean z) {
                zzbu();
                ((zzbl) this.zza).zzC(z);
                return this;
            }

            public zza zze(int i) {
                zzbu();
                ((zzbl) this.zza).zzD(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbm
            public boolean zzf() {
                return ((zzbl) this.zza).zzf();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbm
            public boolean zzg() {
                return ((zzbl) this.zza).zzg();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzbm
            public boolean zzh() {
                return ((zzbl) this.zza).zzh();
            }

            private zza() {
                super(zzbl.zzc);
            }
        }

        static {
            zzbl zzblVar = new zzbl();
            zzc = zzblVar;
            zzgzh.zzbZ(zzbl.class, zzblVar);
        }

        private zzbl() {
        }

        public void zzA() {
            this.zze &= -2;
            this.zzf = false;
        }

        public void zzB() {
            this.zze &= -3;
            this.zzg = 0;
        }

        public void zzC(boolean z) {
            this.zze |= 1;
            this.zzf = z;
        }

        public void zzD(int i) {
            this.zze |= 2;
            this.zzg = i;
        }

        public static zza zzb() {
            return (zza) zzc.zzaZ();
        }

        public static zza zzc(zzbl zzblVar) {
            return (zza) zzc.zzba(zzblVar);
        }

        public static zzbl zzi() {
            return zzc;
        }

        public static zzbl zzj(InputStream inputStream) {
            return (zzbl) zzgzh.zzbk(zzc, inputStream);
        }

        public static zzbl zzk(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzbl) zzgzh.zzbl(zzc, inputStream, zzgyrVar);
        }

        public static zzbl zzl(zzgxz zzgxzVar) {
            return (zzbl) zzgzh.zzbm(zzc, zzgxzVar);
        }

        public static zzbl zzm(zzgyf zzgyfVar) {
            return (zzbl) zzgzh.zzbn(zzc, zzgyfVar);
        }

        public static zzbl zzn(InputStream inputStream) {
            return (zzbl) zzgzh.zzbo(zzc, inputStream);
        }

        public static zzbl zzo(ByteBuffer byteBuffer) {
            return (zzbl) zzgzh.zzbp(zzc, byteBuffer);
        }

        public static zzbl zzp(byte[] bArr) {
            return (zzbl) zzgzh.zzbq(zzc, bArr);
        }

        public static zzbl zzq(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzbl) zzgzh.zzbr(zzc, zzgxzVar, zzgyrVar);
        }

        public static zzbl zzr(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzbl) zzgzh.zzbs(zzc, zzgyfVar, zzgyrVar);
        }

        public static zzbl zzs(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzbl) zzgzh.zzbu(zzc, inputStream, zzgyrVar);
        }

        public static zzbl zzt(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzbl) zzgzh.zzbv(zzc, byteBuffer, zzgyrVar);
        }

        public static zzbl zzu(byte[] bArr, zzgyr zzgyrVar) {
            return (zzbl) zzgzh.zzbx(zzc, bArr, zzgyrVar);
        }

        public static zzhba<zzbl> zzv() {
            return zzc.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbm
        public int zza() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002င\u0001", new Object[]{"zze", "zzf", "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzbl();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzc;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzbl> zzgzcVar = zzd;
            if (zzgzcVar == null) {
                synchronized (zzbl.class) {
                    try {
                        zzgzcVar = zzd;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzc);
                            zzd = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbm
        public boolean zzf() {
            return this.zzf;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbm
        public boolean zzg() {
            return (this.zze & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzbm
        public boolean zzh() {
            return (this.zze & 2) != 0;
        }
    }

    public interface zzbm extends zzhat {
        int zza();

        boolean zzf();

        boolean zzg();

        boolean zzh();
    }

    public interface zzc extends zzhat {
        int zza();

        zzb.zza zzb(int i);

        List<zzb.zza> zzl();
    }

    public final class zzd extends zzgzh<zzd, zzb> implements zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzd zzc;
        private static volatile zzhba<zzd> zzd;
        private int zze;
        private int zzf;
        private zzal zzg;

        public enum zza implements zzgzl {
            AD_FORMAT_TYPE_UNSPECIFIED(0),
            BANNER(1),
            INTERSTITIAL(2),
            NATIVE_EXPRESS(3),
            NATIVE_CONTENT(4),
            NATIVE_APP_INSTALL(5),
            NATIVE_CUSTOM_TEMPLATE(6),
            DFP_BANNER(7),
            DFP_INTERSTITIAL(8),
            REWARD_BASED_VIDEO_AD(9),
            BANNER_SEARCH_ADS(10);

            public static final int zzl = 0;
            public static final int zzm = 1;
            public static final int zzn = 2;
            public static final int zzo = 3;
            public static final int zzp = 4;
            public static final int zzq = 5;
            public static final int zzr = 6;
            public static final int zzs = 7;
            public static final int zzt = 8;
            public static final int zzu = 9;
            public static final int zzv = 10;
            private static final zzgzm<zza> zzw = new zzgzm<zza>() { // from class: com.google.android.gms.internal.ads.zzbcj.zzd.zza.1
                /* JADX INFO: renamed from: zza */
                public zza zzb(int i) {
                    return zza.zzb(i);
                }
            };
            private final int zzy;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zzd$zza$1 */
            public class AnonymousClass1 implements zzgzm<zza> {
                /* JADX INFO: renamed from: zza */
                public zza zzb(int i) {
                    return zza.zzb(i);
                }
            }

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zzd$zza$zza */
            final class C0006zza implements zzgzn {
                static final zzgzn zza = new C0006zza();

                private C0006zza() {
                }

                @Override // com.google.android.gms.internal.ads.zzgzn
                public boolean zza(int i) {
                    return zza.zzb(i) != null;
                }
            }

            zza(int i) {
                this.zzy = i;
            }

            public static zza zzb(int i) {
                switch (i) {
                    case 0:
                        return AD_FORMAT_TYPE_UNSPECIFIED;
                    case 1:
                        return BANNER;
                    case 2:
                        return INTERSTITIAL;
                    case 3:
                        return NATIVE_EXPRESS;
                    case 4:
                        return NATIVE_CONTENT;
                    case 5:
                        return NATIVE_APP_INSTALL;
                    case 6:
                        return NATIVE_CUSTOM_TEMPLATE;
                    case 7:
                        return DFP_BANNER;
                    case 8:
                        return DFP_INTERSTITIAL;
                    case 9:
                        return REWARD_BASED_VIDEO_AD;
                    case 10:
                        return BANNER_SEARCH_ADS;
                    default:
                        return null;
                }
            }

            public static zzgzm<zza> zzd() {
                return zzw;
            }

            public static zzgzn zze() {
                return C0006zza.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.zzy);
            }

            @Override // com.google.android.gms.internal.ads.zzgzl
            public final int zza() {
                return this.zzy;
            }
        }

        public final class zzb extends zzgzb<zzd, zzb> implements zze {
            public /* synthetic */ zzb() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zze
            public zza zza() {
                return ((zzd) this.zza).zza();
            }

            public zzb zzb() {
                zzbu();
                ((zzd) this.zza).zzB();
                return this;
            }

            public zzb zzc() {
                zzbu();
                ((zzd) this.zza).zzC();
                return this;
            }

            public zzb zzd(zzal zzalVar) {
                zzbu();
                ((zzd) this.zza).zzD(zzalVar);
                return this;
            }

            public zzb zze(zzal.zza zzaVar) {
                zzbu();
                ((zzd) this.zza).zzE(zzaVar.zzbr());
                return this;
            }

            public zzb zzf(zzal zzalVar) {
                zzbu();
                ((zzd) this.zza).zzE(zzalVar);
                return this;
            }

            public zzb zzg(zza zzaVar) {
                zzbu();
                ((zzd) this.zza).zzF(zzaVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zze
            public zzal zzh() {
                return ((zzd) this.zza).zzh();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zze
            public boolean zzi() {
                return ((zzd) this.zza).zzi();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zze
            public boolean zzj() {
                return ((zzd) this.zza).zzj();
            }

            private zzb() {
                super(zzd.zzc);
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzc = zzdVar;
            zzgzh.zzbZ(zzd.class, zzdVar);
        }

        private zzd() {
        }

        public void zzB() {
            this.zzg = null;
            this.zze &= -3;
        }

        public void zzC() {
            this.zze &= -2;
            this.zzf = 0;
        }

        public void zzD(zzal zzalVar) {
            zzalVar.getClass();
            zzal zzalVar2 = this.zzg;
            if (zzalVar2 != null && zzalVar2 != zzal.zzi()) {
                zzal.zza zzaVarZzd = zzal.zzd(zzalVar2);
                zzaVarZzd.zzbj(zzalVar);
                zzalVar = zzaVarZzd.zzbs();
            }
            this.zzg = zzalVar;
            this.zze |= 2;
        }

        public void zzE(zzal zzalVar) {
            zzalVar.getClass();
            this.zzg = zzalVar;
            this.zze |= 2;
        }

        public void zzF(zza zzaVar) {
            this.zzf = zzaVar.zza();
            this.zze |= 1;
        }

        public static zzb zzb() {
            return (zzb) zzc.zzaZ();
        }

        public static zzb zzc(zzd zzdVar) {
            return (zzb) zzc.zzba(zzdVar);
        }

        public static zzd zzf() {
            return zzc;
        }

        public static zzd zzg(InputStream inputStream) {
            return (zzd) zzgzh.zzbk(zzc, inputStream);
        }

        public static zzd zzk(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzd) zzgzh.zzbl(zzc, inputStream, zzgyrVar);
        }

        public static zzd zzl(zzgxz zzgxzVar) {
            return (zzd) zzgzh.zzbm(zzc, zzgxzVar);
        }

        public static zzd zzm(zzgyf zzgyfVar) {
            return (zzd) zzgzh.zzbn(zzc, zzgyfVar);
        }

        public static zzd zzn(InputStream inputStream) {
            return (zzd) zzgzh.zzbo(zzc, inputStream);
        }

        public static zzd zzo(ByteBuffer byteBuffer) {
            return (zzd) zzgzh.zzbp(zzc, byteBuffer);
        }

        public static zzd zzp(byte[] bArr) {
            return (zzd) zzgzh.zzbq(zzc, bArr);
        }

        public static zzd zzq(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzd) zzgzh.zzbr(zzc, zzgxzVar, zzgyrVar);
        }

        public static zzd zzr(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzd) zzgzh.zzbs(zzc, zzgyfVar, zzgyrVar);
        }

        public static zzd zzs(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzd) zzgzh.zzbu(zzc, inputStream, zzgyrVar);
        }

        public static zzd zzt(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzd) zzgzh.zzbv(zzc, byteBuffer, zzgyrVar);
        }

        public static zzd zzu(byte[] bArr, zzgyr zzgyrVar) {
            return (zzd) zzgzh.zzbx(zzc, bArr, zzgyrVar);
        }

        public static zzhba<zzd> zzv() {
            return zzc.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zze
        public zza zza() {
            zza zzaVarZzb = zza.zzb(this.zzf);
            return zzaVarZzb == null ? zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", zza.zze(), "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzd();
            }
            if (iOrdinal == 4) {
                return new zzb();
            }
            if (iOrdinal == 5) {
                return zzc;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzd> zzgzcVar = zzd;
            if (zzgzcVar == null) {
                synchronized (zzd.class) {
                    try {
                        zzgzcVar = zzd;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzc);
                            zzd = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zze
        public zzal zzh() {
            zzal zzalVar = this.zzg;
            return zzalVar == null ? zzal.zzi() : zzalVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zze
        public boolean zzi() {
            return (this.zze & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zze
        public boolean zzj() {
            return (this.zze & 1) != 0;
        }
    }

    public interface zze extends zzhat {
        zzd.zza zza();

        zzal zzh();

        boolean zzi();

        boolean zzj();
    }

    public interface zzf extends zzhat {
        int zza();

        zzd zzab(int i);

        zzg zzac();

        zzi zzad();

        zzk zzae();

        zzq zzaf();

        zzx zzag();

        zzz zzah();

        zzac zzai();

        zzah zzaj();

        zzat zzak(int i);

        List<zzd> zzal();

        List<zzat> zzam();

        boolean zzan();

        boolean zzao();

        boolean zzap();

        boolean zzaq();

        boolean zzar();

        boolean zzas();

        boolean zzat();

        boolean zzau();

        boolean zzav();

        int zzb();

        zza.EnumC0001zza zzc();
    }

    public final class zzg extends zzgzh<zzg, zza> implements zzh {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzg zzd;
        private static volatile zzhba<zzg> zze;
        private int zzf;
        private String zzg = "";
        private zzgzt<zzd> zzh = zzgzh.zzbK();
        private int zzi;

        public final class zza extends zzgzb<zzg, zza> implements zzh {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzh
            public int zza() {
                return ((zzg) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzh
            public zzd zzb(int i) {
                return ((zzg) this.zza).zzb(i);
            }

            public zza zzc(Iterable<? extends zzd> iterable) {
                zzbu();
                ((zzg) this.zza).zzN(iterable);
                return this;
            }

            public zza zzd(zzd.zzb zzbVar) {
                zzbu();
                ((zzg) this.zza).zzO(zzbVar.zzbr());
                return this;
            }

            public zza zze(zzd zzdVar) {
                zzbu();
                ((zzg) this.zza).zzO(zzdVar);
                return this;
            }

            public zza zzf(int i, zzd.zzb zzbVar) {
                zzbu();
                ((zzg) this.zza).zzP(i, zzbVar.zzbr());
                return this;
            }

            public zza zzg(int i, zzd zzdVar) {
                zzbu();
                ((zzg) this.zza).zzP(i, zzdVar);
                return this;
            }

            public zza zzh() {
                zzbu();
                ((zzg) this.zza).zzQ();
                return this;
            }

            public zza zzi() {
                zzbu();
                ((zzg) this.zza).zzR();
                return this;
            }

            public zza zzj() {
                zzbu();
                ((zzg) this.zza).zzS();
                return this;
            }

            public zza zzk(int i) {
                zzbu();
                ((zzg) this.zza).zzU(i);
                return this;
            }

            public zza zzl(String str) {
                zzbu();
                ((zzg) this.zza).zzV(str);
                return this;
            }

            public zza zzm(zzgxz zzgxzVar) {
                zzbu();
                ((zzg) this.zza).zzW(zzgxzVar);
                return this;
            }

            public zza zzn(zzq zzqVar) {
                zzbu();
                ((zzg) this.zza).zzX(zzqVar);
                return this;
            }

            public zza zzo(int i, zzd.zzb zzbVar) {
                zzbu();
                ((zzg) this.zza).zzY(i, zzbVar.zzbr());
                return this;
            }

            public zza zzp(int i, zzd zzdVar) {
                zzbu();
                ((zzg) this.zza).zzY(i, zzdVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzh
            public zzq zzq() {
                return ((zzg) this.zza).zzq();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzh
            public zzgxz zzr() {
                return ((zzg) this.zza).zzr();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzh
            public String zzs() {
                return ((zzg) this.zza).zzs();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzh
            public List<zzd> zzt() {
                return Collections.unmodifiableList(((zzg) this.zza).zzt());
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzh
            public boolean zzu() {
                return ((zzg) this.zza).zzu();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzh
            public boolean zzv() {
                return ((zzg) this.zza).zzv();
            }

            private zza() {
                super(zzg.zzd);
            }
        }

        static {
            zzg zzgVar = new zzg();
            zzd = zzgVar;
            zzgzh.zzbZ(zzg.class, zzgVar);
        }

        private zzg() {
        }

        public static zzhba<zzg> zzA() {
            return zzd.zzbN();
        }

        public void zzN(Iterable<? extends zzd> iterable) {
            zzT();
            zzgxi.zzaQ(iterable, this.zzh);
        }

        public void zzO(zzd zzdVar) {
            zzdVar.getClass();
            zzT();
            this.zzh.add(zzdVar);
        }

        public void zzP(int i, zzd zzdVar) {
            zzdVar.getClass();
            zzT();
            this.zzh.add(i, zzdVar);
        }

        public void zzQ() {
            this.zzf &= -2;
            this.zzg = zzh().zzs();
        }

        public void zzR() {
            this.zzf &= -3;
            this.zzi = 0;
        }

        public void zzS() {
            this.zzh = zzgzh.zzbK();
        }

        private void zzT() {
            zzgzt<zzd> zzgztVar = this.zzh;
            if (zzgztVar.zzc()) {
                return;
            }
            this.zzh = zzgzh.zzbL(zzgztVar);
        }

        public void zzU(int i) {
            zzT();
            this.zzh.remove(i);
        }

        public void zzV(String str) {
            str.getClass();
            this.zzf |= 1;
            this.zzg = str;
        }

        public void zzW(zzgxz zzgxzVar) {
            this.zzg = zzgxzVar.zzx();
            this.zzf |= 1;
        }

        public void zzX(zzq zzqVar) {
            this.zzi = zzqVar.zza();
            this.zzf |= 2;
        }

        public void zzY(int i, zzd zzdVar) {
            zzdVar.getClass();
            zzT();
            this.zzh.set(i, zzdVar);
        }

        public static zza zzd() {
            return (zza) zzd.zzaZ();
        }

        public static zza zzf(zzg zzgVar) {
            return (zza) zzd.zzba(zzgVar);
        }

        public static zzg zzh() {
            return zzd;
        }

        public static zzg zzi(InputStream inputStream) {
            return (zzg) zzgzh.zzbk(zzd, inputStream);
        }

        public static zzg zzj(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzg) zzgzh.zzbl(zzd, inputStream, zzgyrVar);
        }

        public static zzg zzk(zzgxz zzgxzVar) {
            return (zzg) zzgzh.zzbm(zzd, zzgxzVar);
        }

        public static zzg zzl(zzgyf zzgyfVar) {
            return (zzg) zzgzh.zzbn(zzd, zzgyfVar);
        }

        public static zzg zzm(InputStream inputStream) {
            return (zzg) zzgzh.zzbo(zzd, inputStream);
        }

        public static zzg zzn(ByteBuffer byteBuffer) {
            return (zzg) zzgzh.zzbp(zzd, byteBuffer);
        }

        public static zzg zzo(byte[] bArr) {
            return (zzg) zzgzh.zzbq(zzd, bArr);
        }

        public static zzg zzp(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzg) zzgzh.zzbr(zzd, zzgxzVar, zzgyrVar);
        }

        public static zzg zzw(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzg) zzgzh.zzbs(zzd, zzgyfVar, zzgyrVar);
        }

        public static zzg zzx(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzg) zzgzh.zzbu(zzd, inputStream, zzgyrVar);
        }

        public static zzg zzy(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzg) zzgzh.zzbv(zzd, byteBuffer, zzgyrVar);
        }

        public static zzg zzz(byte[] bArr, zzgyr zzgyrVar) {
            return (zzg) zzgzh.zzbx(zzd, bArr, zzgyrVar);
        }

        public List<? extends zze> zzB() {
            return this.zzh;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzh
        public int zza() {
            return this.zzh.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzh
        public zzd zzb(int i) {
            return this.zzh.get(i);
        }

        public zze zzc(int i) {
            return this.zzh.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzd, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003᠌\u0001", new Object[]{"zzf", "zzg", "zzh", zzd.class, "zzi", zzq.zze()});
            }
            if (iOrdinal == 3) {
                return new zzg();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzd;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzg> zzgzcVar = zze;
            if (zzgzcVar == null) {
                synchronized (zzg.class) {
                    try {
                        zzgzcVar = zze;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzd);
                            zze = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzh
        public zzq zzq() {
            zzq zzqVarZzb = zzq.zzb(this.zzi);
            return zzqVarZzb == null ? zzq.ENUM_FALSE : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzh
        public zzgxz zzr() {
            return zzgxz.zzw(this.zzg);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzh
        public String zzs() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzh
        public List<zzd> zzt() {
            return this.zzh;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzh
        public boolean zzu() {
            return (this.zzf & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzh
        public boolean zzv() {
            return (this.zzf & 2) != 0;
        }
    }

    public interface zzh extends zzhat {
        int zza();

        zzd zzb(int i);

        zzq zzq();

        zzgxz zzr();

        String zzs();

        List<zzd> zzt();

        boolean zzu();

        boolean zzv();
    }

    public final class zzi extends zzgzh<zzi, zza> implements zzj {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        private static final zzi zzf;
        private static volatile zzhba<zzi> zzg;
        private int zzh;
        private String zzi = "";
        private zzgzt<zzd> zzj = zzgzh.zzbK();
        private int zzk = 1000;
        private int zzl = 1000;
        private int zzm = 1000;

        public final class zza extends zzgzb<zzi, zza> implements zzj {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzj
            public boolean zzA() {
                return ((zzi) this.zza).zzA();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzj
            public boolean zzB() {
                return ((zzi) this.zza).zzB();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzj
            public boolean zzC() {
                return ((zzi) this.zza).zzC();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzj
            public boolean zzD() {
                return ((zzi) this.zza).zzD();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzj
            public int zza() {
                return ((zzi) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzj
            public zzd zzb(int i) {
                return ((zzi) this.zza).zzb(i);
            }

            public zza zzc(Iterable<? extends zzd> iterable) {
                zzbu();
                ((zzi) this.zza).zzV(iterable);
                return this;
            }

            public zza zzd(zzd.zzb zzbVar) {
                zzbu();
                ((zzi) this.zza).zzW(zzbVar.zzbr());
                return this;
            }

            public zza zze(zzd zzdVar) {
                zzbu();
                ((zzi) this.zza).zzW(zzdVar);
                return this;
            }

            public zza zzf(int i, zzd.zzb zzbVar) {
                zzbu();
                ((zzi) this.zza).zzX(i, zzbVar.zzbr());
                return this;
            }

            public zza zzg(int i, zzd zzdVar) {
                zzbu();
                ((zzi) this.zza).zzX(i, zzdVar);
                return this;
            }

            public zza zzh() {
                zzbu();
                ((zzi) this.zza).zzY();
                return this;
            }

            public zza zzi() {
                zzbu();
                ((zzi) this.zza).zzZ();
                return this;
            }

            public zza zzj() {
                zzbu();
                ((zzi) this.zza).zzaa();
                return this;
            }

            public zza zzk() {
                zzbu();
                ((zzi) this.zza).zzab();
                return this;
            }

            public zza zzl() {
                zzbu();
                ((zzi) this.zza).zzac();
                return this;
            }

            public zza zzm(int i) {
                zzbu();
                ((zzi) this.zza).zzae(i);
                return this;
            }

            public zza zzn(zzq zzqVar) {
                zzbu();
                ((zzi) this.zza).zzaf(zzqVar);
                return this;
            }

            public zza zzo(String str) {
                zzbu();
                ((zzi) this.zza).zzag(str);
                return this;
            }

            public zza zzp(zzgxz zzgxzVar) {
                zzbu();
                ((zzi) this.zza).zzah(zzgxzVar);
                return this;
            }

            public zza zzq(zzq zzqVar) {
                zzbu();
                ((zzi) this.zza).zzai(zzqVar);
                return this;
            }

            public zza zzr(zzq zzqVar) {
                zzbu();
                ((zzi) this.zza).zzaj(zzqVar);
                return this;
            }

            public zza zzs(int i, zzd.zzb zzbVar) {
                zzbu();
                ((zzi) this.zza).zzak(i, zzbVar.zzbr());
                return this;
            }

            public zza zzt(int i, zzd zzdVar) {
                zzbu();
                ((zzi) this.zza).zzak(i, zzdVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzj
            public zzq zzu() {
                return ((zzi) this.zza).zzu();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzj
            public zzq zzv() {
                return ((zzi) this.zza).zzv();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzj
            public zzq zzw() {
                return ((zzi) this.zza).zzw();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzj
            public zzgxz zzx() {
                return ((zzi) this.zza).zzx();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzj
            public String zzy() {
                return ((zzi) this.zza).zzy();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzj
            public List<zzd> zzz() {
                return Collections.unmodifiableList(((zzi) this.zza).zzz());
            }

            private zza() {
                super(zzi.zzf);
            }
        }

        static {
            zzi zziVar = new zzi();
            zzf = zziVar;
            zzgzh.zzbZ(zzi.class, zziVar);
        }

        private zzi() {
        }

        public static zzhba<zzi> zzE() {
            return zzf.zzbN();
        }

        public void zzV(Iterable<? extends zzd> iterable) {
            zzad();
            zzgxi.zzaQ(iterable, this.zzj);
        }

        public void zzW(zzd zzdVar) {
            zzdVar.getClass();
            zzad();
            this.zzj.add(zzdVar);
        }

        public void zzX(int i, zzd zzdVar) {
            zzdVar.getClass();
            zzad();
            this.zzj.add(i, zzdVar);
        }

        public void zzY() {
            this.zzh &= -9;
            this.zzm = 1000;
        }

        public void zzZ() {
            this.zzh &= -2;
            this.zzi = zzh().zzy();
        }

        public void zzaa() {
            this.zzh &= -5;
            this.zzl = 1000;
        }

        public void zzab() {
            this.zzh &= -3;
            this.zzk = 1000;
        }

        public void zzac() {
            this.zzj = zzgzh.zzbK();
        }

        private void zzad() {
            zzgzt<zzd> zzgztVar = this.zzj;
            if (zzgztVar.zzc()) {
                return;
            }
            this.zzj = zzgzh.zzbL(zzgztVar);
        }

        public void zzae(int i) {
            zzad();
            this.zzj.remove(i);
        }

        public void zzaf(zzq zzqVar) {
            this.zzm = zzqVar.zza();
            this.zzh |= 8;
        }

        public void zzag(String str) {
            str.getClass();
            this.zzh |= 1;
            this.zzi = str;
        }

        public void zzah(zzgxz zzgxzVar) {
            this.zzi = zzgxzVar.zzx();
            this.zzh |= 1;
        }

        public void zzai(zzq zzqVar) {
            this.zzl = zzqVar.zza();
            this.zzh |= 4;
        }

        public void zzaj(zzq zzqVar) {
            this.zzk = zzqVar.zza();
            this.zzh |= 2;
        }

        public void zzak(int i, zzd zzdVar) {
            zzdVar.getClass();
            zzad();
            this.zzj.set(i, zzdVar);
        }

        public static zza zzd() {
            return (zza) zzf.zzaZ();
        }

        public static zza zzf(zzi zziVar) {
            return (zza) zzf.zzba(zziVar);
        }

        public static zzi zzh() {
            return zzf;
        }

        public static zzi zzi(InputStream inputStream) {
            return (zzi) zzgzh.zzbk(zzf, inputStream);
        }

        public static zzi zzj(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzi) zzgzh.zzbl(zzf, inputStream, zzgyrVar);
        }

        public static zzi zzk(zzgxz zzgxzVar) {
            return (zzi) zzgzh.zzbm(zzf, zzgxzVar);
        }

        public static zzi zzl(zzgyf zzgyfVar) {
            return (zzi) zzgzh.zzbn(zzf, zzgyfVar);
        }

        public static zzi zzm(InputStream inputStream) {
            return (zzi) zzgzh.zzbo(zzf, inputStream);
        }

        public static zzi zzn(ByteBuffer byteBuffer) {
            return (zzi) zzgzh.zzbp(zzf, byteBuffer);
        }

        public static zzi zzo(byte[] bArr) {
            return (zzi) zzgzh.zzbq(zzf, bArr);
        }

        public static zzi zzp(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzi) zzgzh.zzbr(zzf, zzgxzVar, zzgyrVar);
        }

        public static zzi zzq(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzi) zzgzh.zzbs(zzf, zzgyfVar, zzgyrVar);
        }

        public static zzi zzr(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzi) zzgzh.zzbu(zzf, inputStream, zzgyrVar);
        }

        public static zzi zzs(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzi) zzgzh.zzbv(zzf, byteBuffer, zzgyrVar);
        }

        public static zzi zzt(byte[] bArr, zzgyr zzgyrVar) {
            return (zzi) zzgzh.zzbx(zzf, bArr, zzgyrVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzj
        public boolean zzA() {
            return (this.zzh & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzj
        public boolean zzB() {
            return (this.zzh & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzj
        public boolean zzC() {
            return (this.zzh & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzj
        public boolean zzD() {
            return (this.zzh & 2) != 0;
        }

        public List<? extends zze> zzF() {
            return this.zzj;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzj
        public int zza() {
            return this.zzj.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzj
        public zzd zzb(int i) {
            return this.zzj.get(i);
        }

        public zze zzc(int i) {
            return this.zzj.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzf, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003᠌\u0001\u0004᠌\u0002\u0005᠌\u0003", new Object[]{"zzh", "zzi", "zzj", zzd.class, "zzk", zzq.zze(), "zzl", zzq.zze(), "zzm", zzq.zze()});
            }
            if (iOrdinal == 3) {
                return new zzi();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzi> zzgzcVar = zzg;
            if (zzgzcVar == null) {
                synchronized (zzi.class) {
                    try {
                        zzgzcVar = zzg;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzf);
                            zzg = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzj
        public zzq zzu() {
            zzq zzqVarZzb = zzq.zzb(this.zzm);
            return zzqVarZzb == null ? zzq.ENUM_UNKNOWN : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzj
        public zzq zzv() {
            zzq zzqVarZzb = zzq.zzb(this.zzl);
            return zzqVarZzb == null ? zzq.ENUM_UNKNOWN : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzj
        public zzq zzw() {
            zzq zzqVarZzb = zzq.zzb(this.zzk);
            return zzqVarZzb == null ? zzq.ENUM_UNKNOWN : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzj
        public zzgxz zzx() {
            return zzgxz.zzw(this.zzi);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzj
        public String zzy() {
            return this.zzi;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzj
        public List<zzd> zzz() {
            return this.zzj;
        }
    }

    public interface zzj extends zzhat {
        boolean zzA();

        boolean zzB();

        boolean zzC();

        boolean zzD();

        int zza();

        zzd zzb(int i);

        zzq zzu();

        zzq zzv();

        zzq zzw();

        zzgxz zzx();

        String zzy();

        List<zzd> zzz();
    }

    public final class zzk extends zzgzh<zzk, zza> implements zzl {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        private static final zzk zzg;
        private static volatile zzhba<zzk> zzh;
        private int zzi;
        private int zzj;
        private zzap zzk;
        private zzap zzl;
        private zzap zzm;
        private zzgzt<zzap> zzn = zzgzh.zzbK();
        private int zzo;

        public final class zza extends zzgzb<zzk, zza> implements zzl {
            public /* synthetic */ zza() {
                this();
            }

            public zza zzA(zzap zzapVar) {
                zzbu();
                ((zzk) this.zza).zzas(zzapVar);
                return this;
            }

            public zza zzB(int i) {
                zzbu();
                ((zzk) this.zza).zzat(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzl
            public zzap zzC() {
                return ((zzk) this.zza).zzC();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzl
            public zzap zzD() {
                return ((zzk) this.zza).zzD();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzl
            public zzap zzE(int i) {
                return ((zzk) this.zza).zzE(i);
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzl
            public zzap zzF() {
                return ((zzk) this.zza).zzF();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzl
            public List<zzap> zzG() {
                return Collections.unmodifiableList(((zzk) this.zza).zzG());
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzl
            public boolean zzH() {
                return ((zzk) this.zza).zzH();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzl
            public boolean zzI() {
                return ((zzk) this.zza).zzI();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzl
            public boolean zzJ() {
                return ((zzk) this.zza).zzJ();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzl
            public boolean zzK() {
                return ((zzk) this.zza).zzK();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzl
            public boolean zzL() {
                return ((zzk) this.zza).zzL();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzl
            public int zza() {
                return ((zzk) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzl
            public int zzb() {
                return ((zzk) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzl
            public int zzc() {
                return ((zzk) this.zza).zzc();
            }

            public zza zzd(zzap.zza zzaVar) {
                zzbu();
                ((zzk) this.zza).zzaa(zzaVar.zzbr());
                return this;
            }

            public zza zze(zzap zzapVar) {
                zzbu();
                ((zzk) this.zza).zzaa(zzapVar);
                return this;
            }

            public zza zzf(int i, zzap.zza zzaVar) {
                zzbu();
                ((zzk) this.zza).zzab(i, zzaVar.zzbr());
                return this;
            }

            public zza zzg(int i, zzap zzapVar) {
                zzbu();
                ((zzk) this.zza).zzab(i, zzapVar);
                return this;
            }

            public zza zzh(Iterable<? extends zzap> iterable) {
                zzbu();
                ((zzk) this.zza).zzac(iterable);
                return this;
            }

            public zza zzi() {
                zzbu();
                ((zzk) this.zza).zzad();
                return this;
            }

            public zza zzj() {
                zzbu();
                ((zzk) this.zza).zzae();
                return this;
            }

            public zza zzk() {
                zzbu();
                ((zzk) this.zza).zzaf();
                return this;
            }

            public zza zzl() {
                zzbu();
                ((zzk) this.zza).zzag();
                return this;
            }

            public zza zzm() {
                zzbu();
                ((zzk) this.zza).zzah();
                return this;
            }

            public zza zzn() {
                zzbu();
                ((zzk) this.zza).zzai();
                return this;
            }

            public zza zzo(zzap zzapVar) {
                zzbu();
                ((zzk) this.zza).zzak(zzapVar);
                return this;
            }

            public zza zzp(zzap zzapVar) {
                zzbu();
                ((zzk) this.zza).zzal(zzapVar);
                return this;
            }

            public zza zzq(zzap zzapVar) {
                zzbu();
                ((zzk) this.zza).zzam(zzapVar);
                return this;
            }

            public zza zzr(int i) {
                zzbu();
                ((zzk) this.zza).zzan(i);
                return this;
            }

            public zza zzs(int i) {
                zzbu();
                ((zzk) this.zza).zzao(i);
                return this;
            }

            public zza zzt(zzap.zza zzaVar) {
                zzbu();
                ((zzk) this.zza).zzap(zzaVar.zzbr());
                return this;
            }

            public zza zzu(zzap zzapVar) {
                zzbu();
                ((zzk) this.zza).zzap(zzapVar);
                return this;
            }

            public zza zzv(zzap.zza zzaVar) {
                zzbu();
                ((zzk) this.zza).zzaq(zzaVar.zzbr());
                return this;
            }

            public zza zzw(zzap zzapVar) {
                zzbu();
                ((zzk) this.zza).zzaq(zzapVar);
                return this;
            }

            public zza zzx(int i, zzap.zza zzaVar) {
                zzbu();
                ((zzk) this.zza).zzar(i, zzaVar.zzbr());
                return this;
            }

            public zza zzy(int i, zzap zzapVar) {
                zzbu();
                ((zzk) this.zza).zzar(i, zzapVar);
                return this;
            }

            public zza zzz(zzap.zza zzaVar) {
                zzbu();
                ((zzk) this.zza).zzas(zzaVar.zzbr());
                return this;
            }

            private zza() {
                super(zzk.zzg);
            }
        }

        static {
            zzk zzkVar = new zzk();
            zzg = zzkVar;
            zzgzh.zzbZ(zzk.class, zzkVar);
        }

        private zzk() {
        }

        public void zzaa(zzap zzapVar) {
            zzapVar.getClass();
            zzaj();
            this.zzn.add(zzapVar);
        }

        public void zzab(int i, zzap zzapVar) {
            zzapVar.getClass();
            zzaj();
            this.zzn.add(i, zzapVar);
        }

        public void zzac(Iterable<? extends zzap> iterable) {
            zzaj();
            zzgxi.zzaQ(iterable, this.zzn);
        }

        public void zzad() {
            this.zzi &= -2;
            this.zzj = 0;
        }

        public void zzae() {
            this.zzl = null;
            this.zzi &= -5;
        }

        public void zzaf() {
            this.zzk = null;
            this.zzi &= -3;
        }

        public void zzag() {
            this.zzn = zzgzh.zzbK();
        }

        public void zzah() {
            this.zzm = null;
            this.zzi &= -9;
        }

        public void zzai() {
            this.zzi &= -17;
            this.zzo = 0;
        }

        private void zzaj() {
            zzgzt<zzap> zzgztVar = this.zzn;
            if (zzgztVar.zzc()) {
                return;
            }
            this.zzn = zzgzh.zzbL(zzgztVar);
        }

        public void zzak(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzl;
            if (zzapVar2 != null && zzapVar2 != zzap.zzi()) {
                zzap.zza zzaVarZzd = zzap.zzd(zzapVar2);
                zzaVarZzd.zzbj(zzapVar);
                zzapVar = zzaVarZzd.zzbs();
            }
            this.zzl = zzapVar;
            this.zzi |= 4;
        }

        public void zzal(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzk;
            if (zzapVar2 != null && zzapVar2 != zzap.zzi()) {
                zzap.zza zzaVarZzd = zzap.zzd(zzapVar2);
                zzaVarZzd.zzbj(zzapVar);
                zzapVar = zzaVarZzd.zzbs();
            }
            this.zzk = zzapVar;
            this.zzi |= 2;
        }

        public void zzam(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzm;
            if (zzapVar2 != null && zzapVar2 != zzap.zzi()) {
                zzap.zza zzaVarZzd = zzap.zzd(zzapVar2);
                zzaVarZzd.zzbj(zzapVar);
                zzapVar = zzaVarZzd.zzbs();
            }
            this.zzm = zzapVar;
            this.zzi |= 8;
        }

        public void zzan(int i) {
            zzaj();
            this.zzn.remove(i);
        }

        public void zzao(int i) {
            this.zzi |= 1;
            this.zzj = i;
        }

        public void zzap(zzap zzapVar) {
            zzapVar.getClass();
            this.zzl = zzapVar;
            this.zzi |= 4;
        }

        public void zzaq(zzap zzapVar) {
            zzapVar.getClass();
            this.zzk = zzapVar;
            this.zzi |= 2;
        }

        public void zzar(int i, zzap zzapVar) {
            zzapVar.getClass();
            zzaj();
            this.zzn.set(i, zzapVar);
        }

        public void zzas(zzap zzapVar) {
            zzapVar.getClass();
            this.zzm = zzapVar;
            this.zzi |= 8;
        }

        public void zzat(int i) {
            this.zzi |= 16;
            this.zzo = i;
        }

        public static zza zzd() {
            return (zza) zzg.zzaZ();
        }

        public static zza zzf(zzk zzkVar) {
            return (zza) zzg.zzba(zzkVar);
        }

        public static zzk zzh() {
            return zzg;
        }

        public static zzk zzi(InputStream inputStream) {
            return (zzk) zzgzh.zzbk(zzg, inputStream);
        }

        public static zzk zzj(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzk) zzgzh.zzbl(zzg, inputStream, zzgyrVar);
        }

        public static zzk zzk(zzgxz zzgxzVar) {
            return (zzk) zzgzh.zzbm(zzg, zzgxzVar);
        }

        public static zzk zzl(zzgyf zzgyfVar) {
            return (zzk) zzgzh.zzbn(zzg, zzgyfVar);
        }

        public static zzk zzm(InputStream inputStream) {
            return (zzk) zzgzh.zzbo(zzg, inputStream);
        }

        public static zzk zzn(ByteBuffer byteBuffer) {
            return (zzk) zzgzh.zzbp(zzg, byteBuffer);
        }

        public static zzk zzo(byte[] bArr) {
            return (zzk) zzgzh.zzbq(zzg, bArr);
        }

        public static zzk zzp(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzk) zzgzh.zzbr(zzg, zzgxzVar, zzgyrVar);
        }

        public static zzk zzq(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzk) zzgzh.zzbs(zzg, zzgyfVar, zzgyrVar);
        }

        public static zzk zzr(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzk) zzgzh.zzbu(zzg, inputStream, zzgyrVar);
        }

        public static zzk zzs(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzk) zzgzh.zzbv(zzg, byteBuffer, zzgyrVar);
        }

        public static zzk zzt(byte[] bArr, zzgyr zzgyrVar) {
            return (zzk) zzgzh.zzbx(zzg, bArr, zzgyrVar);
        }

        public static zzhba<zzk> zzv() {
            return zzg.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzl
        public zzap zzC() {
            zzap zzapVar = this.zzl;
            return zzapVar == null ? zzap.zzi() : zzapVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzl
        public zzap zzD() {
            zzap zzapVar = this.zzk;
            return zzapVar == null ? zzap.zzi() : zzapVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzl
        public zzap zzE(int i) {
            return this.zzn.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzl
        public zzap zzF() {
            zzap zzapVar = this.zzm;
            return zzapVar == null ? zzap.zzi() : zzapVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzl
        public List<zzap> zzG() {
            return this.zzn;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzl
        public boolean zzH() {
            return (this.zzi & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzl
        public boolean zzI() {
            return (this.zzi & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzl
        public boolean zzJ() {
            return (this.zzi & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzl
        public boolean zzK() {
            return (this.zzi & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzl
        public boolean zzL() {
            return (this.zzi & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzl
        public int zza() {
            return this.zzj;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzl
        public int zzb() {
            return this.zzn.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzl
        public int zzc() {
            return this.zzo;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzg, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005\u001b\u0006င\u0004", new Object[]{"zzi", "zzj", "zzk", "zzl", "zzm", "zzn", zzap.class, "zzo"});
            }
            if (iOrdinal == 3) {
                return new zzk();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzg;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzk> zzgzcVar = zzh;
            if (zzgzcVar == null) {
                synchronized (zzk.class) {
                    try {
                        zzgzcVar = zzh;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzg);
                            zzh = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        public zzaq zzu(int i) {
            return this.zzn.get(i);
        }

        public List<? extends zzaq> zzw() {
            return this.zzn;
        }
    }

    public interface zzl extends zzhat {
        zzap zzC();

        zzap zzD();

        zzap zzE(int i);

        zzap zzF();

        List<zzap> zzG();

        boolean zzH();

        boolean zzI();

        boolean zzJ();

        boolean zzK();

        boolean zzL();

        int zza();

        int zzb();

        int zzc();
    }

    /* JADX INFO: loaded from: classes2.dex */
    public final class zzm extends zzgzh<zzm, zza> implements zzn {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 8;
        private static final zzm zzi;
        private static volatile zzhba<zzm> zzj;
        private int zzk;
        private zzap zzm;
        private int zzn;
        private zzar zzo;
        private int zzp;
        private String zzl = "";
        private int zzu = 1000;
        private int zzv = 1000;
        private int zzw = 1000;

        /* JADX INFO: loaded from: classes.dex */
        public final class zza extends zzgzb<zzm, zza> implements zzn {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzn
            public zzap zzA() {
                return ((zzm) this.zza).zzA();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzn
            public zzar zzB() {
                return ((zzm) this.zza).zzB();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzn
            public zzgxz zzC() {
                return ((zzm) this.zza).zzC();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzn
            public String zzD() {
                return ((zzm) this.zza).zzD();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzn
            public boolean zzE() {
                return ((zzm) this.zza).zzE();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzn
            public boolean zzF() {
                return ((zzm) this.zza).zzF();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzn
            public boolean zzG() {
                return ((zzm) this.zza).zzG();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzn
            public boolean zzH() {
                return ((zzm) this.zza).zzH();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzn
            public boolean zzI() {
                return ((zzm) this.zza).zzI();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzn
            public boolean zzJ() {
                return ((zzm) this.zza).zzJ();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzn
            public boolean zzK() {
                return ((zzm) this.zza).zzK();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzn
            public boolean zzL() {
                return ((zzm) this.zza).zzL();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzn
            public int zza() {
                return ((zzm) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzn
            public int zzb() {
                return ((zzm) this.zza).zzb();
            }

            public zza zzc() {
                zzbu();
                ((zzm) this.zza).zzac();
                return this;
            }

            public zza zzd() {
                zzbu();
                ((zzm) this.zza).zzad();
                return this;
            }

            public zza zze() {
                zzbu();
                ((zzm) this.zza).zzae();
                return this;
            }

            public zza zzf() {
                zzbu();
                ((zzm) this.zza).zzaf();
                return this;
            }

            public zza zzg() {
                zzbu();
                ((zzm) this.zza).zzag();
                return this;
            }

            public zza zzh() {
                zzbu();
                ((zzm) this.zza).zzah();
                return this;
            }

            public zza zzi() {
                zzbu();
                ((zzm) this.zza).zzai();
                return this;
            }

            public zza zzj() {
                zzbu();
                ((zzm) this.zza).zzaj();
                return this;
            }

            public zza zzk(zzap zzapVar) {
                zzbu();
                ((zzm) this.zza).zzak(zzapVar);
                return this;
            }

            public zza zzl(zzar zzarVar) {
                zzbu();
                ((zzm) this.zza).zzal(zzarVar);
                return this;
            }

            public zza zzm(String str) {
                zzbu();
                ((zzm) this.zza).zzam(str);
                return this;
            }

            public zza zzn(zzgxz zzgxzVar) {
                zzbu();
                ((zzm) this.zza).zzan(zzgxzVar);
                return this;
            }

            public zza zzo(zzq zzqVar) {
                zzbu();
                ((zzm) this.zza).zzao(zzqVar);
                return this;
            }

            public zza zzp(zzq zzqVar) {
                zzbu();
                ((zzm) this.zza).zzap(zzqVar);
                return this;
            }

            public zza zzq(zzq zzqVar) {
                zzbu();
                ((zzm) this.zza).zzaq(zzqVar);
                return this;
            }

            public zza zzr(zzap.zza zzaVar) {
                zzbu();
                ((zzm) this.zza).zzar(zzaVar.zzbr());
                return this;
            }

            public zza zzs(zzap zzapVar) {
                zzbu();
                ((zzm) this.zza).zzar(zzapVar);
                return this;
            }

            public zza zzt(int i) {
                zzbu();
                ((zzm) this.zza).zzas(i);
                return this;
            }

            public zza zzu(int i) {
                zzbu();
                ((zzm) this.zza).zzat(i);
                return this;
            }

            public zza zzv(zzar.zza zzaVar) {
                zzbu();
                ((zzm) this.zza).zzau(zzaVar.zzbr());
                return this;
            }

            public zza zzw(zzar zzarVar) {
                zzbu();
                ((zzm) this.zza).zzau(zzarVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzn
            public zzq zzx() {
                return ((zzm) this.zza).zzx();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzn
            public zzq zzy() {
                return ((zzm) this.zza).zzy();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzn
            public zzq zzz() {
                return ((zzm) this.zza).zzz();
            }

            private zza() {
                super(zzm.zzi);
            }
        }

        static {
            zzm zzmVar = new zzm();
            zzi = zzmVar;
            zzgzh.zzbZ(zzm.class, zzmVar);
        }

        private zzm() {
        }

        public void zzac() {
            this.zzk &= -2;
            this.zzl = zzg().zzD();
        }

        public void zzad() {
            this.zzk &= -33;
            this.zzu = 1000;
        }

        public void zzae() {
            this.zzk &= -65;
            this.zzv = 1000;
        }

        public void zzaf() {
            this.zzk &= -129;
            this.zzw = 1000;
        }

        public void zzag() {
            this.zzm = null;
            this.zzk &= -3;
        }

        public void zzah() {
            this.zzk &= -17;
            this.zzp = 0;
        }

        public void zzai() {
            this.zzk &= -5;
            this.zzn = 0;
        }

        public void zzaj() {
            this.zzo = null;
            this.zzk &= -9;
        }

        public void zzak(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzm;
            if (zzapVar2 != null && zzapVar2 != zzap.zzi()) {
                zzap.zza zzaVarZzd = zzap.zzd(zzapVar2);
                zzaVarZzd.zzbj(zzapVar);
                zzapVar = zzaVarZzd.zzbs();
            }
            this.zzm = zzapVar;
            this.zzk |= 2;
        }

        public void zzal(zzar zzarVar) {
            zzarVar.getClass();
            zzar zzarVar2 = this.zzo;
            if (zzarVar2 != null && zzarVar2 != zzar.zzh()) {
                zzar.zza zzaVarZzf = zzar.zzf(zzarVar2);
                zzaVarZzf.zzbj(zzarVar);
                zzarVar = zzaVarZzf.zzbs();
            }
            this.zzo = zzarVar;
            this.zzk |= 8;
        }

        public void zzam(String str) {
            str.getClass();
            this.zzk |= 1;
            this.zzl = str;
        }

        public void zzan(zzgxz zzgxzVar) {
            this.zzl = zzgxzVar.zzx();
            this.zzk |= 1;
        }

        public void zzao(zzq zzqVar) {
            this.zzu = zzqVar.zza();
            this.zzk |= 32;
        }

        public void zzap(zzq zzqVar) {
            this.zzv = zzqVar.zza();
            this.zzk |= 64;
        }

        public void zzaq(zzq zzqVar) {
            this.zzw = zzqVar.zza();
            this.zzk |= 128;
        }

        public void zzar(zzap zzapVar) {
            zzapVar.getClass();
            this.zzm = zzapVar;
            this.zzk |= 2;
        }

        public void zzas(int i) {
            this.zzk |= 16;
            this.zzp = i;
        }

        public void zzat(int i) {
            this.zzk |= 4;
            this.zzn = i;
        }

        public void zzau(zzar zzarVar) {
            zzarVar.getClass();
            this.zzo = zzarVar;
            this.zzk |= 8;
        }

        public static zza zzc() {
            return (zza) zzi.zzaZ();
        }

        public static zza zzd(zzm zzmVar) {
            return (zza) zzi.zzba(zzmVar);
        }

        public static zzm zzg() {
            return zzi;
        }

        public static zzm zzh(InputStream inputStream) {
            return (zzm) zzgzh.zzbk(zzi, inputStream);
        }

        public static zzm zzi(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzm) zzgzh.zzbl(zzi, inputStream, zzgyrVar);
        }

        public static zzm zzj(zzgxz zzgxzVar) {
            return (zzm) zzgzh.zzbm(zzi, zzgxzVar);
        }

        public static zzm zzk(zzgyf zzgyfVar) {
            return (zzm) zzgzh.zzbn(zzi, zzgyfVar);
        }

        public static zzm zzl(InputStream inputStream) {
            return (zzm) zzgzh.zzbo(zzi, inputStream);
        }

        public static zzm zzm(ByteBuffer byteBuffer) {
            return (zzm) zzgzh.zzbp(zzi, byteBuffer);
        }

        public static zzm zzn(byte[] bArr) {
            return (zzm) zzgzh.zzbq(zzi, bArr);
        }

        public static zzm zzo(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzm) zzgzh.zzbr(zzi, zzgxzVar, zzgyrVar);
        }

        public static zzm zzp(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzm) zzgzh.zzbs(zzi, zzgyfVar, zzgyrVar);
        }

        public static zzm zzq(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzm) zzgzh.zzbu(zzi, inputStream, zzgyrVar);
        }

        public static zzm zzr(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzm) zzgzh.zzbv(zzi, byteBuffer, zzgyrVar);
        }

        public static zzm zzs(byte[] bArr, zzgyr zzgyrVar) {
            return (zzm) zzgzh.zzbx(zzi, bArr, zzgyrVar);
        }

        public static zzhba<zzm> zzt() {
            return zzi.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzn
        public zzap zzA() {
            zzap zzapVar = this.zzm;
            return zzapVar == null ? zzap.zzi() : zzapVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzn
        public zzar zzB() {
            zzar zzarVar = this.zzo;
            return zzarVar == null ? zzar.zzh() : zzarVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzn
        public zzgxz zzC() {
            return zzgxz.zzw(this.zzl);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzn
        public String zzD() {
            return this.zzl;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzn
        public boolean zzE() {
            return (this.zzk & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzn
        public boolean zzF() {
            return (this.zzk & 32) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzn
        public boolean zzG() {
            return (this.zzk & 64) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzn
        public boolean zzH() {
            return (this.zzk & 128) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzn
        public boolean zzI() {
            return (this.zzk & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzn
        public boolean zzJ() {
            return (this.zzk & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzn
        public boolean zzK() {
            return (this.zzk & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzn
        public boolean zzL() {
            return (this.zzk & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzn
        public int zza() {
            return this.zzp;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzn
        public int zzb() {
            return this.zzn;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzi, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004ဉ\u0003\u0005င\u0004\u0006᠌\u0005\u0007᠌\u0006\b᠌\u0007", new Object[]{"zzk", "zzl", "zzm", jIKWv.lpZV, "zzo", gZrKCJ.prSlnj, "zzu", zzq.zze(), "zzv", zzq.zze(), "zzw", zzq.zze()});
            }
            if (iOrdinal == 3) {
                return new zzm();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzi;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzm> zzgzcVar = zzj;
            if (zzgzcVar == null) {
                synchronized (zzm.class) {
                    try {
                        zzgzcVar = zzj;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzi);
                            zzj = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzn
        public zzq zzx() {
            zzq zzqVarZzb = zzq.zzb(this.zzu);
            return zzqVarZzb == null ? zzq.ENUM_UNKNOWN : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzn
        public zzq zzy() {
            zzq zzqVarZzb = zzq.zzb(this.zzv);
            return zzqVarZzb == null ? zzq.ENUM_UNKNOWN : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzn
        public zzq zzz() {
            zzq zzqVarZzb = zzq.zzb(this.zzw);
            return zzqVarZzb == null ? zzq.ENUM_UNKNOWN : zzqVarZzb;
        }
    }

    public interface zzn extends zzhat {
        zzap zzA();

        zzar zzB();

        zzgxz zzC();

        String zzD();

        boolean zzE();

        boolean zzF();

        boolean zzG();

        boolean zzH();

        boolean zzI();

        boolean zzJ();

        boolean zzK();

        boolean zzL();

        int zza();

        int zzb();

        zzq zzx();

        zzq zzy();

        zzq zzz();
    }

    public final class zzo extends zzgzh<zzo, zza> implements zzp {
        public static final int zza = 5;
        public static final int zzb = 6;
        public static final int zzc = 7;
        public static final int zzd = 8;
        private static final zzo zze;
        private static volatile zzhba<zzo> zzf;
        private int zzg;
        private int zzh;
        private zzar zzi;
        private String zzj = "";
        private String zzk = "";

        public final class zza extends zzgzb<zzo, zza> implements zzp {
            public /* synthetic */ zza() {
                this();
            }

            public zza zza() {
                zzbu();
                ((zzo) this.zza).zzN();
                return this;
            }

            public zza zzb() {
                zzbu();
                ((zzo) this.zza).zzO();
                return this;
            }

            public zza zzc() {
                zzbu();
                ((zzo) this.zza).zzP();
                return this;
            }

            public zza zzd() {
                zzbu();
                ((zzo) this.zza).zzQ();
                return this;
            }

            public zza zze(zzar zzarVar) {
                zzbu();
                ((zzo) this.zza).zzR(zzarVar);
                return this;
            }

            public zza zzf(String str) {
                zzbu();
                ((zzo) this.zza).zzS(str);
                return this;
            }

            public zza zzg(zzgxz zzgxzVar) {
                zzbu();
                ((zzo) this.zza).zzT(zzgxzVar);
                return this;
            }

            public zza zzh(zzar.zza zzaVar) {
                zzbu();
                ((zzo) this.zza).zzU(zzaVar.zzbr());
                return this;
            }

            public zza zzi(zzar zzarVar) {
                zzbu();
                ((zzo) this.zza).zzU(zzarVar);
                return this;
            }

            public zza zzj(zzb zzbVar) {
                zzbu();
                ((zzo) this.zza).zzV(zzbVar);
                return this;
            }

            public zza zzk(String str) {
                zzbu();
                ((zzo) this.zza).zzW(str);
                return this;
            }

            public zza zzl(zzgxz zzgxzVar) {
                zzbu();
                ((zzo) this.zza).zzX(zzgxzVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzp
            public zzb zzm() {
                return ((zzo) this.zza).zzm();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzp
            public zzar zzn() {
                return ((zzo) this.zza).zzn();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzp
            public zzgxz zzo() {
                return ((zzo) this.zza).zzo();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzp
            public zzgxz zzp() {
                return ((zzo) this.zza).zzp();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzp
            public String zzq() {
                return ((zzo) this.zza).zzq();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzp
            public String zzr() {
                return ((zzo) this.zza).zzr();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzp
            public boolean zzs() {
                return ((zzo) this.zza).zzs();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzp
            public boolean zzt() {
                return ((zzo) this.zza).zzt();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzp
            public boolean zzu() {
                return ((zzo) this.zza).zzu();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzp
            public boolean zzv() {
                return ((zzo) this.zza).zzv();
            }

            private zza() {
                super(zzo.zze);
            }
        }

        public enum zzb implements zzgzl {
            PLATFORM_UNSPECIFIED(0),
            IOS(1),
            ANDROID(2);

            public static final int zzd = 0;
            public static final int zze = 1;
            public static final int zzf = 2;
            private static final zzgzm<zzb> zzg = new zzgzm<zzb>() { // from class: com.google.android.gms.internal.ads.zzbcj.zzo.zzb.1
                /* JADX INFO: renamed from: zza */
                public zzb zzb(int i) {
                    return zzb.zzb(i);
                }
            };
            private final int zzi;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zzo$zzb$1 */
            public class AnonymousClass1 implements zzgzm<zzb> {
                /* JADX INFO: renamed from: zza */
                public zzb zzb(int i) {
                    return zzb.zzb(i);
                }
            }

            final class zza implements zzgzn {
                static final zzgzn zza = new zza();

                private zza() {
                }

                @Override // com.google.android.gms.internal.ads.zzgzn
                public boolean zza(int i) {
                    return zzb.zzb(i) != null;
                }
            }

            zzb(int i) {
                this.zzi = i;
            }

            public static zzb zzb(int i) {
                if (i == 0) {
                    return PLATFORM_UNSPECIFIED;
                }
                if (i == 1) {
                    return IOS;
                }
                if (i != 2) {
                    return null;
                }
                return ANDROID;
            }

            public static zzgzm<zzb> zzd() {
                return zzg;
            }

            public static zzgzn zze() {
                return zza.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.zzi);
            }

            @Override // com.google.android.gms.internal.ads.zzgzl
            public final int zza() {
                return this.zzi;
            }
        }

        static {
            zzo zzoVar = new zzo();
            zze = zzoVar;
            zzgzh.zzbZ(zzo.class, zzoVar);
        }

        private zzo() {
        }

        public static zzo zzA(byte[] bArr, zzgyr zzgyrVar) {
            return (zzo) zzgzh.zzbx(zze, bArr, zzgyrVar);
        }

        public static zzhba<zzo> zzB() {
            return zze.zzbN();
        }

        public void zzN() {
            this.zzg &= -5;
            this.zzj = zzd().zzq();
        }

        public void zzO() {
            this.zzi = null;
            this.zzg &= -3;
        }

        public void zzP() {
            this.zzg &= -2;
            this.zzh = 0;
        }

        public void zzQ() {
            this.zzg &= -9;
            this.zzk = zzd().zzr();
        }

        public void zzR(zzar zzarVar) {
            zzarVar.getClass();
            zzar zzarVar2 = this.zzi;
            if (zzarVar2 != null && zzarVar2 != zzar.zzh()) {
                zzar.zza zzaVarZzf = zzar.zzf(zzarVar2);
                zzaVarZzf.zzbj(zzarVar);
                zzarVar = zzaVarZzf.zzbs();
            }
            this.zzi = zzarVar;
            this.zzg |= 2;
        }

        public void zzS(String str) {
            str.getClass();
            this.zzg |= 4;
            this.zzj = str;
        }

        public void zzT(zzgxz zzgxzVar) {
            this.zzj = zzgxzVar.zzx();
            this.zzg |= 4;
        }

        public void zzU(zzar zzarVar) {
            zzarVar.getClass();
            this.zzi = zzarVar;
            this.zzg |= 2;
        }

        public void zzV(zzb zzbVar) {
            this.zzh = zzbVar.zza();
            this.zzg |= 1;
        }

        public void zzW(String str) {
            str.getClass();
            this.zzg |= 8;
            this.zzk = str;
        }

        public void zzX(zzgxz zzgxzVar) {
            this.zzk = zzgxzVar.zzx();
            this.zzg |= 8;
        }

        public static zza zza() {
            return (zza) zze.zzaZ();
        }

        public static zza zzb(zzo zzoVar) {
            return (zza) zze.zzba(zzoVar);
        }

        public static zzo zzd() {
            return zze;
        }

        public static zzo zzf(InputStream inputStream) {
            return (zzo) zzgzh.zzbk(zze, inputStream);
        }

        public static zzo zzg(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzo) zzgzh.zzbl(zze, inputStream, zzgyrVar);
        }

        public static zzo zzh(zzgxz zzgxzVar) {
            return (zzo) zzgzh.zzbm(zze, zzgxzVar);
        }

        public static zzo zzi(zzgyf zzgyfVar) {
            return (zzo) zzgzh.zzbn(zze, zzgyfVar);
        }

        public static zzo zzj(InputStream inputStream) {
            return (zzo) zzgzh.zzbo(zze, inputStream);
        }

        public static zzo zzk(ByteBuffer byteBuffer) {
            return (zzo) zzgzh.zzbp(zze, byteBuffer);
        }

        public static zzo zzl(byte[] bArr) {
            return (zzo) zzgzh.zzbq(zze, bArr);
        }

        public static zzo zzw(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzo) zzgzh.zzbr(zze, zzgxzVar, zzgyrVar);
        }

        public static zzo zzx(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzo) zzgzh.zzbs(zze, zzgyfVar, zzgyrVar);
        }

        public static zzo zzy(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzo) zzgzh.zzbu(zze, inputStream, zzgyrVar);
        }

        public static zzo zzz(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzo) zzgzh.zzbv(zze, byteBuffer, zzgyrVar);
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zze, "\u0004\u0004\u0000\u0001\u0005\b\u0004\u0000\u0000\u0000\u0005᠌\u0000\u0006ဉ\u0001\u0007ဈ\u0002\bဈ\u0003", new Object[]{"zzg", "zzh", zzb.zze(), "zzi", "zzj", "zzk"});
            }
            if (iOrdinal == 3) {
                return new zzo();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zze;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzo> zzgzcVar = zzf;
            if (zzgzcVar == null) {
                synchronized (zzo.class) {
                    try {
                        zzgzcVar = zzf;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zze);
                            zzf = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzp
        public zzb zzm() {
            zzb zzbVarZzb = zzb.zzb(this.zzh);
            return zzbVarZzb == null ? zzb.PLATFORM_UNSPECIFIED : zzbVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzp
        public zzar zzn() {
            zzar zzarVar = this.zzi;
            return zzarVar == null ? zzar.zzh() : zzarVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzp
        public zzgxz zzo() {
            return zzgxz.zzw(this.zzj);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzp
        public zzgxz zzp() {
            return zzgxz.zzw(this.zzk);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzp
        public String zzq() {
            return this.zzj;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzp
        public String zzr() {
            return this.zzk;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzp
        public boolean zzs() {
            return (this.zzg & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzp
        public boolean zzt() {
            return (this.zzg & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzp
        public boolean zzu() {
            return (this.zzg & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzp
        public boolean zzv() {
            return (this.zzg & 8) != 0;
        }
    }

    public interface zzp extends zzhat {
        zzo.zzb zzm();

        zzar zzn();

        zzgxz zzo();

        zzgxz zzp();

        String zzq();

        String zzr();

        boolean zzs();

        boolean zzt();

        boolean zzu();

        boolean zzv();
    }

    public enum zzq implements zzgzl {
        ENUM_FALSE(0),
        ENUM_TRUE(1),
        ENUM_UNKNOWN(1000);

        public static final int zzd = 0;
        public static final int zze = 1;
        public static final int zzf = 1000;
        private static final zzgzm<zzq> zzg = new zzgzm<zzq>() { // from class: com.google.android.gms.internal.ads.zzbcj.zzq.1
            /* JADX INFO: renamed from: zza */
            public zzq zzb(int i) {
                return zzq.zzb(i);
            }
        };
        private final int zzi;

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zzq$1 */
        public class AnonymousClass1 implements zzgzm<zzq> {
            /* JADX INFO: renamed from: zza */
            public zzq zzb(int i) {
                return zzq.zzb(i);
            }
        }

        final class zza implements zzgzn {
            static final zzgzn zza = new zza();

            private zza() {
            }

            @Override // com.google.android.gms.internal.ads.zzgzn
            public boolean zza(int i) {
                return zzq.zzb(i) != null;
            }
        }

        zzq(int i) {
            this.zzi = i;
        }

        public static zzq zzb(int i) {
            if (i == 0) {
                return ENUM_FALSE;
            }
            if (i == 1) {
                return ENUM_TRUE;
            }
            if (i != 1000) {
                return null;
            }
            return ENUM_UNKNOWN;
        }

        public static zzgzm<zzq> zzd() {
            return zzg;
        }

        public static zzgzn zze() {
            return zza.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(this.zzi);
        }

        @Override // com.google.android.gms.internal.ads.zzgzl
        public final int zza() {
            return this.zzi;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public final class zzr extends zzgzh<zzr, zza> implements zzs {
        public static final int zza = 7;
        public static final int zzb = 8;
        public static final int zzc = 9;
        public static final int zzd = 10;
        public static final int zze = 11;
        public static final int zzf = 12;
        public static final int zzg = 13;
        public static final int zzh = 14;
        public static final int zzi = 15;
        public static final int zzj = 16;
        private static final zzgzq<zzd.zza> zzk = new zzgzq<zzd.zza>() { // from class: com.google.android.gms.internal.ads.zzbcj.zzr.1
            @Override // com.google.android.gms.internal.ads.zzgzq
            /* JADX INFO: renamed from: zza */
            public zzd.zza zzb(int i) {
                zzd.zza zzaVarZzb = zzd.zza.zzb(i);
                return zzaVarZzb == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzb;
            }
        };
        private static final zzgzq<zzd.zza> zzl = new zzgzq<zzd.zza>() { // from class: com.google.android.gms.internal.ads.zzbcj.zzr.2
            @Override // com.google.android.gms.internal.ads.zzgzq
            /* JADX INFO: renamed from: zza */
            public zzd.zza zzb(int i) {
                zzd.zza zzaVarZzb = zzd.zza.zzb(i);
                return zzaVarZzb == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzb;
            }
        };
        private static final zzr zzm;
        private static volatile zzhba<zzr> zzn;
        private int zzA;
        private int zzo;
        private int zzp;
        private zzar zzv;
        private int zzw;
        private int zzz;
        private String zzu = "";
        private String zzx = "";
        private String zzy = "";
        private zzgzp zzB = zzgzh.zzbG();
        private zzgzp zzC = zzgzh.zzbG();

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zzr$1 */
        /* JADX INFO: loaded from: classes.dex */
        public class AnonymousClass1 implements zzgzq<zzd.zza> {
            @Override // com.google.android.gms.internal.ads.zzgzq
            /* JADX INFO: renamed from: zza */
            public zzd.zza zzb(int i) {
                zzd.zza zzaVarZzb = zzd.zza.zzb(i);
                return zzaVarZzb == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzb;
            }
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbcj$zzr$2 */
        /* JADX INFO: loaded from: classes.dex */
        public class AnonymousClass2 implements zzgzq<zzd.zza> {
            @Override // com.google.android.gms.internal.ads.zzgzq
            /* JADX INFO: renamed from: zza */
            public zzd.zza zzb(int i) {
                zzd.zza zzaVarZzb = zzd.zza.zzb(i);
                return zzaVarZzb == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzb;
            }
        }

        /* JADX INFO: loaded from: classes.dex */
        public final class zza extends zzgzb<zzr, zza> implements zzs {
            public /* synthetic */ zza() {
                this();
            }

            public zza zzA(String str) {
                zzbu();
                ((zzr) this.zza).zzch(str);
                return this;
            }

            public zza zzB(zzgxz zzgxzVar) {
                zzbu();
                ((zzr) this.zza).zzci(zzgxzVar);
                return this;
            }

            public zza zzC(String str) {
                zzbu();
                ((zzr) this.zza).zzcj(str);
                return this;
            }

            public zza zzD(zzgxz zzgxzVar) {
                zzbu();
                ((zzr) this.zza).zzck(zzgxzVar);
                return this;
            }

            public zza zzE(int i) {
                zzbu();
                ((zzr) this.zza).zzcl(i);
                return this;
            }

            public zza zzF(zzar.zza zzaVar) {
                zzbu();
                ((zzr) this.zza).zzcm(zzaVar.zzbr());
                return this;
            }

            public zza zzG(zzar zzarVar) {
                zzbu();
                ((zzr) this.zza).zzcm(zzarVar);
                return this;
            }

            public zza zzH(zzo.zzb zzbVar) {
                zzbu();
                ((zzr) this.zza).zzcn(zzbVar);
                return this;
            }

            public zza zzI(int i, zzd.zza zzaVar) {
                zzbu();
                ((zzr) this.zza).zzco(i, zzaVar);
                return this;
            }

            public zza zzJ(int i, zzd.zza zzaVar) {
                zzbu();
                ((zzr) this.zza).zzcp(i, zzaVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public zzab.zzc zzK() {
                return ((zzr) this.zza).zzK();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public zzar zzL() {
                return ((zzr) this.zza).zzL();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public zzgxz zzM() {
                return ((zzr) this.zza).zzM();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public zzgxz zzN() {
                return ((zzr) this.zza).zzN();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public zzgxz zzO() {
                return ((zzr) this.zza).zzO();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public String zzP() {
                return ((zzr) this.zza).zzP();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public String zzQ() {
                return ((zzr) this.zza).zzQ();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public String zzR() {
                return ((zzr) this.zza).zzR();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public List<zzd.zza> zzS() {
                return ((zzr) this.zza).zzS();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public List<zzd.zza> zzT() {
                return ((zzr) this.zza).zzT();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public boolean zzU() {
                return ((zzr) this.zza).zzU();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public boolean zzV() {
                return ((zzr) this.zza).zzV();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public boolean zzW() {
                return ((zzr) this.zza).zzW();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public boolean zzX() {
                return ((zzr) this.zza).zzX();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public boolean zzY() {
                return ((zzr) this.zza).zzY();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public boolean zzZ() {
                return ((zzr) this.zza).zzZ();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public int zza() {
                return ((zzr) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public boolean zzaa() {
                return ((zzr) this.zza).zzaa();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public boolean zzab() {
                return ((zzr) this.zza).zzab();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public int zzb() {
                return ((zzr) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public int zzc() {
                return ((zzr) this.zza).zzc();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public zza.EnumC0001zza zzd() {
                return ((zzr) this.zza).zzd();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public zzd.zza zze(int i) {
                return ((zzr) this.zza).zze(i);
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public zzd.zza zzf(int i) {
                return ((zzr) this.zza).zzf(i);
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzs
            public zzo.zzb zzg() {
                return ((zzr) this.zza).zzg();
            }

            public zza zzh(Iterable<? extends zzd.zza> iterable) {
                zzbu();
                ((zzr) this.zza).zzas(iterable);
                return this;
            }

            public zza zzi(Iterable<? extends zzd.zza> iterable) {
                zzbu();
                ((zzr) this.zza).zzat(iterable);
                return this;
            }

            public zza zzj(zzd.zza zzaVar) {
                zzbu();
                ((zzr) this.zza).zzau(zzaVar);
                return this;
            }

            public zza zzk(zzd.zza zzaVar) {
                zzbu();
                ((zzr) this.zza).zzav(zzaVar);
                return this;
            }

            public zza zzl() {
                zzbu();
                ((zzr) this.zza).zzaw();
                return this;
            }

            public zza zzm() {
                zzbu();
                ((zzr) this.zza).zzax();
                return this;
            }

            public zza zzn() {
                zzbu();
                ((zzr) this.zza).zzay();
                return this;
            }

            public zza zzo() {
                zzbu();
                ((zzr) this.zza).zzaz();
                return this;
            }

            public zza zzp() {
                zzbu();
                ((zzr) this.zza).zzaA();
                return this;
            }

            public zza zzq() {
                zzbu();
                ((zzr) this.zza).zzaB();
                return this;
            }

            public zza zzr() {
                zzbu();
                ((zzr) this.zza).zzaC();
                return this;
            }

            public zza zzs() {
                zzbu();
                ((zzr) this.zza).zzaD();
                return this;
            }

            public zza zzt() {
                zzbu();
                ((zzr) this.zza).zzaE();
                return this;
            }

            public zza zzu() {
                zzbu();
                ((zzr) this.zza).zzaF();
                return this;
            }

            public zza zzv(zzar zzarVar) {
                zzbu();
                ((zzr) this.zza).zzaI(zzarVar);
                return this;
            }

            public zza zzw(zza.EnumC0001zza enumC0001zza) {
                zzbu();
                ((zzr) this.zza).zzaJ(enumC0001zza);
                return this;
            }

            public zza zzx(String str) {
                zzbu();
                ((zzr) this.zza).zzaK(str);
                return this;
            }

            public zza zzy(zzgxz zzgxzVar) {
                zzbu();
                ((zzr) this.zza).zzcf(zzgxzVar);
                return this;
            }

            public zza zzz(zzab.zzc zzcVar) {
                zzbu();
                ((zzr) this.zza).zzcg(zzcVar);
                return this;
            }

            private zza() {
                super(zzr.zzm);
            }
        }

        static {
            zzr zzrVar = new zzr();
            zzm = zzrVar;
            zzgzh.zzbZ(zzr.class, zzrVar);
        }

        private zzr() {
        }

        public void zzaA() {
            this.zzo &= -3;
            this.zzu = zzk().zzR();
        }

        public void zzaB() {
            this.zzo &= -2;
            this.zzp = 0;
        }

        public void zzaC() {
            this.zzv = null;
            this.zzo &= -5;
        }

        public void zzaD() {
            this.zzo &= -9;
            this.zzw = 0;
        }

        public void zzaE() {
            this.zzC = zzgzh.zzbG();
        }

        public void zzaF() {
            this.zzB = zzgzh.zzbG();
        }

        private void zzaG() {
            zzgzp zzgzpVar = this.zzC;
            if (zzgzpVar.zzc()) {
                return;
            }
            this.zzC = zzgzh.zzbH(zzgzpVar);
        }

        private void zzaH() {
            zzgzp zzgzpVar = this.zzB;
            if (zzgzpVar.zzc()) {
                return;
            }
            this.zzB = zzgzh.zzbH(zzgzpVar);
        }

        public void zzaI(zzar zzarVar) {
            zzarVar.getClass();
            zzar zzarVar2 = this.zzv;
            if (zzarVar2 != null && zzarVar2 != zzar.zzh()) {
                zzar.zza zzaVarZzf = zzar.zzf(zzarVar2);
                zzaVarZzf.zzbj(zzarVar);
                zzarVar = zzaVarZzf.zzbs();
            }
            this.zzv = zzarVar;
            this.zzo |= 4;
        }

        public void zzaJ(zza.EnumC0001zza enumC0001zza) {
            this.zzA = enumC0001zza.zza();
            this.zzo |= 128;
        }

        public void zzaK(String str) {
            str.getClass();
            this.zzo |= 16;
            this.zzx = str;
        }

        public void zzas(Iterable<? extends zzd.zza> iterable) {
            zzaG();
            Iterator<? extends zzd.zza> it = iterable.iterator();
            while (it.hasNext()) {
                this.zzC.zzi(it.next().zza());
            }
        }

        public void zzat(Iterable<? extends zzd.zza> iterable) {
            zzaH();
            Iterator<? extends zzd.zza> it = iterable.iterator();
            while (it.hasNext()) {
                this.zzB.zzi(it.next().zza());
            }
        }

        public void zzau(zzd.zza zzaVar) {
            zzaVar.getClass();
            zzaG();
            this.zzC.zzi(zzaVar.zza());
        }

        public void zzav(zzd.zza zzaVar) {
            zzaVar.getClass();
            zzaH();
            this.zzB.zzi(zzaVar.zza());
        }

        public void zzaw() {
            this.zzo &= -129;
            this.zzA = 0;
        }

        public void zzax() {
            this.zzo &= -17;
            this.zzx = zzk().zzP();
        }

        public void zzay() {
            this.zzo &= -65;
            this.zzz = 0;
        }

        public void zzaz() {
            this.zzo &= -33;
            this.zzy = zzk().zzQ();
        }

        public void zzcf(zzgxz zzgxzVar) {
            this.zzx = zzgxzVar.zzx();
            this.zzo |= 16;
        }

        public void zzcg(zzab.zzc zzcVar) {
            this.zzz = zzcVar.zza();
            this.zzo |= 64;
        }

        public void zzch(String str) {
            str.getClass();
            this.zzo |= 32;
            this.zzy = str;
        }

        public void zzci(zzgxz zzgxzVar) {
            this.zzy = zzgxzVar.zzx();
            this.zzo |= 32;
        }

        public void zzcj(String str) {
            str.getClass();
            this.zzo |= 2;
            this.zzu = str;
        }

        public void zzck(zzgxz zzgxzVar) {
            this.zzu = zzgxzVar.zzx();
            this.zzo |= 2;
        }

        public void zzcl(int i) {
            this.zzo |= 1;
            this.zzp = i;
        }

        public void zzcm(zzar zzarVar) {
            zzarVar.getClass();
            this.zzv = zzarVar;
            this.zzo |= 4;
        }

        public void zzcn(zzo.zzb zzbVar) {
            this.zzw = zzbVar.zza();
            this.zzo |= 8;
        }

        public void zzco(int i, zzd.zza zzaVar) {
            zzaVar.getClass();
            zzaG();
            this.zzC.zze(i, zzaVar.zza());
        }

        public void zzcp(int i, zzd.zza zzaVar) {
            zzaVar.getClass();
            zzaH();
            this.zzB.zze(i, zzaVar.zza());
        }

        public static zza zzh() {
            return (zza) zzm.zzaZ();
        }

        public static zza zzi(zzr zzrVar) {
            return (zza) zzm.zzba(zzrVar);
        }

        public static zzr zzk() {
            return zzm;
        }

        public static zzr zzl(InputStream inputStream) {
            return (zzr) zzgzh.zzbk(zzm, inputStream);
        }

        public static zzr zzm(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzr) zzgzh.zzbl(zzm, inputStream, zzgyrVar);
        }

        public static zzr zzn(zzgxz zzgxzVar) {
            return (zzr) zzgzh.zzbm(zzm, zzgxzVar);
        }

        public static zzr zzo(zzgyf zzgyfVar) {
            return (zzr) zzgzh.zzbn(zzm, zzgyfVar);
        }

        public static zzr zzp(InputStream inputStream) {
            return (zzr) zzgzh.zzbo(zzm, inputStream);
        }

        public static zzr zzq(ByteBuffer byteBuffer) {
            return (zzr) zzgzh.zzbp(zzm, byteBuffer);
        }

        public static zzr zzr(byte[] bArr) {
            return (zzr) zzgzh.zzbq(zzm, bArr);
        }

        public static zzr zzs(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzr) zzgzh.zzbr(zzm, zzgxzVar, zzgyrVar);
        }

        public static zzr zzt(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzr) zzgzh.zzbs(zzm, zzgyfVar, zzgyrVar);
        }

        public static zzr zzu(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzr) zzgzh.zzbu(zzm, inputStream, zzgyrVar);
        }

        public static zzr zzv(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzr) zzgzh.zzbv(zzm, byteBuffer, zzgyrVar);
        }

        public static zzr zzw(byte[] bArr, zzgyr zzgyrVar) {
            return (zzr) zzgzh.zzbx(zzm, bArr, zzgyrVar);
        }

        public static zzhba<zzr> zzx() {
            return zzm.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public zzab.zzc zzK() {
            zzab.zzc zzcVarZzb = zzab.zzc.zzb(this.zzz);
            return zzcVarZzb == null ? zzab.zzc.NETWORKTYPE_UNSPECIFIED : zzcVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public zzar zzL() {
            zzar zzarVar = this.zzv;
            return zzarVar == null ? zzar.zzh() : zzarVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public zzgxz zzM() {
            return zzgxz.zzw(this.zzx);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public zzgxz zzN() {
            return zzgxz.zzw(this.zzy);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public zzgxz zzO() {
            return zzgxz.zzw(this.zzu);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public String zzP() {
            return this.zzx;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public String zzQ() {
            return this.zzy;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public String zzR() {
            return this.zzu;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public List<zzd.zza> zzS() {
            return new zzgzr(this.zzC, zzl);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public List<zzd.zza> zzT() {
            return new zzgzr(this.zzB, zzk);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public boolean zzU() {
            return (this.zzo & 128) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public boolean zzV() {
            return (this.zzo & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public boolean zzW() {
            return (this.zzo & 64) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public boolean zzX() {
            return (this.zzo & 32) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public boolean zzY() {
            return (this.zzo & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public boolean zzZ() {
            return (this.zzo & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public int zza() {
            return this.zzp;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public boolean zzaa() {
            return (this.zzo & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public boolean zzab() {
            return (this.zzo & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public int zzb() {
            return this.zzC.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public int zzc() {
            return this.zzB.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public zza.EnumC0001zza zzd() {
            zza.EnumC0001zza enumC0001zzaZzb = zza.EnumC0001zza.zzb(this.zzA);
            return enumC0001zzaZzb == null ? zza.EnumC0001zza.AD_INITIATER_UNSPECIFIED : enumC0001zzaZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzm, "\u0004\n\u0000\u0001\u0007\u0010\n\u0000\u0002\u0000\u0007င\u0000\bဈ\u0001\tဉ\u0002\n᠌\u0003\u000bဈ\u0004\fဈ\u0005\r᠌\u0006\u000e᠌\u0007\u000fࠞ\u0010ࠞ", new Object[]{"zzo", "zzp", "zzu", "zzv", "zzw", zzo.zzb.zze(), "zzx", "zzy", sgtsHsWT.aIAxWxCEpXqFyed, zzab.zzc.zze(), "zzA", zza.EnumC0001zza.zze(), "zzB", zzd.zza.zze(), "zzC", zzd.zza.zze()});
            }
            if (iOrdinal == 3) {
                return new zzr();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzm;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzr> zzgzcVar = zzn;
            if (zzgzcVar == null) {
                synchronized (zzr.class) {
                    try {
                        zzgzcVar = zzn;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzm);
                            zzn = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public zzd.zza zze(int i) {
            zzd.zza zzaVarZzb = zzd.zza.zzb(this.zzC.zzd(i));
            return zzaVarZzb == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public zzd.zza zzf(int i) {
            zzd.zza zzaVarZzb = zzd.zza.zzb(this.zzB.zzd(i));
            return zzaVarZzb == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzs
        public zzo.zzb zzg() {
            zzo.zzb zzbVarZzb = zzo.zzb.zzb(this.zzw);
            return zzbVarZzb == null ? zzo.zzb.PLATFORM_UNSPECIFIED : zzbVarZzb;
        }
    }

    public interface zzs extends zzhat {
        zzab.zzc zzK();

        zzar zzL();

        zzgxz zzM();

        zzgxz zzN();

        zzgxz zzO();

        String zzP();

        String zzQ();

        String zzR();

        List<zzd.zza> zzS();

        List<zzd.zza> zzT();

        boolean zzU();

        boolean zzV();

        boolean zzW();

        boolean zzX();

        boolean zzY();

        boolean zzZ();

        int zza();

        boolean zzaa();

        boolean zzab();

        int zzb();

        int zzc();

        zza.EnumC0001zza zzd();

        zzd.zza zze(int i);

        zzd.zza zzf(int i);

        zzo.zzb zzg();
    }

    public interface zzu extends zzhat {
        int zza();

        zzab zzac();

        zzaf zzad();

        zzar zzae();

        zzbl zzaf();

        zzgxz zzag();

        String zzah();

        List<Long> zzai();

        boolean zzaj();

        boolean zzak();

        boolean zzal();

        boolean zzam();

        boolean zzan();

        boolean zzao();

        boolean zzap();

        boolean zzaq();

        boolean zzar();

        boolean zzas();

        boolean zzat();

        boolean zzau();

        int zzb();

        int zzc();

        long zzd(int i);

        zza zze();

        zzb zzf();

        zzm zzg();

        zzo zzh();

        zzq zzi();
    }

    public final class zzv extends zzgzh<zzv, zza> implements zzw {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        private static final zzv zze;
        private static volatile zzhba<zzv> zzf;
        private int zzg;
        private int zzi;
        private zzap zzk;
        private String zzh = "";
        private zzgzp zzj = zzgzh.zzbG();

        public final class zza extends zzgzb<zzv, zza> implements zzw {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzw
            public int zza(int i) {
                return ((zzv) this.zza).zza(i);
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzw
            public int zzb() {
                return ((zzv) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzw
            public zzq zzc() {
                return ((zzv) this.zza).zzc();
            }

            public zza zzd(Iterable<? extends Integer> iterable) {
                zzbu();
                ((zzv) this.zza).zzO(iterable);
                return this;
            }

            public zza zze(int i) {
                zzbu();
                ((zzv) this.zza).zzP(i);
                return this;
            }

            public zza zzf() {
                zzbu();
                ((zzv) this.zza).zzQ();
                return this;
            }

            public zza zzg() {
                zzbu();
                ((zzv) this.zza).zzR();
                return this;
            }

            public zza zzh() {
                zzbu();
                ((zzv) this.zza).zzS();
                return this;
            }

            public zza zzi() {
                zzbu();
                ((zzv) this.zza).zzT();
                return this;
            }

            public zza zzj(zzap zzapVar) {
                zzbu();
                ((zzv) this.zza).zzV(zzapVar);
                return this;
            }

            public zza zzk(String str) {
                zzbu();
                ((zzv) this.zza).zzW(str);
                return this;
            }

            public zza zzl(zzgxz zzgxzVar) {
                zzbu();
                ((zzv) this.zza).zzX(zzgxzVar);
                return this;
            }

            public zza zzm(zzap.zza zzaVar) {
                zzbu();
                ((zzv) this.zza).zzY(zzaVar.zzbr());
                return this;
            }

            public zza zzn(zzap zzapVar) {
                zzbu();
                ((zzv) this.zza).zzY(zzapVar);
                return this;
            }

            public zza zzo(zzq zzqVar) {
                zzbu();
                ((zzv) this.zza).zzZ(zzqVar);
                return this;
            }

            public zza zzp(int i, int i2) {
                zzbu();
                ((zzv) this.zza).zzaa(i, i2);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzw
            public zzap zzq() {
                return ((zzv) this.zza).zzq();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzw
            public zzgxz zzr() {
                return ((zzv) this.zza).zzr();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzw
            public String zzs() {
                return ((zzv) this.zza).zzs();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzw
            public List<Integer> zzt() {
                return Collections.unmodifiableList(((zzv) this.zza).zzt());
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzw
            public boolean zzu() {
                return ((zzv) this.zza).zzu();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzw
            public boolean zzv() {
                return ((zzv) this.zza).zzv();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzw
            public boolean zzw() {
                return ((zzv) this.zza).zzw();
            }

            private zza() {
                super(zzv.zze);
            }
        }

        static {
            zzv zzvVar = new zzv();
            zze = zzvVar;
            zzgzh.zzbZ(zzv.class, zzvVar);
        }

        private zzv() {
        }

        public static zzv zzA(byte[] bArr, zzgyr zzgyrVar) {
            return (zzv) zzgzh.zzbx(zze, bArr, zzgyrVar);
        }

        public static zzhba<zzv> zzB() {
            return zze.zzbN();
        }

        public void zzO(Iterable<? extends Integer> iterable) {
            zzU();
            zzgxi.zzaQ(iterable, this.zzj);
        }

        public void zzP(int i) {
            zzU();
            this.zzj.zzi(i);
        }

        public void zzQ() {
            this.zzg &= -2;
            this.zzh = zzh().zzs();
        }

        public void zzR() {
            this.zzk = null;
            this.zzg &= -5;
        }

        public void zzS() {
            this.zzg &= -3;
            this.zzi = 0;
        }

        public void zzT() {
            this.zzj = zzgzh.zzbG();
        }

        private void zzU() {
            zzgzp zzgzpVar = this.zzj;
            if (zzgzpVar.zzc()) {
                return;
            }
            this.zzj = zzgzh.zzbH(zzgzpVar);
        }

        public void zzV(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzk;
            if (zzapVar2 != null && zzapVar2 != zzap.zzi()) {
                zzap.zza zzaVarZzd = zzap.zzd(zzapVar2);
                zzaVarZzd.zzbj(zzapVar);
                zzapVar = zzaVarZzd.zzbs();
            }
            this.zzk = zzapVar;
            this.zzg |= 4;
        }

        public void zzW(String str) {
            str.getClass();
            this.zzg |= 1;
            this.zzh = str;
        }

        public void zzX(zzgxz zzgxzVar) {
            this.zzh = zzgxzVar.zzx();
            this.zzg |= 1;
        }

        public void zzY(zzap zzapVar) {
            zzapVar.getClass();
            this.zzk = zzapVar;
            this.zzg |= 4;
        }

        public void zzZ(zzq zzqVar) {
            this.zzi = zzqVar.zza();
            this.zzg |= 2;
        }

        public void zzaa(int i, int i2) {
            zzU();
            this.zzj.zze(i, i2);
        }

        public static zza zzd() {
            return (zza) zze.zzaZ();
        }

        public static zza zzf(zzv zzvVar) {
            return (zza) zze.zzba(zzvVar);
        }

        public static zzv zzh() {
            return zze;
        }

        public static zzv zzi(InputStream inputStream) {
            return (zzv) zzgzh.zzbk(zze, inputStream);
        }

        public static zzv zzj(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzv) zzgzh.zzbl(zze, inputStream, zzgyrVar);
        }

        public static zzv zzk(zzgxz zzgxzVar) {
            return (zzv) zzgzh.zzbm(zze, zzgxzVar);
        }

        public static zzv zzl(zzgyf zzgyfVar) {
            return (zzv) zzgzh.zzbn(zze, zzgyfVar);
        }

        public static zzv zzm(InputStream inputStream) {
            return (zzv) zzgzh.zzbo(zze, inputStream);
        }

        public static zzv zzn(ByteBuffer byteBuffer) {
            return (zzv) zzgzh.zzbp(zze, byteBuffer);
        }

        public static zzv zzo(byte[] bArr) {
            return (zzv) zzgzh.zzbq(zze, bArr);
        }

        public static zzv zzp(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzv) zzgzh.zzbr(zze, zzgxzVar, zzgyrVar);
        }

        public static zzv zzx(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzv) zzgzh.zzbs(zze, zzgyfVar, zzgyrVar);
        }

        public static zzv zzy(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzv) zzgzh.zzbu(zze, inputStream, zzgyrVar);
        }

        public static zzv zzz(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzv) zzgzh.zzbv(zze, byteBuffer, zzgyrVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzw
        public int zza(int i) {
            return this.zzj.zzd(i);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzw
        public int zzb() {
            return this.zzj.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzw
        public zzq zzc() {
            zzq zzqVarZzb = zzq.zzb(this.zzi);
            return zzqVarZzb == null ? zzq.ENUM_FALSE : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zze, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003\u0016\u0004ဉ\u0002", new Object[]{"zzg", "zzh", "zzi", zzq.zze(), "zzj", "zzk"});
            }
            if (iOrdinal == 3) {
                return new zzv();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zze;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzv> zzgzcVar = zzf;
            if (zzgzcVar == null) {
                synchronized (zzv.class) {
                    try {
                        zzgzcVar = zzf;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zze);
                            zzf = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzw
        public zzap zzq() {
            zzap zzapVar = this.zzk;
            return zzapVar == null ? zzap.zzi() : zzapVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzw
        public zzgxz zzr() {
            return zzgxz.zzw(this.zzh);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzw
        public String zzs() {
            return this.zzh;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzw
        public List<Integer> zzt() {
            return this.zzj;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzw
        public boolean zzu() {
            return (this.zzg & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzw
        public boolean zzv() {
            return (this.zzg & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzw
        public boolean zzw() {
            return (this.zzg & 2) != 0;
        }
    }

    public interface zzw extends zzhat {
        int zza(int i);

        int zzb();

        zzq zzc();

        zzap zzq();

        zzgxz zzr();

        String zzs();

        List<Integer> zzt();

        boolean zzu();

        boolean zzv();

        boolean zzw();
    }

    public final class zzx extends zzgzh<zzx, zza> implements zzy {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzx zzc;
        private static volatile zzhba<zzx> zzd;
        private int zze;
        private int zzf;
        private zzgzp zzg = zzgzh.zzbG();

        public final class zza extends zzgzb<zzx, zza> implements zzy {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzy
            public int zza(int i) {
                return ((zzx) this.zza).zza(i);
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzy
            public int zzb() {
                return ((zzx) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzy
            public zzq zzc() {
                return ((zzx) this.zza).zzc();
            }

            public zza zzd(Iterable<? extends Integer> iterable) {
                zzbu();
                ((zzx) this.zza).zzD(iterable);
                return this;
            }

            public zza zze(int i) {
                zzbu();
                ((zzx) this.zza).zzE(i);
                return this;
            }

            public zza zzf() {
                zzbu();
                ((zzx) this.zza).zzF();
                return this;
            }

            public zza zzg() {
                zzbu();
                ((zzx) this.zza).zzG();
                return this;
            }

            public zza zzh(int i, int i2) {
                zzbu();
                ((zzx) this.zza).zzI(i, i2);
                return this;
            }

            public zza zzi(zzq zzqVar) {
                zzbu();
                ((zzx) this.zza).zzJ(zzqVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzy
            public List<Integer> zzj() {
                return Collections.unmodifiableList(((zzx) this.zza).zzj());
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzy
            public boolean zzk() {
                return ((zzx) this.zza).zzk();
            }

            private zza() {
                super(zzx.zzc);
            }
        }

        static {
            zzx zzxVar = new zzx();
            zzc = zzxVar;
            zzgzh.zzbZ(zzx.class, zzxVar);
        }

        private zzx() {
        }

        public void zzD(Iterable<? extends Integer> iterable) {
            zzH();
            zzgxi.zzaQ(iterable, this.zzg);
        }

        public void zzE(int i) {
            zzH();
            this.zzg.zzi(i);
        }

        public void zzF() {
            this.zzg = zzgzh.zzbG();
        }

        public void zzG() {
            this.zze &= -2;
            this.zzf = 0;
        }

        private void zzH() {
            zzgzp zzgzpVar = this.zzg;
            if (zzgzpVar.zzc()) {
                return;
            }
            this.zzg = zzgzh.zzbH(zzgzpVar);
        }

        public void zzI(int i, int i2) {
            zzH();
            this.zzg.zze(i, i2);
        }

        public void zzJ(zzq zzqVar) {
            this.zzf = zzqVar.zza();
            this.zze |= 1;
        }

        public static zza zzd() {
            return (zza) zzc.zzaZ();
        }

        public static zza zzf(zzx zzxVar) {
            return (zza) zzc.zzba(zzxVar);
        }

        public static zzx zzh() {
            return zzc;
        }

        public static zzx zzi(InputStream inputStream) {
            return (zzx) zzgzh.zzbk(zzc, inputStream);
        }

        public static zzx zzl(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzx) zzgzh.zzbl(zzc, inputStream, zzgyrVar);
        }

        public static zzx zzm(zzgxz zzgxzVar) {
            return (zzx) zzgzh.zzbm(zzc, zzgxzVar);
        }

        public static zzx zzn(zzgyf zzgyfVar) {
            return (zzx) zzgzh.zzbn(zzc, zzgyfVar);
        }

        public static zzx zzo(InputStream inputStream) {
            return (zzx) zzgzh.zzbo(zzc, inputStream);
        }

        public static zzx zzp(ByteBuffer byteBuffer) {
            return (zzx) zzgzh.zzbp(zzc, byteBuffer);
        }

        public static zzx zzq(byte[] bArr) {
            return (zzx) zzgzh.zzbq(zzc, bArr);
        }

        public static zzx zzr(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzx) zzgzh.zzbr(zzc, zzgxzVar, zzgyrVar);
        }

        public static zzx zzs(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzx) zzgzh.zzbs(zzc, zzgyfVar, zzgyrVar);
        }

        public static zzx zzt(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzx) zzgzh.zzbu(zzc, inputStream, zzgyrVar);
        }

        public static zzx zzu(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzx) zzgzh.zzbv(zzc, byteBuffer, zzgyrVar);
        }

        public static zzx zzv(byte[] bArr, zzgyr zzgyrVar) {
            return (zzx) zzgzh.zzbx(zzc, bArr, zzgyrVar);
        }

        public static zzhba<zzx> zzw() {
            return zzc.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzy
        public int zza(int i) {
            return this.zzg.zzd(i);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzy
        public int zzb() {
            return this.zzg.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzy
        public zzq zzc() {
            zzq zzqVarZzb = zzq.zzb(this.zzf);
            return zzqVarZzb == null ? zzq.ENUM_FALSE : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u0016", new Object[]{"zze", "zzf", zzq.zze(), "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzx();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzc;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzx> zzgzcVar = zzd;
            if (zzgzcVar == null) {
                synchronized (zzx.class) {
                    try {
                        zzgzcVar = zzd;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzc);
                            zzd = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzy
        public List<Integer> zzj() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzy
        public boolean zzk() {
            return (this.zze & 1) != 0;
        }
    }

    public interface zzy extends zzhat {
        int zza(int i);

        int zzb();

        zzq zzc();

        List<Integer> zzj();

        boolean zzk();
    }

    public final class zzz extends zzgzh<zzz, zza> implements zzaa {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        private static final zzz zze;
        private static volatile zzhba<zzz> zzf;
        private int zzg;
        private zzv zzh;
        private zzgzt<zzan> zzi = zzgzh.zzbK();
        private int zzj;
        private zzap zzk;

        public final class zza extends zzgzb<zzz, zza> implements zzaa {
            public /* synthetic */ zza() {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
            public boolean zzA() {
                return ((zzz) this.zza).zzA();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
            public boolean zzB() {
                return ((zzz) this.zza).zzB();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
            public int zza() {
                return ((zzz) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
            public zzq zzb() {
                return ((zzz) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
            public zzv zzc() {
                return ((zzz) this.zza).zzc();
            }

            public zza zzd(Iterable<? extends zzan> iterable) {
                zzbu();
                ((zzz) this.zza).zzR(iterable);
                return this;
            }

            public zza zze(zzan.zza zzaVar) {
                zzbu();
                ((zzz) this.zza).zzS(zzaVar.zzbr());
                return this;
            }

            public zza zzf(zzan zzanVar) {
                zzbu();
                ((zzz) this.zza).zzS(zzanVar);
                return this;
            }

            public zza zzg(int i, zzan.zza zzaVar) {
                zzbu();
                ((zzz) this.zza).zzT(i, zzaVar.zzbr());
                return this;
            }

            public zza zzh(int i, zzan zzanVar) {
                zzbu();
                ((zzz) this.zza).zzT(i, zzanVar);
                return this;
            }

            public zza zzi() {
                zzbu();
                ((zzz) this.zza).zzU();
                return this;
            }

            public zza zzj() {
                zzbu();
                ((zzz) this.zza).zzV();
                return this;
            }

            public zza zzk() {
                zzbu();
                ((zzz) this.zza).zzW();
                return this;
            }

            public zza zzl() {
                zzbu();
                ((zzz) this.zza).zzX();
                return this;
            }

            public zza zzm(zzv zzvVar) {
                zzbu();
                ((zzz) this.zza).zzZ(zzvVar);
                return this;
            }

            public zza zzn(zzap zzapVar) {
                zzbu();
                ((zzz) this.zza).zzaa(zzapVar);
                return this;
            }

            public zza zzo(int i) {
                zzbu();
                ((zzz) this.zza).zzab(i);
                return this;
            }

            public zza zzp(zzv.zza zzaVar) {
                zzbu();
                ((zzz) this.zza).zzac(zzaVar.zzbr());
                return this;
            }

            public zza zzq(zzv zzvVar) {
                zzbu();
                ((zzz) this.zza).zzac(zzvVar);
                return this;
            }

            public zza zzr(zzap.zza zzaVar) {
                zzbu();
                ((zzz) this.zza).zzad(zzaVar.zzbr());
                return this;
            }

            public zza zzs(zzap zzapVar) {
                zzbu();
                ((zzz) this.zza).zzad(zzapVar);
                return this;
            }

            public zza zzt(zzq zzqVar) {
                zzbu();
                ((zzz) this.zza).zzae(zzqVar);
                return this;
            }

            public zza zzu(int i, zzan.zza zzaVar) {
                zzbu();
                ((zzz) this.zza).zzaf(i, zzaVar.zzbr());
                return this;
            }

            public zza zzv(int i, zzan zzanVar) {
                zzbu();
                ((zzz) this.zza).zzaf(i, zzanVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
            public zzan zzw(int i) {
                return ((zzz) this.zza).zzw(i);
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
            public zzap zzx() {
                return ((zzz) this.zza).zzx();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
            public List<zzan> zzy() {
                return Collections.unmodifiableList(((zzz) this.zza).zzy());
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
            public boolean zzz() {
                return ((zzz) this.zza).zzz();
            }

            private zza() {
                super(zzz.zze);
            }
        }

        static {
            zzz zzzVar = new zzz();
            zze = zzzVar;
            zzgzh.zzbZ(zzz.class, zzzVar);
        }

        private zzz() {
        }

        public void zzR(Iterable<? extends zzan> iterable) {
            zzY();
            zzgxi.zzaQ(iterable, this.zzi);
        }

        public void zzS(zzan zzanVar) {
            zzanVar.getClass();
            zzY();
            this.zzi.add(zzanVar);
        }

        public void zzT(int i, zzan zzanVar) {
            zzanVar.getClass();
            zzY();
            this.zzi.add(i, zzanVar);
        }

        public void zzU() {
            this.zzh = null;
            this.zzg &= -2;
        }

        public void zzV() {
            this.zzk = null;
            this.zzg &= -5;
        }

        public void zzW() {
            this.zzg &= -3;
            this.zzj = 0;
        }

        public void zzX() {
            this.zzi = zzgzh.zzbK();
        }

        private void zzY() {
            zzgzt<zzan> zzgztVar = this.zzi;
            if (zzgztVar.zzc()) {
                return;
            }
            this.zzi = zzgzh.zzbL(zzgztVar);
        }

        public void zzZ(zzv zzvVar) {
            zzvVar.getClass();
            zzv zzvVar2 = this.zzh;
            if (zzvVar2 != null && zzvVar2 != zzv.zzh()) {
                zzv.zza zzaVarZzf = zzv.zzf(zzvVar2);
                zzaVarZzf.zzbj(zzvVar);
                zzvVar = zzaVarZzf.zzbs();
            }
            this.zzh = zzvVar;
            this.zzg |= 1;
        }

        public void zzaa(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzk;
            if (zzapVar2 != null && zzapVar2 != zzap.zzi()) {
                zzap.zza zzaVarZzd = zzap.zzd(zzapVar2);
                zzaVarZzd.zzbj(zzapVar);
                zzapVar = zzaVarZzd.zzbs();
            }
            this.zzk = zzapVar;
            this.zzg |= 4;
        }

        public void zzab(int i) {
            zzY();
            this.zzi.remove(i);
        }

        public void zzac(zzv zzvVar) {
            zzvVar.getClass();
            this.zzh = zzvVar;
            this.zzg |= 1;
        }

        public void zzad(zzap zzapVar) {
            zzapVar.getClass();
            this.zzk = zzapVar;
            this.zzg |= 4;
        }

        public void zzae(zzq zzqVar) {
            this.zzj = zzqVar.zza();
            this.zzg |= 2;
        }

        public void zzaf(int i, zzan zzanVar) {
            zzanVar.getClass();
            zzY();
            this.zzi.set(i, zzanVar);
        }

        public static zza zzd() {
            return (zza) zze.zzaZ();
        }

        public static zza zzf(zzz zzzVar) {
            return (zza) zze.zzba(zzzVar);
        }

        public static zzz zzh() {
            return zze;
        }

        public static zzz zzi(InputStream inputStream) {
            return (zzz) zzgzh.zzbk(zze, inputStream);
        }

        public static zzz zzj(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzz) zzgzh.zzbl(zze, inputStream, zzgyrVar);
        }

        public static zzz zzk(zzgxz zzgxzVar) {
            return (zzz) zzgzh.zzbm(zze, zzgxzVar);
        }

        public static zzz zzl(zzgyf zzgyfVar) {
            return (zzz) zzgzh.zzbn(zze, zzgyfVar);
        }

        public static zzz zzm(InputStream inputStream) {
            return (zzz) zzgzh.zzbo(zze, inputStream);
        }

        public static zzz zzn(ByteBuffer byteBuffer) {
            return (zzz) zzgzh.zzbp(zze, byteBuffer);
        }

        public static zzz zzo(byte[] bArr) {
            return (zzz) zzgzh.zzbq(zze, bArr);
        }

        public static zzz zzp(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzz) zzgzh.zzbr(zze, zzgxzVar, zzgyrVar);
        }

        public static zzz zzq(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzz) zzgzh.zzbs(zze, zzgyfVar, zzgyrVar);
        }

        public static zzz zzr(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzz) zzgzh.zzbu(zze, inputStream, zzgyrVar);
        }

        public static zzz zzs(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzz) zzgzh.zzbv(zze, byteBuffer, zzgyrVar);
        }

        public static zzz zzt(byte[] bArr, zzgyr zzgyrVar) {
            return (zzz) zzgzh.zzbx(zze, bArr, zzgyrVar);
        }

        public static zzhba<zzz> zzv() {
            return zze.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
        public boolean zzA() {
            return (this.zzg & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
        public boolean zzB() {
            return (this.zzg & 2) != 0;
        }

        public List<? extends zzao> zzC() {
            return this.zzi;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
        public int zza() {
            return this.zzi.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
        public zzq zzb() {
            zzq zzqVarZzb = zzq.zzb(this.zzj);
            return zzqVarZzb == null ? zzq.ENUM_FALSE : zzqVarZzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
        public zzv zzc() {
            zzv zzvVar = this.zzh;
            return zzvVar == null ? zzv.zzh() : zzvVar;
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zze, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003᠌\u0001\u0004ဉ\u0002", new Object[]{"zzg", "zzh", "zzi", zzan.class, "zzj", zzq.zze(), "zzk"});
            }
            if (iOrdinal == 3) {
                return new zzz();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zze;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzz> zzgzcVar = zzf;
            if (zzgzcVar == null) {
                synchronized (zzz.class) {
                    try {
                        zzgzcVar = zzf;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zze);
                            zzf = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        public zzao zzu(int i) {
            return this.zzi.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
        public zzan zzw(int i) {
            return this.zzi.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
        public zzap zzx() {
            zzap zzapVar = this.zzk;
            return zzapVar == null ? zzap.zzi() : zzapVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
        public List<zzan> zzy() {
            return this.zzi;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzaa
        public boolean zzz() {
            return (this.zzg & 1) != 0;
        }
    }

    private zzbcj() {
    }

    public static void zza(zzgyr zzgyrVar) {
    }

    /* JADX INFO: loaded from: classes2.dex */
    public final class zzt extends zzgzh<zzt, zza> implements zzu {
        public static final int zza = 9;
        public static final int zzb = 10;
        public static final int zzc = 11;
        public static final int zzd = 12;
        public static final int zze = 13;
        public static final int zzf = 14;
        public static final int zzg = 15;
        public static final int zzh = 16;
        public static final int zzi = 17;
        public static final int zzj = 18;
        public static final int zzk = 19;
        public static final int zzl = 20;
        public static final int zzm = 21;
        private static final zzt zzn;
        private static volatile zzhba<zzt> zzo;
        private zzm zzA;
        private zzo zzB;
        private zzab zzC;
        private zza zzD;
        private zzaf zzE;
        private zzbl zzF;
        private zzb zzG;
        private int zzp;
        private int zzu;
        private int zzw;
        private zzar zzy;
        private String zzv = bUqMCsuPSX.iaEelzsfeDAaLe;
        private int zzx = 1000;
        private zzgzs zzz = zzgzh.zzbI();

        /* JADX INFO: loaded from: classes.dex */
        public final class zza extends zzgzb<zzt, zza> implements zzu {
            public /* synthetic */ zza() {
                this();
            }

            public zza zzA(zzm zzmVar) {
                zzbu();
                ((zzt) this.zza).zzcq(zzmVar);
                return this;
            }

            public zza zzB(zzo zzoVar) {
                zzbu();
                ((zzt) this.zza).zzcr(zzoVar);
                return this;
            }

            public zza zzC(zzab zzabVar) {
                zzbu();
                ((zzt) this.zza).zzcs(zzabVar);
                return this;
            }

            public zza zzD(zzaf zzafVar) {
                zzbu();
                ((zzt) this.zza).zzct(zzafVar);
                return this;
            }

            public zza zzE(zzar zzarVar) {
                zzbu();
                ((zzt) this.zza).zzcu(zzarVar);
                return this;
            }

            public zza zzF(zzbl zzblVar) {
                zzbu();
                ((zzt) this.zza).zzcv(zzblVar);
                return this;
            }

            public zza zzG(zza.zzb zzbVar) {
                zzbu();
                ((zzt) this.zza).zzcw(zzbVar.zzbr());
                return this;
            }

            public zza zzH(zza zzaVar) {
                zzbu();
                ((zzt) this.zza).zzcw(zzaVar);
                return this;
            }

            public zza zzI(zzb.zzc zzcVar) {
                zzbu();
                ((zzt) this.zza).zzcx(zzcVar.zzbr());
                return this;
            }

            public zza zzJ(zzb zzbVar) {
                zzbu();
                ((zzt) this.zza).zzcx(zzbVar);
                return this;
            }

            public zza zzK(zzm.zza zzaVar) {
                zzbu();
                ((zzt) this.zza).zzcy(zzaVar.zzbr());
                return this;
            }

            public zza zzL(zzm zzmVar) {
                zzbu();
                ((zzt) this.zza).zzcy(zzmVar);
                return this;
            }

            public zza zzM(zzo.zza zzaVar) {
                zzbu();
                ((zzt) this.zza).zzcz(zzaVar.zzbr());
                return this;
            }

            public zza zzN(zzo zzoVar) {
                zzbu();
                ((zzt) this.zza).zzcz(zzoVar);
                return this;
            }

            public zza zzO(String str) {
                zzbu();
                ((zzt) this.zza).zzcA(str);
                return this;
            }

            public zza zzP(zzgxz zzgxzVar) {
                zzbu();
                ((zzt) this.zza).zzcB(zzgxzVar);
                return this;
            }

            public zza zzQ(int i, long j) {
                zzbu();
                ((zzt) this.zza).zzcC(i, j);
                return this;
            }

            public zza zzR(zzq zzqVar) {
                zzbu();
                ((zzt) this.zza).zzcD(zzqVar);
                return this;
            }

            public zza zzS(int i) {
                zzbu();
                ((zzt) this.zza).zzcE(i);
                return this;
            }

            public zza zzT(zzab.zza zzaVar) {
                zzbu();
                ((zzt) this.zza).zzcF(zzaVar.zzbr());
                return this;
            }

            public zza zzU(zzab zzabVar) {
                zzbu();
                ((zzt) this.zza).zzcF(zzabVar);
                return this;
            }

            public zza zzV(zzaf.zzc zzcVar) {
                zzbu();
                ((zzt) this.zza).zzcG(zzcVar.zzbr());
                return this;
            }

            public zza zzW(zzaf zzafVar) {
                zzbu();
                ((zzt) this.zza).zzcG(zzafVar);
                return this;
            }

            public zza zzX(zzar.zza zzaVar) {
                zzbu();
                ((zzt) this.zza).zzcH(zzaVar.zzbr());
                return this;
            }

            public zza zzY(zzar zzarVar) {
                zzbu();
                ((zzt) this.zza).zzcH(zzarVar);
                return this;
            }

            public zza zzZ(int i) {
                zzbu();
                ((zzt) this.zza).zzcI(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public int zza() {
                return ((zzt) this.zza).zza();
            }

            public zza zzaa(zzbl.zza zzaVar) {
                zzbu();
                ((zzt) this.zza).zzcJ(zzaVar.zzbr());
                return this;
            }

            public zza zzab(zzbl zzblVar) {
                zzbu();
                ((zzt) this.zza).zzcJ(zzblVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public zzab zzac() {
                return ((zzt) this.zza).zzac();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public zzaf zzad() {
                return ((zzt) this.zza).zzad();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public zzar zzae() {
                return ((zzt) this.zza).zzae();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public zzbl zzaf() {
                return ((zzt) this.zza).zzaf();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public zzgxz zzag() {
                return ((zzt) this.zza).zzag();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public String zzah() {
                return ((zzt) this.zza).zzah();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public List<Long> zzai() {
                return Collections.unmodifiableList(((zzt) this.zza).zzai());
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public boolean zzaj() {
                return ((zzt) this.zza).zzaj();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public boolean zzak() {
                return ((zzt) this.zza).zzak();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public boolean zzal() {
                return ((zzt) this.zza).zzal();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public boolean zzam() {
                return ((zzt) this.zza).zzam();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public boolean zzan() {
                return ((zzt) this.zza).zzan();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public boolean zzao() {
                return ((zzt) this.zza).zzao();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public boolean zzap() {
                return ((zzt) this.zza).zzap();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public boolean zzaq() {
                return ((zzt) this.zza).zzaq();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public boolean zzar() {
                return ((zzt) this.zza).zzar();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public boolean zzas() {
                return ((zzt) this.zza).zzas();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public boolean zzat() {
                return ((zzt) this.zza).zzat();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public boolean zzau() {
                return ((zzt) this.zza).zzau();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public int zzb() {
                return ((zzt) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public int zzc() {
                return ((zzt) this.zza).zzc();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public long zzd(int i) {
                return ((zzt) this.zza).zzd(i);
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public zza zze() {
                return ((zzt) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public zzb zzf() {
                return ((zzt) this.zza).zzf();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public zzm zzg() {
                return ((zzt) this.zza).zzg();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public zzo zzh() {
                return ((zzt) this.zza).zzh();
            }

            @Override // com.google.android.gms.internal.ads.zzbcj.zzu
            public zzq zzi() {
                return ((zzt) this.zza).zzi();
            }

            public zza zzj(Iterable<? extends Long> iterable) {
                zzbu();
                ((zzt) this.zza).zzaE(iterable);
                return this;
            }

            public zza zzk(long j) {
                zzbu();
                ((zzt) this.zza).zzaF(j);
                return this;
            }

            public zza zzl() {
                zzbu();
                ((zzt) this.zza).zzaG();
                return this;
            }

            public zza zzm() {
                zzbu();
                ((zzt) this.zza).zzaH();
                return this;
            }

            public zza zzn() {
                zzbu();
                ((zzt) this.zza).zzaI();
                return this;
            }

            public zza zzo() {
                zzbu();
                ((zzt) this.zza).zzaJ();
                return this;
            }

            public zza zzp() {
                zzbu();
                ((zzt) this.zza).zzaK();
                return this;
            }

            public zza zzq() {
                zzbu();
                ((zzt) this.zza).zzcf();
                return this;
            }

            public zza zzr() {
                zzbu();
                ((zzt) this.zza).zzcg();
                return this;
            }

            public zza zzs() {
                zzbu();
                ((zzt) this.zza).zzch();
                return this;
            }

            public zza zzt() {
                zzbu();
                ((zzt) this.zza).zzci();
                return this;
            }

            public zza zzu() {
                zzbu();
                ((zzt) this.zza).zzcj();
                return this;
            }

            public zza zzv() {
                zzbu();
                ((zzt) this.zza).zzck();
                return this;
            }

            public zza zzw() {
                zzbu();
                ((zzt) this.zza).zzcl();
                return this;
            }

            public zza zzx() {
                zzbu();
                ((zzt) this.zza).zzcm();
                return this;
            }

            public zza zzy(zza zzaVar) {
                zzbu();
                ((zzt) this.zza).zzco(zzaVar);
                return this;
            }

            public zza zzz(zzb zzbVar) {
                zzbu();
                ((zzt) this.zza).zzcp(zzbVar);
                return this;
            }

            private zza() {
                super(zzt.zzn);
            }
        }

        static {
            zzt zztVar = new zzt();
            zzn = zztVar;
            zzgzh.zzbZ(zzt.class, zztVar);
        }

        public void zzaE(Iterable<? extends Long> iterable) {
            zzcn();
            zzgxi.zzaQ(iterable, this.zzz);
        }

        public void zzaF(long j) {
            zzcn();
            this.zzz.zzg(j);
        }

        public void zzaG() {
            this.zzD = null;
            this.zzp &= -257;
        }

        public void zzaH() {
            this.zzG = null;
            this.zzp &= -2049;
        }

        public void zzaI() {
            this.zzA = null;
            this.zzp &= -33;
        }

        public void zzaJ() {
            this.zzB = null;
            this.zzp &= -65;
        }

        public void zzaK() {
            this.zzp &= -3;
            this.zzv = zzm().zzah();
        }

        public void zzcA(String str) {
            str.getClass();
            this.zzp |= 2;
            this.zzv = str;
        }

        public void zzcB(zzgxz zzgxzVar) {
            this.zzv = zzgxzVar.zzx();
            this.zzp |= 2;
        }

        public void zzcC(int i, long j) {
            zzcn();
            this.zzz.zzd(i, j);
        }

        public void zzcD(zzq zzqVar) {
            this.zzx = zzqVar.zza();
            this.zzp |= 8;
        }

        public void zzcE(int i) {
            this.zzp |= 1;
            this.zzu = i;
        }

        public void zzcF(zzab zzabVar) {
            zzabVar.getClass();
            this.zzC = zzabVar;
            this.zzp |= 128;
        }

        public void zzcG(zzaf zzafVar) {
            zzafVar.getClass();
            this.zzE = zzafVar;
            this.zzp |= 512;
        }

        public void zzcH(zzar zzarVar) {
            zzarVar.getClass();
            this.zzy = zzarVar;
            this.zzp |= 16;
        }

        public void zzcI(int i) {
            this.zzp |= 4;
            this.zzw = i;
        }

        public void zzcJ(zzbl zzblVar) {
            zzblVar.getClass();
            this.zzF = zzblVar;
            this.zzp |= 1024;
        }

        public void zzcf() {
            this.zzz = zzgzh.zzbI();
        }

        public void zzcg() {
            this.zzp &= -9;
            this.zzx = 1000;
        }

        public void zzch() {
            this.zzp &= -2;
            this.zzu = 0;
        }

        public void zzci() {
            this.zzC = null;
            this.zzp &= -129;
        }

        public void zzcj() {
            this.zzE = null;
            this.zzp &= -513;
        }

        public void zzck() {
            this.zzy = null;
            this.zzp &= -17;
        }

        public void zzcl() {
            this.zzp &= -5;
            this.zzw = 0;
        }

        public void zzcm() {
            this.zzF = null;
            this.zzp &= -1025;
        }

        private void zzcn() {
            zzgzs zzgzsVar = this.zzz;
            if (zzgzsVar.zzc()) {
                return;
            }
            this.zzz = zzgzh.zzbJ(zzgzsVar);
        }

        public void zzco(zza zzaVar) {
            zzaVar.getClass();
            zza zzaVar2 = this.zzD;
            if (zzaVar2 != null && zzaVar2 != zza.zzh()) {
                zza.zzb zzbVarZzf = zza.zzf(zzaVar2);
                zzbVarZzf.zzbj(zzaVar);
                zzaVar = zzbVarZzf.zzbs();
            }
            this.zzD = zzaVar;
            this.zzp |= 256;
        }

        public void zzcp(zzb zzbVar) {
            zzbVar.getClass();
            zzb zzbVar2 = this.zzG;
            if (zzbVar2 != null && zzbVar2 != zzb.zzh()) {
                zzb.zzc zzcVarZzf = zzb.zzf(zzbVar2);
                zzcVarZzf.zzbj(zzbVar);
                zzbVar = zzcVarZzf.zzbs();
            }
            this.zzG = zzbVar;
            this.zzp |= 2048;
        }

        public void zzcq(zzm zzmVar) {
            zzmVar.getClass();
            zzm zzmVar2 = this.zzA;
            if (zzmVar2 != null && zzmVar2 != zzm.zzg()) {
                zzm.zza zzaVarZzd = zzm.zzd(zzmVar2);
                zzaVarZzd.zzbj(zzmVar);
                zzmVar = zzaVarZzd.zzbs();
            }
            this.zzA = zzmVar;
            this.zzp |= 32;
        }

        public void zzcr(zzo zzoVar) {
            zzoVar.getClass();
            zzo zzoVar2 = this.zzB;
            if (zzoVar2 != null && zzoVar2 != zzo.zzd()) {
                zzo.zza zzaVarZzb = zzo.zzb(zzoVar2);
                zzaVarZzb.zzbj(zzoVar);
                zzoVar = zzaVarZzb.zzbs();
            }
            this.zzB = zzoVar;
            this.zzp |= 64;
        }

        public void zzcs(zzab zzabVar) {
            zzabVar.getClass();
            zzab zzabVar2 = this.zzC;
            if (zzabVar2 != null && zzabVar2 != zzab.zzd()) {
                zzab.zza zzaVarZzb = zzab.zzb(zzabVar2);
                zzaVarZzb.zzbj(zzabVar);
                zzabVar = zzaVarZzb.zzbs();
            }
            this.zzC = zzabVar;
            this.zzp |= 128;
        }

        public void zzct(zzaf zzafVar) {
            zzafVar.getClass();
            zzaf zzafVar2 = this.zzE;
            if (zzafVar2 != null && zzafVar2 != zzaf.zzl()) {
                zzaf.zzc zzcVarZzj = zzaf.zzj(zzafVar2);
                zzcVarZzj.zzbj(zzafVar);
                zzafVar = zzcVarZzj.zzbs();
            }
            this.zzE = zzafVar;
            this.zzp |= 512;
        }

        public void zzcu(zzar zzarVar) {
            zzarVar.getClass();
            zzar zzarVar2 = this.zzy;
            if (zzarVar2 != null && zzarVar2 != zzar.zzh()) {
                zzar.zza zzaVarZzf = zzar.zzf(zzarVar2);
                zzaVarZzf.zzbj(zzarVar);
                zzarVar = zzaVarZzf.zzbs();
            }
            this.zzy = zzarVar;
            this.zzp |= 16;
        }

        public void zzcv(zzbl zzblVar) {
            zzblVar.getClass();
            zzbl zzblVar2 = this.zzF;
            if (zzblVar2 != null && zzblVar2 != zzbl.zzi()) {
                zzbl.zza zzaVarZzc = zzbl.zzc(zzblVar2);
                zzaVarZzc.zzbj(zzblVar);
                zzblVar = zzaVarZzc.zzbs();
            }
            this.zzF = zzblVar;
            this.zzp |= 1024;
        }

        public void zzcw(zza zzaVar) {
            zzaVar.getClass();
            this.zzD = zzaVar;
            this.zzp |= 256;
        }

        public void zzcx(zzb zzbVar) {
            zzbVar.getClass();
            this.zzG = zzbVar;
            this.zzp |= 2048;
        }

        public void zzcy(zzm zzmVar) {
            zzmVar.getClass();
            this.zzA = zzmVar;
            this.zzp |= 32;
        }

        public void zzcz(zzo zzoVar) {
            zzoVar.getClass();
            this.zzB = zzoVar;
            this.zzp |= 64;
        }

        public static zza zzj() {
            return (zza) zzn.zzaZ();
        }

        public static zza zzk(zzt zztVar) {
            return (zza) zzn.zzba(zztVar);
        }

        public static zzt zzm() {
            return zzn;
        }

        public static zzt zzn(InputStream inputStream) {
            return (zzt) zzgzh.zzbk(zzn, inputStream);
        }

        public static zzt zzo(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzt) zzgzh.zzbl(zzn, inputStream, zzgyrVar);
        }

        public static zzt zzp(zzgxz zzgxzVar) {
            return (zzt) zzgzh.zzbm(zzn, zzgxzVar);
        }

        public static zzt zzq(zzgyf zzgyfVar) {
            return (zzt) zzgzh.zzbn(zzn, zzgyfVar);
        }

        public static zzt zzr(InputStream inputStream) {
            return (zzt) zzgzh.zzbo(zzn, inputStream);
        }

        public static zzt zzs(ByteBuffer byteBuffer) {
            return (zzt) zzgzh.zzbp(zzn, byteBuffer);
        }

        public static zzt zzt(byte[] bArr) {
            return (zzt) zzgzh.zzbq(zzn, bArr);
        }

        public static zzt zzu(zzgxz zzgxzVar, zzgyr zzgyrVar) {
            return (zzt) zzgzh.zzbr(zzn, zzgxzVar, zzgyrVar);
        }

        public static zzt zzv(zzgyf zzgyfVar, zzgyr zzgyrVar) {
            return (zzt) zzgzh.zzbs(zzn, zzgyfVar, zzgyrVar);
        }

        public static zzt zzw(InputStream inputStream, zzgyr zzgyrVar) {
            return (zzt) zzgzh.zzbu(zzn, inputStream, zzgyrVar);
        }

        public static zzt zzx(ByteBuffer byteBuffer, zzgyr zzgyrVar) {
            return (zzt) zzgzh.zzbv(zzn, byteBuffer, zzgyrVar);
        }

        public static zzt zzy(byte[] bArr, zzgyr zzgyrVar) {
            return (zzt) zzgzh.zzbx(zzn, bArr, zzgyrVar);
        }

        public static zzhba<zzt> zzz() {
            return zzn.zzbN();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public int zza() {
            return this.zzz.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public zzab zzac() {
            zzab zzabVar = this.zzC;
            return zzabVar == null ? zzab.zzd() : zzabVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public zzaf zzad() {
            zzaf zzafVar = this.zzE;
            return zzafVar == null ? zzaf.zzl() : zzafVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public zzar zzae() {
            zzar zzarVar = this.zzy;
            return zzarVar == null ? zzar.zzh() : zzarVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public zzbl zzaf() {
            zzbl zzblVar = this.zzF;
            return zzblVar == null ? zzbl.zzi() : zzblVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public zzgxz zzag() {
            return zzgxz.zzw(this.zzv);
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public String zzah() {
            return this.zzv;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public List<Long> zzai() {
            return this.zzz;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public boolean zzaj() {
            return (this.zzp & 256) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public boolean zzak() {
            return (this.zzp & 2048) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public boolean zzal() {
            return (this.zzp & 32) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public boolean zzam() {
            return (this.zzp & 64) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public boolean zzan() {
            return (this.zzp & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public boolean zzao() {
            return (this.zzp & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public boolean zzap() {
            return (this.zzp & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public boolean zzaq() {
            return (this.zzp & 128) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public boolean zzar() {
            return (this.zzp & 512) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public boolean zzas() {
            return (this.zzp & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public boolean zzat() {
            return (this.zzp & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public boolean zzau() {
            return (this.zzp & 1024) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public int zzb() {
            return this.zzu;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public int zzc() {
            return this.zzw;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public long zzd(int i) {
            return this.zzz.zza(i);
        }

        @Override // com.google.android.gms.internal.ads.zzgzh
        public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
            int iOrdinal = zzgzgVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzgzh.zzbQ(zzn, "\u0004\r\u0000\u0001\t\u0015\r\u0000\u0001\u0000\tင\u0000\nဈ\u0001\u000bဋ\u0002\f᠌\u0003\rဉ\u0004\u000e\u0015\u000fဉ\u0005\u0010ဉ\u0006\u0011ဉ\u0007\u0012ဉ\b\u0013ဉ\t\u0014ဉ\n\u0015ဉ\u000b", new Object[]{"zzp", "zzu", "zzv", "zzw", "zzx", zzq.zze(), "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzF", "zzG"});
            }
            if (iOrdinal == 3) {
                return new zzt();
            }
            if (iOrdinal == 4) {
                return new zza();
            }
            if (iOrdinal == 5) {
                return zzn;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzhba<zzt> zzgzcVar = zzo;
            if (zzgzcVar == null) {
                synchronized (zzt.class) {
                    try {
                        zzgzcVar = zzo;
                        if (zzgzcVar == null) {
                            zzgzcVar = new zzgzc(zzn);
                            zzo = zzgzcVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return zzgzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public zza zze() {
            zza zzaVar = this.zzD;
            return zzaVar == null ? zza.zzh() : zzaVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public zzb zzf() {
            zzb zzbVar = this.zzG;
            return zzbVar == null ? zzb.zzh() : zzbVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public zzm zzg() {
            zzm zzmVar = this.zzA;
            return zzmVar == null ? zzm.zzg() : zzmVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public zzo zzh() {
            zzo zzoVar = this.zzB;
            return zzoVar == null ? zzo.zzd() : zzoVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbcj.zzu
        public zzq zzi() {
            zzq zzqVarZzb = zzq.zzb(this.zzx);
            return zzqVarZzb == null ? zzq.ENUM_UNKNOWN : zzqVarZzb;
        }

        private zzt() {
        }
    }
}
