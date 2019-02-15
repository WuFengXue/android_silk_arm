package com.reinhard.silk;

/**
 * audio decoder and encoder, support amr to mp3 , pcm to amr and mp3 to amr
 *
 * @author Reinhard（李剑波）
 * @date 2019/1/31
 */
public class AudioCodec {
    static {
        System.loadLibrary("audiocodec");
    }

    /**
     * decode amr to mp3 (1. amr -> pcm  2. pcm -> mp3)
     *
     * @param amrPath amr file path
     * @param mp3Path mp3 file path
     * @param pcmPath pcm file path
     * @return 0 if success, otherwise -1
     */
    public static native int decode(String amrPath, String mp3Path, String pcmPath);

    /**
     * encode pcm to amr
     *
     * @param pcmPath pcm file path
     * @param amrPath amr file path
     * @return 0 if success, otherwise -1
     */
    public static native int encode(String pcmPath, String amrPath);

    /**
     * encode mp3 to amr (1. mp3 -> pcm  2. pcm -> amr)
     *
     * @param mp3Path mp3 file path
     * @param pcmPath pcm file path
     * @param amrPath amr file path
     * @return 0 if success, otherwise -1
     */
    public static native int encode2(String mp3Path, String pcmPath, String amrPath);
}
