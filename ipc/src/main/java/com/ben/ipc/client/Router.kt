package com.ben.ipc.client

import android.content.Context
import android.net.Uri
import android.util.Log
import com.ben.ipc.ApiPublisher
import com.ben.ipc.IRemoteApi

object Router {

    val TAG = Router::class.simpleName

    fun route(
        packageId: String,
        moduleName: String,
        method: String,
        arg: String? = null,
        context: Context
    ): String {

        val builder = Uri.Builder()
        builder.scheme("content").authority(packageId + "." + ApiPublisher::class.simpleName)
        val uri = builder.build()
        //通过uri获取对应的ContentResolver
        val contentResolver = context.contentResolver
        //调用ContentResolver的call方法
        val contentProviderClient = contentResolver.acquireContentProviderClient(uri)
        if (contentProviderClient != null) {
            val bundle = contentProviderClient.call(method, arg, null)
            Log.d(TAG, "call method: $method, arg: $arg, bundle: $bundle")
            val binder = bundle?.getBinder("binder")
            val remoteApiImpl = IRemoteApi.Stub.asInterface(binder)
            val res = remoteApiImpl.onCall(moduleName, method, arg)
            contentProviderClient.release()
            return res
        } else {
            Log.d(TAG, "contentProviderClient is null, failed to route method: $method, arg: $arg")
        }
        return "-1"
    }
}