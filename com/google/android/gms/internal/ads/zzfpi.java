package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.auth.IJ.gZrKCJ;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfpi {
    public static boolean zza(int i) {
        int i2 = i - 1;
        return i2 == 2 || i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:60:0x00de  */
    /* JADX WARN: Code duplicated, block: B:77:0x0116 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x0118 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x011a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x011c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x011e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x0120  */
    /* JADX WARN: Code duplicated, block: B:83:0x0123  */
    /* JADX WARN: Code duplicated, block: B:84:0x0126  */
    /* JADX WARN: Code duplicated, block: B:85:0x0129  */
    /* JADX WARN: Code duplicated, block: B:86:0x012c  */
    /* JADX WARN: Code duplicated, block: B:87:0x012f  */
    /* JADX WARN: Code duplicated, block: B:88:0x0132  */
    public static final int zzb(Context context, zzfoi zzfoiVar) {
        int i;
        String str;
        String strZzc;
        File file = new File(new File(context.getApplicationInfo().dataDir), "lib");
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles(new zzgbh(Pattern.compile(".*\\.so$", 2)));
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                zzfoiVar.zzb(5017, "No .so");
            } else {
                try {
                    FileInputStream fileInputStream = new FileInputStream(fileArrListFiles[0]);
                    try {
                        byte[] bArr = new byte[20];
                        if (fileInputStream.read(bArr) == 20) {
                            byte[] bArr2 = {0, 0};
                            if (bArr[5] == 2) {
                                zzd(bArr, null, context, zzfoiVar);
                            } else {
                                bArr2[0] = bArr[19];
                                bArr2[1] = bArr[18];
                                short s = ByteBuffer.wrap(bArr2).getShort();
                                if (s == 3) {
                                    i = 5;
                                } else if (s == 40) {
                                    i = 3;
                                } else if (s == 62) {
                                    i = 7;
                                } else if (s == 183) {
                                    i = 6;
                                } else if (s != 243) {
                                    zzd(bArr, null, context, zzfoiVar);
                                    i = 1;
                                } else {
                                    i = 8;
                                }
                                fileInputStream.close();
                            }
                        }
                        fileInputStream.close();
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    zzd(null, e.toString(), context, zzfoiVar);
                }
                i = 1;
            }
            if (i == 1000) {
                strZzc = zzc(context, zzfoiVar);
                if (TextUtils.isEmpty(strZzc)) {
                    zzd(null, "Empty dev arch", context, zzfoiVar);
                } else if (!strZzc.equalsIgnoreCase("i686") || strZzc.equalsIgnoreCase("x86")) {
                    i = 5;
                } else if (strZzc.equalsIgnoreCase("x86_64")) {
                    i = 7;
                } else if (strZzc.equalsIgnoreCase("arm64-v8a")) {
                    i = 6;
                } else if (strZzc.equalsIgnoreCase("armeabi-v7a") || strZzc.equalsIgnoreCase("armv71")) {
                    i = 3;
                } else if (strZzc.equalsIgnoreCase("riscv64")) {
                    i = 8;
                } else {
                    zzd(null, strZzc, context, zzfoiVar);
                }
                i = 1;
            }
            if (i != 1) {
                str = "UNSUPPORTED";
            } else if (i != 3) {
                str = "ARM7";
            } else if (i != 5) {
                str = "X86";
            } else if (i != 6) {
                str = "ARM64";
            } else if (i != 7) {
                str = "X86_64";
            } else if (i != 8) {
                str = "null";
            } else {
                str = "RISCV64";
            }
            zzfoiVar.zzb(5018, str);
            return i;
        }
        zzfoiVar.zzb(5017, "No lib/");
        i = 1000;
        if (i == 1000) {
            strZzc = zzc(context, zzfoiVar);
            if (TextUtils.isEmpty(strZzc)) {
                zzd(null, "Empty dev arch", context, zzfoiVar);
            } else if (strZzc.equalsIgnoreCase("i686")) {
                i = 5;
            } else {
                i = 5;
            }
            i = 1;
        }
        if (i != 1) {
            str = "UNSUPPORTED";
        } else if (i != 3) {
            str = "ARM7";
        } else if (i != 5) {
            str = "X86";
        } else if (i != 6) {
            str = "ARM64";
        } else if (i != 7) {
            str = "X86_64";
        } else if (i != 8) {
            str = "null";
        } else {
            str = "RISCV64";
        }
        zzfoiVar.zzb(5018, str);
        return i;
    }

    private static final String zzc(Context context, zzfoi zzfoiVar) {
        HashSet hashSet = new HashSet(Arrays.asList("i686", "armv71"));
        String strZza = zzfwf.OS_ARCH.zza();
        if (!TextUtils.isEmpty(strZza) && hashSet.contains(strZza)) {
            return strZza;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (IllegalAccessException e) {
            zzfoiVar.zzc(2024, 0L, e);
        } catch (NoSuchFieldException e2) {
            zzfoiVar.zzc(2024, 0L, e2);
        }
        String str = Build.CPU_ABI;
        return str != null ? str : Build.CPU_ABI2;
    }

    private static final void zzd(byte[] bArr, String str, Context context, zzfoi zzfoiVar) {
        StringBuilder sb = new StringBuilder("os.arch:");
        sb.append(zzfwf.OS_ARCH.zza());
        sb.append(";");
        try {
            String[] strArr = (String[]) Build.class.getField(gZrKCJ.etgzihjm).get(null);
            if (strArr != null) {
                sb.append("supported_abis:");
                sb.append(Arrays.toString(strArr));
                sb.append(";");
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        sb.append("CPU_ABI:");
        sb.append(Build.CPU_ABI);
        sb.append(";CPU_ABI2:");
        sb.append(Build.CPU_ABI2);
        sb.append(";");
        if (bArr != null) {
            sb.append("ELF:");
            sb.append(Arrays.toString(bArr));
            sb.append(";");
        }
        if (str != null) {
            sb.append("dbg:");
            sb.append(str);
            sb.append(";");
        }
        zzfoiVar.zzb(4007, sb.toString());
    }
}
