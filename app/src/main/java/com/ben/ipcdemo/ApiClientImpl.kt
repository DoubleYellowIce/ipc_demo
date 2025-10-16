package com.ben.ipcdemo

import android.content.Context
import com.ben.ipc.client.ApiClient

class ApiClientImpl(val activityContext: Context) : ApiClient() {
    override fun getModuleName(): String {
        return "demo"
    }

    override fun getAppId(): String {
        return "server"
    }

    override fun getContext(): Context {
        return activityContext
    }

}