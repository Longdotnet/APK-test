package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

/* JADX INFO: loaded from: classes.dex */
public final class AutoBatchedLogRequestEncoder implements Configurator {
    public static final AutoBatchedLogRequestEncoder CONFIG = new AutoBatchedLogRequestEncoder();

    public final class AndroidClientInfoEncoder implements ObjectEncoder {
        public static final AndroidClientInfoEncoder INSTANCE = new AndroidClientInfoEncoder();
        public static final FieldDescriptor SDKVERSION_DESCRIPTOR = FieldDescriptor.of("sdkVersion");
        public static final FieldDescriptor MODEL_DESCRIPTOR = FieldDescriptor.of("model");
        public static final FieldDescriptor HARDWARE_DESCRIPTOR = FieldDescriptor.of("hardware");
        public static final FieldDescriptor DEVICE_DESCRIPTOR = FieldDescriptor.of("device");
        public static final FieldDescriptor PRODUCT_DESCRIPTOR = FieldDescriptor.of("product");
        public static final FieldDescriptor OSBUILD_DESCRIPTOR = FieldDescriptor.of("osBuild");
        public static final FieldDescriptor MANUFACTURER_DESCRIPTOR = FieldDescriptor.of("manufacturer");
        public static final FieldDescriptor FINGERPRINT_DESCRIPTOR = FieldDescriptor.of("fingerprint");
        public static final FieldDescriptor LOCALE_DESCRIPTOR = FieldDescriptor.of("locale");
        public static final FieldDescriptor COUNTRY_DESCRIPTOR = FieldDescriptor.of("country");
        public static final FieldDescriptor MCCMNC_DESCRIPTOR = FieldDescriptor.of("mccMnc");
        public static final FieldDescriptor APPLICATIONBUILD_DESCRIPTOR = FieldDescriptor.of("applicationBuild");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void encode(Object obj, Object obj2) {
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            AutoValue_AndroidClientInfo autoValue_AndroidClientInfo = (AutoValue_AndroidClientInfo) ((AndroidClientInfo) obj);
            objectEncoderContext.add(SDKVERSION_DESCRIPTOR, autoValue_AndroidClientInfo.sdkVersion);
            objectEncoderContext.add(MODEL_DESCRIPTOR, autoValue_AndroidClientInfo.model);
            objectEncoderContext.add(HARDWARE_DESCRIPTOR, autoValue_AndroidClientInfo.hardware);
            objectEncoderContext.add(DEVICE_DESCRIPTOR, autoValue_AndroidClientInfo.device);
            objectEncoderContext.add(PRODUCT_DESCRIPTOR, autoValue_AndroidClientInfo.product);
            objectEncoderContext.add(OSBUILD_DESCRIPTOR, autoValue_AndroidClientInfo.osBuild);
            objectEncoderContext.add(MANUFACTURER_DESCRIPTOR, autoValue_AndroidClientInfo.manufacturer);
            objectEncoderContext.add(FINGERPRINT_DESCRIPTOR, autoValue_AndroidClientInfo.fingerprint);
            objectEncoderContext.add(LOCALE_DESCRIPTOR, autoValue_AndroidClientInfo.locale);
            objectEncoderContext.add(COUNTRY_DESCRIPTOR, autoValue_AndroidClientInfo.country);
            objectEncoderContext.add(MCCMNC_DESCRIPTOR, autoValue_AndroidClientInfo.mccMnc);
            objectEncoderContext.add(APPLICATIONBUILD_DESCRIPTOR, autoValue_AndroidClientInfo.applicationBuild);
        }
    }

    public final class BatchedLogRequestEncoder implements ObjectEncoder {
        public static final BatchedLogRequestEncoder INSTANCE = new BatchedLogRequestEncoder();
        public static final FieldDescriptor LOGREQUEST_DESCRIPTOR = FieldDescriptor.of("logRequest");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void encode(Object obj, Object obj2) {
            ((ObjectEncoderContext) obj2).add(LOGREQUEST_DESCRIPTOR, ((AutoValue_BatchedLogRequest) ((BatchedLogRequest) obj)).logRequests);
        }
    }

    public final class ClientInfoEncoder implements ObjectEncoder {
        public static final ClientInfoEncoder INSTANCE = new ClientInfoEncoder();
        public static final FieldDescriptor CLIENTTYPE_DESCRIPTOR = FieldDescriptor.of("clientType");
        public static final FieldDescriptor ANDROIDCLIENTINFO_DESCRIPTOR = FieldDescriptor.of("androidClientInfo");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void encode(Object obj, Object obj2) {
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            AutoValue_ClientInfo autoValue_ClientInfo = (AutoValue_ClientInfo) ((ClientInfo) obj);
            autoValue_ClientInfo.getClass();
            objectEncoderContext.add(CLIENTTYPE_DESCRIPTOR, ClientInfo.ClientType.ANDROID_FIREBASE);
            objectEncoderContext.add(ANDROIDCLIENTINFO_DESCRIPTOR, autoValue_ClientInfo.androidClientInfo);
        }
    }

    public final class LogEventEncoder implements ObjectEncoder {
        public static final LogEventEncoder INSTANCE = new LogEventEncoder();
        public static final FieldDescriptor EVENTTIMEMS_DESCRIPTOR = FieldDescriptor.of("eventTimeMs");
        public static final FieldDescriptor EVENTCODE_DESCRIPTOR = FieldDescriptor.of("eventCode");
        public static final FieldDescriptor EVENTUPTIMEMS_DESCRIPTOR = FieldDescriptor.of("eventUptimeMs");
        public static final FieldDescriptor SOURCEEXTENSION_DESCRIPTOR = FieldDescriptor.of("sourceExtension");
        public static final FieldDescriptor SOURCEEXTENSIONJSONPROTO3_DESCRIPTOR = FieldDescriptor.of("sourceExtensionJsonProto3");
        public static final FieldDescriptor TIMEZONEOFFSETSECONDS_DESCRIPTOR = FieldDescriptor.of("timezoneOffsetSeconds");
        public static final FieldDescriptor NETWORKCONNECTIONINFO_DESCRIPTOR = FieldDescriptor.of("networkConnectionInfo");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void encode(Object obj, Object obj2) {
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            AutoValue_LogEvent autoValue_LogEvent = (AutoValue_LogEvent) ((LogEvent) obj);
            objectEncoderContext.add(EVENTTIMEMS_DESCRIPTOR, autoValue_LogEvent.eventTimeMs);
            objectEncoderContext.add(EVENTCODE_DESCRIPTOR, autoValue_LogEvent.eventCode);
            objectEncoderContext.add(EVENTUPTIMEMS_DESCRIPTOR, autoValue_LogEvent.eventUptimeMs);
            objectEncoderContext.add(SOURCEEXTENSION_DESCRIPTOR, autoValue_LogEvent.sourceExtension);
            objectEncoderContext.add(SOURCEEXTENSIONJSONPROTO3_DESCRIPTOR, autoValue_LogEvent.sourceExtensionJsonProto3);
            objectEncoderContext.add(TIMEZONEOFFSETSECONDS_DESCRIPTOR, autoValue_LogEvent.timezoneOffsetSeconds);
            objectEncoderContext.add(NETWORKCONNECTIONINFO_DESCRIPTOR, autoValue_LogEvent.networkConnectionInfo);
        }
    }

    public final class LogRequestEncoder implements ObjectEncoder {
        public static final LogRequestEncoder INSTANCE = new LogRequestEncoder();
        public static final FieldDescriptor REQUESTTIMEMS_DESCRIPTOR = FieldDescriptor.of("requestTimeMs");
        public static final FieldDescriptor REQUESTUPTIMEMS_DESCRIPTOR = FieldDescriptor.of("requestUptimeMs");
        public static final FieldDescriptor CLIENTINFO_DESCRIPTOR = FieldDescriptor.of("clientInfo");
        public static final FieldDescriptor LOGSOURCE_DESCRIPTOR = FieldDescriptor.of("logSource");
        public static final FieldDescriptor LOGSOURCENAME_DESCRIPTOR = FieldDescriptor.of("logSourceName");
        public static final FieldDescriptor LOGEVENT_DESCRIPTOR = FieldDescriptor.of("logEvent");
        public static final FieldDescriptor QOSTIER_DESCRIPTOR = FieldDescriptor.of("qosTier");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void encode(Object obj, Object obj2) {
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            AutoValue_LogRequest autoValue_LogRequest = (AutoValue_LogRequest) ((LogRequest) obj);
            objectEncoderContext.add(REQUESTTIMEMS_DESCRIPTOR, autoValue_LogRequest.requestTimeMs);
            objectEncoderContext.add(REQUESTUPTIMEMS_DESCRIPTOR, autoValue_LogRequest.requestUptimeMs);
            objectEncoderContext.add(CLIENTINFO_DESCRIPTOR, autoValue_LogRequest.clientInfo);
            objectEncoderContext.add(LOGSOURCE_DESCRIPTOR, autoValue_LogRequest.logSource);
            objectEncoderContext.add(LOGSOURCENAME_DESCRIPTOR, autoValue_LogRequest.logSourceName);
            objectEncoderContext.add(LOGEVENT_DESCRIPTOR, autoValue_LogRequest.logEvents);
            objectEncoderContext.add(QOSTIER_DESCRIPTOR, QosTier.DEFAULT);
        }
    }

    public final class NetworkConnectionInfoEncoder implements ObjectEncoder {
        public static final NetworkConnectionInfoEncoder INSTANCE = new NetworkConnectionInfoEncoder();
        public static final FieldDescriptor NETWORKTYPE_DESCRIPTOR = FieldDescriptor.of("networkType");
        public static final FieldDescriptor MOBILESUBTYPE_DESCRIPTOR = FieldDescriptor.of("mobileSubtype");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void encode(Object obj, Object obj2) {
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            AutoValue_NetworkConnectionInfo autoValue_NetworkConnectionInfo = (AutoValue_NetworkConnectionInfo) ((NetworkConnectionInfo) obj);
            objectEncoderContext.add(NETWORKTYPE_DESCRIPTOR, autoValue_NetworkConnectionInfo.networkType);
            objectEncoderContext.add(MOBILESUBTYPE_DESCRIPTOR, autoValue_NetworkConnectionInfo.mobileSubtype);
        }
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public final void configure(EncoderConfig encoderConfig) {
        BatchedLogRequestEncoder batchedLogRequestEncoder = BatchedLogRequestEncoder.INSTANCE;
        encoderConfig.registerEncoder(BatchedLogRequest.class, batchedLogRequestEncoder);
        encoderConfig.registerEncoder(AutoValue_BatchedLogRequest.class, batchedLogRequestEncoder);
        LogRequestEncoder logRequestEncoder = LogRequestEncoder.INSTANCE;
        encoderConfig.registerEncoder(LogRequest.class, logRequestEncoder);
        encoderConfig.registerEncoder(AutoValue_LogRequest.class, logRequestEncoder);
        ClientInfoEncoder clientInfoEncoder = ClientInfoEncoder.INSTANCE;
        encoderConfig.registerEncoder(ClientInfo.class, clientInfoEncoder);
        encoderConfig.registerEncoder(AutoValue_ClientInfo.class, clientInfoEncoder);
        AndroidClientInfoEncoder androidClientInfoEncoder = AndroidClientInfoEncoder.INSTANCE;
        encoderConfig.registerEncoder(AndroidClientInfo.class, androidClientInfoEncoder);
        encoderConfig.registerEncoder(AutoValue_AndroidClientInfo.class, androidClientInfoEncoder);
        LogEventEncoder logEventEncoder = LogEventEncoder.INSTANCE;
        encoderConfig.registerEncoder(LogEvent.class, logEventEncoder);
        encoderConfig.registerEncoder(AutoValue_LogEvent.class, logEventEncoder);
        NetworkConnectionInfoEncoder networkConnectionInfoEncoder = NetworkConnectionInfoEncoder.INSTANCE;
        encoderConfig.registerEncoder(NetworkConnectionInfo.class, networkConnectionInfoEncoder);
        encoderConfig.registerEncoder(AutoValue_NetworkConnectionInfo.class, networkConnectionInfoEncoder);
    }
}
