package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
final class zzhau {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String zza(zzhas zzhasVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzhasVar, sb, 0);
        return sb.toString();
    }

    private static void zzc(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01fa  */
    private static void zzd(zzhas zzhasVar, StringBuilder sb, int i) {
        int i2;
        boolean zEquals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzhasVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            i2 = 3;
            if (i3 >= length) {
                break;
            }
            Method method3 = declaredMethods[i3];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        map.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i3++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String strSubstring = ((String) entry.getKey()).substring(i2);
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 4), zzgzh.zzbP(method2, zzhasVar, new Object[0]));
            } else if (strSubstring.endsWith("Map") && !strSubstring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 3), zzgzh.zzbP(method, zzhasVar, new Object[0]));
            } else if (hashSet.contains("set".concat(strSubstring)) && (!strSubstring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) map.get("has".concat(strSubstring));
                if (method4 != null) {
                    Object objZzbP = zzgzh.zzbP(method4, zzhasVar, new Object[0]);
                    if (method5 == null) {
                        if (objZzbP instanceof Boolean) {
                            if (((Boolean) objZzbP).booleanValue()) {
                                zzb(sb, i, strSubstring, objZzbP);
                            }
                        } else if (objZzbP instanceof Integer) {
                            if (((Integer) objZzbP).intValue() != 0) {
                                zzb(sb, i, strSubstring, objZzbP);
                            }
                        } else if (objZzbP instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objZzbP).floatValue()) != 0) {
                                zzb(sb, i, strSubstring, objZzbP);
                            }
                        } else if (!(objZzbP instanceof Double)) {
                            if (objZzbP instanceof String) {
                                zEquals = objZzbP.equals("");
                            } else if (objZzbP instanceof zzgxz) {
                                zEquals = objZzbP.equals(zzgxz.zzb);
                            } else if (objZzbP instanceof zzhas) {
                                if (objZzbP != ((zzhas) objZzbP).zzbt()) {
                                    zzb(sb, i, strSubstring, objZzbP);
                                }
                            } else if (!(objZzbP instanceof Enum) || ((Enum) objZzbP).ordinal() != 0) {
                                zzb(sb, i, strSubstring, objZzbP);
                            }
                            if (!zEquals) {
                                zzb(sb, i, strSubstring, objZzbP);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objZzbP).doubleValue()) != 0) {
                            zzb(sb, i, strSubstring, objZzbP);
                        }
                    } else if (((Boolean) zzgzh.zzbP(method5, zzhasVar, new Object[0])).booleanValue()) {
                        zzb(sb, i, strSubstring, objZzbP);
                    }
                }
            }
            i2 = 3;
        }
        if (zzhasVar instanceof zzgzd) {
            Iterator itZzf = ((zzgzd) zzhasVar).zza.zzf();
            while (itZzf.hasNext()) {
                Map.Entry entry2 = (Map.Entry) itZzf.next();
                zzb(sb, i, CoroutineAdapterKt$$ExternalSyntheticLambda0.m(((zzgze) entry2.getKey()).zza, "[", "]"), entry2.getValue());
            }
        }
        zzhby zzhbyVar = ((zzgzh) zzhasVar).zzt;
        if (zzhbyVar != null) {
            zzhbyVar.zzi(sb, i);
        }
    }

    public static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzc(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzhbv.zza(zzgxz.zzw((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzgxz) {
            sb.append(": \"");
            sb.append(zzhbv.zza((zzgxz) obj));
            sb.append('\"');
            return;
        }
        boolean z = obj instanceof zzgzh;
        String str2 = yzwzcWHcnH.cLKEVJuvx;
        if (z) {
            sb.append(str2);
            zzd((zzgzh) obj, sb, i + 2);
            sb.append("\n");
            zzc(i, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i3 = i + 2;
        sb.append(str2);
        Map.Entry entry = (Map.Entry) obj;
        zzb(sb, i3, "key", entry.getKey());
        zzb(sb, i3, FirebaseAnalytics.Param.VALUE, entry.getValue());
        sb.append("\n");
        zzc(i, sb);
        sb.append("}");
    }
}
