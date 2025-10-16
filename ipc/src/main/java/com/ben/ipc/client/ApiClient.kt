package com.ben.ipc.client

import android.content.Context

abstract class ApiClient {

    abstract fun getModuleName(): String

    abstract fun getAppId(): String

    abstract fun getContext(): Context

    fun call(methodName: String, paras: String): String {
        return ApiManager.call(getAppId(), getModuleName(), methodName, paras, getContext())
    }
}