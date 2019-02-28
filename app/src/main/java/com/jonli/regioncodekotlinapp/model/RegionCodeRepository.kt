package com.jonli.regioncodekotlinapp.model

import android.app.Application
import android.databinding.ObservableArrayMap
import android.databinding.ObservableMap
import com.jonli.regioncodekotlinapp.R
import org.xmlpull.v1.XmlPullParser

class RegionCodeRepository(private val application: Application) {

    val items: ObservableMap<String, String> = ObservableArrayMap<String, String>()

    init {
        readXml()
    }

    companion object {
        private var INSTANCE: RegionCodeRepository? = null

        fun getInstance(application: Application): RegionCodeRepository {
            return if (INSTANCE == null) {
                RegionCodeRepository(application)
            } else {
                INSTANCE as RegionCodeRepository
            }
        }
    }

    private fun readXml() {
        val parser = application.resources.getXml(R.xml.data)

        while (parser.eventType != XmlPullParser.END_DOCUMENT) {
            when (parser.eventType) {
                XmlPullParser.START_TAG -> {
                    if (parser.name == "code") {
                        var code = parser.getAttributeValue(0)
                        val value = parser.nextText()
                        if (code.length == 1) code = String.format("0%s", code)
                        items[code] = value
                    }
                }
            }
            parser.next()
        }
    }

}