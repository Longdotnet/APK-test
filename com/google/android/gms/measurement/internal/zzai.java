package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import java.util.EnumMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzai {
    public static final zzai zza = new zzai(null, null);
    public final EnumMap zzb;

    public zzai(Boolean bool, Boolean bool2) {
        EnumMap enumMap = new EnumMap(zzah.class);
        this.zzb = enumMap;
        enumMap.put(zzah.AD_STORAGE, bool);
        enumMap.put(zzah.ANALYTICS_STORAGE, bool2);
    }

    public static zzai zza(Bundle bundle) {
        if (bundle == null) {
            return zza;
        }
        EnumMap enumMap = new EnumMap(zzah.class);
        for (zzah zzahVar : zzah.values()) {
            String string = bundle.getString(zzahVar.zzd);
            Boolean bool = null;
            if (string != null) {
                if (string.equals("granted")) {
                    bool = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    bool = Boolean.FALSE;
                }
            }
            enumMap.put(zzahVar, bool);
        }
        return new zzai(enumMap);
    }

    public static zzai zzb(String str) {
        EnumMap enumMap = new EnumMap(zzah.class);
        if (str != null) {
            for (int i = 0; i < 2; i++) {
                zzah zzahVar = zzah.zzc[i];
                int i2 = i + 2;
                if (i2 < str.length()) {
                    char cCharAt = str.charAt(i2);
                    Boolean bool = null;
                    if (cCharAt != '-') {
                        if (cCharAt == '0') {
                            bool = Boolean.FALSE;
                        } else if (cCharAt == '1') {
                            bool = Boolean.TRUE;
                        }
                    }
                    enumMap.put(zzahVar, bool);
                }
            }
        }
        return new zzai(enumMap);
    }

    public final boolean equals(Object obj) {
        char c;
        if (!(obj instanceof zzai)) {
            return false;
        }
        zzai zzaiVar = (zzai) obj;
        zzah[] zzahVarArrValues = zzah.values();
        int length = zzahVarArrValues.length;
        int i = 0;
        while (true) {
            char c2 = 1;
            if (i >= length) {
                return true;
            }
            zzah zzahVar = zzahVarArrValues[i];
            Boolean bool = (Boolean) this.zzb.get(zzahVar);
            if (bool == null) {
                c = 0;
            } else {
                c = bool.booleanValue() ? (char) 1 : (char) 2;
            }
            Boolean bool2 = (Boolean) zzaiVar.zzb.get(zzahVar);
            if (bool2 == null) {
                c2 = 0;
            } else if (!bool2.booleanValue()) {
                c2 = 2;
            }
            if (c != c2) {
                return false;
            }
            i++;
        }
    }

    public final int hashCode() {
        int i = 17;
        for (Boolean bool : this.zzb.values()) {
            i = (i * 31) + (bool == null ? 0 : bool.booleanValue() ? 1 : 2);
        }
        return i;
    }

    public final zzai zzc(zzai zzaiVar) {
        EnumMap enumMap = new EnumMap(zzah.class);
        for (zzah zzahVar : zzah.values()) {
            Boolean boolValueOf = (Boolean) this.zzb.get(zzahVar);
            Boolean bool = (Boolean) zzaiVar.zzb.get(zzahVar);
            if (boolValueOf == null) {
                boolValueOf = bool;
            } else if (bool != null) {
                boolValueOf = Boolean.valueOf(boolValueOf.booleanValue() && bool.booleanValue());
            }
            enumMap.put(zzahVar, boolValueOf);
        }
        return new zzai(enumMap);
    }

    public final zzai zzd(zzai zzaiVar) {
        EnumMap enumMap = new EnumMap(zzah.class);
        for (zzah zzahVar : zzah.values()) {
            Boolean bool = (Boolean) this.zzb.get(zzahVar);
            if (bool == null) {
                bool = (Boolean) zzaiVar.zzb.get(zzahVar);
            }
            enumMap.put(zzahVar, bool);
        }
        return new zzai(enumMap);
    }

    public final String zzh() {
        StringBuilder sb = new StringBuilder("G1");
        zzah[] zzahVarArr = zzah.zzc;
        for (int i = 0; i < 2; i++) {
            Boolean bool = (Boolean) this.zzb.get(zzahVarArr[i]);
            sb.append(bool == null ? '-' : bool.booleanValue() ? '1' : '0');
        }
        return sb.toString();
    }

    public final boolean zzi(zzah zzahVar) {
        Boolean bool = (Boolean) this.zzb.get(zzahVar);
        return bool == null || bool.booleanValue();
    }

    public final boolean zzl(zzai zzaiVar, zzah... zzahVarArr) {
        for (zzah zzahVar : zzahVarArr) {
            Boolean bool = (Boolean) this.zzb.get(zzahVar);
            Boolean bool2 = (Boolean) zzaiVar.zzb.get(zzahVar);
            Boolean bool3 = Boolean.FALSE;
            if (bool == bool3 && bool2 != bool3) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("settings: ");
        zzah[] zzahVarArrValues = zzah.values();
        int length = zzahVarArrValues.length;
        for (int i = 0; i < length; i++) {
            zzah zzahVar = zzahVarArrValues[i];
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(zzahVar.name());
            sb.append("=");
            Boolean bool = (Boolean) this.zzb.get(zzahVar);
            if (bool == null) {
                sb.append("uninitialized");
            } else {
                sb.append(true != bool.booleanValue() ? "denied" : eoBKjVuj.ieNMgsN);
            }
        }
        return sb.toString();
    }

    public zzai(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(zzah.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
