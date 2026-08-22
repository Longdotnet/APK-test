package com.google.android.gms.internal.consent_sdk;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzcl {
    public String zza;
    public String zzb;
    public String zzc;
    public int zzf = 1;
    public List zzd = Collections.emptyList();
    public List zze = Collections.emptyList();
    public int zzg = 1;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:74:0x0104  */
    /* JADX WARN: Code duplicated, block: B:95:0x014a  */
    public static zzcl zza(JsonReader jsonReader) throws IOException {
        byte b;
        byte b2;
        int i;
        zzcl zzclVar = new zzcl();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int i2 = 6;
            int i3 = 3;
            switch (jsonReader.nextName()) {
                case "consent_signal":
                    String strNextString = jsonReader.nextString();
                    switch (strNextString) {
                        case "CONSENT_SIGNAL_UNKNOWN":
                            i2 = 1;
                            zzclVar.zzf = i2;
                            break;
                        case "CONSENT_SIGNAL_PERSONALIZED_ADS":
                            i2 = 2;
                            zzclVar.zzf = i2;
                            break;
                        case "CONSENT_SIGNAL_NON_PERSONALIZED_ADS":
                            i2 = 3;
                            zzclVar.zzf = i2;
                            break;
                        case "CONSENT_SIGNAL_SUFFICIENT":
                            i2 = 4;
                            zzclVar.zzf = i2;
                            break;
                        case "CONSENT_SIGNAL_COLLECT_CONSENT":
                            i2 = 5;
                            zzclVar.zzf = i2;
                            break;
                        case "CONSENT_SIGNAL_NOT_REQUIRED":
                            zzclVar.zzf = i2;
                            break;
                        case "CONSENT_SIGNAL_ERROR":
                            i2 = 7;
                            zzclVar.zzf = i2;
                            break;
                        case "CONSENT_SIGNAL_PUBLISHER_MISCONFIGURATION":
                            i2 = 8;
                            zzclVar.zzf = i2;
                            break;
                        default:
                            throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.ConsentSignalfrom: ".concat(strNextString));
                    }
                    break;
                case "consent_form_payload":
                    zzclVar.zza = jsonReader.nextString();
                    break;
                case "consent_form_base_url":
                    zzclVar.zzb = jsonReader.nextString();
                    break;
                case "error_message":
                    zzclVar.zzc = jsonReader.nextString();
                    break;
                case "request_info_keys":
                    zzclVar.zzd = new ArrayList();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzclVar.zzd.add(jsonReader.nextString());
                    }
                    jsonReader.endArray();
                    break;
                case "actions":
                    zzclVar.zze = new ArrayList();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzck zzckVar = new zzck();
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName = jsonReader.nextName();
                            int iHashCode = strNextName.hashCode();
                            if (iHashCode != -2105551094) {
                                if (iHashCode == 1583758243 && strNextName.equals("action_type")) {
                                    b = 0;
                                } else {
                                    b = -1;
                                }
                            } else if (strNextName.equals("args_json")) {
                                b = 1;
                            } else {
                                b = -1;
                            }
                            if (b == 0) {
                                String strNextString2 = jsonReader.nextString();
                                int iHashCode2 = strNextString2.hashCode();
                                if (iHashCode2 != 64208429) {
                                    if (iHashCode2 != 82862015) {
                                        if (iHashCode2 == 1856333582 && strNextString2.equals("UNKNOWN_ACTION_TYPE")) {
                                            b2 = 0;
                                        } else {
                                            b2 = -1;
                                        }
                                    } else if (strNextString2.equals("WRITE")) {
                                        b2 = 1;
                                    } else {
                                        b2 = -1;
                                    }
                                } else if (strNextString2.equals("CLEAR")) {
                                    b2 = 2;
                                } else {
                                    b2 = -1;
                                }
                                if (b2 == 0) {
                                    i = 1;
                                } else if (b2 == 1) {
                                    i = 2;
                                } else {
                                    if (b2 != 2) {
                                        throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.Action.ActionTypefrom: ".concat(strNextString2));
                                    }
                                    i = 3;
                                }
                                zzckVar.zzb = i;
                            } else if (b != 1) {
                                jsonReader.skipValue();
                            } else {
                                zzckVar.zza = jsonReader.nextString();
                            }
                        }
                        jsonReader.endObject();
                        zzclVar.zze.add(zzckVar);
                    }
                    jsonReader.endArray();
                    break;
                case "privacy_options_required":
                    String strNextString3 = jsonReader.nextString();
                    int iHashCode3 = strNextString3.hashCode();
                    if (iHashCode3 != -1888946261) {
                        if (iHashCode3 != 389487519) {
                            if (iHashCode3 == 433141802 && strNextString3.equals("UNKNOWN")) {
                            }
                        } else if (strNextString3.equals("REQUIRED")) {
                        }
                    } else if (strNextString3.equals("NOT_REQUIRED")) {
                    }
                    if (r6 == 0) {
                        i3 = 1;
                    } else if (r6 == 1) {
                        i3 = 2;
                    } else if (r6 != 2) {
                        throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.PrivacyOptionsRequirementStatusfrom: ".concat(strNextString3));
                    }
                    zzclVar.zzg = i3;
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return zzclVar;
    }
}
