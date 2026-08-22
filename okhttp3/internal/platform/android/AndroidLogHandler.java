package okhttp3.internal.platform.android;

import android.util.Log;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidLogHandler extends Handler {
    public static final AndroidLogHandler INSTANCE = new AndroidLogHandler();

    @Override // java.util.logging.Handler
    public final void close() {
    }

    @Override // java.util.logging.Handler
    public final void flush() {
    }

    @Override // java.util.logging.Handler
    public final void publish(LogRecord record) {
        int i;
        int iMin;
        Intrinsics.checkNotNullParameter(record, "record");
        CopyOnWriteArraySet copyOnWriteArraySet = AndroidLog.configuredLoggers;
        String loggerName = record.getLoggerName();
        Intrinsics.checkNotNullExpressionValue(loggerName, "record.loggerName");
        int iIntValue = record.getLevel().intValue();
        Level level = Level.INFO;
        if (iIntValue > level.intValue()) {
            i = 5;
        } else {
            i = record.getLevel().intValue() == level.intValue() ? 4 : 3;
        }
        String message = record.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "record.message");
        Throwable thrown = record.getThrown();
        String strSubstring = (String) AndroidLog.knownLoggers.get(loggerName);
        if (strSubstring == null) {
            int length = loggerName.length();
            if (23 <= length) {
                length = 23;
            }
            strSubstring = loggerName.substring(0, length);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        if (Log.isLoggable(strSubstring, i)) {
            if (thrown != null) {
                message = message + "\n" + Log.getStackTraceString(thrown);
            }
            int length2 = message.length();
            int i2 = 0;
            while (i2 < length2) {
                int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) message, '\n', i2, false, 4);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = length2;
                }
                while (true) {
                    iMin = Math.min(iIndexOf$default, i2 + 4000);
                    String strSubstring2 = message.substring(i2, iMin);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.println(i, strSubstring, strSubstring2);
                    if (iMin >= iIndexOf$default) {
                        break;
                    } else {
                        i2 = iMin;
                    }
                }
                i2 = iMin + 1;
            }
        }
    }
}
