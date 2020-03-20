#include <jni.h>
#include <string>
#include "fileref.h"
#include "tag.h"
#include "tpropertymap.h"


extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_nativetest_MainActivity_stringFromJNI(JNIEnv *env,jobject /* this */) {
    std::string hello = "Library Bound Successfully";
    TagLib::Tag *tag;
    TagLib::FileRef;
    return env->NewStringUTF(hello.c_str());
}
