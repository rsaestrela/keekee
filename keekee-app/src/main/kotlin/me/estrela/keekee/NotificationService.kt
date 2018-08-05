package me.estrela.keekee

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class NotificationService {

    @Autowired
    private lateinit var messagingTemplate: SimpMessagingTemplate

    fun notify(notification: Notification) {
        messagingTemplate.convertAndSend("/queue/notify",notification)
    }

}
