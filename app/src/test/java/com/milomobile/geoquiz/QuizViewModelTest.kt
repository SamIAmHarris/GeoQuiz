package com.milomobile.geoquiz

import androidx.lifecycle.SavedStateHandle
import org.junit.Assert.*
import org.junit.Test

//given, when, then
class QuizViewModelTest {

    @Test
    fun `initial question should be australia text`() {
        val savedStateHandle = SavedStateHandle()
        val quizViewModel = QuizViewModel(savedStateHandle)
        assertEquals(R.string.question_australia, quizViewModel.currentQuestionText)
    }

    @Test
    fun `when user hits end of questions, should start back at initial question`() {
        //Setting up code to be on the final question and asserting it has correct question text
        val savedStateHandle = SavedStateHandle(mapOf(CURRENT_INDEX_KEY to 5))
        val quizViewModel = QuizViewModel(savedStateHandle)
        assertEquals(R.string.question_asia, quizViewModel.currentQuestionText)

        //do action
        quizViewModel.moveToNext()

        //assert correct state
        assertEquals(R.string.question_australia, quizViewModel.currentQuestionText)
    }
}