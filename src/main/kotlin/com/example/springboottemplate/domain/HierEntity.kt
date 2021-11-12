package com.example.springboottemplate.domain

import java.io.Serializable

abstract class HierEntity<T: Serializable, C: Serializable>(

    id: T? = null,

    var parent: HierEntity<T, C>? = null,

    var children: MutableList<HierEntity<T, C>> = mutableListOf(),

    var contents: MutableList<IdEntity<C>> = mutableListOf(),

    var name: String? = null,

    var description: String? = null,

) : IdEntity<T>(id)