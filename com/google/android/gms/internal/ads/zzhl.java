package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class zzhl extends zzgc {
    private final byte[] zza;
    private final DatagramPacket zzb;
    private Uri zzc;
    private DatagramSocket zzd;
    private MulticastSocket zze;
    private InetAddress zzf;
    private boolean zzg;
    private int zzh;

    public zzhl() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) throws zzhk {
        if (i2 == 0) {
            return 0;
        }
        if (this.zzh == 0) {
            try {
                DatagramSocket datagramSocket = this.zzd;
                if (datagramSocket == null) {
                    throw null;
                }
                DatagramPacket datagramPacket = this.zzb;
                datagramSocket.receive(datagramPacket);
                int length = datagramPacket.getLength();
                this.zzh = length;
                zzg(length);
            } catch (SocketTimeoutException e) {
                throw new zzhk(e, 2002);
            } catch (IOException e2) {
                throw new zzhk(e2, 2001);
            }
        }
        int length2 = this.zzb.getLength();
        int i3 = this.zzh;
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.zza, length2 - i3, bArr, i, iMin);
        this.zzh -= iMin;
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final long zzb(zzgo zzgoVar) throws zzhk {
        Uri uri = zzgoVar.zza;
        this.zzc = uri;
        String host = uri.getHost();
        host.getClass();
        int port = this.zzc.getPort();
        zzi(zzgoVar);
        try {
            this.zzf = InetAddress.getByName(host);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.zzf, port);
            if (this.zzf.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.zze = multicastSocket;
                multicastSocket.joinGroup(this.zzf);
                this.zzd = this.zze;
            } else {
                this.zzd = new DatagramSocket(inetSocketAddress);
            }
            this.zzd.setSoTimeout(8000);
            this.zzg = true;
            zzj(zzgoVar);
            return -1L;
        } catch (IOException e) {
            throw new zzhk(e, 2001);
        } catch (SecurityException e2) {
            throw new zzhk(e2, 2006);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Uri zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzd() {
        this.zzc = null;
        MulticastSocket multicastSocket = this.zze;
        if (multicastSocket != null) {
            try {
                InetAddress inetAddress = this.zzf;
                if (inetAddress == null) {
                    throw null;
                }
                multicastSocket.leaveGroup(inetAddress);
                this.zze = null;
            } catch (IOException unused) {
            }
        }
        DatagramSocket datagramSocket = this.zzd;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.zzd = null;
        }
        this.zzf = null;
        this.zzh = 0;
        if (this.zzg) {
            this.zzg = false;
            zzh();
        }
    }

    public zzhl(int i) {
        super(true);
        byte[] bArr = new byte[2000];
        this.zza = bArr;
        this.zzb = new DatagramPacket(bArr, 0, 2000);
    }
}
