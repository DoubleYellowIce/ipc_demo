package com.ben.ipc.client

import android.content.Context

object ApiManager {

    private val appIdToPackageId = mutableMapOf<String, String>().apply {
        put("server", "com.ben.server")
    }


    fun call(
        appId: String,
        moduleName: String,
        method: String,
        params: String,
        context: Context
    ): String {
        val packageId = appIdToPackageId[appId]
            ?: throw IllegalArgumentException("No package ID found for app ID: $appId")
        return Router.route(packageId, moduleName, method, params, context)
    }
}