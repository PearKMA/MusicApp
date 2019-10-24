package com.solarapp.musicapp.models

import android.net.Uri
import java.io.Serializable

abstract class ModelBase :Serializable{
    abstract fun getUri(): Uri
}
