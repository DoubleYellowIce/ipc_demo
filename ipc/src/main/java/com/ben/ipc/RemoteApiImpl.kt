package com.ben.ipc

import com.ben.ipc.server.IpcServerListener

// Implementation of the AIDL interface
object RemoteApiImpl : IRemoteApi.Stub() {

    var listener: IpcServerListener? = null

    override fun onCall(moduleName: String, method: String?, param: String?): String {
        return listener?.onCall(moduleName, method, param) ?: "No listener set"
    }

}