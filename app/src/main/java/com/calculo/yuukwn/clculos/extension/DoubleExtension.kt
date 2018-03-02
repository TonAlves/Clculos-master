package com.example.logonpf.imc.extension

fun Double.format(digits: Int)=
        java.lang.String.format("%.${digits}f",this)

/**
 * Created by logonrm on 02/03/2018.
 */
