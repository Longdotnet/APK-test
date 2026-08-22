package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpv {
    final File zza;
    private final File zzb;
    private final SharedPreferences zzc;
    private final int zzd;

    public zzfpv(Context context, int i) {
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        File dir = context.getDir("pccache", 0);
        zzfpw.zza(dir, false);
        this.zzb = dir;
        File dir2 = context.getDir("tmppccache", 0);
        zzfpw.zza(dir2, true);
        this.zza = dir2;
        this.zzd = i;
    }

    private final File zzd() {
        File file = new File(this.zzb, Integer.toString(this.zzd - 1));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zze() {
        StringBuilder sb = new StringBuilder("FBAMTD");
        sb.append(this.zzd - 1);
        return sb.toString();
    }

    private final String zzf() {
        StringBuilder sb = new StringBuilder("LATMTD");
        sb.append(this.zzd - 1);
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x007d  */
    public final boolean zza(zzayp zzaypVar, zzfqb zzfqbVar) {
        boolean z;
        String strZzk = zzaypVar.zzc().zzk();
        byte[] bArrZzA = zzaypVar.zzf().zzA();
        byte[] bArrZzA2 = zzaypVar.zzd().zzA();
        if (!TextUtils.isEmpty(strZzk) && bArrZzA2 != null && bArrZzA2.length != 0) {
            File file = this.zza;
            zzfpw.zzd(file);
            file.mkdirs();
            zzfpw.zzc(strZzk, file).mkdirs();
            File fileZzb = zzfpw.zzb(strZzk, "pcam.jar", file);
            if ((bArrZzA == null || bArrZzA.length <= 0 || zzfpw.zze(fileZzb, bArrZzA)) && zzfpw.zze(zzfpw.zzb(strZzk, "pcbc", file), bArrZzA2)) {
                File fileZzb2 = zzfpw.zzb(zzaypVar.zzc().zzk(), "pcam.jar", file);
                if (fileZzb2.exists() && zzfqbVar != null && !zzfqbVar.zza(fileZzb2)) {
                    return false;
                }
                String strZzk2 = zzaypVar.zzc().zzk();
                if (TextUtils.isEmpty(strZzk2)) {
                    z = false;
                } else {
                    File fileZzb3 = zzfpw.zzb(strZzk2, "pcam.jar", file);
                    File fileZzb4 = zzfpw.zzb(strZzk2, "pcbc", file);
                    File fileZzb5 = zzfpw.zzb(strZzk2, "pcam.jar", zzd());
                    File fileZzb6 = zzfpw.zzb(strZzk2, "pcbc", zzd());
                    if ((!fileZzb3.exists() || fileZzb3.renameTo(fileZzb5)) && fileZzb4.exists() && fileZzb4.renameTo(fileZzb6)) {
                        zzayq zzayqVarZzd = zzays.zzd();
                        zzayqVarZzd.zze(zzaypVar.zzc().zzk());
                        zzayqVarZzd.zza(zzaypVar.zzc().zzj());
                        zzayqVarZzd.zzb(zzaypVar.zzc().zza());
                        zzayqVarZzd.zzd(zzaypVar.zzc().zzc());
                        zzayqVarZzd.zzc(zzaypVar.zzc().zzb());
                        zzays zzaysVar = (zzays) zzayqVarZzd.zzbr();
                        zzays zzaysVarZzb = zzb(1);
                        SharedPreferences.Editor editorEdit = this.zzc.edit();
                        if (zzaysVarZzb != null && !zzaysVar.zzk().equals(zzaysVarZzb.zzk())) {
                            editorEdit.putString(zze(), Hex.bytesToStringLowercase(zzaysVarZzb.zzaV()));
                        }
                        editorEdit.putString(zzf(), Hex.bytesToStringLowercase(zzaysVar.zzaV()));
                        if (editorEdit.commit()) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                }
                HashSet hashSet = new HashSet();
                zzays zzaysVarZzb2 = zzb(1);
                if (zzaysVarZzb2 != null) {
                    hashSet.add(zzaysVarZzb2.zzk());
                }
                zzays zzaysVarZzb3 = zzb(2);
                if (zzaysVarZzb3 != null) {
                    hashSet.add(zzaysVarZzb3.zzk());
                }
                for (File file2 : zzd().listFiles()) {
                    String name = file2.getName();
                    if (!hashSet.contains(name)) {
                        zzfpw.zzd(zzfpw.zzc(name, zzd()));
                    }
                }
                return z;
            }
        }
        return false;
    }

    public final zzays zzb(int i) {
        String string = i == 1 ? this.zzc.getString(zzf(), null) : this.zzc.getString(zze(), null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            byte[] bArrStringToBytes = Hex.stringToBytes(string);
            zzays zzaysVarZzh = zzays.zzh(zzgxz.zzv(bArrStringToBytes, 0, bArrStringToBytes.length));
            String strZzk = zzaysVarZzh.zzk();
            File fileZzb = zzfpw.zzb(strZzk, "pcam.jar", zzd());
            if (!fileZzb.exists()) {
                fileZzb = zzfpw.zzb(strZzk, "pcam", zzd());
            }
            File fileZzb2 = zzfpw.zzb(strZzk, "pcbc", zzd());
            if (fileZzb.exists() && fileZzb2.exists()) {
                return zzaysVarZzh;
            }
            return null;
        } catch (zzgzw unused) {
        }
    }

    public final zzfpu zzc(int i) {
        zzays zzaysVarZzb = zzb(1);
        if (zzaysVarZzb == null) {
            return null;
        }
        String strZzk = zzaysVarZzb.zzk();
        File fileZzb = zzfpw.zzb(strZzk, "pcam.jar", zzd());
        if (!fileZzb.exists()) {
            fileZzb = zzfpw.zzb(strZzk, "pcam", zzd());
        }
        return new zzfpu(zzaysVarZzb, fileZzb, zzfpw.zzb(strZzk, "pcbc", zzd()), zzfpw.zzb(strZzk, "pcopt", zzd()));
    }
}
