package androidx.multidex;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.core.text.jp.CyjpdoedCdLTIO;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.daerisoft.thespikerm.RunnerApplication;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiDexExtractor implements Closeable {
    public final FileLock cacheLock;
    public final File dexDir;
    public final FileChannel lockChannel;
    public final RandomAccessFile lockRaf;
    public final File sourceApk;
    public final long sourceCrc;

    /* JADX INFO: renamed from: androidx.multidex.MultiDexExtractor$1 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass1 implements FileFilter {
        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return !file.getName().equals("MultiDex.lock");
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class ExtractedDex extends File {
        public long crc;

        public ExtractedDex(File file, String str) {
            super(file, str);
            this.crc = -1L;
        }
    }

    public MultiDexExtractor(File file, File file2) throws Throwable {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.sourceApk = file;
        this.dexDir = file2;
        this.sourceCrc = getZipCrc(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.lockRaf = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.lockChannel = channel;
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.cacheLock = channel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e) {
                e = e;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (Error e2) {
                e = e2;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (RuntimeException e3) {
                e = e3;
                closeQuietly(this.lockChannel);
                throw e;
            }
        } catch (IOException e4) {
            e = e4;
            closeQuietly(this.lockRaf);
            throw e;
        } catch (Error e5) {
            e = e5;
            closeQuietly(this.lockRaf);
            throw e;
        } catch (RuntimeException e6) {
            e = e6;
            closeQuietly(this.lockRaf);
            throw e;
        }
    }

    public static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }

    public static void extract(ZipFile zipFile, ZipEntry zipEntry, ExtractedDex extractedDex, String str) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File fileCreateTempFile = File.createTempFile(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("tmp-", str), ".zip", extractedDex.getParentFile());
        Log.i("MultiDex", "Extracting " + fileCreateTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(fileCreateTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int i = inputStream.read(bArr); i != -1; i = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, i);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (!fileCreateTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + fileCreateTempFile.getAbsolutePath() + "\" (tmp of \"" + extractedDex.getAbsolutePath() + "\")");
                }
                Log.i("MultiDex", "Renaming to " + extractedDex.getPath());
                if (fileCreateTempFile.renameTo(extractedDex)) {
                    closeQuietly(inputStream);
                    fileCreateTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + fileCreateTempFile.getAbsolutePath() + "\" to \"" + extractedDex.getAbsolutePath() + "\"");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            closeQuietly(inputStream);
            fileCreateTempFile.delete();
            throw th2;
        }
    }

    public static long getZipCrc(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            ZipUtil$CentralDirectory zipUtil$CentralDirectoryFindCentralDirectory = GamepadHandler_API19.findCentralDirectory(randomAccessFile);
            CRC32 crc32 = new CRC32();
            long j = zipUtil$CentralDirectoryFindCentralDirectory.size;
            randomAccessFile.seek(zipUtil$CentralDirectoryFindCentralDirectory.offset);
            byte[] bArr = new byte[16384];
            int i = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j));
            while (i != -1) {
                crc32.update(bArr, 0, i);
                j -= (long) i;
                if (j == 0) {
                    break;
                }
                i = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j));
            }
            long value = crc32.getValue();
            randomAccessFile.close();
            return value == -1 ? value - 1 : value;
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public static void putStoredApkInfo(RunnerApplication runnerApplication, long j, long j2, ArrayList arrayList) {
        SharedPreferences.Editor editorEdit = runnerApplication.getSharedPreferences("multidex.version", 4).edit();
        editorEdit.putLong("timestamp", j);
        editorEdit.putLong("crc", j2);
        editorEdit.putInt("dex.number", arrayList.size() + 1);
        Iterator it = arrayList.iterator();
        int i = 2;
        while (it.hasNext()) {
            ExtractedDex extractedDex = (ExtractedDex) it.next();
            editorEdit.putLong(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "dex.crc."), extractedDex.crc);
            editorEdit.putLong("dex.time." + i, extractedDex.lastModified());
            i++;
        }
        editorEdit.commit();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.cacheLock.release();
        this.lockChannel.close();
        this.lockRaf.close();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x007d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x007f  */
    /* JADX WARN: Code duplicated, block: B:24:0x0085  */
    /* JADX WARN: Code duplicated, block: B:27:0x0096  */
    public final ArrayList load(RunnerApplication runnerApplication, boolean z) throws Throwable {
        ArrayList arrayListPerformExtractions;
        long jLastModified;
        ArrayList arrayListLoadExistingExtractions;
        StringBuilder sb = new StringBuilder("MultiDexExtractor.load(");
        File file = this.sourceApk;
        sb.append(file.getPath());
        sb.append(", ");
        sb.append(z);
        sb.append(", )");
        Log.i("MultiDex", sb.toString());
        if (!this.cacheLock.isValid()) {
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        if (z) {
            if (z) {
                Log.i("MultiDex", "Forced extraction must be performed.");
            } else {
                Log.i("MultiDex", "Detected that extraction must be performed.");
            }
            arrayListPerformExtractions = performExtractions();
            jLastModified = file.lastModified();
            if (jLastModified == -1) {
                jLastModified--;
            }
            putStoredApkInfo(runnerApplication, jLastModified, this.sourceCrc, arrayListPerformExtractions);
            arrayListLoadExistingExtractions = arrayListPerformExtractions;
        } else {
            SharedPreferences sharedPreferences = runnerApplication.getSharedPreferences("multidex.version", 4);
            long j = sharedPreferences.getLong("timestamp", -1L);
            long jLastModified2 = file.lastModified();
            if (jLastModified2 == -1) {
                jLastModified2--;
            }
            if (j == jLastModified2 && sharedPreferences.getLong("crc", -1L) == this.sourceCrc) {
                try {
                    arrayListLoadExistingExtractions = loadExistingExtractions(runnerApplication);
                } catch (IOException e) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
                    arrayListPerformExtractions = performExtractions();
                    long jLastModified3 = file.lastModified();
                    if (jLastModified3 == -1) {
                        jLastModified3--;
                    }
                    putStoredApkInfo(runnerApplication, jLastModified3, this.sourceCrc, arrayListPerformExtractions);
                    arrayListLoadExistingExtractions = arrayListPerformExtractions;
                }
            } else {
                if (z) {
                    Log.i("MultiDex", "Forced extraction must be performed.");
                } else {
                    Log.i("MultiDex", "Detected that extraction must be performed.");
                }
                arrayListPerformExtractions = performExtractions();
                jLastModified = file.lastModified();
                if (jLastModified == -1) {
                    jLastModified--;
                }
                putStoredApkInfo(runnerApplication, jLastModified, this.sourceCrc, arrayListPerformExtractions);
            }
            arrayListLoadExistingExtractions = arrayListPerformExtractions;
        }
        Log.i("MultiDex", "load found " + arrayListLoadExistingExtractions.size() + " secondary dex files");
        return arrayListLoadExistingExtractions;
    }

    public final ArrayList loadExistingExtractions(RunnerApplication runnerApplication) throws IOException {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str = this.sourceApk.getName() + QTaELkFI.vWCXp;
        SharedPreferences sharedPreferences = runnerApplication.getSharedPreferences("multidex.version", 4);
        int i = sharedPreferences.getInt("dex.number", 1);
        ArrayList arrayList = new ArrayList(i - 1);
        for (int i2 = 2; i2 <= i; i2++) {
            ExtractedDex extractedDex = new ExtractedDex(this.dexDir, str + i2 + ".zip");
            if (!extractedDex.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
            }
            extractedDex.crc = getZipCrc(extractedDex);
            long j = sharedPreferences.getLong("dex.crc." + i2, -1L);
            long j2 = sharedPreferences.getLong("dex.time." + i2, -1L);
            long jLastModified = extractedDex.lastModified();
            if (j2 != jLastModified || j != extractedDex.crc) {
                throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"\"), expected modification time: " + j2 + ", modification time: " + jLastModified + ", expected crc: " + j + ", file crc: " + extractedDex.crc);
            }
            arrayList.add(extractedDex);
        }
        return arrayList;
    }

    public final ArrayList performExtractions() throws Throwable {
        Throwable th;
        boolean z;
        String str = CyjpdoedCdLTIO.Xwhq;
        StringBuilder sb = new StringBuilder();
        File file = this.sourceApk;
        sb.append(file.getName());
        sb.append(".classes");
        String string = sb.toString();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        File file2 = this.dexDir;
        File[] fileArrListFiles = file2.listFiles(anonymousClass1);
        String str2 = "MultiDex";
        if (fileArrListFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + file2.getPath() + ").");
        } else {
            for (File file3 : fileArrListFiles) {
                Log.i("MultiDex", "Trying to delete old file " + file3.getPath() + " of size " + file3.length());
                if (file3.delete()) {
                    Log.i("MultiDex", "Deleted old file " + file3.getPath());
                } else {
                    Log.w("MultiDex", "Failed to delete old file " + file3.getPath());
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        try {
            int i = 2;
            ZipEntry entry = zipFile.getEntry("classes2" + str);
            while (entry != null) {
                ExtractedDex extractedDex = new ExtractedDex(file2, string + i + ".zip");
                arrayList.add(extractedDex);
                Log.i(str2, "Extraction is needed for file " + extractedDex);
                int i2 = 0;
                boolean z2 = false;
                while (i2 < 3 && !z2) {
                    int i3 = i2 + 1;
                    extract(zipFile, entry, extractedDex, string);
                    String str3 = str2;
                    try {
                        extractedDex.crc = getZipCrc(extractedDex);
                        z = true;
                        str2 = str3;
                    } catch (IOException e) {
                        try {
                            str2 = str3;
                            Log.w(str2, "Failed to read crc from " + extractedDex.getAbsolutePath(), e);
                            z = false;
                        } catch (Throwable th2) {
                            th = th2;
                            str2 = str3;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str2 = str3;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Extraction ");
                    sb2.append(z ? "succeeded" : "failed");
                    sb2.append(" '");
                    sb2.append(extractedDex.getAbsolutePath());
                    sb2.append("': length ");
                    ZipEntry zipEntry = entry;
                    String str4 = string;
                    sb2.append(extractedDex.length());
                    sb2.append(" - crc: ");
                    sb2.append(extractedDex.crc);
                    Log.i(str2, sb2.toString());
                    if (!z) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            Log.w(str2, "Failed to delete corrupted secondary dex '" + extractedDex.getPath() + "'");
                        }
                    }
                    string = str4;
                    entry = zipEntry;
                    z2 = z;
                    i2 = i3;
                }
                String str5 = string;
                if (!z2) {
                    throw new IOException(RDFWIi.HTgXpgBd + extractedDex.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
                i++;
                entry = zipFile.getEntry("classes" + i + str);
                string = str5;
                th = th;
                try {
                    zipFile.close();
                    throw th;
                } catch (IOException e2) {
                    Log.w(str2, "Failed to close resource", e2);
                    throw th;
                }
            }
            try {
                zipFile.close();
            } catch (IOException e3) {
                Log.w(str2, "Failed to close resource", e3);
            }
            return arrayList;
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
