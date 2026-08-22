package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Base64;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.JsonUtils;
import com.google.firebase.auth.zzz;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.io.CloseableKt;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FastJsonResponse {

    public final class Field extends AbstractSafeParcelable {
        public static final zaj CREATOR = new zaj();
        public final int zaa;
        public final boolean zab;
        public final int zac;
        public final boolean zad;
        public final String zae;
        public final int zaf;
        public final Class zag;
        public final String zah;
        public final int zai;
        public zan zaj;
        public final StringToIntConverter zak;

        public Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, zaa zaaVar) {
            this.zai = i;
            this.zaa = i2;
            this.zab = z;
            this.zac = i3;
            this.zad = z2;
            this.zae = str;
            this.zaf = i4;
            if (str2 == null) {
                this.zag = null;
                this.zah = null;
            } else {
                this.zag = SafeParcelResponse.class;
                this.zah = str2;
            }
            if (zaaVar == null) {
                this.zak = null;
                return;
            }
            StringToIntConverter stringToIntConverter = zaaVar.zab;
            if (stringToIntConverter == null) {
                throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
            }
            this.zak = stringToIntConverter;
        }

        public static Field forStrings(int i, String str) {
            return new Field(7, true, 7, true, str, i, null);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iZza = CloseableKt.zza(parcel, 20293);
            CloseableKt.zzc(parcel, 1, 4);
            parcel.writeInt(this.zai);
            CloseableKt.zzc(parcel, 2, 4);
            parcel.writeInt(this.zaa);
            CloseableKt.zzc(parcel, 3, 4);
            parcel.writeInt(this.zab ? 1 : 0);
            CloseableKt.zzc(parcel, 4, 4);
            parcel.writeInt(this.zac);
            CloseableKt.zzc(parcel, 5, 4);
            parcel.writeInt(this.zad ? 1 : 0);
            CloseableKt.writeString(parcel, 6, this.zae, false);
            CloseableKt.zzc(parcel, 7, 4);
            parcel.writeInt(this.zaf);
            zaa zaaVar = null;
            String str = this.zah;
            if (str == null) {
                str = null;
            }
            CloseableKt.writeString(parcel, 8, str, false);
            StringToIntConverter stringToIntConverter = this.zak;
            if (stringToIntConverter != null) {
                if (!(stringToIntConverter instanceof StringToIntConverter)) {
                    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
                }
                zaaVar = new zaa(stringToIntConverter);
            }
            CloseableKt.writeParcelable(parcel, 9, zaaVar, i, false);
            CloseableKt.zzb(parcel, iZza);
        }

        public final String toString() {
            zzz zzzVar = new zzz(this);
            zzzVar.add(Integer.valueOf(this.zai), "versionCode");
            zzzVar.add(Integer.valueOf(this.zaa), "typeIn");
            zzzVar.add(Boolean.valueOf(this.zab), "typeInArray");
            zzzVar.add(Integer.valueOf(this.zac), "typeOut");
            zzzVar.add(Boolean.valueOf(this.zad), "typeOutArray");
            zzzVar.add(this.zae, "outputFieldName");
            zzzVar.add(Integer.valueOf(this.zaf), "safeParcelFieldId");
            String str = this.zah;
            if (str == null) {
                str = null;
            }
            zzzVar.add(str, ygoi.NnTH);
            Class cls = this.zag;
            if (cls != null) {
                zzzVar.add(cls.getCanonicalName(), "concreteType.class");
            }
            StringToIntConverter stringToIntConverter = this.zak;
            if (stringToIntConverter != null) {
                zzzVar.add(stringToIntConverter.getClass().getCanonicalName(), "converterName");
            }
            return zzzVar.toString();
        }

        public Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class cls) {
            this.zai = 1;
            this.zaa = i;
            this.zab = z;
            this.zac = i2;
            this.zad = z2;
            this.zae = str;
            this.zaf = i3;
            this.zag = cls;
            if (cls == null) {
                this.zah = null;
            } else {
                this.zah = cls.getCanonicalName();
            }
            this.zak = null;
        }
    }

    public static final Object zaD(Field field, Object obj) {
        StringToIntConverter stringToIntConverter = field.zak;
        if (stringToIntConverter == null) {
            return obj;
        }
        String str = (String) stringToIntConverter.zac.get(((Integer) obj).intValue());
        return (str == null && stringToIntConverter.zab.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public static final void zaF(StringBuilder sb, Field field, Object obj) {
        int i = field.zaa;
        if (i == 11) {
            Class cls = field.zag;
            zzah.checkNotNull(cls);
            sb.append(((FastJsonResponse) cls.cast(obj)).toString());
        } else {
            if (i != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(JsonUtils.escapeString((String) obj));
            sb.append("\"");
        }
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field field, String str, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(Field field, String str, T t) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    public abstract Map<String, Field> getFieldMappings();

    public Object getFieldValue(Field field) {
        String str = field.zae;
        if (field.zag == null) {
            return getValueObject(str);
        }
        if (!(getValueObject(str) == null)) {
            throw new IllegalStateException("Concrete field shouldn't be value object: " + field.zae);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(str.charAt(0)) + str.substring(1), null).invoke(this, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public abstract Object getValueObject(String str);

    public boolean isFieldSet(Field field) {
        if (field.zac != 11) {
            return isPrimitiveFieldSet(field.zae);
        }
        if (field.zad) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public abstract boolean isPrimitiveFieldSet(String str);

    public void setBooleanInternal(Field field, String str, boolean z) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    public void setDecodedBytesInternal(Field field, String str, byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    public void setIntegerInternal(Field field, String str, int i) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    public void setLongInternal(Field field, String str, long j) {
        throw new UnsupportedOperationException("Long not supported");
    }

    public void setStringInternal(Field field, String str, String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    public void setStringMapInternal(Field field, String str, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    public String toString() {
        Map<String, Field> fieldMappings = getFieldMappings();
        StringBuilder sb = new StringBuilder(100);
        for (String str : fieldMappings.keySet()) {
            Field field = fieldMappings.get(str);
            if (isFieldSet(field)) {
                Object objZaD = zaD(field, getFieldValue(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (objZaD != null) {
                    switch (field.zac) {
                        case 8:
                            sb.append("\"");
                            sb.append(Base64.encodeToString((byte[]) objZaD, 0));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(Base64.encodeToString((byte[]) objZaD, 10));
                            sb.append("\"");
                            break;
                        case 10:
                            Hex.writeStringMapToJson(sb, (HashMap) objZaD);
                            break;
                        default:
                            if (field.zab) {
                                ArrayList arrayList = (ArrayList) objZaD;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    if (i > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i);
                                    if (obj != null) {
                                        zaF(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                            } else {
                                zaF(sb, field, objZaD);
                            }
                            break;
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    public final void zaA(Field field, String str) {
        if (field.zak != null) {
            zaE(field, str);
        } else {
            setStringInternal(field, field.zae, str);
        }
    }

    public final void zaB(Field field, Map map) {
        if (field.zak != null) {
            zaE(field, map);
        } else {
            setStringMapInternal(field, field.zae, map);
        }
    }

    public final void zaC(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            setStringsInternal(field, field.zae, arrayList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zaE(Field field, Object obj) {
        int i = field.zac;
        StringToIntConverter stringToIntConverter = field.zak;
        zzah.checkNotNull(stringToIntConverter);
        HashMap map = stringToIntConverter.zab;
        Integer num = (Integer) map.get((String) obj);
        Integer num2 = num;
        if (num == null) {
            num2 = (Integer) map.get("gms_unknown");
        }
        zzah.checkNotNull(num2);
        String str = field.zae;
        switch (i) {
            case 0:
                setIntegerInternal(field, str, num2.intValue());
                return;
            case 1:
                zaf(field, str, (BigInteger) num2);
                return;
            case 2:
                setLongInternal(field, str, ((Long) num2).longValue());
                return;
            case 3:
            default:
                throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Unsupported type for conversion: "));
            case 4:
                zan(field, str, ((Double) num2).doubleValue());
                return;
            case 5:
                zab(field, str, (BigDecimal) num2);
                return;
            case 6:
                setBooleanInternal(field, str, ((Boolean) num2).booleanValue());
                return;
            case 7:
                setStringInternal(field, str, (String) num2);
                return;
            case 8:
            case 9:
                setDecodedBytesInternal(field, str, (byte[]) num2);
                return;
        }
    }

    public final void zaa(Field field, BigDecimal bigDecimal) {
        if (field.zak != null) {
            zaE(field, bigDecimal);
        } else {
            zab(field, field.zae, bigDecimal);
        }
    }

    public void zab(Field field, String str, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public final void zac(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zad(field, field.zae, arrayList);
        }
    }

    public final void zae(Field field, BigInteger bigInteger) {
        if (field.zak != null) {
            zaE(field, bigInteger);
        } else {
            zaf(field, field.zae, bigInteger);
        }
    }

    public void zaf(Field field, String str, BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public final void zag(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zah(field, field.zae, arrayList);
        }
    }

    public void zah(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final void zai(Field field, boolean z) {
        if (field.zak != null) {
            zaE(field, Boolean.valueOf(z));
        } else {
            setBooleanInternal(field, field.zae, z);
        }
    }

    public final void zaj(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zak(field, field.zae, arrayList);
        }
    }

    public void zak(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final void zal(Field field, byte[] bArr) {
        if (field.zak != null) {
            zaE(field, bArr);
        } else {
            setDecodedBytesInternal(field, field.zae, bArr);
        }
    }

    public final void zam(Field field, double d) {
        if (field.zak != null) {
            zaE(field, Double.valueOf(d));
        } else {
            zan(field, field.zae, d);
        }
    }

    public void zan(Field field, String str, double d) {
        throw new UnsupportedOperationException("Double not supported");
    }

    public final void zao(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zap(field, field.zae, arrayList);
        }
    }

    public void zap(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    public final void zaq(Field field, float f) {
        if (field.zak != null) {
            zaE(field, Float.valueOf(f));
        } else {
            zar(field, field.zae, f);
        }
    }

    public void zar(Field field, String str, float f) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public final void zas(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zat(field, field.zae, arrayList);
        }
    }

    public void zat(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    public final void zau(Field field, int i) {
        if (field.zak != null) {
            zaE(field, Integer.valueOf(i));
        } else {
            setIntegerInternal(field, field.zae, i);
        }
    }

    public final void zav(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zaw(field, field.zae, arrayList);
        }
    }

    public void zaw(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    public final void zax(Field field, long j) {
        if (field.zak != null) {
            zaE(field, Long.valueOf(j));
        } else {
            setLongInternal(field, field.zae, j);
        }
    }

    public final void zay(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zaz(field, field.zae, arrayList);
        }
    }

    public void zaz(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    public void setStringsInternal(Field field, String str, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException(xPQrbOSWiEdU.aJiKyMhGvvHlfYv);
    }

    public void zad(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException(RDFWIi.htr);
    }
}
