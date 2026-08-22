package com.google.android.gms.internal.measurement;

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

/* JADX INFO: loaded from: classes.dex */
final class zzlo {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String zza(zzlm zzlmVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzlmVar, sb, 0);
        return sb.toString();
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
            sb.append(zzmm.zza(zzje.zzm((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzje) {
            sb.append(": \"");
            sb.append(zzmm.zza((zzje) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzkf) {
            sb.append(" {");
            zzd((zzkf) obj, sb, i + 2);
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
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i3 = i + 2;
        zzb(sb, i3, "key", entry.getKey());
        zzb(sb, i3, FirebaseAnalytics.Param.VALUE, entry.getValue());
        sb.append("\n");
        zzc(i, sb);
        sb.append("}");
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
    private static void zzd(zzlm zzlmVar, StringBuilder sb, int i) {
        int i2;
        boolean zEquals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzlmVar.getClass().getDeclaredMethods();
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
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 4), zzkf.zzbH(method2, zzlmVar, new Object[0]));
            } else if (strSubstring.endsWith("Map") && !strSubstring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 3), zzkf.zzbH(method, zzlmVar, new Object[0]));
            } else if (hashSet.contains("set".concat(strSubstring)) && (!strSubstring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) map.get("has".concat(strSubstring));
                if (method4 != null) {
                    Object objZzbH = zzkf.zzbH(method4, zzlmVar, new Object[0]);
                    if (method5 == null) {
                        if (objZzbH instanceof Boolean) {
                            if (((Boolean) objZzbH).booleanValue()) {
                                zzb(sb, i, strSubstring, objZzbH);
                            }
                        } else if (objZzbH instanceof Integer) {
                            if (((Integer) objZzbH).intValue() != 0) {
                                zzb(sb, i, strSubstring, objZzbH);
                            }
                        } else if (objZzbH instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objZzbH).floatValue()) != 0) {
                                zzb(sb, i, strSubstring, objZzbH);
                            }
                        } else if (!(objZzbH instanceof Double)) {
                            if (objZzbH instanceof String) {
                                zEquals = objZzbH.equals("");
                            } else if (objZzbH instanceof zzje) {
                                zEquals = objZzbH.equals(zzje.zzb);
                            } else if (objZzbH instanceof zzlm) {
                                if (objZzbH != ((zzlm) objZzbH).zzbS()) {
                                    zzb(sb, i, strSubstring, objZzbH);
                                }
                            } else if (!(objZzbH instanceof Enum) || ((Enum) objZzbH).ordinal() != 0) {
                                zzb(sb, i, strSubstring, objZzbH);
                            }
                            if (!zEquals) {
                                zzb(sb, i, strSubstring, objZzbH);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objZzbH).doubleValue()) != 0) {
                            zzb(sb, i, strSubstring, objZzbH);
                        }
                    } else if (((Boolean) zzkf.zzbH(method5, zzlmVar, new Object[0])).booleanValue()) {
                        zzb(sb, i, strSubstring, objZzbH);
                    }
                }
            }
            i2 = 3;
        }
        if (zzlmVar instanceof zzkc) {
            throw null;
        }
        zzmp zzmpVar = ((zzkf) zzlmVar).zzc;
        if (zzmpVar != null) {
            zzmpVar.zzi(sb, i);
        }
    }
}
