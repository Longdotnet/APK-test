package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.android.gms.tasks.zzu;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder implements Configurator, Factory {
    public static final AutoProtoEncoderDoNotUseEncoder CONFIG = new AutoProtoEncoderDoNotUseEncoder();

    public final class ClientMetricsEncoder implements ObjectEncoder {
        public static final ClientMetricsEncoder INSTANCE = new ClientMetricsEncoder();
        public static final FieldDescriptor WINDOW_DESCRIPTOR = FieldDescriptor.builder("window").withProperty(AtProtobuf.builder().tag(1).build()).build();
        public static final FieldDescriptor LOGSOURCEMETRICS_DESCRIPTOR = FieldDescriptor.builder("logSourceMetrics").withProperty(AtProtobuf.builder().tag(2).build()).build();
        public static final FieldDescriptor GLOBALMETRICS_DESCRIPTOR = FieldDescriptor.builder("globalMetrics").withProperty(AtProtobuf.builder().tag(3).build()).build();
        public static final FieldDescriptor APPNAMESPACE_DESCRIPTOR = FieldDescriptor.builder("appNamespace").withProperty(AtProtobuf.builder().tag(4).build()).build();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void encode(Object obj, Object obj2) {
            ClientMetrics clientMetrics = (ClientMetrics) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add(WINDOW_DESCRIPTOR, clientMetrics.window_);
            objectEncoderContext.add(LOGSOURCEMETRICS_DESCRIPTOR, clientMetrics.log_source_metrics_);
            objectEncoderContext.add(GLOBALMETRICS_DESCRIPTOR, clientMetrics.global_metrics_);
            objectEncoderContext.add(APPNAMESPACE_DESCRIPTOR, clientMetrics.app_namespace_);
        }
    }

    public final class GlobalMetricsEncoder implements ObjectEncoder {
        public static final GlobalMetricsEncoder INSTANCE = new GlobalMetricsEncoder();
        public static final FieldDescriptor STORAGEMETRICS_DESCRIPTOR = FieldDescriptor.builder("storageMetrics").withProperty(AtProtobuf.builder().tag(1).build()).build();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void encode(Object obj, Object obj2) {
            ((ObjectEncoderContext) obj2).add(STORAGEMETRICS_DESCRIPTOR, ((GlobalMetrics) obj).storage_metrics_);
        }
    }

    public final class LogEventDroppedEncoder implements ObjectEncoder {
        public static final LogEventDroppedEncoder INSTANCE = new LogEventDroppedEncoder();
        public static final FieldDescriptor EVENTSDROPPEDCOUNT_DESCRIPTOR = FieldDescriptor.builder("eventsDroppedCount").withProperty(AtProtobuf.builder().tag(1).build()).build();
        public static final FieldDescriptor REASON_DESCRIPTOR = FieldDescriptor.builder("reason").withProperty(AtProtobuf.builder().tag(3).build()).build();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void encode(Object obj, Object obj2) {
            LogEventDropped logEventDropped = (LogEventDropped) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add(EVENTSDROPPEDCOUNT_DESCRIPTOR, logEventDropped.events_dropped_count_);
            objectEncoderContext.add(REASON_DESCRIPTOR, logEventDropped.reason_);
        }
    }

    public final class LogSourceMetricsEncoder implements ObjectEncoder {
        public static final LogSourceMetricsEncoder INSTANCE = new LogSourceMetricsEncoder();
        public static final FieldDescriptor LOGSOURCE_DESCRIPTOR = FieldDescriptor.builder("logSource").withProperty(AtProtobuf.builder().tag(1).build()).build();
        public static final FieldDescriptor LOGEVENTDROPPED_DESCRIPTOR = FieldDescriptor.builder("logEventDropped").withProperty(AtProtobuf.builder().tag(2).build()).build();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void encode(Object obj, Object obj2) {
            LogSourceMetrics logSourceMetrics = (LogSourceMetrics) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add(LOGSOURCE_DESCRIPTOR, logSourceMetrics.log_source_);
            objectEncoderContext.add(LOGEVENTDROPPED_DESCRIPTOR, logSourceMetrics.log_event_dropped_);
        }
    }

    public final class ProtoEncoderDoNotUseEncoder implements ObjectEncoder {
        public static final ProtoEncoderDoNotUseEncoder INSTANCE = new ProtoEncoderDoNotUseEncoder();

        static {
            FieldDescriptor.of("clientMetrics");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void encode(Object obj, Object obj2) {
            if (obj != null) {
                throw new ClassCastException();
            }
            throw null;
        }
    }

    public final class StorageMetricsEncoder implements ObjectEncoder {
        public static final StorageMetricsEncoder INSTANCE = new StorageMetricsEncoder();
        public static final FieldDescriptor CURRENTCACHESIZEBYTES_DESCRIPTOR = FieldDescriptor.builder("currentCacheSizeBytes").withProperty(AtProtobuf.builder().tag(1).build()).build();
        public static final FieldDescriptor MAXCACHESIZEBYTES_DESCRIPTOR = FieldDescriptor.builder("maxCacheSizeBytes").withProperty(AtProtobuf.builder().tag(2).build()).build();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void encode(Object obj, Object obj2) {
            StorageMetrics storageMetrics = (StorageMetrics) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add(CURRENTCACHESIZEBYTES_DESCRIPTOR, storageMetrics.current_cache_size_bytes_);
            objectEncoderContext.add(MAXCACHESIZEBYTES_DESCRIPTOR, storageMetrics.max_cache_size_bytes_);
        }
    }

    public final class TimeWindowEncoder implements ObjectEncoder {
        public static final TimeWindowEncoder INSTANCE = new TimeWindowEncoder();
        public static final FieldDescriptor STARTMS_DESCRIPTOR = FieldDescriptor.builder("startMs").withProperty(AtProtobuf.builder().tag(1).build()).build();
        public static final FieldDescriptor ENDMS_DESCRIPTOR = FieldDescriptor.builder("endMs").withProperty(AtProtobuf.builder().tag(2).build()).build();

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void encode(Object obj, Object obj2) {
            TimeWindow timeWindow = (TimeWindow) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add(STARTMS_DESCRIPTOR, timeWindow.start_ms_);
            objectEncoderContext.add(ENDMS_DESCRIPTOR, timeWindow.end_ms_);
        }
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig encoderConfig) {
        encoderConfig.registerEncoder(ProtoEncoderDoNotUse.class, ProtoEncoderDoNotUseEncoder.INSTANCE);
        encoderConfig.registerEncoder(ClientMetrics.class, ClientMetricsEncoder.INSTANCE);
        encoderConfig.registerEncoder(TimeWindow.class, TimeWindowEncoder.INSTANCE);
        encoderConfig.registerEncoder(LogSourceMetrics.class, LogSourceMetricsEncoder.INSTANCE);
        encoderConfig.registerEncoder(LogEventDropped.class, LogEventDroppedEncoder.INSTANCE);
        encoderConfig.registerEncoder(GlobalMetrics.class, GlobalMetricsEncoder.INSTANCE);
        encoderConfig.registerEncoder(StorageMetrics.class, StorageMetricsEncoder.INSTANCE);
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new zzu(Executors.newSingleThreadExecutor(), 3);
    }
}
