package com.reinhard.silk;

/**
 * audio decoder and encoder, support amr to mp3 and mp3 to amr
 *
 * @author Reinhard（李剑波）
 * @date 2019/1/31
 */
public class AudioCodec {
    static {
        System.loadLibrary("codec");
    }

    public static native void amrToMp3(String amrPath, String pcmPath, String mp3Path);

    public static native void mp3ToAmr(String mp3Path, String pcmPath, String amrPath);
}
