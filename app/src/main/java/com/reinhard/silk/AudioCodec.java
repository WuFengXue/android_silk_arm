package com.reinhard.silk;

/**
 * audio decoder and encoder, support amr to mp3 and mp3 to amr
 *
 * @author Reinhard（李剑波）
 * @date 2019/1/31
 */
public class AudioCodec {
    static {
        System.loadLibrary("audiocodec");
    }

    public static native int decode(String amrPath, String mp3Path, String pcmPath);

    public static native int encode(String pcmPath, String amrPath);

    public static native int encode2(String mp3Path, String pcmPath, String amrPath);
}
