package com.google.zxing.oned;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zze;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.encoders.json.JsonValueObjectEncoderContext;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.io.IOException;
import java.io.StringWriter;
import java.util.EnumMap;

/* JADX INFO: loaded from: classes3.dex */
public final class UPCAWriter implements OnSuccessListener, DataEncoder, Writer {
    public final Object subWriter;

    public /* synthetic */ UPCAWriter(Object obj) {
        this.subWriter = obj;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, int i, EnumMap enumMap) {
        if (i != 15) {
            throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf$1(i)));
        }
        return ((EAN8Writer) this.subWriter).encode("0".concat(String.valueOf(str)), 8, enumMap);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        ((TaskCompletionSource) this.subWriter).setResult(new zze(null, (String) obj));
    }

    public UPCAWriter() {
        this.subWriter = new EAN8Writer(1);
    }

    @Override // com.google.firebase.encoders.DataEncoder
    public void encode(Object obj, java.io.Writer writer) throws IOException {
        JsonDataEncoderBuilder jsonDataEncoderBuilder = (JsonDataEncoderBuilder) this.subWriter;
        JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(writer, jsonDataEncoderBuilder.objectEncoders, jsonDataEncoderBuilder.valueEncoders, jsonDataEncoderBuilder.fallbackEncoder, jsonDataEncoderBuilder.ignoreNullValues);
        jsonValueObjectEncoderContext.add(obj, false);
        jsonValueObjectEncoderContext.maybeUnNest();
        jsonValueObjectEncoderContext.jsonWriter.flush();
    }

    @Override // com.google.firebase.encoders.DataEncoder
    public String encode(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            encode(obj, stringWriter);
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }
}
