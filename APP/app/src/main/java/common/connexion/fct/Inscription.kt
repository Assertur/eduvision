package common.connexion.fct

fun inscription (nom : String, prenom : String, mdp : String, type : String) : Boolean {

    return "$nom $prenom" != "admin admin"
}