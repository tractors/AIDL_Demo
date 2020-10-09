package com.will.aidl_demo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.will.aidl_demo.person.ILeoAidl
import com.will.aidl_demo.person.Person

class LeoAidlService : Service() {

    private lateinit var persons : MutableList<Person>

    override fun onCreate() {
        super.onCreate()
        persons = ArrayList()
    }

    override fun onBind(intent: Intent?): IBinder? {

        Log.e("LeoAidlService","success onBind")
        return iBinder
    }

    private val iBinder = object : ILeoAidl.Stub(){
        override fun addPerson(person: Person?) {
            person?.let { persons.add(it) }
        }

        override fun getPersonList(): MutableList<Person> {
            return persons
        }
    }
}