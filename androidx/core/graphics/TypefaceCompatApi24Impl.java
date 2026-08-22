package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes.dex */
public final class TypefaceCompatApi24Impl extends ExceptionsKt {
    public static final Method sAddFontWeightStyle;
    public static final Method sCreateFromFamiliesWithDefault;
    public static final Class sFontFamily;
    public static final Constructor sFontFamilyCtor;

    static {
        Method method;
        Class<?> cls;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            method = null;
            cls = null;
            method2 = null;
        }
        sFontFamilyCtor = constructor;
        sFontFamily = cls;
        sAddFontWeightStyle = method2;
        sCreateFromFamiliesWithDefault = method;
    }

    public static boolean addFontWeightStyle(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) sAddFontWeightStyle.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface createFromFamiliesWithDefault$1(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) sFontFamily, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x005c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069 A[LOOP:0: B:9:0x0014->B:37:0x0069, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x005b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0068 A[SYNTHETIC] */
    @Override // kotlin.ExceptionsKt
    public final Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat$FontFamilyFilesResourceEntry fontResourcesParserCompat$FontFamilyFilesResourceEntry, Resources resources, int i) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        MappedByteBuffer map;
        try {
            objNewInstance = sFontFamilyCtor.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance == null) {
            return null;
        }
        for (FontResourcesParserCompat$FontFileResourceEntry fontResourcesParserCompat$FontFileResourceEntry : fontResourcesParserCompat$FontFamilyFilesResourceEntry.mEntries) {
            int i2 = fontResourcesParserCompat$FontFileResourceEntry.mResourceId;
            File tempFile = StringsKt__IndentKt.getTempFile(context);
            if (tempFile != null) {
                try {
                    if (StringsKt__IndentKt.copyToFile(tempFile, resources, i2)) {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(tempFile);
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                                fileInputStream.close();
                            } catch (Throwable th) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (IOException unused2) {
                            map = null;
                        }
                        tempFile.delete();
                    } else {
                        tempFile.delete();
                    }
                    if (map == null) {
                        return null;
                    }
                    if (!addFontWeightStyle(objNewInstance, map, fontResourcesParserCompat$FontFileResourceEntry.mTtcIndex, fontResourcesParserCompat$FontFileResourceEntry.mWeight, fontResourcesParserCompat$FontFileResourceEntry.mItalic)) {
                        return null;
                    }
                } catch (Throwable th3) {
                    tempFile.delete();
                    throw th3;
                }
            }
            map = null;
            if (map == null) {
                return null;
            }
            if (!addFontWeightStyle(objNewInstance, map, fontResourcesParserCompat$FontFileResourceEntry.mTtcIndex, fontResourcesParserCompat$FontFileResourceEntry.mWeight, fontResourcesParserCompat$FontFileResourceEntry.mItalic)) {
                return null;
            }
        }
        return createFromFamiliesWithDefault$1(objNewInstance);
    }

    @Override // kotlin.ExceptionsKt
    public final Typeface createFromFontInfo(Context context, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr, int i) {
        Object objNewInstance;
        try {
            objNewInstance = sFontFamilyCtor.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance == null) {
            return null;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        for (FontsContractCompat$FontInfo fontsContractCompat$FontInfo : fontsContractCompat$FontInfoArr) {
            Uri uri = fontsContractCompat$FontInfo.mUri;
            ByteBuffer byteBufferMmap = (ByteBuffer) simpleArrayMap.getOrDefault(uri, null);
            if (byteBufferMmap == null) {
                byteBufferMmap = StringsKt__IndentKt.mmap(context, uri);
                simpleArrayMap.put(uri, byteBufferMmap);
            }
            if (byteBufferMmap == null) {
                return null;
            }
            if (!addFontWeightStyle(objNewInstance, byteBufferMmap, fontsContractCompat$FontInfo.mTtcIndex, fontsContractCompat$FontInfo.mWeight, fontsContractCompat$FontInfo.mItalic)) {
                return null;
            }
        }
        Typeface typefaceCreateFromFamiliesWithDefault$1 = createFromFamiliesWithDefault$1(objNewInstance);
        if (typefaceCreateFromFamiliesWithDefault$1 == null) {
            return null;
        }
        return Typeface.create(typefaceCreateFromFamiliesWithDefault$1, i);
    }
}
