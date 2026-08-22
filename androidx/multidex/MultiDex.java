package androidx.multidex;

import android.os.Build;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.RunnerApplication;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MultiDex {
    public static final boolean IS_VM_MULTIDEX_CAPABLE;
    public static final HashSet installedApk = new HashSet();

    static {
        String property = System.getProperty("java.vm.version");
        boolean z = false;
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ".");
            String strNextToken = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            if (strNextToken != null && strNextToken2 != null) {
                try {
                    int i = Integer.parseInt(strNextToken);
                    int i2 = Integer.parseInt(strNextToken2);
                    if (i > 2 || (i == 2 && i2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb = new StringBuilder("VM with version ");
        sb.append(property);
        sb.append(z ? " has multidex support" : " does not have multidex support");
        Log.i("MultiDex", sb.toString());
        IS_VM_MULTIDEX_CAPABLE = z;
    }

    public static void clearOldDexDir(RunnerApplication runnerApplication) {
        File file = new File(runnerApplication.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            Log.i("MultiDex", "Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : fileArrListFiles) {
                Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (file2.delete()) {
                    Log.i("MultiDex", "Deleted old file " + file2.getPath());
                } else {
                    Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
                }
            }
            if (file.delete()) {
                Log.i("MultiDex", "Deleted old secondary dex dir " + file.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete secondary dex dir " + file.getPath());
            }
        }
    }

    public static Field findField(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("Field ", str, " not found in ");
        sbM21m.append(obj.getClass());
        throw new NoSuchFieldException(sbM21m.toString());
    }

    public static void installSecondaryDexes(BaseDexClassLoader baseDexClassLoader, File file, ArrayList arrayList) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, IOException {
        Method declaredMethod;
        IOException[] iOExceptionArr;
        if (arrayList.isEmpty()) {
            return;
        }
        Object obj = findField(baseDexClassLoader, "pathList").get(baseDexClassLoader);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(arrayList);
        Class<?>[] clsArr = {ArrayList.class, File.class, ArrayList.class};
        Class<?> superclass = obj.getClass();
        while (true) {
            if (superclass == null) {
                throw new NoSuchMethodException("Method makeDexElements with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
            }
            try {
                declaredMethod = superclass.getDeclaredMethod("makeDexElements", clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                    break;
                }
                break;
            } catch (NoSuchMethodException unused) {
                superclass = superclass.getSuperclass();
            }
        }
        Object[] objArr = (Object[]) declaredMethod.invoke(obj, arrayList3, file, arrayList2);
        Field fieldFindField = findField(obj, "dexElements");
        Object[] objArr2 = (Object[]) fieldFindField.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        fieldFindField.set(obj, objArr3);
        if (arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
            }
            Field fieldFindField2 = findField(obj, "dexElementsSuppressedExceptions");
            IOException[] iOExceptionArr2 = (IOException[]) fieldFindField2.get(obj);
            if (iOExceptionArr2 == null) {
                iOExceptionArr = (IOException[]) arrayList2.toArray(new IOException[arrayList2.size()]);
            } else {
                IOException[] iOExceptionArr3 = new IOException[arrayList2.size() + iOExceptionArr2.length];
                arrayList2.toArray(iOExceptionArr3);
                System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList2.size(), iOExceptionArr2.length);
                iOExceptionArr = iOExceptionArr3;
            }
            fieldFindField2.set(obj, iOExceptionArr);
            IOException iOException = new IOException("I/O exception during makeDexElement");
            iOException.initCause((Throwable) arrayList2.get(0));
            throw iOException;
        }
    }

    public static void doInstallation(RunnerApplication runnerApplication, File file, File file2) {
        ClassLoader classLoader;
        HashSet hashSet = installedApk;
        synchronized (hashSet) {
            try {
                if (hashSet.contains(file)) {
                    return;
                }
                hashSet.add(file);
                Log.w("MultiDex", "MultiDex is not guaranteed to work in SDK version " + Build.VERSION.SDK_INT + ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"" + System.getProperty(JrbhsraGtto.VtqorQXqdmoO) + "\"");
                IOException e = null;
                try {
                    classLoader = runnerApplication.getClassLoader();
                    if (!(classLoader instanceof BaseDexClassLoader)) {
                        Log.e("MultiDex", "Context class loader is null or not dex-capable. Must be running in test mode. Skip patching.");
                        classLoader = null;
                    }
                } catch (RuntimeException e2) {
                    Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e2);
                }
                if (classLoader == null) {
                    return;
                }
                try {
                    clearOldDexDir(runnerApplication);
                } catch (Throwable th) {
                    Log.w(PZmDzEagKNdW.caxtmLOLkSnlklG, "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", th);
                }
                File file3 = new File(file2, "code_cache");
                try {
                    mkdirChecked(file3);
                } catch (IOException unused) {
                    file3 = new File(runnerApplication.getFilesDir(), "code_cache");
                    mkdirChecked(file3);
                }
                File file4 = new File(file3, "secondary-dexes");
                mkdirChecked(file4);
                MultiDexExtractor multiDexExtractor = new MultiDexExtractor(file, file4);
                try {
                    try {
                        installSecondaryDexes((BaseDexClassLoader) classLoader, file4, multiDexExtractor.load(runnerApplication, false));
                    } catch (IOException e3) {
                        Log.w("MultiDex", "Failed to install extracted secondary dex files, retrying with forced extraction", e3);
                        installSecondaryDexes((BaseDexClassLoader) classLoader, file4, multiDexExtractor.load(runnerApplication, true));
                    }
                    try {
                        multiDexExtractor.close();
                    } catch (IOException e4) {
                        e = e4;
                    }
                    if (e != null) {
                        throw e;
                    }
                } catch (Throwable th2) {
                    try {
                        multiDexExtractor.close();
                    } catch (IOException unused2) {
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public static void mkdirChecked(File file) throws IOException {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            String str = MnHfHMYQDPUO.ggehtyaFp;
            if (parentFile == null) {
                Log.e("MultiDex", str + file.getPath() + ". Parent file is null.");
            } else {
                Log.e("MultiDex", str + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
            }
            throw new IOException("Failed to create directory " + file.getPath());
        }
    }
}
