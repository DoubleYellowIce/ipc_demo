package com.ben.server

import android.util.Log
import com.ben.ipc.RemoteApiImpl
import com.ben.ipc.server.IpcServerListener

object ServerImplementation : IpcServerListener {

    val TAG = ServerImplementation::class.simpleName

    fun init() {
        Log.d(TAG, "ServerImplementation initialized")
        RemoteApiImpl.listener = this
    }

    override fun onCall(
        moduleName: String,
        method: String?,
        arg: String?
    ): String {
        Log.d(TAG, "onCall moduleName: $moduleName, method: $method, arg: $arg")
        return "Invokes method $method with arg $arg in module $moduleName"
    }

}