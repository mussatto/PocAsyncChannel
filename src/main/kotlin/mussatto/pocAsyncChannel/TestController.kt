package mussatto.pocAsyncChannel

import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(val channelComponent: ChannelComponent) {

    @GetMapping("/async")
    fun ShouldProcessAsync(@RequestParam message: String): String {

        runBlocking {
            channelComponent.channelMessage.send("Sending Message!")
            println("Message sent!")
        }

        return "Enqueued!"
    }
}