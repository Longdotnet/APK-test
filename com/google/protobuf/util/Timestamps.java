package com.google.protobuf.util;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import okhttp3.Headers;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes3.dex */
public final class Timestamps {
    static final int MICROS_PER_SECOND = 1000000;
    static final int MILLIS_PER_SECOND = 1000;
    static final int NANOS_PER_MICROSECOND = 1000;
    static final int NANOS_PER_MILLISECOND = 1000000;
    static final int NANOS_PER_SECOND = 1000000000;
    static final long TIMESTAMP_SECONDS_MIN = -62135596800L;
    public static final Timestamp MIN_VALUE = Timestamp.newBuilder().setSeconds(TIMESTAMP_SECONDS_MIN).setNanos(0).build();
    static final long TIMESTAMP_SECONDS_MAX = 253402300799L;
    public static final Timestamp MAX_VALUE = Timestamp.newBuilder().setSeconds(TIMESTAMP_SECONDS_MAX).setNanos(999999999).build();
    public static final Timestamp EPOCH = Timestamp.newBuilder().setSeconds(0).setNanos(0).build();
    private static final ThreadLocal<SimpleDateFormat> timestampFormat = new ThreadLocal<SimpleDateFormat>() { // from class: com.google.protobuf.util.Timestamps.1
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return Timestamps.createTimestampFormat();
        }
    };
    private static final Method INSTANT_NOW = instantMethod("now");
    private static final Method INSTANT_GET_EPOCH_SECOND = instantMethod("getEpochSecond");
    private static final Method INSTANT_GET_NANO = instantMethod("getNano");

    public enum TimestampComparator implements Comparator<Timestamp>, Serializable {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Timestamp timestamp, Timestamp timestamp2) {
            Timestamps.checkValid(timestamp);
            Timestamps.checkValid(timestamp2);
            int iCompare = Long.compare(timestamp.getSeconds(), timestamp2.getSeconds());
            return iCompare != 0 ? iCompare : Integer.compare(timestamp.getNanos(), timestamp2.getNanos());
        }
    }

    private Timestamps() {
    }

    public static Timestamp add(Timestamp timestamp, Duration duration) {
        checkValid(timestamp);
        Durations.checkValid(duration);
        long jCheckedAdd = Headers.Companion.checkedAdd(timestamp.getSeconds(), duration.getSeconds());
        int nanos = timestamp.getNanos();
        int nanos2 = duration.getNanos();
        long j = ((long) nanos) + ((long) nanos2);
        int i = (int) j;
        MediaType.Companion.checkNoOverflow(j == ((long) i), "checkedAdd", nanos, nanos2);
        return normalizedTimestamp(jCheckedAdd, i);
    }

    public static Duration between(Timestamp timestamp, Timestamp timestamp2) {
        checkValid(timestamp);
        checkValid(timestamp2);
        return Durations.normalizedDuration(Headers.Companion.checkedSubtract(timestamp2.getSeconds(), timestamp.getSeconds()), GamepadHandler_API19.checkedSubtract(timestamp2.getNanos(), timestamp.getNanos()));
    }

    public static Timestamp checkValid(Timestamp timestamp) {
        long seconds = timestamp.getSeconds();
        int nanos = timestamp.getNanos();
        if (isValid(seconds, nanos)) {
            return timestamp;
        }
        throw new IllegalArgumentException("Timestamp is not valid. See proto definition for valid values. Seconds (" + seconds + ") must be in range [-62,135,596,800, +253,402,300,799]. Nanos (" + nanos + ") must be in range [0, +999,999,999].");
    }

    public static Comparator<Timestamp> comparator() {
        return TimestampComparator.INSTANCE;
    }

    public static int compare(Timestamp timestamp, Timestamp timestamp2) {
        return TimestampComparator.INSTANCE.compare(timestamp, timestamp2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SimpleDateFormat createTimestampFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        simpleDateFormat.setCalendar(gregorianCalendar);
        return simpleDateFormat;
    }

    public static String formatNanos(int i) {
        if (i % 1000000 == 0) {
            return String.format(Locale.ENGLISH, "%1$03d", Integer.valueOf(i / 1000000));
        }
        return i % 1000 == 0 ? String.format(Locale.ENGLISH, "%1$06d", Integer.valueOf(i / 1000)) : String.format(Locale.ENGLISH, "%1$09d", Integer.valueOf(i));
    }

    public static Timestamp fromDate(Date date) {
        if (!(date instanceof java.sql.Timestamp)) {
            return fromMillis(date.getTime());
        }
        java.sql.Timestamp timestamp = (java.sql.Timestamp) date;
        long time = timestamp.getTime();
        return Timestamp.newBuilder().setSeconds((time >= 0 || time % 1000 == 0) ? time / 1000 : (time / 1000) - 1).setNanos(timestamp.getNanos()).build();
    }

    public static Timestamp fromMicros(long j) {
        return normalizedTimestamp(j / 1000000, (int) ((j % 1000000) * 1000));
    }

    public static Timestamp fromMillis(long j) {
        return normalizedTimestamp(j / 1000, (int) ((j % 1000) * 1000000));
    }

    public static Timestamp fromNanos(long j) {
        return normalizedTimestamp(j / 1000000000, (int) (j % 1000000000));
    }

    public static Timestamp fromSeconds(long j) {
        return normalizedTimestamp(j, 0);
    }

    private static Method instantMethod(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isValid(Timestamp timestamp) {
        return isValid(timestamp.getSeconds(), timestamp.getNanos());
    }

    private static boolean isValidSeconds(long j) {
        return j >= TIMESTAMP_SECONDS_MIN && j <= TIMESTAMP_SECONDS_MAX;
    }

    public static Timestamp normalizedTimestamp(long j, int i) {
        if (!isValidSeconds(j)) {
            throw new IllegalArgumentException("Timestamp is not valid. Input seconds is too large. Seconds (" + j + ") must be in range [-62,135,596,800, +253,402,300,799]. ");
        }
        if (i <= -1000000000 || i >= NANOS_PER_SECOND) {
            j = Headers.Companion.checkedAdd(j, i / NANOS_PER_SECOND);
            i %= NANOS_PER_SECOND;
        }
        if (i < 0) {
            i += NANOS_PER_SECOND;
            j = Headers.Companion.checkedSubtract(j, 1L);
        }
        return checkValid(Timestamp.newBuilder().setSeconds(j).setNanos(i).build());
    }

    public static Timestamp now() {
        Method method = INSTANT_NOW;
        if (method == null) {
            return fromMillis(System.currentTimeMillis());
        }
        try {
            Object objInvoke = method.invoke(null, null);
            return normalizedTimestamp(((Long) INSTANT_GET_EPOCH_SECOND.invoke(objInvoke, null)).longValue(), ((Integer) INSTANT_GET_NANO.invoke(objInvoke, null)).intValue());
        } catch (Throwable th) {
            throw new AssertionError(th);
        }
    }

    public static int parseNanos(String str) throws ParseException {
        int iCharAt = 0;
        for (int i = 0; i < 9; i++) {
            iCharAt *= 10;
            if (i < str.length()) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    throw new ParseException("Invalid nanoseconds.", 0);
                }
                iCharAt = (str.charAt(i) - '0') + iCharAt;
            }
        }
        return iCharAt;
    }

    private static long parseTimezoneOffset(String str) throws ParseException {
        int iIndexOf = str.indexOf(58);
        if (iIndexOf == -1) {
            throw new ParseException("Invalid offset value: ".concat(str), 0);
        }
        try {
            return ((Long.parseLong(str.substring(0, iIndexOf)) * 60) + Long.parseLong(str.substring(iIndexOf + 1))) * 60;
        } catch (NumberFormatException e) {
            ParseException parseException = new ParseException("Invalid offset value: ".concat(str), 0);
            parseException.initCause(e);
            throw parseException;
        }
    }

    public static Timestamp parseUnchecked(String str) {
        try {
            return parse(str);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static Timestamp subtract(Timestamp timestamp, Duration duration) {
        checkValid(timestamp);
        Durations.checkValid(duration);
        return normalizedTimestamp(Headers.Companion.checkedSubtract(timestamp.getSeconds(), duration.getSeconds()), GamepadHandler_API19.checkedSubtract(timestamp.getNanos(), duration.getNanos()));
    }

    public static long toMicros(Timestamp timestamp) {
        checkValid(timestamp);
        return Headers.Companion.checkedAdd(Headers.Companion.checkedMultiply(timestamp.getSeconds(), 1000000L), timestamp.getNanos() / 1000);
    }

    public static long toMillis(Timestamp timestamp) {
        checkValid(timestamp);
        return Headers.Companion.checkedAdd(Headers.Companion.checkedMultiply(timestamp.getSeconds(), 1000L), timestamp.getNanos() / 1000000);
    }

    public static long toNanos(Timestamp timestamp) {
        checkValid(timestamp);
        return Headers.Companion.checkedAdd(Headers.Companion.checkedMultiply(timestamp.getSeconds(), 1000000000L), timestamp.getNanos());
    }

    public static long toSeconds(Timestamp timestamp) {
        return checkValid(timestamp).getSeconds();
    }

    public static String toString(Timestamp timestamp) {
        checkValid(timestamp);
        long seconds = timestamp.getSeconds();
        int nanos = timestamp.getNanos();
        StringBuilder sb = new StringBuilder();
        sb.append(timestampFormat.get().format(new Date(seconds * 1000)));
        if (nanos != 0) {
            sb.append(".");
            sb.append(formatNanos(nanos));
        }
        sb.append("Z");
        return sb.toString();
    }

    public static boolean isValid(long j, int i) {
        return isValidSeconds(j) && i >= 0 && i < NANOS_PER_SECOND;
    }

    public static Timestamp parse(String str) throws ParseException {
        String strSubstring;
        int iIndexOf = str.indexOf(84);
        if (iIndexOf == -1) {
            throw new ParseException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Failed to parse timestamp: invalid timestamp \"", str, "\""), 0);
        }
        int iIndexOf2 = str.indexOf(90, iIndexOf);
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.indexOf(43, iIndexOf);
        }
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.indexOf(45, iIndexOf);
        }
        if (iIndexOf2 == -1) {
            throw new ParseException(ehgOP.ASNfbgv, 0);
        }
        String strSubstring2 = str.substring(0, iIndexOf2);
        int iIndexOf3 = strSubstring2.indexOf(46);
        if (iIndexOf3 != -1) {
            String strSubstring3 = strSubstring2.substring(0, iIndexOf3);
            strSubstring = strSubstring2.substring(iIndexOf3 + 1);
            strSubstring2 = strSubstring3;
        } else {
            strSubstring = "";
        }
        long time = timestampFormat.get().parse(strSubstring2).getTime() / 1000;
        int nanos = strSubstring.isEmpty() ? 0 : parseNanos(strSubstring);
        if (str.charAt(iIndexOf2) != 'Z') {
            long timezoneOffset = parseTimezoneOffset(str.substring(iIndexOf2 + 1));
            time = str.charAt(iIndexOf2) == '+' ? time - timezoneOffset : time + timezoneOffset;
        } else if (str.length() != iIndexOf2 + 1) {
            throw new ParseException("Failed to parse timestamp: invalid trailing data \"" + str.substring(iIndexOf2) + "\"", 0);
        }
        try {
            return normalizedTimestamp(time, nanos);
        } catch (IllegalArgumentException e) {
            ParseException parseException = new ParseException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Failed to parse timestamp ", str, " Timestamp is out of range."), 0);
            parseException.initCause(e);
            throw parseException;
        }
    }

    public static Timestamp checkValid(Timestamp.Builder builder) {
        return checkValid(builder.build());
    }
}
