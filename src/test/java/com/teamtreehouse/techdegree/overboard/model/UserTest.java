package com.teamtreehouse.techdegree.overboard.model;


import com.teamtreehouse.techdegree.overboard.exc.AnswerAcceptanceException;
import com.teamtreehouse.techdegree.overboard.exc.VotingException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


/**
 * Created by narcis on 10/23/2016.
 */
public class UserTest {
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
    public void userReputationIncreasesByFiveIfQuestionUpvoted() throws Exception {
        user2.upVote(question);

        assertEquals(5, user1.getReputation());
    }

    @Test
    public void userReputationIncreasesByTenIfAnswerUpvoted() throws Exception{
        user1.upVote(answer);

        assertEquals(10, user2.getReputation());
    }

    @Test
    public void userReputationIsDecrementedIfAnswerDownvoted() throws Exception {
        user1.downVote(answer);

        assertEquals(-1, user2.getReputation());
    }

    @Test
    public void userReputationIncreasesByFifteenIfAnswerAccepted() throws Exception{
        user1.acceptAnswer(answer);

        assertEquals(15, user2.getReputation());
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
    public void acceptingAnswerAsNonQuestioneerUserThrowsException() throws Exception {
        thrown.expect(AnswerAcceptanceException.class);
        thrown.expectMessage("Only JohnDoe can accept this answer as it is their question");

        user2.acceptAnswer(answer);
    }

}