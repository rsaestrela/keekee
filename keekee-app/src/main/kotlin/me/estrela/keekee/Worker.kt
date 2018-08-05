package me.estrela.keekee

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.concurrent.Executors

@Component
class Worker {

    @Autowired
    private lateinit var notificationService: NotificationService

    @Autowired
    private lateinit var lyricsLoader: LyricsLoader

    fun start() {
        executorService.submit {
            val sentences = lyricsLoader.getLyrics().sentences
            sentences.forEachIndexed { index, sentence ->
                val next = index + 1
                if (next < sentences.size) {
                    val diffInTime = sentences[index + 1].time - sentence.time
                    Thread.sleep(diffInTime)
                }
                notificationService.notify(Notification(sentence.content))
            }
        }
    }

    companion object {
        private val executorService = Executors.newSingleThreadExecutor()
    }

}
