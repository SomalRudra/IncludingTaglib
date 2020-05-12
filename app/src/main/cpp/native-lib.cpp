#include <jni.h>
#include <string>
#include <iomanip>
#include "tag.h"
#include "tpropertymap.h"
#include "fileref.h"

using namespace std;

const char *audiofile;
int sizeofaudiofile;
extern "C"
JNIEXPORT jint JNICALL
Java_com_example_nativetest_JNIInteract_passingDataToJni(JNIEnv *env, jobject thiz,
                                                         jstring audiopassed) {
    audiofile= env->GetStringUTFChars(audiopassed,NULL);
    sizeofaudiofile=env->GetStringLength(audiopassed);
    return 0;
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_example_nativetest_JNIInteract_passObjectToJNI(JNIEnv *env, jobject thiz, jobject Obj) {
    // Get jclass of the object
    jclass OBJClass = env->GetObjectClass(Obj);

    //Getting field id
    jfieldID TitleStringField = env->GetFieldID(OBJClass, "title",
                                                "Ljava/lang/String;");

    //TagLib::FileRef f(audiofile);

    //TagLib::Tag *tag = f.tag();
    //env->SetObjectField(Obj, TitleStringField, env->NewStringUTF(tag->title()));

    return 1;
}
//        cout << "title   - \"" << tag->title()   << "\"" << endl;
//        cout << "artist  - \"" << tag->artist()  << "\"" << endl;
//        cout << "album   - \"" << tag->album()   << "\"" << endl;
//        cout << "year    - \"" << tag->year()    << "\"" << endl;
//        cout << "comment - \"" << tag->comment() << "\"" << endl;
//        cout << "track   - \"" << tag->track()   << "\"" << endl;
//        cout << "genre   - \"" << tag->genre()   << "\"" << endl;
//
//        TagLib::PropertyMap tags = f.file()->properties();
//
//        unsigned int longest = 0;
//        for(TagLib::PropertyMap::ConstIterator i = tags.begin(); i != tags.end(); ++i) {
//            if (i->first.size() > longest) {
//                longest = i->first.size();
//            }
//        }
//
//        cout << "-- TAG (properties) --" << endl;
//        for(TagLib::PropertyMap::ConstIterator i = tags.begin(); i != tags.end(); ++i) {
//            for(TagLib::StringList::ConstIterator j = i->second.begin(); j != i->second.end(); ++j) {
//                cout << left << setw(longest) << i->first << " - " << '"' << *j << '"' << endl;
//            }
//        }
//
//    }
//
//    if(!f.isNull() && f.audioProperties()) {
//
//        TagLib::AudioProperties *properties = f.audioProperties();
//
//        int seconds = properties->length() % 60;
//        int minutes = (properties->length() - seconds) / 60;
//
//        cout << "-- AUDIO --" << endl;
//        cout << "bitrate     - " << properties->bitrate() << endl;
//        cout << "sample rate - " << properties->sampleRate() << endl;
//        cout << "channels    - " << properties->channels() << endl;
//        cout << "length      - " << minutes << ":" << setfill('0') << setw(2) << seconds << endl;
//    }

