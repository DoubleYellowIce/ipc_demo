package com.ben.ipc

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.os.IBinder
import android.util.Log

class ApiPublisher : ContentProvider() {

    private val remoteApi: IBinder = RemoteApiImpl

    companion object {
        val TAG = ApiPublisher::class.simpleName
    }


    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        p0: Uri,
        p1: Array<out String?>?,
        p2: String?,
        p3: Array<out String?>?,
        p4: String?
    ): Cursor? {
        return null
    }

    override fun getType(p0: Uri): String? {
        return ""
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        return null
    }

    override fun delete(
        p0: Uri,
        p1: String?,
        p2: Array<out String?>?
    ): Int {
        return -1
    }

    override fun update(
        p0: Uri,
        p1: ContentValues?,
        p2: String?,
        p3: Array<out String?>?
    ): Int {
        return -1
    }

    override fun call(method: String, arg: String?, extras: Bundle?): Bundle? {
        Log.d(TAG, "call method: $method, arg: $arg, extras: $extras")
        val res = Bundle()
        res.putBinder("binder", remoteApi)
        return res
    }

}