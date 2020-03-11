package com.example.testretrofit.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

fun createDialogWithTitle(title: String, context: Context, listener: DialogInterface.OnClickListener) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
    builder.setTitle(title)
    builder.setCancelable(true)
    builder.setPositiveButton("확인", listener)
    builder.setNegativeButton("취소") { dialogInterface, _ ->
        dialogInterface.cancel()
    }
    builder.create().show()
}