package com.google.firebase.auth;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.WorkContinuation;
import com.android.billingclient.api.zzda;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions;
import com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.heartbeatinfo.HeartBeatConsumer;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.ObjectConstructor;
import com.google.protobuf.DescriptorProtos;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.aztec.encoder.HighLevelEncoder;
import com.google.zxing.aztec.encoder.State;
import com.google.zxing.aztec.encoder.Token;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.datamatrix.encoder.EncoderContext;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.datamatrix.encoder.X12Encoder;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.pdf417.encoder.BarcodeMatrix;
import com.google.zxing.pdf417.encoder.PDF417;
import com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.encoder.BlockPair;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.http2.Huffman;
import okio.Buffer;

/* JADX INFO: loaded from: classes2.dex */
public class zzr implements Continuation, HeartBeatConsumer, ObjectConstructor, Writer {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ zzr(int i) {
        this.$r8$classId = i;
    }

    public static ArrayList alpnProtocolNames(List protocols) {
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        ArrayList arrayList = new ArrayList();
        for (Object obj : protocols) {
            if (((Protocol) obj) != Protocol.HTTP_1_0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Protocol) it.next()).protocol);
        }
        return arrayList2;
    }

    public static BitMatrix bitMatrixFromBitArray(byte[][] bArr, int i) {
        int i2 = i * 2;
        int length = bArr[0].length + i2;
        int length2 = bArr.length + i2;
        BitMatrix bitMatrix = new BitMatrix(length, length2);
        int[] iArr = bitMatrix.bits;
        int length3 = iArr.length;
        for (int i3 = 0; i3 < length3; i3++) {
            iArr[i3] = 0;
        }
        int i4 = (length2 - i) - 1;
        int i5 = 0;
        while (i5 < bArr.length) {
            byte[] bArr2 = bArr[i5];
            for (int i6 = 0; i6 < bArr[0].length; i6++) {
                if (bArr2[i6] == 1) {
                    bitMatrix.set(i6 + i, i4);
                }
            }
            i5++;
            i4--;
        }
        return bitMatrix;
    }

    public static byte[] concatLengthPrefixed(List protocols) {
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Buffer buffer = new Buffer();
        for (String str : alpnProtocolNames(protocols)) {
            buffer.writeByte(str.length());
            buffer.m124writeUtf8(str);
        }
        return buffer.readByteArray(buffer.size);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0083  */
    private final BitMatrix encode$com$google$zxing$aztec$AztecWriter(String str, int i, EnumMap enumMap) {
        byte[] bArr;
        int i2;
        int i3;
        int i4;
        boolean z;
        int iAbs;
        int i5;
        BitArray bitArrayStuffBits;
        BitArray bitArrayGenerateCheckWords;
        int i6;
        int i7;
        int i8;
        Charset charsetForName = StandardCharsets.ISO_8859_1;
        EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
        if (enumMap.containsKey(encodeHintType)) {
            charsetForName = Charset.forName(enumMap.get(encodeHintType).toString());
        }
        EncodeHintType encodeHintType2 = EncodeHintType.ERROR_CORRECTION;
        int i9 = enumMap.containsKey(encodeHintType2) ? Integer.parseInt(enumMap.get(encodeHintType2).toString()) : 33;
        EncodeHintType encodeHintType3 = EncodeHintType.AZTEC_LAYERS;
        int i10 = enumMap.containsKey(encodeHintType3) ? Integer.parseInt(enumMap.get(encodeHintType3).toString()) : 0;
        int i11 = 1;
        if (i != 1) {
            throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf$1(i)));
        }
        HighLevelEncoder highLevelEncoder = new HighLevelEncoder(str.getBytes(charsetForName));
        List<State> listSingletonList = Collections.singletonList(State.INITIAL_STATE);
        int i12 = 0;
        while (true) {
            bArr = highLevelEncoder.text;
            int i13 = 4;
            i2 = 3;
            int i14 = 2;
            if (i12 >= bArr.length) {
                break;
            }
            int i15 = i12 + 1;
            byte b = i15 < bArr.length ? bArr[i15] : (byte) 0;
            byte b2 = bArr[i12];
            if (b2 != 13) {
                if (b2 != 44) {
                    if (b2 != 46) {
                        if (b2 == 58 && b == 32) {
                            i7 = 5;
                        } else {
                            i7 = 0;
                        }
                    } else if (b == 32) {
                        i7 = 3;
                    } else {
                        i7 = 0;
                    }
                } else if (b == 32) {
                    i7 = 4;
                } else {
                    i7 = 0;
                }
            } else if (b == 10) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if (i7 > 0) {
                LinkedList linkedList = new LinkedList();
                for (State state : listSingletonList) {
                    State stateEndBinaryShift = state.endBinaryShift(i12);
                    linkedList.add(stateEndBinaryShift.latchAndAppend(4, i7));
                    if (state.mode != 4) {
                        linkedList.add(stateEndBinaryShift.shiftAndAppend(4, i7));
                    }
                    if (i7 == 3 || i7 == 4) {
                        linkedList.add(stateEndBinaryShift.latchAndAppend(2, 16 - i7).latchAndAppend(2, i11));
                    }
                    if (state.binaryShiftByteCount > 0) {
                        linkedList.add(state.addBinaryShiftChar(i12).addBinaryShiftChar(i15));
                    }
                }
                listSingletonList = HighLevelEncoder.simplifyStates(linkedList);
                i12 = i15;
            } else {
                LinkedList linkedList2 = new LinkedList();
                for (State state2 : listSingletonList) {
                    char c = (char) (bArr[i12] & 255);
                    int i16 = state2.mode;
                    int[][] iArr = HighLevelEncoder.CHAR_MAP;
                    int i17 = iArr[i16][c] > 0 ? i11 : 0;
                    int i18 = 0;
                    State stateEndBinaryShift2 = null;
                    while (true) {
                        i8 = state2.mode;
                        if (i18 > i13) {
                            break;
                        }
                        int i19 = iArr[i18][c];
                        if (i19 > 0) {
                            if (stateEndBinaryShift2 == null) {
                                stateEndBinaryShift2 = state2.endBinaryShift(i12);
                            }
                            if (i17 == 0 || i18 == i8 || i18 == i14) {
                                linkedList2.add(stateEndBinaryShift2.latchAndAppend(i18, i19));
                            }
                            if (i17 == 0 && HighLevelEncoder.SHIFT_TABLE[i8][i18] >= 0) {
                                linkedList2.add(stateEndBinaryShift2.shiftAndAppend(i18, i19));
                            }
                        }
                        i18++;
                        i13 = 4;
                        i14 = 2;
                    }
                    if (state2.binaryShiftByteCount > 0 || iArr[i8][c] == 0) {
                        linkedList2.add(state2.addBinaryShiftChar(i12));
                    }
                    i11 = 1;
                    i13 = 4;
                    i14 = 2;
                }
                listSingletonList = HighLevelEncoder.simplifyStates(linkedList2);
                i11 = 1;
            }
            i12 += i11;
        }
        State state3 = (State) Collections.min(listSingletonList, new com.google.android.gms.location.zzn(4));
        state3.getClass();
        LinkedList linkedList3 = new LinkedList();
        for (Token token = state3.endBinaryShift(bArr.length).token; token != null; token = token.previous) {
            linkedList3.addFirst(token);
        }
        BitArray bitArray = new BitArray();
        Iterator it = linkedList3.iterator();
        while (it.hasNext()) {
            ((Token) it.next()).appendTo(bitArray, bArr);
        }
        int i20 = bitArray.size;
        int iM$1 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1(i20, i9, 100, 11);
        int i21 = i20 + iM$1;
        int[] iArr2 = Encoder.WORD_SIZE;
        if (i10 != 0) {
            z = i10 < 0;
            iAbs = Math.abs(i10);
            if (iAbs > (z ? 4 : 32)) {
                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i10, "Illegal value ", " for layers"));
            }
            i5 = ((z ? 88 : 112) + (iAbs << 4)) * iAbs;
            i4 = iArr2[iAbs];
            int i22 = i5 - (i5 % i4);
            bitArrayStuffBits = Encoder.stuffBits(bitArray, i4);
            int i23 = bitArrayStuffBits.size;
            if (iM$1 + i23 > i22) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
            if (z && i23 > (i4 << 6)) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
        } else {
            int i24 = 0;
            int i25 = 0;
            BitArray bitArrayStuffBits2 = null;
            while (true) {
                if (i24 > 32) {
                    throw new IllegalArgumentException("Data too large for an Aztec code");
                }
                boolean z2 = i24 <= i2;
                int i26 = z2 ? i24 + 1 : i24;
                int i27 = ((z2 ? 88 : 112) + (i26 << 4)) * i26;
                if (i21 <= i27) {
                    if (bitArrayStuffBits2 == null || i25 != iArr2[i26]) {
                        i3 = iArr2[i26];
                        bitArrayStuffBits2 = Encoder.stuffBits(bitArray, i3);
                    } else {
                        i3 = i25;
                    }
                    int i28 = i27 - (i27 % i3);
                    if ((!z2 || bitArrayStuffBits2.size <= (i3 << 6)) && bitArrayStuffBits2.size + iM$1 <= i28) {
                        i4 = i3;
                        z = z2;
                        iAbs = i26;
                        i5 = i27;
                        bitArrayStuffBits = bitArrayStuffBits2;
                        break;
                    }
                    i25 = i3;
                }
                i24++;
                i2 = 3;
            }
        }
        BitArray bitArrayGenerateCheckWords2 = Encoder.generateCheckWords(bitArrayStuffBits, i5, i4);
        int i29 = bitArrayStuffBits.size / i4;
        BitArray bitArray2 = new BitArray();
        if (z) {
            bitArray2.appendBits(iAbs - 1, 2);
            bitArray2.appendBits(i29 - 1, 6);
            bitArrayGenerateCheckWords = Encoder.generateCheckWords(bitArray2, 28, 4);
        } else {
            bitArray2.appendBits(iAbs - 1, 5);
            bitArray2.appendBits(i29 - 1, 11);
            bitArrayGenerateCheckWords = Encoder.generateCheckWords(bitArray2, 40, 4);
        }
        int i30 = (z ? 11 : 14) + (iAbs << 2);
        int[] iArr3 = new int[i30];
        if (z) {
            for (int i31 = 0; i31 < i30; i31++) {
                iArr3[i31] = i31;
            }
            i6 = i30;
        } else {
            int i32 = i30 / 2;
            i6 = (((i32 - 1) / 15) * 2) + i30 + 1;
            int i33 = i6 / 2;
            for (int i34 = 0; i34 < i32; i34++) {
                int i35 = (i34 / 15) + i34;
                iArr3[(i32 - i34) - 1] = (i33 - i35) - 1;
                iArr3[i32 + i34] = i35 + i33 + 1;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i6, i6);
        int i36 = 0;
        for (int i37 = 0; i37 < iAbs; i37++) {
            int i38 = ((iAbs - i37) << 2) + (z ? 9 : 12);
            for (int i39 = 0; i39 < i38; i39++) {
                int i40 = i39 << 1;
                int i41 = 0;
                for (int i42 = 2; i41 < i42; i42 = 2) {
                    if (bitArrayGenerateCheckWords2.get(i36 + i40 + i41)) {
                        int i43 = i37 << 1;
                        bitMatrix.set(iArr3[i43 + i41], iArr3[i43 + i39]);
                    }
                    if (bitArrayGenerateCheckWords2.get((i38 << 1) + i36 + i40 + i41)) {
                        int i44 = i37 << 1;
                        bitMatrix.set(iArr3[i44 + i39], iArr3[((i30 - 1) - i44) - i41]);
                    }
                    if (bitArrayGenerateCheckWords2.get((i38 << 2) + i36 + i40 + i41)) {
                        int i45 = (i30 - 1) - (i37 << 1);
                        bitMatrix.set(iArr3[i45 - i41], iArr3[i45 - i39]);
                    }
                    if (bitArrayGenerateCheckWords2.get((i38 * 6) + i36 + i40 + i41)) {
                        int i46 = i37 << 1;
                        bitMatrix.set(iArr3[((i30 - 1) - i46) - i39], iArr3[i46 + i41]);
                    }
                    i41++;
                }
            }
            i36 += i38 << 3;
        }
        int i47 = i6 / 2;
        if (z) {
            for (int i48 = 0; i48 < 7; i48++) {
                int i49 = (i47 - 3) + i48;
                if (bitArrayGenerateCheckWords.get(i48)) {
                    bitMatrix.set(i49, i47 - 5);
                }
                if (bitArrayGenerateCheckWords.get(i48 + 7)) {
                    bitMatrix.set(i47 + 5, i49);
                }
                if (bitArrayGenerateCheckWords.get(20 - i48)) {
                    bitMatrix.set(i49, i47 + 5);
                }
                if (bitArrayGenerateCheckWords.get(27 - i48)) {
                    bitMatrix.set(i47 - 5, i49);
                }
            }
        } else {
            for (int i50 = 0; i50 < 10; i50++) {
                int i51 = (i50 / 5) + (i47 - 5) + i50;
                if (bitArrayGenerateCheckWords.get(i50)) {
                    bitMatrix.set(i51, i47 - 7);
                }
                if (bitArrayGenerateCheckWords.get(i50 + 10)) {
                    bitMatrix.set(i47 + 7, i51);
                }
                if (bitArrayGenerateCheckWords.get(29 - i50)) {
                    bitMatrix.set(i51, i47 + 7);
                }
                if (bitArrayGenerateCheckWords.get(39 - i50)) {
                    bitMatrix.set(i47 - 7, i51);
                }
            }
        }
        if (z) {
            Encoder.drawBullsEye(bitMatrix, i47, 5);
        } else {
            Encoder.drawBullsEye(bitMatrix, i47, 7);
            int i52 = 0;
            int i53 = 0;
            while (i52 < (i30 / 2) - 1) {
                for (int i54 = i47 & 1; i54 < i6; i54 += 2) {
                    int i55 = i47 - i53;
                    bitMatrix.set(i55, i54);
                    int i56 = i47 + i53;
                    bitMatrix.set(i56, i54);
                    bitMatrix.set(i54, i55);
                    bitMatrix.set(i54, i56);
                }
                i52 += 15;
                i53 += 16;
            }
        }
        int i57 = bitMatrix.width;
        int iMax = Math.max(200, i57);
        int i58 = bitMatrix.height;
        int iMax2 = Math.max(200, i58);
        int iMin = Math.min(iMax / i57, iMax2 / i58);
        int i59 = (iMax - (i57 * iMin)) / 2;
        int i60 = (iMax2 - (i58 * iMin)) / 2;
        BitMatrix bitMatrix2 = new BitMatrix(iMax, iMax2);
        int i61 = 0;
        while (i61 < i58) {
            int i62 = i59;
            int i63 = 0;
            while (i63 < i57) {
                if (bitMatrix.get(i63, i61)) {
                    bitMatrix2.setRegion(i62, i60, iMin, iMin);
                }
                i63++;
                i62 += iMin;
            }
            i61++;
            i60 += iMin;
        }
        return bitMatrix2;
    }

    private final BitMatrix encode$com$google$zxing$datamatrix$DataMatrixWriter(String str, int i, EnumMap enumMap) {
        int i2;
        int i3;
        int i4;
        char c;
        char c2;
        int i5;
        byte[] bArr;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        BitMatrix bitMatrix;
        int i12 = 0;
        int i13 = 3;
        int i14 = 2;
        int i15 = 1;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i != 6) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf$1(i)));
        }
        SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
        SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) enumMap.get(EncodeHintType.DATA_MATRIX_SHAPE);
        if (symbolShapeHint2 != null) {
            symbolShapeHint = symbolShapeHint2;
        }
        if (enumMap.get(EncodeHintType.MIN_SIZE) != null) {
            throw new ClassCastException();
        }
        if (enumMap.get(EncodeHintType.MAX_SIZE) != null) {
            throw new ClassCastException();
        }
        zzr[] zzrVarArr = {new zzr(21), new zzr(23), new X12Encoder(1), new X12Encoder(0), new zzr(24), new zzr(22)};
        EncoderContext encoderContext = new EncoderContext(str);
        encoderContext.shape = symbolShapeHint;
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            encoderContext.writeCodeword((char) 236);
            encoderContext.skipAtEnd = 2;
            encoderContext.pos += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            encoderContext.writeCodeword((char) 237);
            encoderContext.skipAtEnd = 2;
            encoderContext.pos += 7;
        }
        int i16 = 0;
        while (encoderContext.hasMoreCharacters()) {
            zzrVarArr[i16].encode(encoderContext);
            int i17 = encoderContext.newEncoding;
            if (i17 >= 0) {
                encoderContext.newEncoding = -1;
                i16 = i17;
            }
        }
        StringBuilder sb = encoderContext.codewords;
        int length = sb.length();
        encoderContext.updateSymbolInfo(sb.length());
        int i18 = encoderContext.symbolInfo.dataCapacity;
        if (length < i18 && i16 != 0 && i16 != 5 && i16 != 4) {
            encoderContext.writeCodeword((char) 254);
        }
        if (sb.length() < i18) {
            sb.append((char) 129);
        }
        while (sb.length() < i18) {
            int length2 = ((sb.length() + 1) * 149) % 253;
            int i19 = length2 + 130;
            if (i19 > 254) {
                i19 = length2 - 124;
            }
            sb.append((char) i19);
        }
        String string = sb.toString();
        SymbolInfo symbolInfoLookup = SymbolInfo.lookup(string.length(), symbolShapeHint);
        int[] iArr = ErrorCorrection.FACTOR_SETS;
        int length3 = string.length();
        int i20 = symbolInfoLookup.dataCapacity;
        if (length3 != i20) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        int i21 = symbolInfoLookup.errorCodewords;
        StringBuilder sb2 = new StringBuilder(i20 + i21);
        sb2.append(string);
        int interleavedBlockCount = symbolInfoLookup.getInterleavedBlockCount();
        if (interleavedBlockCount == 1) {
            sb2.append(ErrorCorrection.createECCBlock(i21, string));
        } else {
            sb2.setLength(sb2.capacity());
            int[] iArr2 = new int[interleavedBlockCount];
            int[] iArr3 = new int[interleavedBlockCount];
            int[] iArr4 = new int[interleavedBlockCount];
            int i22 = 0;
            while (i22 < interleavedBlockCount) {
                int i23 = i22 + 1;
                iArr2[i22] = symbolInfoLookup.getDataLengthForInterleavedBlock(i23);
                iArr3[i22] = symbolInfoLookup.rsBlockError;
                iArr4[i22] = 0;
                if (i22 > 0) {
                    iArr4[i22] = iArr4[i22 - 1] + iArr2[i22];
                }
                i22 = i23;
            }
            for (int i24 = 0; i24 < interleavedBlockCount; i24++) {
                StringBuilder sb3 = new StringBuilder(iArr2[i24]);
                for (int i25 = i24; i25 < i20; i25 += interleavedBlockCount) {
                    sb3.append(string.charAt(i25));
                }
                String strCreateECCBlock = ErrorCorrection.createECCBlock(iArr3[i24], sb3.toString());
                int i26 = i24;
                int i27 = 0;
                while (i26 < iArr3[i24] * interleavedBlockCount) {
                    sb2.setCharAt(i20 + i26, strCreateECCBlock.charAt(i27));
                    i26 += interleavedBlockCount;
                    i27++;
                }
            }
        }
        String string2 = sb2.toString();
        int horizontalDataRegions = symbolInfoLookup.getHorizontalDataRegions();
        int i28 = symbolInfoLookup.matrixWidth;
        int verticalDataRegions = symbolInfoLookup.getVerticalDataRegions();
        int i29 = symbolInfoLookup.matrixHeight;
        AppCompatTextHelper.AnonymousClass1 anonymousClass1 = new AppCompatTextHelper.AnonymousClass1(string2, horizontalDataRegions * i28, verticalDataRegions * i29);
        int i30 = 0;
        int i31 = 0;
        int i32 = 4;
        while (true) {
            i2 = anonymousClass1.val$style;
            i3 = anonymousClass1.val$fontWeight;
            if (i32 == i3 && i30 == 0) {
                int i33 = i3 - 1;
                anonymousClass1.module(i33, i12, i31, i15);
                anonymousClass1.module(i33, i15, i31, i14);
                anonymousClass1.module(i33, i14, i31, i13);
                anonymousClass1.module(i12, i2 - 2, i31, 4);
                int i34 = i2 - 1;
                anonymousClass1.module(i12, i34, i31, 5);
                anonymousClass1.module(i15, i34, i31, 6);
                anonymousClass1.module(i14, i34, i31, 7);
                anonymousClass1.module(i13, i34, i31, 8);
                i31++;
            }
            i4 = i3 - 2;
            if (i32 == i4 && i30 == 0 && i2 % 4 != 0) {
                anonymousClass1.module(i3 - 3, i12, i31, i15);
                anonymousClass1.module(i4, i12, i31, i14);
                anonymousClass1.module(i3 - 1, i12, i31, i13);
                anonymousClass1.module(i12, i2 - 4, i31, 4);
                anonymousClass1.module(i12, i2 - 3, i31, 5);
                anonymousClass1.module(i12, i2 - 2, i31, 6);
                i15 = 1;
                int i35 = i2 - 1;
                anonymousClass1.module(i12, i35, i31, 7);
                c = '\b';
                anonymousClass1.module(1, i35, i31, 8);
                i31++;
            } else {
                c = '\b';
            }
            if (i32 == i4 && i30 == 0) {
                if (i2 % 8 == 4) {
                    anonymousClass1.module(i3 - 3, i12, i31, i15);
                    i5 = 2;
                    anonymousClass1.module(i4, i12, i31, 2);
                    anonymousClass1.module(i3 - 1, i12, i31, i13);
                    anonymousClass1.module(i12, i2 - 2, i31, 4);
                    int i36 = i2 - 1;
                    anonymousClass1.module(i12, i36, i31, 5);
                    anonymousClass1.module(i15, i36, i31, 6);
                    anonymousClass1.module(2, i36, i31, 7);
                    c2 = '\b';
                    anonymousClass1.module(3, i36, i31, 8);
                    i31++;
                } else {
                    c2 = '\b';
                }
                if (i32 != i3 + 4 && i30 == i5 && i2 % 8 == 0) {
                    int i37 = i3 - 1;
                    anonymousClass1.module(i37, i12, i31, 1);
                    int i38 = i2 - 1;
                    anonymousClass1.module(i37, i38, i31, i5);
                    int i39 = i2 - 3;
                    anonymousClass1.module(i12, i39, i31, 3);
                    int i40 = i2 - 2;
                    anonymousClass1.module(i12, i40, i31, 4);
                    anonymousClass1.module(i12, i38, i31, 5);
                    anonymousClass1.module(1, i39, i31, 6);
                    anonymousClass1.module(1, i40, i31, 7);
                    anonymousClass1.module(1, i38, i31, 8);
                    i31++;
                }
                while (true) {
                    bArr = (byte[]) anonymousClass1.this$0;
                    if (i32 < i3 && i30 >= 0 && bArr[(i32 * i2) + i30] < 0) {
                        anonymousClass1.utah(i32, i30, i31);
                        i31++;
                    }
                    i6 = i32 - 2;
                    i7 = i30 + 2;
                    if (i6 < 0 || i7 >= i2) {
                        break;
                    }
                    i30 = i7;
                    i32 = i6;
                }
                i8 = i32 - 1;
                i9 = i30 + 5;
                while (true) {
                    if (i8 >= 0 && i9 < i2 && bArr[(i8 * i2) + i9] < 0) {
                        anonymousClass1.utah(i8, i9, i31);
                        i31++;
                    }
                    i10 = i8 + 2;
                    i11 = i9 - 2;
                    if (i10 >= i3 || i11 < 0) {
                        break;
                    }
                    i9 = i11;
                    i8 = i10;
                }
                i32 = i8 + 5;
                i30 = i9 - 1;
                if (i32 < i3 && i30 >= i2) {
                    break;
                }
                i14 = 2;
                i12 = 0;
                i15 = 1;
                i13 = 3;
            } else {
                c2 = c;
            }
            i5 = 2;
            if (i32 != i3 + 4) {
            }
            while (true) {
                bArr = (byte[]) anonymousClass1.this$0;
                if (i32 < i3) {
                    anonymousClass1.utah(i32, i30, i31);
                    i31++;
                }
                i6 = i32 - 2;
                i7 = i30 + 2;
                if (i6 < 0) {
                    break;
                }
                break;
                break;
                i30 = i7;
                i32 = i6;
            }
            i8 = i32 - 1;
            i9 = i30 + 5;
            while (true) {
                if (i8 >= 0) {
                    anonymousClass1.utah(i8, i9, i31);
                    i31++;
                }
                i10 = i8 + 2;
                i11 = i9 - 2;
                if (i10 >= i3) {
                    break;
                }
                break;
                break;
                i9 = i11;
                i8 = i10;
            }
            i32 = i8 + 5;
            i30 = i9 - 1;
            if (i32 < i3) {
            }
            i14 = 2;
            i12 = 0;
            i15 = 1;
            i13 = 3;
        }
        int i41 = i2 - 1;
        int i42 = i3 - 1;
        if (bArr[(i42 * i2) + i41] < 0) {
            int i43 = (i42 * i2) + i41;
            byte b = (byte) 1;
            bArr[i43] = b;
            bArr[(i4 * i2) + (i2 - 2)] = b;
        }
        int horizontalDataRegions2 = symbolInfoLookup.getHorizontalDataRegions() * i28;
        int verticalDataRegions2 = symbolInfoLookup.getVerticalDataRegions() * i29;
        Huffman.Node node = new Huffman.Node((symbolInfoLookup.getHorizontalDataRegions() * i28) + (symbolInfoLookup.getHorizontalDataRegions() << 1), (symbolInfoLookup.getVerticalDataRegions() * i29) + (symbolInfoLookup.getVerticalDataRegions() << 1), 1);
        int i44 = 0;
        int i45 = 0;
        while (i44 < verticalDataRegions2) {
            int i46 = i44 % i29;
            if (i46 == 0) {
                int i47 = 0;
                for (int i48 = 0; i48 < (symbolInfoLookup.getHorizontalDataRegions() * i28) + (symbolInfoLookup.getHorizontalDataRegions() << 1); i48++) {
                    node.set(i47, i45, i48 % 2 == 0);
                    i47++;
                }
                i45++;
            }
            int i49 = 0;
            int i50 = 0;
            while (i49 < horizontalDataRegions2) {
                int i51 = i49 % i28;
                if (i51 == 0) {
                    node.set(i50, i45, true);
                    i50++;
                }
                node.set(i50, i45, bArr[(i44 * i2) + i49] == 1);
                int i52 = i50 + 1;
                int i53 = horizontalDataRegions2;
                if (i51 == i28 - 1) {
                    node.set(i52, i45, i44 % 2 == 0);
                    i50 += 2;
                } else {
                    i50 = i52;
                }
                i49++;
                horizontalDataRegions2 = i53;
            }
            int i54 = horizontalDataRegions2;
            int i55 = i45 + 1;
            if (i46 == i29 - 1) {
                int i56 = 0;
                for (int i57 = 0; i57 < (symbolInfoLookup.getHorizontalDataRegions() * i28) + (symbolInfoLookup.getHorizontalDataRegions() << 1); i57++) {
                    node.set(i56, i55, true);
                    i56++;
                }
                i45 += 2;
            } else {
                i45 = i55;
            }
            i44++;
            horizontalDataRegions2 = i54;
        }
        int i58 = node.symbol;
        int iMax = Math.max(200, i58);
        int i59 = node.terminalBitCount;
        int iMax2 = Math.max(200, i59);
        int iMin = Math.min(iMax / i58, iMax2 / i59);
        int i60 = (iMax - (i58 * iMin)) / 2;
        int i61 = (iMax2 - (i59 * iMin)) / 2;
        if (200 < i59 || 200 < i58) {
            bitMatrix = new BitMatrix(i58, i59);
            i60 = 0;
            i61 = 0;
        } else {
            bitMatrix = new BitMatrix(200, 200);
        }
        int[] iArr5 = bitMatrix.bits;
        int length4 = iArr5.length;
        for (int i62 = 0; i62 < length4; i62++) {
            iArr5[i62] = 0;
        }
        int i63 = 0;
        while (i63 < i59) {
            int i64 = i60;
            int i65 = 0;
            while (i65 < i58) {
                if (node.get(i65, i63) == 1) {
                    bitMatrix.setRegion(i64, i61, iMin, iMin);
                }
                i65++;
                i64 += iMin;
            }
            i63++;
            i61 += iMin;
        }
        return bitMatrix;
    }

    public static String encodeToCodewords(StringBuilder sb) {
        int length = sb.length();
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        int iCharAt = (sb.charAt(0) << 18) + ((length >= 2 ? sb.charAt(1) : (char) 0) << '\f') + ((length >= 3 ? sb.charAt(2) : (char) 0) << 6) + (length >= 4 ? sb.charAt(3) : (char) 0);
        char c = (char) ((iCharAt >> 16) & 255);
        char c2 = (char) ((iCharAt >> 8) & 255);
        char c3 = (char) (iCharAt & 255);
        StringBuilder sb2 = new StringBuilder(3);
        sb2.append(c);
        if (length >= 2) {
            sb2.append(c2);
        }
        if (length >= 3) {
            sb2.append(c3);
        }
        return sb2.toString();
    }

    public static boolean isAndroid() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    public static byte[][] rotateArray(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, bArr[0].length, bArr.length);
        for (int i = 0; i < bArr.length; i++) {
            int length = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length] = bArr[i][i2];
            }
        }
        return bArr2;
    }

    public static void writeNextTriplet(EncoderContext encoderContext, StringBuilder sb) {
        int iCharAt = (sb.charAt(1) * '(') + (sb.charAt(0) * 1600) + sb.charAt(2) + 1;
        encoderContext.codewords.append(new String(new char[]{(char) (iCharAt / 256), (char) (iCharAt % 256)}));
        sb.delete(0, 3);
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.$r8$classId) {
            case 8:
                return new ConcurrentHashMap();
            case 9:
                return new TreeMap();
            case 10:
                return new LinkedHashMap();
            case 11:
                return new LinkedTreeMap();
            case 12:
                return new TreeSet();
            case 13:
                return new LinkedHashSet();
            case 14:
                return new ArrayDeque();
            case 15:
                return new ArrayList();
            default:
                return new ConcurrentSkipListMap();
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:105:0x0213  */
    /* JADX WARN: Code duplicated, block: B:108:0x021d  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b6 A[Catch: all -> 0x009a, TryCatch #0 {all -> 0x009a, blocks: (B:25:0x005f, B:30:0x006c, B:32:0x0088, B:41:0x00a6, B:47:0x00b6, B:49:0x00ca, B:51:0x00d9, B:52:0x00e1, B:54:0x00e6, B:55:0x00ed), top: B:151:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00ca A[Catch: all -> 0x009a, TryCatch #0 {all -> 0x009a, blocks: (B:25:0x005f, B:30:0x006c, B:32:0x0088, B:41:0x00a6, B:47:0x00b6, B:49:0x00ca, B:51:0x00d9, B:52:0x00e1, B:54:0x00e6, B:55:0x00ed), top: B:151:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00d9 A[Catch: all -> 0x009a, TryCatch #0 {all -> 0x009a, blocks: (B:25:0x005f, B:30:0x006c, B:32:0x0088, B:41:0x00a6, B:47:0x00b6, B:49:0x00ca, B:51:0x00d9, B:52:0x00e1, B:54:0x00e6, B:55:0x00ed), top: B:151:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00e1 A[Catch: all -> 0x009a, TryCatch #0 {all -> 0x009a, blocks: (B:25:0x005f, B:30:0x006c, B:32:0x0088, B:41:0x00a6, B:47:0x00b6, B:49:0x00ca, B:51:0x00d9, B:52:0x00e1, B:54:0x00e6, B:55:0x00ed), top: B:151:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00e6 A[Catch: all -> 0x009a, TryCatch #0 {all -> 0x009a, blocks: (B:25:0x005f, B:30:0x006c, B:32:0x0088, B:41:0x00a6, B:47:0x00b6, B:49:0x00ca, B:51:0x00d9, B:52:0x00e1, B:54:0x00e6, B:55:0x00ed), top: B:151:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:89:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:90:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:94:0x01df  */
    /* JADX WARN: Code duplicated, block: B:96:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:97:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:99:0x01ec  */
    public void encode(EncoderContext encoderContext) {
        int i;
        int length;
        StringBuilder sb;
        int length2;
        boolean z;
        int length3;
        int length4;
        String str;
        StringBuilder sb2;
        boolean z2;
        int i2;
        String strEncodeToCodewords;
        switch (this.$r8$classId) {
            case 21:
                int i3 = encoderContext.pos;
                String str2 = encoderContext.msg;
                int length5 = str2.length();
                if (i3 < length5) {
                    char cCharAt = str2.charAt(i3);
                    i = 0;
                    while (JvmClassMappingKt.isDigit(cCharAt) && i3 < length5) {
                        i++;
                        i3++;
                        if (i3 < length5) {
                            cCharAt = str2.charAt(i3);
                        }
                    }
                } else {
                    i = 0;
                }
                if (i >= 2) {
                    char cCharAt2 = str2.charAt(encoderContext.pos);
                    char cCharAt3 = str2.charAt(encoderContext.pos + 1);
                    if (!JvmClassMappingKt.isDigit(cCharAt2) || !JvmClassMappingKt.isDigit(cCharAt3)) {
                        throw new IllegalArgumentException("not digits: " + cCharAt2 + cCharAt3);
                    }
                    encoderContext.writeCodeword((char) ((cCharAt3 - '0') + ((cCharAt2 - '0') * 10) + 130));
                    encoderContext.pos += 2;
                    return;
                }
                char currentChar = encoderContext.getCurrentChar();
                int iLookAheadTest = JvmClassMappingKt.lookAheadTest(str2, encoderContext.pos, 0);
                if (iLookAheadTest == 0) {
                    if (!JvmClassMappingKt.isExtendedASCII(currentChar)) {
                        encoderContext.writeCodeword((char) (currentChar + 1));
                        encoderContext.pos++;
                        return;
                    } else {
                        encoderContext.writeCodeword((char) 235);
                        encoderContext.writeCodeword((char) (currentChar - 127));
                        encoderContext.pos++;
                        return;
                    }
                }
                if (iLookAheadTest == 1) {
                    encoderContext.writeCodeword((char) 230);
                    encoderContext.newEncoding = 1;
                    return;
                }
                if (iLookAheadTest == 2) {
                    encoderContext.writeCodeword((char) 239);
                    encoderContext.newEncoding = 2;
                    return;
                }
                if (iLookAheadTest == 3) {
                    encoderContext.writeCodeword((char) 238);
                    encoderContext.newEncoding = 3;
                    return;
                } else if (iLookAheadTest == 4) {
                    encoderContext.writeCodeword((char) 240);
                    encoderContext.newEncoding = 4;
                    return;
                } else {
                    if (iLookAheadTest != 5) {
                        throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(iLookAheadTest)));
                    }
                    encoderContext.writeCodeword((char) 231);
                    encoderContext.newEncoding = 5;
                    return;
                }
            case 22:
                StringBuilder sb3 = new StringBuilder();
                sb3.append((char) 0);
                while (encoderContext.hasMoreCharacters()) {
                    sb3.append(encoderContext.getCurrentChar());
                    int i4 = encoderContext.pos + 1;
                    encoderContext.pos = i4;
                    if (JvmClassMappingKt.lookAheadTest(encoderContext.msg, i4, 5) != 5) {
                        encoderContext.newEncoding = 0;
                        length = sb3.length() - 1;
                        sb = encoderContext.codewords;
                        length2 = sb.length() + length + 1;
                        encoderContext.updateSymbolInfo(length2);
                        if (encoderContext.symbolInfo.dataCapacity - length2 > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (encoderContext.hasMoreCharacters() || z) {
                            if (length <= 249) {
                                sb3.setCharAt(0, (char) length);
                            } else {
                                if (length > 1555) {
                                    throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
                                }
                                sb3.setCharAt(0, (char) ((length / 250) + 249));
                                sb3.insert(1, (char) (length % 250));
                            }
                        }
                        length3 = sb3.length();
                        for (int i5 = 0; i5 < length3; i5++) {
                            length4 = (((sb.length() + 1) * 149) % 255) + 1 + sb3.charAt(i5);
                            if (length4 > 255) {
                                length4 -= 256;
                            }
                            encoderContext.writeCodeword((char) length4);
                        }
                        return;
                    }
                }
                length = sb3.length() - 1;
                sb = encoderContext.codewords;
                length2 = sb.length() + length + 1;
                encoderContext.updateSymbolInfo(length2);
                if (encoderContext.symbolInfo.dataCapacity - length2 > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (encoderContext.hasMoreCharacters()) {
                    if (length <= 249) {
                        sb3.setCharAt(0, (char) length);
                    } else {
                        if (length > 1555) {
                            throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
                        }
                        sb3.setCharAt(0, (char) ((length / 250) + 249));
                        sb3.insert(1, (char) (length % 250));
                    }
                } else if (length <= 249) {
                    sb3.setCharAt(0, (char) length);
                } else {
                    if (length > 1555) {
                        throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
                    }
                    sb3.setCharAt(0, (char) ((length / 250) + 249));
                    sb3.insert(1, (char) (length % 250));
                }
                length3 = sb3.length();
                while (i5 < length3) {
                    length4 = (((sb.length() + 1) * 149) % 255) + 1 + sb3.charAt(i5);
                    if (length4 > 255) {
                        length4 -= 256;
                    }
                    encoderContext.writeCodeword((char) length4);
                }
                return;
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                StringBuilder sb4 = new StringBuilder();
                while (encoderContext.hasMoreCharacters()) {
                    char currentChar2 = encoderContext.getCurrentChar();
                    encoderContext.pos++;
                    int iEncodeChar = encodeChar(currentChar2, sb4);
                    int length6 = encoderContext.codewords.length() + ((sb4.length() / 3) << 1);
                    encoderContext.updateSymbolInfo(length6);
                    int i6 = encoderContext.symbolInfo.dataCapacity - length6;
                    if (!encoderContext.hasMoreCharacters()) {
                        StringBuilder sb5 = new StringBuilder();
                        if (sb4.length() % 3 == 2 && (i6 < 2 || i6 > 2)) {
                            int length7 = sb4.length();
                            sb4.delete(length7 - iEncodeChar, length7);
                            encoderContext.pos--;
                            iEncodeChar = encodeChar(encoderContext.getCurrentChar(), sb5);
                            encoderContext.symbolInfo = null;
                        }
                        while (sb4.length() % 3 == 1 && ((iEncodeChar <= 3 && i6 != 1) || iEncodeChar > 3)) {
                            int length8 = sb4.length();
                            sb4.delete(length8 - iEncodeChar, length8);
                            encoderContext.pos--;
                            iEncodeChar = encodeChar(encoderContext.getCurrentChar(), sb5);
                            encoderContext.symbolInfo = null;
                        }
                    } else if (sb4.length() % 3 == 0) {
                        if (JvmClassMappingKt.lookAheadTest(encoderContext.msg, encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                            encoderContext.newEncoding = 0;
                        }
                    }
                    handleEOD(encoderContext, sb4);
                    return;
                }
                handleEOD(encoderContext, sb4);
                return;
            default:
                StringBuilder sb6 = new StringBuilder();
                while (true) {
                    boolean zHasMoreCharacters = encoderContext.hasMoreCharacters();
                    str = encoderContext.msg;
                    sb2 = encoderContext.codewords;
                    z2 = true;
                    if (zHasMoreCharacters) {
                        char currentChar3 = encoderContext.getCurrentChar();
                        if (currentChar3 >= ' ' && currentChar3 <= '?') {
                            sb6.append(currentChar3);
                        } else {
                            if (currentChar3 < '@' || currentChar3 > '^') {
                                JvmClassMappingKt.illegalCharacter(currentChar3);
                                throw null;
                            }
                            sb6.append((char) (currentChar3 - '@'));
                        }
                        encoderContext.pos++;
                        if (sb6.length() >= 4) {
                            sb2.append(encodeToCodewords(sb6));
                            sb6.delete(0, 4);
                            if (JvmClassMappingKt.lookAheadTest(str, encoderContext.pos, 4) != 4) {
                                encoderContext.newEncoding = 0;
                            }
                        }
                    }
                }
                sb6.append((char) 31);
                try {
                    int length9 = sb6.length();
                    if (length9 == 0) {
                        encoderContext.newEncoding = 0;
                        return;
                    }
                    if (length9 == 1) {
                        encoderContext.updateSymbolInfo(sb2.length());
                        int length10 = encoderContext.symbolInfo.dataCapacity - sb2.length();
                        int length11 = (str.length() - encoderContext.skipAtEnd) - encoderContext.pos;
                        if (length11 > length10) {
                            encoderContext.updateSymbolInfo(sb2.length() + 1);
                            length10 = encoderContext.symbolInfo.dataCapacity - sb2.length();
                        }
                        if (length11 > length10 || length10 > 2) {
                            if (length9 <= 4) {
                                throw new IllegalStateException("Count must not exceed 4");
                            }
                            i2 = length9 - 1;
                            strEncodeToCodewords = encodeToCodewords(sb6);
                            if (encoderContext.hasMoreCharacters() || i2 > 2) {
                                z2 = false;
                            }
                            if (i2 <= 2) {
                                encoderContext.updateSymbolInfo(sb2.length() + i2);
                                if (encoderContext.symbolInfo.dataCapacity - sb2.length() >= 3) {
                                    encoderContext.updateSymbolInfo(sb2.length() + strEncodeToCodewords.length());
                                    z2 = false;
                                }
                            }
                            if (z2) {
                                encoderContext.symbolInfo = null;
                                encoderContext.pos -= i2;
                            } else {
                                sb2.append(strEncodeToCodewords);
                            }
                        }
                    } else {
                        if (length9 <= 4) {
                            throw new IllegalStateException("Count must not exceed 4");
                        }
                        i2 = length9 - 1;
                        strEncodeToCodewords = encodeToCodewords(sb6);
                        if (encoderContext.hasMoreCharacters()) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if (i2 <= 2) {
                            encoderContext.updateSymbolInfo(sb2.length() + i2);
                            if (encoderContext.symbolInfo.dataCapacity - sb2.length() >= 3) {
                                encoderContext.updateSymbolInfo(sb2.length() + strEncodeToCodewords.length());
                                z2 = false;
                            }
                        }
                        if (z2) {
                            encoderContext.symbolInfo = null;
                            encoderContext.pos -= i2;
                        } else {
                            sb2.append(strEncodeToCodewords);
                        }
                    }
                    encoderContext.newEncoding = 0;
                    return;
                } catch (Throwable th) {
                    encoderContext.newEncoding = 0;
                    throw th;
                }
        }
    }

    public int encodeChar(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c >= '0' && c <= '9') {
            sb.append((char) (c - ','));
            return 1;
        }
        if (c >= 'A' && c <= 'Z') {
            sb.append((char) (c - '3'));
            return 1;
        }
        if (c < ' ') {
            sb.append((char) 0);
            sb.append(c);
            return 2;
        }
        if (c >= '!' && c <= '/') {
            sb.append((char) 1);
            sb.append((char) (c - '!'));
            return 2;
        }
        if (c >= ':' && c <= '@') {
            sb.append((char) 1);
            sb.append((char) (c - '+'));
            return 2;
        }
        if (c >= '[' && c <= '_') {
            sb.append((char) 1);
            sb.append((char) (c - 'E'));
            return 2;
        }
        if (c < '`' || c > 127) {
            sb.append("\u0001\u001e");
            return encodeChar((char) (c - 128), sb) + 2;
        }
        sb.append((char) 2);
        sb.append((char) (c - '`'));
        return 2;
    }

    public int getEncodingMode() {
        return 1;
    }

    public void handleEOD(EncoderContext encoderContext, StringBuilder sb) {
        int length = (sb.length() / 3) << 1;
        int length2 = sb.length() % 3;
        int length3 = encoderContext.codewords.length() + length;
        encoderContext.updateSymbolInfo(length3);
        int i = encoderContext.symbolInfo.dataCapacity - length3;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword((char) 254);
            }
        } else if (i == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword((char) 254);
            }
            encoderContext.pos--;
        } else {
            if (length2 != 0) {
                throw new IllegalStateException("Unexpected case. Please report!");
            }
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (i > 0 || encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword((char) 254);
            }
        }
        encoderContext.newEncoding = 0;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004b A[DONT_INVERT, PHI: r6
  0x004b: PHI (r6v2 int) = (r6v1 int), (r6v3 int) binds: [B:18:0x0044, B:20:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:23:0x004d  */
    public DynamiteModule$VersionPolicy$SelectionResult selectModule(Context context, String str, DynamiteModule$VersionPolicy$IVersions dynamiteModule$VersionPolicy$IVersions) {
        int iZzb;
        switch (this.$r8$classId) {
            case 1:
                DynamiteModule$VersionPolicy$SelectionResult dynamiteModule$VersionPolicy$SelectionResult = new DynamiteModule$VersionPolicy$SelectionResult();
                int iZzb2 = dynamiteModule$VersionPolicy$IVersions.zzb(context, str, true);
                dynamiteModule$VersionPolicy$SelectionResult.remoteVersion = iZzb2;
                if (iZzb2 != 0) {
                    dynamiteModule$VersionPolicy$SelectionResult.selection = 1;
                } else {
                    int iZza = dynamiteModule$VersionPolicy$IVersions.zza(context, str);
                    dynamiteModule$VersionPolicy$SelectionResult.localVersion = iZza;
                    if (iZza != 0) {
                        dynamiteModule$VersionPolicy$SelectionResult.selection = -1;
                    }
                }
                return dynamiteModule$VersionPolicy$SelectionResult;
            case 2:
                DynamiteModule$VersionPolicy$SelectionResult dynamiteModule$VersionPolicy$SelectionResult2 = new DynamiteModule$VersionPolicy$SelectionResult();
                dynamiteModule$VersionPolicy$SelectionResult2.localVersion = dynamiteModule$VersionPolicy$IVersions.zza(context, str);
                int i = 1;
                int iZzb3 = dynamiteModule$VersionPolicy$IVersions.zzb(context, str, true);
                dynamiteModule$VersionPolicy$SelectionResult2.remoteVersion = iZzb3;
                int i2 = dynamiteModule$VersionPolicy$SelectionResult2.localVersion;
                if (i2 == 0) {
                    i2 = 0;
                    if (iZzb3 == 0) {
                        i = 0;
                    } else if (i2 >= iZzb3) {
                        i = -1;
                    }
                } else if (i2 >= iZzb3) {
                    i = -1;
                }
                dynamiteModule$VersionPolicy$SelectionResult2.selection = i;
                return dynamiteModule$VersionPolicy$SelectionResult2;
            default:
                DynamiteModule$VersionPolicy$SelectionResult dynamiteModule$VersionPolicy$SelectionResult3 = new DynamiteModule$VersionPolicy$SelectionResult();
                int iZza2 = dynamiteModule$VersionPolicy$IVersions.zza(context, str);
                dynamiteModule$VersionPolicy$SelectionResult3.localVersion = iZza2;
                int i3 = 1;
                int i4 = 0;
                if (iZza2 != 0) {
                    iZzb = dynamiteModule$VersionPolicy$IVersions.zzb(context, str, false);
                    dynamiteModule$VersionPolicy$SelectionResult3.remoteVersion = iZzb;
                } else {
                    iZzb = dynamiteModule$VersionPolicy$IVersions.zzb(context, str, true);
                    dynamiteModule$VersionPolicy$SelectionResult3.remoteVersion = iZzb;
                }
                int i5 = dynamiteModule$VersionPolicy$SelectionResult3.localVersion;
                if (i5 == 0) {
                    if (iZzb == 0) {
                        i3 = 0;
                    }
                    dynamiteModule$VersionPolicy$SelectionResult3.selection = i3;
                    return dynamiteModule$VersionPolicy$SelectionResult3;
                }
                i4 = i5;
                if (i4 >= iZzb) {
                    i3 = -1;
                }
                dynamiteModule$VersionPolicy$SelectionResult3.selection = i3;
                return dynamiteModule$VersionPolicy$SelectionResult3;
        }
    }

    @Override // com.google.android.gms.tasks.Continuation
    public /* bridge */ /* synthetic */ Object then(Task task) {
        switch (this.$r8$classId) {
            case 0:
                return (!task.isSuccessful() && (task.getException() instanceof FirebaseAuthException) && ((FirebaseAuthException) task.getException()).getErrorCode().equals("ERROR_INTERNAL_SUCCESS_SIGN_OUT")) ? WorkContinuation.forResult(null) : task;
            default:
                return !task.isSuccessful() ? WorkContinuation.forException(task.getException()) : WorkContinuation.forResult(com.google.firebase.auth.internal.zzag.zza(((GetTokenResult) task.getResult()).getToken()));
        }
    }

    /* JADX WARN: Code duplicated, block: B:168:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:180:0x0328  */
    /* JADX WARN: Code duplicated, block: B:220:0x0423 A[LOOP:12: B:219:0x0421->B:220:0x0423, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:223:0x043f  */
    /* JADX WARN: Code duplicated, block: B:224:0x0449  */
    /* JADX WARN: Code duplicated, block: B:28:0x0077  */
    private final BitMatrix encode$com$google$zxing$pdf417$PDF417Writer(String str, int i, EnumMap enumMap) throws WriterException {
        int i2;
        CharacterSetECI characterSetECI;
        int i3;
        int i4;
        String str2;
        int i5;
        char c;
        boolean z;
        int i6;
        int i7;
        int i8;
        int i9;
        int[][] iArr;
        int i10;
        int i11;
        int[][] iArr2;
        int i12;
        int i13;
        int i14;
        String str3;
        int i15;
        int i16;
        int i17;
        int i18 = 1;
        if (i != 11) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf$1(i)));
        }
        EncodeHintType encodeHintType = EncodeHintType.PDF417_COMPACT;
        boolean zBooleanValue = enumMap.containsKey(encodeHintType) ? Boolean.valueOf(enumMap.get(encodeHintType).toString()).booleanValue() : false;
        EncodeHintType encodeHintType2 = EncodeHintType.PDF417_COMPACTION;
        if (enumMap.containsKey(encodeHintType2)) {
            String string = enumMap.get(encodeHintType2).toString();
            if (string == null) {
                throw new NullPointerException("Name is null");
            }
            if (string.equals("AUTO")) {
                i2 = 1;
            } else if (string.equals("TEXT")) {
                i2 = 2;
            } else if (string.equals("BYTE")) {
                i2 = 3;
            } else {
                if (!string.equals("NUMERIC")) {
                    throw new IllegalArgumentException("No enum constant com.google.zxing.pdf417.encoder.Compaction.".concat(string));
                }
                i2 = 4;
            }
        } else {
            i2 = 1;
        }
        EncodeHintType encodeHintType3 = EncodeHintType.PDF417_DIMENSIONS;
        if (enumMap.containsKey(encodeHintType3)) {
            enumMap.get(encodeHintType3).getClass();
            throw new ClassCastException();
        }
        EncodeHintType encodeHintType4 = EncodeHintType.MARGIN;
        int i19 = enumMap.containsKey(encodeHintType4) ? Integer.parseInt(enumMap.get(encodeHintType4).toString()) : 30;
        EncodeHintType encodeHintType5 = EncodeHintType.ERROR_CORRECTION;
        int i20 = enumMap.containsKey(encodeHintType5) ? Integer.parseInt(enumMap.get(encodeHintType5).toString()) : 2;
        EncodeHintType encodeHintType6 = EncodeHintType.CHARACTER_SET;
        int[] iArr3 = null;
        Charset charsetForName = enumMap.containsKey(encodeHintType6) ? Charset.forName(enumMap.get(encodeHintType6).toString()) : null;
        String str4 = "Error correction level must be between 0 and 8!";
        if (i20 < 0 || i20 > 8) {
            throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
        }
        int i21 = 1 << (i20 + 1);
        byte[] bArr = PDF417HighLevelEncoder.TEXT_MIXED_RAW;
        StringBuilder sb = new StringBuilder(str.length());
        Charset charset = PDF417HighLevelEncoder.DEFAULT_ENCODING;
        if (charsetForName == null) {
            charsetForName = charset;
        } else if (!charset.equals(charsetForName) && (characterSetECI = (CharacterSetECI) CharacterSetECI.NAME_TO_ECI.get(charsetForName.name())) != null) {
            int i22 = characterSetECI.values[0];
            if (i22 >= 0 && i22 < 900) {
                sb.append((char) 927);
                sb.append((char) i22);
            } else if (i22 < 810900) {
                sb.append((char) 926);
                sb.append((char) ((i22 / DescriptorProtos.Edition.EDITION_LEGACY_VALUE) - 1));
                sb.append((char) (i22 % DescriptorProtos.Edition.EDITION_LEGACY_VALUE));
            } else {
                if (i22 >= 811800) {
                    throw new WriterException("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i22)));
                }
                sb.append((char) 925);
                sb.append((char) (810900 - i22));
            }
        }
        int length = str.length();
        int iOrdinal = Fragment$$ExternalSyntheticOutline0.ordinal(i2);
        if (iOrdinal == 1) {
            i3 = 1;
            i4 = i19;
            str2 = "Error correction level must be between 0 and 8!";
            PDF417HighLevelEncoder.encodeText(str, 0, length, sb, 0);
        } else if (iOrdinal == 2) {
            i4 = i19;
            str2 = "Error correction level must be between 0 and 8!";
            byte[] bytes = str.getBytes(charsetForName);
            i3 = 1;
            PDF417HighLevelEncoder.encodeBinary(bytes, bytes.length, 1, sb);
        } else if (iOrdinal != 3) {
            int i23 = 0;
            int i24 = 0;
            int iEncodeText = 0;
            while (i23 < length) {
                int length2 = str.length();
                char c2 = '0';
                if (i23 < length2) {
                    char cCharAt = str.charAt(i23);
                    int i25 = 0;
                    int i26 = i23;
                    while (cCharAt >= '0' && cCharAt <= '9' && i26 < length2) {
                        i25++;
                        i26++;
                        if (i26 < length2) {
                            cCharAt = str.charAt(i26);
                        }
                    }
                    i13 = i25;
                } else {
                    i13 = 0;
                }
                if (i13 >= 13) {
                    sb.append((char) 902);
                    PDF417HighLevelEncoder.encodeNumeric(i23, i13, str, sb);
                    i23 += i13;
                    i24 = 2;
                    i18 = 1;
                    iEncodeText = 0;
                } else {
                    int length3 = str.length();
                    int i27 = i23;
                    while (true) {
                        if (i27 < length3) {
                            i14 = i19;
                            char cCharAt2 = str.charAt(i27);
                            str3 = str4;
                            int i28 = 0;
                            while (i28 < 13 && cCharAt2 >= c2 && cCharAt2 <= '9' && i27 < length3) {
                                i28++;
                                i27++;
                                if (i27 < length3) {
                                    cCharAt2 = str.charAt(i27);
                                }
                                c2 = '0';
                            }
                            if (i28 >= 13) {
                                i15 = (i27 - i23) - i28;
                                break;
                            }
                            if (i28 <= 0) {
                                char cCharAt3 = str.charAt(i27);
                                if (cCharAt3 == '\t' || cCharAt3 == '\n' || cCharAt3 == '\r' || (cCharAt3 >= ' ' && cCharAt3 <= '~')) {
                                    i27++;
                                }
                            }
                            str4 = str3;
                            i19 = i14;
                            c2 = '0';
                        } else {
                            i14 = i19;
                            str3 = str4;
                        }
                        i15 = i27 - i23;
                        break;
                    }
                    if (i15 >= 5 || i13 == length) {
                        if (i24 != 0) {
                            sb.append((char) 900);
                            i24 = 0;
                            i16 = 0;
                        } else {
                            i16 = iEncodeText;
                        }
                        iEncodeText = PDF417HighLevelEncoder.encodeText(str, i23, i15, sb, i16);
                        i23 += i15;
                    } else {
                        CharsetEncoder charsetEncoderNewEncoder = charsetForName.newEncoder();
                        int length4 = str.length();
                        int i29 = i23;
                        while (i29 < length4) {
                            char cCharAt4 = str.charAt(i29);
                            int i30 = 0;
                            while (true) {
                                if (i30 >= 13 || cCharAt4 < '0') {
                                    break;
                                }
                                if (cCharAt4 > '9' || (i17 = i29 + (i30 = i30 + 1)) >= length4) {
                                    break;
                                }
                                cCharAt4 = str.charAt(i17);
                            }
                            if (i30 >= 13) {
                                break;
                            }
                            char cCharAt5 = str.charAt(i29);
                            if (!charsetEncoderNewEncoder.canEncode(cCharAt5)) {
                                throw new WriterException("Non-encodable character detected: " + cCharAt5 + " (Unicode: " + ((int) cCharAt5) + ')');
                            }
                            i29++;
                        }
                        int i31 = i29 - i23;
                        if (i31 == 0) {
                            i31 = 1;
                        }
                        int i32 = i23 + i31;
                        byte[] bytes2 = str.substring(i23, i32).getBytes(charsetForName);
                        if (bytes2.length == 1 && i24 == 0) {
                            PDF417HighLevelEncoder.encodeBinary(bytes2, 1, 0, sb);
                            iEncodeText = iEncodeText;
                        } else {
                            PDF417HighLevelEncoder.encodeBinary(bytes2, bytes2.length, i24, sb);
                            i24 = 1;
                            iEncodeText = 0;
                        }
                        i23 = i32;
                    }
                    str4 = str3;
                    i19 = i14;
                    i18 = 1;
                }
            }
            i4 = i19;
            str2 = str4;
            i3 = i18;
        } else {
            i4 = i19;
            str2 = "Error correction level must be between 0 and 8!";
            sb.append((char) 902);
            PDF417HighLevelEncoder.encodeNumeric(0, length, str, sb);
            i3 = 1;
        }
        String string2 = sb.toString();
        int length5 = string2.length();
        float f = 0.0f;
        int i33 = 2;
        while (true) {
            if (i33 > 30) {
                i5 = i3;
                break;
            }
            int i34 = length5 + 1 + i21;
            int i35 = i34 / i33;
            int i36 = i35 + 1;
            if (i33 * i36 < i34 + i33) {
                i35 = i36;
            }
            if (i35 < 2) {
                i5 = 1;
                break;
            }
            if (i35 <= 30) {
                float f2 = (((i33 * 17) + 69) * 0.357f) / (i35 * 2.0f);
                if (iArr3 == null || Math.abs(f2 - 3.0f) <= Math.abs(f - 3.0f)) {
                    i12 = 1;
                    f = f2;
                    iArr3 = new int[]{i33, i35};
                } else {
                    i12 = 1;
                }
            } else {
                i12 = 1;
            }
            i33 += i12;
            i3 = i12;
        }
        if (iArr3 == null) {
            int i37 = length5 + 1 + i21;
            int i38 = i37 / 2;
            int i39 = i38 + 1;
            if (2 * i39 < i37 + 2) {
                i38 = i39;
            }
            if (i38 < 2) {
                int[] iArr4 = new int[2];
                c = 0;
                iArr4[0] = 2;
                iArr4[i5] = 2;
                iArr3 = iArr4;
            } else {
                c = 0;
            }
        } else {
            c = 0;
        }
        if (iArr3 == null) {
            throw new WriterException("Unable to fit message in columns");
        }
        int i40 = iArr3[c];
        int i41 = iArr3[i5];
        int i42 = (i40 * i41) - i21;
        int i43 = i42 > length5 + 1 ? (i42 - length5) - i5 : 0;
        if (length5 + i21 + i5 > 929) {
            throw new WriterException(iafHZUfOuHNwvy.nSpCxtSZIuRjN + str.length() + " bytes)");
        }
        int i44 = length5 + i43 + i5;
        StringBuilder sb2 = new StringBuilder(i44);
        sb2.append((char) i44);
        sb2.append(string2);
        for (int i45 = 0; i45 < i43; i45 += i5) {
            sb2.append((char) 900);
        }
        String string3 = sb2.toString();
        if (i20 < 0 || i20 > 8) {
            throw new IllegalArgumentException(str2);
        }
        char[] cArr = new char[i21];
        int length6 = string3.length();
        int i46 = 0;
        while (i46 < length6) {
            int i47 = i21 - 1;
            int iCharAt = (string3.charAt(i46) + cArr[i47]) % 929;
            while (true) {
                iArr2 = PDF417.EC_COEFFICIENTS;
                if (i47 > 0) {
                    cArr[i47] = (char) ((cArr[i47 - 1] + (929 - ((iArr2[i20][i47] * iCharAt) % 929))) % 929);
                    i47--;
                }
            }
            cArr[0] = (char) ((929 - ((iCharAt * iArr2[i20][0]) % 929)) % 929);
            i46++;
            i5 = 1;
        }
        StringBuilder sb3 = new StringBuilder(i21);
        for (int i48 = i21 - i5; i48 >= 0; i48--) {
            char c3 = cArr[i48];
            if (c3 != 0) {
                cArr[i48] = (char) (929 - c3);
            }
            sb3.append(cArr[i48]);
        }
        String string4 = sb3.toString();
        BarcodeMatrix barcodeMatrix = new BarcodeMatrix(i41, i40);
        String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(string3, string4);
        int i49 = 0;
        for (int i50 = 0; i50 < i41; i50++) {
            int i51 = i50 % 3;
            barcodeMatrix.currentRow++;
            PDF417.encodeChar(130728, 17, barcodeMatrix.getCurrentRow());
            if (i51 == 0) {
                i8 = (i50 / 3) * 30;
                i6 = ((i41 - 1) / 3) + i8;
                i9 = i40 - 1;
            } else {
                if (i51 == 1) {
                    i8 = (i50 / 3) * 30;
                    int i52 = i41 - 1;
                    i6 = (i20 * 3) + i8 + (i52 % 3);
                    i9 = i52 / 3;
                } else {
                    int i53 = (i50 / 3) * 30;
                    i6 = (i40 - 1) + i53;
                    i7 = (i20 * 3) + i53 + ((i41 - 1) % 3);
                }
                iArr = PDF417.CODEWORD_TABLE;
                i10 = 17;
                PDF417.encodeChar(iArr[i51][i6], 17, barcodeMatrix.getCurrentRow());
                i11 = 0;
                while (i11 < i40) {
                    PDF417.encodeChar(iArr[i51][strM.charAt(i49)], i10, barcodeMatrix.getCurrentRow());
                    i49++;
                    i11++;
                    i10 = 17;
                }
                if (zBooleanValue) {
                    PDF417.encodeChar(260649, 1, barcodeMatrix.getCurrentRow());
                } else {
                    PDF417.encodeChar(iArr[i51][i7], 17, barcodeMatrix.getCurrentRow());
                    PDF417.encodeChar(260649, 18, barcodeMatrix.getCurrentRow());
                }
            }
            i7 = i9 + i8;
            iArr = PDF417.CODEWORD_TABLE;
            i10 = 17;
            PDF417.encodeChar(iArr[i51][i6], 17, barcodeMatrix.getCurrentRow());
            i11 = 0;
            while (i11 < i40) {
                PDF417.encodeChar(iArr[i51][strM.charAt(i49)], i10, barcodeMatrix.getCurrentRow());
                i49++;
                i11++;
                i10 = 17;
            }
            if (zBooleanValue) {
                PDF417.encodeChar(260649, 1, barcodeMatrix.getCurrentRow());
            } else {
                PDF417.encodeChar(iArr[i51][i7], 17, barcodeMatrix.getCurrentRow());
                PDF417.encodeChar(260649, 18, barcodeMatrix.getCurrentRow());
            }
        }
        byte[][] scaledMatrix = barcodeMatrix.getScaledMatrix(1, 4);
        if (scaledMatrix[0].length < scaledMatrix.length) {
            scaledMatrix = rotateArray(scaledMatrix);
            z = true;
        } else {
            z = false;
        }
        int length7 = 200 / scaledMatrix[0].length;
        int length8 = 200 / scaledMatrix.length;
        if (length7 >= length8) {
            length7 = length8;
        }
        if (length7 <= 1) {
            return bitMatrixFromBitArray(scaledMatrix, i4);
        }
        byte[][] scaledMatrix2 = barcodeMatrix.getScaledMatrix(length7, length7 << 2);
        if (z) {
            scaledMatrix2 = rotateArray(scaledMatrix2);
        }
        return bitMatrixFromBitArray(scaledMatrix2, i4);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0064  */
    /* JADX WARN: Code duplicated, block: B:368:0x0670  */
    /* JADX WARN: Code duplicated, block: B:402:0x06eb  */
    /* JADX WARN: Code duplicated, block: B:483:0x00ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:484:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00da  */
    /* JADX WARN: Code duplicated, block: B:66:0x00de  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x00f3  */
    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, int i, EnumMap enumMap) throws WriterException {
        Writer zzrVar;
        int i2;
        String string;
        Mode mode;
        int i3;
        Version versionForNumber;
        Huffman.Node node;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        char c;
        int i4;
        int i5;
        CharacterSetECI characterSetECI;
        boolean z5;
        boolean z6;
        int i6;
        char cCharAt;
        int i7;
        switch (this.$r8$classId) {
            case 18:
                switch (Fragment$$ExternalSyntheticOutline0.ordinal(i)) {
                    case 0:
                        zzrVar = new zzr(19);
                        break;
                    case 1:
                        zzrVar = new CodaBarWriter();
                        break;
                    case 2:
                        zzrVar = new ITFWriter(2);
                        break;
                    case 3:
                        zzrVar = new ITFWriter(3);
                        break;
                    case 4:
                        zzrVar = new ITFWriter(1);
                        break;
                    case 5:
                        zzrVar = new zzr(20);
                        break;
                    case 6:
                        zzrVar = new EAN8Writer(0);
                        break;
                    case 7:
                        zzrVar = new EAN8Writer(1);
                        break;
                    case 8:
                        zzrVar = new ITFWriter(0);
                        break;
                    case 9:
                    case 12:
                    case 13:
                    default:
                        throw new IllegalArgumentException("No encoder available for format ".concat(BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf$1(i)));
                    case 10:
                        zzrVar = new zzr(25);
                        break;
                    case 11:
                        zzrVar = new zzr(26);
                        break;
                    case 14:
                        zzrVar = new UPCAWriter();
                        break;
                    case 15:
                        zzrVar = new EAN8Writer(2);
                        break;
                }
                return zzrVar.encode(str, i, enumMap);
            case 19:
                return encode$com$google$zxing$aztec$AztecWriter(str, i, enumMap);
            case 20:
                return encode$com$google$zxing$datamatrix$DataMatrixWriter(str, i, enumMap);
            case 25:
                return encode$com$google$zxing$pdf417$PDF417Writer(str, i, enumMap);
            default:
                if (str.isEmpty()) {
                    throw new IllegalArgumentException("Found empty contents");
                }
                if (i == 12) {
                    EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
                    if (enumMap.containsKey(encodeHintType)) {
                        String string2 = enumMap.get(encodeHintType).toString();
                        if (string2 == null) {
                            throw new NullPointerException("Name is null");
                        }
                        if (string2.equals("L")) {
                            i2 = 1;
                        } else if (string2.equals("M")) {
                            i2 = 2;
                        } else if (string2.equals("Q")) {
                            i2 = 3;
                        } else {
                            if (!string2.equals("H")) {
                                throw new IllegalArgumentException("No enum constant com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.".concat(string2));
                            }
                            i2 = 4;
                        }
                    } else {
                        i2 = 1;
                    }
                    EncodeHintType encodeHintType2 = EncodeHintType.MARGIN;
                    int i8 = enumMap.containsKey(encodeHintType2) ? Integer.parseInt(enumMap.get(encodeHintType2).toString()) : 4;
                    EncodeHintType encodeHintType3 = EncodeHintType.CHARACTER_SET;
                    boolean zContainsKey = enumMap.containsKey(encodeHintType3);
                    if (zContainsKey) {
                        string = enumMap.get(encodeHintType3).toString();
                    } else {
                        string = "ISO-8859-1";
                    }
                    String str2 = TSDAbK.MYUWfwOvq;
                    boolean zEquals = str2.equals(string);
                    Mode mode2 = Mode.BYTE;
                    int[] iArr = com.google.zxing.qrcode.encoder.Encoder.ALPHANUMERIC_TABLE;
                    if (zEquals) {
                        try {
                            byte[] bytes = str.getBytes(str2);
                            int length = bytes.length;
                            if (length % 2 != 0) {
                                z5 = false;
                                z6 = false;
                                i6 = 0;
                                while (true) {
                                    if (i6 < str.length()) {
                                        cCharAt = str.charAt(i6);
                                        if (cCharAt >= '0' || cCharAt > '9') {
                                            if (cCharAt < '`') {
                                                i7 = iArr[cCharAt];
                                            } else {
                                                i7 = -1;
                                            }
                                            if (i7 != -1) {
                                                z5 = true;
                                            }
                                        } else {
                                            z6 = true;
                                        }
                                        i6++;
                                    } else if (z5) {
                                        mode = Mode.ALPHANUMERIC;
                                    } else if (z6) {
                                        mode = Mode.NUMERIC;
                                    }
                                    mode = mode2;
                                }
                            } else {
                                int i9 = 0;
                                while (true) {
                                    if (i9 < length) {
                                        int i10 = bytes[i9] & 255;
                                        if ((i10 < 129 || i10 > 159) && (i10 < 224 || i10 > 235)) {
                                            z5 = false;
                                            z6 = false;
                                            i6 = 0;
                                            while (true) {
                                                if (i6 < str.length()) {
                                                    cCharAt = str.charAt(i6);
                                                    if (cCharAt >= '0') {
                                                        if (cCharAt < '`') {
                                                            i7 = iArr[cCharAt];
                                                        } else {
                                                            i7 = -1;
                                                        }
                                                        if (i7 != -1) {
                                                            z5 = true;
                                                        }
                                                    } else {
                                                        if (cCharAt < '`') {
                                                            i7 = iArr[cCharAt];
                                                        } else {
                                                            i7 = -1;
                                                        }
                                                        if (i7 != -1) {
                                                            z5 = true;
                                                        }
                                                    }
                                                    i6++;
                                                } else if (z5) {
                                                    mode = Mode.ALPHANUMERIC;
                                                } else if (z6) {
                                                    mode = Mode.NUMERIC;
                                                }
                                                mode = mode2;
                                            }
                                        } else {
                                            i9 += 2;
                                        }
                                    } else {
                                        mode = Mode.KANJI;
                                    }
                                }
                            }
                        } catch (UnsupportedEncodingException unused) {
                        }
                    } else {
                        z5 = false;
                        z6 = false;
                        i6 = 0;
                        while (true) {
                            if (i6 < str.length()) {
                                cCharAt = str.charAt(i6);
                                if (cCharAt >= '0') {
                                    if (cCharAt < '`') {
                                        i7 = iArr[cCharAt];
                                    } else {
                                        i7 = -1;
                                    }
                                    if (i7 != -1) {
                                        z5 = true;
                                    }
                                } else {
                                    if (cCharAt < '`') {
                                        i7 = iArr[cCharAt];
                                    } else {
                                        i7 = -1;
                                    }
                                    if (i7 != -1) {
                                        z5 = true;
                                    }
                                }
                                i6++;
                            } else if (z5) {
                                mode = Mode.ALPHANUMERIC;
                            } else if (z6) {
                                mode = Mode.NUMERIC;
                            }
                            mode = mode2;
                        }
                    }
                    BitArray bitArray = new BitArray();
                    if (mode == mode2 && zContainsKey && (characterSetECI = (CharacterSetECI) CharacterSetECI.NAME_TO_ECI.get(string)) != null) {
                        bitArray.appendBits(7, 4);
                        bitArray.appendBits(characterSetECI.values[0], 8);
                    }
                    EncodeHintType encodeHintType4 = EncodeHintType.GS1_FORMAT;
                    if (enumMap.containsKey(encodeHintType4) && Boolean.valueOf(enumMap.get(encodeHintType4).toString()).booleanValue()) {
                        i3 = 4;
                        bitArray.appendBits(5, 4);
                    } else {
                        i3 = 4;
                    }
                    bitArray.appendBits(mode.bits, i3);
                    BitArray bitArray2 = new BitArray();
                    int iOrdinal = mode.ordinal();
                    if (iOrdinal == 1) {
                        int length2 = str.length();
                        int i11 = 0;
                        while (i11 < length2) {
                            int iCharAt = str.charAt(i11) - '0';
                            int i12 = i11 + 2;
                            if (i12 < length2) {
                                bitArray2.appendBits(((str.charAt(i11 + 1) - '0') * 10) + (iCharAt * 100) + (str.charAt(i12) - '0'), 10);
                                i11 += 3;
                            } else {
                                i11++;
                                if (i11 < length2) {
                                    bitArray2.appendBits((iCharAt * 10) + (str.charAt(i11) - '0'), 7);
                                    i11 = i12;
                                } else {
                                    bitArray2.appendBits(iCharAt, 4);
                                }
                            }
                        }
                    } else if (iOrdinal == 2) {
                        int length3 = str.length();
                        int i13 = 0;
                        while (i13 < length3) {
                            char cCharAt2 = str.charAt(i13);
                            int i14 = cCharAt2 < '`' ? iArr[cCharAt2] : -1;
                            if (i14 == -1) {
                                throw new WriterException();
                            }
                            int i15 = i13 + 1;
                            if (i15 < length3) {
                                char cCharAt3 = str.charAt(i15);
                                int i16 = cCharAt3 < '`' ? iArr[cCharAt3] : -1;
                                if (i16 != -1) {
                                    bitArray2.appendBits((i14 * 45) + i16, 11);
                                    i13 += 2;
                                } else {
                                    throw new WriterException();
                                }
                            } else {
                                bitArray2.appendBits(i14, 6);
                                i13 = i15;
                            }
                        }
                    } else if (iOrdinal == 4) {
                        try {
                            for (byte b : str.getBytes(string)) {
                                bitArray2.appendBits(b, 8);
                            }
                        } catch (UnsupportedEncodingException e) {
                            throw new WriterException(e);
                        }
                    } else if (iOrdinal == 6) {
                        try {
                            byte[] bytes2 = str.getBytes(str2);
                            int length4 = bytes2.length;
                            for (int i17 = 0; i17 < length4; i17 += 2) {
                                int i18 = ((bytes2[i17] & 255) << 8) | (bytes2[i17 + 1] & 255);
                                int i19 = 33088;
                                if (i18 >= 33088 && i18 <= 40956) {
                                    i5 = i18 - i19;
                                    i4 = -1;
                                } else if (i18 < 57408 || i18 > 60351) {
                                    i4 = -1;
                                    i5 = -1;
                                } else {
                                    i19 = 49472;
                                    i5 = i18 - i19;
                                    i4 = -1;
                                }
                                if (i5 != i4) {
                                    bitArray2.appendBits(((i5 >> 8) * 192) + (i5 & 255), 13);
                                } else {
                                    throw new WriterException("Invalid byte sequence");
                                }
                            }
                        } catch (UnsupportedEncodingException e2) {
                            throw new WriterException(e2);
                        }
                    } else {
                        throw new WriterException("Invalid mode: ".concat(String.valueOf(mode)));
                    }
                    EncodeHintType encodeHintType5 = EncodeHintType.QR_VERSION;
                    boolean zContainsKey2 = enumMap.containsKey(encodeHintType5);
                    int[] iArr2 = mode.characterCountBitsForVersions;
                    if (zContainsKey2) {
                        versionForNumber = Version.getVersionForNumber(Integer.parseInt(enumMap.get(encodeHintType5).toString()));
                        int i20 = bitArray.size;
                        int i21 = versionForNumber.versionNumber;
                        int i22 = iArr2[i21 <= 9 ? (char) 0 : i21 <= 26 ? (char) 1 : (char) 2] + i20 + bitArray2.size;
                        zzda zzdaVar = versionForNumber.ecBlocks[Fragment$$ExternalSyntheticOutline0.ordinal(i2)];
                        int i23 = 0;
                        for (Version.ECB ecb : (Version.ECB[]) zzdaVar.zza) {
                            i23 += ecb.count;
                        }
                        if (!(versionForNumber.totalCodewords - (i23 * zzdaVar.zzb) >= (i22 + 7) / 8)) {
                            throw new WriterException("Data too big for requested version");
                        }
                    } else {
                        Version versionForNumber2 = Version.getVersionForNumber(1);
                        int i24 = bitArray.size;
                        int i25 = versionForNumber2.versionNumber;
                        int i26 = iArr2[i25 <= 9 ? (char) 0 : i25 <= 26 ? (char) 1 : (char) 2] + i24 + bitArray2.size;
                        int i27 = 1;
                        while (true) {
                            if (i27 <= 40) {
                                Version versionForNumber3 = Version.getVersionForNumber(i27);
                                int i28 = versionForNumber3.totalCodewords;
                                zzda zzdaVar2 = versionForNumber3.ecBlocks[Fragment$$ExternalSyntheticOutline0.ordinal(i2)];
                                Version.ECB[] ecbArr = (Version.ECB[]) zzdaVar2.zza;
                                int i29 = 0;
                                int i30 = 0;
                                for (int length5 = ecbArr.length; i29 < length5; length5 = length5) {
                                    i30 += ecbArr[i29].count;
                                    i29++;
                                }
                                if (i28 - (i30 * zzdaVar2.zzb) >= (i26 + 7) / 8) {
                                    int i31 = bitArray.size;
                                    int i32 = versionForNumber3.versionNumber;
                                    int i33 = iArr2[i32 <= 9 ? (char) 0 : i32 <= 26 ? (char) 1 : (char) 2] + i31 + bitArray2.size;
                                    int i34 = 40;
                                    int i35 = 1;
                                    while (true) {
                                        if (i35 <= i34) {
                                            Version versionForNumber4 = Version.getVersionForNumber(i35);
                                            int i36 = versionForNumber4.totalCodewords;
                                            zzda zzdaVar3 = versionForNumber4.ecBlocks[Fragment$$ExternalSyntheticOutline0.ordinal(i2)];
                                            Version.ECB[] ecbArr2 = (Version.ECB[]) zzdaVar3.zza;
                                            int length6 = ecbArr2.length;
                                            int i37 = 0;
                                            int i38 = 0;
                                            while (i37 < length6) {
                                                i38 += ecbArr2[i37].count;
                                                i37++;
                                                versionForNumber4 = versionForNumber4;
                                            }
                                            Version version = versionForNumber4;
                                            if (i36 - (i38 * zzdaVar3.zzb) >= (i33 + 7) / 8) {
                                                versionForNumber = version;
                                            } else {
                                                i35++;
                                                i2 = i2;
                                                i8 = i8;
                                                i34 = 40;
                                            }
                                        } else {
                                            throw new WriterException("Data too big");
                                        }
                                    }
                                } else {
                                    i27++;
                                    i2 = i2;
                                    i8 = i8;
                                }
                            } else {
                                throw new WriterException("Data too big");
                            }
                        }
                    }
                    BitArray bitArray3 = new BitArray();
                    int i39 = bitArray.size;
                    bitArray3.ensureCapacity(i39);
                    for (int i40 = 0; i40 < i39; i40++) {
                        bitArray3.appendBit(bitArray.get(i40));
                    }
                    int sizeInBytes = mode == mode2 ? bitArray2.getSizeInBytes() : str.length();
                    int i41 = versionForNumber.versionNumber;
                    int i42 = iArr2[i41 <= 9 ? (char) 0 : i41 <= 26 ? (char) 1 : (char) 2];
                    int i43 = 1 << i42;
                    if (sizeInBytes < i43) {
                        bitArray3.appendBits(sizeInBytes, i42);
                        int i44 = bitArray2.size;
                        bitArray3.ensureCapacity(bitArray3.size + i44);
                        for (int i45 = 0; i45 < i44; i45++) {
                            bitArray3.appendBit(bitArray2.get(i45));
                        }
                        zzda zzdaVar4 = versionForNumber.ecBlocks[Fragment$$ExternalSyntheticOutline0.ordinal(i2)];
                        int i46 = 0;
                        for (Version.ECB ecb2 : (Version.ECB[]) zzdaVar4.zza) {
                            i46 += ecb2.count;
                        }
                        int i47 = i46 * zzdaVar4.zzb;
                        int i48 = versionForNumber.totalCodewords;
                        int i49 = i48 - i47;
                        int i50 = i49 << 3;
                        if (bitArray3.size <= i50) {
                            for (int i51 = 0; i51 < 4 && bitArray3.size < i50; i51++) {
                                bitArray3.appendBit(false);
                            }
                            int i52 = bitArray3.size & 7;
                            if (i52 > 0) {
                                while (i52 < 8) {
                                    bitArray3.appendBit(false);
                                    i52++;
                                }
                            }
                            int sizeInBytes2 = i49 - bitArray3.getSizeInBytes();
                            for (int i53 = 0; i53 < sizeInBytes2; i53++) {
                                bitArray3.appendBits((i53 & 1) == 0 ? 236 : 17, 8);
                            }
                            if (bitArray3.size == i50) {
                                int i54 = 0;
                                for (Version.ECB ecb3 : (Version.ECB[]) zzdaVar4.zza) {
                                    i54 += ecb3.count;
                                }
                                if (bitArray3.getSizeInBytes() == i49) {
                                    ArrayList arrayList = new ArrayList(i54);
                                    int i55 = 0;
                                    int i56 = 0;
                                    int iMax = 0;
                                    int iMax2 = 0;
                                    while (i55 < i54) {
                                        int[] iArr3 = new int[1];
                                        int[] iArr4 = new int[1];
                                        if (i55 < i54) {
                                            int i57 = i48 % i54;
                                            int i58 = i8;
                                            int i59 = i54 - i57;
                                            int i60 = i48 / i54;
                                            int i61 = i60 + 1;
                                            int i62 = i49 / i54;
                                            int i63 = i62 + 1;
                                            int i64 = i2;
                                            int i65 = i60 - i62;
                                            Version version2 = versionForNumber;
                                            int i66 = i61 - i63;
                                            if (i65 != i66) {
                                                throw new WriterException("EC bytes mismatch");
                                            }
                                            int i67 = i41;
                                            if (i54 != i59 + i57) {
                                                throw new WriterException("RS blocks mismatch");
                                            }
                                            if (i48 == ((i63 + i66) * i57) + ((i62 + i65) * i59)) {
                                                if (i55 < i59) {
                                                    c = 0;
                                                    iArr3[0] = i62;
                                                    iArr4[0] = i65;
                                                } else {
                                                    c = 0;
                                                    iArr3[0] = i63;
                                                    iArr4[0] = i66;
                                                }
                                                int i68 = iArr3[c];
                                                byte[] bArr = new byte[i68];
                                                int i69 = i56 << 3;
                                                int i70 = 0;
                                                while (i70 < i68) {
                                                    int i71 = i48;
                                                    int i72 = i54;
                                                    int i73 = 0;
                                                    int i74 = 0;
                                                    for (int i75 = 8; i74 < i75; i75 = 8) {
                                                        if (bitArray3.get(i69)) {
                                                            i73 = (1 << (7 - i74)) | i73;
                                                        }
                                                        i69++;
                                                        i74++;
                                                    }
                                                    bArr[i70] = (byte) i73;
                                                    i70++;
                                                    i54 = i72;
                                                    i48 = i71;
                                                }
                                                int i76 = i48;
                                                int i77 = i54;
                                                int i78 = iArr4[0];
                                                int[] iArr5 = new int[i68 + i78];
                                                for (int i79 = 0; i79 < i68; i79++) {
                                                    iArr5[i79] = bArr[i79] & 255;
                                                }
                                                new zzz(GenericGF.QR_CODE_FIELD_256).encode(i78, iArr5);
                                                byte[] bArr2 = new byte[i78];
                                                for (int i80 = 0; i80 < i78; i80++) {
                                                    bArr2[i80] = (byte) iArr5[i68 + i80];
                                                }
                                                arrayList.add(new BlockPair(bArr, bArr2));
                                                iMax = Math.max(iMax, i68);
                                                iMax2 = Math.max(iMax2, i78);
                                                i56 += iArr3[0];
                                                i55++;
                                                i54 = i77;
                                                i8 = i58;
                                                versionForNumber = version2;
                                                i41 = i67;
                                                i48 = i76;
                                                i2 = i64;
                                            } else {
                                                throw new WriterException("Total bytes mismatch");
                                            }
                                        } else {
                                            throw new WriterException("Block ID too large");
                                        }
                                    }
                                    int i81 = i2;
                                    Version version3 = versionForNumber;
                                    int i82 = i8;
                                    int i83 = i41;
                                    int i84 = i48;
                                    if (i49 == i56) {
                                        BitArray bitArray4 = new BitArray();
                                        for (int i85 = 0; i85 < iMax; i85++) {
                                            Iterator it = arrayList.iterator();
                                            while (it.hasNext()) {
                                                byte[] bArr3 = ((BlockPair) it.next()).dataBytes;
                                                if (i85 < bArr3.length) {
                                                    bitArray4.appendBits(bArr3[i85], 8);
                                                }
                                            }
                                        }
                                        for (int i86 = 0; i86 < iMax2; i86++) {
                                            Iterator it2 = arrayList.iterator();
                                            while (it2.hasNext()) {
                                                byte[] bArr4 = ((BlockPair) it2.next()).errorCorrectionBytes;
                                                if (i86 < bArr4.length) {
                                                    bitArray4.appendBits(bArr4[i86], 8);
                                                }
                                            }
                                        }
                                        if (i84 == bitArray4.getSizeInBytes()) {
                                            int i87 = (i83 * 4) + 17;
                                            Huffman.Node node2 = new Huffman.Node(i87, i87, 1);
                                            int i88 = Integer.MAX_VALUE;
                                            int i89 = -1;
                                            int i90 = 0;
                                            while (true) {
                                                int i91 = node2.symbol;
                                                int i92 = node2.terminalBitCount;
                                                if (i90 < 8) {
                                                    Version version4 = version3;
                                                    int i93 = i81;
                                                    com.google.zxing.qrcode.encoder.Encoder.buildMatrix(bitArray4, i93, version4, i90, node2);
                                                    int iApplyMaskPenaltyRule1Internal = com.google.zxing.qrcode.encoder.Encoder.applyMaskPenaltyRule1Internal(node2, false) + com.google.zxing.qrcode.encoder.Encoder.applyMaskPenaltyRule1Internal(node2, true);
                                                    int i94 = 0;
                                                    int i95 = 0;
                                                    while (true) {
                                                        int i96 = i92 - 1;
                                                        byte[][] bArr5 = (byte[][]) node2.children;
                                                        if (i94 < i96) {
                                                            byte[] bArr6 = bArr5[i94];
                                                            int i97 = 0;
                                                            while (i97 < i91 - 1) {
                                                                byte b2 = bArr6[i97];
                                                                int i98 = i97 + 1;
                                                                BitArray bitArray5 = bitArray4;
                                                                if (b2 == bArr6[i98]) {
                                                                    byte[] bArr7 = bArr5[i94 + 1];
                                                                    if (b2 == bArr7[i97] && b2 == bArr7[i98]) {
                                                                        i95++;
                                                                    }
                                                                }
                                                                bitArray4 = bitArray5;
                                                                i97 = i98;
                                                            }
                                                            i94++;
                                                        } else {
                                                            BitArray bitArray6 = bitArray4;
                                                            int i99 = (i95 * 3) + iApplyMaskPenaltyRule1Internal;
                                                            int i100 = 0;
                                                            for (int i101 = 0; i101 < i92; i101++) {
                                                                int i102 = 0;
                                                                while (i102 < i91) {
                                                                    byte[] bArr8 = bArr5[i101];
                                                                    int i103 = i102 + 6;
                                                                    if (i103 < i91) {
                                                                        node = node2;
                                                                        byte b3 = 1;
                                                                        if (bArr8[i102] == 1 && bArr8[i102 + 1] == 0 && bArr8[i102 + 2] == 1 && bArr8[i102 + 3] == 1 && bArr8[i102 + 4] == 1 && bArr8[i102 + 5] == 0 && bArr8[i103] == 1) {
                                                                            int iMax3 = Math.max(i102 - 4, 0);
                                                                            int iMin = Math.min(i102, bArr8.length);
                                                                            while (true) {
                                                                                if (iMax3 < iMin) {
                                                                                    int i104 = iMin;
                                                                                    if (bArr8[iMax3] == b3) {
                                                                                        z3 = false;
                                                                                    } else {
                                                                                        iMax3++;
                                                                                        iMin = i104;
                                                                                        b3 = 1;
                                                                                    }
                                                                                } else {
                                                                                    z3 = true;
                                                                                }
                                                                            }
                                                                            if (z3) {
                                                                                i100++;
                                                                            } else {
                                                                                int iMax4 = Math.max(i102 + 7, 0);
                                                                                int iMin2 = Math.min(i102 + 11, bArr8.length);
                                                                                while (true) {
                                                                                    if (iMax4 < iMin2) {
                                                                                        byte[] bArr9 = bArr8;
                                                                                        if (bArr8[iMax4] == 1) {
                                                                                            z4 = false;
                                                                                        } else {
                                                                                            iMax4++;
                                                                                            bArr8 = bArr9;
                                                                                        }
                                                                                    } else {
                                                                                        z4 = true;
                                                                                    }
                                                                                }
                                                                                if (z4) {
                                                                                    i100++;
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        node = node2;
                                                                    }
                                                                    int i105 = i101 + 6;
                                                                    if (i105 < i92) {
                                                                        byte b4 = 1;
                                                                        if (bArr5[i101][i102] == 1 && bArr5[i101 + 1][i102] == 0 && bArr5[i101 + 2][i102] == 1 && bArr5[i101 + 3][i102] == 1 && bArr5[i101 + 4][i102] == 1 && bArr5[i101 + 5][i102] == 0 && bArr5[i105][i102] == 1) {
                                                                            int iMax5 = Math.max(i101 - 4, 0);
                                                                            int iMin3 = Math.min(i101, bArr5.length);
                                                                            while (true) {
                                                                                if (iMax5 >= iMin3) {
                                                                                    z = true;
                                                                                } else if (bArr5[iMax5][i102] == b4) {
                                                                                    z = false;
                                                                                } else {
                                                                                    iMax5++;
                                                                                    b4 = 1;
                                                                                }
                                                                            }
                                                                            if (z) {
                                                                                i100++;
                                                                            } else {
                                                                                int iMax6 = Math.max(i101 + 7, 0);
                                                                                int iMin4 = Math.min(i101 + 11, bArr5.length);
                                                                                while (true) {
                                                                                    if (iMax6 >= iMin4) {
                                                                                        z2 = true;
                                                                                    } else if (bArr5[iMax6][i102] == 1) {
                                                                                        z2 = false;
                                                                                    } else {
                                                                                        iMax6++;
                                                                                    }
                                                                                }
                                                                                if (z2) {
                                                                                    i100++;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    i102++;
                                                                    node2 = node;
                                                                }
                                                            }
                                                            Huffman.Node node3 = node2;
                                                            int i106 = (i100 * 40) + i99;
                                                            int i107 = 0;
                                                            for (int i108 = 0; i108 < i92; i108++) {
                                                                byte[] bArr10 = bArr5[i108];
                                                                for (int i109 = 0; i109 < i91; i109++) {
                                                                    if (bArr10[i109] == 1) {
                                                                        i107++;
                                                                    }
                                                                }
                                                            }
                                                            int i110 = i92 * i91;
                                                            int iAbs = (((Math.abs((i107 << 1) - i110) * 10) / i110) * 10) + i106;
                                                            if (iAbs < i88) {
                                                                i88 = iAbs;
                                                                i89 = i90;
                                                            }
                                                            i90++;
                                                            bitArray4 = bitArray6;
                                                            node2 = node3;
                                                            i81 = i93;
                                                            version3 = version4;
                                                        }
                                                    }
                                                } else {
                                                    com.google.zxing.qrcode.encoder.Encoder.buildMatrix(bitArray4, i81, version3, i89, node2);
                                                    int i111 = i82 << 1;
                                                    int i112 = i91 + i111;
                                                    int i113 = i111 + i92;
                                                    int iMax7 = Math.max(200, i112);
                                                    int iMax8 = Math.max(200, i113);
                                                    int iMin5 = Math.min(iMax7 / i112, iMax8 / i113);
                                                    int i114 = (iMax7 - (i91 * iMin5)) / 2;
                                                    int i115 = (iMax8 - (i92 * iMin5)) / 2;
                                                    BitMatrix bitMatrix = new BitMatrix(iMax7, iMax8);
                                                    int i116 = 0;
                                                    while (i116 < i92) {
                                                        int i117 = i114;
                                                        int i118 = 0;
                                                        while (i118 < i91) {
                                                            if (node2.get(i118, i116) == 1) {
                                                                bitMatrix.setRegion(i117, i115, iMin5, iMin5);
                                                            }
                                                            i118++;
                                                            i117 += iMin5;
                                                        }
                                                        i116++;
                                                        i115 += iMin5;
                                                    }
                                                    return bitMatrix;
                                                }
                                            }
                                        } else {
                                            StringBuilder sbM = Fragment$$ExternalSyntheticOutline0.m(i84, "Interleaving error: ", " and ");
                                            sbM.append(bitArray4.getSizeInBytes());
                                            sbM.append(" differ.");
                                            throw new WriterException(sbM.toString());
                                        }
                                    } else {
                                        throw new WriterException("Data bytes does not match offset");
                                    }
                                } else {
                                    throw new WriterException("Number of bits and data bytes does not match");
                                }
                            } else {
                                throw new WriterException("Bits size does not equal capacity");
                            }
                        } else {
                            throw new WriterException("data bits cannot fit in the QR Code" + bitArray3.size + " > " + i50);
                        }
                    } else {
                        throw new WriterException(sizeInBytes + " is bigger than " + (i43 - 1));
                    }
                } else {
                    throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf$1(i)));
                }
                break;
        }
    }
}
