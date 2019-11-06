package com.averoes.daff.dailynote.model

/**
 * Created by daff on 10/03/19 at 21:15.
 */
class Daily{

    var date:String? = null
    var title: String? = null
    var note:String? = null
    var firebaseKey: String? = null

    constructor( date:String?,
                 title: String?,
                 note:String?,
                 firebaseKey: String?){
        this.date = date
        this.title = title
        this.note = note
        this.firebaseKey = firebaseKey
    }

    constructor()

    val myNote: Map<String, String?>
    get() = mapOf("date" to this.date,
        "title" to this.title,
        "note" to this.note)
}