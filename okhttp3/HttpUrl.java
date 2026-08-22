package okhttp3;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.RealBufferedSink;

/* JADX INFO: loaded from: classes3.dex */
public final class HttpUrl {
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final String fragment;
    public final String host;
    public final boolean isHttps;
    public final String password;
    public final int port;
    public final ArrayList queryNamesAndValues;
    public final String scheme;
    public final String url;
    public final String username;

    public final class Builder {
        public String encodedFragment;
        public final ArrayList encodedPathSegments;
        public ArrayList encodedQueryNamesAndValues;
        public String host;
        public String scheme;
        public String encodedUsername = "";
        public String encodedPassword = "";
        public int port = -1;

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            String strPercentDecode$okhttp$default = Companion.percentDecode$okhttp$default(this.encodedUsername, 0, 0, 7, false);
            String strPercentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(this.encodedPassword, 0, 0, 7, false);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iEffectivePort = effectivePort();
            ArrayList arrayList2 = this.encodedPathSegments;
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(Companion.percentDecode$okhttp$default((String) it.next(), 0, 0, 7, false));
            }
            ArrayList<String> arrayList4 = this.encodedQueryNamesAndValues;
            if (arrayList4 != null) {
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4));
                for (String str3 : arrayList4) {
                    arrayList.add(str3 != null ? Companion.percentDecode$okhttp$default(str3, 0, 0, 3, true) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new HttpUrl(str, strPercentDecode$okhttp$default, strPercentDecode$okhttp$default2, str2, iEffectivePort, arrayList3, arrayList, str4 != null ? Companion.percentDecode$okhttp$default(str4, 0, 0, 7, false) : null, toString());
        }

        public final int effectivePort() {
            int i = this.port;
            if (i != -1) {
                return i;
            }
            String str = this.scheme;
            Intrinsics.checkNotNull(str);
            int iHashCode = str.hashCode();
            if (iHashCode != 3213448) {
                if (iHashCode == 99617003 && str.equals("https")) {
                    return 443;
                }
            } else if (str.equals("http")) {
                return 80;
            }
            return -1;
        }

        /* JADX WARN: Code duplicated, block: B:39:0x009a  */
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (this.encodedUsername.length() > 0 || this.encodedPassword.length() > 0) {
                sb.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                if (StringsKt__StringsKt.contains$default((CharSequence) str2, ':')) {
                    sb.append('[');
                    sb.append(this.host);
                    sb.append(']');
                } else {
                    sb.append(this.host);
                }
            }
            int i = -1;
            if (this.port != -1 || this.scheme != null) {
                int iEffectivePort = effectivePort();
                String str3 = this.scheme;
                if (str3 == null) {
                    sb.append(':');
                    sb.append(iEffectivePort);
                } else {
                    int iHashCode = str3.hashCode();
                    if (iHashCode != 3213448) {
                        if (iHashCode == 99617003 && str3.equals("https")) {
                            i = 443;
                        }
                    } else if (str3.equals("http")) {
                        i = 80;
                    }
                    if (iEffectivePort != i) {
                        sb.append(':');
                        sb.append(iEffectivePort);
                    }
                }
            }
            ArrayList toPathString = this.encodedPathSegments;
            Intrinsics.checkNotNullParameter(toPathString, "$this$toPathString");
            int size = toPathString.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append('/');
                sb.append((String) toPathString.get(i2));
            }
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                ArrayList arrayList = this.encodedQueryNamesAndValues;
                Intrinsics.checkNotNull(arrayList);
                IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, arrayList.size()), 2);
                int i3 = intProgressionStep.first;
                int i4 = intProgressionStep.last;
                int i5 = intProgressionStep.step;
                if (i5 < 0 ? i3 >= i4 : i3 <= i4) {
                    while (true) {
                        String str4 = (String) arrayList.get(i3);
                        String str5 = (String) arrayList.get(i3 + 1);
                        if (i3 > 0) {
                            sb.append('&');
                        }
                        sb.append(str4);
                        if (str5 != null) {
                            sb.append('=');
                            sb.append(str5);
                        }
                        if (i3 == i4) {
                            break;
                        }
                        i3 += i5;
                    }
                }
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }

        /* JADX WARN: Code duplicated, block: B:103:0x020f  */
        /* JADX WARN: Code duplicated, block: B:105:0x0215  */
        /* JADX WARN: Code duplicated, block: B:107:0x0219  */
        /* JADX WARN: Code duplicated, block: B:108:0x021b  */
        /* JADX WARN: Code duplicated, block: B:111:0x021f  */
        /* JADX WARN: Code duplicated, block: B:118:0x0235  */
        /* JADX WARN: Code duplicated, block: B:129:0x0266  */
        /* JADX WARN: Code duplicated, block: B:132:0x026c  */
        /* JADX WARN: Code duplicated, block: B:133:0x0270  */
        /* JADX WARN: Code duplicated, block: B:135:0x0296  */
        /* JADX WARN: Code duplicated, block: B:138:0x02b2  */
        /* JADX WARN: Code duplicated, block: B:193:0x03d2  */
        /* JADX WARN: Code duplicated, block: B:215:0x022c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:216:0x0229 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:218:0x0227 A[EDGE_INSN: B:218:0x0227->B:113:0x0227 BREAK  A[LOOP:4: B:109:0x021c->B:220:?], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:4:0x0022  */
        /* JADX WARN: Code duplicated, block: B:76:0x0139  */
        /* JADX WARN: Code duplicated, block: B:79:0x0147  */
        /* JADX WARN: Code duplicated, block: B:80:0x014c  */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void parse$okhttp(HttpUrl httpUrl, String str) {
            int i;
            byte b;
            byte b2;
            int i2;
            int iDelimiterOffset;
            byte bCharAt;
            ArrayList arrayList;
            String str2;
            int i3;
            int i4;
            int i5;
            boolean z;
            int i6;
            char cCharAt;
            int i7;
            int i8;
            byte b3;
            ArrayList arrayList2;
            char cCharAt2;
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            int iIndexOfFirstNonAsciiWhitespace = Util.indexOfFirstNonAsciiWhitespace(0, str.length(), str);
            int iIndexOfLastNonAsciiWhitespace = Util.indexOfLastNonAsciiWhitespace(iIndexOfFirstNonAsciiWhitespace, str.length(), str);
            byte b4 = -1;
            if (iIndexOfLastNonAsciiWhitespace - iIndexOfFirstNonAsciiWhitespace >= 2) {
                char cCharAt3 = str.charAt(iIndexOfFirstNonAsciiWhitespace);
                char c = 'a';
                if ((Intrinsics.compare(cCharAt3, 97) >= 0 && Intrinsics.compare(cCharAt3, 122) <= 0) || (Intrinsics.compare(cCharAt3, 65) >= 0 && Intrinsics.compare(cCharAt3, 90) <= 0)) {
                    i = iIndexOfFirstNonAsciiWhitespace + 1;
                    while (true) {
                        if (i < iIndexOfLastNonAsciiWhitespace) {
                            char cCharAt4 = str.charAt(i);
                            if ((c > cCharAt4 || 'z' < cCharAt4) && (('A' > cCharAt4 || 'Z' < cCharAt4) && (('0' > cCharAt4 || '9' < cCharAt4) && cCharAt4 != '+' && cCharAt4 != '-' && cCharAt4 != '.'))) {
                                if (cCharAt4 == ':') {
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                i++;
                                c = 'a';
                            }
                        }
                        i = -1;
                        break;
                    }
                } else {
                    i = -1;
                    break;
                }
            } else {
                i = -1;
                break;
            }
            String str3 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            if (i != -1) {
                if (StringsKt__StringsKt.startsWith(str, iIndexOfFirstNonAsciiWhitespace, "https:", true)) {
                    this.scheme = "https";
                    iIndexOfFirstNonAsciiWhitespace += 6;
                } else {
                    if (!StringsKt__StringsKt.startsWith(str, iIndexOfFirstNonAsciiWhitespace, MnHfHMYQDPUO.RKsKX, true)) {
                        StringBuilder sb = new StringBuilder("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = str.substring(0, i);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sb.append(strSubstring);
                        sb.append("'");
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.scheme = "http";
                    iIndexOfFirstNonAsciiWhitespace += 5;
                }
            } else {
                if (httpUrl == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.scheme = httpUrl.scheme;
            }
            int i9 = iIndexOfFirstNonAsciiWhitespace;
            int i10 = 0;
            while (true) {
                b = 47;
                b2 = 92;
                if (i9 >= iIndexOfLastNonAsciiWhitespace || !((cCharAt2 = str.charAt(i9)) == '\\' || cCharAt2 == '/')) {
                    break;
                }
                i10++;
                i9++;
            }
            ArrayList arrayList3 = this.encodedPathSegments;
            byte b5 = 63;
            byte b6 = 35;
            if (i10 >= 2 || httpUrl == null) {
                i2 = iIndexOfFirstNonAsciiWhitespace + i10;
                boolean z2 = false;
                boolean z3 = false;
                while (true) {
                    iDelimiterOffset = Util.delimiterOffset(i2, iIndexOfLastNonAsciiWhitespace, str, "@/\\?#");
                    if (iDelimiterOffset != iIndexOfLastNonAsciiWhitespace) {
                        bCharAt = str.charAt(iDelimiterOffset);
                    } else {
                        bCharAt = b4;
                    }
                    if (bCharAt == b4 || bCharAt == b6 || bCharAt == b || bCharAt == b2 || bCharAt == b5) {
                        break;
                    }
                    if (bCharAt != 64) {
                        b3 = b5;
                        arrayList3 = arrayList3;
                        str3 = str3;
                    } else {
                        if (z2) {
                            i8 = iDelimiterOffset;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.encodedPassword);
                            sb2.append("%40");
                            b3 = b5;
                            sb2.append(Companion.canonicalize$okhttp$default(str, i2, i8, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 240));
                            this.encodedPassword = sb2.toString();
                        } else {
                            int iDelimiterOffset2 = Util.delimiterOffset(str, ':', i2, iDelimiterOffset);
                            int i11 = i2;
                            byte b7 = b5;
                            i8 = iDelimiterOffset;
                            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(str, i11, iDelimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 240);
                            if (z3) {
                                strCanonicalize$okhttp$default = Fragment$$ExternalSyntheticOutline0.m(new StringBuilder(), this.encodedUsername, "%40", strCanonicalize$okhttp$default);
                            }
                            this.encodedUsername = strCanonicalize$okhttp$default;
                            if (iDelimiterOffset2 != i8) {
                                this.encodedPassword = Companion.canonicalize$okhttp$default(str, iDelimiterOffset2 + 1, i8, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 240);
                                z2 = true;
                            }
                            b3 = b7;
                            z3 = true;
                        }
                        i2 = i8 + 1;
                    }
                    b5 = b3;
                    arrayList3 = arrayList3;
                    str3 = str3;
                    b2 = 92;
                    b = 47;
                    b6 = 35;
                    b4 = -1;
                }
                arrayList = arrayList3;
                str2 = str3;
                i3 = i2;
                while (true) {
                    if (i3 >= iDelimiterOffset) {
                        cCharAt = str.charAt(i3);
                        if (cCharAt != ':') {
                            i4 = i3;
                            break;
                        }
                        if (cCharAt != '[') {
                            i7 = 1;
                            do {
                                i3++;
                                if (i3 < iDelimiterOffset) {
                                    break;
                                }
                            } while (str.charAt(i3) != ']');
                        } else {
                            i7 = 1;
                        }
                        i3 += i7;
                    } else {
                        i4 = iDelimiterOffset;
                        break;
                    }
                }
                i5 = i4 + 1;
                if (i5 < iDelimiterOffset) {
                    this.host = TextStreamsKt.toCanonicalHost(Companion.percentDecode$okhttp$default(str, i2, i4, 4, false));
                    try {
                        i6 = Integer.parseInt(Companion.canonicalize$okhttp$default(str, i5, iDelimiterOffset, "", false, false, false, false, 248));
                        if (1 <= i6 || 65535 < i6) {
                            i6 = -1;
                        }
                    } catch (NumberFormatException unused) {
                    }
                    this.port = i6;
                    if (i6 != -1) {
                        StringBuilder sb3 = new StringBuilder("Invalid URL port: \"");
                        String strSubstring2 = str.substring(i5, iDelimiterOffset);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, str2);
                        sb3.append(strSubstring2);
                        sb3.append('\"');
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                    z = false;
                } else {
                    z = false;
                    this.host = TextStreamsKt.toCanonicalHost(Companion.percentDecode$okhttp$default(str, i2, i4, 4, false));
                    String str4 = this.scheme;
                    Intrinsics.checkNotNull(str4);
                    this.port = Companion.defaultPort(str4);
                }
                if (this.host != null) {
                    StringBuilder sb4 = new StringBuilder("Invalid URL host: \"");
                    String strSubstring3 = str.substring(i2, i4);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, str2);
                    sb4.append(strSubstring3);
                    sb4.append('\"');
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                iIndexOfFirstNonAsciiWhitespace = iDelimiterOffset;
            } else if (Intrinsics.areEqual(httpUrl.scheme, this.scheme)) {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host;
                this.port = httpUrl.port;
                arrayList3.clear();
                arrayList3.addAll(httpUrl.encodedPathSegments());
                if (iIndexOfFirstNonAsciiWhitespace == iIndexOfLastNonAsciiWhitespace || str.charAt(iIndexOfFirstNonAsciiWhitespace) == '#') {
                    String strEncodedQuery = httpUrl.encodedQuery();
                    this.encodedQueryNamesAndValues = strEncodedQuery != null ? Companion.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(strEncodedQuery, 0, 0, " \"'<>#", true, false, true, false, 211)) : null;
                }
                arrayList = arrayList3;
                z = false;
            } else {
                i2 = iIndexOfFirstNonAsciiWhitespace + i10;
                boolean z4 = false;
                boolean z5 = false;
                while (true) {
                    iDelimiterOffset = Util.delimiterOffset(i2, iIndexOfLastNonAsciiWhitespace, str, "@/\\?#");
                    if (iDelimiterOffset != iIndexOfLastNonAsciiWhitespace) {
                        bCharAt = str.charAt(iDelimiterOffset);
                    } else {
                        bCharAt = b4;
                    }
                    if (bCharAt == b4) {
                        break;
                    } else {
                        break;
                    }
                    b5 = b3;
                    arrayList3 = arrayList3;
                    str3 = str3;
                    b2 = 92;
                    b = 47;
                    b6 = 35;
                    b4 = -1;
                }
                arrayList = arrayList3;
                str2 = str3;
                i3 = i2;
                while (true) {
                    if (i3 >= iDelimiterOffset) {
                        cCharAt = str.charAt(i3);
                        if (cCharAt != ':') {
                            i4 = i3;
                            break;
                        }
                        if (cCharAt != '[') {
                            i7 = 1;
                            do {
                                i3++;
                                if (i3 < iDelimiterOffset) {
                                    break;
                                    break;
                                }
                            } while (str.charAt(i3) != ']');
                        } else {
                            i7 = 1;
                        }
                        i3 += i7;
                    } else {
                        i4 = iDelimiterOffset;
                        break;
                    }
                }
                i5 = i4 + 1;
                if (i5 < iDelimiterOffset) {
                    this.host = TextStreamsKt.toCanonicalHost(Companion.percentDecode$okhttp$default(str, i2, i4, 4, false));
                    i6 = Integer.parseInt(Companion.canonicalize$okhttp$default(str, i5, iDelimiterOffset, "", false, false, false, false, 248));
                    if (1 <= i6) {
                        i6 = -1;
                    } else {
                        i6 = -1;
                    }
                    this.port = i6;
                    if (i6 != -1) {
                        StringBuilder sb5 = new StringBuilder("Invalid URL port: \"");
                        String strSubstring4 = str.substring(i5, iDelimiterOffset);
                        Intrinsics.checkNotNullExpressionValue(strSubstring4, str2);
                        sb5.append(strSubstring4);
                        sb5.append('\"');
                        throw new IllegalArgumentException(sb5.toString().toString());
                    }
                    z = false;
                } else {
                    z = false;
                    this.host = TextStreamsKt.toCanonicalHost(Companion.percentDecode$okhttp$default(str, i2, i4, 4, false));
                    String str5 = this.scheme;
                    Intrinsics.checkNotNull(str5);
                    this.port = Companion.defaultPort(str5);
                }
                if (this.host != null) {
                    StringBuilder sb6 = new StringBuilder("Invalid URL host: \"");
                    String strSubstring5 = str.substring(i2, i4);
                    Intrinsics.checkNotNullExpressionValue(strSubstring5, str2);
                    sb6.append(strSubstring5);
                    sb6.append('\"');
                    throw new IllegalArgumentException(sb6.toString().toString());
                }
                iIndexOfFirstNonAsciiWhitespace = iDelimiterOffset;
            }
            int iDelimiterOffset3 = Util.delimiterOffset(iIndexOfFirstNonAsciiWhitespace, iIndexOfLastNonAsciiWhitespace, str, "?#");
            if (iIndexOfFirstNonAsciiWhitespace != iDelimiterOffset3) {
                char cCharAt5 = str.charAt(iIndexOfFirstNonAsciiWhitespace);
                if (cCharAt5 == '/' || cCharAt5 == '\\') {
                    arrayList2 = arrayList;
                    arrayList2.clear();
                    arrayList2.add("");
                    iIndexOfFirstNonAsciiWhitespace++;
                } else {
                    arrayList2 = arrayList;
                    arrayList2.set(arrayList.size() - 1, "");
                }
                while (iIndexOfFirstNonAsciiWhitespace < iDelimiterOffset3) {
                    int iDelimiterOffset4 = Util.delimiterOffset(iIndexOfFirstNonAsciiWhitespace, iDelimiterOffset3, str, "/\\");
                    boolean z6 = iDelimiterOffset4 < iDelimiterOffset3 ? true : z;
                    int i12 = iDelimiterOffset4;
                    String strCanonicalize$okhttp$default2 = Companion.canonicalize$okhttp$default(str, iIndexOfFirstNonAsciiWhitespace, iDelimiterOffset4, " \"<>^`{}|/\\?#", true, false, false, false, 240);
                    if (!strCanonicalize$okhttp$default2.equals(".") && !strCanonicalize$okhttp$default2.equalsIgnoreCase("%2e")) {
                        if (!strCanonicalize$okhttp$default2.equals("..") && !strCanonicalize$okhttp$default2.equalsIgnoreCase("%2e.") && !strCanonicalize$okhttp$default2.equalsIgnoreCase(".%2e") && !strCanonicalize$okhttp$default2.equalsIgnoreCase("%2e%2e")) {
                            if (((CharSequence) arrayList2.get(arrayList2.size() - 1)).length() == 0) {
                                arrayList2.set(arrayList2.size() - 1, strCanonicalize$okhttp$default2);
                            } else {
                                arrayList2.add(strCanonicalize$okhttp$default2);
                            }
                            if (z6) {
                                arrayList2.add("");
                            }
                        } else if (((String) arrayList2.remove(arrayList2.size() - 1)).length() != 0 || arrayList2.isEmpty()) {
                            arrayList2.add("");
                        } else {
                            arrayList2.set(arrayList2.size() - 1, "");
                        }
                    }
                    if (z6) {
                        i12++;
                    }
                    iIndexOfFirstNonAsciiWhitespace = i12;
                }
            }
            if (iDelimiterOffset3 < iIndexOfLastNonAsciiWhitespace && str.charAt(iDelimiterOffset3) == '?') {
                int iDelimiterOffset5 = Util.delimiterOffset(str, '#', iDelimiterOffset3, iIndexOfLastNonAsciiWhitespace);
                this.encodedQueryNamesAndValues = Companion.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(str, iDelimiterOffset3 + 1, iDelimiterOffset5, " \"'<>#", true, false, true, false, 208));
                iDelimiterOffset3 = iDelimiterOffset5;
            }
            if (iDelimiterOffset3 >= iIndexOfLastNonAsciiWhitespace || str.charAt(iDelimiterOffset3) != '#') {
                return;
            }
            this.encodedFragment = Companion.canonicalize$okhttp$default(str, iDelimiterOffset3 + 1, iIndexOfLastNonAsciiWhitespace, "", true, false, false, true, 176);
        }
    }

    public final class Companion {
        public static final Companion NONE = new Companion();
        public static final Companion NO_COOKIES = new Companion();
        public static final Companion SYSTEM = new Companion();

        public static final CipherSuite access$init(Companion companion, String str) {
            CipherSuite cipherSuite = new CipherSuite(str);
            CipherSuite.INSTANCES.put(str, cipherSuite);
            return cipherSuite;
        }

        public static String canonicalize$okhttp$default(String canonicalize, int i, int i2, String str, boolean z, boolean z2, boolean z3, boolean z4, int i3) {
            int i4 = (i3 & 1) != 0 ? 0 : i;
            int length = (i3 & 2) != 0 ? canonicalize.length() : i2;
            boolean z5 = (i3 & 8) != 0 ? false : z;
            boolean z6 = (i3 & 16) != 0 ? false : z2;
            boolean z7 = (i3 & 32) != 0 ? false : z3;
            boolean z8 = (i3 & 64) == 0 ? z4 : false;
            Intrinsics.checkNotNullParameter(canonicalize, "$this$canonicalize");
            int iCharCount = i4;
            while (iCharCount < length) {
                int iCodePointAt = canonicalize.codePointAt(iCharCount);
                int i5 = 32;
                int i6 = 128;
                if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z8) || StringsKt__StringsKt.contains$default(str, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z5 || (z6 && !isPercentEncoded(iCharCount, length, canonicalize)))) || (iCodePointAt == 43 && z7)))) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(i4, iCharCount, canonicalize);
                    Buffer buffer2 = null;
                    while (iCharCount < length) {
                        int iCodePointAt2 = canonicalize.codePointAt(iCharCount);
                        if (!z5 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                            if (iCodePointAt2 == 43 && z7) {
                                buffer.m124writeUtf8(z5 ? "+" : "%2B");
                            } else if (iCodePointAt2 < i5 || iCodePointAt2 == 127 || ((iCodePointAt2 >= i6 && !z8) || StringsKt__StringsKt.contains$default(str, (char) iCodePointAt2) || (iCodePointAt2 == 37 && (!z5 || (z6 && !isPercentEncoded(iCharCount, length, canonicalize)))))) {
                                if (buffer2 == null) {
                                    buffer2 = new Buffer();
                                }
                                buffer2.writeUtf8CodePoint(iCodePointAt2);
                                while (!buffer2.exhausted()) {
                                    byte b = buffer2.readByte();
                                    buffer.writeByte(37);
                                    char[] cArr = HttpUrl.HEX_DIGITS;
                                    buffer.writeByte(cArr[((b & 255) >> 4) & 15]);
                                    buffer.writeByte(cArr[b & 15]);
                                }
                            } else {
                                buffer.writeUtf8CodePoint(iCodePointAt2);
                            }
                        }
                        iCharCount += Character.charCount(iCodePointAt2);
                        i5 = 32;
                        i6 = 128;
                    }
                    return buffer.readString(buffer.size, Charsets.UTF_8);
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            String strSubstring = canonicalize.substring(i4, length);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring;
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [okhttp3.RequestBody$Companion$toRequestBody$2] */
        public static RequestBody$Companion$toRequestBody$2 create$default(final byte[] toRequestBody, final MediaType mediaType, int i) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            final int length = toRequestBody.length;
            Intrinsics.checkNotNullParameter(toRequestBody, "$this$toRequestBody");
            long length2 = toRequestBody.length;
            final int i2 = 0;
            long j = 0;
            long j2 = length;
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            if ((j | j2) < 0 || j > length2 || length2 - j < j2) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public final long contentLength() {
                    return length;
                }

                @Override // okhttp3.RequestBody
                public final MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public final void writeTo(RealBufferedSink realBufferedSink) {
                    byte[] source = toRequestBody;
                    Intrinsics.checkNotNullParameter(source, "source");
                    if (realBufferedSink.closed) {
                        throw new IllegalStateException("closed");
                    }
                    realBufferedSink.bufferField.write(source, i2, length);
                    realBufferedSink.emitCompleteSegments();
                }
            };
        }

        public static int defaultPort(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            int iHashCode = scheme.hashCode();
            if (iHashCode != 3213448) {
                if (iHashCode == 99617003 && scheme.equals("https")) {
                    return 443;
                }
            } else if (scheme.equals("http")) {
                return 80;
            }
            return -1;
        }

        public static boolean isPercentEncoded(int i, int i2, String str) {
            int i3 = i + 2;
            return i3 < i2 && str.charAt(i) == '%' && Util.parseHexDigit(str.charAt(i + 1)) != -1 && Util.parseHexDigit(str.charAt(i3)) != -1;
        }

        public static String percentDecode$okhttp$default(String percentDecode, int i, int i2, int i3, boolean z) {
            int i4;
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = percentDecode.length();
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            Intrinsics.checkNotNullParameter(percentDecode, "$this$percentDecode");
            int iCharCount = i;
            while (iCharCount < i2) {
                char cCharAt = percentDecode.charAt(iCharCount);
                if (cCharAt == '%' || (cCharAt == '+' && z)) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(i, iCharCount, percentDecode);
                    while (iCharCount < i2) {
                        int iCodePointAt = percentDecode.codePointAt(iCharCount);
                        if (iCodePointAt == 37 && (i4 = iCharCount + 2) < i2) {
                            int hexDigit = Util.parseHexDigit(percentDecode.charAt(iCharCount + 1));
                            int hexDigit2 = Util.parseHexDigit(percentDecode.charAt(i4));
                            if (hexDigit == -1 || hexDigit2 == -1) {
                                buffer.writeUtf8CodePoint(iCodePointAt);
                                iCharCount += Character.charCount(iCodePointAt);
                            } else {
                                buffer.writeByte((hexDigit << 4) + hexDigit2);
                                iCharCount = Character.charCount(iCodePointAt) + i4;
                            }
                        } else if (iCodePointAt == 43 && z) {
                            buffer.writeByte(32);
                            iCharCount++;
                        } else {
                            buffer.writeUtf8CodePoint(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        }
                    }
                    return buffer.readString(buffer.size, Charsets.UTF_8);
                }
                iCharCount++;
            }
            String strSubstring = percentDecode.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public static ArrayList toQueryNamesAndValues$okhttp(String str) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '&', i, false, 4);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = str.length();
                }
                int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, '=', i, false, 4);
                if (iIndexOf$default2 == -1 || iIndexOf$default2 > iIndexOf$default) {
                    String strSubstring = str.substring(i, iIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str.substring(i, iIndexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str.substring(iIndexOf$default2 + 1, iIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i = iIndexOf$default + 1;
            }
            return arrayList;
        }

        public synchronized CipherSuite forJavaName(String javaName) {
            CipherSuite cipherSuite;
            String strConcat;
            try {
                Intrinsics.checkNotNullParameter(javaName, "javaName");
                LinkedHashMap linkedHashMap = CipherSuite.INSTANCES;
                cipherSuite = (CipherSuite) linkedHashMap.get(javaName);
                if (cipherSuite == null) {
                    if (StringsKt__StringsKt.startsWith(javaName, "TLS_", false)) {
                        String strSubstring = javaName.substring(4);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                        strConcat = "SSL_".concat(strSubstring);
                    } else if (StringsKt__StringsKt.startsWith(javaName, "SSL_", false)) {
                        String strSubstring2 = javaName.substring(4);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                        strConcat = "TLS_".concat(strSubstring2);
                    } else {
                        strConcat = javaName;
                    }
                    cipherSuite = (CipherSuite) linkedHashMap.get(strConcat);
                    if (cipherSuite == null) {
                        cipherSuite = new CipherSuite(javaName);
                    }
                    linkedHashMap.put(javaName, cipherSuite);
                }
            } catch (Throwable th) {
                throw th;
            }
            return cipherSuite;
        }
    }

    public HttpUrl(String scheme, String str, String str2, String host, int i, ArrayList arrayList, ArrayList arrayList2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(host, "host");
        this.scheme = scheme;
        this.username = str;
        this.password = str2;
        this.host = host;
        this.port = i;
        this.queryNamesAndValues = arrayList2;
        this.fragment = str3;
        this.url = str4;
        this.isHttps = scheme.equals("https");
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String strSubstring = str.substring(StringsKt__StringsKt.indexOf$default((CharSequence) str, ':', length, false, 4) + 1, StringsKt__StringsKt.indexOf$default((CharSequence) str, '@', 0, false, 6));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String encodedPath() {
        int length = this.scheme.length() + 3;
        String str = this.url;
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '/', length, false, 4);
        String strSubstring = str.substring(iIndexOf$default, Util.delimiterOffset(iIndexOf$default, str.length(), str, "?#"));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final ArrayList encodedPathSegments() {
        int length = this.scheme.length() + 3;
        String str = this.url;
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '/', length, false, 4);
        int iDelimiterOffset = Util.delimiterOffset(iIndexOf$default, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf$default < iDelimiterOffset) {
            int i = iIndexOf$default + 1;
            int iDelimiterOffset2 = Util.delimiterOffset(str, '/', i, iDelimiterOffset);
            String strSubstring = str.substring(i, iDelimiterOffset2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iIndexOf$default = iDelimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        String str = this.url;
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '?', 0, false, 6) + 1;
        String strSubstring = str.substring(iIndexOf$default, Util.delimiterOffset(str, '#', iIndexOf$default, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        int iDelimiterOffset = Util.delimiterOffset(length, str.length(), str, ":@");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(length, iDelimiterOffset);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && Intrinsics.areEqual(((HttpUrl) obj).url, this.url);
    }

    public final int hashCode() {
        return this.url.hashCode();
    }

    public final String toString() {
        return this.url;
    }

    public final URI uri() {
        String strSubstring;
        String strReplaceAll;
        Builder builder = new Builder();
        String str = this.scheme;
        builder.scheme = str;
        builder.encodedUsername = encodedUsername();
        builder.encodedPassword = encodedPassword();
        builder.host = this.host;
        int iDefaultPort = Companion.defaultPort(str);
        int i = this.port;
        if (i == iDefaultPort) {
            i = -1;
        }
        builder.port = i;
        ArrayList arrayList = builder.encodedPathSegments;
        arrayList.clear();
        arrayList.addAll(encodedPathSegments());
        String strEncodedQuery = encodedQuery();
        builder.encodedQueryNamesAndValues = strEncodedQuery != null ? Companion.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(strEncodedQuery, 0, 0, " \"'<>#", true, false, true, false, 211)) : null;
        if (this.fragment == null) {
            strSubstring = null;
        } else {
            String str2 = this.url;
            strSubstring = str2.substring(StringsKt__StringsKt.indexOf$default((CharSequence) str2, '#', 0, false, 6) + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        }
        builder.encodedFragment = strSubstring;
        String str3 = builder.host;
        if (str3 != null) {
            Pattern patternCompile = Pattern.compile("[\"<>^`{|}]");
            Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern)");
            strReplaceAll = patternCompile.matcher(str3).replaceAll("");
            Intrinsics.checkNotNullExpressionValue(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        } else {
            strReplaceAll = null;
        }
        builder.host = strReplaceAll;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.set(i2, Companion.canonicalize$okhttp$default((String) arrayList.get(i2), 0, 0, "[]", true, true, false, false, 227));
        }
        ArrayList arrayList2 = builder.encodedQueryNamesAndValues;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                String str4 = (String) arrayList2.get(i3);
                arrayList2.set(i3, str4 != null ? Companion.canonicalize$okhttp$default(str4, 0, 0, "\\^`{|}", true, true, true, false, 195) : null);
            }
        }
        String str5 = builder.encodedFragment;
        builder.encodedFragment = str5 != null ? Companion.canonicalize$okhttp$default(str5, 0, 0, " \"#<>\\^`{|}", true, true, false, true, 163) : null;
        String string = builder.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                Pattern patternCompile2 = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                Intrinsics.checkNotNullExpressionValue(patternCompile2, "compile(pattern)");
                String strReplaceAll2 = patternCompile2.matcher(string).replaceAll("");
                Intrinsics.checkNotNullExpressionValue(strReplaceAll2, "nativePattern.matcher(in…).replaceAll(replacement)");
                URI uriCreate = URI.create(strReplaceAll2);
                Intrinsics.checkNotNullExpressionValue(uriCreate, "try {\n        val stripp…e) // Unexpected!\n      }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }
}
