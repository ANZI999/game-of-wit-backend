package com.myproduction.gameofwit.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.myproduction.gameofwit.model.Challenge;
import com.myproduction.gameofwit.model.ChallengePart;
import com.myproduction.gameofwit.model.Submission;
import com.myproduction.gameofwit.repository.ChallengeService;
import com.myproduction.gameofwit.repository.SubmissionService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SubmissionController.class)
public class SubmissionControllerTest {
	private static final Long USER_ID = 23L;
	private static final Long CHALLENGE_ID = 12L;
	
	@MockBean
	ChallengeService challengeService;
	
	@MockBean
	SubmissionService submissionService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void createHappyPath() throws Exception {	
		when(challengeService.findById(Mockito.anyLong(), Mockito.anyBoolean()))
				.thenReturn(generateSpyChallenge());
		
		mockMvc.perform(post("/submission/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(generateValidSubmission())).andExpect(status().isOk());
		
		ArgumentCaptor<Submission> submissionCaptor = ArgumentCaptor.forClass(Submission.class);
		verify(submissionService, times(1)).save(submissionCaptor.capture());
		Submission submission = submissionCaptor.getValue();
		assertEquals(CHALLENGE_ID, submission.getChallengeId());
		assertEquals(USER_ID, submission.getUserId());
	}

	@Test
	public void createIllegal() throws Exception {
		when(challengeService.findById(Mockito.anyLong(), Mockito.anyBoolean()))
				.thenReturn(generateSpyChallenge());
		
		mockMvc.perform(post("/submission/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(generateInvalidSubmission())).andExpect(status().isOk());
		
		verify(submissionService, never()).save(Mockito.any(Submission.class));	
	}
	
	private String generateValidSubmission() throws JSONException {
		return new JSONObject()
				.put("userId", USER_ID)
				.put("challengeId", CHALLENGE_ID)
				.put("parts", new JSONArray().put("12345"))
				.toString();
	}
	
	private String generateInvalidSubmission() throws JSONException {
		return new JSONObject()
				.put("userId", USER_ID)
				.put("challengeId", CHALLENGE_ID)
				.put("parts", new JSONArray().put("123456"))
				.toString();
	}
	
	private Challenge generateSpyChallenge() {
		Challenge challenge = new Challenge();
		challenge.setId(CHALLENGE_ID);

		List<ChallengePart> parts = new ArrayList<ChallengePart>();
		
		ChallengePart challengePartConst = new ChallengePart();
		challengePartConst.setIsFillable(false);
		challengePartConst.setText("bla bla bla");
		parts.add(challengePartConst);
		
		ChallengePart challengePartEmpty = new ChallengePart();
		challengePartConst.setIsFillable(true);
		challengePartConst.setAllowedLength(5);
		parts.add(challengePartEmpty);
		challenge.setParts(parts);
		
		return Mockito.spy(challenge);
	}
}
