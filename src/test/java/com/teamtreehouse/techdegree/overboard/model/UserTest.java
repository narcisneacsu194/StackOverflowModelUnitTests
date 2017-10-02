package com.teamtreehouse.techdegree.overboard.model;


import com.teamtreehouse.techdegree.overboard.exc.AnswerAcceptanceException;
import com.teamtreehouse.techdegree.overboard.exc.VotingException;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
/**
 * Created by narcis on 10/23/2016.
 */
public class UserTest {

    // assertThat

    Board board;
    User user1;
    User user2;
    Question question;
    Answer answer;

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setUp() throws Exception {
        board = new Board("Java");

        user1 = board.createUser("JohnDoe");
        user2 = board.createUser("JaneDoe");

        question = user1.askQuestion("What is Java ?");
        answer = user2.answerQuestion(question, "Java is a programming language.");
    }

    @Test
    public void verifyBoardTopic() throws Exception{
        assertEquals("Java", board.getTopic());
    }

    @Test
    public void verifyBoardTopicWithAssertThat() throws Exception{
        assertThat(board.getTopic(), equalTo("Java"));
    }

    @Test
    public void verifyBoardTopicWithAssertThat2() throws Exception{
        assertThat(board.getTopic(), is(equalTo("Java")));
    }

    @Test
    public void verifyBoardTopicWithAssertThat55() throws Exception{
        assertThat(board.getTopic(), is("Java"));
    }

    @Test
    public void verifyBoardTopicWithAssertThat3() throws Exception{
        assertThat(board.getTopic(), is(any(String.class)));
    }

    @Test
    public void verifyBoardTopicWithAssertThat4() throws Exception{
        assertThat(board.getTopic(), comparesEqualTo("Java"));
    }

    @Test
    public void verifyBoardTopicWithAssertThat5() throws Exception{
        assertThat(board.getTopic(), startsWith("Ja"));
    }

    @Test
    public void verifyBoardTopicWithAssertThat6()  throws Exception{
        assertThat(board.getTopic(), endsWith("va"));
    }

    @Test
    public void verifyBoardTopicWithAssertThat7() throws Exception{
        assertThat(board.getTopic(), containsString("av"));
    }

    @Test
    public void verifyBoardTopicWithAssertThat8() throws Exception{
        assertThat(board.getTopic(), equalToIgnoringCase("java"));
    }

    @Test
    public void verifyBoardTopicWithAssertThat9() throws Exception{
        assertThat(board.getTopic(), allOf(startsWith("J"), containsString("av"),
                endsWith("a")));
    }

    @Test
    public void verifyBoardTopicWithAssertThat10() throws Exception{
        List<Matcher<? super String>> matchers =
                Arrays.asList(startsWith("J"), containsString("av"),
                        endsWith("a"));

        assertThat(board.getTopic(), allOf(matchers));
    }

    @Test
    public void verifyBoardTopicWithAssertThat11() throws Exception{
        assertThat(board.getTopic(), both(startsWith("J"))
                .and(endsWith("a")));
    }

    @Test
    public void verifyBoardTopicClassIsTypeCompatibleWithString() throws Exception{
        assertThat(board.getTopic().getClass(), typeCompatibleWith(String.class));
    }

    @Test
    public void verifyCreateUserMethodReturnsNonNullObject() throws Exception{
        assertNotNull(board.createUser("User1"));
    }

    @Test
    public void verifyCreateUserMethodReturnsNonNullObject2() throws Exception{
        assertThat(board.createUser("User1"), is(not(equalTo(null))));
    }

    @Test
    public void verifyCreateUserMethodReturnsNonNullObject3() throws Exception{
        assertThat(board.createUser("User1"), notNullValue());
    }

    @Test
    public void verifyCreateUserMethodReturnsNonNullObject4() throws Exception{
        assertThat(board.createUser("User1"), notNullValue(User.class));
    }

    @Test
    public void verifyCreateUserMethodReturnsTypeCompatibleObject() throws Exception{
        assertThat(board.createUser("User1").getClass(), typeCompatibleWith(User.class));
    }

    @Test
    public void verifyCreateUserMethodAddsUserToBoardUserList() throws Exception{
        board.createUser("User1");
        assertEquals("User1", board.getUsers().get(2).getName());
    }

    @Test
    public void verifyCreateUserMethodAddsUserToBoardUserListUsingAssertThat() throws Exception{
        board.createUser("User1");
        assertThat(board.getUsers().get(2).getName(), is(equalTo("User1")));
    }

    @Test
    public void verifyCreateUserMethodAddsUserToBoardUserListUsingAssertThat2() throws Exception{
        board.createUser("User1");
        assertThat(board.getUsers().get(2).getName(), is(any(String.class)));
    }

    @Test
    public void verifyCreateUserMethodAddsUserToBoardUserListUsingAssertThat3() throws Exception{
        board.createUser("User1");
        assertThat(board.getUsers().get(2).getName(), comparesEqualTo("User1"));
    }

    @Test
    public void verifyCreateUserMethodAddsUserToBoardUserListUsingAssertThat4() throws Exception{
        board.createUser("User1");
        assertThat(board.getUsers().get(2).getName(), startsWith("User"));
    }

    @Test
    public void verifyCreateUserMethodAddsUserToBoardUserListUsingAssertThat5() throws Exception{
        board.createUser("User1");
        assertThat(board.getUsers().get(2).getName(), endsWith("1"));
    }

    @Test
    public void verifyCreateUserMethodAddsUserToBoardUserListUsingAssertThat6() throws Exception{
        board.createUser("User1");

        assertThat(board.getUsers().get(2).getName(), containsString("ser"));
    }

    @Test
    public void verifyCreateUserMethodAddsUserToBoardUserListUsingAssertThat7() throws Exception{
        board.createUser("User1");

        assertThat(board.getUsers().get(2).getName(), equalToIgnoringCase("user1"));
    }

    @Test
    public void verifyCreateUserMethodAddsUserToBoardUserListUsingAssertThat8() throws Exception{
        board.createUser("User1");

        assertThat(board.getUsers().get(2).getName(), allOf(startsWith("U"),
                containsString("ser"), endsWith("1")));
    }

    @Test
    public void verifyCreateUserMethodAddsUserToBoardUserListUsingAssertThat9() throws Exception{
        board.createUser("User1");

        List<Matcher<? super String>> matchers =
                Arrays.asList(startsWith("U"), containsString("ser"),
                        endsWith("1"));

        assertThat(board.getUsers().get(2).getName(), allOf(matchers));
    }

    @Test
    public void verifyCreateUserMethodAddsUserToBoardUserListUsingAssertThat10() throws Exception{
        board.createUser("User1");

        assertThat(board.getUsers().get(2).getName(), both(startsWith("U"))
                .and(endsWith("1")));
    }

    @Test
    public void verifyQuestionPostText() throws Exception{
        assertEquals("What is Java ?", question.getText());
    }

    @Test
    public void verifyQuestionPostTextUsingAssertThat() throws Exception{
        assertThat(question.getText(), is(equalTo("What is Java ?")));
    }

    @Test
    public void verifyQuestionPostTextUsingAssertThat2() throws Exception{
        assertThat(question.getText(), is(any(String.class)));
    }

    @Test
    public void verifyQuestionPostTextUsingAssertThat3() throws Exception{
        assertThat(question.getText(), comparesEqualTo("What is Java ?"));
    }

    @Test
    public void verifyQuestionPostTextUsingAssertThat4() throws Exception{
        assertThat(question.getText(), startsWith("What"));
    }

    @Test
    public void verifyQuestionPostTextUsingAssertThat5() throws Exception{
        assertThat(question.getText(), endsWith("?"));
    }

    @Test
    public void verifyQuestionPostTextUsingAssertThat6() throws Exception{
        assertThat(question.getText(), containsString(" is "));
    }

    @Test
    public void verifyQuestionPostTextUsingAssertThat7() throws Exception{
        assertThat(question.getText(), equalToIgnoringCase("what is java ?"));
    }

    @Test
    public void verifyQuestionPostTextUsingAssertThat8() throws Exception{
        assertThat(question.getText(), allOf(startsWith("What"),
                containsString(" is "), endsWith("Java ?")));
    }

    @Test
    public void verifyQuestionPostTextUsingAssertThat9() throws Exception{
        List<Matcher<? super String>> matchers =
                Arrays.asList(startsWith("What"), containsString(" is "),
                        endsWith("Java ?"));

        assertThat(question.getText(), allOf(matchers));
    }

    @Test
    public void verifyQuestionPostTextUsingAssertThat10() throws Exception{
        assertThat(question.getText(), both(startsWith("What"))
                .and(endsWith("Java ?")));
    }

    @Test
    public void verifyQuestionPostTextObjectIsTypeCompatible() throws Exception{
        assertThat(question.getText().getClass(), typeCompatibleWith(String.class));
    }

    @Test
    public void verifyAnswerPostText() throws Exception{
        assertEquals("Java is a programming language.", answer.getText());
    }

    @Test
    public void verifyAnswerPostTextUsingAssertThat() throws Exception{
        assertThat(answer.getText(), is(equalTo("Java is a programming language.")));
    }

    @Test
    public void verifyAnswerPostTextUsingAssertThat2() throws Exception{
        assertThat(answer.getText(), is(any(String.class)));
    }

    @Test
    public void verifyAnswerPostTextUsingAssertThat3() throws Exception{
        assertThat(answer.getText(), comparesEqualTo("Java is a programming language."));
    }

    @Test
    public void verifyAnswerPostTextUsingAssertThat4() throws Exception{
        assertThat(answer.getText(), startsWith("Java"));
    }

    @Test
    public void verifyAnswerPostTextUsingAssertThat5() throws Exception{
        assertThat(answer.getText(), endsWith("language."));
    }

    @Test
    public void verifyAnswerPostTextUsingAssertThat6() throws Exception{
        assertThat(answer.getText(), containsString(" is a "));
    }

    @Test
    public void verifyAnswerPostTextUsingAssertThat7() throws Exception{
        assertThat(answer.getText(), equalToIgnoringCase("java is a programming language."));
    }

    @Test
    public void verifyAnswerPostTextUsingAssertThat8() throws Exception{
        assertThat(answer.getText(), allOf(startsWith("Java"),
                containsString(" is a "),
                endsWith("programming language.")));
    }

    @Test
    public void verifyAnswerPostTextUsingAssertThat9() throws Exception{
        List<Matcher<? super String>> matchers =
                Arrays.asList(startsWith("Java"), containsString(" is a "),
                        endsWith("programming language."));

        assertThat(answer.getText(), allOf(matchers));
    }

    @Test
    public void verifyAnswerPostTextUsingAssertThat10() throws Exception{
        assertThat(answer.getText(), both(startsWith("Java"))
            .and(endsWith("programming language.")));
    }

    @Test
    public void verifyAnswerPostTextObjectIsTypeCompatible() throws Exception{
        assertThat(answer.getText().getClass(), typeCompatibleWith(String.class));
    }

    @Test
    public void verifyBoardQuestionListNotNull() throws Exception{
        assertNotNull(board.getQuestions());
    }

    @Test
    public void verifyBoardQuestionListNotNull2() throws Exception{
        assertThat(board.getQuestions(), is(not(equalTo(null))));
    }

    @Test
    public void verifyBoardQuestionListNotNull3() throws Exception{
        assertThat(board.getQuestions(), notNullValue());
    }

    @Test
    public void verifyBoardQuestionListNotNull4() throws Exception{
        assertThat(board.getQuestions(), notNullValue(List.class));
    }

    @Test
    public void verifyBoardAnswerListNotNull() throws Exception{
        assertNotNull(board.getAnswers());
    }

    @Test
    public void verifyBoardAnswerListNotNull2() throws Exception{
        assertThat(board.getAnswers(), is(not(equalTo(null))));
    }

    @Test
    public void verifyBoardAnswerListNotNull3() throws Exception{
        assertThat(board.getAnswers(), notNullValue());
    }

    @Test
    public void verifyBoardAnswerListNotNull4() throws Exception{
        assertThat(board.getAnswers(), notNullValue(List.class));
    }

    @Test
    public void verifyBoardAnswerListClassIsTypeCompatible() throws Exception{
        assertThat(board.getAnswers().getClass(), typeCompatibleWith(List.class));
    }

    @Test
    public void verifyBoardUserListNotNull() throws Exception{
        assertNotNull(board.getUsers());
    }

    @Test
    public void verifyBoardUserListNotNull2() throws Exception{
        assertThat(board.getUsers(), is(not(equalTo(null))));
    }

    @Test
    public void verifyBoardUserListNotNull3() throws Exception{
        assertThat(board.getUsers(), notNullValue());
    }

    @Test
    public void verifyBoardUserListNotNull4() throws Exception{
        assertThat(board.getUsers(), notNullValue(List.class));
    }

    @Test
    public void verifyBoardUserListObjectIsTypeCompatible() throws Exception{
        assertThat(board.getUsers().getClass(), typeCompatibleWith(List.class));
    }

    @Test
    public void verifyBoardQuestionListSize() throws Exception{
        assertEquals(1, board.getQuestions().size());
    }

    @Test
    public void verifyBoardQuestionListSizeUsingAssertThat() throws Exception{
        assertThat(board.getQuestions().size(), is(equalTo(1)));
    }

    @Test
    public void verifyBoardQuestionListSizeUsingAssertThat2() throws Exception{
        assertThat(board.getQuestions().size(), is(any(Integer.class)));
    }

    @Test
    public void verifyBoardAnswerListSize() throws Exception{
        assertEquals(1, board.getAnswers().size());
    }

    @Test
    public void verifyBoardAnswerListSizeUsingAssertThat() throws Exception{
        assertThat(board.getAnswers().size(), is(equalTo(1)));
    }

    @Test
    public void verifyBoardAnswerListSizeUsingAssertThat2() throws Exception{
        assertThat(board.getAnswers().size(), is(any(Integer.class)));
    }

    @Test
    public void verifyBoardUserListSize() throws Exception{
        assertEquals(2, board.getUsers().size());
    }

    @Test
    public void verifyBoardUserListSizeUsingAssertThat() throws Exception{
        assertThat(board.getUsers().size(), is(equalTo(2)));
    }

    @Test
    public void verifyBoardUserListSizeUsingAssertThat2() throws Exception{
        assertThat(board.getUsers().size(), is(any(Integer.class)));
    }

    @Test
    public void verifyNewBoardQuestionListSize() throws Exception{
        board.addQuestion(new Question(user1, "What is Java used for ?"));
        assertEquals(2, board.getQuestions().size());
    }

    @Test
    public void verifyNewBoardQuestionListSizeUsingAssertThat() throws Exception{
        board.addQuestion(new Question(user1, "What is Java used for ?"));

        assertThat(board.getQuestions().size(), is(equalTo(2)));
    }

    @Test
    public void verifyNewBoardQuestionListSizeUsingAssertThat2() throws Exception{
        board.addQuestion(new Question(user1, "What is Java used for ?"));

        assertThat(board.getQuestions().size(), is(any(Integer.class)));
    }

    @Test
    public void verifyNewBoardAnswerListSize() throws Exception{
        board.addAnswer(new Answer(question, user2, "Java is used for creating apps."));

        assertEquals(2, board.getAnswers().size());
    }

    @Test
    public void verifyNewBoardAnswerListSizeUsingAssertThat() throws Exception{
        board.addAnswer(new Answer(question, user2, "Java is used for creating apps."));

        assertThat(board.getAnswers().size(), is(equalTo(2)));
    }

    @Test
    public void verifyNewBoardAnswerListSizeUsingAssertThat2() throws Exception{
        board.addAnswer(new Answer(question, user2, "Java is used for creating apps."));

        assertThat(board.getAnswers().size(), is(any(Integer.class)));
    }

    @Test
    public void verifyBoardNotNull() throws Exception{
        assertNotNull(board);
    }

    @Test
    public void verifyBoardNotNull2() throws Exception{
        assertThat(board, is(not(equalTo(null))));
    }

    @Test
    public void verifyBoardNotNull3() throws Exception{
        assertThat(board, notNullValue());
    }

    @Test
    public void verifyBoardNotNull4() throws Exception{
        assertThat(board, notNullValue(Board.class));
    }

    @Test
    public void verifyBoardObjectIsTypeCompatible() throws Exception{
        assertThat(board.getClass(), typeCompatibleWith(Board.class));
    }

    @Test
    public void verifyQuestionerNotNull() throws Exception{
        assertNotNull(user1);
    }

    @Test
    public void verifyQuestionerNotNull2() throws Exception{
        assertThat(user1, is(not(equalTo(null))));
    }

    @Test
    public void verifyQuestionerNotNull3() throws Exception{
        assertThat(user1, notNullValue());
    }

    @Test
    public void verifyQuestionerNotNull4() throws Exception{
        assertThat(user1, notNullValue(User.class));
    }

    @Test
    public void verifyQuestionerObjectIsTypeCompatible() throws Exception{
        assertThat(user1.getClass(), typeCompatibleWith(User.class));
    }

    @Test
    public void verifyAnswererNotNull() throws Exception{
        assertNotNull(user2);
    }

    @Test
    public void verifyAnswererNotNull2() throws Exception{
        assertThat(user2, is(not(equalTo(null))));
    }

    @Test
    public void verifyAnswererNotNull3() throws Exception{
        assertThat(user2, notNullValue());
    }

    @Test
    public void verifyAnswererNotNull4() throws Exception{
        assertThat(user2, notNullValue(User.class));
    }

    @Test
    public void verifyAnswererObjectIsTypeCompatible() throws Exception{
        assertThat(user2.getClass(), typeCompatibleWith(User.class));
    }

    @Test
    public void verifyQuestionNotNull() throws Exception{
        assertNotNull(question);
    }

    @Test
    public void verifyQuestionsNotNull2() throws Exception{
        assertThat(question, is(not(equalTo(null))));
    }

    @Test
    public void verifyQuestionsNotNull3() throws Exception{
        assertThat(question, notNullValue());
    }

    @Test
    public void verifyQuestionsNotNull4() throws Exception{
        assertThat(question, notNullValue(Question.class));
    }

    @Test
    public void verifyQuestionObjectIsTypeCompatible() throws Exception{
        assertThat(question.getClass(), typeCompatibleWith(Question.class));
    }

    @Test
    public void verifyAnswerNotNull() throws Exception{
        assertNotNull(answer);
    }

    @Test
    public void verifyAnswerNotNull2() throws Exception{
        assertThat(answer, is(not(equalTo(null))));
    }

    @Test
    public void verifyAnswerNotNull3()  throws Exception{
        assertThat(answer, notNullValue());
    }

    @Test
    public void verifyAnswerNotNull4() throws Exception{
        assertThat(answer, notNullValue(Answer.class));
    }

    @Test
    public void verifyAnswerObjectIsTypeCompatible() throws Exception{
        assertThat(answer.getClass(), typeCompatibleWith(Answer.class));
    }

    @Test
    public void userReputationIncreasesByFiveIfQuestionUpvoted() throws Exception {
        user2.upVote(question);

        assertEquals(5, user1.getReputation());
    }

    @Test
    public void userReputationIncreasesByFiveIfQuestionUpvotedUsingAssertThat() throws Exception{
        user2.upVote(question);

        assertThat(user1.getReputation(), is(equalTo(5)));
    }

    @Test
    public void userReputationIncreasesByFiveIfQuestionUpvotedUsingAssertThat2() throws Exception{
        user2.upVote(question);

        assertThat(user1.getReputation(), is(any(Integer.class)));
    }

    @Test
    public void userReputationIsDecrementedIfQuestionDownvoted() throws Exception{
        user2.downVote(question);

        assertEquals(-1, user1.getReputation());
    }

    @Test
    public void userReputationDecrementedIfQuestionDownvotedUsingAssertThat() throws Exception{
        user2.downVote(question);

        assertThat(user1.getReputation(), is(equalTo(-1)));
    }

    @Test
    public void userReputationDecrementedIfQuestionDownvotedUsingAssertThat2() throws Exception{
        user2.downVote(question);

        assertThat(user1.getReputation(), is(any(Integer.class)));
    }

    @Test
    public void userReputationIncreasesByTenIfAnswerUpvoted() throws Exception{
        user1.upVote(answer);

        assertEquals(10, user2.getReputation());
    }

    @Test
    public void userReputationIncreasesByTenIfAnswerUpvotedUsingAssertThat() throws Exception{
        user1.upVote(answer);

        assertThat(user2.getReputation(), is(equalTo(10)));
    }

    @Test
    public void userReputationIncreasesByTenIfAnswerUpvotedUsingAssertThat2() throws Exception{
        user1.upVote(answer);

        assertThat(user2.getReputation(), is(any(Integer.class)));
    }

    @Test
    public void userReputationIsDecrementedIfAnswerDownvoted() throws Exception {
        user1.downVote(answer);

        assertEquals(-1, user2.getReputation());
    }

    @Test
    public void userReputationIsDecrementedIfAnswerDownvotedUsingAssertThat() throws Exception{
        user1.downVote(answer);

        assertThat(user2.getReputation(), is(equalTo(-1)));
    }

    @Test
    public void userReputationIsDecrementedIfAnswerDownvotedUsingAssertThat2() throws Exception{
        user1.downVote(answer);

        assertThat(user2.getReputation(), is(any(Integer.class)));
    }

    @Test
    public void userReputationIncreasesByFifteenIfAnswerAccepted() throws Exception{
        user1.acceptAnswer(answer);

        assertEquals(15, user2.getReputation());
    }

    @Test
    public void userReputationIncreasesByFifteenIfAnswerAcceptedUsingAssertThat() throws Exception{
        user1.acceptAnswer(answer);

        assertThat(user2.getReputation(), is(equalTo(15)));
    }

    @Test
    public void userReputationIncreasesByFifteenIfAnswerAcceptedUsingAssertThat2() throws Exception{
        user1.acceptAnswer(answer);
        assertThat(user2.getReputation(), is(any(Integer.class)));
    }

    @Test
    public void verifyUsermame() throws Exception{
        assertEquals("JohnDoe", user1.getName());
    }

    @Test
    public void verifyUsernameUsingAssertThat() throws Exception{
        assertThat(user1.getName(), is(equalTo("JohnDoe")));
    }

    @Test
    public void verifyUsernameUsingAssertThat2() throws Exception{
        assertThat(user1.getName(), is(any(String.class)));
    }

    @Test
    public void verifyUsernameUsingAssertThat3() throws Exception{
        assertThat(user1.getName(), comparesEqualTo("JohnDoe"));
    }

    @Test
    public void verifyUsernameUsingAssertThat4() throws Exception{
        assertThat(user1.getName(), startsWith("John"));
    }

    @Test
    public void verifyUsernameUsingAssertThat5() throws Exception{
        assertThat(user1.getName(), endsWith("Doe"));
    }

    @Test
    public void verifyUsernameUsingAssertThat6() throws Exception{
        assertThat(user1.getName(), containsString("ohn"));
    }

    @Test
    public void verifyUsernameUsingAssertThat7() throws Exception{
        assertThat(user1.getName(), equalToIgnoringCase("johndoe"));
    }

    @Test
    public void verifyUsernameUsingAssertThat8() throws Exception{
        assertThat(user1.getName(), allOf(startsWith("Jo"),
                containsString("hn"),
                endsWith("Doe")));
    }

    @Test
    public void verifyUsernameUsingAssertThat9() throws Exception{
        List<Matcher<? super String>> matchers =
                Arrays.asList(startsWith("Jo"),
                        containsString("hn"),
                        endsWith("Doe"));

        assertThat(user1.getName(), allOf(matchers));
    }

    @Test
    public void verifyUsernameUsingAssertThat10() throws Exception{
        assertThat(user1.getName(), both(startsWith("Jo"))
            .and(endsWith("Doe")));
    }

    @Test
    public void verifyUsernameIsNotNull() throws Exception{
        assertNotNull(user1.getName());
    }

    @Test
    public void verifyUsernameIsNotNull2() throws Exception{
        assertThat(user1.getName(), is(not(equalTo(null))));
    }

    @Test
    public void verifyUsernameIsNotNull3() throws Exception{
        assertThat(user1.getName(), notNullValue());
    }

    @Test
    public void verifyUsernameIsNotNull4() throws Exception{
        assertThat(user1.getName(), notNullValue(String.class));
    }

    @Test
    public void verifyUsernameObjectIsTypeCompatible() throws Exception{
        assertThat(user1.getName().getClass(), typeCompatibleWith(String.class));
    }

    @Test
    public void verifyGetQuestionsMethodReturnsAListWithOneElementForQuestioner() throws Exception{
        assertEquals(1, user1.getQuestions().size());
    }

    @Test
    public void verifyGetQuestionsMethodReturnsAListWithOneElementForQuestionerUsingAssertThat() throws Exception{
        assertThat(user1.getQuestions().size(), is(equalTo(1)));
    }

    @Test
    public void verifyGetQuestionsMethodReturnsAListWithOneElementForQuestionerUsingAssertThat2() throws Exception{
        assertThat(user1.getQuestions().size(), is(any(Integer.class)));
    }

    @Test
    public void verifyGetAnswersMethodReturnsAnEmptyListForQuestioner() throws Exception{
        assertEquals(0, user1.getAnswers().size());
    }

    @Test
    public void verifyGetAnswersMethodReturnsAnEmptyListForQuestionerUsingAsserThat() throws Exception{
        assertThat(user1.getAnswers().size(), is(equalTo(0)));
    }

    @Test
    public void verifyGetAnswerMethodReturnsAnEmptyListForQuestionerUsingAssertThat2() throws Exception{
        assertThat(user1.getAnswers().size(), is(any(Integer.class)));
    }

    @Test
    public void verifyGetQuestionsMethodReturnsAnEmptyListForTheAnswerer() throws Exception{
        assertEquals(0, user2.getQuestions().size());
    }

    @Test
    public void verifyGetQuestionsMethodReturnsAnEmptyListForTheAnswererUsingAssertThat() throws Exception{
        assertThat(user2.getQuestions().size(), is(equalTo(0)));
    }

    @Test
    public void verifyGetQuestionsMethodReturnsAnEmptyListForTheAnswererUsingAssertThat2() throws Exception{
        assertThat(user2.getQuestions().size(), is(any(Integer.class)));
    }

    @Test
    public void verifyGetAnswersMethodReturnsAListWithOneElementForAnswerer() throws Exception{
        assertEquals(1, user2.getAnswers().size());
    }

    @Test
    public void verifyGetAnswersMethodReturnsAListWithOneElementForAnswererUsingAssertThat() throws Exception{
        assertThat(user2.getAnswers().size(), is(equalTo(1)));
    }

    @Test
    public void verifyGetAnswersMethodReturnsAListWithOneElementForAnswererUsingAssertThat2() throws Exception{
        assertThat(user2.getAnswers().size(), is(any(Integer.class)));
    }

    @Test
    public void verifyGetQuestionsListIsNotNullForQuestioner() throws Exception{
        assertNotNull(user1.getQuestions());
    }

    @Test
    public void verifyGetQuestionsListIsNotNullForQuestioner2() throws Exception{
        assertThat(user1.getQuestions(), is(not(equalTo(null))));
    }

    @Test
    public void verifyGetQuestionsListIsNotNullForQuestioner3() throws Exception{
        assertThat(user1.getQuestions(), notNullValue());
    }

    @Test
    public void verifyGetQuestionsListIsNotNullForQuestioner4() throws Exception{
        assertThat(user1.getQuestions(), notNullValue(List.class));
    }

    @Test
    public void verifyGetQuestionsListObjectForQuestionerIsTypeCompatible() throws Exception{
        assertThat(user1.getQuestions().getClass(), typeCompatibleWith(List.class));
    }

    @Test
    public void verifyGetAnswersListIsNotNullForQuestioner() throws Exception{
        assertNotNull(user1.getAnswers());
    }

    @Test
    public void verifyGetAnswersListIsNotNullForQuestioner2() throws Exception{
        assertThat(user1.getAnswers(), is(not(equalTo(null))));
    }

    @Test
    public void verifyGetAnswersListIsNotNullForQuestioner3() throws Exception{
        assertThat(user1.getAnswers(), notNullValue());
    }

    @Test
    public void verifyGetAnswersListIsNotNullForQuestioner4() throws Exception{
        assertThat(user1.getAnswers(), notNullValue(List.class));
    }

    @Test
    public void verifyGetAnswersListObjectForQuestionerIsTypeCompatible() throws Exception{
        assertThat(user1.getAnswers().getClass(), typeCompatibleWith(List.class));
    }

    @Test
    public void verifyGetQuestionsListIsNotNullForAnswerer() throws Exception{
        assertNotNull(user2.getQuestions());
    }

    @Test
    public void verifyGetQuestionsListIsNotNullForAnswerer2() throws Exception{
        assertThat(user2.getQuestions(), is(not(equalTo(null))));
    }

    @Test
    public void verifyGetQuestionsListIsNotNullForAnswerer3() throws Exception{
        assertThat(user2.getQuestions(), notNullValue());
    }

    @Test
    public void verifyGetQuestionsListIsNotNullForAnswerer4() throws Exception{
        assertThat(user2.getQuestions(), notNullValue(List.class));
    }

    @Test
    public void verifyGetQuestionsListObjectForAnswererIsTypeCompatible() throws Exception{
        assertThat(user2.getQuestions().getClass(), typeCompatibleWith(List.class));
    }

    @Test
    public void verifyGetAnswersListIsNotNullForAnswerer() throws Exception{
        assertNotNull(user2.getAnswers());
    }

    @Test
    public void verifyGetAnswersListIsNotNullForAnswerer2() throws Exception{
        assertThat(user2.getAnswers(), is(not(equalTo(null))));
    }

    @Test
    public void verifyGetAnswersListIsNotNullForAnswerer3() throws Exception{
        assertThat(user2.getAnswers(), notNullValue());
    }

    @Test
    public void verifyGetAnswersListIsNotNullForAnswerer4() throws Exception{
        assertThat(user2.getAnswers(), notNullValue(List.class));
    }

    @Test
    public void verifyGetAnswersListObjectForAnswererIsTypeCompatible() throws Exception{
        assertThat(user2.getAnswers().getClass(), typeCompatibleWith(List.class));
    }

    @Test
    public void verifyAuthorOfPostedQuestion() throws Exception{
        assertEquals("JohnDoe", user1.getQuestions().get(0).getAuthor().getName());
    }

    @Test
    public void verifyAuthorOfPostedQuestionUsingAssert() throws Exception{
        assertThat(user1.getQuestions().get(0).getAuthor().getName(), is(equalTo("JohnDoe")));
    }

    @Test
    public void verifyAuthorOfPostedQuestionUsingAssert2() throws Exception{
        assertThat(user1.getQuestions().get(0).getAuthor().getName(), is(any(String.class)));
    }

    @Test
    public void verifyAuthorOfPostedQuestionUsingAssert3() throws Exception{
        assertThat(user1.getQuestions().get(0).getAuthor().getName(), comparesEqualTo("JohnDoe"));
    }

    @Test
    public void verifyAuthorOfPostedQuestionUsingAssert4() throws Exception{
        assertThat(user1.getQuestions().get(0).getAuthor().getName(), startsWith("John"));
    }

    @Test
    public void verifyAuthorOfPostedQuestionUsingAssert5() throws Exception{
        assertThat(user1.getQuestions().get(0).getAuthor().getName(), endsWith("Doe"));
    }

    @Test
    public void verifyAuthorOfPostedQuestionUsingAssert6() throws Exception{
        assertThat(user1.getQuestions().get(0).getAuthor().getName(), containsString("ohn"));
    }

    @Test
    public void verifyAuthorOfPostedQuestionUsingAssert7() throws Exception{
        assertThat(user1.getQuestions().get(0).getAuthor().getName(),
                allOf(startsWith("Jo"), containsString("hn"),
                        endsWith("Doe")));
    }

    @Test
    public void verifyAuthorOfPostedQuestionUsingAssert8() throws Exception{
        List<Matcher<? super String>> matchers =
                Arrays.asList(startsWith("Jo"), containsString("hn"),
                        endsWith("Doe"));

        assertThat(user1.getQuestions().get(0).getAuthor().getName(),
                allOf(matchers));
    }

    @Test
    public void verifyAuthorOfPostedQuestionUsingAssert9() throws Exception{
        assertThat(user1.getQuestions().get(0).getAuthor().getName(),
                both(startsWith("Jo")).and(endsWith("Doe")));
    }

    @Test
    public void verifyAuthorObjectOfPostedQuestionIsTypeCompatible() throws Exception{
        assertThat(user1.getQuestions().get(0).getAuthor().getName().getClass(),
                typeCompatibleWith(String.class));
    }

    @Test
    public void verifyAuthorOfPostedAnswer() throws Exception{
        assertEquals("JaneDoe", user2.getAnswers().get(0).getAuthor().getName());
    }

    @Test
    public void verifyAuthorOfPostedAnswerUsingAssertThat() throws Exception{
        assertThat(user2.getAnswers().get(0).getAuthor().getName(), is(equalTo("JaneDoe")));
    }

    @Test
    public void verifyAuthorOfPostedAnswerUsingAssertThat2() throws Exception{
        assertThat(user2.getAnswers().get(0).getAuthor().getName(), is(any(String.class)));
    }

    @Test
    public void verifyAuthorOfPostedAnswerUsingAssertThat3() throws Exception{
        assertThat(user2.getAnswers().get(0).getAuthor().getName(), comparesEqualTo("JaneDoe"));
    }

    @Test
    public void verifyAuthorOfPostedAnswerUsingAssertThat4() throws Exception{
        assertThat(user2.getAnswers().get(0).getAuthor().getName(), startsWith("Jane"));
    }

    @Test
    public void verifyAuthorOfPostedAnswerUsingAssertThat5() throws Exception{
        assertThat(user2.getAnswers().get(0).getAuthor().getName(), endsWith("Doe"));
    }

    @Test
    public void verifyAuthorOfPostedAnswerUsingAssertThat6() throws Exception{
        assertThat(user2.getAnswers().get(0).getAuthor().getName(), containsString("ane"));
    }

    @Test
    public void verifyAuthorOfPostedAnswerUsingAssertThat7() throws Exception{
        assertThat(user2.getAnswers().get(0).getAuthor().getName(), equalToIgnoringCase("janedoe"));
    }

    @Test
    public void verifyAuthorOfPostedAnswerUsingAssertThat8() throws Exception{
        assertThat(user2.getAnswers().get(0).getAuthor().getName(),
                allOf(startsWith("Ja"), containsString("ne"),
                        endsWith("Doe")));
    }

    @Test
    public void verifyAuthorOfPostedAnswerUsingAssertThat9() throws Exception{
        List<Matcher<? super String>> matchers =
                Arrays.asList(startsWith("Ja"),
                        containsString("ne"), endsWith("Doe"));
        assertThat(user2.getAnswers().get(0).getAuthor().getName(),
                allOf(matchers));
    }

    @Test
    public void verifyAuthorOfPostedAnswerUsingAssertThat10() throws Exception{
        assertThat(user2.getAnswers().get(0).getAuthor().getName(),
                both(startsWith("Ja")).and(endsWith("Doe")));
    }

    @Test
    public void verifyAuthorObjectOfPostedAnswerIsTypeCompatible() throws Exception{
        assertThat(user2.getAnswers().get(0).getAuthor().getName().getClass(),
                typeCompatibleWith(String.class));
    }

    @Test
    public void verifyAskQuestionMethodReturnsNonNullObject() throws Exception {
        assertNotNull(user1.askQuestion("Who is the main creator of Java ?"));
    }

    @Test
    public void verifyAskQuestionMethodReturnsNonNullObject2() throws Exception{
        assertThat(user1.askQuestion("Who is the main creator of Java?"), is(not(equalTo(null))));
    }

    @Test
    public void verifyAskQuestionMethodReturnsNonNullObject3() throws Exception{
        assertThat(user1.askQuestion("Who is the main creator of Java?"), notNullValue());
    }

    @Test
    public void verifyAskQuestionMethodReturnsNonNullObject4() throws Exception{
        assertThat(user1.askQuestion("Who is the main creator of Java?"), notNullValue(Question.class));
    }

    @Test
    public void verifyAskQuestionMethodReturnsTypeCompatibleObject() throws Exception{
        assertThat(user1.askQuestion("Who is the main creator of Java?").getClass(),
                typeCompatibleWith(Question.class));
    }

    @Test
    public void verifyAnswerQuestionMethodReturnsNonNullObject() throws Exception{
        Question q = user1.askQuestion("What is the latest version of Java ?");
        assertNotNull(user1.answerQuestion(q, "1.9"));
    }

    @Test
    public void verifyAnswerQuestionMethodReturnsNonNullObject2() throws Exception{
        Question q = user1.askQuestion("What is the latest version of Java ?");
        assertThat(user2.answerQuestion(q, "1.9"), is(not(equalTo(null))));
    }

    @Test
    public void verifyAnswerQuestionMethodReturnsNonNullObject3() throws Exception{
        Question q = user1.askQuestion("What is the latest version of Java ?");
        assertThat(user2.answerQuestion(q, "1.9"), notNullValue());
    }

    @Test
    public void verifyAnswerQuestionMethodReturnsNonNullObject4() throws Exception{
        Question q = user1.askQuestion("What is the latest version of Java ?");
        assertThat(user2.answerQuestion(q, "1.9"), notNullValue(Answer.class));
    }

    @Test
    public void verifyQuestionsAnswers() throws Exception{
        assertSame(answer, question.getAnswers().get(0));
    }

    @Test
    public void verifyQuestionsAnswers2() throws Exception{
        assertThat(answer, sameInstance(question.getAnswers().get(0)));
    }

    @Test
    public void verifyQuestionsAnswers3() throws Exception{
        assertThat(answer, theInstance(question.getAnswers().get(0)));
    }

    @Test
    public void verifyAnswersQuestions() throws Exception{
        assertSame(question, answer.getQuestion());
    }

    @Test
    public void verifyAnswersQuestions2() throws Exception{
        assertThat(question, sameInstance(answer.getQuestion()));
    }

    @Test
    public void verifyAnswersQuestions3() throws Exception{
        assertThat(question, theInstance(answer.getQuestion()));
    }

    @Test
    public void verifyQuestionerQuestion() throws Exception{
        assertSame(question, user1.getQuestions().get(0));
    }

    @Test
    public void verifyQuestionerQuestion2() throws Exception{
        assertThat(question, sameInstance(user1.getQuestions().get(0)));
    }

    @Test
    public void verifyQuestionerQuestion3() throws Exception{
        assertThat(question, theInstance(user1.getQuestions().get(0)));
    }

    @Test
    public void verifyAnswererAnswer() throws Exception{
        assertSame(answer, user2.getAnswers().get(0));
    }

    @Test
    public void verifyAnswererAnswer2() throws Exception{
        assertThat(answer, sameInstance(user2.getAnswers().get(0)));
    }

    @Test
    public void verifyAnswererAnswer3() throws Exception{
        assertThat(answer, theInstance(user2.getAnswers().get(0)));
    }

    @Test
    public void verifyBoardQuestioner() throws Exception{
        assertSame(user1, board.getUsers().get(0));
    }

    @Test
    public void verifyBoardQuestioner2() throws Exception{
        assertThat(user1, sameInstance(board.getUsers().get(0)));
    }

    @Test
    public void verifyBoardQuestioner3() throws Exception{
        assertThat(user1, theInstance(board.getUsers().get(0)));
    }

    @Test
    public void verifyBoardAnswerer() throws Exception{
        assertSame(user2, board.getUsers().get(1));
    }

    @Test
    public void verifyBoardAnswerer2() throws Exception{
        assertThat(user2, sameInstance(board.getUsers().get(1)));
    }

    @Test
    public void verifyBoardAnswerer3() throws Exception{
        assertThat(user2, theInstance(board.getUsers().get(1)));
    }

    @Test
    public void verifyAcceptAnswerMethodMarksAnswerAsAnswered() throws Exception{
        user1.acceptAnswer(answer);
        assertTrue(answer.isAccepted());
    }

    @Test
    public void verifyUpvoteMethodReturnsTrueIfQuestionerUpvotesAnswer()  throws Exception{
        assertTrue(user1.upVote(answer));
    }

    @Test
    public void verifyDownvoteMethodReturnsTrueIfQuestionerDownvotesAnswer() throws Exception{
        assertTrue(user1.downVote(answer));
    }

    @Test
    public void verifyUpvoteMethodReturnsTrueIfAnswererUpvotesQuestion() throws Exception{
        assertTrue(user2.upVote(question));
    }

    @Test
    public void verifyDownvoteMethodReturnsTrueIfAnswererDownvotesQuestion() throws Exception{
        assertTrue(user2.downVote(question));
    }

    @Test
    public void upvotingOwnPostThrowsException() throws Exception {
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself!");

        user1.upVote(question);
    }

    @Test
    public void downvotingOwnPostThrowsException() throws Exception {
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself!");

        user1.downVote(question);
    }

    @Test
    public void upvotingOwnAnswerThrowsException() throws Exception{
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself");

        user2.upVote(answer);
    }

    @Test
    public void downvotingOwnAnswerThrowsException() throws Exception{
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself!");

        user2.downVote(answer);
    }

    @Test
    public void acceptingAnswerAsNonQuestioneerUserThrowsException() throws Exception {
        thrown.expect(AnswerAcceptanceException.class);
        thrown.expectMessage("Only JohnDoe can accept this answer as it is their question");

        user2.acceptAnswer(answer);
    }

    @Test
    public void verifyQuestionerUserQuestionListSizeWithAssertThat() throws Exception{
        assertThat(user1.getQuestions(), hasSize(1));
    }

    @Test
    public void verifyQuestionerUserQuestionListElementWithAssertThat() throws Exception{
        assertThat(user1.getQuestions(), hasItem(question));
    }

    @Test
    public void verifyQuestionerUserQuestionListElementWithAssertThat2() throws Exception{
        assertThat(user1.getQuestions(), contains(question));
    }

    @Test
    public void verifyQuestionerUserQuestionListElementWithAssertThat3() throws Exception{
        assertThat(question, isIn(user1.getQuestions()));
    }

    @Test
    public void verifyQuestionerUserQuestionListElementWithAssertThat4() throws Exception{
        assertThat(user1.getQuestions(), iterableWithSize(1));
    }

    @Test
    public void verifyQuestionerUserAnswerListSizeWithAssertThat() throws Exception{
        assertThat(user1.getAnswers(), hasSize(0));
    }

    @Test
    public void verifyQuestionerUserAnswerListSizeWithAssertThat2() throws Exception{
        assertThat(user1.getAnswers(), is(empty()));
    }

    @Test
    public void verifyQuestionerUserAnswerListSizeWithAssertThat3() throws Exception{
        assertThat(user1.getAnswers(), is(emptyCollectionOf(Answer.class)));
    }

    @Test
    public void verifyQuestionerUserAnswerListSizeWithAsserThat4() throws Exception{
        assertThat(user1.getAnswers(), is(emptyIterable()));
    }

    @Test
    public void verifyQuestionerUserAnswerListSizeWithAssertThat5() throws Exception{
        assertThat(user1.getAnswers(), is(emptyIterableOf(Answer.class)));
    }

    @Test
    public void verifyQuestionerUserAnswerListSizeWithAssertThat6() throws Exception{
        assertThat(user1.getAnswers(), iterableWithSize(0));
    }

    @Test
    public void verifyAnswererUserQuestionListSizeWithAssertThat() throws Exception{
        assertThat(user2.getQuestions(), hasSize(0));
    }

    @Test
    public void verifyAnswererUserQuestionListSizeWithAssertThat2() throws Exception{
        assertThat(user2.getQuestions(), is(empty()));
    }

    @Test
    public void verifyAnswererUserQuestionListSizeWithAssertThat3() throws Exception{
        assertThat(user2.getQuestions(), is(emptyCollectionOf(Question.class)));
    }

    @Test
    public void verifyAnswererUserQuestionListSizeWithAssertThat4() throws Exception{
        assertThat(user2.getQuestions(), is(emptyIterable()));
    }

    @Test
    public void verifyAnswererUserQuestionListSizeWithAssertThat5() throws Exception{
        assertThat(user2.getQuestions(), is(emptyIterableOf(Question.class)));
    }

    @Test
    public void verifyAnswererUserQuestionListSizeWithAssertThat6() throws Exception{
        assertThat(user2.getQuestions(), iterableWithSize(0));
    }

    @Test
    public void verifyAnswererUserAnswerListSizeWithAssertThat() throws Exception{
        assertThat(user2.getAnswers(), hasSize(1));
    }

    @Test
    public void verifyAnswererUserAnswerListElementWithAssertThat() throws Exception{
        assertThat(user2.getAnswers(), hasItem(answer));
    }

    @Test
    public void verifyAnswererUserAnswerListElementWithAssertThat2() throws Exception{
        assertThat(user2.getAnswers(), contains(answer));
    }

    @Test
    public void verifyAnswererUserAnswerListElementWithAssertThat3() throws Exception{
        assertThat(answer, isIn(user2.getAnswers()));
    }

    @Test
    public void verifyAnswererUserAnswerListElementWithAssertThat4() throws Exception{
        assertThat(user2.getAnswers(), iterableWithSize(1));
    }

    @Test
    public void verifyBoardQuestionListSizeWithAssertThat() throws Exception{
        assertThat(board.getQuestions(), hasSize(1));
    }

    @Test
    public void verifyBoardQuestionListElementWithAssertThat() throws Exception{
        assertThat(board.getQuestions(), hasItem(question));
    }

    @Test
    public void verifyBoardQuestionListElementWithAssertThat2() throws Exception{
        assertThat(board.getQuestions(), contains(question));
    }

    @Test
    public void verifyBoardQuestionListElementWithAssertThat3() throws Exception{
        assertThat(question, isIn(board.getQuestions()));
    }

    @Test
    public void verifyBoardQuestionListElementWithAssertThat4() throws Exception{
        assertThat(board.getQuestions(), iterableWithSize(1));
    }

    @Test
    public void verifyBoardAnswerListSizeWithAssertThat() throws Exception{
        assertThat(board.getAnswers(), hasSize(1));
    }

    @Test
    public void verifyBoardAnswerListElementWithAssertThat() throws Exception{
        assertThat(board.getAnswers(), hasItem(answer));
    }

    @Test
    public void verifyBoardAnswerListElementWithAssertThat2() throws Exception{
        assertThat(board.getAnswers(), contains(answer));
    }

    @Test
    public void verifyBoardAnswerListElementWithAssertThat3() throws Exception{
        assertThat(answer, isIn(board.getAnswers()));
    }

    @Test
    public void verifyBoardAnswerListElementWithAssertThat4() throws Exception{
        assertThat(board.getAnswers(), iterableWithSize(1));
    }

    @Test
    public void verifyBoardUserListSizeWithAssertThat() throws Exception{
        assertThat(board.getUsers(), hasSize(2));
    }

    @Test
    public void verifyBoardUserListElementsWithAssertThat() throws Exception{
        assertThat(board.getUsers(), hasItems(user1, user2));
    }

    @Test
    public void verifyBoardUserListElementsWithAssertThat2() throws Exception{
        assertThat(board.getUsers(), contains(user1, user2));
    }

    @Test
    public void verifyBoardUserListElementWithAssertThat3() throws Exception{
        assertThat(board.getUsers(), containsInAnyOrder(user2, user1));
    }

    @Test
    public void verifyBoardUserListElementWithAssertThat4() throws Exception{
        assertThat(user1, isIn(board.getUsers()));
    }

    @Test
    public void verifyBoardUserListElementWithAssertThat5() throws Exception{
        assertThat(user2, isIn(board.getUsers()));
    }

    @Test
    public void verifyBoardUserListElementWithAssertThat6() throws Exception{
        assertThat(board.getUsers(), iterableWithSize(2));
    }

    @Test
    public void verifyQuestionListSizeWithAssertThat() throws Exception{
        assertThat(question.getAnswers(), hasSize(1));
    }

    @Test
    public void verifyQuestionListElementWithAssertThat() throws Exception{
        assertThat(question.getAnswers(), hasItem(answer));
    }

    @Test
    public void verifyQuestionListElementWithAssertThat2() throws Exception{
        assertThat(question.getAnswers(), contains(answer));
    }

    @Test
    public void verifyQuestionListElementWithAssertThat3() throws Exception{
        assertThat(answer, isIn(question.getAnswers()));
    }

    @Test
    public void verifyQuestionListElementWithAssertThat4() throws Exception{
        assertThat(question.getAnswers(), iterableWithSize(1));
    }
}