#include <jni.h>
#include <stdio.h>
#include "HelloJni.h"

JNIEXPORT jstring JNICALL
Java_com_manish_hellojni_HelloJni_print(JNIEnv *env, jobject obj) {
	return (*env)->NewStringUTF(env, “Hello JNI!!\n”);
}
