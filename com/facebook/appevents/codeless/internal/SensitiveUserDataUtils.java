package com.facebook.appevents.codeless.internal;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class SensitiveUserDataUtils {
    public static final SensitiveUserDataUtils INSTANCE = new SensitiveUserDataUtils();

    /* JADX WARN: Code duplicated, block: B:24:0x0046  */
    /* JADX WARN: Code duplicated, block: B:32:0x0059 A[Catch: all -> 0x00c4, TRY_LEAVE, TryCatch #1 {all -> 0x00c4, blocks: (B:5:0x000a, B:8:0x0010, B:20:0x0034, B:22:0x003d, B:32:0x0059, B:42:0x0075, B:52:0x0090, B:66:0x00bd, B:50:0x008a, B:40:0x006f, B:30:0x0053, B:18:0x002e, B:25:0x0048, B:45:0x0080, B:55:0x009a, B:58:0x00a4, B:60:0x00aa, B:63:0x00b1, B:12:0x001c, B:15:0x0026, B:35:0x0064), top: B:78:0x000a, inners: #0, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075 A[Catch: all -> 0x00c4, TRY_LEAVE, TryCatch #1 {all -> 0x00c4, blocks: (B:5:0x000a, B:8:0x0010, B:20:0x0034, B:22:0x003d, B:32:0x0059, B:42:0x0075, B:52:0x0090, B:66:0x00bd, B:50:0x008a, B:40:0x006f, B:30:0x0053, B:18:0x002e, B:25:0x0048, B:45:0x0080, B:55:0x009a, B:58:0x00a4, B:60:0x00aa, B:63:0x00b1, B:12:0x001c, B:15:0x0026, B:35:0x0064), top: B:78:0x000a, inners: #0, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090 A[Catch: all -> 0x00c4, TRY_LEAVE, TryCatch #1 {all -> 0x00c4, blocks: (B:5:0x000a, B:8:0x0010, B:20:0x0034, B:22:0x003d, B:32:0x0059, B:42:0x0075, B:52:0x0090, B:66:0x00bd, B:50:0x008a, B:40:0x006f, B:30:0x0053, B:18:0x002e, B:25:0x0048, B:45:0x0080, B:55:0x009a, B:58:0x00a4, B:60:0x00aa, B:63:0x00b1, B:12:0x001c, B:15:0x0026, B:35:0x0064), top: B:78:0x000a, inners: #0, #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0098  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a4 A[Catch: all -> 0x00bc, TryCatch #3 {all -> 0x00bc, blocks: (B:55:0x009a, B:58:0x00a4, B:60:0x00aa, B:63:0x00b1), top: B:81:0x009a, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00aa A[Catch: all -> 0x00bc, TryCatch #3 {all -> 0x00bc, blocks: (B:55:0x009a, B:58:0x00a4, B:60:0x00aa, B:63:0x00b1), top: B:81:0x009a, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:? A[RETURN, SYNTHETIC] */
    public static final boolean isSensitiveUserData(View view) {
        boolean z;
        boolean z2;
        TextView textView;
        boolean z3;
        TextView textView2;
        boolean z4;
        TextView textView3;
        String textOfView;
        boolean zMatches;
        if (CrashShieldHandler.isObjectCrashing(SensitiveUserDataUtils.class)) {
            return false;
        }
        try {
            if (!(view instanceof TextView)) {
                return false;
            }
            SensitiveUserDataUtils sensitiveUserDataUtils = INSTANCE;
            TextView textView4 = (TextView) view;
            if (CrashShieldHandler.isObjectCrashing(sensitiveUserDataUtils)) {
                z = false;
            } else {
                try {
                    z = textView4.getInputType() == 128 ? true : textView4.getTransformationMethod() instanceof PasswordTransformationMethod;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(sensitiveUserDataUtils, th);
                    z = false;
                }
            }
            if (!z && !sensitiveUserDataUtils.isCreditCard((TextView) view)) {
                TextView textView5 = (TextView) view;
                if (CrashShieldHandler.isObjectCrashing(sensitiveUserDataUtils)) {
                    z2 = false;
                    if (!z2) {
                        textView = (TextView) view;
                        if (CrashShieldHandler.isObjectCrashing(sensitiveUserDataUtils)) {
                            z3 = false;
                            if (!z3) {
                                textView2 = (TextView) view;
                                if (CrashShieldHandler.isObjectCrashing(sensitiveUserDataUtils)) {
                                    z4 = false;
                                    if (!z4) {
                                        textView3 = (TextView) view;
                                        if (CrashShieldHandler.isObjectCrashing(sensitiveUserDataUtils)) {
                                            zMatches = false;
                                        } else {
                                            try {
                                                if (textView3.getInputType() == 32) {
                                                    zMatches = true;
                                                } else {
                                                    textOfView = ViewHierarchy.getTextOfView(textView3);
                                                    if (textOfView != null || textOfView.length() == 0) {
                                                        zMatches = false;
                                                    } else {
                                                        zMatches = Patterns.EMAIL_ADDRESS.matcher(textOfView).matches();
                                                    }
                                                }
                                            } catch (Throwable th2) {
                                                CrashShieldHandler.handleThrowable(sensitiveUserDataUtils, th2);
                                            }
                                        }
                                        if (!zMatches) {
                                            return false;
                                        }
                                    }
                                } else {
                                    try {
                                        if (textView2.getInputType() == 3) {
                                            z4 = true;
                                        } else {
                                            z4 = false;
                                        }
                                    } catch (Throwable th3) {
                                        CrashShieldHandler.handleThrowable(sensitiveUserDataUtils, th3);
                                    }
                                    if (!z4) {
                                        textView3 = (TextView) view;
                                        if (CrashShieldHandler.isObjectCrashing(sensitiveUserDataUtils)) {
                                            zMatches = false;
                                        } else if (textView3.getInputType() == 32) {
                                            zMatches = true;
                                        } else {
                                            textOfView = ViewHierarchy.getTextOfView(textView3);
                                            if (textOfView != null) {
                                                zMatches = false;
                                            } else {
                                                zMatches = false;
                                            }
                                        }
                                        if (!zMatches) {
                                            return false;
                                        }
                                    }
                                }
                            }
                        } else {
                            try {
                                if (textView.getInputType() == 112) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                            } catch (Throwable th4) {
                                CrashShieldHandler.handleThrowable(sensitiveUserDataUtils, th4);
                            }
                            if (!z3) {
                                textView2 = (TextView) view;
                                if (CrashShieldHandler.isObjectCrashing(sensitiveUserDataUtils)) {
                                    z4 = false;
                                    if (!z4) {
                                        textView3 = (TextView) view;
                                        if (CrashShieldHandler.isObjectCrashing(sensitiveUserDataUtils)) {
                                            zMatches = false;
                                        } else if (textView3.getInputType() == 32) {
                                            zMatches = true;
                                        } else {
                                            textOfView = ViewHierarchy.getTextOfView(textView3);
                                            if (textOfView != null) {
                                                zMatches = false;
                                            } else {
                                                zMatches = false;
                                            }
                                        }
                                        if (!zMatches) {
                                            return false;
                                        }
                                    }
                                } else {
                                    if (textView2.getInputType() == 3) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if (!z4) {
                                        textView3 = (TextView) view;
                                        if (CrashShieldHandler.isObjectCrashing(sensitiveUserDataUtils)) {
                                            zMatches = false;
                                        } else if (textView3.getInputType() == 32) {
                                            zMatches = true;
                                        } else {
                                            textOfView = ViewHierarchy.getTextOfView(textView3);
                                            if (textOfView != null) {
                                                zMatches = false;
                                            } else {
                                                zMatches = false;
                                            }
                                        }
                                        if (!zMatches) {
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    try {
                        if (textView5.getInputType() == 96) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } catch (Throwable th5) {
                        CrashShieldHandler.handleThrowable(sensitiveUserDataUtils, th5);
                    }
                    if (!z2) {
                        textView = (TextView) view;
                        if (CrashShieldHandler.isObjectCrashing(sensitiveUserDataUtils)) {
                            z3 = false;
                            if (!z3) {
                                textView2 = (TextView) view;
                                if (CrashShieldHandler.isObjectCrashing(sensitiveUserDataUtils)) {
                                    z4 = false;
                                    if (!z4) {
                                        textView3 = (TextView) view;
                                        if (CrashShieldHandler.isObjectCrashing(sensitiveUserDataUtils)) {
                                            zMatches = false;
                                        } else if (textView3.getInputType() == 32) {
                                            zMatches = true;
                                        } else {
                                            textOfView = ViewHierarchy.getTextOfView(textView3);
                                            if (textOfView != null) {
                                                zMatches = false;
                                            } else {
                                                zMatches = false;
                                            }
                                        }
                                        if (!zMatches) {
                                            return false;
                                        }
                                    }
                                } else {
                                    if (textView2.getInputType() == 3) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if (!z4) {
                                        textView3 = (TextView) view;
                                        if (CrashShieldHandler.isObjectCrashing(sensitiveUserDataUtils)) {
                                            zMatches = false;
                                        } else if (textView3.getInputType() == 32) {
                                            zMatches = true;
                                        } else {
                                            textOfView = ViewHierarchy.getTextOfView(textView3);
                                            if (textOfView != null) {
                                                zMatches = false;
                                            } else {
                                                zMatches = false;
                                            }
                                        }
                                        if (!zMatches) {
                                            return false;
                                        }
                                    }
                                }
                            }
                        } else {
                            if (textView.getInputType() == 112) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (!z3) {
                                textView2 = (TextView) view;
                                if (CrashShieldHandler.isObjectCrashing(sensitiveUserDataUtils)) {
                                    z4 = false;
                                    if (!z4) {
                                        textView3 = (TextView) view;
                                        if (CrashShieldHandler.isObjectCrashing(sensitiveUserDataUtils)) {
                                            zMatches = false;
                                        } else if (textView3.getInputType() == 32) {
                                            zMatches = true;
                                        } else {
                                            textOfView = ViewHierarchy.getTextOfView(textView3);
                                            if (textOfView != null) {
                                                zMatches = false;
                                            } else {
                                                zMatches = false;
                                            }
                                        }
                                        if (!zMatches) {
                                            return false;
                                        }
                                    }
                                } else {
                                    if (textView2.getInputType() == 3) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if (!z4) {
                                        textView3 = (TextView) view;
                                        if (CrashShieldHandler.isObjectCrashing(sensitiveUserDataUtils)) {
                                            zMatches = false;
                                        } else if (textView3.getInputType() == 32) {
                                            zMatches = true;
                                        } else {
                                            textOfView = ViewHierarchy.getTextOfView(textView3);
                                            if (textOfView != null) {
                                                zMatches = false;
                                            } else {
                                                zMatches = false;
                                            }
                                        }
                                        if (!zMatches) {
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return true;
        } catch (Throwable th6) {
            CrashShieldHandler.handleThrowable(SensitiveUserDataUtils.class, th6);
            return false;
        }
    }

    public final boolean isCreditCard(TextView textView) {
        int i;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            String input = ViewHierarchy.getTextOfView(textView);
            Pattern patternCompile = Pattern.compile("\\s");
            Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern)");
            Intrinsics.checkNotNullParameter(input, "input");
            String strReplaceAll = patternCompile.matcher(input).replaceAll("");
            Intrinsics.checkNotNullExpressionValue(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
            int length = strReplaceAll.length();
            if (length >= 12 && length <= 19) {
                int i2 = length - 1;
                if (i2 >= 0) {
                    boolean z = false;
                    i = 0;
                    while (true) {
                        int i3 = i2 - 1;
                        char cCharAt = strReplaceAll.charAt(i2);
                        if (!Character.isDigit(cCharAt)) {
                            return false;
                        }
                        int iDigit = Character.digit((int) cCharAt, 10);
                        if (iDigit < 0) {
                            throw new IllegalArgumentException("Char " + cCharAt + " is not a decimal digit");
                        }
                        if (z && (iDigit = iDigit * 2) > 9) {
                            iDigit = (iDigit % 10) + 1;
                        }
                        i += iDigit;
                        z = !z;
                        if (i3 < 0) {
                            break;
                        }
                        i2 = i3;
                    }
                } else {
                    i = 0;
                }
                return i % 10 == 0;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return false;
        }
    }
}
