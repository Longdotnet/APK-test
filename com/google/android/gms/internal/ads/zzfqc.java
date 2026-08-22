package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class zzfqc {
    private static final Object zza = new Object();
    private final Context zzb;
    private final SharedPreferences zzc;
    private final String zzd;
    private final zzfpj zze;
    private boolean zzf;

    public zzfqc(Context context, int i, zzfpj zzfpjVar, boolean z) {
        this.zzf = false;
        this.zzb = context;
        this.zzd = Integer.toString(i - 1);
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        this.zze = zzfpjVar;
        this.zzf = z;
    }

    private final File zze(String str) {
        return new File(new File(this.zzb.getDir("pccache", 0), this.zzd), str);
    }

    private static String zzf(zzayp zzaypVar) {
        zzayq zzayqVarZzd = zzays.zzd();
        zzayqVarZzd.zze(zzaypVar.zzc().zzk());
        zzayqVarZzd.zza(zzaypVar.zzc().zzj());
        zzayqVarZzd.zzb(zzaypVar.zzc().zza());
        zzayqVarZzd.zzd(zzaypVar.zzc().zzc());
        zzayqVarZzd.zzc(zzaypVar.zzc().zzb());
        return Hex.bytesToStringLowercase(((zzays) zzayqVarZzd.zzbr()).zzaV());
    }

    private final String zzg() {
        return "FBAMTD".concat(String.valueOf(this.zzd));
    }

    private final String zzh() {
        return "LATMTD".concat(String.valueOf(this.zzd));
    }

    private final void zzi(int i, long j) {
        this.zze.zza(i, j);
    }

    private final void zzj(int i, long j, String str) {
        this.zze.zzb(i, j, str);
    }

    private final zzays zzk(int i) {
        String string = i == 1 ? this.zzc.getString(zzh(), null) : this.zzc.getString(zzg(), null);
        if (string == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            byte[] bArrStringToBytes = Hex.stringToBytes(string);
            return zzays.zzi(zzgxz.zzv(bArrStringToBytes, 0, bArrStringToBytes.length), this.zzf ? zzgyr.zza() : zzgyr.zzb());
        } catch (zzgzw unused) {
            return null;
        } catch (NullPointerException unused2) {
            zzi(2029, jCurrentTimeMillis);
            return null;
        } catch (RuntimeException unused3) {
            zzi(2032, jCurrentTimeMillis);
            return null;
        }
    }

    public final boolean zza(zzayp zzaypVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            try {
                if (!zzfpw.zze(new File(zze(zzaypVar.zzc().zzk()), "pcbc"), zzaypVar.zzd().zzA())) {
                    zzi(4020, jCurrentTimeMillis);
                    return false;
                }
                String strZzf = zzf(zzaypVar);
                SharedPreferences.Editor editorEdit = this.zzc.edit();
                editorEdit.putString(zzh(), strZzf);
                boolean zCommit = editorEdit.commit();
                if (zCommit) {
                    zzi(5015, jCurrentTimeMillis);
                } else {
                    zzi(4021, jCurrentTimeMillis);
                }
                return zCommit;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzb(zzayp zzaypVar, zzfqb zzfqbVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            try {
                zzays zzaysVarZzk = zzk(1);
                String strZzk = zzaypVar.zzc().zzk();
                if (zzaysVarZzk != null && zzaysVarZzk.zzk().equals(strZzk)) {
                    zzi(4014, jCurrentTimeMillis);
                    return false;
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                File fileZze = zze(strZzk);
                if (fileZze.exists()) {
                    zzj(4023, jCurrentTimeMillis2, "d:" + (true != fileZze.isDirectory() ? "0" : "1") + ",f:" + (true != fileZze.isFile() ? "0" : "1"));
                    zzi(4015, jCurrentTimeMillis2);
                } else if (!fileZze.mkdirs()) {
                    zzj(4024, jCurrentTimeMillis2, "cw:".concat(true != fileZze.canWrite() ? "0" : "1"));
                    zzi(4015, jCurrentTimeMillis2);
                    return false;
                }
                File fileZze2 = zze(strZzk);
                File file = new File(fileZze2, "pcam.jar");
                File file2 = new File(fileZze2, "pcbc");
                if (!zzfpw.zze(file, zzaypVar.zzf().zzA())) {
                    zzi(4016, jCurrentTimeMillis);
                    return false;
                }
                if (!zzfpw.zze(file2, zzaypVar.zzd().zzA())) {
                    zzi(4017, jCurrentTimeMillis);
                    return false;
                }
                if (zzfqbVar != null && !zzfqbVar.zza(file)) {
                    zzi(4018, jCurrentTimeMillis);
                    zzfpw.zzd(fileZze2);
                    return false;
                }
                String strZzf = zzf(zzaypVar);
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                SharedPreferences sharedPreferences = this.zzc;
                String string = sharedPreferences.getString(zzh(), null);
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString(zzh(), strZzf);
                if (string != null) {
                    editorEdit.putString(zzg(), string);
                }
                if (!editorEdit.commit()) {
                    zzi(4019, jCurrentTimeMillis3);
                    return false;
                }
                HashSet hashSet = new HashSet();
                zzays zzaysVarZzk2 = zzk(1);
                if (zzaysVarZzk2 != null) {
                    hashSet.add(zzaysVarZzk2.zzk());
                }
                zzays zzaysVarZzk3 = zzk(2);
                if (zzaysVarZzk3 != null) {
                    hashSet.add(zzaysVarZzk3.zzk());
                }
                for (File file3 : new File(this.zzb.getDir("pccache", 0), this.zzd).listFiles()) {
                    if (!hashSet.contains(file3.getName())) {
                        zzfpw.zzd(file3);
                    }
                }
                zzi(5014, jCurrentTimeMillis);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzfpu zzc(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            try {
                zzays zzaysVarZzk = zzk(1);
                if (zzaysVarZzk == null) {
                    zzi(4022, jCurrentTimeMillis);
                    return null;
                }
                File fileZze = zze(zzaysVarZzk.zzk());
                File file = new File(fileZze, "pcam.jar");
                if (!file.exists()) {
                    file = new File(fileZze, "pcam");
                }
                File file2 = new File(fileZze, "pcbc");
                File file3 = new File(fileZze, "pcopt");
                zzi(5016, jCurrentTimeMillis);
                return new zzfpu(zzaysVarZzk, file, file2, file3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzd(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            try {
                zzays zzaysVarZzk = zzk(1);
                if (zzaysVarZzk == null) {
                    zzi(4025, jCurrentTimeMillis);
                    return false;
                }
                File fileZze = zze(zzaysVarZzk.zzk());
                if (!new File(fileZze, "pcam.jar").exists()) {
                    zzi(4026, jCurrentTimeMillis);
                    return false;
                }
                if (new File(fileZze, "pcbc").exists()) {
                    zzi(5019, jCurrentTimeMillis);
                    return true;
                }
                zzi(4027, jCurrentTimeMillis);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
