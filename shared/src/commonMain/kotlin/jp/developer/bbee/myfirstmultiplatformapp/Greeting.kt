package jp.developer.bbee.myfirstmultiplatformapp

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import jp.developer.bbee.myfirstmultiplatformapp.data.RocketComponent
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class Greeting {
    private val platform: Platform = getPlatform()

//    fun greet(): String {
//        //return "Hello, ${platform.name}!"
//        val firstWord = if(Random.nextBoolean()) "Hi!" else "Hello!"
//
//        return "$firstWord [$num] Guess what this is! > ${platform.name.reversed()}!"
//    }

    @NativeCoroutines
    fun greet(): Flow<String> = flow {
        emit(if(Random.nextBoolean()) "Hi!" else "Hello!")
        delay(1.seconds)
        emit("Guess what this is! > ${platform.name.reversed()}")
        delay(1.seconds)
        emit(rocketComponent.launchPhase())
    }

    private val rocketComponent = RocketComponent()

}