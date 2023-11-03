package com.example.camobileappchallenges.data.repository



import com.google.common.truth.Truth.assertThat
import com.example.camobileappchallenges.data.remote.GetListAccountsApi
import com.example.camobileappchallenges.data.remote.malformedBankResponse
import com.example.camobileappchallenges.data.remote.validBankResponse
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AccountRepositoryImpTest {

    private lateinit var repository: AccountRepositoryImp
    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var api: GetListAccountsApi


    @Before
    fun setUp() {
        mockWebServer = MockWebServer()

        okHttpClient = OkHttpClient.Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()

        api =  Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GetListAccountsApi::class.java)

        repository = AccountRepositoryImp(
            api = api
        )
    }

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }

    @Test
    fun `valid response, returns results`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().setResponseCode(200)
                .setBody(validBankResponse)
        )

        val result = repository.getAccounts()

        assertThat(result).isNotNull()
    }

    @Test
    fun `valid response, returns accounts not null`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().setResponseCode(200)
                .setBody(malformedBankResponse)
        )

        val result = repository.getAccounts()

        assertThat(result.first().accounts).isNotEmpty()
    }

    @Test
    fun `valid response, returns balance not null`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().setResponseCode(200)
                .setBody(malformedBankResponse)
        )

        val result = repository.getAccounts()

        assertThat(result.first().accounts.first().balance).isNotNull()
    }
}