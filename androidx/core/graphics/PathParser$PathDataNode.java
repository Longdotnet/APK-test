package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.work.WorkContinuation;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;

/* JADX INFO: loaded from: classes2.dex */
public final class PathParser$PathDataNode {
    public final float[] mParams;
    public char mType;

    public PathParser$PathDataNode(char c, float[] fArr) {
        this.mType = c;
        this.mParams = fArr;
    }

    public static void nodesToPath(PathParser$PathDataNode[] pathParser$PathDataNodeArr, Path path) {
        int i;
        int i2;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        PathParser$PathDataNode[] pathParser$PathDataNodeArr2 = pathParser$PathDataNodeArr;
        int i3 = 6;
        float[] fArr = new float[6];
        int length = pathParser$PathDataNodeArr2.length;
        int i4 = 0;
        char c = 'm';
        while (i4 < length) {
            PathParser$PathDataNode pathParser$PathDataNode = pathParser$PathDataNodeArr2[i4];
            char c2 = pathParser$PathDataNode.mType;
            float f13 = fArr[0];
            float f14 = fArr[1];
            float f15 = fArr[2];
            float f16 = fArr[3];
            float f17 = fArr[4];
            float f18 = fArr[5];
            switch (c2) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case TOSS_VERYHIGH_VALUE:
                    i = i3;
                    break;
                case 'H':
                case ModuleDescriptor.MODULE_VERSION /* 86 */:
                case TOSS_FIXED_LOW_FOR_BEGINNER_VALUE:
                case 'v':
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f17, f18);
                    f13 = f17;
                    f15 = f13;
                    f14 = f18;
                    f16 = f14;
                default:
                    i = 2;
                    break;
            }
            float f19 = f17;
            float f20 = f18;
            float f21 = f13;
            float f22 = f14;
            int i5 = 0;
            while (true) {
                float[] fArr2 = pathParser$PathDataNode.mParams;
                if (i5 < fArr2.length) {
                    if (c2 != 'A') {
                        if (c2 != 'C') {
                            if (c2 == 'H') {
                                i2 = i5;
                                c2 = c2;
                                i4 = i4;
                                length = length;
                                pathParser$PathDataNode = pathParser$PathDataNode;
                                path.lineTo(fArr2[i2], f22);
                                f21 = fArr2[i2];
                            } else if (c2 == 'Q') {
                                i2 = i5;
                                float f23 = fArr2[i2];
                                int i6 = i2 + 1;
                                float f24 = fArr2[i6];
                                int i7 = i2 + 2;
                                int i8 = i2 + 3;
                                path.quadTo(f23, f24, fArr2[i7], fArr2[i8]);
                                f = fArr2[i2];
                                f2 = fArr2[i6];
                                f21 = fArr2[i7];
                                f22 = fArr2[i8];
                            } else if (c2 == 'V') {
                                i2 = i5;
                                c2 = c2;
                                i4 = i4;
                                length = length;
                                pathParser$PathDataNode = pathParser$PathDataNode;
                                path.lineTo(f21, fArr2[i2]);
                                f22 = fArr2[i2];
                            } else if (c2 != 'a') {
                                if (c2 != 'c') {
                                    if (c2 != 'h') {
                                        if (c2 == 'q') {
                                            i2 = i5;
                                            float f25 = f22;
                                            float f26 = f21;
                                            int i9 = i2 + 1;
                                            int i10 = i2 + 2;
                                            int i11 = i2 + 3;
                                            path.rQuadTo(fArr2[i2], fArr2[i9], fArr2[i10], fArr2[i11]);
                                            float f27 = f26 + fArr2[i2];
                                            float f28 = fArr2[i9] + f25;
                                            float f29 = f26 + fArr2[i10];
                                            f22 = f25 + fArr2[i11];
                                            f16 = f28;
                                            f15 = f27;
                                            f21 = f29;
                                        } else if (c2 == 'v') {
                                            i2 = i5;
                                            path.rLineTo(0.0f, fArr2[i2]);
                                            f22 += fArr2[i2];
                                        } else if (c2 == 'L') {
                                            i2 = i5;
                                            int i12 = i2 + 1;
                                            path.lineTo(fArr2[i2], fArr2[i12]);
                                            f21 = fArr2[i2];
                                            f22 = fArr2[i12];
                                        } else if (c2 == 'M') {
                                            i2 = i5;
                                            f21 = fArr2[i2];
                                            f22 = fArr2[i2 + 1];
                                            if (i2 > 0) {
                                                path.lineTo(f21, f22);
                                            } else {
                                                path.moveTo(f21, f22);
                                                f20 = f22;
                                                f19 = f21;
                                            }
                                        } else if (c2 == 'S') {
                                            i2 = i5;
                                            float f30 = f22;
                                            float f31 = f21;
                                            if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                                                f7 = (f30 * 2.0f) - f16;
                                                f8 = (f31 * 2.0f) - f15;
                                            } else {
                                                f8 = f31;
                                                f7 = f30;
                                            }
                                            int i13 = i2 + 1;
                                            int i14 = i2 + 2;
                                            int i15 = i2 + 3;
                                            path.cubicTo(f8, f7, fArr2[i2], fArr2[i13], fArr2[i14], fArr2[i15]);
                                            float f32 = fArr2[i2];
                                            float f33 = fArr2[i13];
                                            f21 = fArr2[i14];
                                            f22 = fArr2[i15];
                                            f16 = f33;
                                            f15 = f32;
                                        } else if (c2 == 'T') {
                                            i2 = i5;
                                            float f34 = f22;
                                            float f35 = f21;
                                            if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                                                f3 = (f35 * 2.0f) - f15;
                                                f4 = (f34 * 2.0f) - f16;
                                            } else {
                                                f3 = f35;
                                                f4 = f34;
                                            }
                                            int i16 = i2 + 1;
                                            path.quadTo(f3, f4, fArr2[i2], fArr2[i16]);
                                            f5 = fArr2[i2];
                                            f6 = fArr2[i16];
                                        } else if (c2 == 'l') {
                                            i2 = i5;
                                            int i17 = i2 + 1;
                                            path.rLineTo(fArr2[i2], fArr2[i17]);
                                            f21 += fArr2[i2];
                                            f22 += fArr2[i17];
                                        } else if (c2 == 'm') {
                                            i2 = i5;
                                            float f36 = fArr2[i2];
                                            f21 += f36;
                                            float f37 = fArr2[i2 + 1];
                                            f22 += f37;
                                            if (i2 > 0) {
                                                path.rLineTo(f36, f37);
                                            } else {
                                                path.rMoveTo(f36, f37);
                                                f20 = f22;
                                                f19 = f21;
                                            }
                                        } else if (c2 == 's') {
                                            if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                                                float f38 = f21 - f15;
                                                f9 = f22 - f16;
                                                f10 = f38;
                                            } else {
                                                f9 = 0.0f;
                                                f10 = 0.0f;
                                            }
                                            int i18 = i5 + 1;
                                            int i19 = i5 + 2;
                                            int i20 = i5 + 3;
                                            i2 = i5;
                                            float f39 = f22;
                                            float f40 = f21;
                                            path.rCubicTo(f10, f9, fArr2[i5], fArr2[i18], fArr2[i19], fArr2[i20]);
                                            f3 = f40 + fArr2[i2];
                                            f4 = f39 + fArr2[i18];
                                            f5 = f40 + fArr2[i19];
                                            f6 = fArr2[i20] + f39;
                                        } else if (c2 != 't') {
                                            i2 = i5;
                                        } else {
                                            if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                                                f11 = f21 - f15;
                                                f12 = f22 - f16;
                                            } else {
                                                f12 = 0.0f;
                                                f11 = 0.0f;
                                            }
                                            int i21 = i5 + 1;
                                            path.rQuadTo(f11, f12, fArr2[i5], fArr2[i21]);
                                            float f41 = f11 + f21;
                                            float f42 = f12 + f22;
                                            f21 += fArr2[i5];
                                            f22 += fArr2[i21];
                                            f16 = f42;
                                            i2 = i5;
                                            f15 = f41;
                                        }
                                        pathParser$PathDataNode = pathParser$PathDataNode;
                                    } else {
                                        i2 = i5;
                                        path.rLineTo(fArr2[i2], 0.0f);
                                        f21 += fArr2[i2];
                                    }
                                    pathParser$PathDataNode = pathParser$PathDataNode;
                                } else {
                                    i2 = i5;
                                    float f43 = f22;
                                    float f44 = f21;
                                    int i22 = i2 + 2;
                                    int i23 = i2 + 3;
                                    int i24 = i2 + 4;
                                    int i25 = i2 + 5;
                                    path.rCubicTo(fArr2[i2], fArr2[i2 + 1], fArr2[i22], fArr2[i23], fArr2[i24], fArr2[i25]);
                                    f3 = f44 + fArr2[i22];
                                    f4 = f43 + fArr2[i23];
                                    f5 = f44 + fArr2[i24];
                                    f6 = fArr2[i25] + f43;
                                }
                                f16 = f4;
                                f15 = f3;
                                f21 = f5;
                                f22 = f6;
                                pathParser$PathDataNode = pathParser$PathDataNode;
                            } else {
                                i2 = i5;
                                float f45 = f22;
                                float f46 = f21;
                                int i26 = i2 + 5;
                                int i27 = i2 + 6;
                                drawArc(path, f46, f45, fArr2[i26] + f46, fArr2[i27] + f45, fArr2[i2], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                                f21 = f46 + fArr2[i26];
                                f22 = f45 + fArr2[i27];
                            }
                            i5 = i2 + i;
                            pathParser$PathDataNode = pathParser$PathDataNode;
                            length = length;
                            c = c2;
                            c2 = c;
                            i4 = i4;
                        } else {
                            i2 = i5;
                            int i28 = i2 + 2;
                            int i29 = i2 + 3;
                            int i30 = i2 + 4;
                            int i31 = i2 + 5;
                            path.cubicTo(fArr2[i2], fArr2[i2 + 1], fArr2[i28], fArr2[i29], fArr2[i30], fArr2[i31]);
                            f21 = fArr2[i30];
                            f22 = fArr2[i31];
                            f = fArr2[i28];
                            f2 = fArr2[i29];
                        }
                        f15 = f;
                        f16 = f2;
                        i5 = i2 + i;
                        pathParser$PathDataNode = pathParser$PathDataNode;
                        length = length;
                        c = c2;
                        c2 = c;
                        i4 = i4;
                    } else {
                        i2 = i5;
                        int i32 = i2 + 5;
                        int i33 = i2 + 6;
                        drawArc(path, f21, f22, fArr2[i32], fArr2[i33], fArr2[i2], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        f21 = fArr2[i32];
                        f22 = fArr2[i33];
                    }
                    f16 = f22;
                    f15 = f21;
                    i5 = i2 + i;
                    pathParser$PathDataNode = pathParser$PathDataNode;
                    length = length;
                    c = c2;
                    c2 = c;
                    i4 = i4;
                }
            }
            fArr[0] = f21;
            fArr[1] = f22;
            fArr[2] = f15;
            fArr[3] = f16;
            fArr[4] = f19;
            fArr[5] = f20;
            c = pathParser$PathDataNode.mType;
            i4++;
            pathParser$PathDataNodeArr2 = pathParser$PathDataNodeArr;
            length = length;
            i3 = 6;
        }
    }

    public static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
        double d;
        double d2;
        double radians = Math.toRadians(f7);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d3 = f;
        double d4 = f2;
        double d5 = (d4 * dSin) + (d3 * dCos);
        double d6 = d3;
        double d7 = f5;
        double d8 = d5 / d7;
        double d9 = f6;
        double d10 = ((d4 * dCos) + (((double) (-f)) * dSin)) / d9;
        double d11 = d4;
        double d12 = f4;
        double d13 = ((d12 * dSin) + (((double) f3) * dCos)) / d7;
        double d14 = ((d12 * dCos) + (((double) (-f3)) * dSin)) / d9;
        double d15 = d8 - d13;
        double d16 = d10 - d14;
        double d17 = (d8 + d13) / 2.0d;
        double d18 = (d10 + d14) / 2.0d;
        double d19 = (d16 * d16) + (d15 * d15);
        String str = JrbhsraGtto.TRBVInmOktt;
        if (d19 == 0.0d) {
            Log.w(str, " Points are coincident");
            return;
        }
        double d20 = (1.0d / d19) - 0.25d;
        if (d20 < 0.0d) {
            Log.w(str, "Points are too far apart " + d19);
            float fSqrt = (float) (Math.sqrt(d19) / 1.99999d);
            drawArc(path, f, f2, f3, f4, f5 * fSqrt, f6 * fSqrt, f7, z, z2);
            return;
        }
        double dSqrt = Math.sqrt(d20);
        double d21 = d15 * dSqrt;
        double d22 = dSqrt * d16;
        if (z == z2) {
            d = d17 - d22;
            d2 = d18 + d21;
        } else {
            d = d17 + d22;
            d2 = d18 - d21;
        }
        double dAtan2 = Math.atan2(d10 - d2, d8 - d);
        double dAtan3 = Math.atan2(d14 - d2, d13 - d) - dAtan2;
        if (z2 != (dAtan3 >= 0.0d)) {
            dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
        }
        double d23 = d * d7;
        double d24 = d2 * d9;
        double d25 = (d23 * dCos) - (d24 * dSin);
        double d26 = (d24 * dCos) + (d23 * dSin);
        int iCeil = (int) Math.ceil(Math.abs((dAtan3 * 4.0d) / 3.141592653589793d));
        double dCos2 = Math.cos(radians);
        double dSin2 = Math.sin(radians);
        double dCos3 = Math.cos(dAtan2);
        double dSin3 = Math.sin(dAtan2);
        double d27 = -d7;
        double d28 = d27 * dCos2;
        double d29 = d9 * dSin2;
        double d30 = (d28 * dSin3) - (d29 * dCos3);
        double d31 = d27 * dSin2;
        double d32 = d9 * dCos2;
        double d33 = (dCos3 * d32) + (dSin3 * d31);
        double d34 = d32;
        double d35 = dAtan3 / ((double) iCeil);
        int i = 0;
        while (i < iCeil) {
            double d36 = dAtan2 + d35;
            double dSin4 = Math.sin(d36);
            double dCos4 = Math.cos(d36);
            double d37 = d35;
            double d38 = (((d7 * dCos2) * dCos4) + d25) - (d29 * dSin4);
            double d39 = d34;
            double d40 = d25;
            double d41 = (d39 * dSin4) + (d7 * dSin2 * dCos4) + d26;
            double d42 = (d28 * dSin4) - (d29 * dCos4);
            double d43 = (dCos4 * d39) + (dSin4 * d31);
            double d44 = d36 - dAtan2;
            double dTan = Math.tan(d44 / 2.0d);
            double dSqrt2 = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d44)) / 3.0d;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) ((d30 * dSqrt2) + d6), (float) ((d33 * dSqrt2) + d11), (float) (d38 - (dSqrt2 * d42)), (float) (d41 - (dSqrt2 * d43)), (float) d38, (float) d41);
            i++;
            dAtan2 = d36;
            d31 = d31;
            dCos2 = dCos2;
            iCeil = iCeil;
            d33 = d43;
            d7 = d7;
            d30 = d42;
            d6 = d38;
            d11 = d41;
            d25 = d40;
            d35 = d37;
            d34 = d39;
        }
    }

    public PathParser$PathDataNode(PathParser$PathDataNode pathParser$PathDataNode) {
        this.mType = pathParser$PathDataNode.mType;
        float[] fArr = pathParser$PathDataNode.mParams;
        this.mParams = WorkContinuation.copyOfRange(fArr, fArr.length);
    }
}
