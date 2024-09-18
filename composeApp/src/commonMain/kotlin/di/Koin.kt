package di

import data.repository.NewsRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import network.NewsApi
import network.NewsNetworkApi
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import presentation.screen.details.DetailsViewModel

fun networkModule() =
    module {
        single<HttpClient> { createHttpClient() }
        single<NewsApi> { NewsNetworkApi(get(), baseUrl = "https://inshortsapi.vercel.app") }
    }

fun dataModule() =
    module {
        single { NewsRepository(get()) }
    }

fun viewModelModule() =
    module {
        viewModelOf(::DetailsViewModel)
    }

fun createHttpClient() =
    HttpClient {
        expectSuccess = true
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                },
            )
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        install(HttpCache)
    }
