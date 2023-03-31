
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.wezacare_developer_challenge.network_data.CharacterApi
import com.example.wezacare_developer_challenge.network_data.CharacterApiService
import com.example.wezacare_developer_challenge.network_data.Character_
import com.example.wezacare_developer_challenge.viewmodels.CharacterViewModel
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CharacterViewModelTest {



    private lateinit var viewModel: CharacterViewModel
    private val mockService = mockk<CharacterApiService>()

    // Set up a coroutine test scope
    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    @Before
    fun setUp() {
        viewModel = CharacterViewModel()
        CharacterApi.retrofitService = mockService
    }

    @After
    fun tearDown() {
        unmockkAll()
        testScope.cleanupTestCoroutines()
    }

    @Test
    fun `getCharacterPhotos should set status to success and result to non-empty list`() = testScope.runBlockingTest {
        // Given
        val character = Character_(id = "1", name = "Harry Potter", alternateNames = emptyList(), species = "human", gender = "male", house = "Gryffindor", dateOfBirth = null, yearOfBirth = null, wizard = true, ancestry = "pure-blood", eyeColour = "green", hairColour = "black", patronus = "stag", hogwartsStudent = true, hogwartsStaff = false, actor = "Daniel Radcliffe", alternateActors = emptyList(), alive = true, image = "https://i.imgur.com/2lCdx7C.jpg")
        val listResult = listOf(character)
        coEvery { mockService.getCharacters() } returns listResult

        // Create an observer to listen for changes in the view model's live data
        val statusObserver = Observer<String> {}
        val resultObserver = Observer<List<Character_>> {}

        // Observe the view model's live data
        viewModel.status.observeForever(statusObserver)
        viewModel.result.observeForever(resultObserver)

        // When
        viewModel.getCharacterPhotos()

        // Then
        assert(viewModel.status.value == "success")
        assert(viewModel.result.value == listResult)

        // Clean up
        viewModel.status.removeObserver(statusObserver)
        viewModel.result.removeObserver(resultObserver)
    }

    @Test
    fun `getCharacterPhotos should set status to failure when service throws an exception`() = testScope.runBlockingTest {
        // Given
        coEvery { mockService.getCharacters() } throws Exception("network error")

        // Create an observer to listen for changes in the view model's live data
        val statusObserver = Observer<String> {}
        val resultObserver = Observer<List<Character_>> {}

        // Observe the view model's live data
        viewModel.status.observeForever(statusObserver)
        viewModel.result.observeForever(resultObserver)

        // When
        viewModel.getCharacterPhotos()

        // Then
        assert(viewModel.status.value == "Failure: network error... check that you are connected and try again")
        assert(viewModel.result.value == null)

        // Clean up
        viewModel.status.removeObserver(statusObserver)
        viewModel.result.removeObserver(resultObserver)
    }}
