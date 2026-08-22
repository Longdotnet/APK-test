package com.google.android.gms.measurement.internal;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.comparisons.NaturalOrderComparator;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CipherSuite;
import okhttp3.CipherSuite$Companion$ORDER_BY_NAME$1;
import okhttp3.ConnectionSpec;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes.dex */
public final class zzef {
    public final Object zza;
    public int zzb;
    public boolean zzc;
    public boolean zzd;

    public zzef(zzeh zzehVar, int i, boolean z, boolean z2) {
        this.zza = zzehVar;
        this.zzb = i;
        this.zzc = z;
        this.zzd = z2;
    }

    public ConnectionSpec configureSecureSocket(SSLSocket sSLSocket) throws UnknownServiceException, CloneNotSupportedException {
        ConnectionSpec connectionSpec;
        int i;
        boolean z;
        String[] cipherSuitesIntersection;
        String[] tlsVersionsIntersection;
        int i2 = this.zzb;
        List list = (List) this.zza;
        int size = list.size();
        while (true) {
            if (i2 >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = (ConnectionSpec) list.get(i2);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.zzb = i2 + 1;
                break;
            }
            i2++;
        }
        if (connectionSpec == null) {
            StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
            sb.append(this.zzd);
            sb.append(", modes=");
            sb.append(list);
            sb.append(", supported protocols=");
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            Intrinsics.checkNotNull(enabledProtocols);
            String string = Arrays.toString(enabledProtocols);
            Intrinsics.checkNotNullExpressionValue(string, "java.util.Arrays.toString(this)");
            sb.append(string);
            throw new UnknownServiceException(sb.toString());
        }
        int i3 = this.zzb;
        int size2 = list.size();
        while (true) {
            i = 0;
            if (i3 >= size2) {
                z = false;
                break;
            }
            if (((ConnectionSpec) list.get(i3)).isCompatible(sSLSocket)) {
                z = true;
                break;
            }
            i3++;
        }
        this.zzc = z;
        boolean z2 = this.zzd;
        String[] strArr = connectionSpec.cipherSuitesAsString;
        if (strArr != null) {
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            Intrinsics.checkNotNullExpressionValue(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            cipherSuitesIntersection = Util.intersect(enabledCipherSuites, strArr, CipherSuite.ORDER_BY_NAME);
        } else {
            cipherSuitesIntersection = sSLSocket.getEnabledCipherSuites();
        }
        String[] strArr2 = connectionSpec.tlsVersionsAsString;
        if (strArr2 != null) {
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            Intrinsics.checkNotNullExpressionValue(enabledProtocols2, "sslSocket.enabledProtocols");
            tlsVersionsIntersection = Util.intersect(enabledProtocols2, strArr2, NaturalOrderComparator.INSTANCE);
        } else {
            tlsVersionsIntersection = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(supportedCipherSuites, "supportedCipherSuites");
        CipherSuite$Companion$ORDER_BY_NAME$1 cipherSuite$Companion$ORDER_BY_NAME$1 = CipherSuite.ORDER_BY_NAME;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        int length = supportedCipherSuites.length;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (cipherSuite$Companion$ORDER_BY_NAME$1.compare(supportedCipherSuites[i], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i++;
        }
        if (z2 && i != -1) {
            Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
            String str = supportedCipherSuites[i];
            Intrinsics.checkNotNullExpressionValue(str, "supportedCipherSuites[indexOfFallbackScsv]");
            Object[] objArrCopyOf = Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length + 1);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
            cipherSuitesIntersection = (String[]) objArrCopyOf;
            cipherSuitesIntersection[cipherSuitesIntersection.length - 1] = str;
        }
        ConnectionSpec.Builder builder = new ConnectionSpec.Builder();
        builder.tls = connectionSpec.isTls;
        builder.cipherSuites = strArr;
        builder.tlsVersions = strArr2;
        builder.supportsTlsExtensions = connectionSpec.supportsTlsExtensions;
        Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
        builder.cipherSuites((String[]) Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length));
        Intrinsics.checkNotNullExpressionValue(tlsVersionsIntersection, "tlsVersionsIntersection");
        builder.tlsVersions((String[]) Arrays.copyOf(tlsVersionsIntersection, tlsVersionsIntersection.length));
        ConnectionSpec connectionSpecBuild = builder.build();
        if (connectionSpecBuild.tlsVersions() != null) {
            sSLSocket.setEnabledProtocols(connectionSpecBuild.tlsVersionsAsString);
        }
        if (connectionSpecBuild.cipherSuites() != null) {
            sSLSocket.setEnabledCipherSuites(connectionSpecBuild.cipherSuitesAsString);
        }
        return connectionSpec;
    }

    public void zza(String str) {
        ((zzeh) this.zza).zzt(this.zzb, this.zzc, this.zzd, str, null, null, null);
    }

    public void zzb(Object obj, String str) {
        ((zzeh) this.zza).zzt(this.zzb, this.zzc, this.zzd, str, obj, null, null);
    }

    public void zzc(Object obj, String str, Object obj2) {
        ((zzeh) this.zza).zzt(this.zzb, this.zzc, this.zzd, str, obj, obj2, null);
    }

    public void zzd(String str, Object obj, Object obj2, Object obj3) {
        ((zzeh) this.zza).zzt(this.zzb, this.zzc, this.zzd, str, obj, obj2, obj3);
    }

    public zzef(List connectionSpecs) {
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        this.zza = connectionSpecs;
    }
}
