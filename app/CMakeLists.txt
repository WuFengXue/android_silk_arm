cmake_minimum_required(VERSION 3.6)
project(silk)

# silk
include_directories(src/main/jni/silk/interface)
include_directories(src/main/jni/silk/src)

aux_source_directory(src/main/jni/silk/src SILK_SRC)

add_library(silk SHARED ${SILK_SRC})
find_library(android-log log)
target_link_libraries(silk ${android-log})

add_executable(Decoder src/main/jni/silk/test/Decoder.c ${SILK_SRC})
add_executable(Encoder src/main/jni/silk/test/Encoder.c ${SILK_SRC})
add_executable(signalCompare src/main/jni/silk/test/signalCompare.c ${SILK_SRC})


# lame
include_directories(src/main/jni/lame/frontend)
include_directories(src/main/jni/lame/include)
include_directories(src/main/jni/lame/libmp3lame)
include_directories(src/main/jni/lame/mpglib)

aux_source_directory(src/main/jni/lame/frontend LAME_FRONTEND_SRC)
aux_source_directory(src/main/jni/lame/libmp3lame LAME_SRC)
aux_source_directory(src/main/jni/lame/mpglib LAME_MPGLIB_SRC)
add_library(mp3lame SHARED ${LAME_SRC} ${LAME_MPGLIB_SRC})
add_executable(lame ${LAME_FRONTEND_SRC} ${LAME_SRC} ${LAME_MPGLIB_SRC})

# audio codec
aux_source_directory(src/main/jni/silk SILK_CODEC_SRC)
add_library(codec SHARED src/main/jni/AudioCodec.c ${SILK_SRC} ${SILK_CODEC_SRC}
        ${LAME_SRC} ${LAME_MPGLIB_SRC})
find_library(android-log log)
target_link_libraries(codec ${android-log})