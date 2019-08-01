package com.schroeter.mlb.player;


import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.*;

import com.schroeter.mlb.configuration.AppConfig;
import com.schroeter.mlb.player.remoteMlbService.RemoteMlbService;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@WebAppConfiguration
public class RemoteMLBServiceIntegrationTests {
	
//	@Autowired
//	private RemoteMlbService remoteMlbService;
	
	//[UnitOfWork_StateUnderTest_ExpectedBehavior]
	@Test
	public void getTeamRoster_teamId121_shouldReturnTeam() {
		//given
		RemoteMlbService remoteMlbService = new RemoteMlbService();
		String teamId = "121";
		
		//when
		List<PlayerResource> playerResourceList = remoteMlbService.getTeamRoster("121");
		
		//then
//		assertThat(playerResourceList).isNotEmpty();
	}

}
