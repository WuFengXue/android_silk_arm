#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif

#include "lame/LameCodec.h"
#include "silk/SilkCodec.h"

/*
 * Class:     com_reinhard_silk_AudioCodec
 * Method:    amrToMp3
 * Signature: (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_reinhard_silk_AudioCodec_amrToMp3
        (JNIEnv *env, jclass clazz, jstring amrPath, jstring pcmPath, jstring mp3Path) {
    const char *amr = (*env)->GetStringUTFChars(env, amrPath, JNI_FALSE);
    const char *pcm = (*env)->GetStringUTFChars(env, pcmPath, JNI_FALSE);
    const char *mp3 = (*env)->GetStringUTFChars(env, mp3Path, JNI_FALSE);
    int argc = 3;
    const char *argv[] = {"./Decoder", amr, pcm};
    silk_decoder_main(argc, (char **) argv);

    int argc2 = 14;
    const char *argv2[] = {"./lame", "-q", "5", "-b", "128", "-m", "m", "-r",
                           "-s", "24000", "--resample", "24000", pcm, mp3};
    lame_codec_main(argc2, (char **) argv2);
}

/*
 * Class:     com_reinhard_silk_AudioCodec
 * Method:    mp3ToAmr
 * Signature: (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_reinhard_silk_AudioCodec_mp3ToAmr
        (JNIEnv *env, jclass clazz, jstring mp3Path, jstring pcmPath, jstring amrPath) {
    const char *mp3 = (*env)->GetStringUTFChars(env, mp3Path, JNI_FALSE);
    const char *pcm = (*env)->GetStringUTFChars(env, pcmPath, JNI_FALSE);
    const char *amr = (*env)->GetStringUTFChars(env, amrPath, JNI_FALSE);
    int argc = 5;
    const char *argv2[] = {"./lame", "--decode", "-t", mp3, pcm};
    lame_codec_main(argc, (char **) argv2);

    int argc2 = 5;
    const char *argv[] = {"./Encoder", pcm, amr, "-rate", "24000"};
    silk_encoder_main(argc2, (char **) argv);
}

#ifdef __cplusplus
}
#endif
