package com.google.android.datatransport.cct;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedDestination;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.jvm.JvmClassMappingKt;

/* JADX INFO: loaded from: classes2.dex */
public final class CCTDestination implements EncodedDestination {
    public static final String DEFAULT_END_POINT;
    public static final CCTDestination INSTANCE;
    public static final Set SUPPORTED_ENCODINGS;
    public final String apiKey;
    public final String endPoint;

    public CCTDestination(String str, String str2) {
        this.endPoint = str;
        this.apiKey = str2;
    }

    static {
        String strMergeStrings = JvmClassMappingKt.mergeStrings("hts/frbslgiggolai.o/0clgbthfra=snpoo", GsPcpBmONXh.VTgCdDBWTBLhITH);
        DEFAULT_END_POINT = strMergeStrings;
        JvmClassMappingKt.mergeStrings("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        JvmClassMappingKt.mergeStrings("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        SUPPORTED_ENCODINGS = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Encoding(yzwzcWHcnH.DKbb), new Encoding("json"))));
        INSTANCE = new CCTDestination(strMergeStrings, null);
    }

    public static CCTDestination fromByteArray(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith(xPQrbOSWiEdU.HKzWChcqg)) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new CCTDestination(str2, str3);
    }
}
