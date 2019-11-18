#include "com_zhujohnle_androidreplay_ndk_Test.h"
#include <jni.h>

JNIEXPORT jstring JNICALL Java_com_zhujohnle_androidreplay_ndk_Test_sayHi
    (JNIEnv *env, jclass clazz){
     return (*env)->NewStringUTF(env,"from c");
}