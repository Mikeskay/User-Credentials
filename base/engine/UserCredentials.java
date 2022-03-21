package usercredentials.base.engine;

import java.util.Scanner;
public class UserCredentials {

   protected String username;
   protected String password;

public UserCredentials (String username, String password){
    this.username = username;
    this.password = password;
}
  public String getUsername(){
      return username;
  }

  public String getPassword(){
      return password;
  }

  public void setUsername(String username){
      this.username = username;
  }

  public void setPassword(String password){
      this.password = password;
  }

  public Boolean validUsername(String name){

      return  name.equalsIgnoreCase(this.username);

  }

  public  Boolean validPassword(String pass){

      return  pass.equalsIgnoreCase(this.password);
  }

}
