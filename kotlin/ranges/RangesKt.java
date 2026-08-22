package kotlin.ranges;

import android.app.AppOpsManager;
import android.content.Context;
import android.graphics.Paint;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.AppOpsManagerCompat$Api23Impl;
import androidx.core.app.AppOpsManagerCompat$Api29Impl;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.widget.TextViewCompat$Api23Impl;
import androidx.core.widget.TextViewCompat$Api24Impl;
import androidx.core.widget.TextViewCompat$Api28Impl;
import androidx.core.widget.TextViewCompat$OreoCallback;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RangesKt {
    public static int checkSelfPermission(Context context, String str) {
        int iNoteProxyOpNoThrow;
        int iMyPid = Process.myPid();
        int iMyUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, iMyPid, iMyUid) == -1) {
            return -1;
        }
        String strPermissionToOp = AppOpsManagerCompat$Api23Impl.permissionToOp(str);
        if (strPermissionToOp != null) {
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(iMyUid);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                packageName = packagesForUid[0];
            }
            int iMyUid2 = Process.myUid();
            String packageName2 = context.getPackageName();
            if (iMyUid2 == iMyUid && Objects.equals(packageName2, packageName) && Build.VERSION.SDK_INT >= 29) {
                AppOpsManager systemService = AppOpsManagerCompat$Api29Impl.getSystemService(context);
                iNoteProxyOpNoThrow = AppOpsManagerCompat$Api29Impl.checkOpNoThrow(systemService, strPermissionToOp, Binder.getCallingUid(), packageName);
                if (iNoteProxyOpNoThrow == 0) {
                    iNoteProxyOpNoThrow = AppOpsManagerCompat$Api29Impl.checkOpNoThrow(systemService, strPermissionToOp, iMyUid, AppOpsManagerCompat$Api29Impl.getOpPackageName(context));
                }
            } else {
                iNoteProxyOpNoThrow = AppOpsManagerCompat$Api23Impl.noteProxyOpNoThrow((AppOpsManager) AppOpsManagerCompat$Api23Impl.getSystemService(context, AppOpsManager.class), strPermissionToOp, packageName);
            }
            if (iNoteProxyOpNoThrow != 0) {
                return -2;
            }
        }
        return 0;
    }

    public static void d(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, String.format(str2, obj));
        }
    }

    public static void e(Exception exc, String str, String str2) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 6)) {
            Log.e(tag, str2, exc);
        }
    }

    public static ArrayList findVisibleChildren(ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList();
        int childCount = viewGroup.getChildCount();
        if (childCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    arrayList.add(childAt);
                }
                if (i2 >= childCount) {
                    break;
                }
                i = i2;
            }
        }
        return arrayList;
    }

    public static String getTag(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return "TRuntime.".concat(str);
        }
        String strConcat = "TRuntime.".concat(str);
        return strConcat.length() > 23 ? strConcat.substring(0, 23) : strConcat;
    }

    public static PrecomputedTextCompat.Params getTextMetricsParams(AppCompatTextView appCompatTextView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return new PrecomputedTextCompat.Params(TextViewCompat$Api28Impl.getTextMetricsParams(appCompatTextView));
        }
        TextPaint textPaint = new TextPaint(appCompatTextView.getPaint());
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int breakStrategy = TextViewCompat$Api23Impl.getBreakStrategy(appCompatTextView);
        int hyphenationFrequency = TextViewCompat$Api23Impl.getHyphenationFrequency(appCompatTextView);
        if (appCompatTextView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else if (i < 28 || (appCompatTextView.getInputType() & 15) != 3) {
            boolean z = appCompatTextView.getLayoutDirection() == 1;
            switch (appCompatTextView.getTextDirection()) {
                case 2:
                    textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                    break;
                case 3:
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                    break;
                case 4:
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                    break;
                case 5:
                    textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                    break;
                case 6:
                    break;
                case 7:
                    textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    break;
                default:
                    if (z) {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    break;
            }
        } else {
            byte directionality = Character.getDirectionality(TextViewCompat$Api28Impl.getDigitStrings(TextViewCompat$Api24Impl.getInstance(appCompatTextView.getTextLocale()))[0].codePointAt(0));
            textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        return new PrecomputedTextCompat.Params(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
    }

    public static final boolean permitsRequestBody(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return (method.equals("GET") || method.equals("HEAD")) ? false : true;
    }

    public static void setFirstBaselineToTopHeight(TextView textView, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (Build.VERSION.SDK_INT >= 28) {
            TextViewCompat$Api28Impl.setFirstBaselineToTopHeight(textView, i);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i + i2, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void setLastBaselineToBottomHeight(TextView textView, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    public static void setLineHeight(TextView textView, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i != fontMetricsInt) {
            textView.setLineSpacing(i - fontMetricsInt, 1.0f);
        }
    }

    public static IntProgression step(IntProgression intProgression, int i) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        boolean z = i > 0;
        Integer numValueOf = Integer.valueOf(i);
        if (z) {
            if (intProgression.step <= 0) {
                i = -i;
            }
            return new IntProgression(intProgression.first, intProgression.last, i);
        }
        throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
    }

    public static IntRange until(int i, int i2) {
        if (i2 > Integer.MIN_VALUE) {
            return new IntRange(i, i2 - 1, 1);
        }
        IntRange intRange = IntRange.EMPTY;
        return IntRange.EMPTY;
    }

    public static ActionMode.Callback unwrapCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        return (!(callback instanceof TextViewCompat$OreoCallback) || Build.VERSION.SDK_INT < 26) ? callback : ((TextViewCompat$OreoCallback) callback).mCallback;
    }

    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(ActionMode.Callback callback, TextView textView) {
        int i = Build.VERSION.SDK_INT;
        return (i < 26 || i > 27 || (callback instanceof TextViewCompat$OreoCallback) || callback == null) ? callback : new TextViewCompat$OreoCallback(callback, textView);
    }

    public static int zza(int i) {
        int[] iArr = {1, 2, 3, 4, 5, 6};
        for (int i2 = 0; i2 < 6; i2++) {
            int i3 = iArr[i2];
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            }
            if (i4 == i) {
                return i3;
            }
        }
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x0185, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1, r10) == false) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList findViewByPath(android.view.View r7, java.util.List r8, int r9, int r10, java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.RangesKt.findViewByPath(android.view.View, java.util.List, int, int, java.lang.String):java.util.ArrayList");
    }
}
