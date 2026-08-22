package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import okio.AsyncTimeout;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzfcd {
    public final List zza;
    public final String zzb;
    public final int zzc;
    public final int zzd;
    public final String zze;
    public final int zzf;
    public final long zzg;
    public final boolean zzh;
    public final String zzi;
    public final zzfcc zzj;
    public final Bundle zzk;
    public final String zzl;
    public final String zzm;
    public final String zzn;
    public final JSONObject zzo;
    public final JSONObject zzp;
    public final String zzq;
    public final int zzr;
    public long zzs;
    public long zzt;

    public zzfcd(JsonReader jsonReader) throws IOException {
        List listEmptyList = Collections.emptyList();
        Bundle bundle = new Bundle();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jsonReader.beginObject();
        String strNextString = "";
        String strNextString2 = "";
        String strNextString3 = strNextString2;
        String strNextString4 = strNextString3;
        String strNextString5 = strNextString4;
        int iNextInt = 0;
        int iNextInt2 = 0;
        boolean zNextBoolean = false;
        zzfcc zzfccVar = null;
        long jZza = -1;
        long jZza2 = -1;
        long jNextLong = 0;
        int iNextInt3 = -1;
        int iMax = 1;
        String strNextString6 = strNextString5;
        String strNextString7 = strNextString6;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (Objects.equals(strNextName, "nofill_urls")) {
                listEmptyList = AsyncTimeout.Companion.zzd(jsonReader);
            } else if ("refresh_interval".equals(strNextName)) {
                iNextInt = jsonReader.nextInt();
            } else if (Objects.equals(strNextName, "refresh_load_delay_time_interval")) {
                iNextInt3 = jsonReader.nextInt();
            } else if ("gws_query_id".equals(strNextName)) {
                strNextString = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(strNextName)) {
                strNextString6 = jsonReader.nextString();
            } else if ("is_idless".equals(strNextName)) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if ("response_code".equals(strNextName)) {
                iNextInt2 = jsonReader.nextInt();
            } else if ("latency".equals(strNextName)) {
                jNextLong = jsonReader.nextLong();
            } else {
                zzbcv zzbcvVar = zzbde.zziH;
                String str = strNextString3;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                JSONObject jSONObject3 = jSONObject2;
                if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && "public_error".equals(strNextName) && jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                    zzfccVar = new zzfcc(jsonReader);
                } else if ("bidding_data".equals(strNextName)) {
                    strNextString7 = jsonReader.nextString();
                } else {
                    zzbcv zzbcvVar2 = zzbde.zzkQ;
                    zzbdc zzbdcVar = zzbdVar.zzd;
                    if (((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue() && Objects.equals(strNextName, "topics_should_record_observation")) {
                        jsonReader.nextBoolean();
                    } else if ("adapter_response_replacement_key".equals(strNextName)) {
                        strNextString3 = jsonReader.nextString();
                        jSONObject2 = jSONObject3;
                    } else if ("response_info_extras".equals(strNextName)) {
                        if (((Boolean) zzbdcVar.zzb(zzbde.zzgY)).booleanValue()) {
                            try {
                                Bundle bundleZza = AsyncTimeout.Companion.zza(AsyncTimeout.Companion.zzi(jsonReader));
                                if (bundleZza != null) {
                                    bundle = bundleZza;
                                }
                            } catch (IOException | JSONException unused) {
                                strNextString3 = str;
                                jSONObject2 = jSONObject3;
                            } catch (IllegalStateException unused2) {
                                jsonReader.skipValue();
                                strNextString3 = str;
                                jSONObject2 = jSONObject3;
                            }
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if ("adRequestPostBody".equals(strNextName)) {
                        if (((Boolean) zzbdcVar.zzb(zzbde.zzjI)).booleanValue()) {
                            strNextString5 = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if (!"adRequestUrl".equals(strNextName)) {
                        zzbcv zzbcvVar3 = zzbde.zzjJ;
                        if (((Boolean) zzbdcVar.zzb(zzbcvVar3)).booleanValue() && Objects.equals(strNextName, "adResponseBody")) {
                            strNextString2 = jsonReader.nextString();
                        } else if (((Boolean) zzbdcVar.zzb(zzbcvVar3)).booleanValue() && Objects.equals(strNextName, "adResponseHeaders")) {
                            jSONObject = AsyncTimeout.Companion.zzi(jsonReader);
                        } else {
                            if (Objects.equals(strNextName, "max_parallel_renderers")) {
                                iMax = Math.max(1, jsonReader.nextInt());
                            } else if (((Boolean) zzbdcVar.zzb(zzbde.zzjR)).booleanValue() && Objects.equals(strNextName, "inspector_ad_transaction_extras")) {
                                jSONObject2 = AsyncTimeout.Companion.zzi(jsonReader);
                                strNextString3 = str;
                            } else if (((Boolean) zzbdcVar.zzb(zzbde.zzcr)).booleanValue() && Objects.equals(strNextName, "latency_extras")) {
                                try {
                                    Bundle bundleZza2 = AsyncTimeout.Companion.zza(AsyncTimeout.Companion.zzi(jsonReader));
                                    if (bundleZza2 != null) {
                                        jZza2 = zza(bundleZza2.getDouble("start_time"));
                                        jZza = zza(bundleZza2.getDouble("end_time"));
                                    }
                                } catch (IOException | JSONException unused3) {
                                } catch (IllegalStateException unused4) {
                                    jsonReader.skipValue();
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                            strNextString3 = str;
                            jSONObject2 = jSONObject3;
                        }
                    } else if (((Boolean) zzbdcVar.zzb(zzbde.zzjI)).booleanValue()) {
                        strNextString4 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    strNextString3 = str;
                    jSONObject2 = jSONObject3;
                }
                strNextString3 = str;
                jSONObject2 = jSONObject3;
            }
        }
        JSONObject jSONObject4 = jSONObject2;
        String str2 = strNextString3;
        jsonReader.endObject();
        this.zza = listEmptyList;
        this.zzc = iNextInt;
        if (((Boolean) zzbfk.zzc.zze()).booleanValue()) {
            this.zzd = -1;
        } else {
            zzbeo zzbeoVar = zzbes.zza;
            if (((Long) zzbeoVar.zze()).longValue() > -1) {
                this.zzd = ((Long) zzbeoVar.zze()).intValue();
            } else {
                this.zzd = iNextInt3;
            }
        }
        this.zzb = strNextString;
        this.zze = strNextString6;
        this.zzf = iNextInt2;
        this.zzg = jNextLong;
        this.zzj = zzfccVar;
        this.zzh = zNextBoolean;
        this.zzi = strNextString7;
        this.zzk = bundle;
        this.zzl = strNextString4;
        this.zzm = strNextString5;
        this.zzn = strNextString2;
        this.zzo = jSONObject;
        this.zzp = jSONObject4;
        this.zzq = str2;
        zzbeo zzbeoVar2 = zzbfi.zza;
        this.zzr = ((Long) zzbeoVar2.zze()).longValue() > 0 ? ((Long) zzbeoVar2.zze()).intValue() : iMax;
        this.zzs = jZza2;
        this.zzt = jZza;
    }

    private static final long zza(double d) {
        if (d > 9.223372036854776E18d || d < -9.223372036854776E18d) {
            return -1L;
        }
        return (long) d;
    }
}
