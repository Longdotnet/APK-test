package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import androidx.loader.app.gv.DYYbQc;

/* JADX INFO: loaded from: classes2.dex */
public final class zzeh extends zzgl {
    public char zza;
    public long zzb;
    public String zzc;
    public final zzef zzd;
    public final zzef zze;
    public final zzef zzf;
    public final zzef zzg;
    public final zzef zzh;
    public final zzef zzi;
    public final zzef zzj;
    public final zzef zzk;
    public final zzef zzl;

    public zzeh(zzfr zzfrVar) {
        super(zzfrVar);
        this.zza = (char) 0;
        this.zzb = -1L;
        this.zzd = new zzef(this, 6, false, false);
        this.zze = new zzef(this, 6, true, false);
        this.zzf = new zzef(this, 6, false, true);
        this.zzg = new zzef(this, 5, false, false);
        this.zzh = new zzef(this, 5, true, false);
        this.zzi = new zzef(this, 5, false, true);
        this.zzj = new zzef(this, 4, false, false);
        this.zzk = new zzef(this, 3, false, false);
        this.zzl = new zzef(this, 2, false, false);
    }

    public static zzeg zzn(String str) {
        if (str == null) {
            return null;
        }
        return new zzeg(str);
    }

    public static String zzp(Object obj, boolean z) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z) {
                return obj.toString();
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return obj.toString();
            }
            String str = obj.toString().charAt(0) == '-' ? "-" : "";
            String strValueOf = String.valueOf(Math.abs(l.longValue()));
            return str + Math.round(Math.pow(10.0d, strValueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof zzeg) {
                return ((zzeg) obj).zza;
            }
            return z ? "-" : obj.toString();
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb = new StringBuilder(z ? th.getClass().getName() : th.toString());
        String canonicalName = zzfr.class.getCanonicalName();
        if (TextUtils.isEmpty(canonicalName)) {
            canonicalName = "";
        } else {
            int iLastIndexOf = canonicalName.lastIndexOf(46);
            if (iLastIndexOf != -1) {
                canonicalName = canonicalName.substring(0, iLastIndexOf);
            }
        }
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                if (TextUtils.isEmpty(className)) {
                    className = "";
                } else {
                    int iLastIndexOf2 = className.lastIndexOf(46);
                    if (iLastIndexOf2 != -1) {
                        className = className.substring(0, iLastIndexOf2);
                    }
                }
                if (className.equals(canonicalName)) {
                    sb.append(": ");
                    sb.append(stackTraceElement);
                    break;
                }
            }
        }
        return sb.toString();
    }

    public final zzef zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final boolean zzf() {
        return false;
    }

    public final zzef zzj() {
        return this.zzl;
    }

    public final zzef zzk() {
        return this.zzg;
    }

    public final String zzq() {
        String str;
        synchronized (this) {
            try {
                if (this.zzc == null) {
                    zzfr zzfrVar = (zzfr) this.mBuilder;
                    String str2 = zzfrVar.zzh;
                    if (str2 != null) {
                        this.zzc = str2;
                    } else {
                        ((zzfr) zzfrVar.zzk.mBuilder).getClass();
                        this.zzc = "FA";
                    }
                }
                com.google.android.gms.common.internal.zzah.checkNotNull(this.zzc);
                str = this.zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final void zzt(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(zzq(), i)) {
            Log.println(i, zzq(), zzo(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        com.google.android.gms.common.internal.zzah.checkNotNull(str);
        zzfo zzfoVar = ((zzfr) this.mBuilder).zzn;
        if (zzfoVar == null) {
            Log.println(6, zzq(), "Scheduler not set. Not logging error/warn");
        } else {
            if (!zzfoVar.zza) {
                Log.println(6, zzq(), "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i >= 9) {
                i = 8;
            }
            zzfoVar.zzp(new zzee(this, i, str, obj, obj2, obj3));
        }
    }

    public static String zzo(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strZzp = zzp(obj, z);
        String strZzp2 = zzp(obj2, z);
        String strZzp3 = zzp(obj3, z);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = DYYbQc.QrUjkmNyG;
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strZzp)) {
            sb.append(str2);
            sb.append(strZzp);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strZzp2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strZzp2);
        }
        if (!TextUtils.isEmpty(strZzp3)) {
            sb.append(str3);
            sb.append(strZzp3);
        }
        return sb.toString();
    }
}
