package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.InputMergerFactory$1;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.protobuf.DescriptorProtos;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Encoding {
    public static final InputMergerFactory$1 EMPTY_DIAGNOSTICS = new InputMergerFactory$1(15);
    public static final byte[] MAGIC_PROF = {112, 114, 111, 0};
    public static final byte[] MAGIC_PROFM = {112, 114, 109, 0};
    public static final byte[] V015_S = {48, 49, 53, 0};
    public static final byte[] V010_P = {48, 49, 48, 0};
    public static final byte[] V009_O_MR1 = {48, 48, 57, 0};
    public static final byte[] V005_O = {48, 48, 53, 0};
    public static final byte[] V001_N = {48, 48, 49, 0};
    public static final byte[] METADATA_V001_N = {48, 48, 49, 0};
    public static final byte[] METADATA_V002 = {48, 48, 50, 0};

    public static byte[] compress(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    deflaterOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            deflater.end();
            throw th3;
        }
    }

    public static byte[] createCompressibleBody(DexProfileData[] dexProfileDataArr, byte[] bArr) throws IOException {
        int length = 0;
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            length += ((((dexProfileData.numMethodIds * 2) + 7) & (-8)) / 8) + (dexProfileData.classSetSize * 2) + generateDexKey(dexProfileData.apkName, bArr, dexProfileData.dexName).getBytes(StandardCharsets.UTF_8).length + 16 + dexProfileData.hotMethodRegionSize;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        if (Arrays.equals(bArr, V009_O_MR1)) {
            for (DexProfileData dexProfileData2 : dexProfileDataArr) {
                writeLineHeader(byteArrayOutputStream, dexProfileData2, generateDexKey(dexProfileData2.apkName, bArr, dexProfileData2.dexName));
                writeMethodsWithInlineCaches(byteArrayOutputStream, dexProfileData2);
                int[] iArr = dexProfileData2.classes;
                int length2 = iArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length2) {
                    int i3 = iArr[i];
                    writeUInt16(byteArrayOutputStream, i3 - i2);
                    i++;
                    i2 = i3;
                }
                writeMethodBitmap(byteArrayOutputStream, dexProfileData2);
            }
        } else {
            for (DexProfileData dexProfileData3 : dexProfileDataArr) {
                writeLineHeader(byteArrayOutputStream, dexProfileData3, generateDexKey(dexProfileData3.apkName, bArr, dexProfileData3.dexName));
            }
            for (DexProfileData dexProfileData4 : dexProfileDataArr) {
                writeMethodsWithInlineCaches(byteArrayOutputStream, dexProfileData4);
                int[] iArr2 = dexProfileData4.classes;
                int length3 = iArr2.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length3) {
                    int i6 = iArr2[i4];
                    writeUInt16(byteArrayOutputStream, i6 - i5);
                    i4++;
                    i5 = i6;
                }
                writeMethodBitmap(byteArrayOutputStream, dexProfileData4);
            }
        }
        if (byteArrayOutputStream.size() == length) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + length);
    }

    public static boolean deleteFilesRecursively(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file2 : fileArrListFiles) {
            z = deleteFilesRecursively(file2) && z;
        }
        return z;
    }

    public static String generateDexKey(String str, byte[] bArr, String str2) {
        byte[] bArr2 = V001_N;
        boolean zEquals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = V005_O;
        Object obj = (zEquals || Arrays.equals(bArr, bArr3)) ? ":" : "!";
        if (str.length() <= 0) {
            if ("!".equals(obj)) {
                return str2.replace(":", "!");
            }
            return ":".equals(obj) ? str2.replace("!", ":") : str2;
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            if ("!".equals(obj)) {
                return str2.replace(":", "!");
            }
            return ":".equals(obj) ? str2.replace("!", ":") : str2;
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) ? ":" : "!", str2);
    }

    public static void noteProfileWrittenFor(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
        }
    }

    public static byte[] read(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 < 0) {
                throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Not enough bytes to read: "));
            }
            i2 += i3;
        }
        return bArr;
    }

    public static int[] readClasses(ByteArrayInputStream byteArrayInputStream, int i) {
        int[] iArr = new int[i];
        int uInt = 0;
        for (int i2 = 0; i2 < i; i2++) {
            uInt += (int) readUInt(byteArrayInputStream, 2);
            iArr[i2] = uInt;
        }
        return iArr;
    }

    public static byte[] readCompressed(FileInputStream fileInputStream, int i, int i2) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i2];
            byte[] bArr2 = new byte[2048];
            int i3 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i3 < i) {
                int i4 = fileInputStream.read(bArr2);
                if (i4 < 0) {
                    throw new IllegalStateException("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i + " bytes");
                }
                inflater.setInput(bArr2, 0, i4);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i2 - iInflate);
                    i3 += i4;
                } catch (DataFormatException e) {
                    throw new IllegalStateException(e.getMessage());
                }
            }
            if (i3 == i) {
                if (!inflater.finished()) {
                    throw new IllegalStateException("Inflater did not finish");
                }
                inflater.end();
                return bArr;
            }
            throw new IllegalStateException("Didn't read enough bytes during decompression. expected=" + i + " actual=" + i3);
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    public static DexProfileData[] readMeta(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, DexProfileData[] dexProfileDataArr) throws IOException {
        byte[] bArr3 = METADATA_V001_N;
        if (!Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(bArr, METADATA_V002)) {
                throw new IllegalStateException("Unsupported meta version");
            }
            int uInt = (int) readUInt(fileInputStream, 2);
            byte[] compressed = readCompressed(fileInputStream, (int) readUInt(fileInputStream, 4), (int) readUInt(fileInputStream, 4));
            if (fileInputStream.read() > 0) {
                throw new IllegalStateException("Content found after the end of file");
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressed);
            try {
                DexProfileData[] metadataV002Body = readMetadataV002Body(byteArrayInputStream, bArr2, uInt, dexProfileDataArr);
                byteArrayInputStream.close();
                return metadataV002Body;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (Arrays.equals(V015_S, bArr2)) {
            throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }
        if (!Arrays.equals(bArr, bArr3)) {
            throw new IllegalStateException("Unsupported meta version");
        }
        int uInt2 = (int) readUInt(fileInputStream, 1);
        byte[] compressed2 = readCompressed(fileInputStream, (int) readUInt(fileInputStream, 4), (int) readUInt(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(compressed2);
        try {
            DexProfileData[] metadataForNBody = readMetadataForNBody(byteArrayInputStream2, uInt2, dexProfileDataArr);
            byteArrayInputStream2.close();
            return metadataForNBody;
        } catch (Throwable th3) {
            try {
                byteArrayInputStream2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static DexProfileData[] readMetadataForNBody(ByteArrayInputStream byteArrayInputStream, int i, DexProfileData[] dexProfileDataArr) {
        if (byteArrayInputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i != dexProfileDataArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i];
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            int uInt = (int) readUInt(byteArrayInputStream, 2);
            iArr[i2] = (int) readUInt(byteArrayInputStream, 2);
            strArr[i2] = new String(read(byteArrayInputStream, uInt), StandardCharsets.UTF_8);
        }
        for (int i3 = 0; i3 < i; i3++) {
            DexProfileData dexProfileData = dexProfileDataArr[i3];
            if (!dexProfileData.dexName.equals(strArr[i3])) {
                throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
            }
            int i4 = iArr[i3];
            dexProfileData.classSetSize = i4;
            dexProfileData.classes = readClasses(byteArrayInputStream, i4);
        }
        return dexProfileDataArr;
    }

    public static DexProfileData[] readMetadataV002Body(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i, DexProfileData[] dexProfileDataArr) throws IOException {
        if (byteArrayInputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i != dexProfileDataArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        for (int i2 = 0; i2 < i; i2++) {
            readUInt(byteArrayInputStream, 2);
            String str = new String(read(byteArrayInputStream, (int) readUInt(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
            long uInt = readUInt(byteArrayInputStream, 4);
            int uInt2 = (int) readUInt(byteArrayInputStream, 2);
            DexProfileData dexProfileData = null;
            if (dexProfileDataArr.length > 0) {
                int iIndexOf = str.indexOf("!");
                if (iIndexOf < 0) {
                    iIndexOf = str.indexOf(":");
                }
                String strSubstring = iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
                for (int i3 = 0; i3 < dexProfileDataArr.length; i3++) {
                    if (dexProfileDataArr[i3].dexName.equals(strSubstring)) {
                        dexProfileData = dexProfileDataArr[i3];
                        break;
                    }
                }
            }
            if (dexProfileData == null) {
                throw new IllegalStateException("Missing profile key: ".concat(str));
            }
            dexProfileData.mTypeIdCount = uInt;
            int[] classes = readClasses(byteArrayInputStream, uInt2);
            if (Arrays.equals(bArr, V001_N)) {
                dexProfileData.classSetSize = uInt2;
                dexProfileData.classes = classes;
            }
        }
        return dexProfileDataArr;
    }

    public static DexProfileData[] readProfile(FileInputStream fileInputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, V010_P)) {
            throw new IllegalStateException("Unsupported version");
        }
        int uInt = (int) readUInt(fileInputStream, 1);
        byte[] compressed = readCompressed(fileInputStream, (int) readUInt(fileInputStream, 4), (int) readUInt(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressed);
        try {
            DexProfileData[] uncompressedBody = readUncompressedBody(byteArrayInputStream, str, uInt);
            byteArrayInputStream.close();
            return uncompressedBody;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long readUInt(InputStream inputStream, int i) throws IOException {
        byte[] bArr = read(inputStream, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += ((long) (bArr[i2] & 255)) << (i2 * 8);
        }
        return j;
    }

    public static DexProfileData[] readUncompressedBody(ByteArrayInputStream byteArrayInputStream, String str, int i) throws IOException {
        TreeMap treeMap;
        if (byteArrayInputStream.available() == 0) {
            return new DexProfileData[0];
        }
        DexProfileData[] dexProfileDataArr = new DexProfileData[i];
        for (int i2 = 0; i2 < i; i2++) {
            int uInt = (int) readUInt(byteArrayInputStream, 2);
            int uInt2 = (int) readUInt(byteArrayInputStream, 2);
            dexProfileDataArr[i2] = new DexProfileData(str, new String(read(byteArrayInputStream, uInt), StandardCharsets.UTF_8), readUInt(byteArrayInputStream, 4), uInt2, (int) readUInt(byteArrayInputStream, 4), (int) readUInt(byteArrayInputStream, 4), new int[uInt2], new TreeMap());
        }
        for (int i3 = 0; i3 < i; i3++) {
            DexProfileData dexProfileData = dexProfileDataArr[i3];
            int iAvailable = byteArrayInputStream.available() - dexProfileData.hotMethodRegionSize;
            int uInt3 = 0;
            while (true) {
                int iAvailable2 = byteArrayInputStream.available();
                treeMap = dexProfileData.methods;
                if (iAvailable2 <= iAvailable) {
                    break;
                }
                uInt3 += (int) readUInt(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(uInt3), 1);
                for (int uInt4 = (int) readUInt(byteArrayInputStream, 2); uInt4 > 0; uInt4--) {
                    readUInt(byteArrayInputStream, 2);
                    int uInt5 = (int) readUInt(byteArrayInputStream, 1);
                    if (uInt5 != 6 && uInt5 != 7) {
                        while (uInt5 > 0) {
                            readUInt(byteArrayInputStream, 1);
                            for (int uInt6 = (int) readUInt(byteArrayInputStream, 1); uInt6 > 0; uInt6--) {
                                readUInt(byteArrayInputStream, 2);
                            }
                            uInt5--;
                        }
                    }
                }
            }
            if (byteArrayInputStream.available() != iAvailable) {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
            dexProfileData.classes = readClasses(byteArrayInputStream, dexProfileData.classSetSize);
            int i4 = dexProfileData.numMethodIds;
            BitSet bitSetValueOf = BitSet.valueOf(read(byteArrayInputStream, (((i4 * 2) + 7) & (-8)) / 8));
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = bitSetValueOf.get(i5) ? 2 : 0;
                if (bitSetValueOf.get(i5 + i4)) {
                    i6 |= 4;
                }
                if (i6 != 0) {
                    Integer num = (Integer) treeMap.get(Integer.valueOf(i5));
                    if (num == null) {
                        num = 0;
                    }
                    treeMap.put(Integer.valueOf(i5), Integer.valueOf(i6 | num.intValue()));
                }
            }
        }
        return dexProfileDataArr;
    }

    public static boolean transcodeAndWriteBody(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        long j;
        ArrayList arrayList;
        int length;
        byte[] bArr2 = V015_S;
        int i = 0;
        if (!Arrays.equals(bArr, bArr2)) {
            byte[] bArr3 = V010_P;
            if (Arrays.equals(bArr, bArr3)) {
                byte[] bArrCreateCompressibleBody = createCompressibleBody(dexProfileDataArr, bArr3);
                writeUInt(byteArrayOutputStream, dexProfileDataArr.length, 1);
                writeUInt(byteArrayOutputStream, bArrCreateCompressibleBody.length, 4);
                byte[] bArrCompress = compress(bArrCreateCompressibleBody);
                writeUInt(byteArrayOutputStream, bArrCompress.length, 4);
                byteArrayOutputStream.write(bArrCompress);
                return true;
            }
            byte[] bArr4 = V005_O;
            if (Arrays.equals(bArr, bArr4)) {
                writeUInt(byteArrayOutputStream, dexProfileDataArr.length, 1);
                for (DexProfileData dexProfileData : dexProfileDataArr) {
                    int size = dexProfileData.methods.size() * 4;
                    String strGenerateDexKey = generateDexKey(dexProfileData.apkName, bArr4, dexProfileData.dexName);
                    Charset charset = StandardCharsets.UTF_8;
                    writeUInt16(byteArrayOutputStream, strGenerateDexKey.getBytes(charset).length);
                    writeUInt16(byteArrayOutputStream, dexProfileData.classes.length);
                    writeUInt(byteArrayOutputStream, size, 4);
                    writeUInt(byteArrayOutputStream, dexProfileData.dexChecksum, 4);
                    byteArrayOutputStream.write(strGenerateDexKey.getBytes(charset));
                    Iterator it = dexProfileData.methods.keySet().iterator();
                    while (it.hasNext()) {
                        writeUInt16(byteArrayOutputStream, ((Integer) it.next()).intValue());
                        writeUInt16(byteArrayOutputStream, 0);
                    }
                    for (int i2 : dexProfileData.classes) {
                        writeUInt16(byteArrayOutputStream, i2);
                    }
                }
                return true;
            }
            byte[] bArr5 = V009_O_MR1;
            if (Arrays.equals(bArr, bArr5)) {
                byte[] bArrCreateCompressibleBody2 = createCompressibleBody(dexProfileDataArr, bArr5);
                writeUInt(byteArrayOutputStream, dexProfileDataArr.length, 1);
                writeUInt(byteArrayOutputStream, bArrCreateCompressibleBody2.length, 4);
                byte[] bArrCompress2 = compress(bArrCreateCompressibleBody2);
                writeUInt(byteArrayOutputStream, bArrCompress2.length, 4);
                byteArrayOutputStream.write(bArrCompress2);
                return true;
            }
            byte[] bArr6 = V001_N;
            if (!Arrays.equals(bArr, bArr6)) {
                return false;
            }
            writeUInt16(byteArrayOutputStream, dexProfileDataArr.length);
            for (DexProfileData dexProfileData2 : dexProfileDataArr) {
                String strGenerateDexKey2 = generateDexKey(dexProfileData2.apkName, bArr6, dexProfileData2.dexName);
                Charset charset2 = StandardCharsets.UTF_8;
                writeUInt16(byteArrayOutputStream, strGenerateDexKey2.getBytes(charset2).length);
                TreeMap treeMap = dexProfileData2.methods;
                writeUInt16(byteArrayOutputStream, treeMap.size());
                writeUInt16(byteArrayOutputStream, dexProfileData2.classes.length);
                writeUInt(byteArrayOutputStream, dexProfileData2.dexChecksum, 4);
                byteArrayOutputStream.write(strGenerateDexKey2.getBytes(charset2));
                Iterator it2 = treeMap.keySet().iterator();
                while (it2.hasNext()) {
                    writeUInt16(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                }
                for (int i3 : dexProfileData2.classes) {
                    writeUInt16(byteArrayOutputStream, i3);
                }
            }
            return true;
        }
        ArrayList arrayList2 = new ArrayList(3);
        ArrayList arrayList3 = new ArrayList(3);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            writeUInt16(byteArrayOutputStream2, dexProfileDataArr.length);
            int i4 = 2;
            int i5 = 2;
            for (DexProfileData dexProfileData3 : dexProfileDataArr) {
                writeUInt(byteArrayOutputStream2, dexProfileData3.dexChecksum, 4);
                writeUInt(byteArrayOutputStream2, dexProfileData3.mTypeIdCount, 4);
                writeUInt(byteArrayOutputStream2, dexProfileData3.numMethodIds, 4);
                String strGenerateDexKey3 = generateDexKey(dexProfileData3.apkName, bArr2, dexProfileData3.dexName);
                Charset charset3 = StandardCharsets.UTF_8;
                int length2 = strGenerateDexKey3.getBytes(charset3).length;
                writeUInt16(byteArrayOutputStream2, length2);
                i5 = i5 + 14 + length2;
                byteArrayOutputStream2.write(strGenerateDexKey3.getBytes(charset3));
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            if (i5 != byteArray.length) {
                throw new IllegalStateException("Expected size " + i5 + ", does not match actual size " + byteArray.length);
            }
            WritableFileSection writableFileSection = new WritableFileSection(byteArray, 1, false);
            byteArrayOutputStream2.close();
            arrayList2.add(writableFileSection);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i6 = 0;
            int i7 = 0;
            while (i6 < dexProfileDataArr.length) {
                try {
                    DexProfileData dexProfileData4 = dexProfileDataArr[i6];
                    writeUInt16(byteArrayOutputStream3, i6);
                    writeUInt16(byteArrayOutputStream3, dexProfileData4.classSetSize);
                    i7 = i7 + 4 + (dexProfileData4.classSetSize * 2);
                    int[] iArr = dexProfileData4.classes;
                    int length3 = iArr.length;
                    int i8 = i;
                    while (i < length3) {
                        int i9 = iArr[i];
                        writeUInt16(byteArrayOutputStream3, i9 - i8);
                        i++;
                        i8 = i9;
                    }
                    i6++;
                    i = 0;
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream3.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
            if (i7 != byteArray2.length) {
                throw new IllegalStateException("Expected size " + i7 + ", does not match actual size " + byteArray2.length);
            }
            WritableFileSection writableFileSection2 = new WritableFileSection(byteArray2, 3, true);
            byteArrayOutputStream3.close();
            arrayList2.add(writableFileSection2);
            ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
            int i10 = 0;
            int i11 = 0;
            while (i10 < dexProfileDataArr.length) {
                try {
                    DexProfileData dexProfileData5 = dexProfileDataArr[i10];
                    Iterator it3 = dexProfileData5.methods.entrySet().iterator();
                    int iIntValue = 0;
                    while (it3.hasNext()) {
                        iIntValue |= ((Integer) ((Map.Entry) it3.next()).getValue()).intValue();
                    }
                    ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
                    try {
                        writeMethodBitmap(byteArrayOutputStream5, dexProfileData5);
                        byte[] byteArray3 = byteArrayOutputStream5.toByteArray();
                        byteArrayOutputStream5.close();
                        ByteArrayOutputStream byteArrayOutputStream6 = new ByteArrayOutputStream();
                        try {
                            writeMethodsWithInlineCaches(byteArrayOutputStream6, dexProfileData5);
                            byte[] byteArray4 = byteArrayOutputStream6.toByteArray();
                            byteArrayOutputStream6.close();
                            writeUInt16(byteArrayOutputStream4, i10);
                            int length4 = byteArray3.length + i4 + byteArray4.length;
                            int i12 = i11 + 6;
                            ArrayList arrayList4 = arrayList3;
                            writeUInt(byteArrayOutputStream4, length4, 4);
                            writeUInt16(byteArrayOutputStream4, iIntValue);
                            byteArrayOutputStream4.write(byteArray3);
                            byteArrayOutputStream4.write(byteArray4);
                            i11 = i12 + length4;
                            i10++;
                            arrayList3 = arrayList4;
                            i4 = 2;
                        } catch (Throwable th3) {
                            try {
                                byteArrayOutputStream6.close();
                                throw th3;
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                                throw th3;
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            byteArrayOutputStream5.close();
                            throw th5;
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                            throw th5;
                        }
                    }
                } catch (Throwable th7) {
                    try {
                        byteArrayOutputStream4.close();
                        throw th7;
                    } catch (Throwable th8) {
                        th7.addSuppressed(th8);
                        throw th7;
                    }
                }
            }
            ArrayList arrayList5 = arrayList3;
            byte[] byteArray5 = byteArrayOutputStream4.toByteArray();
            if (i11 != byteArray5.length) {
                throw new IllegalStateException("Expected size " + i11 + ", does not match actual size " + byteArray5.length);
            }
            WritableFileSection writableFileSection3 = new WritableFileSection(byteArray5, 4, true);
            byteArrayOutputStream4.close();
            arrayList2.add(writableFileSection3);
            long j2 = 4;
            long size2 = j2 + j2 + 4 + ((long) (arrayList2.size() * 16));
            writeUInt(byteArrayOutputStream, arrayList2.size(), 4);
            int i13 = 0;
            while (i13 < arrayList2.size()) {
                WritableFileSection writableFileSection4 = (WritableFileSection) arrayList2.get(i13);
                int i14 = writableFileSection4.mType;
                if (i14 == 1) {
                    j = 0;
                } else if (i14 == 2) {
                    j = 1;
                } else if (i14 == 3) {
                    j = 2;
                } else if (i14 == 4) {
                    j = 3;
                } else {
                    if (i14 != 5) {
                        throw null;
                    }
                    j = 4;
                }
                writeUInt(byteArrayOutputStream, j, 4);
                writeUInt(byteArrayOutputStream, size2, 4);
                byte[] bArr7 = writableFileSection4.mContents;
                if (writableFileSection4.mNeedsCompression) {
                    long length5 = bArr7.length;
                    byte[] bArrCompress3 = compress(bArr7);
                    arrayList = arrayList5;
                    arrayList.add(bArrCompress3);
                    writeUInt(byteArrayOutputStream, bArrCompress3.length, 4);
                    writeUInt(byteArrayOutputStream, length5, 4);
                    length = bArrCompress3.length;
                } else {
                    arrayList = arrayList5;
                    arrayList.add(bArr7);
                    writeUInt(byteArrayOutputStream, bArr7.length, 4);
                    writeUInt(byteArrayOutputStream, 0L, 4);
                    length = bArr7.length;
                }
                size2 += (long) length;
                i13++;
                arrayList5 = arrayList;
            }
            ArrayList arrayList6 = arrayList5;
            for (int i15 = 0; i15 < arrayList6.size(); i15++) {
                byteArrayOutputStream.write((byte[]) arrayList6.get(i15));
            }
            return true;
        } catch (Throwable th9) {
            try {
                byteArrayOutputStream2.close();
                throw th9;
            } catch (Throwable th10) {
                th9.addSuppressed(th10);
                throw th9;
            }
        }
    }

    public static void writeLineHeader(ByteArrayOutputStream byteArrayOutputStream, DexProfileData dexProfileData, String str) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        writeUInt16(byteArrayOutputStream, str.getBytes(charset).length);
        writeUInt16(byteArrayOutputStream, dexProfileData.classSetSize);
        writeUInt(byteArrayOutputStream, dexProfileData.hotMethodRegionSize, 4);
        writeUInt(byteArrayOutputStream, dexProfileData.dexChecksum, 4);
        writeUInt(byteArrayOutputStream, dexProfileData.numMethodIds, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void writeMethodBitmap(ByteArrayOutputStream byteArrayOutputStream, DexProfileData dexProfileData) throws IOException {
        byte[] bArr = new byte[(((dexProfileData.numMethodIds * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : dexProfileData.methods.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                int i = iIntValue / 8;
                bArr[i] = (byte) (bArr[i] | (1 << (iIntValue % 8)));
            }
            if ((iIntValue2 & 4) != 0) {
                int i2 = iIntValue + dexProfileData.numMethodIds;
                int i3 = i2 / 8;
                bArr[i3] = (byte) ((1 << (i2 % 8)) | bArr[i3]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void writeMethodsWithInlineCaches(ByteArrayOutputStream byteArrayOutputStream, DexProfileData dexProfileData) throws IOException {
        int i = 0;
        for (Map.Entry entry : dexProfileData.methods.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                writeUInt16(byteArrayOutputStream, iIntValue - i);
                writeUInt16(byteArrayOutputStream, 0);
                i = iIntValue;
            }
        }
    }

    public static void writeUInt(ByteArrayOutputStream byteArrayOutputStream, long j, int i) throws IOException {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((j >> (i2 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void writeUInt16(ByteArrayOutputStream byteArrayOutputStream, int i) throws IOException {
        writeUInt(byteArrayOutputStream, i, 2);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x018a A[Catch: all -> 0x01a0, TRY_LEAVE, TryCatch #1 {all -> 0x01a0, blocks: (B:100:0x017e, B:102:0x018a, B:113:0x01a3, B:114:0x01a8), top: B:237:0x017e }] */
    /* JADX WARN: Code duplicated, block: B:113:0x01a3 A[Catch: all -> 0x01a0, TRY_ENTER, TryCatch #1 {all -> 0x01a0, blocks: (B:100:0x017e, B:102:0x018a, B:113:0x01a3, B:114:0x01a8), top: B:237:0x017e }] */
    /* JADX WARN: Code duplicated, block: B:121:0x01b3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:122:0x01b5 A[Catch: IllegalStateException -> 0x0199, IOException -> 0x019b, FileNotFoundException -> 0x019e, TRY_LEAVE, TryCatch #29 {FileNotFoundException -> 0x019e, IOException -> 0x019b, IllegalStateException -> 0x0199, blocks: (B:98:0x0176, B:103:0x0194, B:122:0x01b5, B:120:0x01b2, B:119:0x01af), top: B:278:0x0176 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:133:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ef A[Catch: all -> 0x01fe, TRY_LEAVE, TryCatch #21 {all -> 0x01fe, blocks: (B:139:0x01e3, B:141:0x01ef, B:150:0x0201), top: B:258:0x01e3, outer: #33 }] */
    /* JADX WARN: Code duplicated, block: B:150:0x0201 A[Catch: all -> 0x01fe, TRY_ENTER, TRY_LEAVE, TryCatch #21 {all -> 0x01fe, blocks: (B:139:0x01e3, B:141:0x01ef, B:150:0x0201), top: B:258:0x01e3, outer: #33 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x021f  */
    /* JADX WARN: Code duplicated, block: B:166:0x0229  */
    /* JADX WARN: Code duplicated, block: B:167:0x022d  */
    /* JADX WARN: Code duplicated, block: B:175:0x0247 A[Catch: all -> 0x026a, TRY_LEAVE, TryCatch #9 {all -> 0x026a, blocks: (B:172:0x023f, B:173:0x0241, B:175:0x0247), top: B:240:0x023f }] */
    /* JADX WARN: Code duplicated, block: B:218:0x0299  */
    /* JADX WARN: Code duplicated, block: B:221:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:226:0x02af A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:228:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:237:0x017e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:272:0x0231 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:273:0x01de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:278:0x0176 A[EXC_TOP_SPLITTER, PHI: r6
  0x0176: PHI (r6v25 char) = (r6v33 char), (r6v34 char), (r6v29 char) binds: [B:93:0x016c, B:95:0x0170, B:96:0x0172] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:279:0x024c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:281:? A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:282:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x0160  */
    /* JADX WARN: Code duplicated, block: B:90:0x0166  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v43 */
    /* JADX WARN: Type inference failed for: r6v44 */
    /* JADX WARN: Type inference failed for: r6v45 */
    /* JADX WARN: Type inference failed for: r6v46 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static void writeProfile(Context context, Executor executor, ProfileInstaller$DiagnosticsCallback profileInstaller$DiagnosticsCallback, boolean z) throws Throwable {
        byte[] bArr;
        ?? OpenStreamFromAssets;
        IOException iOException;
        int i;
        DexProfileData[] profile;
        DexProfileData[] dexProfileDataArr;
        DeviceProfileWriter deviceProfileWriter;
        ProfileInstaller$DiagnosticsCallback profileInstaller$DiagnosticsCallback2;
        DexProfileData[] dexProfileDataArr2;
        ?? r6;
        byte[] bArr2;
        ?? r7;
        boolean z2;
        ByteArrayInputStream byteArrayInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        byte[] bArr3;
        int i2;
        byte[] bArr4;
        ByteArrayOutputStream byteArrayOutputStream;
        int i3;
        FileInputStream fileInputStreamOpenStreamFromAssets;
        boolean zEquals;
        ?? r11;
        boolean z3;
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            ?? r15 = 1;
            if (!z) {
                File file = new File(filesDir, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
                if (file.exists()) {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                        try {
                            long j = dataInputStream.readLong();
                            dataInputStream.close();
                            z3 = j == packageInfo.lastUpdateTime;
                            if (z3) {
                                profileInstaller$DiagnosticsCallback.onResultReceived(2, null);
                            }
                        } catch (Throwable th2) {
                            try {
                                dataInputStream.close();
                                throw th2;
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                                throw th2;
                            }
                        }
                    } catch (IOException unused) {
                        z3 = false;
                    }
                } else {
                    z3 = false;
                }
                if (z3) {
                    Log.d("ProfileInstaller", "Skipping profile installation for " + context.getPackageName());
                    ProfileVerifier.writeProfileVerification(context, false);
                    return;
                }
            }
            Log.d("ProfileInstaller", "Installing profile for " + context.getPackageName());
            int i4 = Build.VERSION.SDK_INT;
            File file2 = new File(new File("/data/misc/profiles/cur/0", packageName), MnHfHMYQDPUO.AMWQA);
            DeviceProfileWriter deviceProfileWriter2 = new DeviceProfileWriter(assets, executor, profileInstaller$DiagnosticsCallback, name, file2);
            byte[] bArr5 = deviceProfileWriter2.mDesiredVersion;
            if (bArr5 == null) {
                deviceProfileWriter2.result(3, Integer.valueOf(i4));
            } else {
                try {
                    try {
                        if (file2.exists()) {
                            if (!file2.canWrite()) {
                                deviceProfileWriter2.result(4, null);
                            }
                            if (z2 || !z) {
                                r11 = 0;
                            } else {
                                r11 = r15;
                            }
                            ProfileVerifier.writeProfileVerification(context, r11);
                        }
                        try {
                            file2.createNewFile();
                        } catch (IOException unused2) {
                            deviceProfileWriter2.result(4, null);
                            z2 = false;
                        }
                        if (OpenStreamFromAssets != 0) {
                            try {
                                if (!Arrays.equals(bArr, read(OpenStreamFromAssets, 4))) {
                                    throw new IllegalStateException("Invalid magic");
                                }
                                profile = readProfile(OpenStreamFromAssets, read(OpenStreamFromAssets, 4), deviceProfileWriter2.mApkName);
                                try {
                                    OpenStreamFromAssets.close();
                                    OpenStreamFromAssets = OpenStreamFromAssets;
                                } catch (IOException e) {
                                    IOException iOException2 = e;
                                    profileInstaller$DiagnosticsCallback.onResultReceived(7, iOException2);
                                    OpenStreamFromAssets = iOException2;
                                }
                                deviceProfileWriter2.mProfile = profile;
                            } catch (IOException e2) {
                                i = 7;
                                profileInstaller$DiagnosticsCallback.onResultReceived(7, e2);
                                try {
                                    OpenStreamFromAssets.close();
                                } catch (IOException e3) {
                                    iOException = e3;
                                    profileInstaller$DiagnosticsCallback.onResultReceived(i, iOException);
                                    profile = null;
                                    OpenStreamFromAssets = OpenStreamFromAssets;
                                    deviceProfileWriter2.mProfile = profile;
                                    dexProfileDataArr = deviceProfileWriter2.mProfile;
                                    if (dexProfileDataArr != null) {
                                        i3 = Build.VERSION.SDK_INT;
                                        OpenStreamFromAssets = 24;
                                        char c = 24;
                                        OpenStreamFromAssets = 24;
                                        if (i3 >= 24) {
                                            deviceProfileWriter = deviceProfileWriter2;
                                        } else {
                                            deviceProfileWriter = deviceProfileWriter2;
                                        }
                                    } else {
                                        deviceProfileWriter = deviceProfileWriter2;
                                    }
                                    profileInstaller$DiagnosticsCallback2 = deviceProfileWriter.mDiagnostics;
                                    dexProfileDataArr2 = deviceProfileWriter.mProfile;
                                    r6 = OpenStreamFromAssets;
                                    if (dexProfileDataArr2 != null) {
                                        if (!deviceProfileWriter.mDeviceSupportsAotProfile) {
                                            r6 = bArr4;
                                            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                        }
                                        try {
                                            r6 = bArr4;
                                            byteArrayOutputStream = new ByteArrayOutputStream();
                                            try {
                                                byteArrayOutputStream.write(bArr);
                                                byteArrayOutputStream.write(bArr4);
                                                if (transcodeAndWriteBody(byteArrayOutputStream, bArr4, dexProfileDataArr2)) {
                                                    deviceProfileWriter.mTranscodedProfile = byteArrayOutputStream.toByteArray();
                                                    byteArrayOutputStream.close();
                                                    deviceProfileWriter.mProfile = null;
                                                    r6 = bArr4;
                                                } else {
                                                    profileInstaller$DiagnosticsCallback2.onResultReceived(5, null);
                                                    deviceProfileWriter.mProfile = null;
                                                    byteArrayOutputStream.close();
                                                    r6 = bArr4;
                                                }
                                            } catch (Throwable th4) {
                                                try {
                                                    byteArrayOutputStream.close();
                                                    throw th4;
                                                } catch (Throwable th5) {
                                                    th4.addSuppressed(th5);
                                                    throw th4;
                                                }
                                            }
                                        } catch (IOException e4) {
                                            profileInstaller$DiagnosticsCallback2.onResultReceived(7, e4);
                                        } catch (IllegalStateException e5) {
                                            profileInstaller$DiagnosticsCallback2.onResultReceived(8, e5);
                                        }
                                    }
                                    r6 = bArr4;
                                    bArr2 = deviceProfileWriter.mTranscodedProfile;
                                    if (bArr2 == null) {
                                        z2 = false;
                                        r15 = 1;
                                    } else {
                                        try {
                                            if (!deviceProfileWriter.mDeviceSupportsAotProfile) {
                                                throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                            }
                                            try {
                                                try {
                                                    byteArrayInputStream = new ByteArrayInputStream(bArr2);
                                                    try {
                                                        fileOutputStream = new FileOutputStream(deviceProfileWriter.mCurProfile);
                                                        try {
                                                            try {
                                                                bArr3 = new byte[512];
                                                                while (true) {
                                                                    i2 = byteArrayInputStream.read(bArr3);
                                                                    if (i2 > 0) {
                                                                        fileOutputStream.write(bArr3, 0, i2);
                                                                    } else {
                                                                        r15 = 1;
                                                                        try {
                                                                            deviceProfileWriter.result(1, null);
                                                                            fileOutputStream.close();
                                                                            byteArrayInputStream.close();
                                                                            deviceProfileWriter.mTranscodedProfile = null;
                                                                            deviceProfileWriter.mProfile = null;
                                                                            z2 = true;
                                                                        } catch (Throwable th6) {
                                                                            th = th6;
                                                                        }
                                                                    }
                                                                    th = th;
                                                                    try {
                                                                        fileOutputStream.close();
                                                                        throw th;
                                                                    } catch (Throwable th7) {
                                                                        th.addSuppressed(th7);
                                                                        throw th;
                                                                    }
                                                                }
                                                            } catch (Throwable th8) {
                                                                th = th8;
                                                            }
                                                        } catch (Throwable th9) {
                                                            th = th9;
                                                            Throwable th10 = th;
                                                            try {
                                                                byteArrayInputStream.close();
                                                                throw th10;
                                                            } catch (Throwable th11) {
                                                                th10.addSuppressed(th11);
                                                                throw th10;
                                                            }
                                                        }
                                                    } catch (Throwable th12) {
                                                        th = th12;
                                                    }
                                                } catch (FileNotFoundException e6) {
                                                    e = e6;
                                                    r6 = 1;
                                                    deviceProfileWriter.result(6, e);
                                                    r7 = r6;
                                                    deviceProfileWriter.mTranscodedProfile = null;
                                                    deviceProfileWriter.mProfile = null;
                                                    z2 = false;
                                                    r15 = r7;
                                                } catch (IOException e7) {
                                                    e = e7;
                                                    r6 = 1;
                                                    deviceProfileWriter.result(7, e);
                                                    r7 = r6;
                                                    deviceProfileWriter.mTranscodedProfile = null;
                                                    deviceProfileWriter.mProfile = null;
                                                    z2 = false;
                                                    r15 = r7;
                                                }
                                            } catch (FileNotFoundException e8) {
                                                e = e8;
                                                deviceProfileWriter.result(6, e);
                                                r7 = r6;
                                                deviceProfileWriter.mTranscodedProfile = null;
                                                deviceProfileWriter.mProfile = null;
                                                z2 = false;
                                                r15 = r7;
                                            } catch (IOException e9) {
                                                e = e9;
                                                deviceProfileWriter.result(7, e);
                                                r7 = r6;
                                                deviceProfileWriter.mTranscodedProfile = null;
                                                deviceProfileWriter.mProfile = null;
                                                z2 = false;
                                                r15 = r7;
                                            }
                                        } catch (Throwable th13) {
                                            deviceProfileWriter.mTranscodedProfile = null;
                                            deviceProfileWriter.mProfile = null;
                                            throw th13;
                                        }
                                    }
                                    if (z2) {
                                        noteProfileWrittenFor(packageInfo, filesDir);
                                    }
                                    if (z2) {
                                        r11 = 0;
                                    } else {
                                        r11 = 0;
                                    }
                                    ProfileVerifier.writeProfileVerification(context, r11);
                                }
                                profile = null;
                                OpenStreamFromAssets = OpenStreamFromAssets;
                            } catch (IllegalStateException e10) {
                                try {
                                    profileInstaller$DiagnosticsCallback.onResultReceived(8, e10);
                                    try {
                                        OpenStreamFromAssets.close();
                                    } catch (IOException e11) {
                                        iOException = e11;
                                        i = 7;
                                        profileInstaller$DiagnosticsCallback.onResultReceived(i, iOException);
                                        profile = null;
                                        OpenStreamFromAssets = OpenStreamFromAssets;
                                        deviceProfileWriter2.mProfile = profile;
                                        dexProfileDataArr = deviceProfileWriter2.mProfile;
                                        if (dexProfileDataArr != null) {
                                            i3 = Build.VERSION.SDK_INT;
                                            OpenStreamFromAssets = 24;
                                            char c2 = 24;
                                            OpenStreamFromAssets = 24;
                                            if (i3 >= 24) {
                                                deviceProfileWriter = deviceProfileWriter2;
                                            } else {
                                                deviceProfileWriter = deviceProfileWriter2;
                                            }
                                        } else {
                                            deviceProfileWriter = deviceProfileWriter2;
                                        }
                                        profileInstaller$DiagnosticsCallback2 = deviceProfileWriter.mDiagnostics;
                                        dexProfileDataArr2 = deviceProfileWriter.mProfile;
                                        r6 = OpenStreamFromAssets;
                                        if (dexProfileDataArr2 != null) {
                                            if (!deviceProfileWriter.mDeviceSupportsAotProfile) {
                                                r6 = bArr4;
                                                throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                            }
                                            r6 = bArr4;
                                            byteArrayOutputStream = new ByteArrayOutputStream();
                                            byteArrayOutputStream.write(bArr);
                                            byteArrayOutputStream.write(bArr4);
                                            if (transcodeAndWriteBody(byteArrayOutputStream, bArr4, dexProfileDataArr2)) {
                                                profileInstaller$DiagnosticsCallback2.onResultReceived(5, null);
                                                deviceProfileWriter.mProfile = null;
                                                byteArrayOutputStream.close();
                                                r6 = bArr4;
                                            } else {
                                                deviceProfileWriter.mTranscodedProfile = byteArrayOutputStream.toByteArray();
                                                byteArrayOutputStream.close();
                                                deviceProfileWriter.mProfile = null;
                                                r6 = bArr4;
                                            }
                                        }
                                        r6 = bArr4;
                                        bArr2 = deviceProfileWriter.mTranscodedProfile;
                                        if (bArr2 == null) {
                                            if (!deviceProfileWriter.mDeviceSupportsAotProfile) {
                                                throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                            }
                                            byteArrayInputStream = new ByteArrayInputStream(bArr2);
                                            fileOutputStream = new FileOutputStream(deviceProfileWriter.mCurProfile);
                                            bArr3 = new byte[512];
                                            while (true) {
                                                i2 = byteArrayInputStream.read(bArr3);
                                                if (i2 > 0) {
                                                    fileOutputStream.write(bArr3, 0, i2);
                                                } else {
                                                    r15 = 1;
                                                    deviceProfileWriter.result(1, null);
                                                    fileOutputStream.close();
                                                    byteArrayInputStream.close();
                                                    deviceProfileWriter.mTranscodedProfile = null;
                                                    deviceProfileWriter.mProfile = null;
                                                    z2 = true;
                                                }
                                                th = th;
                                                fileOutputStream.close();
                                                throw th;
                                            }
                                        }
                                        z2 = false;
                                        r15 = 1;
                                        if (z2) {
                                            noteProfileWrittenFor(packageInfo, filesDir);
                                        }
                                        if (z2) {
                                            r11 = 0;
                                        } else {
                                            r11 = 0;
                                        }
                                        ProfileVerifier.writeProfileVerification(context, r11);
                                    }
                                    profile = null;
                                    OpenStreamFromAssets = OpenStreamFromAssets;
                                } catch (Throwable th14) {
                                    th = th14;
                                    Throwable th15 = th;
                                    try {
                                        OpenStreamFromAssets.close();
                                        throw th15;
                                    } catch (IOException e12) {
                                        profileInstaller$DiagnosticsCallback.onResultReceived(7, e12);
                                        throw th15;
                                    }
                                }
                            }
                        }
                        dexProfileDataArr = deviceProfileWriter2.mProfile;
                        if (dexProfileDataArr != null) {
                            i3 = Build.VERSION.SDK_INT;
                            OpenStreamFromAssets = 24;
                            char c3 = 24;
                            OpenStreamFromAssets = 24;
                            if (i3 >= 24 || i3 > 34) {
                                deviceProfileWriter = deviceProfileWriter2;
                            } else if (i3 != 24) {
                                c3 = 25;
                                OpenStreamFromAssets = 25;
                                c3 = 25;
                                if (i3 != 25) {
                                    switch (i3) {
                                        case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                                        case 32:
                                        case 33:
                                        case 34:
                                            try {
                                                fileInputStreamOpenStreamFromAssets = deviceProfileWriter2.openStreamFromAssets(assets, "dexopt/baseline.profm");
                                                if (fileInputStreamOpenStreamFromAssets != null) {
                                                    try {
                                                        zEquals = Arrays.equals(MAGIC_PROFM, read(fileInputStreamOpenStreamFromAssets, 4));
                                                        if (!zEquals) {
                                                            throw new IllegalStateException("Invalid magic");
                                                        }
                                                        deviceProfileWriter2.mProfile = readMeta(fileInputStreamOpenStreamFromAssets, read(fileInputStreamOpenStreamFromAssets, 4), bArr5, dexProfileDataArr);
                                                        fileInputStreamOpenStreamFromAssets.close();
                                                        deviceProfileWriter = deviceProfileWriter2;
                                                        OpenStreamFromAssets = zEquals;
                                                    } catch (Throwable th16) {
                                                        try {
                                                            fileInputStreamOpenStreamFromAssets.close();
                                                            throw th16;
                                                        } catch (Throwable th17) {
                                                            th16.addSuppressed(th17);
                                                            throw th16;
                                                        }
                                                    }
                                                } else {
                                                    if (fileInputStreamOpenStreamFromAssets != null) {
                                                        fileInputStreamOpenStreamFromAssets.close();
                                                    }
                                                    deviceProfileWriter = null;
                                                    OpenStreamFromAssets = c3;
                                                }
                                            } catch (FileNotFoundException e13) {
                                                profileInstaller$DiagnosticsCallback.onResultReceived(9, e13);
                                            } catch (IOException e14) {
                                                profileInstaller$DiagnosticsCallback.onResultReceived(7, e14);
                                            } catch (IllegalStateException e15) {
                                                deviceProfileWriter2.mProfile = null;
                                                profileInstaller$DiagnosticsCallback.onResultReceived(8, e15);
                                            }
                                            if (deviceProfileWriter == null) {
                                                deviceProfileWriter = deviceProfileWriter2;
                                            }
                                            break;
                                        default:
                                            deviceProfileWriter = deviceProfileWriter2;
                                            break;
                                    }
                                } else {
                                    fileInputStreamOpenStreamFromAssets = deviceProfileWriter2.openStreamFromAssets(assets, "dexopt/baseline.profm");
                                    if (fileInputStreamOpenStreamFromAssets != null) {
                                        zEquals = Arrays.equals(MAGIC_PROFM, read(fileInputStreamOpenStreamFromAssets, 4));
                                        if (!zEquals) {
                                            throw new IllegalStateException("Invalid magic");
                                        }
                                        deviceProfileWriter2.mProfile = readMeta(fileInputStreamOpenStreamFromAssets, read(fileInputStreamOpenStreamFromAssets, 4), bArr5, dexProfileDataArr);
                                        fileInputStreamOpenStreamFromAssets.close();
                                        deviceProfileWriter = deviceProfileWriter2;
                                        OpenStreamFromAssets = zEquals;
                                    } else {
                                        if (fileInputStreamOpenStreamFromAssets != null) {
                                            fileInputStreamOpenStreamFromAssets.close();
                                        }
                                        deviceProfileWriter = null;
                                        OpenStreamFromAssets = c3;
                                    }
                                    if (deviceProfileWriter == null) {
                                        deviceProfileWriter = deviceProfileWriter2;
                                    }
                                }
                            } else {
                                fileInputStreamOpenStreamFromAssets = deviceProfileWriter2.openStreamFromAssets(assets, "dexopt/baseline.profm");
                                if (fileInputStreamOpenStreamFromAssets != null) {
                                    zEquals = Arrays.equals(MAGIC_PROFM, read(fileInputStreamOpenStreamFromAssets, 4));
                                    if (!zEquals) {
                                        throw new IllegalStateException("Invalid magic");
                                    }
                                    deviceProfileWriter2.mProfile = readMeta(fileInputStreamOpenStreamFromAssets, read(fileInputStreamOpenStreamFromAssets, 4), bArr5, dexProfileDataArr);
                                    fileInputStreamOpenStreamFromAssets.close();
                                    deviceProfileWriter = deviceProfileWriter2;
                                    OpenStreamFromAssets = zEquals;
                                } else {
                                    if (fileInputStreamOpenStreamFromAssets != null) {
                                        fileInputStreamOpenStreamFromAssets.close();
                                    }
                                    deviceProfileWriter = null;
                                    OpenStreamFromAssets = c3;
                                }
                                if (deviceProfileWriter == null) {
                                    deviceProfileWriter = deviceProfileWriter2;
                                }
                            }
                        } else {
                            deviceProfileWriter = deviceProfileWriter2;
                        }
                        profileInstaller$DiagnosticsCallback2 = deviceProfileWriter.mDiagnostics;
                        dexProfileDataArr2 = deviceProfileWriter.mProfile;
                        r6 = OpenStreamFromAssets;
                        if (dexProfileDataArr2 != null && (bArr4 = deviceProfileWriter.mDesiredVersion) != null) {
                            if (!deviceProfileWriter.mDeviceSupportsAotProfile) {
                                r6 = bArr4;
                                throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                            }
                            r6 = bArr4;
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            byteArrayOutputStream.write(bArr);
                            byteArrayOutputStream.write(bArr4);
                            if (transcodeAndWriteBody(byteArrayOutputStream, bArr4, dexProfileDataArr2)) {
                                profileInstaller$DiagnosticsCallback2.onResultReceived(5, null);
                                deviceProfileWriter.mProfile = null;
                                byteArrayOutputStream.close();
                                r6 = bArr4;
                            } else {
                                deviceProfileWriter.mTranscodedProfile = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                deviceProfileWriter.mProfile = null;
                                r6 = bArr4;
                            }
                        }
                        r6 = bArr4;
                        bArr2 = deviceProfileWriter.mTranscodedProfile;
                        if (bArr2 == null) {
                            if (!deviceProfileWriter.mDeviceSupportsAotProfile) {
                                throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                            }
                            byteArrayInputStream = new ByteArrayInputStream(bArr2);
                            fileOutputStream = new FileOutputStream(deviceProfileWriter.mCurProfile);
                            bArr3 = new byte[512];
                            while (true) {
                                i2 = byteArrayInputStream.read(bArr3);
                                if (i2 > 0) {
                                    fileOutputStream.write(bArr3, 0, i2);
                                } else {
                                    r15 = 1;
                                    deviceProfileWriter.result(1, null);
                                    fileOutputStream.close();
                                    byteArrayInputStream.close();
                                    deviceProfileWriter.mTranscodedProfile = null;
                                    deviceProfileWriter.mProfile = null;
                                    z2 = true;
                                }
                                th = th;
                                fileOutputStream.close();
                                throw th;
                            }
                        }
                        z2 = false;
                        r15 = 1;
                        if (z2) {
                            noteProfileWrittenFor(packageInfo, filesDir);
                        }
                        if (z2) {
                            r11 = 0;
                        } else {
                            r11 = 0;
                        }
                        ProfileVerifier.writeProfileVerification(context, r11);
                    } catch (Throwable th18) {
                        th = th18;
                    }
                    OpenStreamFromAssets = deviceProfileWriter2.openStreamFromAssets(assets, "dexopt/baseline.prof");
                } catch (FileNotFoundException e16) {
                    profileInstaller$DiagnosticsCallback.onResultReceived(6, e16);
                    OpenStreamFromAssets = 0;
                } catch (IOException e17) {
                    profileInstaller$DiagnosticsCallback.onResultReceived(7, e17);
                    OpenStreamFromAssets = 0;
                }
                deviceProfileWriter2.mDeviceSupportsAotProfile = true;
                bArr = MAGIC_PROF;
            }
            z2 = false;
            if (z2) {
                r11 = 0;
            } else {
                r11 = 0;
            }
            ProfileVerifier.writeProfileVerification(context, r11);
        } catch (PackageManager.NameNotFoundException e18) {
            profileInstaller$DiagnosticsCallback.onResultReceived(7, e18);
            ProfileVerifier.writeProfileVerification(context, false);
        }
    }
}
