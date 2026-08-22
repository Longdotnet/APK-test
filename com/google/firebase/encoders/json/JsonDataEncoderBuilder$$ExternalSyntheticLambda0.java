package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.ProtobufDataEncoderContext;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class JsonDataEncoderBuilder$$ExternalSyntheticLambda0 implements ObjectEncoder {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ JsonDataEncoderBuilder$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final void encode(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                JsonDataEncoderBuilder.lambda$static$0(obj, (ObjectEncoderContext) obj2);
                break;
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
                objectEncoderContext.add(ProtobufDataEncoderContext.MAP_KEY_DESC, entry.getKey());
                objectEncoderContext.add(ProtobufDataEncoderContext.MAP_VALUE_DESC, entry.getValue());
                break;
            default:
                ProtobufEncoder.Builder.lambda$static$0(obj, (ObjectEncoderContext) obj2);
                break;
        }
    }
}
