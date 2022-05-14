package dev.skrilltrax.baka.data.model.common

public enum class Genre(public val displayName: String) {
    Action("Action"),
    Adventure("Adventure"),
    Comedy("Comedy"),
    Drama("Drama"),
    Ecchi("Ecchi"),
    Fantasy("Fantasy"),
    Horror("Horror"),
    MahouShoujo("Mahou Shoujo"),
    Mecha("Mecha"),
    Music("Music"),
    Mystery("Mystery"),
    Psychological("Psychological"),
    Romance("Romance"),
    SciFi("Sci-Fi"),
    SliceOfLife("Slice of Life"),
    Sports("Sports"),
    Supernatural("Supernatural"),
    Thriller("Thriller"),
    ;

    public fun findGenreByName(displayName: String): Genre {
        return values().find { it.displayName == displayName }
            ?: throw EnumConstantNotPresentException(this::class.java, displayName)
    }
}