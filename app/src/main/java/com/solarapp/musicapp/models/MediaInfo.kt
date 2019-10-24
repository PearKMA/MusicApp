package com.solarapp.musicapp.models

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class MediaInfo(val getFieldName: String)