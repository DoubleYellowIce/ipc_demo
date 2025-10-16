package com.ben.ipc.server

interface IpcServerListener {
    fun onCall(
        moduleName: String,
        method: String?,
        arg: String? = null,
    ): String
}