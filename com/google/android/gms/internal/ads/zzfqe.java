package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfqe {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzfqf zzc;
    private final zzfoi zzd;
    private final zzfod zze;
    private zzfpt zzf;
    private final Object zzg = new Object();

    public zzfqe(Context context, zzfqf zzfqfVar, zzfoi zzfoiVar, zzfod zzfodVar, boolean z) {
        this.zzb = context;
        this.zzc = zzfqfVar;
        this.zzd = zzfoiVar;
        this.zze = zzfodVar;
    }

    private final synchronized Class zzd(zzfpu zzfpuVar) {
        try {
            String strZzk = zzfpuVar.zza().zzk();
            HashMap map = zza;
            Class cls = (Class) map.get(strZzk);
            if (cls != null) {
                return cls;
            }
            try {
                if (!this.zze.zza(zzfpuVar.zzc())) {
                    throw new zzfqd(2026, "VM did not pass signature verification");
                }
                try {
                    File fileZzb = zzfpuVar.zzb();
                    if (!fileZzb.exists()) {
                        fileZzb.mkdirs();
                    }
                    Class<?> clsLoadClass = new DexClassLoader(zzfpuVar.zzc().getAbsolutePath(), fileZzb.getAbsolutePath(), null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                    map.put(strZzk, clsLoadClass);
                    return clsLoadClass;
                } catch (ClassNotFoundException e) {
                    e = e;
                    throw new zzfqd(2008, e);
                } catch (IllegalArgumentException e2) {
                    e = e2;
                    throw new zzfqd(2008, e);
                } catch (SecurityException e3) {
                    e = e3;
                    throw new zzfqd(2008, e);
                }
            } catch (GeneralSecurityException e4) {
                throw new zzfqd(2026, e4);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final zzfol zza() {
        zzfpt zzfptVar;
        synchronized (this.zzg) {
            zzfptVar = this.zzf;
        }
        return zzfptVar;
    }

    public final zzfpu zzb() {
        synchronized (this.zzg) {
            try {
                zzfpt zzfptVar = this.zzf;
                if (zzfptVar == null) {
                    return null;
                }
                return zzfptVar.zzf();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzc(zzfpu zzfpuVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                zzfpt zzfptVar = new zzfpt(zzd(zzfpuVar).getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.zzb, oKjScaD.TFumViDxzR, zzfpuVar.zze(), null, new Bundle(), 2), zzfpuVar, this.zzc, this.zzd, false);
                if (!zzfptVar.zzh()) {
                    throw new zzfqd(4000, "init failed");
                }
                int iZze = zzfptVar.zze();
                if (iZze != 0) {
                    throw new zzfqd(4001, "ci: " + iZze);
                }
                synchronized (this.zzg) {
                    try {
                        zzfpt zzfptVar2 = this.zzf;
                        if (zzfptVar2 != null) {
                            try {
                                zzfptVar2.zzg();
                            } catch (zzfqd e) {
                                this.zzd.zzc(e.zza(), -1L, e);
                            }
                        }
                        this.zzf = zzfptVar;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.zzd.zzd(3000, System.currentTimeMillis() - jCurrentTimeMillis);
                return true;
            } catch (Exception e2) {
                throw new zzfqd(2004, e2);
            }
        } catch (zzfqd e3) {
            this.zzd.zzc(e3.zza(), System.currentTimeMillis() - jCurrentTimeMillis, e3);
            return false;
        } catch (Exception e4) {
            this.zzd.zzc(4010, System.currentTimeMillis() - jCurrentTimeMillis, e4);
            return false;
        }
    }
}
