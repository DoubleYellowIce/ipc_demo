package com.ben.ipc

import android.os.IBinder


class ApiMatcher {

    private val remoteApi: IBinder = RemoteApiImpl

    fun match(
        method: String,
        arg: String? = null,
        extras: Map<String, Any>? = null
    ): Pair<IBinder, String> {
        return Pair(remoteApi, "IRemoteApi")
    }
}