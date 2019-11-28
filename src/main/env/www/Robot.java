package www;

import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import cartago.Artifact;
import cartago.OPERATION;

public class Robot extends Artifact {
	
    String accessToken;    
 
  @OPERATION
  void init(String token) {
	  	//log(token);
//	  	token = "opensesame";
	    this.accessToken = token;
  }
  
  @OPERATION
  void work() {
	  elbow(400);
	  wristAngle(250);
	  elbow(500);
	  wristAngle(480);
  }
  
  @OPERATION
  void right() {
	  	elbow(400);
	  	wristAngle(250);
	  	//gripper();
	  	//gripper(500);
	  	//gripper();
	  	wristAngle(480);
	  	elbow(600);
	  	//turn plate
	  	elbow(400);
	  	wristAngle(250);
	  	//gripper();
	  	//gripper(500);
	  	//gripper();
	  	wristAngle(480);
	  	elbow(600);  	
  }
  
  @OPERATION
  void maintain() {
	  elbow(600);
	  wristRotation(0);
	  wristRotation(1023);
	  wristRotation(0);
	  wristRotation(1023);
	 //sendMaintenanceEvent();
  }
  
  
 //possibility to make the blocks according to these attributes: 
  
  @OPERATION
  void gripperopen () {
	  gripper(500);
  }
  
  @OPERATION
  void gripperclose () {
	  gripper(0);
  }
  
  @OPERATION
  void elbowbend () {
	  elbow(500);
  }
 
  @OPERATION
  void elbowtransp () {
	  elbow(600);
  }
  
  @OPERATION
  void wristpick () {
	  wristAngle(200);
  }
  
  @OPERATION
  void wristtrans () {
	  wristAngle(400);
  }
  
  //etc. 
  
  
  private void waitS() {
	  try {
		TimeUnit.SECONDS.sleep(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	  
	  
	  
  }
  
  private void elbow(int angle) {
	  HttpPut request1 = new HttpPut("https://api.interactions.ics.unisg.ch/leubot/elbow");
	  try {
		  String payload1 = "{\n" + 
		  		"  \"token\": \"" + this.accessToken + "\",\n" + 
		  		"  \"value\": " + angle + "\n" + 
		  		"}";
          request1.setEntity(new StringEntity(payload1));
          HttpClient client = HttpClientBuilder.create().build();
          HttpResponse response = client.execute(request1); 
          log("Response[" + response.getStatusLine().getStatusCode() + "]");
          
      } catch (Exception e) {
          e.printStackTrace();
      }
	  waitS();
  }
  
  private void wristAngle(int angle) {
	  HttpPut request1 = new HttpPut("https://api.interactions.ics.unisg.ch/leubot/wrist/angle");
	  try {
		  String payload1 = "{\n" + 
		  		"  \"token\": \"" + this.accessToken + "\",\n" + 
		  		"  \"value\": " + angle + "\n" + 
		  		"}";
          request1.setEntity(new StringEntity(payload1));
          HttpClient client = HttpClientBuilder.create().build();
          HttpResponse response = client.execute(request1); 
          log("Response[" + response.getStatusLine().getStatusCode() + "]");
          
      } catch (Exception e) {
          e.printStackTrace();
      }
	  waitS();
  }
  
  private void wristRotation(int angle) {
	  HttpPut request1 = new HttpPut("https://api.interactions.ics.unisg.ch/leubot/wrist/rotation");
	  try {
		  String payload1 = "{\n" + 
		  		"  \"token\": \"" + this.accessToken + "\",\n" + 
		  		"  \"value\": " + angle + "\n" + 
		  		"}";
          request1.setEntity(new StringEntity(payload1));
          HttpClient client = HttpClientBuilder.create().build();
          HttpResponse response = client.execute(request1); 
          log("Response[" + response.getStatusLine().getStatusCode() + "]");
          
      } catch (Exception e) {
          e.printStackTrace();
      }
	  waitS();
  }
  
  private void gripper(int value) {
	  HttpPut request1 = new HttpPut("https://api.interactions.ics.unisg.ch/leubot/gripper");
	  try {
		  String payload1 = "{\n" + 
		  		"  \"token\": \"" + this.accessToken + "\",\n" + 
		  		"  \"value\": " + value + "\n" + 
		  		"}";
          request1.setEntity(new StringEntity(payload1));
          HttpClient client = HttpClientBuilder.create().build();
          HttpResponse response = client.execute(request1); 
          log("Response[" + response.getStatusLine().getStatusCode() + "]");
          
      } catch (Exception e) {
          e.printStackTrace();
      }
	  waitS();
  }
}
  