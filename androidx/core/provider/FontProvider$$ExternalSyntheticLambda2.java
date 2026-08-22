package androidx.core.provider;

import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.anrreport.ANRHandler;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.instrument.errorreport.ErrorReportData;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FontProvider$$ExternalSyntheticLambda2 implements Comparator {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ FontProvider$$ExternalSyntheticLambda2(int i) {
        this.$r8$classId = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i = 0; i < bArr.length; i++) {
                    byte b = bArr[i];
                    byte b2 = bArr2[i];
                    if (b != b2) {
                        return b - b2;
                    }
                }
                return 0;
            case 1:
                InstrumentData instrumentData = (InstrumentData) obj;
                InstrumentData o2 = (InstrumentData) obj2;
                if (CrashShieldHandler.isObjectCrashing(ANRHandler.class)) {
                    return 0;
                }
                try {
                    Intrinsics.checkNotNullExpressionValue(o2, "o2");
                    instrumentData.getClass();
                    Long l = instrumentData.timestamp;
                    if (l != null) {
                        long jLongValue = l.longValue();
                        Long l2 = o2.timestamp;
                        if (l2 != null) {
                            long jLongValue2 = l2.longValue();
                            if (jLongValue2 >= jLongValue) {
                                if (jLongValue2 == jLongValue) {
                                    return 0;
                                }
                            }
                        }
                        return 1;
                    }
                    return -1;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(ANRHandler.class, th);
                    return 0;
                }
            case 2:
                InstrumentData instrumentData2 = (InstrumentData) obj;
                InstrumentData o3 = (InstrumentData) obj2;
                Intrinsics.checkNotNullExpressionValue(o3, "o2");
                instrumentData2.getClass();
                Long l3 = instrumentData2.timestamp;
                if (l3 == null) {
                    return -1;
                }
                long jLongValue3 = l3.longValue();
                Long l4 = o3.timestamp;
                if (l4 != null) {
                    long jLongValue4 = l4.longValue();
                    if (jLongValue4 < jLongValue3) {
                        return -1;
                    }
                    if (jLongValue4 == jLongValue3) {
                        return 0;
                    }
                }
                return 1;
            default:
                ErrorReportData errorReportData = (ErrorReportData) obj;
                ErrorReportData o4 = (ErrorReportData) obj2;
                Intrinsics.checkNotNullExpressionValue(o4, "o2");
                errorReportData.getClass();
                Long l5 = errorReportData.timestamp;
                if (l5 == null) {
                    return -1;
                }
                long jLongValue5 = l5.longValue();
                Long l6 = o4.timestamp;
                if (l6 != null) {
                    long jLongValue6 = l6.longValue();
                    if (jLongValue6 < jLongValue5) {
                        return -1;
                    }
                    if (jLongValue6 == jLongValue5) {
                        return 0;
                    }
                }
                return 1;
        }
    }
}
