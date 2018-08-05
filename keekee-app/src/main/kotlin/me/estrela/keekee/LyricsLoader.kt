package me.estrela.keekee

import com.google.gson.Gson
import me.estrela.keekee.domain.Lyrics
import org.springframework.stereotype.Component

@Component
class LyricsLoader {

    fun getLyrics(): Lyrics {
        val fileContent = this::class.java.getResource(LYRICS_FILE).readText()
        return Gson().fromJson(fileContent, Lyrics::class.java)
    }

    companion object {
        private var LYRICS_FILE = "/lyrics/drake_in_my_feelings.json"
    }

}
