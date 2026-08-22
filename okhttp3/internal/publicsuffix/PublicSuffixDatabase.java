package okhttp3.internal.publicsuffix;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.DropSequence;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.platform.Platform;
import okio.GzipSource;
import okio.InputStreamSource;
import okio.Okio;
import okio.Okio__JvmOkioKt;
import okio.RealBufferedSource;
import okio.Timeout;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class PublicSuffixDatabase {
    public byte[] publicSuffixExceptionListBytes;
    public byte[] publicSuffixListBytes;
    public static final byte[] WILDCARD_LABEL = {(byte) 42};
    public static final List PREVAILING_RULE = Okio.listOf("*");
    public static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    public final AtomicBoolean listRead = new AtomicBoolean(false);
    public final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    public static List splitDomain(String str) {
        int i = 0;
        List listSplit$default = StringsKt__StringsKt.split$default(str, new char[]{'.'});
        if (!Intrinsics.areEqual((String) CollectionsKt.last(listSplit$default), "")) {
            return listSplit$default;
        }
        int size = listSplit$default.size() - 1;
        if (size < 0) {
            size = 0;
        }
        if (size < 0) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(size, "Requested element count ", " is less than zero.").toString());
        }
        if (size == 0) {
            return EmptyList.INSTANCE;
        }
        if (size >= listSplit$default.size()) {
            return CollectionsKt.toList(listSplit$default);
        }
        if (size == 1) {
            return Okio.listOf(CollectionsKt.first(listSplit$default));
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            i++;
            if (i == size) {
                break;
            }
        }
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
    }

    public final String getEffectiveTldPlusOne(String str) {
        String strAccess$binarySearch;
        String strAccess$binarySearch2;
        String strAccess$binarySearch3;
        List listSplit$default;
        int size;
        int size2;
        int i = 0;
        String unicode = IDN.toUnicode(str);
        Intrinsics.checkNotNullExpressionValue(unicode, JrbhsraGtto.QzUIQtLbQKoY);
        List listSplitDomain = splitDomain(unicode);
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z = false;
            while (true) {
                try {
                    try {
                        readTheList();
                        break;
                    } catch (InterruptedIOException unused2) {
                        Thread.interrupted();
                        z = true;
                    } catch (IOException e) {
                        Platform platform = Platform.platform;
                        Platform.platform.getClass();
                        Platform.log(5, "Failed to read public suffix list", e);
                        if (z) {
                        }
                    }
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
        if (this.publicSuffixListBytes == null) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
        }
        int size3 = listSplitDomain.size();
        byte[][] bArr = new byte[size3][];
        for (int i2 = 0; i2 < size3; i2++) {
            String str2 = (String) listSplitDomain.get(i2);
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            if (str2 == null) {
                throw new NullPointerException(dLDI.tWuRnW);
            }
            byte[] bytes = str2.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            bArr[i2] = bytes;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= size3) {
                strAccess$binarySearch = null;
                break;
            }
            byte[] bArr2 = this.publicSuffixListBytes;
            if (bArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                throw null;
            }
            strAccess$binarySearch = JSONObject.Null.access$binarySearch(bArr2, bArr, i3);
            if (strAccess$binarySearch != null) {
                break;
            }
            i3++;
        }
        if (size3 <= 1) {
            strAccess$binarySearch2 = null;
            break;
        }
        byte[][] bArr3 = (byte[][]) bArr.clone();
        int length = bArr3.length - 1;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                strAccess$binarySearch2 = null;
                break;
            }
            bArr3[i4] = WILDCARD_LABEL;
            byte[] bArr4 = this.publicSuffixListBytes;
            if (bArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                throw null;
            }
            strAccess$binarySearch2 = JSONObject.Null.access$binarySearch(bArr4, bArr3, i4);
            if (strAccess$binarySearch2 != null) {
                break;
            }
            i4++;
        }
        if (strAccess$binarySearch2 == null) {
            strAccess$binarySearch3 = null;
            break;
        }
        int i5 = size3 - 1;
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                strAccess$binarySearch3 = null;
                break;
            }
            byte[] bArr5 = this.publicSuffixExceptionListBytes;
            if (bArr5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
                throw null;
            }
            strAccess$binarySearch3 = JSONObject.Null.access$binarySearch(bArr5, bArr, i6);
            if (strAccess$binarySearch3 != null) {
                break;
            }
            i6++;
        }
        if (strAccess$binarySearch3 != null) {
            listSplit$default = StringsKt__StringsKt.split$default("!".concat(strAccess$binarySearch3), new char[]{'.'});
        } else if (strAccess$binarySearch == null && strAccess$binarySearch2 == null) {
            listSplit$default = PREVAILING_RULE;
        } else {
            List listSplit$default2 = EmptyList.INSTANCE;
            List listSplit$default3 = strAccess$binarySearch != null ? StringsKt__StringsKt.split$default(strAccess$binarySearch, new char[]{'.'}) : listSplit$default2;
            if (strAccess$binarySearch2 != null) {
                listSplit$default2 = StringsKt__StringsKt.split$default(strAccess$binarySearch2, new char[]{'.'});
            }
            listSplit$default = listSplit$default3.size() > listSplit$default2.size() ? listSplit$default3 : listSplit$default2;
        }
        if (listSplitDomain.size() == listSplit$default.size() && ((String) listSplit$default.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String) listSplit$default.get(0)).charAt(0) == '!') {
            size = listSplitDomain.size();
            size2 = listSplit$default.size();
        } else {
            size = listSplitDomain.size();
            size2 = listSplit$default.size() + 1;
        }
        int i7 = size - size2;
        Sequence generatorSequence = new GeneratorSequence(splitDomain(str), 1);
        if (i7 < 0) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i7, "Requested element count ", " is less than zero.").toString());
        }
        if (i7 != 0) {
            generatorSequence = new DropSequence(generatorSequence, i7);
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        for (Object obj : generatorSequence) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) ".");
            }
            StringsKt__IndentKt.appendElement(sb, obj, null);
        }
        sb.append((CharSequence) "");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public final void readTheList() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            Logger logger = Okio__JvmOkioKt.logger;
            RealBufferedSource realBufferedSource = new RealBufferedSource(new GzipSource(new InputStreamSource(resourceAsStream, new Timeout(), 0)));
            try {
                long j = realBufferedSource.readInt();
                realBufferedSource.require(j);
                byte[] byteArray = realBufferedSource.bufferField.readByteArray(j);
                long j2 = realBufferedSource.readInt();
                realBufferedSource.require(j2);
                byte[] byteArray2 = realBufferedSource.bufferField.readByteArray(j2);
                CloseableKt.closeFinally(realBufferedSource, null);
                synchronized (this) {
                    this.publicSuffixListBytes = byteArray;
                    this.publicSuffixExceptionListBytes = byteArray2;
                }
                this.readCompleteLatch.countDown();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(realBufferedSource, th);
                    throw th2;
                }
            }
        }
    }
}
