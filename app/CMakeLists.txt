cmake_minimum_required(VERSION 3.6)
project(silk)

include_directories(src/main/jni/silk/interface)
include_directories(src/main/jni/silk/src)

aux_source_directory(src/main/jni/silk/src JNI_SRC)

add_library(silk SHARED ${JNI_SRC})
find_library(android-log log)
target_link_libraries(silk ${android-log})

add_executable(Decoder src/main/jni/silk/test/Decoder.c ${JNI_SRC})
add_executable(Encoder src/main/jni/silk/test/Encoder.c ${JNI_SRC})
add_executable(signalCompare src/main/jni/silk/test/signalCompare.c ${JNI_SRC})