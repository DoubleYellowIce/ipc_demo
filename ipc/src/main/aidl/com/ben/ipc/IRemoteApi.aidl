// IRemoteApi.aidl
package com.ben.ipc;

// Declare any non-default types here with import statements

interface IRemoteApi {

    String onCall(String moduleName,String method,String param);

}