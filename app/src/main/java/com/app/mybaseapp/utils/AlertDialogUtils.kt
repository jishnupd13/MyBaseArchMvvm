package com.app.mybaseapp.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface


fun Context.showAlertDialog(
    title:String = EMPTY,
    message:String = EMPTY,
    positiveButtonText:String = EMPTY,
    negativeButtonText:String = EMPTY,
    positiveButtonAction:( dialogInterface: DialogInterface)->Unit = {},
    negativeButtonAction:( dialogInterface: DialogInterface)-> Unit = {}
){

    val builder = AlertDialog.Builder(this)
    builder.setTitle(title)
    builder.setMessage(message)

    builder.setPositiveButton(positiveButtonText){dialogInterface, which ->
       positiveButtonAction.invoke(dialogInterface)
    }

    builder.setNegativeButton(negativeButtonText){dialogInterface, which ->
        negativeButtonAction.invoke(dialogInterface)
    }
    val alertDialog: AlertDialog = builder.create()
    alertDialog.setCancelable(false)
    alertDialog.show()
}

fun androidx.fragment.app.Fragment.showAlertDialog(
    title:String = EMPTY,
    message:String = EMPTY,
    positiveButtonText:String = EMPTY,
    negativeButtonText:String = EMPTY,
    positiveButtonAction:( dialogInterface: DialogInterface)->Unit = {},
    negativeButtonAction:( dialogInterface: DialogInterface)-> Unit = {}
){

    val builder = AlertDialog.Builder(requireContext())
    builder.setTitle(title)
    builder.setMessage(message)

    builder.setPositiveButton(positiveButtonText){dialogInterface, which ->
        positiveButtonAction.invoke(dialogInterface)
    }

    builder.setNegativeButton(negativeButtonText){dialogInterface, which ->
        negativeButtonAction.invoke(dialogInterface)
    }
    val alertDialog: AlertDialog = builder.create()
    alertDialog.setCancelable(false)
    alertDialog.show()
}

fun Activity.showAlertDialog(
    title:String = EMPTY,
    message:String = EMPTY,
    positiveButtonText:String = EMPTY,
    negativeButtonText:String = EMPTY,
    positiveButtonAction:( dialogInterface: DialogInterface)->Unit = {},
    negativeButtonAction:( dialogInterface: DialogInterface)-> Unit = {}
){

    val builder = AlertDialog.Builder(this)
    builder.setTitle(title)
    builder.setMessage(message)

    builder.setPositiveButton(positiveButtonText){dialogInterface, which ->
        positiveButtonAction.invoke(dialogInterface)
    }

    builder.setNegativeButton(negativeButtonText){dialogInterface, which ->
        negativeButtonAction.invoke(dialogInterface)
    }
    val alertDialog: AlertDialog = builder.create()
    alertDialog.setCancelable(false)
    alertDialog.show()
}