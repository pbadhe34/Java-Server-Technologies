package com.services; 

/*import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
 
import org.codehaus.jackson.annotate.JsonProperty;

 * To avoid Error on server side unknown field '$promise'
 * Add the following annotation at class level
 */

//@JsonIgnoreProperties(ignoreUnknown = true)

public class User
{
   private String userId; 
   
  public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getUserPass() {
	return userPass;
}

public void setUserPass(String userPass) {
	this.userPass = userPass;
}

public String getUserMail() {
	return userMail;
}

public void setUserMail(String userMail) {
	this.userMail = userMail;
}

private String userName;   
  public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

private String userPass;   
   private String userMail;
    

   /*@JsonCreator
  
   public User(@JsonProperty("userId") String  id,
		   @JsonProperty("userName") String name,
		   @JsonProperty("userPass") String pass,
		   @JsonProperty("userMail") String  mail)
		{
	   System.out.println("User json Constructor.."); 
        this.userId = id;
        this.userName= name;
        this.userPass = pass;
        this.userMail= mail;         
   } */
   
   public User()
   {
	   System.out.println("User default Constructor..");
   }   
    
   /*public String toString()
   {
      return "{userId:'" +userId+'\'' +
    		  ",userName:'" + userName + '\'' +
               ",userPass:'" + userPass + '\'' +
              ", userMail:'" + userMail + '\'' +              
              '}';
      }*/
}
