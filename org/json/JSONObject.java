package org.json;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import com.google.firebase.inject.PVS.jIKWv;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.ByteString;
import okio.internal.ByteStringKt;

/* JADX INFO: loaded from: classes3.dex */
public class JSONObject {
    public static final Object NULL = new Null();
    private Map map;

    public final class Null {
        public final /* synthetic */ int $r8$classId = 0;

        /* JADX WARN: Code duplicated, block: B:29:0x005e  */
        public static final String access$binarySearch(byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            boolean z;
            int i3;
            int i4;
            int i5 = -1;
            byte[] bArr3 = PublicSuffixDatabase.WILDCARD_LABEL;
            int length = bArr.length;
            int i6 = 0;
            while (i6 < length) {
                int i7 = (i6 + length) / 2;
                while (i7 > i5 && bArr[i7] != ((byte) 10)) {
                    i7 += i5;
                }
                int i8 = i7 + 1;
                int i9 = 1;
                while (true) {
                    i2 = i8 + i9;
                    if (bArr[i2] == ((byte) 10)) {
                        break;
                    }
                    i9++;
                }
                int i10 = i2 - i8;
                int i11 = i;
                boolean z2 = false;
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    if (z2) {
                        i3 = 46;
                        z = false;
                    } else {
                        byte b = bArr2[i11][i12];
                        byte[] bArr4 = Util.EMPTY_BYTE_ARRAY;
                        int i14 = b & 255;
                        z = z2;
                        i3 = i14;
                    }
                    byte b2 = bArr[i8 + i13];
                    byte[] bArr5 = Util.EMPTY_BYTE_ARRAY;
                    i4 = i3 - (b2 & 255);
                    if (i4 != 0) {
                        break;
                    }
                    i13++;
                    i12++;
                    if (i13 == i10) {
                        break;
                    }
                    if (bArr2[i11].length != i12) {
                        z2 = z;
                    } else {
                        if (i11 == bArr2.length - 1) {
                            break;
                        }
                        i11++;
                        z2 = true;
                        i12 = -1;
                    }
                }
                if (i4 >= 0) {
                    if (i4 <= 0) {
                        int i15 = i10 - i13;
                        int length2 = bArr2[i11].length - i12;
                        int length3 = bArr2.length;
                        for (int i16 = i11 + 1; i16 < length3; i16++) {
                            length2 += bArr2[i16].length;
                        }
                        if (length2 < i15) {
                            length = i7;
                        } else if (length2 <= i15) {
                            Charset UTF_8 = StandardCharsets.UTF_8;
                            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                            return new String(bArr, i8, i10, UTF_8);
                        }
                    }
                    i6 = i2 + 1;
                } else {
                    length = i7;
                }
                i5 = -1;
            }
            return null;
        }

        public static ByteString decodeHex(String str) {
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (ByteStringKt.access$decodeHexDigit(str.charAt(i2 + 1)) + (ByteStringKt.access$decodeHexDigit(str.charAt(i2)) << 4));
            }
            return new ByteString(bArr);
        }

        public Object clone() {
            switch (this.$r8$classId) {
                case 0:
                    return this;
                default:
                    return super.clone();
            }
        }

        public boolean equals(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    return obj == null || obj == this;
                default:
                    return super.equals(obj);
            }
        }

        public String toString() {
            switch (this.$r8$classId) {
                case 0:
                    return "null";
                default:
                    return super.toString();
            }
        }

        public static ByteString encodeUtf8(String encodeUtf8) {
            Intrinsics.checkNotNullParameter(encodeUtf8, "$this$encodeUtf8");
            byte[] bytes = encodeUtf8.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, eoBKjVuj.YvhkPaGcCCkdAFt);
            ByteString byteString = new ByteString(bytes);
            byteString.utf8 = encodeUtf8;
            return byteString;
        }
    }

    public JSONObject() {
        this.map = new HashMap();
    }

    public static String doubleToString(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            return "null";
        }
        String string = Double.toString(d);
        if (string.indexOf(46) <= 0 || string.indexOf(101) >= 0 || string.indexOf(69) >= 0) {
            return string;
        }
        while (string.endsWith("0")) {
            string = string.substring(0, string.length() - 1);
        }
        return string.endsWith(".") ? string.substring(0, string.length() - 1) : string;
    }

    public static String[] getNames(JSONObject jSONObject) {
        int length = jSONObject.length();
        if (length == 0) {
            return null;
        }
        Iterator itKeys = jSONObject.keys();
        String[] strArr = new String[length];
        int i = 0;
        while (itKeys.hasNext()) {
            strArr[i] = (String) itKeys.next();
            i++;
        }
        return strArr;
    }

    public static String numberToString(Number number) throws JSONException {
        if (number == null) {
            throw new JSONException("Null pointer");
        }
        testValidity(number);
        String string = number.toString();
        if (string.indexOf(46) <= 0 || string.indexOf(101) >= 0 || string.indexOf(69) >= 0) {
            return string;
        }
        while (string.endsWith("0")) {
            string = string.substring(0, string.length() - 1);
        }
        return string.endsWith(".") ? string.substring(0, string.length() - 1) : string;
    }

    private void populateMap(Object obj) {
        Class<?> cls = obj.getClass();
        for (Method method : cls.getClassLoader() != null ? cls.getMethods() : cls.getDeclaredMethods()) {
            try {
                if (Modifier.isPublic(method.getModifiers())) {
                    String name = method.getName();
                    String strSubstring = "";
                    if (name.startsWith("get")) {
                        if (!name.equals("getClass") && !name.equals("getDeclaringClass")) {
                            strSubstring = name.substring(3);
                        }
                    } else if (name.startsWith("is")) {
                        strSubstring = name.substring(2);
                    }
                    if (strSubstring.length() > 0 && Character.isUpperCase(strSubstring.charAt(0)) && method.getParameterTypes().length == 0) {
                        if (strSubstring.length() == 1) {
                            strSubstring = strSubstring.toLowerCase();
                        } else if (!Character.isUpperCase(strSubstring.charAt(1))) {
                            strSubstring = strSubstring.substring(0, 1).toLowerCase() + strSubstring.substring(1);
                        }
                        Object objInvoke = method.invoke(obj, null);
                        if (objInvoke != null) {
                            this.map.put(strSubstring, wrap(objInvoke));
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x009b  */
    public static String quote(String str) {
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 4);
        stringBuffer.append('\"');
        int i = 0;
        char c = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\f') {
                stringBuffer.append("\\f");
            } else if (cCharAt == '\r') {
                stringBuffer.append("\\r");
            } else if (cCharAt == '\"') {
                stringBuffer.append('\\');
                stringBuffer.append(cCharAt);
            } else if (cCharAt == '/') {
                if (c == '<') {
                    stringBuffer.append('\\');
                }
                stringBuffer.append(cCharAt);
            } else if (cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                        stringBuffer.append("\\b");
                        break;
                    case '\t':
                        stringBuffer.append("\\t");
                        break;
                    case '\n':
                        stringBuffer.append("\\n");
                        break;
                    default:
                        if (cCharAt >= ' ' && ((cCharAt < 128 || cCharAt >= 160) && (cCharAt < 8192 || cCharAt >= 8448))) {
                            stringBuffer.append(cCharAt);
                        } else {
                            String str2 = "000" + Integer.toHexString(cCharAt);
                            stringBuffer.append("\\u" + str2.substring(str2.length() - 4));
                        }
                        break;
                }
            } else {
                stringBuffer.append('\\');
                stringBuffer.append(cCharAt);
            }
            i++;
            c = cCharAt;
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    public static Object stringToValue(String str) {
        if (str.equals("")) {
            return str;
        }
        if (str.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        }
        if (str.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        }
        if (str.equalsIgnoreCase("null")) {
            return NULL;
        }
        char cCharAt = str.charAt(0);
        if ((cCharAt < '0' || cCharAt > '9') && cCharAt != '.' && cCharAt != '-' && cCharAt != '+') {
            return str;
        }
        if (cCharAt == '0' && str.length() > 2 && (str.charAt(1) == 'x' || str.charAt(1) == 'X')) {
            try {
                return new Integer(Integer.parseInt(str.substring(2), 16));
            } catch (Exception unused) {
            }
        }
        try {
            if (str.indexOf(46) <= -1 && str.indexOf(101) <= -1 && str.indexOf(69) <= -1) {
                Long l = new Long(str);
                return l.longValue() == ((long) l.intValue()) ? new Integer(l.intValue()) : l;
            }
            return Double.valueOf(str);
        } catch (Exception unused2) {
            return str;
        }
    }

    public static void testValidity(Object obj) throws JSONException {
        if (obj != null) {
            if (obj instanceof Double) {
                Double d = (Double) obj;
                if (d.isInfinite() || d.isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
                return;
            }
            if (obj instanceof Float) {
                Float f = (Float) obj;
                if (f.isInfinite() || f.isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
            }
        }
    }

    public static String valueToString(Object obj) {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (obj instanceof Number) {
            return numberToString((Number) obj);
        }
        if ((obj instanceof Boolean) || (obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return obj.toString();
        }
        if (obj instanceof Map) {
            return new JSONObject((Map) obj).toString();
        }
        if (obj instanceof Collection) {
            return new JSONArray((Collection) obj).toString();
        }
        return obj.getClass().isArray() ? new JSONArray(obj).toString() : quote(obj.toString());
    }

    public static Object wrap(Object obj) {
        try {
            if (obj == null) {
                return NULL;
            }
            if (!(obj instanceof JSONObject) && !(obj instanceof JSONArray) && !NULL.equals(obj) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Short) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Boolean) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof String)) {
                if (obj instanceof Collection) {
                    return new JSONArray((Collection) obj);
                }
                if (obj.getClass().isArray()) {
                    return new JSONArray(obj);
                }
                if (obj instanceof Map) {
                    return new JSONObject((Map) obj);
                }
                Package r0 = obj.getClass().getPackage();
                String name = r0 != null ? r0.getName() : "";
                if (!name.startsWith("java.") && !name.startsWith("javax.") && obj.getClass().getClassLoader() != null) {
                    return new JSONObject(obj);
                }
                return obj.toString();
            }
            return obj;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject accumulate(String str, Object obj) throws JSONException {
        testValidity(obj);
        Object objOpt = opt(str);
        if (objOpt == null) {
            if (obj instanceof JSONArray) {
                obj = new JSONArray().put(obj);
            }
            put(str, obj);
        } else if (objOpt instanceof JSONArray) {
            ((JSONArray) objOpt).put(obj);
        } else {
            put(str, new JSONArray().put(objOpt).put(obj));
        }
        return this;
    }

    public JSONObject append(String str, Object obj) throws JSONException {
        testValidity(obj);
        Object objOpt = opt(str);
        if (objOpt == null) {
            put(str, new JSONArray().put(obj));
        } else {
            if (!(objOpt instanceof JSONArray)) {
                throw new JSONException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("JSONObject[", str, "] is not a JSONArray."));
            }
            put(str, ((JSONArray) objOpt).put(obj));
        }
        return this;
    }

    public Object get(String str) throws JSONException {
        if (str == null) {
            throw new JSONException("Null key.");
        }
        Object objOpt = opt(str);
        if (objOpt != null) {
            return objOpt;
        }
        throw new JSONException("JSONObject[" + quote(str) + "] not found.");
    }

    public boolean getBoolean(String str) throws JSONException {
        Object obj = get(str);
        if (obj.equals(Boolean.FALSE)) {
            return false;
        }
        boolean z = obj instanceof String;
        if (z && ((String) obj).equalsIgnoreCase("false")) {
            return false;
        }
        if (obj.equals(Boolean.TRUE)) {
            return true;
        }
        if (z && ((String) obj).equalsIgnoreCase("true")) {
            return true;
        }
        throw new JSONException("JSONObject[" + quote(str) + "] is not a Boolean.");
    }

    public double getDouble(String str) throws JSONException {
        Object obj = get(str);
        try {
            return obj instanceof Number ? ((Number) obj).doubleValue() : Double.parseDouble((String) obj);
        } catch (Exception unused) {
            throw new JSONException("JSONObject[" + quote(str) + "] is not a number.");
        }
    }

    public int getInt(String str) {
        Object obj = get(str);
        try {
            return obj instanceof Number ? ((Number) obj).intValue() : Integer.parseInt((String) obj);
        } catch (Exception unused) {
            throw new JSONException("JSONObject[" + quote(str) + "] is not an int.");
        }
    }

    public JSONObject getJSONObject(String str) throws JSONException {
        Object obj = get(str);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw new JSONException("JSONObject[" + quote(str) + "] is not a JSONObject.");
    }

    public long getLong(String str) throws JSONException {
        Object obj = get(str);
        try {
            return obj instanceof Number ? ((Number) obj).longValue() : Long.parseLong((String) obj);
        } catch (Exception unused) {
            throw new JSONException("JSONObject[" + quote(str) + "] is not a long.");
        }
    }

    public String getString(String str) {
        Object obj = get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new JSONException("JSONObject[" + quote(str) + "] not a string.");
    }

    public boolean has(String str) {
        return this.map.containsKey(str);
    }

    public JSONObject increment(String str) throws JSONException {
        Object objOpt = opt(str);
        if (objOpt == null) {
            put(str, 1);
        } else if (objOpt instanceof Integer) {
            put(str, ((Integer) objOpt).intValue() + 1);
        } else if (objOpt instanceof Long) {
            put(str, ((Long) objOpt).longValue() + 1);
        } else if (objOpt instanceof Double) {
            put(str, ((Double) objOpt).doubleValue() + 1.0d);
        } else {
            if (!(objOpt instanceof Float)) {
                throw new JSONException("Unable to increment [" + quote(str) + "].");
            }
            put(str, ((Float) objOpt).floatValue() + 1.0f);
        }
        return this;
    }

    public boolean isNull(String str) {
        return NULL.equals(opt(str));
    }

    public Iterator keys() {
        return this.map.keySet().iterator();
    }

    public int length() {
        return this.map.size();
    }

    public JSONArray names() {
        JSONArray jSONArray = new JSONArray();
        Iterator itKeys = keys();
        while (itKeys.hasNext()) {
            jSONArray.put(itKeys.next());
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray;
    }

    public Object opt(String str) {
        if (str == null) {
            return null;
        }
        return this.map.get(str);
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public double optDouble(String str) {
        return optDouble(str, Double.NaN);
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public JSONArray optJSONArray(String str) {
        Object objOpt = opt(str);
        if (objOpt instanceof JSONArray) {
            return (JSONArray) objOpt;
        }
        return null;
    }

    public JSONObject optJSONObject(String str) {
        Object objOpt = opt(str);
        if (objOpt instanceof JSONObject) {
            return (JSONObject) objOpt;
        }
        return null;
    }

    public long optLong(String str) {
        return optLong(str, 0L);
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public JSONObject put(String str, boolean z) {
        put(str, z ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }

    public JSONObject putOnce(String str, Object obj) throws JSONException {
        if (str != null && obj != null) {
            if (opt(str) != null) {
                throw new JSONException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Duplicate key \"", str, "\""));
            }
            put(str, obj);
        }
        return this;
    }

    public JSONObject putOpt(String str, Object obj) {
        if (str != null && obj != null) {
            put(str, obj);
        }
        return this;
    }

    public Object remove(String str) {
        return this.map.remove(str);
    }

    public JSONArray toJSONArray(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            jSONArray2.put(opt(jSONArray.getString(i)));
        }
        return jSONArray2;
    }

    public String toString() {
        try {
            Iterator itKeys = keys();
            StringBuffer stringBuffer = new StringBuffer("{");
            while (itKeys.hasNext()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                Object next = itKeys.next();
                stringBuffer.append(quote(next.toString()));
                stringBuffer.append(':');
                stringBuffer.append(valueToString(this.map.get(next)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public Writer write(Writer writer) throws JSONException {
        try {
            Iterator itKeys = keys();
            writer.write(123);
            boolean z = false;
            while (itKeys.hasNext()) {
                if (z) {
                    writer.write(44);
                }
                Object next = itKeys.next();
                writer.write(quote(next.toString()));
                writer.write(58);
                Object obj = this.map.get(next);
                if (obj instanceof JSONObject) {
                    ((JSONObject) obj).write(writer);
                } else if (obj instanceof JSONArray) {
                    ((JSONArray) obj).write(writer);
                } else {
                    writer.write(valueToString(obj));
                }
                z = true;
            }
            writer.write(125);
            return writer;
        } catch (IOException e) {
            JSONException jSONException = new JSONException(e.getMessage());
            jSONException.cause = e;
            throw jSONException;
        }
    }

    public boolean optBoolean(String str, boolean z) {
        try {
            return getBoolean(str);
        } catch (Exception unused) {
            return z;
        }
    }

    public double optDouble(String str, double d) {
        try {
            return getDouble(str);
        } catch (Exception unused) {
            return d;
        }
    }

    public int optInt(String str, int i) {
        try {
            return getInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public long optLong(String str, long j) {
        try {
            return getLong(str);
        } catch (Exception unused) {
            return j;
        }
    }

    public String optString(String str, String str2) {
        Object objOpt = opt(str);
        return NULL.equals(objOpt) ? str2 : objOpt.toString();
    }

    public JSONObject put(String str, Collection collection) {
        put(str, new JSONArray(collection));
        return this;
    }

    public JSONObject(JSONObject jSONObject, String[] strArr) {
        this();
        for (String str : strArr) {
            try {
                putOnce(str, jSONObject.opt(str));
            } catch (Exception unused) {
            }
        }
    }

    public JSONArray getJSONArray(String str) {
        Object obj = get(str);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw new JSONException(GsPcpBmONXh.RwkOJJ + quote(str) + "] is not a JSONArray.");
    }

    public JSONObject put(String str, double d) {
        put(str, new Double(d));
        return this;
    }

    public JSONObject put(String str, int i) {
        put(str, new Integer(i));
        return this;
    }

    public JSONObject put(String str, long j) {
        put(str, new Long(j));
        return this;
    }

    public JSONObject(JSONTokener jSONTokener) throws JSONException {
        this();
        if (jSONTokener.nextClean() != '{') {
            throw jSONTokener.syntaxError("A JSONObject text must begin with '{'");
        }
        while (true) {
            char cNextClean = jSONTokener.nextClean();
            if (cNextClean == 0) {
                throw jSONTokener.syntaxError("A JSONObject text must end with '}'");
            }
            if (cNextClean == '}') {
                return;
            }
            jSONTokener.back();
            String string = jSONTokener.nextValue().toString();
            char cNextClean2 = jSONTokener.nextClean();
            if (cNextClean2 == '=') {
                if (jSONTokener.next() != '>') {
                    jSONTokener.back();
                }
            } else if (cNextClean2 != ':') {
                throw jSONTokener.syntaxError("Expected a ':' after a key");
            }
            putOnce(string, jSONTokener.nextValue());
            char cNextClean3 = jSONTokener.nextClean();
            if (cNextClean3 != ',' && cNextClean3 != ';') {
                if (cNextClean3 != '}') {
                    throw jSONTokener.syntaxError("Expected a ',' or '}'");
                }
                return;
            } else if (jSONTokener.nextClean() == '}') {
                return;
            } else {
                jSONTokener.back();
            }
        }
    }

    public static String[] getNames(Object obj) {
        Field[] fields;
        int length;
        if (obj == null || (length = (fields = obj.getClass().getFields()).length) == 0) {
            return null;
        }
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = fields[i].getName();
        }
        return strArr;
    }

    public JSONObject put(String str, Map map) {
        put(str, new JSONObject(map));
        return this;
    }

    public JSONObject put(String str, Object obj) {
        if (str == null) {
            throw new JSONException("Null key.");
        }
        if (obj != null) {
            testValidity(obj);
            this.map.put(str, obj);
        } else {
            remove(str);
        }
        return this;
    }

    public String toString(int i) {
        return toString(i, 0);
    }

    public String toString(int i, int i2) {
        int i3;
        int length = length();
        if (length == 0) {
            return "{}";
        }
        Iterator itKeys = keys();
        int i4 = i2 + i;
        StringBuffer stringBuffer = new StringBuffer("{");
        if (length == 1) {
            Object next = itKeys.next();
            stringBuffer.append(quote(next.toString()));
            stringBuffer.append(": ");
            stringBuffer.append(valueToString(this.map.get(next), i, i2));
        } else {
            while (true) {
                i3 = 0;
                if (!itKeys.hasNext()) {
                    break;
                }
                Object next2 = itKeys.next();
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(",\n");
                } else {
                    stringBuffer.append('\n');
                }
                while (i3 < i4) {
                    stringBuffer.append(' ');
                    i3++;
                }
                stringBuffer.append(quote(next2.toString()));
                stringBuffer.append(": ");
                stringBuffer.append(valueToString(this.map.get(next2), i, i4));
            }
            if (stringBuffer.length() > 1) {
                stringBuffer.append('\n');
                while (i3 < i2) {
                    stringBuffer.append(' ');
                    i3++;
                }
            }
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public static String valueToString(Object obj, int i, int i2) {
        if (obj != null && !obj.equals(null)) {
            if (obj instanceof Number) {
                return numberToString((Number) obj);
            }
            if (obj instanceof Boolean) {
                return obj.toString();
            }
            if (obj instanceof JSONObject) {
                return ((JSONObject) obj).toString(i, i2);
            }
            if (obj instanceof JSONArray) {
                return ((JSONArray) obj).toString(i, i2);
            }
            if (obj instanceof Map) {
                return new JSONObject((Map) obj).toString(i, i2);
            }
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj).toString(i, i2);
            }
            if (obj.getClass().isArray()) {
                return new JSONArray(obj).toString(i, i2);
            }
            return quote(obj.toString());
        }
        return "null";
    }

    public JSONObject(Map map) {
        this.map = new HashMap();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    this.map.put(entry.getKey(), wrap(value));
                }
            }
        }
    }

    public JSONObject(Object obj) {
        this();
        populateMap(obj);
    }

    public JSONObject(Object obj, String[] strArr) {
        this();
        Class<?> cls = obj.getClass();
        for (String str : strArr) {
            try {
                putOpt(str, cls.getField(str).get(obj));
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject(String str) {
        this(new JSONTokener(str));
    }

    public JSONObject(String str, Locale locale) {
        this();
        ResourceBundle bundle = ResourceBundle.getBundle(str, locale, Thread.currentThread().getContextClassLoader());
        Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String strNextElement = keys.nextElement();
            if (strNextElement instanceof String) {
                String str2 = strNextElement;
                String[] strArrSplit = str2.split(jIKWv.VqdrBZxz);
                int length = strArrSplit.length - 1;
                JSONObject jSONObject = this;
                for (int i = 0; i < length; i++) {
                    String str3 = strArrSplit[i];
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str3);
                    if (jSONObjectOptJSONObject == null) {
                        jSONObjectOptJSONObject = new JSONObject();
                        jSONObject.put(str3, jSONObjectOptJSONObject);
                    }
                    jSONObject = jSONObjectOptJSONObject;
                }
                jSONObject.put(strArrSplit[length], bundle.getString(str2));
            }
        }
    }
}
