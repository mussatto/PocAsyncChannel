package mussatto.pocAsyncChannel

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Component

@Component
class ChannelListenerBean(val channelComponent: ChannelComponent): InitializingBean {
    override fun afterPropertiesSet() {
        GlobalScope.launch{
            for(message in channelComponent.channelMessage){
                Thread.sleep(5000)
                println("The message is $message")
            }
        }
    }
}