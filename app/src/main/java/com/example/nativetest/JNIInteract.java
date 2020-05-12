package com.example.nativetest;

public class JNIInteract {

        String audiopassed=new String();
        // Used to load the 'native-lib' library on application startup.
        static {
            System.loadLibrary("native-lib");
        }



        /**
         * A native method that is implemented by the 'native-lib' native library,
         * which is packaged with this application.
         * @param name
         */
//        public native String stringFromNative();
        public native int passingDataToJni(String name);
        public native int passObjectToJNI(Audiofileproperties Obj);

        //public native Audiofileproperties getObjectFromJNI();

        //public native void callTheCallBackMethod();

        /*private void callBack(int data, String stringValue) {
            callBackInterface.callBackEvent(stringValue + String.valueOf(data));
        }*/
    }

