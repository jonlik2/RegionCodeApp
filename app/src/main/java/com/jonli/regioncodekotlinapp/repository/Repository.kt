package com.jonli.regioncodekotlinapp.repository

import android.app.Application
import com.jonli.regioncodekotlinapp.R
import org.xmlpull.v1.XmlPullParser

class Repository(private val application: Application) {

    private val _items: MutableMap<String, String> = mutableMapOf()
    val items: Map<String, String>
        get() = _items

    init {
        readXml()
    }

    companion object {
        private var INSTANCE: Repository? = null

        fun getInstance(application: Application): Repository {
            return if (INSTANCE == null) {
                Repository(application)
            } else {
                INSTANCE as Repository
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
                        _items[code] = value
                    }
                }
            }
            parser.next()
        }
    }

}