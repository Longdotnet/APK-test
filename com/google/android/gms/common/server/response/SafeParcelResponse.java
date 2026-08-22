package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.SparseArray;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.drive.zza;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.io.CloseableKt;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zza(18);
    public final int zaa;
    public final Parcel zab;
    public final int zac;
    public final zan zad;
    public final String zae;
    public int zaf;
    public int zag;

    public SafeParcelResponse(int i, Parcel parcel, zan zanVar) {
        this.zaa = i;
        zzah.checkNotNull(parcel);
        this.zab = parcel;
        this.zac = 2;
        this.zad = zanVar;
        this.zae = zanVar == null ? null : zanVar.zac;
        this.zaf = 2;
    }

    public static void zaH(StringBuilder sb, Map map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) entry.getValue()).zaf, entry);
        }
        sb.append('{');
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        boolean z = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            Map.Entry entry2 = (Map.Entry) sparseArray.get((char) i);
            if (entry2 != null) {
                if (z) {
                    sb.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry2.getValue();
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                StringToIntConverter stringToIntConverter = field.zak;
                BigInteger bigInteger = null;
                BigInteger bigInteger2 = null;
                Parcel[] parcelArr = null;
                BigDecimal[] bigDecimalArr = null;
                double[] dArrCreateDoubleArray = null;
                float[] fArrCreateFloatArray = null;
                long[] jArrCreateLongArray = null;
                BigInteger[] bigIntegerArr = null;
                Parcel parcelObtain = null;
                int i2 = field.zac;
                if (stringToIntConverter != null) {
                    switch (i2) {
                        case 0:
                            zaJ(sb, field, FastJsonResponse.zaD(field, Integer.valueOf(Protocol.Companion.readInt(parcel, i))));
                            break;
                        case 1:
                            int size = Protocol.Companion.readSize(parcel, i);
                            int iDataPosition = parcel.dataPosition();
                            if (size != 0) {
                                byte[] bArrCreateByteArray = parcel.createByteArray();
                                parcel.setDataPosition(iDataPosition + size);
                                bigInteger2 = new BigInteger(bArrCreateByteArray);
                            }
                            zaJ(sb, field, FastJsonResponse.zaD(field, bigInteger2));
                            break;
                        case 2:
                            zaJ(sb, field, FastJsonResponse.zaD(field, Long.valueOf(Protocol.Companion.readLong(parcel, i))));
                            break;
                        case 3:
                            zaJ(sb, field, FastJsonResponse.zaD(field, Float.valueOf(Protocol.Companion.readFloat(parcel, i))));
                            break;
                        case 4:
                            Protocol.Companion.zzb(parcel, i, 8);
                            zaJ(sb, field, FastJsonResponse.zaD(field, Double.valueOf(parcel.readDouble())));
                            break;
                        case 5:
                            zaJ(sb, field, FastJsonResponse.zaD(field, Protocol.Companion.createBigDecimal(parcel, i)));
                            break;
                        case 6:
                            zaJ(sb, field, FastJsonResponse.zaD(field, Boolean.valueOf(Protocol.Companion.readBoolean(parcel, i))));
                            break;
                        case 7:
                            zaJ(sb, field, FastJsonResponse.zaD(field, Protocol.Companion.createString(parcel, i)));
                            break;
                        case 8:
                        case 9:
                            zaJ(sb, field, FastJsonResponse.zaD(field, Protocol.Companion.createByteArray(parcel, i)));
                            break;
                        case 10:
                            Bundle bundleCreateBundle = Protocol.Companion.createBundle(parcel, i);
                            HashMap map2 = new HashMap();
                            for (String str2 : bundleCreateBundle.keySet()) {
                                String string = bundleCreateBundle.getString(str2);
                                zzah.checkNotNull(string);
                                map2.put(str2, string);
                            }
                            zaJ(sb, field, FastJsonResponse.zaD(field, map2));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, "Unknown field out type = "));
                    }
                } else {
                    boolean z2 = field.zad;
                    String str3 = field.zah;
                    if (z2) {
                        sb.append("[");
                        switch (i2) {
                            case 0:
                                int[] iArrCreateIntArray = Protocol.Companion.createIntArray(parcel, i);
                                int length = iArrCreateIntArray.length;
                                for (int i3 = 0; i3 < length; i3++) {
                                    if (i3 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(iArrCreateIntArray[i3]);
                                }
                                break;
                            case 1:
                                int size2 = Protocol.Companion.readSize(parcel, i);
                                int iDataPosition2 = parcel.dataPosition();
                                if (size2 != 0) {
                                    int i4 = parcel.readInt();
                                    bigIntegerArr = new BigInteger[i4];
                                    for (int i5 = 0; i5 < i4; i5++) {
                                        bigIntegerArr[i5] = new BigInteger(parcel.createByteArray());
                                    }
                                    parcel.setDataPosition(iDataPosition2 + size2);
                                }
                                int length2 = bigIntegerArr.length;
                                for (int i6 = 0; i6 < length2; i6++) {
                                    if (i6 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(bigIntegerArr[i6]);
                                }
                                break;
                            case 2:
                                int size3 = Protocol.Companion.readSize(parcel, i);
                                int iDataPosition3 = parcel.dataPosition();
                                if (size3 != 0) {
                                    jArrCreateLongArray = parcel.createLongArray();
                                    parcel.setDataPosition(iDataPosition3 + size3);
                                }
                                int length3 = jArrCreateLongArray.length;
                                for (int i7 = 0; i7 < length3; i7++) {
                                    if (i7 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(jArrCreateLongArray[i7]);
                                }
                                break;
                            case 3:
                                int size4 = Protocol.Companion.readSize(parcel, i);
                                int iDataPosition4 = parcel.dataPosition();
                                if (size4 != 0) {
                                    fArrCreateFloatArray = parcel.createFloatArray();
                                    parcel.setDataPosition(iDataPosition4 + size4);
                                }
                                int length4 = fArrCreateFloatArray.length;
                                for (int i8 = 0; i8 < length4; i8++) {
                                    if (i8 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(fArrCreateFloatArray[i8]);
                                }
                                break;
                            case 4:
                                int size5 = Protocol.Companion.readSize(parcel, i);
                                int iDataPosition5 = parcel.dataPosition();
                                if (size5 != 0) {
                                    dArrCreateDoubleArray = parcel.createDoubleArray();
                                    parcel.setDataPosition(iDataPosition5 + size5);
                                }
                                int length5 = dArrCreateDoubleArray.length;
                                for (int i9 = 0; i9 < length5; i9++) {
                                    if (i9 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(dArrCreateDoubleArray[i9]);
                                }
                                break;
                            case 5:
                                int size6 = Protocol.Companion.readSize(parcel, i);
                                int iDataPosition6 = parcel.dataPosition();
                                if (size6 != 0) {
                                    int i10 = parcel.readInt();
                                    bigDecimalArr = new BigDecimal[i10];
                                    for (int i11 = 0; i11 < i10; i11++) {
                                        bigDecimalArr[i11] = new BigDecimal(new BigInteger(parcel.createByteArray()), parcel.readInt());
                                    }
                                    parcel.setDataPosition(iDataPosition6 + size6);
                                }
                                int length6 = bigDecimalArr.length;
                                for (int i12 = 0; i12 < length6; i12++) {
                                    if (i12 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(bigDecimalArr[i12]);
                                }
                                break;
                            case 6:
                                boolean[] zArrCreateBooleanArray = Protocol.Companion.createBooleanArray(parcel, i);
                                int length7 = zArrCreateBooleanArray.length;
                                for (int i13 = 0; i13 < length7; i13++) {
                                    if (i13 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(zArrCreateBooleanArray[i13]);
                                }
                                break;
                            case 7:
                                String[] strArrCreateStringArray = Protocol.Companion.createStringArray(parcel, i);
                                int length8 = strArrCreateStringArray.length;
                                for (int i14 = 0; i14 < length8; i14++) {
                                    if (i14 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append("\"");
                                    sb.append(strArrCreateStringArray[i14]);
                                    sb.append("\"");
                                }
                                break;
                            case 8:
                            case 9:
                            case 10:
                                throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                            case 11:
                                int size7 = Protocol.Companion.readSize(parcel, i);
                                int iDataPosition7 = parcel.dataPosition();
                                if (size7 != 0) {
                                    int i15 = parcel.readInt();
                                    Parcel[] parcelArr2 = new Parcel[i15];
                                    for (int i16 = 0; i16 < i15; i16++) {
                                        int i17 = parcel.readInt();
                                        if (i17 != 0) {
                                            int iDataPosition8 = parcel.dataPosition();
                                            Parcel parcelObtain2 = Parcel.obtain();
                                            parcelObtain2.appendFrom(parcel, iDataPosition8, i17);
                                            parcelArr2[i16] = parcelObtain2;
                                            parcel.setDataPosition(iDataPosition8 + i17);
                                        } else {
                                            parcelArr2[i16] = null;
                                        }
                                    }
                                    parcel.setDataPosition(iDataPosition7 + size7);
                                    parcelArr = parcelArr2;
                                }
                                int length9 = parcelArr.length;
                                for (int i18 = 0; i18 < length9; i18++) {
                                    if (i18 > 0) {
                                        sb.append(",");
                                    }
                                    parcelArr[i18].setDataPosition(0);
                                    zzah.checkNotNull(str3);
                                    zzah.checkNotNull(field.zaj);
                                    Map map3 = (Map) field.zaj.zab.get(str3);
                                    zzah.checkNotNull(map3);
                                    zaH(sb, map3, parcelArr[i18]);
                                }
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out.");
                        }
                        sb.append("]");
                    } else {
                        switch (i2) {
                            case 0:
                                sb.append(Protocol.Companion.readInt(parcel, i));
                                break;
                            case 1:
                                int size8 = Protocol.Companion.readSize(parcel, i);
                                int iDataPosition9 = parcel.dataPosition();
                                if (size8 != 0) {
                                    byte[] bArrCreateByteArray2 = parcel.createByteArray();
                                    parcel.setDataPosition(iDataPosition9 + size8);
                                    bigInteger = new BigInteger(bArrCreateByteArray2);
                                }
                                sb.append(bigInteger);
                                break;
                            case 2:
                                sb.append(Protocol.Companion.readLong(parcel, i));
                                break;
                            case 3:
                                sb.append(Protocol.Companion.readFloat(parcel, i));
                                break;
                            case 4:
                                Protocol.Companion.zzb(parcel, i, 8);
                                sb.append(parcel.readDouble());
                                break;
                            case 5:
                                sb.append(Protocol.Companion.createBigDecimal(parcel, i));
                                break;
                            case 6:
                                sb.append(Protocol.Companion.readBoolean(parcel, i));
                                break;
                            case 7:
                                String strCreateString = Protocol.Companion.createString(parcel, i);
                                sb.append("\"");
                                sb.append(JsonUtils.escapeString(strCreateString));
                                sb.append("\"");
                                break;
                            case 8:
                                byte[] bArrCreateByteArray3 = Protocol.Companion.createByteArray(parcel, i);
                                sb.append("\"");
                                sb.append(bArrCreateByteArray3 != null ? Base64.encodeToString(bArrCreateByteArray3, 0) : null);
                                sb.append("\"");
                                break;
                            case 9:
                                byte[] bArrCreateByteArray4 = Protocol.Companion.createByteArray(parcel, i);
                                sb.append("\"");
                                sb.append(bArrCreateByteArray4 != null ? Base64.encodeToString(bArrCreateByteArray4, 10) : null);
                                sb.append("\"");
                                break;
                            case 10:
                                Bundle bundleCreateBundle2 = Protocol.Companion.createBundle(parcel, i);
                                Set<String> setKeySet = bundleCreateBundle2.keySet();
                                sb.append("{");
                                boolean z3 = true;
                                for (String str4 : setKeySet) {
                                    if (!z3) {
                                        sb.append(",");
                                    }
                                    sb.append("\"");
                                    sb.append(str4);
                                    sb.append("\":\"");
                                    sb.append(JsonUtils.escapeString(bundleCreateBundle2.getString(str4)));
                                    sb.append("\"");
                                    z3 = false;
                                }
                                sb.append("}");
                                break;
                            case 11:
                                int size9 = Protocol.Companion.readSize(parcel, i);
                                int iDataPosition10 = parcel.dataPosition();
                                if (size9 != 0) {
                                    parcelObtain = Parcel.obtain();
                                    parcelObtain.appendFrom(parcel, iDataPosition10, size9);
                                    parcel.setDataPosition(iDataPosition10 + size9);
                                }
                                parcelObtain.setDataPosition(0);
                                zzah.checkNotNull(str3);
                                zzah.checkNotNull(field.zaj);
                                Map map4 = (Map) field.zaj.zab.get(str3);
                                zzah.checkNotNull(map4);
                                zaH(sb, map4, parcelObtain);
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out");
                        }
                    }
                }
                z = true;
            }
        }
        if (parcel.dataPosition() != iValidateObjectHeader) {
            throw new SafeParcelReader$ParseException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iValidateObjectHeader, "Overread allowed size end="), parcel);
        }
        sb.append('}');
    }

    public static final void zaI(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                zzah.checkNotNull(obj);
                sb.append(JsonUtils.escapeString(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                byte[] bArr = (byte[]) obj;
                sb.append(bArr != null ? Base64.encodeToString(bArr, 0) : null);
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                byte[] bArr2 = (byte[]) obj;
                sb.append(bArr2 != null ? Base64.encodeToString(bArr2, 10) : null);
                sb.append("\"");
                return;
            case 10:
                zzah.checkNotNull(obj);
                Hex.writeStringMapToJson(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Unknown type = "));
        }
    }

    public static final void zaJ(StringBuilder sb, FastJsonResponse.Field field, Object obj) {
        boolean z = field.zab;
        int i = field.zaa;
        if (!z) {
            zaI(sb, i, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb.append("[");
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            zaI(sb, i, arrayList.get(i2));
        }
        sb.append("]");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeArrayInternal(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        ArrayList arrayList2 = new ArrayList();
        zzah.checkNotNull(arrayList);
        arrayList.size();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(((SafeParcelResponse) ((FastJsonResponse) arrayList.get(i))).zaE());
        }
        int i2 = field.zaf;
        Parcel parcel = this.zab;
        int iZza = CloseableKt.zza(parcel, i2);
        int size2 = arrayList2.size();
        parcel.writeInt(size2);
        for (int i3 = 0; i3 < size2; i3++) {
            Parcel parcel2 = (Parcel) arrayList2.get(i3);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeInternal(FastJsonResponse.Field field, String str, FastJsonResponse fastJsonResponse) {
        zaG(field);
        Parcel parcelZaE = ((SafeParcelResponse) fastJsonResponse).zaE();
        Parcel parcel = this.zab;
        int i = field.zaf;
        if (parcelZaE == null) {
            CloseableKt.zzc(parcel, i, 0);
            return;
        }
        int iZza = CloseableKt.zza(parcel, i);
        parcel.appendFrom(parcelZaE, 0, parcelZaE.dataSize());
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Map getFieldMappings() {
        zan zanVar = this.zad;
        if (zanVar == null) {
            return null;
        }
        String str = this.zae;
        zzah.checkNotNull(str);
        return (Map) zanVar.zab.get(str);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setBooleanInternal(FastJsonResponse.Field field, String str, boolean z) {
        zaG(field);
        Parcel parcel = this.zab;
        CloseableKt.zzc(parcel, field.zaf, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setDecodedBytesInternal(FastJsonResponse.Field field, String str, byte[] bArr) {
        zaG(field);
        CloseableKt.writeByteArray(this.zab, field.zaf, bArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setIntegerInternal(FastJsonResponse.Field field, String str, int i) {
        zaG(field);
        Parcel parcel = this.zab;
        CloseableKt.zzc(parcel, field.zaf, 4);
        parcel.writeInt(i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setLongInternal(FastJsonResponse.Field field, String str, long j) {
        zaG(field);
        Parcel parcel = this.zab;
        CloseableKt.zzc(parcel, field.zaf, 8);
        parcel.writeLong(j);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setStringInternal(FastJsonResponse.Field field, String str, String str2) {
        zaG(field);
        CloseableKt.writeString(this.zab, field.zaf, str2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setStringMapInternal(FastJsonResponse.Field field, String str, Map map) {
        zaG(field);
        Bundle bundle = new Bundle();
        zzah.checkNotNull(map);
        for (String str2 : map.keySet()) {
            bundle.putString(str2, (String) map.get(str2));
        }
        CloseableKt.writeBundle(this.zab, field.zaf, bundle, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setStringsInternal(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        zzah.checkNotNull(arrayList);
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) arrayList.get(i);
        }
        CloseableKt.writeStringArray(this.zab, field.zaf, strArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final String toString() {
        zan zanVar = this.zad;
        zzah.checkNotNull(zanVar, "Cannot convert to JSON on client side.");
        Parcel parcelZaE = zaE();
        parcelZaE.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        String str = this.zae;
        zzah.checkNotNull(str);
        Map map = (Map) zanVar.zab.get(str);
        zzah.checkNotNull(map);
        zaH(sb, map, parcelZaE);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zaa);
        Parcel parcelZaE = zaE();
        if (parcelZaE != null) {
            int iZza2 = CloseableKt.zza(parcel, 2);
            parcel.appendFrom(parcelZaE, 0, parcelZaE.dataSize());
            CloseableKt.zzb(parcel, iZza2);
        }
        CloseableKt.writeParcelable(parcel, 3, this.zac != 0 ? this.zad : null, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final Parcel zaE() {
        int i = this.zaf;
        Parcel parcel = this.zab;
        if (i == 0) {
            int iZza = CloseableKt.zza(parcel, 20293);
            this.zag = iZza;
            CloseableKt.zzb(parcel, iZza);
            this.zaf = 2;
        } else if (i == 1) {
            CloseableKt.zzb(parcel, this.zag);
            this.zaf = 2;
        }
        return parcel;
    }

    public final void zaG(FastJsonResponse.Field field) {
        if (field.zaf == -1) {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
        Parcel parcel = this.zab;
        if (parcel == null) {
            throw new IllegalStateException("Internal Parcel object is null.");
        }
        int i = this.zaf;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
            }
        } else {
            this.zag = CloseableKt.zza(parcel, 20293);
            this.zaf = 1;
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zab(FastJsonResponse.Field field, String str, BigDecimal bigDecimal) {
        zaG(field);
        Parcel parcel = this.zab;
        int i = field.zaf;
        if (bigDecimal == null) {
            CloseableKt.zzc(parcel, i, 0);
            return;
        }
        int iZza = CloseableKt.zza(parcel, i);
        parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
        parcel.writeInt(bigDecimal.scale());
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zad(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        zzah.checkNotNull(arrayList);
        int size = arrayList.size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i = 0; i < size; i++) {
            bigDecimalArr[i] = (BigDecimal) arrayList.get(i);
        }
        int i2 = field.zaf;
        Parcel parcel = this.zab;
        int iZza = CloseableKt.zza(parcel, i2);
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeByteArray(bigDecimalArr[i3].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i3].scale());
        }
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zaf(FastJsonResponse.Field field, String str, BigInteger bigInteger) {
        zaG(field);
        Parcel parcel = this.zab;
        int i = field.zaf;
        if (bigInteger == null) {
            CloseableKt.zzc(parcel, i, 0);
            return;
        }
        int iZza = CloseableKt.zza(parcel, i);
        parcel.writeByteArray(bigInteger.toByteArray());
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zah(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        zzah.checkNotNull(arrayList);
        int size = arrayList.size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i = 0; i < size; i++) {
            bigIntegerArr[i] = (BigInteger) arrayList.get(i);
        }
        int i2 = field.zaf;
        Parcel parcel = this.zab;
        int iZza = CloseableKt.zza(parcel, i2);
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeByteArray(bigIntegerArr[i3].toByteArray());
        }
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zak(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        zzah.checkNotNull(arrayList);
        int size = arrayList.size();
        boolean[] zArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            zArr[i] = ((Boolean) arrayList.get(i)).booleanValue();
        }
        CloseableKt.writeBooleanArray(this.zab, field.zaf, zArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zan(FastJsonResponse.Field field, String str, double d) {
        zaG(field);
        Parcel parcel = this.zab;
        CloseableKt.zzc(parcel, field.zaf, 8);
        parcel.writeDouble(d);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zap(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        zzah.checkNotNull(arrayList);
        int size = arrayList.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = ((Double) arrayList.get(i)).doubleValue();
        }
        int i2 = field.zaf;
        Parcel parcel = this.zab;
        int iZza = CloseableKt.zza(parcel, i2);
        parcel.writeDoubleArray(dArr);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zar(FastJsonResponse.Field field, String str, float f) {
        zaG(field);
        Parcel parcel = this.zab;
        CloseableKt.zzc(parcel, field.zaf, 4);
        parcel.writeFloat(f);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zat(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        zzah.checkNotNull(arrayList);
        int size = arrayList.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = ((Float) arrayList.get(i)).floatValue();
        }
        int i2 = field.zaf;
        Parcel parcel = this.zab;
        int iZza = CloseableKt.zza(parcel, i2);
        parcel.writeFloatArray(fArr);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zaw(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        zzah.checkNotNull(arrayList);
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        CloseableKt.writeIntArray(this.zab, field.zaf, iArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zaz(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        zzah.checkNotNull(arrayList);
        int size = arrayList.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = ((Long) arrayList.get(i)).longValue();
        }
        int i2 = field.zaf;
        Parcel parcel = this.zab;
        int iZza = CloseableKt.zza(parcel, i2);
        parcel.writeLongArray(jArr);
        CloseableKt.zzb(parcel, iZza);
    }
}
