package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgfi implements zzgmy {
    private final zzgun zza;
    private final List zzb;
    private final zzgnh zzc;

    public /* synthetic */ zzgfi(zzgun zzgunVar, List list, zzgnh zzgnhVar) {
        this(zzgunVar, list, zzgnhVar);
    }

    public static final zzgfi zzd(zzgun zzgunVar) throws GeneralSecurityException {
        zzj(zzgunVar);
        return new zzgfi(zzgunVar, zzi(zzgunVar), zzgnh.zza);
    }

    public static final zzgfi zze(zzgfm zzgfmVar) {
        zzgff zzgffVar = new zzgff();
        zzgfd zzgfdVar = new zzgfd(zzgfmVar, null);
        zzgfdVar.zzd();
        zzgfdVar.zzc();
        zzgffVar.zza(zzgfdVar);
        return zzgffVar.zzb();
    }

    private static List zzi(zzgun zzgunVar) throws GeneralSecurityException {
        zzgfb zzgfbVar;
        ArrayList arrayList = new ArrayList(zzgunVar.zza());
        for (zzgul zzgulVar : zzgunVar.zzh()) {
            int iZza = zzgulVar.zza();
            try {
                zzgox zzgoxVarZza = zzgox.zza(zzgulVar.zzb().zzg(), zzgulVar.zzb().zzf(), zzgulVar.zzb().zzb(), zzgulVar.zzf(), zzgulVar.zzf() == zzgvf.RAW ? null : Integer.valueOf(zzgulVar.zza()));
                zzgny zzgnyVarZzc = zzgny.zzc();
                zzgfn zzgfnVarZza = zzgfn.zza();
                zzgez zzgndVar = !zzgnyVarZzc.zzj(zzgoxVarZza) ? new zzgnd(zzgoxVarZza, zzgfnVarZza) : zzgnyVarZzc.zza(zzgoxVarZza, zzgfnVarZza);
                int iZzk = zzgulVar.zzk() - 2;
                if (iZzk == 1) {
                    zzgfbVar = zzgfb.zza;
                } else if (iZzk == 2) {
                    zzgfbVar = zzgfb.zzb;
                } else {
                    if (iZzk != 3) {
                        throw new GeneralSecurityException("Unknown key status");
                    }
                    zzgfbVar = zzgfb.zzc;
                }
                arrayList.add(new zzgfg(zzgndVar, zzgfbVar, iZza, iZza == zzgunVar.zzb(), null));
            } catch (GeneralSecurityException e) {
                if (zzgme.zza.zza()) {
                    throw new GeneralSecurityException("Parsing of a single key failed (maybe wrong status?) and Tink is configured via validateKeysetsOnParsing to reject such keysets.", e);
                }
                arrayList.add(null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static void zzj(zzgun zzgunVar) throws GeneralSecurityException {
        if (zzgunVar == null || zzgunVar.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public final String toString() {
        int i = zzgfp.zza;
        zzguo zzguoVarZza = zzgus.zza();
        zzgun zzgunVar = this.zza;
        zzguoVarZza.zzb(zzgunVar.zzb());
        for (zzgul zzgulVar : zzgunVar.zzh()) {
            zzgup zzgupVarZza = zzguq.zza();
            zzgupVarZza.zzc(zzgulVar.zzb().zzg());
            zzgupVarZza.zzd(zzgulVar.zzk());
            zzgupVarZza.zzb(zzgulVar.zzf());
            zzgupVarZza.zza(zzgulVar.zza());
            zzguoVarZza.zza((zzguq) zzgupVarZza.zzbr());
        }
        return ((zzgus) zzguoVarZza.zzbr()).toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgmy
    public final int zza() {
        return this.zzb.size();
    }

    public final zzgfg zzb(int i) {
        if (i < 0 || i >= zza()) {
            throw new IndexOutOfBoundsException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, zza(), "Invalid index ", " for keyset of size "));
        }
        List list = this.zzb;
        if (list.get(i) != null) {
            return (zzgfg) list.get(i);
        }
        throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Keyset-Entry at position ", " has wrong status or key parsing failed"));
    }

    public final zzgfg zzc() {
        for (zzgfg zzgfgVar : this.zzb) {
            if (zzgfgVar != null && zzgfgVar.zzd()) {
                if (zzgfgVar.zzc() == zzgfb.zza) {
                    return zzgfgVar;
                }
                throw new IllegalStateException("Keyset has primary which isn't enabled");
            }
        }
        throw new IllegalStateException("Keyset has no valid primary");
    }

    public final zzgun zzf() {
        return this.zza;
    }

    public final Object zzg(zzgex zzgexVar, Class cls) throws GeneralSecurityException {
        if (!(zzgexVar instanceof zzgmo)) {
            throw new GeneralSecurityException("Currently only subclasses of InternalConfiguration are accepted");
        }
        zzgmo zzgmoVar = (zzgmo) zzgexVar;
        zzgun zzgunVar = this.zza;
        int i = zzgfp.zza;
        int iZzb = zzgunVar.zzb();
        int i2 = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzgul zzgulVar : zzgunVar.zzh()) {
            if (zzgulVar.zzk() == 3) {
                if (!zzgulVar.zzj()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzgulVar.zza())));
                }
                if (zzgulVar.zzf() == zzgvf.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzgulVar.zza())));
                }
                if (zzgulVar.zzk() == 2) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzgulVar.zza())));
                }
                if (zzgulVar.zza() == iZzb) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                z2 &= zzgulVar.zzb().zzb() == zzgtz.ASYMMETRIC_PUBLIC;
                i2++;
            }
        }
        if (i2 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
        for (int i3 = 0; i3 < zza(); i3++) {
            if (this.zzb.get(i3) == null) {
                throw new GeneralSecurityException("Key parsing of key with index " + i3 + JuorMn.QfFGl + zzgunVar.zzd(i3).zzb().zzg() + " failed, unable to get primitive");
            }
        }
        return zzgmoVar.zza(this, this.zzc, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    zzgfi(zzgun zzgunVar, List list, zzgnh zzgnhVar) throws GeneralSecurityException {
        this.zza = zzgunVar;
        this.zzb = list;
        this.zzc = zzgnhVar;
        if (zzgme.zza.zza()) {
            HashSet hashSet = new HashSet();
            for (zzgul zzgulVar : zzgunVar.zzh()) {
                if (hashSet.contains(Integer.valueOf(zzgulVar.zza()))) {
                    throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzgulVar.zza(), "KeyID ", " is duplicated in the keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing."));
                }
                hashSet.add(Integer.valueOf(zzgulVar.zza()));
            }
            if (!hashSet.contains(Integer.valueOf(zzgunVar.zzb()))) {
                throw new GeneralSecurityException("Primary key id not found in keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing.");
            }
        }
    }
}
