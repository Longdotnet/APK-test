package okhttp3;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import com.google.firebase.inject.PVS.jIKWv;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.NaturalOrderComparator;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
public final class ConnectionSpec {
    public static final ConnectionSpec CLEARTEXT;
    public static final ConnectionSpec MODERN_TLS;
    public final String[] cipherSuitesAsString;
    public final boolean isTls;
    public final boolean supportsTlsExtensions;
    public final String[] tlsVersionsAsString;

    public final class Builder implements GraphRequest.KeyValueSerializer {
        public Object cipherSuites;
        public boolean supportsTlsExtensions;
        public boolean tls = true;
        public Object tlsVersions;

        public ConnectionSpec build() {
            return new ConnectionSpec(this.tls, this.supportsTlsExtensions, (String[]) this.cipherSuites, (String[]) this.tlsVersions);
        }

        public void cipherSuites(CipherSuite... cipherSuites) throws CloneNotSupportedException {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (!this.tls) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections");
            }
            ArrayList arrayList = new ArrayList(cipherSuites.length);
            for (CipherSuite cipherSuite : cipherSuites) {
                arrayList.add(cipherSuite.javaName);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            cipherSuites((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public void tlsVersions(TlsVersion... tlsVersionArr) throws CloneNotSupportedException {
            if (!this.tls) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections");
            }
            ArrayList arrayList = new ArrayList(tlsVersionArr.length);
            for (TlsVersion tlsVersion : tlsVersionArr) {
                arrayList.add(tlsVersion.javaName);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            tlsVersions((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public void write(String str, Object... args) throws IOException {
            Intrinsics.checkNotNullParameter(args, "args");
            FilterOutputStream filterOutputStream = (FilterOutputStream) this.cipherSuites;
            if (this.supportsTlsExtensions) {
                Locale locale = Locale.US;
                Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
                String strEncode = URLEncoder.encode(String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length)), "UTF-8");
                Intrinsics.checkNotNullExpressionValue(strEncode, "encode(String.format(Locale.US, format, *args), \"UTF-8\")");
                byte[] bytes = strEncode.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                filterOutputStream.write(bytes);
                return;
            }
            if (this.tls) {
                Charset charset = Charsets.UTF_8;
                byte[] bytes2 = "--".getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                filterOutputStream.write(bytes2);
                String str2 = GraphRequest.MIME_BOUNDARY;
                if (str2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                byte[] bytes3 = str2.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes3, "(this as java.lang.String).getBytes(charset)");
                filterOutputStream.write(bytes3);
                byte[] bytes4 = "\r\n".getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes4, "(this as java.lang.String).getBytes(charset)");
                filterOutputStream.write(bytes4);
                this.tls = false;
            }
            Object[] objArrCopyOf2 = Arrays.copyOf(args, args.length);
            byte[] bytes5 = String.format(str, Arrays.copyOf(objArrCopyOf2, objArrCopyOf2.length)).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes5, "(this as java.lang.String).getBytes(charset)");
            filterOutputStream.write(bytes5);
        }

        public void writeContentDisposition(String str, String str2, String str3) throws IOException {
            if (this.supportsTlsExtensions) {
                byte[] bytes = String.format("%s=", Arrays.copyOf(new Object[]{str}, 1)).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                ((FilterOutputStream) this.cipherSuites).write(bytes);
                return;
            }
            write("Content-Disposition: form-data; name=\"%s\"", str);
            if (str2 != null) {
                write("; filename=\"%s\"", str2);
            }
            writeLine("", new Object[0]);
            if (str3 != null) {
                writeLine("%s: %s", "Content-Type", str3);
            }
            writeLine("", new Object[0]);
        }

        public void writeContentUri(String key, Uri contentUri, String str) throws Throwable {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(contentUri, "contentUri");
            if (str == null) {
                str = "content/unknown";
            }
            writeContentDisposition(key, key, str);
            int iCopyAndCloseInputStream = Utility.copyAndCloseInputStream(FacebookSdk.getApplicationContext().getContentResolver().openInputStream(contentUri), (FilterOutputStream) this.cipherSuites);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            ((Logger) this.tlsVersions).appendKeyValue(String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(iCopyAndCloseInputStream)}, 1)), Intrinsics.stringPlus(key, "    "));
        }

        public void writeFile(String key, ParcelFileDescriptor descriptor, String str) throws Throwable {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            if (str == null) {
                str = "content/unknown";
            }
            writeContentDisposition(key, key, str);
            int iCopyAndCloseInputStream = Utility.copyAndCloseInputStream(new ParcelFileDescriptor.AutoCloseInputStream(descriptor), (FilterOutputStream) this.cipherSuites);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            ((Logger) this.tlsVersions).appendKeyValue(String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(iCopyAndCloseInputStream)}, 1)), Intrinsics.stringPlus(key, "    "));
        }

        public void writeLine(String str, Object... objArr) throws IOException {
            write(str, Arrays.copyOf(objArr, objArr.length));
            if (this.supportsTlsExtensions) {
                return;
            }
            write("\r\n", new Object[0]);
        }

        public void writeObject(String key, Object obj, GraphRequest graphRequest) {
            Intrinsics.checkNotNullParameter(key, "key");
            FilterOutputStream filterOutputStream = (FilterOutputStream) this.cipherSuites;
            String str = GraphRequest.MIME_BOUNDARY;
            if (GraphRequest.Companion.isSupportedParameterType(obj)) {
                writeString(key, GraphRequest.Companion.access$parameterToString(obj));
                return;
            }
            boolean z = obj instanceof Bitmap;
            Logger logger = (Logger) this.tlsVersions;
            if (z) {
                Bitmap bitmap = (Bitmap) obj;
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                writeContentDisposition(key, key, "image/png");
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, filterOutputStream);
                writeLine("", new Object[0]);
                writeRecordBoundary();
                logger.appendKeyValue("<Image>", Intrinsics.stringPlus(key, "    "));
                return;
            }
            if (obj instanceof byte[]) {
                byte[] bytes = (byte[]) obj;
                Intrinsics.checkNotNullParameter(bytes, "bytes");
                writeContentDisposition(key, key, "content/unknown");
                filterOutputStream.write(bytes);
                writeLine("", new Object[0]);
                writeRecordBoundary();
                logger.appendKeyValue(String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(bytes.length)}, 1)), Intrinsics.stringPlus(key, "    "));
                return;
            }
            if (obj instanceof Uri) {
                writeContentUri(key, (Uri) obj, null);
                return;
            }
            if (obj instanceof ParcelFileDescriptor) {
                writeFile(key, (ParcelFileDescriptor) obj, null);
                return;
            }
            if (!(obj instanceof GraphRequest.ParcelableResourceWithMimeType)) {
                throw new IllegalArgumentException("value is not a supported type.");
            }
            GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = (GraphRequest.ParcelableResourceWithMimeType) obj;
            Parcelable parcelable = parcelableResourceWithMimeType.resource;
            boolean z2 = parcelable instanceof ParcelFileDescriptor;
            String str2 = parcelableResourceWithMimeType.mimeType;
            if (z2) {
                writeFile(key, (ParcelFileDescriptor) parcelable, str2);
            } else {
                if (!(parcelable instanceof Uri)) {
                    throw new IllegalArgumentException("value is not a supported type.");
                }
                writeContentUri(key, (Uri) parcelable, str2);
            }
        }

        public void writeRecordBoundary() throws IOException {
            if (!this.supportsTlsExtensions) {
                writeLine("--%s", GraphRequest.MIME_BOUNDARY);
                return;
            }
            byte[] bytes = "&".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            ((FilterOutputStream) this.cipherSuites).write(bytes);
        }

        @Override // com.facebook.GraphRequest.KeyValueSerializer
        public void writeString(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            writeContentDisposition(key, null, null);
            writeLine("%s", value);
            writeRecordBoundary();
            Logger logger = (Logger) this.tlsVersions;
            if (logger == null) {
                return;
            }
            logger.appendKeyValue(value, Intrinsics.stringPlus(key, jIKWv.ARep));
        }

        public void cipherSuites(String... cipherSuites) throws CloneNotSupportedException {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (this.tls) {
                if (cipherSuites.length != 0) {
                    Object objClone = cipherSuites.clone();
                    if (objClone == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    }
                    this.cipherSuites = (String[]) objClone;
                    return;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }

        public void tlsVersions(String... tlsVersions) throws CloneNotSupportedException {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            if (this.tls) {
                if (tlsVersions.length != 0) {
                    Object objClone = tlsVersions.clone();
                    if (objClone == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    }
                    this.tlsVersions = (String[]) objClone;
                    return;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }
    }

    static {
        CipherSuite cipherSuite = CipherSuite.TLS_AES_128_GCM_SHA256;
        CipherSuite cipherSuite2 = CipherSuite.TLS_AES_256_GCM_SHA384;
        CipherSuite cipherSuite3 = CipherSuite.TLS_CHACHA20_POLY1305_SHA256;
        CipherSuite cipherSuite4 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        CipherSuite cipherSuite5 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        CipherSuite cipherSuite6 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        CipherSuite cipherSuite7 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        CipherSuite cipherSuite8 = CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        CipherSuite cipherSuite9 = CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        CipherSuite[] cipherSuiteArr = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        Builder builder = new Builder();
        builder.cipherSuites((CipherSuite[]) Arrays.copyOf(new CipherSuite[]{cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9}, 9));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        builder.tlsVersions(tlsVersion, tlsVersion2);
        if (!builder.tls) {
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }
        builder.supportsTlsExtensions = true;
        builder.build();
        Builder builder2 = new Builder();
        builder2.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr, 16));
        builder2.tlsVersions(tlsVersion, tlsVersion2);
        if (!builder2.tls) {
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }
        builder2.supportsTlsExtensions = true;
        MODERN_TLS = builder2.build();
        Builder builder3 = new Builder();
        builder3.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr, 16));
        builder3.tlsVersions(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        if (!builder3.tls) {
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }
        builder3.supportsTlsExtensions = true;
        builder3.build();
        CLEARTEXT = new ConnectionSpec(false, false, null, null);
    }

    public ConnectionSpec(boolean z, boolean z2, String[] strArr, String[] strArr2) {
        this.isTls = z;
        this.supportsTlsExtensions = z2;
        this.cipherSuitesAsString = strArr;
        this.tlsVersionsAsString = strArr2;
    }

    public final List cipherSuites() {
        String[] strArr = this.cipherSuitesAsString;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(CipherSuite.Companion.forJavaName(str));
        }
        return CollectionsKt.toList(arrayList);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z = connectionSpec.isTls;
        boolean z2 = this.isTls;
        if (z2 != z) {
            return false;
        }
        return !z2 || (Arrays.equals(this.cipherSuitesAsString, connectionSpec.cipherSuitesAsString) && Arrays.equals(this.tlsVersionsAsString, connectionSpec.tlsVersionsAsString) && this.supportsTlsExtensions == connectionSpec.supportsTlsExtensions);
    }

    public final int hashCode() {
        if (!this.isTls) {
            return 17;
        }
        String[] strArr = this.cipherSuitesAsString;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.tlsVersionsAsString;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.supportsTlsExtensions ? 1 : 0);
    }

    public final boolean isCompatible(SSLSocket sSLSocket) {
        if (!this.isTls) {
            return false;
        }
        String[] strArr = this.tlsVersionsAsString;
        if (strArr != null && !Util.hasIntersection(strArr, sSLSocket.getEnabledProtocols(), NaturalOrderComparator.INSTANCE)) {
            return false;
        }
        String[] strArr2 = this.cipherSuitesAsString;
        return strArr2 == null || Util.hasIntersection(strArr2, sSLSocket.getEnabledCipherSuites(), CipherSuite.ORDER_BY_NAME);
    }

    public final List tlsVersions() {
        String[] strArr = this.tlsVersionsAsString;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(CloseableKt.forJavaName(str));
        }
        return CollectionsKt.toList(arrayList);
    }

    public final String toString() {
        if (!this.isTls) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(cipherSuites(), "[all enabled]") + ", tlsVersions=" + Objects.toString(tlsVersions(), "[all enabled]") + wsbWxekY.ZhUJbXsiJivqTmt + this.supportsTlsExtensions + ')';
    }
}
