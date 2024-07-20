package com.android.movie.base.viewmodel

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ObservableDelegate<T>(private var value: T) : ReadWriteProperty<ObservableViewModel, T> {
    override fun getValue(thisRef: ObservableViewModel, property: KProperty<*>): T = value

    override fun setValue(thisRef: ObservableViewModel, property: KProperty<*>, value: T) {
        if (this.value != value) {
            this.value = value
            thisRef.notifyPropertyChanged(property.name)
        }
    }
}

fun <T> bindingProperty(value: T): ObservableDelegate<T> = ObservableDelegate(value)