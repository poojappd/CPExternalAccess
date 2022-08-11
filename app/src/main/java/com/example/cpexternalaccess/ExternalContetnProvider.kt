package com.example.cpexternalaccess

import android.net.Uri

object ExternalContetnProvider {
    const val AUTHORITY = "com.external.cpimplementation.MyContentProvider"
    //const val PROVIDER_NAME = "$AUTHORITY/MyContentProvider"
    val URI: Uri = Uri.parse("content://$AUTHORITY/SOMETABLE")

    const val ID = "_id"
    const val NAME = "NAME"
    const val MEANING = "MEANING"
}