package common.connexion.fct

fun connexion (id : String, mdp : String) : Boolean {
    return id == "admin" && mdp == "admin"
}