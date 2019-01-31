#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif

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
    const char *argv[] = {"./Encoder", pcm, amr, "-rate", "24000"};
    silk_encoder_main(argc, (char **) argv);
}

#ifdef __cplusplus
}
#endif
